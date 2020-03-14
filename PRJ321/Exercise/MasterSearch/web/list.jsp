<%-- 
    Document   : list
    Created on : Oct 18, 2019, 4:00:44 PM
    Author     : Asus
--%>

<%@page import="model.Employee"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Department"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
            ArrayList<Department> depts = (ArrayList<Department>) request.getAttribute("depts");
            ArrayList<Employee> emps = (ArrayList<Employee>) request.getAttribute("emps");
            Integer did = (Integer) request.getAttribute("did");
            Integer id  = (Integer) request.getAttribute("id");
            Integer gender  = (Integer) request.getAttribute("gender");
            String name = (String) request.getAttribute("name");
        %>
        
    </head>
    <body>
        <form action="list" method="post">
            ID:<input type="text" name="id" <%if(id!=0)%> value="<%=id%>" />
            Name:<input type="text" name="name" value="<%=name%>"/><br>
            Gender
            <input type="radio" name="gender" value="1"/>Male
            <input type="radio" name="gender" value="0"/>Female
            <input type="radio" name="gender" value="2" checked=""/>Both
            <br>Department
            <select name="did"> 
                <option value="0">----------ALL----------</option>
                <% for (Department d : depts) {
                %>
                <option 
                    <%=(d.getId() == did) ? "selected" : ""%>
                    value="<%=d.getId()%>"><%=d.getName()%></option>
                <%}%>
            </select>
            <br>
            Dob From <input type="date" name="dobFrom" />
            Dob To <input type="date" name="dobTo" />
            <br>
            <input type="submit" value="Search" />
        </form>
        <table border="1">
            <tr>
                <td>Id</td>
                <td>Name</td>
                <td>Dob</td>
                <td>Gender</td>
                <td>Department</td>
            </tr>
            <%for (Employee e : emps) {
            %>
            <tr>
                <td><%=e.getId()%></td>
                <td><%=e.getName()%></td>
                <td><%=e.getDob()%></td>
                <td><%=e.isGender()%></td>
                <td><%=e.getDepartment().getName()%></td>
            </tr>
            <%}%>
        </table>
    </body>
</html>
