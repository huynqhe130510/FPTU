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
import model.Department;
import model.Student;

/**
 *
 * @author huyNguyen
 */
public class StudentDAO extends DBContext {

    public ArrayList<Student> getStds() {
        ArrayList<Student> list = new ArrayList<>();
        try {
            String sql = "select s.id, s.name, s.gender, s.dob,d.id as did, d.name as dname\n"
                    + "from student s, Department d\n"
                    + "where s.did = d.id ";

            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setDob(rs.getString("dob"));
                s.setGender(rs.getBoolean("gender"));

                Department d = new Department();
                d.setId(rs.getInt("did"));
                d.setName(rs.getString("dname"));

                s.setD(d);
                list.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
