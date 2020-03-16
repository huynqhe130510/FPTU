/*
* UpdateQuestionController.java
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
import model.Question;
import model.User;

/**
 * UpdateQuestionController.<br>
 *
 * <pre>
 *
 *  Thực hiện việc update câu hỏi tương ứng với id của người dùng (mỗi câu hỏi
 *  sẽ chỉ thuộc 1 người dùng duy nhất).
 *  Trong class này sẽ tiến hành các xử lí dưới đây.
 *
 * . doGet.
 * . doPost .
 *
 * </pre>
 *
 * @author FU HuyNQHE130510
 * @version 1.0
 */
public class UpdateQuestionController extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     * Lấy câu hỏi theo id của người dùng rồi hiển thị câu hỏi và câu trả lời 
     * qua trang update.jsp.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            QuestionDAO dao = new QuestionDAO();
            int id = Integer.parseInt(request.getParameter("id"));
            Question q = dao.getQuestionById(id);

            request.setAttribute("q", q);
            request.getRequestDispatcher("update.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(UpdateQuestionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     * Lấy các chỉnh sửa của câu hỏi khi người dùng thay đổi rồi thực hiện việc
     * update câu hỏi qua câu lệnh sql.
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

            String question = request.getParameter("question");
            String o1 = request.getParameter("o1");
            String o2 = request.getParameter("o2");
            String o3 = request.getParameter("o3");
            String o4 = request.getParameter("o4");
            String answer[] = request.getParameterValues("answer");
            User u = (User) request.getSession().getAttribute("user");
            int teacherId = u.getId();
            int qid = Integer.parseInt(request.getParameter("id"));
            dao.updateQuestion(qid, question, o1, o2, o3, o4, answer, teacherId);
            response.sendRedirect("update?id=" + qid);
        } catch (SQLException ex) {
            Logger.getLogger(UpdateQuestionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
