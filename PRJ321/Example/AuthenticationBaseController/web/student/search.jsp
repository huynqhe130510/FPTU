<%-- 
    Document   : search
    Created on : Oct 4, 2018, 9:37:39 AM
    Author     : sonnt
--%>

<%@page import="model.StudentModel"%>
<%@page import="model.DepartmentModel"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Students</title>
        <%
            ArrayList<DepartmentModel> depts
                    = (ArrayList<DepartmentModel>) request.getAttribute("depts");
            ArrayList<StudentModel> students = (ArrayList<StudentModel>) request.getAttribute("students");
        %>
    </head>
    <body>
        <form action="search" method="GET" >
            ID: <input type="number" name="id"/> <br/>
            Name: <input type="text" name="name"/> <br/>
            From DOB: <input type="date" name="from"/> <br/>
            To DOB: <input type="date" name="to"/> <br/>
            Gender: 
            Both <input type="radio" checked="checked" name="gender" value="both" /> 
            Male <input type="radio" name="gender" value="male" /> 
            Female <input type="radio" name="gender" value="female" />
            <br/>
            Departments: <select name="did">
                <option value="-1">......</option>
                <%for (DepartmentModel d : depts) {%>
                <option value="<%=d.getId()%>" ><%=d.getName()%></option>
                <%}%>
            </select>    
            <br/>
            <input type="submit" value="Search"/>
        </form> 
        <table border = "1px"> 
            <tr>
                <th>Name</th>
                <th>DOB</th>
                <th>Gender</th>
                <th>Department</th>
            </tr>
            <% for (StudentModel s : students) {%>   
            <tr>
                <th><a href="edit?id=<%=s.getId()%>"> <%=s.getName()%> </a></th>
                <th><%=s.getDob()%></th>
                <th>
                    <input type="checkbox" disabled="disabled" <%=s.isGender() ? "checked" : ""%> />
                </th>
                <th><%=s.getDepartment().getName()%></th>
            </tr>
            <%}%>
        </table>
    </body>
</html>
