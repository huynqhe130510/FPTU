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
import java.util.List;
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
     * Lấy ra từ database thời gian mở của từ T2 đến CN của nhà hàng
     *
     * @return info
     * @throws SQLException
     */
    public List<Information> getInfor() throws SQLException {
        List<Information> infor = new ArrayList<>();

        try {
            String sql = "select * from Information";
            conn = db.getConnection();
            statement = conn.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                Information inf = new Information();
                inf.setId(rs.getInt("id"));
                inf.setName(rs.getString("name"));
                inf.setContent(rs.getString("content"));

                infor.add(inf);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeConnection(rs, statement, conn);
        }
        return infor;
    }

    /**
     * getAddress <br>
     *
     * Lấy dữ liệu từ database thông tin về địa chỉ của nhà hàng
     *
     * @return address
     * @throws SQLException
     */
    public String getAddress() throws SQLException {
        List<Information> info = getInfor();
        return info.get(1).getContent();
    }

    /**
     * getTel <br>
     *
     * Lấy dữ liệu từ database thông tin về số điện thoại của nhà hàng
     *
     * @return tel
     * @throws SQLException
     */
    public String getTel() throws SQLException {
        List<Information> info = getInfor();
        return info.get(2).getContent();
    }

    /**
     * getMail <br>
     *
     * Lấy dữ liệu từ database thông tin về email của nhà hàng
     *
     * @return email
     * @throws SQLException
     */
    public String getMail() throws SQLException {
        List<Information> info = getInfor();
        return info.get(3).getContent();
    }

}
