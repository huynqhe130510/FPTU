<%@page import="model.Menu"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu and Price List</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <!--Header-->
            <div class="header">
                <h1><a href="home">The Sushi Restaurant</a></h1>
                <h3>Welcome to this website</h3>
            </div>
            <div class="menu">
                <a class="menuItem" href="home">Home</a>
                <a class="menuItem" href="menu">Menu and Price list</a>
                <a class="menuItem" href="infor">Find us</a>
            </div>

            <div class="bodyy">
                <div class="content">
                    <h2>Menu and price list</h2>
                    <table border="0">
                        <c:forEach items="${menu}" var="i">
                            <tr>
                                <td><div class="row1">Menu ${i.id}</div></td>
                                <td align="right"><div class="row1">Price</div></td>
                            </tr>    
                            <tr>
                                <td>${i.name}</td>
                                <td align="right">$${i.price}</td>
                            </tr>
                            <tr>
                                <td colspan="2"><div class="row2">${i.content}</div></td>
                            </tr>
                            <tr><td><br><br></td></tr>
                                </c:forEach>
                    </table>
                    <div class="page">
                        <c:forEach items="${listCount}" var="i">
                            <c:if test="${page == i}">
                                <a class="curIndex" href="menu?index=${i}">${i}</a> 
                            </c:if>
                            <c:if test="${page != i}">
                                <a href="menu?index=${i}">${i}</a> 
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
