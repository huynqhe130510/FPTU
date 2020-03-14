
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
        <canvas id="myCanvas" width="500" height="500" style="border: 1px solid black;" ></canvas>
        <script>
            <% List<Circle> circles = (ArrayList<Circle>) request.getAttribute("data");%>
            var canvas = document.getElementById("myCanvas");
            var ctx = canvas.getContext("2d");
            function Ball(x, y, r, speed, vertical, horizontal, color, Height, Width) {
                this.x = x;
                this.y = y;
                this.r = r;
                this.speed = speed;
                this.vertical = vertical;
                this.horizontal = horizontal;
                this.color = color;
                this.Height = Height;
                this.Width = Width;
                this.draw = function (context) {
                    context.beginPath();
                    context.arc(this.x, this.y, this.r, 0, 2 * Math.PI, false);
                    context.strokeStyle = this.color;
                    context.lineWidth = 3;
                    context.stroke();
                };
                this.move = function () {
                    if (this.vertical) {
                        this.y -= speed;
                        if (this.y <= this.r) {
                            this.vertical = false;
                        }
                    } else {
                        this.y += speed;
                        if (this.y >= this.Height - this.r) {
                            this.vertical = true;
                        }
                    }
                    if (this.horizontal) {
                        this.x += speed;
                        if (this.x >= this.Width - this.r) {
                            this.horizontal = false;
                        }
                    } else {
                        this.x -= speed;
                        if (this.x <= this.r) {
                            this.horizontal = true;
                        }
                    }
                };
                this.stop = function () {
                    if (this.speed > 0) {
                        this.speed = 0;
                    } else
                        this.speed = speed;
                };
            }
            var balls = [];
            var startAlready = 0;
            window.onload = function () {
                var canvas = document.getElementById("myCanvas");
                var context = canvas.getContext("2d");
            <%
                for (Circle circle : circles) {
            %>
                var r = <%=circle.getRadius()%>
                var x = <%=circle.getX()%>
                var y = <%=circle.getY()%>
                var speed = Math.floor(Math.random() * 5) + 1;
                var vertical = Math.random() > 0.5 ? true : false;
                var horizontal = Math.random() > 0.5 ? true : false;
                var color = 'rgb(' + <%=circle.getR()%> + ',' + <%=circle.getG()%> + ',' + <%=circle.getB()%> + ')';
                ball = new Ball(x, y, r, speed, vertical, horizontal, color, canvas.height, canvas.width);
                balls.push(ball);
            <%}%>
                setInterval(animate, 10);
            };
            function animate() {
                var canvas = document.getElementById("myCanvas");
                var context = canvas.getContext("2d");
                context.clearRect(0, 0, canvas.width, canvas.height);
            <%for (int i = 0; i < circles.size(); i++) {%>
                balls[<%=i%>].draw(context);
                balls[<%=i%>].move();

            <%}%>
                jQuery("#myCanvas").click(function (e) {
                    var x = e.pageX - e.target.offsetLeft;
                    var y = e.pageY - e.target.offsetTop;
                    var i = 0;
                    if (isIntersect(x, y, ball.x, ball.y, ball.r)) {
                        ball.speed = 0;
                    }
                });
            }
            function isIntersect(x, y, x1, y1, r) {
                return Math.sqrt((x - x1) * 2 + (y - y1) * 2) < r;
            }
        </script>
    </body>

</html>