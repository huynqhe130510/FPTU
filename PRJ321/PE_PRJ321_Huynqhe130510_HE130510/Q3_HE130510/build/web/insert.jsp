<%-- 
    Document   : insert
    Created on : Nov 9, 2019, 11:41:06 AM
    Author     : huyNguyen
--%>

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
            Userid : <input type="text" name="id"><br>
            Password : <input type="password" name="pass"><br>
            <input type="text" value="" hidden="">
            <c:forEach items="${requestScope.groups}" var="g">
                <input type="checkbox" name="gid" value="${g.id}" />${g.name}<br>
            </c:forEach>
            <input type="submit" value="Add">
        </form>
    </body>
</html>
