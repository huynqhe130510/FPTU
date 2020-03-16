/*
* QuestionDAO.java
*
* All Right Reserved
* Copyright (c) 2020 FPT University
 */
package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Question;

/**
 * QuestionDAO.<br>
 *
 * <pre>
 * Class dùng các câu query để lấy dữ liệu từ database
 * Trong class này sẽ tiến hành các xử lí dưới đây.
 *
 * .getAllQuestions
 * .getQuestionById
 * .addQuestion
 * .totalQuestions
 * .totalQuestionsByTeacherId
 * .getQuestionsByTeacherId
 * .deleteQuestion
 * .updateQuestion
 *
 * </pre>
 *
 * @author FU HuynqHE130510
 * @version 1.0
 */
public class QuestionDAO extends DBContext {

    /**
     * gọi hàm DBContext
     */
    private final DBContext db;
    /**
     * khởi tạo connection
     */
    Connection conn = null;
    /**
     * khởi tạo prepareStatement
     */
    PreparedStatement statement = null;
    /**
     * khởi tạo resultSet
     */
    ResultSet rs = null;

    /**
     * Constructor khởi tạo
     */
    public QuestionDAO() {
        db = new DBContext();
        conn = null;
        statement = null;
        rs = null;
    }

    /**
     * getAllQuestions.method.<br>
     * Lấy tất cả thông tin của tất cả câu hỏi có trong<br>
     * database. Khi thực hiện xong thì đóng kết nối.
     *
     * @return
     * @throws SQLException
     */
    public List<Question> getAllQuestions() throws SQLException {
        List<Question> questions = new ArrayList<>();
        try {
            String sql = "select q.id, q.question, q.option_1, q.option_2, q.option_3, q.option_4, q.answer, q.created_date, q.teacher_id\n"
                    + "from [user] u, questions q\n"
                    + "where u.id = q.teacher_id";
            conn = db.getConnection();
            statement = conn.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                Question q = new Question();
                q.setId(rs.getInt("id"));
                q.setQuestion(rs.getString("question"));
                q.setO1(rs.getString("option_1"));
                q.setO2(rs.getString("option_2"));
                q.setO3(rs.getString("option_3"));
                q.setO4(rs.getString("option_4"));
                q.setAnswer(rs.getString("answer"));
                q.setCreatedDate(rs.getDate("created_date"));
                q.setTeacherId(rs.getInt("teacher_id"));

                questions.add(q);
            }
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeConnection(rs, statement, conn);
        }
        return questions;
    }

    /**
     * getQuestionById.method.
     * Lấy tất cả thông tin của câu hỏi có trong database<br>
     * thông qua id của câu hỏi. Khi thực hiện xong thì đóng kết nối.
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public Question getQuestionById(int id) throws SQLException {
        Question q = new Question();
        try {
            String sql = "select q.id, q.question, q.option_1, q.option_2, q.option_3, q.option_4, q.answer, q.created_date, q.teacher_id\n"
                    + "from [user] u, questions q\n"
                    + "where u.id = q.teacher_id\n"
                    + "and q.id = ?";
            conn = db.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            rs = statement.executeQuery();
            while (rs.next()) {
                q.setId(rs.getInt("id"));
                q.setQuestion(rs.getString("question"));
                q.setO1(rs.getString("option_1"));
                q.setO2(rs.getString("option_2"));
                q.setO3(rs.getString("option_3"));
                q.setO4(rs.getString("option_4"));
                q.setAnswer(rs.getString("answer"));
                q.setCreatedDate(rs.getDate("created_date"));
                q.setTeacherId(rs.getInt("teacher_id"));
            }
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeConnection(rs, statement, conn);
        }
        return q;
    }

    /**
     * addQuestion.method.
     * Thực hiện việc thêm câu hỏi vào trong database qua các thông tin mà người<br>
     * dùng nhập vào . <br>
     * Khi thực hiện xong đóng kết nối. 
     * @param question
     * @param opt1
     * @param opt2
     * @param opt3
     * @param opt4
     * @param answer
     * @param teacherId
     * @throws SQLException
     */
    public void addQuestion(String question, String opt1, String opt2, String opt3, String opt4, String[] answer, int teacherId) throws SQLException {
        String sql = "INSERT INTO [questions]\n"
                + "           ([question]\n"
                + "           ,[option_1]\n"
                + "           ,[option_2]\n"
                + "           ,[option_3]\n"
                + "           ,[option_4]\n"
                + "           ,[answer]\n"
                + "           ,[created_date]\n"
                + "           ,[teacher_id])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,(select GETDATE())\n"
                + "           , ?)";
        try {
            conn = db.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setString(1, question);
            statement.setString(2, opt1);
            statement.setString(3, opt2);
            statement.setString(4, opt3);
            statement.setString(5, opt4);
            statement.setString(6, answer[0] + "," + answer[answer.length - 1]);
            statement.setInt(7, teacherId);
            statement.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeConnection(rs, statement, conn);
        }
    }

    /**
     * totalQuestions. method.<br>
     * Lấy ra tổng số câu hỏi có trong database.<br>
     * Thực hiện xong đóng kết nối.
     * @return
     * @throws SQLException 
     */
    public int totalQuestions() throws SQLException {
        int total = 0;
        String sql = "select COUNT(id) as total from questions";
        try {
            conn = db.getConnection();
            statement = conn.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                total = rs.getInt("total");
            }
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeConnection(rs, statement, conn);
        }
        return total;
    }

    /**
     * totalQuestionsByTeacherId. method.<br>
     * Lấy ra tổng số câu hỏi thông qua id của teacher.<br>
     * Khi thực hiện xong đóng kết nối.
     * @param teacherId
     * @return
     * @throws SQLException 
     */
    public int totalQuestionsByTeacherId(int teacherId) throws SQLException {
        int total = 0;
        String sql = "select COUNT(id) as total \n"
                + "from questions\n"
                + "where teacher_id = ?";
        try {
            conn = db.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setInt(1, teacherId);
            rs = statement.executeQuery();
            while (rs.next()) {
                total = rs.getInt("total");
            }
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeConnection(rs, statement, conn);
        }
        return total;
    }

    /**
     * getQuestionsByTeacherId. method.<br>
     * Lấy ra list các câu hỏi theo id của teacher.<br>
     * Khi thực hiện xong đóng kết nối.
     * @param teacherId
     * @return
     * @throws SQLException 
     */
    public List<Question> getQuestionsByTeacherId(int teacherId) throws SQLException {
        List<Question> questions = new ArrayList<>();
        try {
            String sql = "select q.id, q.question, q.option_1, q.option_2, q.option_3, q.option_4, q.answer, q.created_date, q.teacher_id\n"
                    + "from [user] u, questions q\n"
                    + "where u.id = q.teacher_id\n"
                    + "	and q.teacher_id = ?";
            conn = db.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setInt(1, teacherId);
            rs = statement.executeQuery();
            while (rs.next()) {
                Question q = new Question();
                q.setId(rs.getInt("id"));
                q.setQuestion(rs.getString("question"));
                q.setO1(rs.getString("option_1"));
                q.setO2(rs.getString("option_2"));
                q.setO3(rs.getString("option_3"));
                q.setO4(rs.getString("option_4"));
                q.setAnswer(rs.getString("answer"));
                q.setCreatedDate(rs.getDate("created_date"));
                q.setTeacherId(rs.getInt("teacher_id"));

                questions.add(q);
            }
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeConnection(rs, statement, conn);
        }
        return questions;
    }

    /**
     * deleteQuestion. method.<br>
     * Thực hiện việc xóa câu hỏi ra khỏi database thông qua id của câu hỏi.<br>
     * Khi thực hiện xong đóng kết nối.
     * @param id
     * @throws SQLException 
     */
    public void deleteQuestion(int id) throws SQLException {
        try {
            String sql = "DELETE FROM [questions]\n"
                    + "      WHERE id = ?";
            conn = db.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeConnection(rs, statement, conn);
        }
    }

    /**
     * updateQuestion. method.<br>
     * Thực hiện việc upadate câu hỏi thông qua id của câu hỏi và dữ liệu mà <br>
     * người dùng nhập vào.<br>
     * Khi thực hiện xong đóng kết nối.
     * @param id
     * @param question
     * @param opt1
     * @param opt2
     * @param opt3
     * @param opt4
     * @param answer
     * @param teacherId
     * @throws SQLException 
     */
    public void updateQuestion(int id, String question, String opt1, String opt2, String opt3, String opt4, String answer[], int teacherId) throws SQLException {
        String sql = "UPDATE [questions]\n"
                + "   SET [question] = ?\n"
                + "      ,[option_1] = ?\n"
                + "      ,[option_2] = ?\n"
                + "      ,[option_3] = ?\n"
                + "      ,[option_4] = ?\n"
                + "      ,[answer] = ?\n"
                + "      ,[created_date] = (select GETDATE())\n"
                + "      ,[teacher_id] = ?\n"
                + " WHERE id = ?";
        try {
            conn = db.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setString(1, question);
            statement.setString(2, opt1);
            statement.setString(3, opt2);
            statement.setString(4, opt3);
            statement.setString(5, opt4);
            if (answer.length <= 1) {
                statement.setString(6, answer[0]);
            } else {
                statement.setString(6, answer[0] + "," + answer[answer.length - 1]);
            }
            statement.setInt(7, teacherId);
            statement.setInt(8, id);
            statement.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeConnection(rs, statement, conn);
        }
    }
}
