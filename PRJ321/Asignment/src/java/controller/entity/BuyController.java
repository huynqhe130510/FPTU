/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.entity;

import dal.AoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Ao;
import model.Chi_Tiet_Don_Hang;
import model.Don_Hang;

/**
 *
 * @author huyNguyen
 */
public class BuyController extends BaseRequiredAuthenticationController {

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("giohang.jsp").forward(request, response);
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Chi_Tiet_Don_Hang chi_Tiet_Don_Hang = (Chi_Tiet_Don_Hang) session.getAttribute("chi_Tiet_Don_Hang");
        if (chi_Tiet_Don_Hang == null) {
            chi_Tiet_Don_Hang = new Chi_Tiet_Don_Hang();
        }

        String Ma_Ao = request.getParameter("Ma_Ao");
        AoDAO aoDAO = new AoDAO();
        Ao ao = aoDAO.getAo(Ma_Ao);
        boolean isExisting = false;
        for (Don_Hang don_Hang : chi_Tiet_Don_Hang.getDon_Hangs()) {
            if (don_Hang.getAo().getMa_ao().equalsIgnoreCase(ao.getMa_ao())) {
                don_Hang.setSo_luong(don_Hang.getSo_luong() + 1);
                isExisting = true;
                break;
            }
        }
        if (!isExisting) {
            Don_Hang don_Hang = new Don_Hang();
            don_Hang.setChi_Tiet_Don_Hang(chi_Tiet_Don_Hang);
            don_Hang.setAo(ao);
            don_Hang.setDon_gia(ao.getGia());
            don_Hang.setSo_luong(1);
            don_Hang.setTong(don_Hang.getTotal());
            chi_Tiet_Don_Hang.getDon_Hangs().add(don_Hang);
        }
        session.setAttribute("chi_Tiet_Don_Hang", chi_Tiet_Don_Hang);
        response.sendRedirect("ao");

    }

}
