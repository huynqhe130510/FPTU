<%-- 
    Document   : insert
    Created on : Sep 25, 2018, 11:39:44 AM
    Author     : sonnt
--%>

<%@page import="model.DepartmentModel"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Student</title>
        <%
            ArrayList<DepartmentModel> depts = 
                    (ArrayList<DepartmentModel>)request.getAttribute("departments");
        %>
    </head>
    <body>
        <form action="insert" method="POST">
            ID: <input type="number" name="id"/> <br/>
            Name: <input type="text" name="name"/> <br/>
            DOB: <input type="date" name="dob"/> <br/>
            Gender: 
            Male <input type="radio" checked="checked" name="gender" value="male" /> 
            Female <input type="radio" name="gender" value="female" />
            <br/>
            Departments: <select name="did">
                <%for(DepartmentModel d : depts){ %>
                <option value="<%=d.getId()%>" ><%=d.getName()%></option>
                <%}%>
            </select>    
            <br/>
            <input type="reset" value="Reset"/>
            <input type="submit" value="Save"/>
        </form>    
    </body>
</html>
