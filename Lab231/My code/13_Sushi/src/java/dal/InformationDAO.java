/*
* InfomationDao.java
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Information;

/**
 * InfomationDao.<br>
 *
 * <pre>
 *
 * Class dùng các câu query để lấy dữ liệu từ database
 * Trong class này sẽ tiến hành các xử lí dưới đây.
 *
 * . getInfor.
 * . getAddress
 * . getTel
 * . getMail
 *
 * </pre>
 *
 * @author FU HuynqHE130510
 * @version 1.0
 */
public class InformationDAO {

    /**
     * gọi hàm DBContext
     */
    DBContext db = null;
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
     * Constructor khởi tạo hàm DBContext
     */
    public InformationDAO() {
        db = new DBContext();
    }

    /**
     * getInfor <br>
     *
     * Lấy ra từ database thông tin về nhà hàng và thời gian mở của từ T2 đến CN
     * của nhà hàng. Sau khi thực hiện xong câu lệnh đóng kết nối.
     *
     * @return info
     * @throws SQLException
     */
    public Map<String, String> getInfor() throws SQLException {
        Map<String, String> map = new HashMap<>();

        try {
            String sql = "select * from Information";
            conn = db.getConnection();
            statement = conn.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                map.put(rs.getString("name"), rs.getString("content"));
            }
        } catch (Exception ex) {
            Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeConnection(rs, statement, conn);
        }
        return map;
    }
}
