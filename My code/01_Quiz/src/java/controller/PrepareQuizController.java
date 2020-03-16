/*
* PrepareQuizController.java
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

/**
 * PrepareQuizController.<br>
 *
 * <pre>
 *
 *  Lấy dữ liệu từ class QuestionDAO, chuẩn bị các câu hỏi để làm bài theo số câu hỏi
 *  mà người dùng nhập
 *  Trong class này sẽ tiến hành các xử lí dưới đây.
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
public class PrepareQuizController extends BaseRequiredAuthenticationController {

    /**
     * Handles the HTTP <code>GET</code> method.
     * Lấy ra tổng tất cả các câu hỏi trong database và giới hạn số câu hỏi cho
     * người dùng nhập phải nhỏ hơn tổng số câu hỏi được lấy ra.
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            QuestionDAO dao = new QuestionDAO();
            int maxQuestion = dao.totalQuestions();
            request.setAttribute("maxQuestion", maxQuestion);
            request.getRequestDispatcher("prepareQuiz.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(PrepareQuizController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     * lấy số câu hỏi mà người dùng nhập vào, cho vào trong session rồi gửi đến
     * trang trackingQuiz.jsp để người dùng làm bài.
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int numOfQuestions = Integer.parseInt(request.getParameter("numOfQues"));
        request.getSession().setAttribute("num", numOfQuestions);
        response.sendRedirect("takingQuiz?num=" + numOfQuestions);
    }
}
