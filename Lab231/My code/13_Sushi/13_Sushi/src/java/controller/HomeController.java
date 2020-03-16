/*
* HomeController.java
*
* All Right Reserved
* Copyright (c) 2020 FPT University
 */
package controller;

import dal.ArticleDAO;
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
import model.Article;

/**
 * Home.<br>
 *
 * <pre>
 * 
 * Class sẽ hiện ra toàn bộ các món Sushi cho người dùng lựa chọn
 * 
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
public class HomeController extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method. 
     * methods. 
     * hiện ra thông tin của tất cả các món Sushi
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
            ArticleDAO dao = new ArticleDAO();
            int pageCount = dao.countAllResult();
            ArrayList<Integer> listCount = new ArrayList<>();

            pageCount = (pageCount % 3 == 0) ? pageCount / 3 : pageCount / 3 + 1;
            for (int i = 1; i <= pageCount; i++) {
                listCount.add(i);
            }
            String pageindex_raw = request.getParameter("index");
            if (pageindex_raw == null) {
                pageindex_raw = "1";
            }
            int pageIndex = Integer.parseInt(pageindex_raw);
            List<Article> articles = dao.getListArticle(pageIndex, 3);

            request.setAttribute("page", pageIndex);
            request.setAttribute("count", pageCount);
            request.setAttribute("articles", articles);
            request.setAttribute("listCount", listCount);
            request.getRequestDispatcher("home.jsp").forward(request, response);
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
