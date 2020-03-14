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
import model.Group;

/**
 *
 * @author huyNguyen
 */
public class GroupDAO extends DBContext {

    public ArrayList<Group> getTypes() {
        ArrayList<Group> groups = new ArrayList<>();
        try {
            String sql = "SELECT TOP 1000 [groupid]\n"
                    + "      ,[name]\n"
                    + "  FROM [PRJ321_FALL_2019].[dbo].[Group]";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Group t = new Group();
                t.setId(rs.getInt("groupid"));
                t.setName(rs.getString("name"));
                groups.add(t);
            }
        } catch (SQLException e) {
        }
        return groups;
    }
}
