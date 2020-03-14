/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.auth;

import controller.BaseController;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.AccountModel;

/**
 *
 * @author sonnt
 */
public class LoginController extends BaseController {

    @Override
    protected void processPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if(username.equals("huynguyen") && password.equals("123"))
        {
            AccountModel model = new AccountModel();
            model.setUsername(username);
            model.setPassword(password);
            req.getSession().setAttribute("user", model);
            resp.getWriter().println("Login Successful!");
        }
        else
        {
            resp.getWriter().println("Login Failed!");
        }
    }

    @Override
    protected void processGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }
    
}
