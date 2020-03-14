<%-- 
    Document   : check
    Created on : Nov 6, 2019, 9:23:29 PM
    Author     : huyNguyen
--%>

<%@page import="model.Message"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
            Message m = (Message) request.getAttribute("message");
        %>
    </head>
    <body>
        <table border="1">
            <tr>
                <td>From</td>
                <td><%= m.getFrom() %></td>
            </tr>
            <tr>
                <td>Title</td>
                <td><%= m.getTitle()%></td>
            </tr>
            <tr>
                <td>Create Time</td>
                <td><%= m.getTime() %></td>
            </tr>
            <tr>
                <td>Content</td>
                <td><%= m.getContent()%></td>
            </tr>
        </table>
    </body>
</html>
