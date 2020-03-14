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
import model.User;

/**
 *
 * @author huyNguyen
 */
public class DAO extends DBContext {

    public User getAccountByUsernameAndPassword(String username, String password) {

        try {
            String sql = "Select * from [User]";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                User user = new User();
                if (username.equals(rs.getString("username")) && password.equals(rs.getString("password"))) {
                    user.setUsername(username);
                    user.setPassword(password);
                    return user;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
