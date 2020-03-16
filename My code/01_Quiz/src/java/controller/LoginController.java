/*
* LoginController.java
*
* All Right Reserved
* Copyright (c) 2020 FPT University
 */
package controller;

import dal.UserDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

/**
 * LoginController.<br>
 *
 * <pre>
 *
 * Thực hiện việc đăng nhập vào hệ thống thông qua việc so sánh thông tin uername
 * và password lúc người dùng nhập vào và trong database.
 * Trong class này sẽ tiến hành các xử lí dưới đây.
 *
 * . doGet.
 * . doPost.
 *
 *
 * </pre>
 *
 * @author FU HuyNQHE130510
 * @version 1.0
 */
public class LoginController extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     * Chuyển sang trang login.jsp cho người dùng đăng nhập
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     * Lấy username và password khi người dùng nhập vào ô đăng nhập để so sánh với
     * thông tin tài khoản trong database nếu trùng thì chuyển qua trang home.jsp và
     * cho phép người dùng sử dụng các chức năng của hệ thống
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            UserDAO dao = new UserDAO();
            User user = dao.getUser(username, password);
            if (user != null) {
                 request.getSession().setAttribute("user", user);
                response.sendRedirect("home");
            } else {
                response.sendRedirect(request.getContextPath() + "/login");
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
