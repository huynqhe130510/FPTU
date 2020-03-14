<%-- 
    Document   : Add
    Created on : 21-Aug-2019, 16:54:21
    Author     : Hoan toan hanh phuc 
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <p align="center">${mess}</p>
        <form action="AddControl" method="post">
            <table align="center">
                <tr>
                    <td>
                        Name 
                    </td>
                    <td>
                        <input type="text" name="name"> 
                    </td>
                </tr>
                <tr>
                    <td>
                        Date 
                    </td>
                    <td>
                        <input type="text" name="date"> 
                    </td>
                    <td>
                        (yyyy-MM-dd)
                    </td>
                </tr>
                
                <tr>
                    <td>
                        Gender 
                    </td>
                    <td>
                        <input type="radio" name="gender" value="1" checked>Male 
                        <input type="radio" name="gender" value="0">Female 
                    </td>
                </tr>
                <tr>
                    <td>
                        Department 
                    </td>
                    <td>
                        <select name="dp">
                            <c:forEach items="${list}" var="x">
                                <option value="${x.departmentId}">${x.departmentName}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                         
                    </td>
                    <td>
                        <input type="submit" value="Save">
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
