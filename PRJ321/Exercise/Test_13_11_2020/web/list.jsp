<%-- 
    Document   : list
    Created on : Nov 13, 2019, 8:44:29 AM
    Author     : huyNguyen
--%>

<%@page import="model.Schedule"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
            ArrayList<Schedule> schedules = (ArrayList<Schedule>) request.getAttribute("schedules");
            ArrayList<Integer> listDay = (ArrayList<Integer>) request.getAttribute("dateDay");
            ArrayList<Integer> listMonth = (ArrayList<Integer>) request.getAttribute("dateMonth");
        %>
    </head>
    <body>
        <form action="list" method="post">
            From: <input type="date" name="from" value="<%= request.getParameter("from")%>">
            To: <input type="date" name="to" value="<%= request.getParameter("to")%>"><br>
            <input type="submit" value="See">
        </form><br>
        <% if (listDay != null && listMonth != null) {%>
        <table border="1">
            <tr>
                <td></td>
                <% for (int i = 0; i < listDay.size(); i++) {
                        for (int j = 0; j < listMonth.size(); j++) {%>
                <td><%= listDay.get(i)%>/<%= listMonth.get(j)%></td>      
                <%}
                    }%>
            </tr>
            <%for (Schedule s : schedules) {%>
            <tr>
                <td><%= s.getRoom().getName()%></td>
                <td colspan="<%= 2%>" style="background-color: red;"></td>
            </tr>
            <%}%>
        </table>
        <%}%>
    </body>
</html>
