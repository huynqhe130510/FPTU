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
public class AddDAO extends DBContext {

    public void AddContact(String firstName, String lastName, int groupID, String phoneNumber) {
        try {
            String sql = "INSERT INTO [ContactDB].[dbo].[Contact]\n"
                    + "           ([FirstName]\n"
                    + "           ,[LastName]\n"
                    + "           ,[CreatedDate]\n"
                    + "           ,[PhoneNumber]\n"
                    + "           ,[GroupID])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,GETDATE()\n"
                    + "           ,?\n"
                    + "           ,?)";
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, phoneNumber);
            statement.setInt(4, groupID);
            statement.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void AddGroup(String name, String des) {
        try {
            String sql = "INSERT INTO [ContactDB].[dbo].[FriendGroup]\n"
                    + "           ([Name]\n"
                    + "           ,[Description])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?)";
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, des);

            statement.executeUpdate();
        } catch (Exception e) {
        }
    }

}
