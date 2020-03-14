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
import model.Contact;
import model.Group;

/**
 *
 * @author huyNguyen
 */
public class ContactDAO extends DBContext {

    public ArrayList<Contact> getContact() {
        ArrayList<Contact> contacts = new ArrayList<>();
        try {
            String sql = "select c.ID, c.FirstName, c.LastName, f.Name , c.PhoneNumber\n"
                    + "from Contact c, FriendGroup f\n"
                    + "where c.GroupID = f.ID";

            PreparedStatement statement = getConnection().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Contact c = new Contact();
                c.setId(rs.getInt("id"));
                c.setFirstName(rs.getString("FirstName"));
                c.setLastName(rs.getString("LastName"));

                Group g = new Group();
                g.setName(rs.getString("name"));
                c.setGroup(g);

                c.setPhoneNumber(rs.getString("PhoneNumber"));
                contacts.add(c);
            }
        } catch (Exception ex) {
            Logger.getLogger(ContactDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return contacts;
    }

    public Contact getContact(int id) {
        Contact c = new Contact();
        try {
            String sql = "select c.ID, c.FirstName, c.LastName, c.PhoneNumber,c.GroupID as gid, f.Name as fname\n"
                    + "from Contact c, FriendGroup f\n"
                    + "where c.GroupID = f.ID\n"
                    + "	and c.ID = " + id;

            PreparedStatement statement = getConnection().prepareStatement(sql);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                c.setId(rs.getInt("id"));
                c.setFirstName(rs.getString("FirstName"));
                c.setLastName(rs.getString("LastName"));
                c.setPhoneNumber(rs.getString("PhoneNumber"));

                Group g = new Group();
                g.setId(rs.getInt("gid"));
                g.setName(rs.getString("fname"));

                c.setGroup(g);
            }
        } catch (Exception ex) {
            Logger.getLogger(ContactDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }

    public void updateContact(String FirstName, String LastName, String PhoneNumber, int gid, int id) {
        try {
            String sql = "UPDATE [ContactDB].[dbo].[Contact]\n"
                    + "   SET [FirstName] = ?\n"
                    + "      ,[LastName] = ?\n"
                    + "      ,[PhoneNumber] = ?\n"
                    + "      ,[GroupID] = ?\n"
                    + " WHERE ID = ?";
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setString(1, FirstName);
            statement.setString(2, LastName);
            statement.setString(3, PhoneNumber);
            statement.setInt(4, gid);
            statement.setInt(5, id);
            statement.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(ContactDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void removeContact(int id) {
        try {
            String sql = "DELETE FROM [ContactDB].[dbo].[Contact]\n"
                    + "      WHERE ID = ?";
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
        }
    }
}
