/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;

/**
 *
 * @author huyNguyen
 */
public class DeleteDAO extends DBContext{
    public void deleteEmployee(int id){
        try {
            String sql = "delete from Employee_1 where id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
        }
    }
}
