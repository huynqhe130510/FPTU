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
    public ArrayList<Employee> getEmployeesByDeptID(int did)
    {
        ArrayList<Employee> emps = new ArrayList<>();
        try {
            String sql = "SELECT e.id,e.name,e.dob,e.gender,e.did,d.name as dname "
                    + "FROM Employee_1 e INNER JOIN Department d ON e.did = d.id";
            if(did != -1)
            {
                sql += " WHERE d.id = ?";
            }
            PreparedStatement statement = connection.prepareStatement(sql);
            if(did != -1)
            {
                statement.setInt(1, did);
            }
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
            Logger.getLogger(DepartmentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return emps;
    }
}
