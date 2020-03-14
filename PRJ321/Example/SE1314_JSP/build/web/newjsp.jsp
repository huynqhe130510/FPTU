<%-- 
    Document   : newjsp
    Created on : Sep 18, 2019, 7:51:48 AM
    Author     : sonnt
--%>

<%@page import="model.Rect"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
            ArrayList<Rect> rects = (ArrayList<Rect>) request.getAttribute("data");
        %>
    </head>
    <body>
        <canvas id="myCanvas" width="500" height="500" style="border:1px solid #d3d3d3;">
            Your browser does not support the HTML5 canvas tag.</canvas>
        <script>
            var c = document.getElementById("myCanvas");
            var ctx = c.getContext("2d");
            
            <%
            for (Rect rect : rects) {
            %>
            ctx.beginPath();
            ctx.lineWidth = "2";
            ctx.strokeStyle = "rgb(<%=rect.getR()%>,<%=rect.getG()%>,<%=rect.getB()%>)";
            ctx.rect(<%=rect.getX()%>, <%=rect.getY()%>, <%=rect.getW()%>, <%=rect.getH()%>);
            ctx.stroke();
            <%}%>
            
        </script> 
    </body>
</html>
