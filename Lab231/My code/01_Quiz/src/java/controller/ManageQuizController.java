/*
* ManageQuizController.java
*
* All Right Reserved
* Copyright (c) 2020 FPT University
 */
package controller;

import dal.QuestionDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Question;
import model.User;

/**
 * ManageQuizController.<br>
 *
 * <pre>
 *
 * Thực hiện việc quản lí câu hỏi tương ứng với số câu hỏi của người dùng đó, 
 * người dùng có thể sửa vào xóa câu hỏi nếu muốn.
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
public class ManageQuizController extends BaseRequiredAuthenticationController {

    /**
     * Handles the HTTP <code>GET</code> method.
     * Đầu tiên thực hiện kiểm tra xem người dùng có quyền quản lí câu hỏi hay không,
     * nếu có thì cho phép người dùng thực hiện chức năng này tương ứng với id của
     * người dùng (id của ai thì quản lí câu hỏi của người đó) còn nếu không có quyền
     * thì thông báo lỗi.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User u = (User) request.getSession().getAttribute("user");

        if (u.getType().getId() == 1) {
            try {
                QuestionDAO dao = new QuestionDAO();
                int teacherId = u.getId();
                List<Question> questions = dao.getQuestionsByTeacherId(teacherId);
                int total = dao.totalQuestionsByTeacherId(teacherId);

                request.setAttribute("questions", questions);
                request.setAttribute("totalQues", total);
                request.getRequestDispatcher("manageQuiz.jsp").forward(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(ManageQuizController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            request.getRequestDispatcher("accessError.jsp").forward(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

}
