/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.DepartmentDAO;
import dao.StudentDAO;
import entity.Department;
import entity.Student;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Hoan toan hanh phuc
 */
@WebServlet(name = "AddControl", urlPatterns = {"/AddControl"})
public class AddControl extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
          try {
            String name = request.getParameter("name");
            String date = request.getParameter("date");
            int gender = Integer.parseInt(request.getParameter("gender"));
            int departmentid =Integer.parseInt(request.getParameter("dp"));
            Student s = new Student(name, date , gender, departmentid);
            StudentDAO studentDAO = new StudentDAO();
            studentDAO.insertStudent(s);
          //  response.sendRedirect("index.html");
            request.setAttribute("mess", "add succesfully");
            DepartmentDAO departmentDAO = new DepartmentDAO();
            List<Department> list = departmentDAO.getDepartmentName();
            request.setAttribute("list",list);
            request.getRequestDispatcher("Add.jsp").forward(request, response);
          //  request.getRequestDispatcher("Add.jsp").forward(request, response);
        } catch (Exception e) {
        }
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
