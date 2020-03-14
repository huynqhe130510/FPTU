<%-- 
    Document   : AddContact
    Created on : Nov 3, 2019, 3:45:30 PM
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
        <form action="add" method="POST">
            First Name: <input type="text" name="first"><br>
            Last Name: <input type="text" name="last"><br>
            Group: <select name="gid">
                <%for (Group g : groups) {
                %>
                <option value="<%=g.getId()%>" ><%=g.getName()%></option>
                <%}%>
            </select><br>  
            Phone Number: <input type="text" name="phone"><br>
            <input type="submit" value="Add">
        </form>
        <a href="list"><button>Return To Contact List</button></a>
    </body>
</html>
