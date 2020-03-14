<%-- 
    Document   : employee
    Created on : Sep 24, 2019, 10:11:15 AM
    Author     : sonnt
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
        %>
        <script>
            function submitForm()
            {
                document.getElementById("searchFrm").submit();
            }

        </script>
    </head>
    <body align="center">
        <form id="searchFrm" action="list" method="get">
            <select name="did" onchange="submitForm();"> 
                <option value="-1">----------ALL----------</option>
                <% for (Department d : depts) {
                %>
                <option 
                    <%=(d.getId() == did) ? "selected" : ""%>
                    value="<%=d.getId()%>"><%=d.getName()%></option>
                <%}%>
            </select>
        </form> 

        <a href="insert"><input type="button" value="Add"></a>

        <table border =1 align="center">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>DOB</th>
                <th>Gender</th>
                <th>Department</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            <% for (Employee e : emps) {
            %>
            <tr>
                <td><%=e.getId()%></td>
                <td><%=e.getName()%></td>
                <td><%=e.getDob()%></td>
                <td>
                    <%if (e.isGender()) {%><img src="https://static.thenounproject.com/png/583025-200.png" width = "20px" height = "20px" alt=""/><%}%> 
                    <% if (!e.isGender()) {%><img src="https://image.flaticon.com/icons/png/512/38/38373.png" width = "20px" height = "20px" alt=""/><%}%> 
                </td>
                <td><%=e.getDept().getName()%></td>
                <td><a href="update?id=<%=e.getId()%>">Edit</a></td>
                <td><a href="delete?e_id=<%=e.getId()%>">Delete</a></td>
            </tr>
            <%}%>
        </table>  
    </body>
</html>
