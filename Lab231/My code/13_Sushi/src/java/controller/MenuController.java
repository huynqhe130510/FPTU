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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Menu;

/**
 * MenuController.<br>
 *
 * <pre>
 *
 * Class sẽ lấy dữ liệu từ class MenuDAO để hiện ra thông tin các menu của các
 * món sushi cho người dùng xem.
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
     * methods.<br>
     * Hiện ra toàn bộ menu của các món Sushi tương ứng rồi thực hiện thao tác
     * phân trang (3 menu/1 trang).
     * Nếu bị lỗi chuyển qua trang error.jsp để thông báo lỗi cho người dùng.
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
            MenuDAO dao = new MenuDAO();
            int pageCount = dao.countAllResult();
            int pageSize = 3;
            ArrayList<Integer> listCount = new ArrayList<>();

            pageCount = (pageCount % pageSize == 0) ? pageCount / pageSize : pageCount / pageSize + 1;
            for (int i = 1; i <= pageCount; i++) {
                listCount.add(i);
            }
            String pageindex_raw = request.getParameter("index");
            if (pageindex_raw == null) {
                pageindex_raw = "1";
            }
            int pageIndex = Integer.parseInt(pageindex_raw);
            List<Menu> menus = dao.getMenu(pageIndex, pageSize);

            request.setAttribute("page", pageIndex);
            request.setAttribute("count", pageCount);
            request.setAttribute("listCount", listCount);
            request.setAttribute("menu", menus);
            request.getRequestDispatcher("menu.jsp").forward(request, response);
        } catch (IOException | NumberFormatException | SQLException | ServletException ex) {
            request.setAttribute("error", ex.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
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
