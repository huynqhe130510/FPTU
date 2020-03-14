<%-- 
    Document   : ListContacts
    Created on : Nov 3, 2019, 4:49:51 PM
    Author     : huyNguyen
--%>

<%@page import="model.Contact"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <%
            ArrayList<Contact> contacts = (ArrayList<Contact>) request.getAttribute("contacts");
        %>
    </head>
    <body>
        <p>There are contains <%= contacts.size()%> contacts in the List </p>
        <table border="1">
            <tr>
                <td>Id</td>
                <td>First Name</td>
                <td>Last Name</td>
                <td>Group</td>
                <td>Phone Number</td>
                <td>Operations</td>
            </tr>
            <% for (Contact c : contacts) {%>
            <tr>
                <td><%= c.getId() %></td>
                <td><%= c.getFirstName()%></td>
                <td><%= c.getLastName()%></td>
                <td><%= c.getGroup().getName() %></td>
                <td><%= c.getPhoneNumber() %></td>
                <td><a href="edit?id=<%= c.getId() %>">Edit</a> <a href="remove?id=<%= c.getId() %>">Remove</a></td>
            </tr>  
            <%}%>
        </table>
        <a href="add"><button>Add Contact</button></a>  <a href="group"><button>List Group</button></a>
    </body>
</html>
