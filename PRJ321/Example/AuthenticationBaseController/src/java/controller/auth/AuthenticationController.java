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
public abstract class AuthenticationController 
extends BaseController
{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(!isAuthenticated(req))
            resp.sendRedirect("../login");
        else
            super.doGet(req, resp); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(!isAuthenticated(req))
            resp.sendRedirect("../login");
        else
            super.doPost(req, resp); //To change body of generated methods, choose Tools | Templates.
    }
    
    private boolean isAuthenticated(HttpServletRequest req)
    {
      AccountModel account =
              (AccountModel)req.getSession().getAttribute("user");
      return account !=null;
    }
}
