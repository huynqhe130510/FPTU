/*
* NewsDAO.java
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
import model.News;

/**
 * NewsDAO.<br>
 *
 * <pre>
 * Class dùng các câu query để lấy dữ liệu từ database
 * Trong class này sẽ tiến hành các xử lí dưới đây.
 *
 * .getNewsById
 * .getTop5LatestNews
 * .getLastestNews
 * .searchNewsByTitle
 * .countSearchResult
 *
 * </pre>
 *
 * @author FU HuynqHE130510
 * @version 1.0
 */
public class NewsDAO extends DBContext {

    /**
     * gọi hàm DBContext
     */
    private final DBContext db;
    /**
     * khởi tạo connection
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
    public NewsDAO() {
        db = new DBContext();
        conn = null;
        statement = null;
        rs = null;
    }

    /**
     * getNewsById.<br>
     * Lấy tất cả thông tin của các bài báo thông qua id từ database
     *
     * @param id
     * @return a News
     * @throws java.sql.SQLException
     */
    public News getNewsById(int id) throws SQLException {
        News news = new News();
        try {
            String sql = "SELECT * FROM [news] WHERE [id] = ?";
            conn = db.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            rs = statement.executeQuery();
            while (rs.next()) {
                news.setId(rs.getInt("id"));
                news.setTitle(rs.getString("title"));
                news.setContent(rs.getString("content"));
                news.setShort_content(rs.getString("short_content"));
                news.setWriter(rs.getString("writer"));
                news.setImage_link(rs.getString("image"));
                news.setDate_published(rs.getDate("date_published"));
            }
        } catch (Exception ex) {
            Logger.getLogger(NewsDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeConnection(rs, statement, conn);
        }
        return news;
    }

    /**
     * getTop5LatestNews.<br>
     * Lấy ra top5 bài báo mới nhất từ database
     *
     * @return list of News
     * @throws SQLException
     */
    public List<News> getTop5LatestNews() throws SQLException {
        List<News> newses = new ArrayList<>();
        try {
            String sql = "SELECT TOP 5 [id],[title],[content],[short_content],[writer],[date_published],[image] "
                    + "FROM [news] ORDER BY date_published DESC";
            conn = db.getConnection();
            statement = conn.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                News n = new News();
                n.setId(rs.getInt("id"));
                n.setTitle(rs.getString("title"));
                n.setContent(rs.getString("content"));
                n.setShort_content(rs.getString("short_content"));
                n.setWriter(rs.getString("writer"));
                n.setImage_link(rs.getString("image"));
                n.setDate_published(rs.getDate("date_published"));

                newses.add(n);
            }
        } catch (Exception ex) {
            Logger.getLogger(NewsDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeConnection(rs, statement, conn);
        }
        return newses;
    }

    /**
     * getLastestNews.<br>
     * Lấy ra bài báo mới nhất từ database
     *
     * @return a News
     * @throws SQLException
     */
    public News getLastestNews() throws SQLException {
        News news = new News();
        try {
            String sql = "SELECT TOP 1 [id],[title],[content],[short_content],[writer],[date_published],[image] "
                    + "FROM [news] ORDER BY date_published DESC";
            conn = db.getConnection();
            statement = conn.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                news.setId(rs.getInt("id"));
                news.setTitle(rs.getString("title"));
                news.setContent(rs.getString("content"));
                news.setShort_content(rs.getString("short_content"));
                news.setWriter(rs.getString("writer"));
                news.setImage_link(rs.getString("image"));
                news.setDate_published(rs.getDate("date_published"));
            }
        } catch (Exception ex) {
            Logger.getLogger(NewsDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeConnection(rs, statement, conn);
        }
        return news;
    }

    /**
     * searchNewsByTitle.<br>
     * Tìm kiếm bài báo thông qua tiêu đề bài báo
     *
     * @param title
     * @param pageIndex
     * @param pageSize
     * @return list of News
     * @throws SQLException
     */
    public List<News> searchNewsByTitle(String title, int pageIndex, int pageSize) throws SQLException {
        List<News> newses = new ArrayList<>();
        try {
            String sql = "SELECT * FROM (SELECT *,ROW_NUMBER() OVER (ORDER BY ID ASC) as row_num "
                    + " FROM  news  WHERE title like ?) tblNews "
                    + "WHERE row_num >= (? - 1)*? +1 AND row_num<= ? * ?";
            conn = db.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setString(1, "%" + title + "%");
            statement.setInt(2, pageIndex);
            statement.setInt(3, pageSize);
            statement.setInt(4, pageIndex);
            statement.setInt(5, pageSize);
            rs = statement.executeQuery();
            while (rs.next()) {
                News n = new News();
                n.setId(rs.getInt("id"));
                n.setTitle(rs.getString("title"));
                n.setContent(rs.getString("content"));
                n.setShort_content(rs.getString("short_content"));
                n.setWriter(rs.getString("writer"));
                n.setImage_link(rs.getString("image"));
                n.setDate_published(rs.getDate("date_published"));

                newses.add(n);
            }
        } catch (Exception ex) {
            Logger.getLogger(NewsDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeConnection(rs, statement, conn);
        }
        return newses;
    }

    /**
     * countSearchResult. <br>
     * Đếm số bản ghi sau khi search được theo title
     *
     * @param title
     * @return a number
     * @throws SQLException
     */
    public int countSearchResult(String title) throws SQLException {
        int count = 0;
        try {
            String sql = " SELECT COUNT(*) as [count] FROM News WHERE title LIKE ?";
            conn = db.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setString(1, "%" + title + "%");
            rs = statement.executeQuery();
            while (rs.next()) {
                count = rs.getInt("count");
            }
        } catch (Exception ex) {
            Logger.getLogger(NewsDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeConnection(rs, statement, conn);
        }
        return count;
    }
}
