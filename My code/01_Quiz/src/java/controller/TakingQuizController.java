/*
* TakingQuizController.java
*
* All Right Reserved
* Copyright (c) 2020 FPT University
 */
package controller;

import dal.QuestionDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Question;

/**
 * TakingQuizController.<br>
 *
 * <pre>
 *
 *  Thực hiện việc hiển thị số câu hỏi mà người dùng đã chọn trong trang prepare.jsp
 *  để làm, người dùng có thể next hoặc previous câu hỏi sau khi làm xong có thể submit
 *  làm, nếu hết thời gian hệ thống sẽ tự động submit bài (1'/câu hỏi).
 *  Trong class này sẽ tiến hành các xử lí dưới đây.
 *
 * . processGet.
 * . processPost .
 *
 *
 * </pre>
 *
 * @author FU HuyNQHE130510
 * @version 1.0
 */
public class TakingQuizController extends BaseRequiredAuthenticationController {

    /**
     * Handles the HTTP <code>GET</code> method.
     * Lấy tất cả câu hỏi trong database rồi hiển thị lên trang takeQuiz.jsp để
     * người dùng làm bài.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            QuestionDAO dao = new QuestionDAO();
            List<Question> questions = dao.getAllQuestions();
            request.setAttribute("question", questions);
            request.getRequestDispatcher("takeQuiz.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(TakingQuizController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     * Lấy tất cả câu hỏi trong database, số câu hỏi mà người dùng nhập rồi thực
     * hiện vòng lặp để so sánh từng đáp án của từng câu hỏi, nếu trùng thì câu trả
     * lời là đúng, người lại câu hỏi sẽ bị sai, mỗi lần đúng thì số câu hỏi đúng sẽ tăng theo,
     * sau khi kết thúc thì tính điểm cho người dùng.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //Số câu hỏi mà người dùng nhập
            double num = Double.parseDouble(request.getParameter("num"));
            QuestionDAO dao = new QuestionDAO();
            List<Question> questions = dao.getAllQuestions();
            //Số câu hỏi đúng 
            double correctAnswer = 0;
            Question q = new Question();
            for (int i = 0; i < num; i++) {
                //Mảng câu trả lời của người dùng
                String name[] = request.getParameterValues("q" + (i + 1));
                if (name == null) {
                    name = new String[0];
                }
                for (int j = 0; j < questions.size(); j++) {
                    q = dao.getQuestionById(questions.get(j).getId());
                    String[] s = q.getAnswer().split(",");
                    if (s.length != name.length) {
                        questions.remove(j).getId();
                        break;
                    } else {
                        //Câu hỏi có 1 đáp án đúng
                        if (s.length == 1 && name.length == 1 && s[0].equals(name[0])) {
                            correctAnswer += 1;
                            questions.remove(j).getId();
                            break;
                        }
                        if (s.length == 1 && name.length == 1 && !s[0].equals(name[0])) {
                            questions.remove(j).getId();
                            break;
                        }
                        //Câu hỏi có 2 đáp án đúng
                        if (s.length == 2 && name.length == 2 && s[0].equals(name[0]) && s[1].equals(name[1])) {
                            correctAnswer += 1;
                            questions.remove(j).getId();
                            break;
                        }
                        if (s.length == 2 && name.length == 2 && !s[0].equals(name[0]) || !s[1].equals(name[1])) {
                            correctAnswer += 1;
                            questions.remove(j).getId();
                            break;
                        }
                    }
                }
            }
            NumberFormat format = new DecimalFormat("#0.0");
            String point = format.format((correctAnswer / num) * 10);
            HttpSession session = request.getSession();
            session.setAttribute("point", point);
            response.sendRedirect("score");
        } catch (SQLException ex) {
            Logger.getLogger(TakingQuizController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
