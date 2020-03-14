/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Exam;
import model.Student;
import model.Subject;

/**
 *
 * @author huyNguyen
 */
public class DAO extends DBContext {

    public ArrayList<Exam> getExams() {
        ArrayList<Exam> exams = new ArrayList<>();

        try {
            String sql = "select * \n"
                    + "	from exam";

            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));

                Subject subject = new Subject();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));

                Exam exam = new Exam();
                exam.setScore(rs.getFloat("score"));
                exam.setStudent(student);
                exam.setSubject(subject);

                exams.add(exam);
            }
        } catch (Exception e) {
        }
        return exams;
    }

}
