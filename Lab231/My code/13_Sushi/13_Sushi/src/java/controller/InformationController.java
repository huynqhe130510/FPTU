/*
* InfomationController.java
*
* All Right Reserved
* Copyright (c) 2020 FPT University
 */
package controller;

import dal.InformationDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Information;

/**
 * Info.<br>
 *
 * <pre>
 * Class sẽ lấy dữ liệu từ class InfomationDAO để hiện ra thông tin
 * Trong class này sẽ tiến hành các xử lí dưới đây.
 *
 * . DoGet.
 * . DoPost.
 *
 *
 * </pre>
 *
 * @author FU HuyNQHE130510
 * @version 1.0
 */
public class InformationController extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     * methods. Hiển thị ra thông tin liên hệ (SĐT, email, địa chỉ và giờ mở cửa)
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            InformationDAO dao = new InformationDAO();
            List<Information> info = dao.getInfor();
            request.setAttribute("infor", info);
            request.setAttribute("address", dao.getAddress());
            request.setAttribute("tel", dao.getTel());
            request.setAttribute("mail", dao.getMail());
            request.getRequestDispatcher("infor.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(InformationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
