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
import model.Type;

/**
 *
 * @author huyNguyen
 */
public class TypeDAO extends DBContext {

    public ArrayList<Type> getTypes() {
        ArrayList<Type> types = new ArrayList<>();
        try {
            String sql = "select * from type";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Type t = new Type();
                t.setId(rs.getInt("id"));
                t.setName(rs.getString("name"));
                types.add(t);
            }
        } catch (SQLException e) {
        }
        return types;
    }
}
