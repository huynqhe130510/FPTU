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
import model.Classes;

/**
 *
 * @author sonnt
 */
public class ClassDAO extends DBContext {
    public ArrayList<Classes> getDepts()
    {
        ArrayList<Classes> depts = new ArrayList<>();
        try {
            String sql = "SELECT id,name FROM Class";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while(rs.next())
            {
                Classes d = new Classes();
                d.setId(rs.getInt("id"));
                d.setName(rs.getString("name"));
                depts.add(d);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClassDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return depts;
    }
}
