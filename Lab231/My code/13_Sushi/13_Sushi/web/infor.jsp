<%@page import="model.Information"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Find us</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <div class="header">
                <h1><a href="home">The Sushi Restaurant</a></h1>
                <h3>Welcome to this website</h3>
            </div>
            <div class="menu">
                <a class="menuItem" href="home">Home</a>
                <a class="menuItem" href="menu">Menu and Price list</a>
                <a class="menuItem" href="infor">Find us</a>
            </div>
            <!--Body-->
            <div class="bodyy">
                <div class="content">
                    <div class="address">
                        <table>
                            <tr>
                                <td><h2>Address and Contact</h2></td>
                                <td><h2>Opening Hours</h2></td>
                            </tr>
                            <tr>
                                <td>
                                    ${address}<br>
                                    Tel: ${tel}<br>
                                    Email: ${mail}
                                </td>

                                <td>
                                    <c:forEach items="${infor}" var="i">
                                        <c:if test="${i.id > 4}">
                                            ${i.name} ${i.content}<br>
                                        </c:if>
                                    </c:forEach>
                                </td>
                            </tr>
                        </table>
                    </div>
                    <div class="map">
                        <c:forEach items="${infor}" var="i">
                            <c:if test="${i.id == 1}">
                                <img src="image/${i.content}" width="130%" height="700px" />
                            </c:if>
                        </c:forEach>
                    </div>
                </div>
                <div class="contact">
                    <div class="contactItem">
                        <h4>Share this page</h4>
                        <div><span><img src="image/fbicon.jpg" alt="" width="10px" height="15px" /></span><a href="#">Share on Facebook</a></div>
                        <div><span><img src="image/twitericon.jpg" alt="" width="10px" height="15px"/></span><a href="#">Share on Twitter</a></div>
                    </div>
                </div>
            </div>
            <div class="footer">
                <div><a href="">Created with SimpleSite</a></div>
                <div class="number">0 2 4 9 5 4</div>
            </div>
        </div>
    </body>
</html>
