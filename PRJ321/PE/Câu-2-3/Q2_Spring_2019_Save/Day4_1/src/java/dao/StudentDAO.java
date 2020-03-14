
package dao;

import context.DBContext;
import entity.Department;
import entity.Student;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hoan toan hanh phuc
 */
public class StudentDAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    public void insertStudent(Student s) throws SQLException{
        String query = "insert into Students(sname,sdob,sgender,did) values(?,?,?,?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, s.getName());
            ps.setDate(2, java.sql.Date.valueOf(s.getDob()));
            ps.setInt(3, s.getGender());
            ps.setInt(4, s.getDepartmentid());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            conn.close();
            ps.close();
        }
    }

}
