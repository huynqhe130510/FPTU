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
public class SearchController extends AuthenticationController{

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String raw_id = req.getParameter("id");
        raw_id = (raw_id==null||raw_id.length()==0)
                ?"-1":raw_id;
        String raw_name = req.getParameter("name");
        raw_name = (raw_name==null)?"":raw_name;
        String raw_from = req.getParameter("from");
        raw_from = (raw_from==null)?"":raw_from;
        String raw_to = req.getParameter("to");
        raw_to = (raw_to==null)?"":raw_to;
        String raw_gender = req.getParameter("gender");
        raw_gender = (raw_gender==null)?"both":raw_gender;
        String raw_did = req.getParameter("did");
        raw_did = (raw_did==null||raw_did.length()==0)
                ?"-1":raw_did;
        
        int id = Integer.parseInt(raw_id);
        String name = raw_name;
        Date from = (raw_from.length()==0)
                ?null:Date.valueOf(raw_from);
        Date to = (raw_to.length()==0)
                ?null:Date.valueOf(raw_to);
        Boolean gender = (raw_gender.equals("both"))?null
                :raw_gender.equals("male");
        int did = Integer.parseInt(raw_did);
        
        StudentDAO stuDB = new StudentDAO();
        ArrayList<StudentModel> students = 
                stuDB.search(id, name, from, to, gender, did);
        req.setAttribute("students", students);
        DepartmentDAO deptDB = new DepartmentDAO();
        ArrayList<DepartmentModel> depts = deptDB.all();
        req.setAttribute("depts", depts);
        req.getRequestDispatcher("search.jsp").forward(req, resp);
    }
    
    @Override
    protected void processPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void processGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }
    
}
