/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Department;
import model.Employee;

/**
 *
 * @author sonnt
 */
public class EmployeeDAO extends DBContext {
    public ArrayList<Employee> getEmpsByDeptID(int did,int id,int gender,String name,String fromm,String to)
    {   
        String sql="";
        ArrayList<Employee> emps = new ArrayList<>();
        try {
             sql = "SELECT e.id,e.name,e.dob,e.gender,e.did,d.name as dname "
                    + "FROM Employee_2 e INNER JOIN Department d ON e.did = d.id " ;
            if(did!=0|| id!=0 || gender!=2 || name!=null) sql+=" where ";
            if(did !=0)
                sql+="d.id = "+did+" ";
            if(did!=0 && id!=0)
                sql=sql+" and ";
            if(id!=0)
                sql+= " e.id= '"+id+"' ";
            if((did!=0||id!=0 )&& gender!=2)
                sql+= " and ";
            if(gender!= 2)
                sql+= " e.gender="+gender+" ";
            
            if((did!=0|| id!=0 || gender!=2) && name!=null)
                sql+=" and ";
            sql+= " e.name like '%"+name+"%' ";
            
              if((did!=0||id!=0 || gender!=2 ||name!=null)&& fromm!=null)
                sql+= " and ";
            sql+= " e.dob >='"+fromm+"' ";
            if(to!=""){
             if((did!=0||id!=0 || gender!=2 ||name!=null|| fromm!=null) && to!=null)
                sql+= " and ";
            sql+= " e.dob <='"+to+"' ";}
            PreparedStatement statement = connection.prepareStatement(sql);
//            if(did !=0)
//                statement.setInt(1, did);
//            
            ResultSet rs = statement.executeQuery();
            while(rs.next())
            {
                Employee e = new Employee();
                e.setId(rs.getInt("id"));
                e.setName(rs.getString("name"));
                e.setDob(rs.getDate("dob"));
                e.setGender(rs.getBoolean("gender"));
                
                Department d = new Department();
                d.setId(rs.getInt("did"));
                d.setName(rs.getString("dname"));
                
                e.setDept(d);
                emps.add(e);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return emps;
    }
      public String getstring(int did,int id,int gender,String name,String fromm,String to)
    {   
        String sql="";
        ArrayList<Employee> emps = new ArrayList<>();
        try {
             sql = "SELECT e.id,e.name,e.dob,e.gender,e.did,d.name as dname "
                    + "FROM Employee_1 e e INNER JOIN Department d ON e.did = d.id " ;
            if(did!=0|| id!=0 || gender!=2|| name!=null) sql+=" where ";
            if(did !=0)
                sql+="d.id = "+did+" ";
            if(did!=0 && id!=0)
                sql=sql+" and ";
            if(id!=0)
                sql+= " e.id= '"+id+"' ";
            
            if((did!=0||id!=0 )&& gender!=2)
                sql+= " and ";
            if(gender != 2)
                sql+= " e.gender="+gender+" ";
            
            if((did!=0||id!=0 || gender!=2) && name!=null)
                sql+=" and ";
            sql+= " e.name like '%"+name+"%' ";
            
            if((did!=0||id!=0 || gender!=2 ||name!=null)&& fromm!=null)
                sql+= " and ";
            sql+= " e.dob >='"+fromm+"' ";
            
             if((did!=0||id!=0 || gender!=2 ||name!=null|| fromm!=null) && to!=null)
                sql+= " and ";
            sql+= " e.dob <='"+to+"' ";
            PreparedStatement statement = connection.prepareStatement(sql);
//            if(did !=0)
//                statement.setInt(1, did);
//            
            ResultSet rs = statement.executeQuery();
            while(rs.next())
            {
                Employee e = new Employee();
                e.setId(rs.getInt("id"));
                e.setName(rs.getString("name"));
                e.setDob(rs.getDate("dob"));
                e.setGender(rs.getBoolean("gender"));
                
                Department d = new Department();
                d.setId(rs.getInt("did"));
                d.setName(rs.getString("dname"));
                
                e.setDept(d);
                emps.add(e);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sql;
    }
}
