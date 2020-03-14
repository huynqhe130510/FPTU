<%-- 
    Document   : login
    Created on : Sep 30, 2019, 7:11:14 PM
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
        <form action="login" method="post">
            <table>
                <tr>
                    <td>User name : </td>
                    <td><input type="text" name="uname"></td>
                </tr>
                <tr>
                    <td>Password :</td>
                    <td><input type="password" name="pass"></td>
                </tr>
            </table>
            <input type="submit" value="Login">
        </form>
    </body>
</html>
