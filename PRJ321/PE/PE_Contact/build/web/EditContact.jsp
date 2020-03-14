<%-- 
    Document   : EditContact
    Created on : Nov 3, 2019, 5:29:25 PM
    Author     : huyNguyen
--%>

<%@page import="model.Contact"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Group"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
            ArrayList<Group> groups = (ArrayList<Group>) request.getAttribute("groups");
            Contact contact = (Contact) request.getAttribute("contact");
        %>
    </head>
    <body>
        <form action="edit" method="POST">
            ID :<input type="text" readonly="" name="id" value="<%= contact.getId()%>"><br>
            First Name: <input type="text" name="first" value="<%= contact.getFirstName()%>"><br>
            Last Name: <input type="text" name="last" value="<%= contact.getLastName()%>"><br>
            Group: <select name="gid">
                <%for (Group g : groups) {
                %>
                <option <%=(g.getId() == contact.getGroup().getId()) ? "selected" : ""%> value="<%=g.getId()%>" ><%=g.getName()%></option>
                <%}%>
            </select><br>  
            Phone Number: <input type="text" value="<%= contact.getPhoneNumber()%>" name="phone"><br>
            <input type="submit" value="Edit"><br>
        </form>
        <a href="list"><button>Return To Contact List</button></a>
    </body>
</html>
