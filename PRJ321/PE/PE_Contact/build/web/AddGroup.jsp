<%-- 
    Document   : AddGroup
    Created on : Nov 3, 2019, 5:14:29 PM
    Author     : huyNguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="addGroup" method="POST">
            Name: <input type="text" name="name"><br>
            Description: <input type="text" name="des"><br>
            <input type="submit" value="Add">
        </form>
        <a href="group"><button>Return To Group List</button></a>
    </body>
</html>
