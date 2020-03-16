/*
* MakeQuizController.java
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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

/**
 * MakeQuizController.<br>
 *
 * <pre>
 *
 * Thực hiện việc tạo câu hỏi cho người dùng(Teacher) có quyền qua các câu lệnh sql
 * Trong class này sẽ tiến hành các xử lí dưới đây.
 * 
 * . doGet.
 * . doPost.
 *
 *
 * </pre>
 *
 * @author FU HuyNQHE130510
 * @version 1.0
 */
public class MakeQuizController extends BaseRequiredAuthenticationController {

    /**
     * Handles the HTTP <code>GET</code> method.
     * Lấy thông tin của User trong session, xét xem User có quyền thêm câu hỏi
     * hay không, nếu không gửi về trang thông báo lỗi, nếu có gửi về trang makeQuiz.jsp
     * cho người dùng thực hiện việc thêm câu hỏi.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User u = (User) request.getSession().getAttribute("user");

        if (u.getType().getId() == 1) {
            request.getRequestDispatcher("makeQuiz.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("accessError.jsp").forward(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     * Lấy dữ liệu của câu hỏi mà người dùng đã nhập(muốn thêm) tương ứng với id
     * của người dùng ở trang makeQuiz.jsp rồi thực hiện thêm câu hỏi vào database 
     * qua câu lệnh sql.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String question = request.getParameter("question");
            String o1 = request.getParameter("o1");
            String o2 = request.getParameter("o2");
            String o3 = request.getParameter("o3");
            String o4 = request.getParameter("o4");
            String answer[] = request.getParameterValues("answer");
            User u = (User) request.getSession().getAttribute("user");
            int teacherId = u.getId();

            QuestionDAO dao = new QuestionDAO();
            dao.addQuestion(question, o1, o2, o3, o4, answer, teacherId);
            response.sendRedirect("makeQuiz");
        } catch (SQLException ex) {
            Logger.getLogger(MakeQuizController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
