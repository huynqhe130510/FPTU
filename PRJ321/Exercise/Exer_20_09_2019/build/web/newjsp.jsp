<%-- 
    Document   : newjsp
    Created on : Sep 20, 2019, 5:12:40 PM
    Author     : huyNguyen
--%>

<%@page import="model.Employee"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>JSP Page</title>
    </head>
    <body>
        <table border = 1>
            <tr>
                <td>Id</td>
                <td>Name</td>
                <td>DoB</td>
                <td>Gender</td>
            </tr>

            <%
                List<Employee> list = (ArrayList<Employee>) request.getAttribute("data");
                for (Employee employee : list) {%>

            <tr>
                <td><%=employee.getId()%></td>
                <td><%=employee.getName()%></td>
                <td><%=employee.getDate()%></td>
                <td><% if (employee.isBit() == true) {
                        out.println("<img src='https://static.thenounproject.com/png/583025-200.png' width = '20px' height = '20px'>");
                    } else {
                        out.println("<img src='https://image.flaticon.com/icons/png/512/38/38373.png' width = '20px' height = '20px'>");
                    }%> 
                </td>
            </tr>

            <%}
            %>

        </table>
    </body>
</html>
