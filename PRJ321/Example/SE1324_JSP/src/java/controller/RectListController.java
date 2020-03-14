/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Rect;

/**
 *
 * @author sonnt
 */
public class RectListController extends HttpServlet {

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
        int num = Integer.parseInt(request.getParameter("num"));
        int width = Integer.parseInt(this.getInitParameter("CanvasW"));
        int height = Integer.parseInt(this.getInitParameter("CanvasH"));
        request.setAttribute("CanvasW", width);
        request.setAttribute("CanvasH", height);
        ArrayList<Rect> rects = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < num; i++) {
            Rect rect = new Rect();
            rect.setBorderWidth( random.nextInt(5) + 1 );
            rect.setW( random.nextInt(151) + 50);
            rect.setH( random.nextInt(151) + 50);
            rect.setX(random.nextInt(width - rect.getW() - rect.getBorderWidth()));
            rect.setY(random.nextInt(height - rect.getH() - rect.getBorderWidth()));
            rect.setR(random.nextInt(256));
            rect.setG(random.nextInt(256));
            rect.setB(random.nextInt(256));
            rects.add(rect);
        }
        request.setAttribute("data", rects);
        request.getRequestDispatcher("newjsp.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
