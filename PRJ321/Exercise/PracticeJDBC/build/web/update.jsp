<%-- 
    Document   : update
    Created on : Sep 25, 2019, 5:12:36 PM
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
        <form align ="left" action="<%=request.getContextPath()%>/update" method="POST">
            ID <input type="text" name="id" value="<%=request.getParameter("id")%>"><br>
            Name: <input type="text" name="name" ><br>
            Date of Birth: <input type="text" name="dob"><br>
            Gender: <select name="gender"><br>
                <option value="1">Male</option>
                <option value="0">Female</option>
            </select><br>
        <input type="submit" value="Update">
    </form>
</body>
</html>
