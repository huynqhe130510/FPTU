/*
* BaseRequiredAuthenticationController.java
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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

/**
 * BaseRequiredAuthenticationController.<br>
 *
 * <pre>
 *
 *  Kiểm soát việc đăng nhập của người dùng thông qua session.
 *  Trong class này sẽ tiến hành các xử lí dưới đây.
 *
 * . isAuthenticated
 * . processGet
 * . processPost
 * . DoGet.
 * . DoPost.
 *
 *
 * </pre>
 *
 * @author FU HuyNQHE130510
 * @version 1.0
 */
public abstract class BaseRequiredAuthenticationController extends HttpServlet {

    /**
     * isAuthenticated . method.
     * Lấy dữ liệu của người dùng khi đăng nhập, nếu chưa đăng
     * nhập sẽ bắt buộc yêu cầu người dùng phải đăng nhập để sử dụng hệ thống
     *
     * @param request
     * @return
     */
    private boolean isAuthenticated(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            return true;
        } else {
            Cookie[] cookies = request.getCookies();
            if (cookies == null) {
                return false;
            } else {
                String username = null;
                String password = null;
                for (Cookie cooky : cookies) {
                    if (cooky.getName().equals("username")) {
                        username = cooky.getValue();
                    }
                    if (cooky.getName().equals("password")) {
                        password = cooky.getValue();
                    }
                    if (username != null && password != null) {
                        break;
                    }
                }
                if (username != null && password != null) {
                    try {
                        UserDAO dao = new UserDAO();
                        user = dao.getUser(username, password);
                        if (user != null) {
                            request.getSession().setAttribute("user", user);
                            return true;
                        } else {
                            return false;
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(BaseRequiredAuthenticationController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        return false;
    }

    /**
     * processGet. method.
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected abstract void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;

    /**
     * processPost. method.
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected abstract void processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;

    /**
     * Handles the HTTP <code>GET</code> method.
     * kiểm tra xem người dùng đã đăng nhập hay chưa, nếu chưa đăng nhập
     * thì chuyển đến trang login cho người dùng đăng nhập
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (isAuthenticated(request)) {
            processGet(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/login");
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     * kiểm tra xem người dùng đã đăng nhập hay chưa, nếu chưa đăng nhập
     * thì chuyển đến trang login cho người dùng đăng nhập
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (isAuthenticated(request)) {
            processPost(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/login");
        }
    }

}
