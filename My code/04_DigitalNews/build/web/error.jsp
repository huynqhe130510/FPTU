<%-- 
    Document   : error
    Created on : Feb 28, 2020, 4:27:15 PM
    Author     : huyNguyen
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>Error Page</title>
    </head>
    <body>
        <div class="error">Error : ${error}</div>
        <div class="return"><a href="news">Return Home</a></div>
    </body>
</html>
