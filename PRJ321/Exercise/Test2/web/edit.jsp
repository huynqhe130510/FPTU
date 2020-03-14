<%-- 
    Document   : edit
    Created on : Oct 21, 2019, 4:38:14 PM
    Author     : huyNguyen
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Classes"%>
<%@page import="model.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
            Student s = (Student) request.getAttribute("student");
            ArrayList<Classes> list = (ArrayList<Classes>) request.getAttribute("classes");
        %>
    </head>
    <body>
        <table>
            <form action="edit" method="POST">
                <tr>
                    <td>ID</td>
                    <td><input type="text" name="id" value="<%=request.getParameter("id")%>"></td>
                </tr>
                <tr>
                    <td>Name</td>
                    <td>
                        <input type="text" name="name" value="<%=s.getName()%>">
                    </td>
                </tr>
                <tr>
                    <td>Date Of Birth</td>
                    <td>
                        <input type="text" name="dob" value="<%=s.getDob()%>">
                    </td>
                </tr>
                <tr>
                    <td>Gender</td>
                    <td>
                        <input type="radio" name="gender" value="1" <%=(s.isGender() ? "checked" : "")%> />Male
                        <input type="radio" name="gender" value="0" <%=(!s.isGender() ? "checked" : "")%> />Female
                    </td>
                </tr>
                <tr>
                    <td>Class</td>
                    <td>
                        <select name="did">
                            <%for (Classes d : list) {
                            %>
                            <option <%=(d.getId() == s.getClasses().getId()) ? "selected" : ""%> value="<%=d.getId()%>" ><%=d.getName()%></option>
                            <%}%>
                        </select>  
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" value="Save">
                    </td>
                </tr>
            </form>
        </table>
    </body>
</html>
