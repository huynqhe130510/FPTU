/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.entity;

import dal.ThongKeDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Thong_Ke;

/**
 *
 * @author huyNguyen
 */
public class ThongKeController extends BaseRequiredAuthenticationController {

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String from = request.getParameter("from");
        if (from == null) {
            from = "";
        }
        String to = request.getParameter("to");
        if (to == null) {
            to = "";
        }
        ThongKeDAO thongKeDAO = new ThongKeDAO();
        ArrayList<Thong_Ke> thong_Kes = thongKeDAO.thongKe(from, to);
        String sum = thongKeDAO.getTong(from, to);
        String quantity = thongKeDAO.getTongSoLuong(from, to);
        if(sum == null){
            sum = "0";
        }
        if(quantity == null){
            quantity = "0";
        }
        request.setAttribute("thong_Kes", thong_Kes);
        request.setAttribute("sum", sum);
        request.setAttribute("quantity", quantity);
        request.getRequestDispatcher("thongke.jsp").forward(request, response);
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String from = request.getParameter("from");
         if (from == null) {
            from = "";
        }
        String to = request.getParameter("to");
        if (to == null) {
            to = "";
        }
        ThongKeDAO thongKeDAO = new ThongKeDAO();
        ArrayList<Thong_Ke> thong_Kes = thongKeDAO.thongKe(from, to);
        String sum = thongKeDAO.getTong(from, to);
        String quantity = thongKeDAO.getTongSoLuong(from, to);
        if(sum == null){
            sum = "0";
        }
        if(quantity == null){
            quantity = "0";
        }
        request.setAttribute("thong_Kes", thong_Kes);
        request.setAttribute("sum", sum);
        request.setAttribute("quantity", quantity);
        request.getRequestDispatcher("thongke.jsp").forward(request, response);
    }

}
