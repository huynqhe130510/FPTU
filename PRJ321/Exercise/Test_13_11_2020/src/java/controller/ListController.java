/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.ScheduleDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Schedule;

/**
 *
 * @author huyNguyen
 */
public class ListController extends HttpServlet {

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
        String from = request.getParameter("from");
        if (from == null) {
            from = "";
        }
        String to = request.getParameter("to");
        if (to == null) {
            to = "";
        }

        ScheduleDAO scheduleDAO = new ScheduleDAO();
        ArrayList<Schedule> schedules = scheduleDAO.getSchedules(from, to);
        request.setAttribute("schedules", schedules);
        request.getRequestDispatcher("list.jsp").forward(request, response);
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
        String from = request.getParameter("from");
        String[] raw_from = from.split("-");
        String to = request.getParameter("to");
        String[] raw_to = to.split("-");

        int from_to_day = Integer.parseInt(raw_to[2]) - Integer.parseInt(raw_from[2]) + 1;
        int from_to_month = Integer.parseInt(raw_to[1]) - Integer.parseInt(raw_from[1]) + 1;

        ArrayList<Integer> dateDay = new ArrayList<>();
        ArrayList<Integer> dateMonth = new ArrayList<>();
        int day = Integer.parseInt(raw_from[2]);
        int month = Integer.parseInt(raw_from[1]);

        for (int i = 0; i < from_to_month; i++) {
            dateMonth.add(month);
        }

        for (int i = 0; i < from_to_day; i++) {
            dateDay.add(day);
            day++;
        }

        ScheduleDAO scheduleDAO = new ScheduleDAO();
        ArrayList<Schedule> schedules = scheduleDAO.getSchedules(from, to);
        ArrayList<Schedule> schedules_1 = scheduleDAO.getSchedules_1();
        ArrayList<Schedule> arrayList = new ArrayList<>();
        arrayList.addAll(schedules);
        arrayList.addAll(schedules_1);
        request.setAttribute("schedules", arrayList);
        request.setAttribute("dateDay", dateDay);
        request.setAttribute("dateMonth", dateMonth);
        request.getRequestDispatcher("list.jsp").forward(request, response);
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
