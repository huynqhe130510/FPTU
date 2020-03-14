/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.entity;

import dal.MessageDAO;
import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;
import util.SessionHelper;

/**
 *
 * @author huyNguyen
 */
public class CreateController extends BaseRequiredAuthenticationController {

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDAO userDAO = new UserDAO();
        ArrayList<User> users = userDAO.getUsers();
        request.setAttribute("users", users);
        request.getRequestDispatcher("create.jsp").forward(request, response);
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MessageDAO messageDAO = new MessageDAO();

        String title = request.getParameter("title");
        String to = request.getParameter("to");
        String content = request.getParameter("content");

        User u = SessionHelper.getAccountFromSession(request.getSession());
        String from = u.getId();

        messageDAO.createMessage(title, from, to, content);
        response.getWriter().println("Message send successful!");
    }

}
