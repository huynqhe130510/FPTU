/*
* GalleryController.java
*
* All Right Reserved
* Copyright (c) 2020 FPT University
 */
package controller;

import dal.ContactDAO;
import dal.GalleryDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Contact;
import model.Gallery;

/**
 * ContactController.<br>
 *
 * <pre>
 *
 *  Lấy dữ liệu từ database thông qua class GalleryDAO để hiển thị các thông tin của Gallery lên
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
public class GalleryController extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     * methods. 
     * Lấy tất cả thông tin cả Gallery rồi gửi qua trang home.jsp
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GalleryDAO dao = new GalleryDAO();
        ContactDAO cDao = new ContactDAO();
        try {
            List<Gallery> gallerys = dao.getGalleries();
            Contact c = cDao.getContact();
            request.getSession().setAttribute("gallerys", gallerys);
            request.setAttribute("contact", c);
            request.getRequestDispatcher("home.jsp").forward(request, response);
        } catch (IOException | SQLException | ServletException ex) {
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
