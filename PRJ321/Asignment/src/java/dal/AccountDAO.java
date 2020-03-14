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
import model.Account;

/**
 *
 * @author huyNguyen
 */
public class AccountDAO extends DBContext {

    public Account getAccountByUsernameAndPassword(String username, String password) {

        try {
            String sql = "Select * from Account";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Account account = new Account();
                if (username.equals(rs.getString("user")) && password.equals(rs.getString("password"))) {
                    account.setUsername(username);
                    account.setPassword(password);
                    return account;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
