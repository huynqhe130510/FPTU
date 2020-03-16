/*
* MenuDAO.java
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
import model.Menu;

/**
 * MenuDAO.<br>
 *
 * <pre>
 * Class dùng các câu query để lấy tất cả các menu của các món sushi từ database
 * Trong class này sẽ tiến hành các xử lí dưới đây.
 *
 * . getMenu.
 *
 * </pre>
 *
 * @author FU HuynqHE130510
 * @version 1.0
 */
public class MenuDAO {

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
    public MenuDAO() {
        db = new DBContext();
    }

    /**
     * getInfor <br>
     *
     * Lấy ra từ database menu của các món Sushi tương ứng đong thời tiến hành việc
     * phân trang theo pageSize(tổng số bài viết trên 1 trang) và pageIndex(số 
     * trang hiện tại) thông qua câu lệnh sql.
     * Sau khi thực hiện xong câu lệnh đóng kết nối.
     *
     * @param pageIndex
     * @param pageSize
     * @return menu
     * @throws SQLException
     */
    public List<Menu> getMenu(int pageIndex, int pageSize) throws SQLException {
        List<Menu> menu = new ArrayList<>();

        try {
            String sql = "SELECT * FROM(SELECT *,ROW_NUMBER() OVER (ORDER BY ID ASC) as row_num FROM  Menu) tblMenu "
                    + "WHERE row_num >= (? - 1)*? +1 AND row_num<= ? * ?";
            conn = db.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setInt(1, pageIndex);
            statement.setInt(2, pageSize);
            statement.setInt(3, pageIndex);
            statement.setInt(4, pageSize);
            rs = statement.executeQuery();
            while (rs.next()) {
                Menu m = new Menu();
                m.setId(rs.getInt("id"));
                m.setName(rs.getString("name"));
                m.setContent(rs.getString("content"));
                m.setPrice(rs.getDouble("price"));

                menu.add(m);
            }
        }catch (Exception ex) {
            Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeConnection(rs, statement, conn);
        }
        return menu;
    }
    
    /**
     * countAllResult. <br>
     * 
     * Đếm số bản ghi của bằng Menu trong database để xử lí việc phân trang.
     * Sau khi thực hiện xong câu lệnh đóng kết nối.
     *
     * @return a number
     * @throws SQLException
     */
    public int countAllResult() throws SQLException {
        int count = 0;
        try {
            String sql = " SELECT COUNT(*) as [count] FROM Menu";
            conn = db.getConnection();
            statement = conn.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                count = rs.getInt("count");
            }
        } catch (Exception ex) {
            Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeConnection(rs, statement, conn);
        }
        return count;
    }
}
