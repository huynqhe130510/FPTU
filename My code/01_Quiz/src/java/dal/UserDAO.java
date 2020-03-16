/*
* UserDAO.java
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
import model.User;
import model.UserType;

/**
 * UserDAO.<br>
 *
 * <pre>
 * Class dùng các câu query để lấy dữ liệu từ database
 * Trong class này sẽ tiến hành các xử lí dưới đây.
 *
 * .getUser.
 * .getType.
 * .addUser.
 *
 * </pre>
 *
 * @author FU HuynqHE130510
 * @version 1.0
 */
public class UserDAO extends DBContext {

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
    public UserDAO() {
        db = new DBContext();
        conn = null;
        statement = null;
        rs = null;
    }

    /**
     * getUser. method.
     * Lấy ra thông tin của người dùng để so sánh với dữ liệu mà người dùng nhập
     * để thực hiện việc đăng nhập vào trong hệ thống.
     * Khi thực hiện xong thì đóng kết nối.
     * @param username
     * @param password
     * @return
     * @throws SQLException 
     */
    public User getUser(String username, String password) throws SQLException {
        User u = new User();
        try {
            String sql = "select u.id,u.username,u.[password],u.email,t.id as tid,t.name as tname \n"
                    + "from [user] u ,usertype t\n"
                    + "where u.typeid = t.id\n"
                    + "	and u.username = ?\n"
                    + "	and u.[password] = ?";
            conn = db.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            rs = statement.executeQuery();
            while (rs.next()) {
                u.setId(rs.getInt("id"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setEmail(rs.getString("email"));

                UserType t = new UserType();
                t.setId(rs.getInt("tid"));
                t.setName(rs.getString("tname"));

                u.setType(t);
            }
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeConnection(rs, statement, conn);
        }
        return u;
    }

    /**
     * getType. method.
     * Lấy ra list các loại người dùng (teacher, student) có trong database.
     * Khi thực hiện xong thì đóng kết nối.
     * @return
     * @throws SQLException 
     */
    public List<UserType> getType() throws SQLException {
        List<UserType> types = new ArrayList<>();
        try {
            String sql = "select * from usertype";
            conn = db.getConnection();
            statement = conn.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                UserType t = new UserType();
                t.setId(rs.getInt("id"));
                t.setName(rs.getString("name"));

                types.add(t);
            }
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeConnection(rs, statement, conn);
        }
        return types;
    }

    /**
     * addUser. method.
     * Thực hiện việc thêm người dùng vào trong database qua các thông tin mà 
     * người dùng đã nhập vào.
     * Khi thực hiện xong đóng kết nối.
     * @param username
     * @param password
     * @param type
     * @param email
     * @throws SQLException 
     */
    public void addUser(String username, String password, int type, String email) throws SQLException {
        String sql = "INSERT INTO [user]\n"
                + "           ([username]\n"
                + "           ,[password]\n"
                + "           ,[typeid]\n"
                + "           ,[email])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)";
        try {
            conn = db.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            statement.setInt(3, type);
            statement.setString(4, email);
            statement.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeConnection(rs, statement, conn);
        }
    }
}
