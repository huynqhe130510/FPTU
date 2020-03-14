/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author huyNguyen
 */
public class InsertDAO extends DBContext {

    public void insertAccount(String id, String pass) {
        try {
            String sql
                    = "INSERT INTO [PRJ321_FALL_2019].[dbo].[Account]\n"
                    + "           ([accountid]\n"
                    + "           ,[password])\n"
                    + "     VALUES\n"
                    + "           ('" + id + "'\n"
                    + "           ,'" + pass + "')";
            PreparedStatement insertPreparedStatement
                    = connection.prepareStatement(sql);
            insertPreparedStatement.executeUpdate();

        } catch (SQLException sQLException) {
        }
    }

    public void insertAccountGroup(String aid, String[] gid) {
        try {
            String sql
                    = "INSERT INTO [PRJ321_FALL_2019].[dbo].[Account_Group]\n"
                    + "           ([groupid]\n"
                    + "           ,[accountid])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?)";

            for (int i = 0; i < gid.length; i++) {
                PreparedStatement statement
                        = connection.prepareStatement(sql);
                statement.setInt(1, Integer.parseInt(gid[i]));
                statement.setString(2, aid);
                statement.executeUpdate();
            }
        } catch (SQLException sQLException) {
        }
    }
}
