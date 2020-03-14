<%-- 
    Document   : create
    Created on : Nov 6, 2019, 9:46:25 PM
    Author     : huyNguyen
--%>

<%@page import="model.User"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <%
            ArrayList<User> users = (ArrayList<User>) request.getAttribute("users");
        %>
    </head>
    <body>
        <form action="create" method="post">
            <table border="1">
                <tr>
                    <td>To</td>
                    <td><select name="to">
                            <%for (User u : users) {
                            %>
                            <option value="<%=u.getId()%>" ><%=u.getId()%></option>
                            <%}%>
                        </select>  </td>
                </tr>
                <tr>
                    <td>title</td>
                    <td><input type="text" name="title"></td>
                </tr>
                <tr>
                    <td>Content</td>
                    <td><textarea rows="10" cols="25" name="content"></textarea></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Save"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
