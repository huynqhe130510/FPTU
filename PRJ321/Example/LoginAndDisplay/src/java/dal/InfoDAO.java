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
import model.Group;

/**
 *
 * @author huyNguyen
 */
public class InfoDAO extends DBContext {

    public ArrayList<Group> getGroupInfos(String username) {
        ArrayList<Group> groups = new ArrayList<>();
        try {
            String sql = "select g.id, g.name\n"
                    + "from [User] u ,User_Group ug, [Group] g\n"
                    + "where ug.gid = g.id\n"
                    + "	and u.username = ug.username\n"
                    + "	and u.username = '" + username + "'";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Group group = new Group();
                group.setId(rs.getInt("id"));
                group.setName(rs.getString("name"));
                groups.add(group);
            }
        } catch (SQLException ex) {
            Logger.getLogger(InfoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return groups;
    }
}
