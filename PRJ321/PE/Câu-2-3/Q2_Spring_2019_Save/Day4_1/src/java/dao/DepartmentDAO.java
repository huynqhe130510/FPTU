/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import entity.Department;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DepartmentDAO {
     Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    public List<Department> getDepartmentName() throws SQLException{
        List<Department> list = new ArrayList<>();
        String query = "select * from Departments";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                Department d = new Department(rs.getInt("did"),
                        rs.getString("dname"));
                list.add(d);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            conn.close();
            ps.close();
            rs.close();
        }
        return null;
    }
}
