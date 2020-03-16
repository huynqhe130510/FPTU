/*
* NewsController.java
*
* All Right Reserved
* Copyright (c) 2020 FPT University
 */
package controller;

import dal.NewsDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.News;

/**
 * NewsController.<br>
 *
 * <pre>
 *
 *  Lấy dữ liệu từ database thông qua class NewsDAO để hiển thị các thông tin về bài báo
 *  Tiến hành tìm kiếm theo kí tự của tiêu đề bài báo
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
public class NewsController extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method. 
     * methods. 
     * Hiển thị̣ tiêu đề, nội dung của bài báo mới nhất và top5 bài báo mới nhất
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
            HttpSession session = request.getSession();
            NewsDAO dao = new NewsDAO();
            String id = request.getParameter("id");
            if (id == null) {
                id = String.valueOf(dao.getLastestNews().getId());
            }
            News n = dao.getNewsById(Integer.parseInt(id));

            List<News> listTop5 = dao.getTop5LatestNews();
            News latestNews = dao.getLastestNews();

            session.setAttribute("top5", listTop5);
            session.setAttribute("lastest", latestNews);
            request.setAttribute("news", n);
            request.getRequestDispatcher("news.jsp").forward(request, response);
        } catch (IOException | NumberFormatException | SQLException | ServletException ex) {
            request.setAttribute("error", ex.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
            Logger.getLogger(NewsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method. 
     * methods. 
     * Lấy dữ liệu từ ô search từ đó tìm kiếm thông qua kí tự mà người dùng vừa nhập
     * rồi hiển thị kết quả tìm kiếm được sau đó phân trang
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int pageSize = 3;
            int pageIndex = 1;
            HttpSession session = request.getSession();
            String searchInput = request.getParameter("searchInput");
            session.setAttribute("searchInput", searchInput);
            NewsDAO dao = new NewsDAO();
            List<News> listSearch = dao.searchNewsByTitle(searchInput, pageIndex, pageSize);
            session.setAttribute("searchResults", listSearch);
            session.setAttribute("numOfSearchResult", dao.countSearchResult(searchInput));
            response.sendRedirect("search?index=" + pageIndex);
        } catch (IOException | SQLException ex) {
            request.setAttribute("error", ex.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
            Logger.getLogger(NewsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
