/*
* HomeController.java
*
* All Right Reserved
* Copyright (c) 2020 FPT University
 */
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * HomeController.<br>
 *
 * <pre>
 *
 * Nhận request rồi đẩy dữ liệu sang trang home.jsp khi người dùng đăng nhập thành công 
 * Trong class này sẽ tiến hành các xử lí dưới đây.
 *
 * . processGet.
 * . processPost.
 *
 *
 * </pre>
 *
 * @author FU HuyNQHE130510
 * @version 1.0
 */
public class HomeController extends BaseRequiredAuthenticationController {

    /**
     * Handles the HTTP <code>GET</code> method. 
     * Đẩy dữ liệu qua trang home.jsp
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
