/*
* ContactController.java
*
* All Right Reserved
* Copyright (c) 2020 FPT University
 */
package controller;

import dal.ContactDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Contact;

/**
 * ContactController.<br>
 *
 * <pre>
 *
 *  Lấy dữ liệu từ database thông qua class ContactDAO để hiện thị các thông tin lên
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
public class ContactController extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     * methods. 
     * Lấy tất cả thông tin rồi gửi qua trang contact.jsp
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
            ContactDAO dao = new ContactDAO();
            Contact c = dao.getContact();
            request.setAttribute("contact", c);
            request.getRequestDispatcher("contact.jsp").forward(request, response);
        }catch (IOException | SQLException | ServletException ex) {
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
