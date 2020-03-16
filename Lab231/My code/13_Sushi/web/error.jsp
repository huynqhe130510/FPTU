<%-- 
    Document   : error
    Created on : Feb 29, 2020, 10:39:28 AM
    Author     : huyNguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>Error Page</title>
    </head>
    <body>
        <div class="err">
            <div class="error">${error}</div>
            <div class="return"><a href="home">Return home</a></div>
        </div>
    </body>
</html>
