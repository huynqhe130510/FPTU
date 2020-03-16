/*
* MenuController.java
*
* All Right Reserved
* Copyright (c) 2020 FPT University
 */
package controller;

import dal.MenuDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Menu;

/**
 * Menu.<br>
 *
 * <pre>
 * 
 * Class sẽ lấy dữ liệu từ class MenuDAO để hiện ra thông tin
 * Trong class này sẽ tiến hành các xử lí dưới đây.
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
public class MenuController extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     * methods.
     * Hiện ra toàn bộ giá tiền của các món Sushi tương ứng
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            MenuDAO dao = new MenuDAO();
            List<Menu> menu = dao.getMenu();
            request.setAttribute("menu", menu);
            request.getRequestDispatcher("menu.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
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
