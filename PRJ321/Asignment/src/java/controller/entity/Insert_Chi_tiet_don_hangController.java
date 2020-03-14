/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.entity;

import dal.GioHangDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Chi_Tiet_Don_Hang;

/**
 *
 * @author huyNguyen
 */
public class Insert_Chi_tiet_don_hangController extends BaseRequiredAuthenticationController {

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
        String ten_khack_hang = request.getParameter("ten_khack_hang");
        String sdt = request.getParameter("sdt");
        String dia_chi = request.getParameter("dia_chi");

        Chi_Tiet_Don_Hang chi_Tiet_Don_Hang = (Chi_Tiet_Don_Hang) request.getSession().getAttribute("chi_Tiet_Don_Hang");

        chi_Tiet_Don_Hang.setTen(ten_khack_hang);
        chi_Tiet_Don_Hang.setSdt(sdt);
        chi_Tiet_Don_Hang.setDia_chi(dia_chi);

        GioHangDAO gioHangDAO = new GioHangDAO();
        gioHangDAO.insert(chi_Tiet_Don_Hang);
        request.getSession().setAttribute("chi_Tiet_Don_Hang", null);
        response.sendRedirect("ao");
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
