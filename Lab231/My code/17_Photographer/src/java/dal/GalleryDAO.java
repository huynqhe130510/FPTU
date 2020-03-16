/*
* GalleryDAO.java
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
import model.Gallery;

/**
 * GalleryDAO.<br>
 *
 * <pre>
 * Class dùng các câu query để lấy dữ liệu từ database
 * Trong class này sẽ tiến hành các xử lí dưới đây.
 *
 * .getGalleries.
 *
 *
 * </pre>
 *
 * @author FU HuynqHE130510
 * @version 1.0
 */
public class GalleryDAO {

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
    public GalleryDAO() {
        db = new DBContext();
        conn = null;
        statement = null;
        rs = null;
    }

    /**
     * getGalleries.<br>
     * 
     * Lất tất cả thuộc tính của từng Gallery từ database
     *
     * @return a list of Gallery
     * @throws java.sql.SQLException
     */
    public List<Gallery> getGalleries() throws SQLException {
        List<Gallery> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM [photographer].[dbo].[Gallery]";
            conn = db.getConnection();
            statement = conn.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                Gallery g = new Gallery();
                g.setId(rs.getInt("id"));
                g.setName(rs.getString("name"));
                g.setPictureCover(rs.getString("pictureCover"));
                g.setDescription(rs.getString("description"));
                list.add(g);
            }
        } catch (Exception ex) {
            Logger.getLogger(GalleryDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeConnection(rs, statement, conn);
        }
        return list;
    }

}
