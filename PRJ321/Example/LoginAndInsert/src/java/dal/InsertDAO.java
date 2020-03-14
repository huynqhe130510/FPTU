/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;

/**
 *
 * @author huyNguyen
 */
public class InsertDAO extends DBContext {

    public void InsertRequest(String from, String to, String reason, String username ) {
        try {
            String sql = "INSERT INTO [PRJ321].[dbo].[Request]\n"
                    + "           ([from]\n"
                    + "           ,[to]\n"
                    + "           ,[reason]\n"
                    + "           ,[username])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, from);
            statement.setString(2, to);
            statement.setString(3, reason);
            statement.setString(4, username);
            statement.executeUpdate();
        } catch (Exception e) {
        }
    }
}
