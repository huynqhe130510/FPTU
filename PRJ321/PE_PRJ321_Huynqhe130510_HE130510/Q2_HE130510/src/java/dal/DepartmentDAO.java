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

/**
 *
 * @author huyNguyen
 */
public class DepartmentDAO extends DBContext {

    public Department getDep() {
        Department d = new Department();
        try {
            String sql = "SELECT TOP 1000 [id]\n"
                    + "      ,[name]\n"
                    + "  FROM [PRJ321_FALL_2019].[dbo].[Department]";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                d.setId(rs.getInt("id"));
                d.setName(rs.getString("name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return d;
    }
}
