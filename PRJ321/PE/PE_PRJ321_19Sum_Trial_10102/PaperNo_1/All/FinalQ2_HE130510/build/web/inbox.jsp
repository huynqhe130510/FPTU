<%-- 
    Document   : inbox
    Created on : Nov 6, 2019, 8:33:52 PM
    Author     : huyNguyen
--%>

<%@page import="model.Message"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
            ArrayList<Message> messages = (ArrayList<Message>) request.getAttribute("messages");
        %>
    </head>
    <body>
        <a href="create">Create Message</a>
        <table border="1">
            <tr>
                <td>Title</td>
                <td>From</td>
                <td>At</td>
                <td>Seen</td>
            </tr>
            <% for (Message m : messages) {%>
            <tr>
                <td><a href="message?id=<%= m.getId()%>"><%= m.getTitle()%></a></td>
                <td><%= m.getFrom()%></td>
                <td><%= m.getTime()%></td>
                <td><% if (m.isIsRead() == true) {%>
                    <img src="eye.png" alt=""/>
                    <%}%></td>
            </tr>
            <%}%>
        </table>
    </body>
</html>
