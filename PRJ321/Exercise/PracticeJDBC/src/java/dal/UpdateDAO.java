/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author huyNguyen
 */
public class UpdateDAO extends DBContext {
//    public void update(Employee employee)
//    {
//        try {
//            String sql = "UPDATE [Employee_1]\n" +
//                    "   SET \n" +
//                    "       [id] = ?\n" +
//                    "      ,[name] = ?\n" +
//                    "      ,[dob] = ?\n" +
//                    "      ,[gender] = ?\n" +
//                    " WHERE [id] = ?";
//            
//            PreparedStatement statement = connection.prepareStatement(sql);
//            statement.setInt(1, employee.getId());
//            statement.setString(2, employee.getName());
//            statement.setDate(3, employee.getDob());
//            statement.setBoolean(4, employee.isGender());
//            statement.setInt(5, employee.getId());
//            statement.executeUpdate();
//        } catch (SQLException ex) {
//            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }   
//    }

    public void update(String name, String id, String dob, int gender) {
        try {
            String sql = "UPDATE [Employee_1]\n"
                    + "   SET \n"
                    + "   [name] = ?\n"
                    + "   ,[dob] = ?\n"
                    + "   ,[gender] = ?\n"
                    + "   WHERE [id] = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, dob);
            statement.setInt(3, gender);
            statement.setString(4, id);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
