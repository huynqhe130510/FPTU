/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
            String sql = "SELECT TOP 1000 [userid]\n"
                    + "      ,[password]\n"
                    + "  FROM [PRJ321_SP19_B5].[dbo].[UserTBL]";
            PreparedStatement statement = getConnection().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                User account = new User();
                if (username.equals(rs.getString("userid")) && password.equals(rs.getString("password"))) {
                    account.setId(username);
                    account.setPassword(password);
                    return account;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
