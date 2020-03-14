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
import model.Message;

/**
 *
 * @author huyNguyen
 */
public class MessageDAO extends DBContext {

    public ArrayList<Message> getMessages(String id) {
        ArrayList<Message> messages = new ArrayList<>();

        try {
            String sql = "SELECT [messageid]\n"
                    + "      ,[messagetitle]\n"
                    + "      ,[messagetime]\n"
                    + "      ,[from]\n"
                    + "      ,[to]\n"
                    + "      ,[messagecontent]\n"
                    + "      ,[isread]\n"
                    + "  FROM [PRJ321_SP19_B5].[dbo].[MessageTBL]\n"
                    + "  where [TO] = '" + id + "'";
            PreparedStatement statement = getConnection().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Message m = new Message();
                m.setId(rs.getInt("messageid"));
                m.setTitle(rs.getString("messagetitle"));
                m.setTime(rs.getString("messagetime"));
                m.setFrom(rs.getString("from"));
                m.setTo(rs.getString("to"));
                m.setContent(rs.getString("messagecontent"));
                m.setIsRead(rs.getBoolean("isread"));
                messages.add(m);
            }

        } catch (SQLException ex) {
            Logger.getLogger(MessageDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(MessageDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return messages;
    }

    public Message getMessage(int mid) {
        Message m = new Message();
        try {
            String sql = " SELECT [messageid]\n"
                    + "      ,[messagetitle]\n"
                    + "      ,[messagetime]\n"
                    + "      ,[from]\n"
                    + "      ,[to]\n"
                    + "      ,[messagecontent]\n"
                    + "      ,[isread]\n"
                    + "  FROM [PRJ321_SP19_B5].[dbo].[MessageTBL]\n"
                    + "  where messageid = " + mid;
            PreparedStatement statement = getConnection().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                m.setId(rs.getInt("messageid"));
                m.setTitle(rs.getString("messagetitle"));
                m.setTime(rs.getString("messagetime"));
                m.setFrom(rs.getString("from"));
                m.setTo(rs.getString("to"));
                m.setContent(rs.getString("messagecontent"));
                m.setIsRead(rs.getBoolean("isread"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(MessageDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(MessageDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return m;
    }

    public void updateIsRead(int mid) {
        try {
            String sql = "UPDATE [PRJ321_SP19_B5].[dbo].[MessageTBL]\n"
                    + "   SET [isread] = 1\n"
                    + " WHERE messageid = " + mid;
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MessageDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(MessageDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void createMessage(String messagetitle, String from, String to, String messagecontent) {
        try {
            String sql = "INSERT INTO [PRJ321_SP19_B5].[dbo].[MessageTBL]\n"
                    + "           ([messagetitle]\n"
                    + "           ,[messagetime]\n"
                    + "           ,[from]\n"
                    + "           ,[to]\n"
                    + "           ,[messagecontent]\n"
                    + "           ,[isread])\n"
                    + "     VALUES\n"
                    + "           ('" + messagetitle + "'\n"
                    + "           ,GETDATE()\n"
                    + "           ,'" + from + "'\n"
                    + "           ,'" + to + "'\n"
                    + "           ,'" + messagecontent + "'\n"
                    + "           ,0)";
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MessageDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(MessageDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
