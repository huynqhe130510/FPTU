<%-- 
    Document   : insert
    Created on : Sep 26, 2019, 6:08:14 PM
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
        <form action="<%=request.getContextPath()%>/insert" method="POST">
            ID <input type="text" name="id"><br>
            Name: <input type="text" name="name" ><br>
            Date of Birth: <input type="text" name="dob"><br>
            Gender: <select name="gender"><br>
                <option value="1">Male</option>
                <option value="0">Female</option>
            </select><br>
            DepartmentID: <input type="text" name="did" required=""><br>
            <input type="submit" value="Add">
        </form>
    </body>
</html>
