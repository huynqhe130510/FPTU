/*
* LogoutController.java
*
* All Right Reserved
* Copyright (c) 2020 FPT University
 */
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * LogoutController.<br>
 *
 * <pre>
 *
 * Thực hiện việc đăng xuất ra khổi hệ thống
 * Trong class này sẽ tiến hành các xử lí dưới đây.
 * 
 * . processRequest.
 * . doGet.
 * . doPost.
 *
 *
 * </pre>
 *
 * @author FU HuyNQHE130510
 * @version 1.0
 */
public class LogoutController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     * Đăng xuất tài khoản của người dùng ra khỏi hệ thống bằng cách thêm User 
     * không có dữ liệu vào trong session thay cho User muốn đăng xuất rồi sau đó
     * gửi về trang login.jsp cho người dùng đăng nhập lại nếu muốn.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getSession().setAttribute("user", null);
        response.sendRedirect("login");
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
        processRequest(request, response);
    }
}
