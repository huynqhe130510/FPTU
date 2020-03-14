/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.entity;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Chi_Tiet_Don_Hang;
import model.Don_Hang;

/**
 *
 * @author huyNguyen
 */
public class Delete_Don_Hang extends BaseRequiredAuthenticationController {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Chi_Tiet_Don_Hang chi_Tiet_Don_Hang = (Chi_Tiet_Don_Hang) session.getAttribute("chi_Tiet_Don_Hang");
        String raw_id = request.getParameter("del");
        for (int i = 0; i < chi_Tiet_Don_Hang.getDon_Hangs().size(); i++) {
            if (raw_id.equals(chi_Tiet_Don_Hang.getDon_Hangs().get(i).getAo().getMa_ao())) {
                chi_Tiet_Don_Hang.getDon_Hangs().remove(i);
            }
        }
        response.sendRedirect("mua");
    }

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

}
