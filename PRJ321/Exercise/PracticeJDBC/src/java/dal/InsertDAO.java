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
public class InsertDAO extends DBContext {

    public void InsertEmployee(int id, String name, String dob, int gender, int did) {
        try {
            String sql = "Insert into employee_1 (id, name, dob, gender, did)"
                    + " values (?, ? , ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.setString(2, name);
            statement.setString(3, dob);
            statement.setInt(4, gender);
            statement.setInt(5, did);
            statement.executeUpdate();
        } catch (Exception e) {
        }
    }
}
