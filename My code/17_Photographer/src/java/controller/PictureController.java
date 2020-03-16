/*
* PictureController.java
*
* All Right Reserved
* Copyright (c) 2020 FPT University
 */
package controller;

import dal.GalleryDAO;
import dal.PictureDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Gallery;
import model.Picture;

/**
 * PictureController.<br>
 *
 * <pre>
 *
 *  Lấy dữ liệu từ database thông qua class PictureDAO để lấy ra tất cả các ảnh
 *  Trong class này sẽ tiến hành các xử lí dưới đây.
 *
 * . DoGet.
 * . DoPost.
 *
 *
 * </pre>
 *
 * @author FU HuyNQHE130510
 * @version 1.0
 */
public class PictureController extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     * methods.
     * Hiển thị toàn bộ ảnh theo id của Gallery lên trang picture.jsp
     * 
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            GalleryDAO gDao = new GalleryDAO();
            PictureDAO dao = new PictureDAO();
            request.setAttribute("gId", Integer.parseInt((String) request.getParameter("id")));
            List<Gallery> gallerys = gDao.getGalleries();
            List<Picture> pictures = dao.getPicturesById(Integer.parseInt((String) request.getParameter("id")));
            request.setAttribute("gallerys", gallerys);
            request.setAttribute("pictures", pictures);
            request.getRequestDispatcher("picture.jsp").forward(request, response);
        } catch (IOException | NumberFormatException | SQLException | ServletException ex) {
            request.setAttribute("error", ex.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
            Logger.getLogger(PictureController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
