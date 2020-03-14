package Q3;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Nguyen Thai Bao
 */
public class PMDAO {
    
    public ArrayList<ProjectMember> selectAllPM() {
        ArrayList<ProjectMember> members = new ArrayList<>();
        try {
            Connection conn = new DBContext().getConnection();
            String query = " select * from ProjectMember";
            ResultSet rs = conn.prepareStatement(query).executeQuery();
            while(rs.next()) {
                int proID = rs.getInt("projectid");
                String emID = rs.getString("employeeid");
                boolean isFT = rs.getBoolean("isfulltime");
                int hour = rs.getInt("hours");
                members.add(new ProjectMember(proID, emID, isFT, hour));
            }
            rs.close();
            conn.close();
        } catch(Exception e) {
            System.out.println(e);
        }
        
        return members;
    }
    
    public ArrayList<ProjectMember> selectByProID(int partID, boolean isFull) {
        ArrayList<ProjectMember> listPM = new ArrayList<>();
        try {
            Connection conn = new DBContext().getConnection();
            String query = "select * from ProjectMember where Projectid = ? and isfulltime = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, partID);
            ps.setBoolean(2, isFull);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int proID = rs.getInt("Projectid");
                String emID = rs.getString("employeeid");
                boolean isFulltime = rs.getBoolean("isfulltime");
                int hour = rs.getInt("hours");
                listPM.add(new ProjectMember(proID, emID, isFull, hour));
            }
            rs.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return listPM;
    }
    
    public ArrayList<ProjectMember> selectByEmpID(String partID, boolean isFull) {
        ArrayList<ProjectMember> listPM = new ArrayList<>();
        try {
            Connection conn = new DBContext().getConnection();
            String query = "select * from ProjectMember where Employeeid like ? and isfulltime = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, "%" + partID + "%");
            ps.setBoolean(2, isFull);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int proID = rs.getInt("Projectid");
                String emID = rs.getString("employeeid");
                boolean isFulltime = rs.getBoolean("isfulltime");
                int hour = rs.getInt("hours");
                listPM.add(new ProjectMember(proID, emID, isFull, hour));
            }
            rs.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return listPM;
    }
}
