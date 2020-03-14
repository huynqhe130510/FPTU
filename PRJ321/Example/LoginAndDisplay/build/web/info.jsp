

<%@page import="util.SessionHelper"%>
<%@page import="model.User"%>
<%@page import="model.Group"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <%
            ArrayList<Group> groups = (ArrayList<Group>) request.getAttribute("groups");
        %>
    </head>
    <body>
        <table border="1">
            <tr>
                <td>Id</td>
                <td>Name</td>
            </tr>
            <% for (Group g : groups) {%>
            <tr>
                <td><%= g.getId()%></td>
                <td><%= g.getName()%></td>
            </tr>
            <%}%>
        </table>
    </body>
</html>
