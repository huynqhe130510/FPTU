/*
* DeleteQuestionController.java
*
* All Right Reserved
* Copyright (c) 2020 FPT University
 */
package controller;

import dal.QuestionDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * DeleteQuestionController.<br>
 *
 * <pre>
 *
 *  Thực hiện chức năng xóa câu hỏi qua câu lệnh sql 
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
public class DeleteQuestionController extends HttpServlet {

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
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     * Xóa câu hỏi theo id của câu hổi được chọn, sau khi xóa xong chuyển lại 
     * trang manageQuiz.jsp
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            QuestionDAO dao = new QuestionDAO();
            int id = Integer.parseInt(request.getParameter("id"));
            dao.deleteQuestion(id);
            response.sendRedirect("manageQuiz");
        } catch (SQLException ex) {
            Logger.getLogger(DeleteQuestionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
