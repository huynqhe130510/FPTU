/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import javax.servlet.http.HttpSession;
import model.User;

/**
 *
 * @author sonnt
 */
public class SessionHelper {
    public static void addAccountToSession(HttpSession session,User user)
    {
        session.setAttribute("user", user);
    }
    
    public static User getAccountFromSession(HttpSession session)
    {
        return (User)session.getAttribute("user");
    }
}
