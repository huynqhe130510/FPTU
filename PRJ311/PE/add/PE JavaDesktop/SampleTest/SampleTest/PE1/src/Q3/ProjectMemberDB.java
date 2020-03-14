/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author dell
 */
public class ProjectMemberDB {
    
    private final DBContext db = new DBContext();
    private Connection con = null;
    
    public ArrayList<ProjectMember> getProjectMemberAll(){
        ArrayList<ProjectMember> list = new ArrayList<>();
        try{
            con = db.getConnection();
            String sql = "select * from ProjectMember";
            PreparedStatement ppsm = con.prepareStatement(sql);
            ResultSet rs = ppsm.executeQuery();
            while(rs.next()){
                ProjectMember p = new ProjectMember(rs.getInt(1),rs.getString(2),rs.getBoolean(3),rs.getInt(4));
                list.add(p);
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return list;
    }
    
    public void insert(ProjectMember p){
        try{
            con = db.getConnection();
            String sql ="insert into ProjectMember values(?,?,?,?)";
            PreparedStatement ppsm = con.prepareStatement(sql);
            ppsm.setInt(1,p.getpId());
            ppsm.setString(2,p.geteId());
            ppsm.setBoolean(3,p.getFulltime());
            ppsm.setInt(4,p.getHour());
            ppsm.executeUpdate();
            con.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void dele(String id){
        try{
            con = db.getConnection();
            String sql = "delete from ProjectMember where Employeeid=?";
            PreparedStatement psmt = con.prepareStatement(sql);
            psmt.setString(1, id);
            psmt.executeUpdate();
            con.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public ArrayList<ProjectMember> searchById(String id){
        ArrayList<ProjectMember> list = new ArrayList<>();
        try{
            con=db.getConnection();
            String sql = "select * from ProjectMember where [projectid]=?";
            PreparedStatement psmt = con.prepareStatement(sql);
            psmt.setString(1, id);
            ResultSet rs = psmt.executeQuery();
            while(rs.next()){
                list.add(new ProjectMember(rs.getInt(1), id,rs.getBoolean(3),rs.getInt(4)));
            }
            con.close();
        }catch(Exception e){
            System.out.println(e);
        }
        return list;
    }
    
    public ArrayList<ProjectMember> searchByEmp(String emp){
        ArrayList<ProjectMember> list = new ArrayList<>();
        try{
            con=db.getConnection();
            String sql = "select * from ProjectMember where [Employeeid] like '%'+?+'%'";
            PreparedStatement psmt = con.prepareStatement(sql);
            psmt.setString(1, emp);
            ResultSet rs = psmt.executeQuery();
            while(rs.next()){
                list.add(new ProjectMember(rs.getInt(1), rs.getString(2),rs.getBoolean(3),rs.getInt(4)));
            }
            con.close();
        }catch(Exception e){
            System.out.println(e);
        }
        return list;
    }
    
    public ArrayList<ProjectMember> displaySearch(int id){
        ArrayList<ProjectMember> list = new ArrayList<>();
        try{
            con =db.getConnection();
            String sql = "select * from ProjectMember where Projectid=?";
            PreparedStatement ppsm = con.prepareStatement(sql);
            ppsm.setInt(1, id);
            ResultSet rs = ppsm.executeQuery();
            while(rs.next()){
                list.add(new ProjectMember(rs.getInt(1),rs.getString(2),rs.getBoolean(3),rs.getInt(4)));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return list;
    }
    
    public ArrayList<ProjectMember> searchHours(int from,int to){
        ArrayList<ProjectMember> list = new ArrayList<>();
        try{
            con =db.getConnection();
            String sql = "select * from ProjectMember where hours>= ? AND hours <= ?";
            PreparedStatement ppsm = con.prepareStatement(sql);
            ppsm.setInt(1, from);
            ppsm.setInt(2, to);
            ResultSet rs = ppsm.executeQuery();
            while(rs.next()){
                list.add(new ProjectMember(rs.getInt(1),rs.getString(2),rs.getBoolean(3),rs.getInt(4)));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return list;
    }
    
    public ArrayList<ProjectMember> sortByID( ){
         ArrayList<ProjectMember> list = new ArrayList();
        try{
            con = db.getConnection();
            String sql = "select * from  ProjectMember order by [Employeeid]";
            PreparedStatement psmt = con.prepareStatement(sql);
//            psmt.setString(1, name);
//            psmt.executeUpdate();
            ResultSet rs = psmt.executeQuery();
           while(rs.next()) {
                ProjectMember c = new ProjectMember();
                c.setpId(rs.getInt(1));
                c.seteId(rs.getString(2));
                c.setFulltime(rs.getBoolean(3));
                c.setHour(rs.getInt(4));
                list.add(c);
            }
            con.close();
        }catch(SQLException se){
            System.out.println(se);
        }catch (Exception e){
            System.out.println(e);
        }
        return list;
    }
    
    public ArrayList<ProjectMember> sortByHour(){
        ArrayList<ProjectMember> list = new ArrayList<>();
         try{
            con = db.getConnection();
            String sql = "select * from  ProjectMember order by [hours]";
            PreparedStatement psmt = con.prepareStatement(sql);
//            psmt.setString(1, name);
//            psmt.executeUpdate();
            ResultSet rs = psmt.executeQuery();
           while(rs.next()) {
                ProjectMember c = new ProjectMember();
                c.setpId(rs.getInt(1));
                c.seteId(rs.getString(2));
                c.setFulltime(rs.getBoolean(3));
                c.setHour(rs.getInt(4));
                list.add(c);
            }
            con.close();
        }catch(SQLException se){
            System.out.println(se);
        }catch (Exception e){
            System.out.println(e);
        }
        return list;
    }
    
}
