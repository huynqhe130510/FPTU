/*
* ContactDAO.java
*
* All Right Reserved
* Copyright (c) 2020 FPT University
 */
package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Contact;

/**
 * ContactDAO.<br>
 *
 * <pre>
 * Class dùng các câu query để lấy dữ liệu từ database
 * Trong class này sẽ tiến hành các xử lí dưới đây.
 *
 * .getContact
 *
 *
 * </pre>
 *
 * @author FU HuynqHE130510
 * @version 1.0
 */
public class ContactDAO {

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
    public ContactDAO() {
        db = new DBContext();
        conn = null;
        statement = null;
        rs = null;
    }

     /**
     * getContact.<br>
     * Lấy tất cả thông tin liên hệ từ database
     *
     * @return a Contact
     * @throws java.sql.SQLException
     */
    public Contact getContact() throws SQLException {
        Contact c = new Contact();
        try {
            String sql = "SELECT * FROM [Contact] WHERE id = (select MAX(id) from Contact)";
            conn = db.getConnection();
            statement = conn.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                c.setId(rs.getInt("id"));
                c.setAddress(rs.getString("address"));
                c.setCity(rs.getString("city"));
                c.setCountry(rs.getString("country"));
                c.setTel(rs.getString("tel"));
                c.setEmail(rs.getString("email"));
                c.setAbout_me(rs.getString("about_me"));
            }
        } catch (Exception ex) {
            Logger.getLogger(ContactDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeConnection(rs, statement, conn);
        }
        return c;
    }

}
