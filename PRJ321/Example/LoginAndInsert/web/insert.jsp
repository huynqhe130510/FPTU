<%-- 
    Document   : insert
    Created on : Oct 31, 2019, 3:58:19 PM
    Author     : huyNguyen
--%>

<%@page import="util.SessionHelper"%>
<%@page import="model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
      <%
          User user = SessionHelper.getAccountFromSession(session);
      %>
    </head>
    <body>
        <form action="insert" method="post">
            From <input type="date" name="from"/> <br/>
            To <input type="date" name="to"/> <br/>
            Reason <input type="text" name="reason" required=""><br>
            <input type="hidden" name="username" value="<%= user.getUsername() %>">
            <input type="submit" value="Insert">
        </form>
    </body>
</html>
