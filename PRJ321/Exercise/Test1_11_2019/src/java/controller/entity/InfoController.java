/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.entity;

import dal.InfoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Group;
import model.User;
import util.SessionHelper;

/**
 *
 * @author huyNguyen
 */
public class InfoController extends BaseRequiredAuthenticationController {

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Group> groups = new ArrayList<>();
        InfoDAO infoDAO = new InfoDAO();

        User user = SessionHelper.getAccountFromSession(request.getSession());
        String username = user.getUsername();
        groups = infoDAO.getGroups(username);
        request.setAttribute("groups", groups);
        request.getRequestDispatcher("info.jsp").forward(request, response);
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
