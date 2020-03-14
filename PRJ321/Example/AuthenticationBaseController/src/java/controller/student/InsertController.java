/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.student;

import controller.BaseController;
import controller.auth.AuthenticationController;
import dal.DepartmentDAO;
import dal.StudentDAO;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DepartmentModel;
import model.StudentModel;

/**
 *
 * @author sonnt
 */
public class InsertController extends BaseController {

    @Override
    protected void processPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt( req.getParameter("id") );
        String name = req.getParameter("name");
        Date dob = Date.valueOf(req.getParameter("dob") );
        boolean gender = req.getParameter("gender").equals("male");
        int did = Integer.parseInt( req.getParameter("did") );
        DepartmentModel dept = new DepartmentModel();
        dept.setId(did);
        
        StudentModel s = new StudentModel();
        s.setId(id);
        s.setName(name);
        s.setGender(gender);
        s.setDob(dob);
        s.setDepartment(dept);
        StudentDAO db = new StudentDAO();
        db.insert(s);
        resp.sendRedirect("list");
    }

    @Override
    protected void processGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //load data
        DepartmentDAO db = new DepartmentDAO();
        ArrayList<DepartmentModel> departments = db.all();
        //FW
        req.setAttribute("departments", departments);
        req.getRequestDispatcher("insert.jsp").forward(req, resp);
    }
    
}
