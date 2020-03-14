<%-- 
    Document   : homeView
    Created on : Sep 18, 2019, 6:37:31 PM
    Author     : qa
--%>

<%@page import="java.util.List"%>
<%@page import="model.Circle"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    </head>
    <body>
        <canvas id="myCanvas" width="500" height="500" style="border: 2px solid black"></canvas>
        <script>
            function isIntersect(x, y, x1, y1, r) {
                return Math.sqrt((x - x1) ** 2 + (y - y1) ** 2) < r;
            }
            var c = document.getElementById("myCanvas");
            var ctx = c.getContext("2d");

            <%
                List<Circle> list = (ArrayList<Circle>) request.getAttribute("data");

                for (Circle circle : list) {%>
            ctx.beginPath();
            ctx.arc(<%=circle.getX()%>, <%=circle.getY()%>, <%=circle.getRadius()%>, 0, 2 * Math.PI);
            ctx.lineWidth = 3;
            ctx.strokeStyle = 'rgb(<%=circle.getR()%>,<%=circle.getG()%>,<%=circle.getB()%>)', 'border: 5px solid;';
            ctx.stroke();
            jQuery("#myCanvas").click(function (e) {
                var x = e.pageX - e.target.offsetLeft;
                var y = e.pageY - e.target.offsetTop;
                if (isIntersect(x, y, <%=circle.getX()%>, <%=circle.getY()%>, <%=circle.getRadius()%>)) {
                    alert("<%=circle.getName()%>");
                }
            });


            <%}%>


        </script>
    </body>

</html>