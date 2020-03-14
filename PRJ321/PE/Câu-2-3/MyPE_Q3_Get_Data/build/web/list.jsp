<%-- 
    Document   : list
    Created on : Nov 7, 2019, 9:36:19 AM
    Author     : huyNguyen
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
            ArrayList<model.Character> characters = (ArrayList<model.Character>) request.getAttribute("characters");
        %>
    </head>
    <body>
        <table border="1">
            <tr>
                <td>ID</td>
                <td>Name</td>
                <td>Gender</td>
                <td>Created Date</td>
                <td>Skill</td>
            </tr>
            <% for (model.Character c : characters) {%>
            <tr>
                <td><%= c.getId()%></td>
                <td><%= c.getName()%></td>
                <td><%= c.isGender()%></td>
                <td><%= c.getDate()%></td>
                <td><% for (int i = 0; i < c.getS().size(); i++) {%>
                    <ul>  <%=c.getS().get(i).getName()%> </ul>
                    <%}%></td>
            </tr>
            <%}%>
        </table>
    </body>
</html>
