/*
* RegisterController.java
*
* All Right Reserved
* Copyright (c) 2020 FPT University
 */
package controller;

import dal.UserDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.UserType;

/**
 * RegisterController.<br>
 *
 * <pre>
 *
 *  Thực hiện việc đăng ký tài khoản cho người dùng khi muốn đăng ký tài khoản mới
 *  Trong class này sẽ tiến hành các xử lí dưới đây.
 *
 * . doGet.
 * . doPost .
 *
 *
 * </pre>
 *
 * @author FU HuyNQHE130510
 * @version 1.0
 */
public class RegisterController extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     * Lấy ra các loại người dùng (teacher, student) cho người dùng lực chọn khi
     * đăng ký tài khoản mới rồi gửi qua trang register.jsp.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            UserDAO dao = new UserDAO();
            List<UserType> types = dao.getType();

            request.setAttribute("types", types);
            request.getRequestDispatcher("register.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     * Lấy dữ liệu khi người dùng nhập vào rồi thêm tất cả các thông tin vừa lấy được
     * vào trong database thông qua câu lệnh sql.
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
            String type = request.getParameter("type");
            int t = Integer.parseInt(type);
            String email = request.getParameter("email");

            UserDAO dao = new UserDAO();
            dao.addUser(username, password, t, email);
            response.sendRedirect("login");
        } catch (SQLException ex) {
            Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
