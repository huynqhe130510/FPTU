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
import model.Student;

/**
 *
 * @author Asus
 */
public class StudentDAO extends DBContext{
    public Student getStd(int id) {
        Student s = new Student();
        try {
            String sql = "SELECT e.id,e.name,e.dob,e.gender,e.did,d.name as dname "
                    + "FROM Student_1 e INNER JOIN Department d ON e.did = d.id "
                    + "where e.id = " + id;
            
            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setDob(rs.getDate("dob"));
                s.setGender(rs.getBoolean("gender"));

                Classes c = new Classes();
                c.setId(rs.getInt("did"));
                c.setName(rs.getString("dname"));

                s.setDept(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }

    public void updateStd(String id, String name, String dob, int gender, int did) {
        try {
            String sql = "update Student_1\n"
                    + "set name = ?, "
                    + "dob = ?, "
                    + "gender = ?, "
                    + "did = ? \n"
                    + "where id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, dob);
            statement.setInt(3, gender);
            statement.setInt(4, did);
            statement.setString(5, id);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
