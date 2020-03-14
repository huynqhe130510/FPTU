/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.DepartmentDAO;
import dal.EmployeeDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Asus
 */
public class EmployeeListController extends HttpServlet {

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
        String raw_did = request.getParameter("did");
        
        String raw_id = request.getParameter("id");
        String name = request.getParameter("name");
        String raw_gender = request.getParameter("gender");
        String dobFrom = request.getParameter("dobFrom");
        String dobTo = request.getParameter("dobTo");
        
        if(raw_did == null)
            raw_did = "0";
        int did = Integer.parseInt(raw_did);
        if(raw_id == null || raw_id.equals(""))
            raw_id = "0";
        int id = Integer.parseInt(raw_id);
        if(raw_gender == null)
            raw_gender = "2";
        int gender = Integer.parseInt(raw_gender);
        if(name == null)
            name = "";
        if(dobFrom == null)
            dobFrom = "";
        if(dobTo == null)
           dobTo = "";
        
        
        DepartmentDAO deptDB = new DepartmentDAO();
        request.setAttribute("depts", deptDB.getDepts());
        EmployeeDAO empDB = new EmployeeDAO();
        request.setAttribute("emps", empDB.getEmpsByDeptID(did, id, name, gender, dobFrom, dobTo));
        request.setAttribute("did", did);
        request.setAttribute("did", did);
        request.setAttribute("id", id);
        request.setAttribute("name", name);
        request.setAttribute("gender", gender);
        request.getRequestDispatcher("list.jsp").forward(request, response);
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
