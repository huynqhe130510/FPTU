/*
* SearchController.java
*
* All Right Reserved
* Copyright (c) 2020 FPT University
 */
package controller;

import dal.NewsDAO;
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
import javax.servlet.http.HttpSession;
import model.News;

/**
 * SearchController.<br>
 *
 * <pre>
 *
 *  Lấy dữ liệu từ class NewsController thông qua các session để hiện ra các bản ghi
 *  về các bài báo tìm kiếm được
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
public class SearchController extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method. 
     * methods.
     * Hiển thị tiêu đề và nội dung tóm tắt của các bài báo vừa tìm kiếm được
     * đồng thời tiến hành phân trang (3 bài báo/ 1 trang)
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
            String searchTitle = (String) session.getAttribute("searchInput");

            //chia ra số trang cần có cho các kết quả search được
            int pageCount = (Integer) session.getAttribute("numOfSearchResult");
            pageCount = (pageCount % 3 == 0) ? pageCount / 3 : pageCount / 3 + 1;

            ArrayList<Integer> listCount = new ArrayList<>();
            for (int i = 1; i <= pageCount; i++) {
                listCount.add(i);
            }

            NewsDAO dao = new NewsDAO();
            String pageindex_raw = request.getParameter("index");
            if (pageindex_raw == null) {
                pageindex_raw = "1";
            }
            int pageIndex = Integer.parseInt(pageindex_raw);
            request.setAttribute("page", pageIndex);

            List<News> listSearch = dao.searchNewsByTitle(searchTitle, pageIndex, 3);
            request.setAttribute("searchResults", listSearch);
            request.setAttribute("page_Index", pageIndex);
            request.setAttribute("listCount", listCount);
            request.getRequestDispatcher("search.jsp").forward(request, response);
        } catch (IOException | NumberFormatException | SQLException | ServletException ex) {
            request.setAttribute("error", ex.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
            Logger.getLogger(NewsController.class.getName()).log(Level.SEVERE, null, ex);
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
