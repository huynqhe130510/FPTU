<%-- 
    Document   : ListGroups
    Created on : Nov 3, 2019, 5:05:57 PM
    Author     : huyNguyen
--%>

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
                <td>Group Name</td>
                <td>Description</td>
            </tr>
            <% for (Group g : groups) {%>
            <tr>
                <td><%= g.getId() %></td>
                <td><%= g.getName()%></td>
                <td><%= g.getDescription()%></td>
            </tr>  
            <%}%>
        </table>
        <a href="addGroup"><button>Add Group</button></a>  <a href="list"><button>List Contact</button></a>
    </body>
</html>
