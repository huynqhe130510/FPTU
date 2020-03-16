/*
* PictureDAO.java
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
import model.Picture;

/**
 * PictureDAO.<br>
 *
 * <pre>
 * Class dùng các câu query để lấy dữ liệu từ database
 * Trong class này sẽ tiến hành các xử lí dưới đây.
 *
 * .getPicturesById
 *
 *
 * </pre>
 *
 * @author FU HuynqHE130510
 * @version 1.0
 */
public class PictureDAO {

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
    public PictureDAO() {
        db = new DBContext();
        conn = null;
        statement = null;
        rs = null;
    }

    /**
     * getPicturesById.<br>
     * 
     * Lấy tất cả ảnh theo id của Gallery từ database
     *
     * @param id
     * @return a list of Gallery
     * @throws java.sql.SQLException
     */
    public List<Picture> getPicturesById(int id) throws SQLException {
        List<Picture> list = new ArrayList<>();
        try {
            String sql = "select p.id, p.picture from Gallery_Picture gp, Gallery g, Picture p where gp.galleryId = g.id and gp.pictureId = p.id and g.id = ?";
            conn = db.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            rs = statement.executeQuery();
            while (rs.next()) {
                Picture p = new Picture();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("picture"));
                list.add(p);
            }
        } catch (Exception ex) {
            Logger.getLogger(GalleryDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeConnection(rs, statement, conn);
        }
        return list;
    }
}
