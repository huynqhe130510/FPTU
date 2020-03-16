/*
* ScoreController.java
*
* All Right Reserved
* Copyright (c) 2020 FPT University
 */
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ScoreController.<br>
 *
 * <pre>
 *
 *  Thực hiện việc hiển thị số điểm khi người dùng làm xong bài và submit bài 
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
public class ScoreController extends BaseRequiredAuthenticationController {

    /**
     * Handles the HTTP <code>GET</code> method.
     * Lấy kết quả (số điểm) của bài vừa làm xong trong session rồi gửi qua trang
     * score.jsp để hiện thị số điểm của bài làm cho người dùng biết.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("point", request.getSession().getAttribute("point"));
        request.getRequestDispatcher("score.jsp").forward(request, response);
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
