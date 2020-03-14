<%-- 
    Document   : insert
    Created on : Oct 23, 2019, 4:15:17 PM
    Author     : huyNguyen
--%>

<%@page import="model.Type"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
       
    </head>
    <body>
        <form action="insert" method="post">
            ID : <input type="text" name="id"><br>
            Name : <input type="text" name="name"><br>
            <input type="text" value="" hidden="">
            <c:forEach items="${requestScope.types}" var="t">
                    <input type="checkbox" name="tid" value="${t.id}" />${t.name}<br>
             </c:forEach>
            <input type="submit" value="Save">
        </form>
    </body>
</html>
