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
 * @author sonnt
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
        String raw_gender = request.getParameter("gender");
        String raw_name = request.getParameter("name");
        String raw_fromm = request.getParameter("fromm");
        String raw_to = request.getParameter("to");
        if(raw_did == null)
            raw_did = "0";
        int did = Integer.parseInt(raw_did);
        if (raw_id ==null||raw_id.contentEquals(""))
            raw_id = "0";
         int id = Integer.parseInt(raw_id);
        if(raw_gender == null) 
            raw_gender="2";
        int gender = Integer.parseInt(raw_gender);
        if(raw_name==null) 
            raw_name="";
        if(raw_fromm ==null) 
            raw_fromm = "";
        if(raw_to ==null) 
            raw_to = "";
        DepartmentDAO deptDB = new DepartmentDAO();
        request.setAttribute("depts", deptDB.getDepts());
        EmployeeDAO empDB = new EmployeeDAO();
        request.setAttribute("emps", empDB.getEmpsByDeptID(did,id,gender,raw_name,raw_fromm,raw_to));
        request.setAttribute("did", did);
        request.setAttribute("id", id);
        request.setAttribute("name", raw_name);
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
