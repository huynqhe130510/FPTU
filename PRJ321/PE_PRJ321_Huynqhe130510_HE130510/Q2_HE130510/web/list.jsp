<%-- 
    Document   : list
    Created on : Nov 9, 2019, 11:12:47 AM
    Author     : huyNguyen
--%>

<%@page import="model.Student"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
            ArrayList<Student> students = (ArrayList<Student>) request.getAttribute("students");
        %>
    </head>
    <body>
        <table border="1">
            <tr>
                <td>ID</td>
                <td>Name</td>
                <td>Gender</td>
                <td>DOB</td>
                <td>Department</td>
            </tr>
            <% for (Student s : students) {%>
            <tr>
                <td><%= s.getId()%></td>
                <td><%= s.getName()%></td>
                <% if (s.isGender() == true) {%>
                <td><img src="Male-icon.png" alt=""/></td>
                    <%} else {%>
            <img src="Female-icon.png" alt=""/>
            <%}%>
            <td><%= s.getDob()%></td>
            <td><%= s.getD().getName() %></td>
        </tr>      

        <%}
        %>
    </table>
</body>
</html>
