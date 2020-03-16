/*
* ArticleDao.java
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
import model.Article;

/**
 * ArticleDao.<br>
 *
 * <pre>
 * 
 * Class dùng các câu query để lấy dữ liệu từ database
 * Trong class này sẽ tiến hành các xử lí dưới đây.
 * 
 * .getListArticle.
 * .countAllResult.
 *
 </pre>
 *
 * @author FU HuynqHE130510
 * @version 1.0
 */
public class ArticleDAO {

    /**
     * gọi hàm DBContext
     */
    private DBContext db = null;

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
    public ArticleDAO() {
        db = new DBContext();
    }

    /**
     * getListArticle.<br>
     * 
     * Lấy tất cả thông tin của các món Sushi trong database
     *
     * @param pageIndex
     * @param pageSize
     * @return a Articles
     * @throws java.sql.SQLException
     */
    public List<Article> getListArticle(int pageIndex, int pageSize) throws SQLException {
        List<Article> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM(SELECT *,ROW_NUMBER() OVER (ORDER BY ID ASC) as row_num FROM  Article) tblArticle WHERE row_num >= (? - 1)*? +1 AND row_num<= ? * ?";
            conn = db.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setInt(1, pageIndex);
            statement.setInt(2, pageSize);
            statement.setInt(3, pageIndex);
            statement.setInt(4, pageSize);
            rs = statement.executeQuery();

            while (rs.next()) {
                Article a = new Article();
                a.setId(rs.getInt("id"));
                a.setTitle(rs.getString("title"));
                a.setImgLink(rs.getString("imgLink"));
                a.setContent(rs.getString("shortContent"));
                a.setFullContent(rs.getString("fullContent"));

                list.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeConnection(rs, statement, conn);
        }
        return list;
    }

    /**
     * countAllResult. <br>
     * 
     * Đếm số bản ghi
     *
     * @return a number
     * @throws SQLException
     */
    public int countAllResult() throws SQLException {
        int count = 0;
        try {
            String sql = " SELECT COUNT(*) as [count] FROM Article";
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
