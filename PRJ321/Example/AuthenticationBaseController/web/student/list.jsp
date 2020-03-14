<%-- 
    Document   : list
    Created on : Sep 25, 2018, 11:31:05 AM
    Author     : sonnt
--%>

<%@page import="model.StudentModel"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List of Students</title>
        <%
          ArrayList<StudentModel> students = (ArrayList<StudentModel>)
                  request.getAttribute("students");
        %>
    </head>
    <body>
        <table border = "1px"> 
            <tr>
                <th>Name</th>
                <th>DOB</th>
                <th>Gender</th>
            </tr>
         <% for(StudentModel s : students){ %>   
            <tr>
                <th><a href="edit?id=<%=s.getId()%>"> <%=s.getName()%> </a></th>
                <th><%=s.getDob()%></th>
                <th>
                    <input type="checkbox" disabled="disabled" <%=s.isGender()?"checked":""%> />
                </th>
            </tr>
         <%}%>
        </table>
        <a href="insert"> Insert </a>
    </body>
</html>
