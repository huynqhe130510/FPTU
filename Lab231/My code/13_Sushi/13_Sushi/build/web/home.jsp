<%@page import="model.Article"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>Home Page</title>

    </head>
    <body>
        <!--Header-->
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
                <div class="content" >
                    <img class="image" src="image/i282319414620330848._szw1280h1280_.jpg" alt=""/>
                    <table>
                        <c:forEach items="${articles}" var="i">
                            <tr>
                                <td colspan="2"><b>${i.title}</b></td>
                            </tr>
                            <tr>
                                <td><img class="imgSushi" src="image/${i.imgLink}" width="300" height="300"/></td>
                                <td class="contentItem">${i.content}</td>
                            </tr>
                        </c:forEach>
                    </table>
                    <div class="page">
                        <c:forEach items="${listCount}" var="i">
                            <c:if test="${page == i}">
                                <a class="curIndex" href="home?index=${i}">${i}</a> 
                            </c:if>
                            <c:if test="${page != i}">
                                <a href="home?index=${i}">${i}</a> 
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
