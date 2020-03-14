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
    public ArrayList<Classes> getClasses()
    {
        ArrayList<Classes> classes = new ArrayList<>();
        try {
            String sql = "SELECT id,name FROM Class";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while(rs.next())
            {
                Classes c = new Classes();
                c.setId(rs.getInt("id"));
                c.setName(rs.getString("name"));
                classes.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClassDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return classes;
    }
}
