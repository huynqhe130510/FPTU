<%-- 
    Document   : home
    Created on : Feb 23, 2020, 9:58:07 AM
    Author     : huyNguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>My front page</title>
    </head>
    <body>
        <div class="container">
            <div class="header">
                <div class="link">
                    <a href="home"><b>My front page</b></a>
                    <c:forEach items="${gallerys}" var="i">
                            <a href="picture?id=${i.id}">Gallery ${i.id}</a>
                    </c:forEach>
                    <a href="contact">Contact</a>
                </div>
                <div class="title">
                    <a href="home"><div class="webTitle">
                            <img src="image/logo.jpg">
                            PHOTOGRAPHER
                        </div>
                    </a>
                    <h2>Welcome to this website</h2>
                </div>
            </div>
            <div class="content">
                <div class="left">
                    <div class="gallery">
                        <div class="titleImg">
                            <img src="image/i4.jpg" width="700px" height="500px">
                            <i><p>Lorem ipsum dolor sit amet</p></i>
                        </div>
                        <div class="items">
                            <c:forEach items="${gallerys}" var="i">
                                <div class="item">
                                    <div><img src="image/${i.pictureCover}" width="220px" height="170px" ></div>
                                    <div><a class="viewGallery" href="picture?id=${i.id}">View ${i.name}</a></div>
                                    <div class="description">${i.description}</div>
                                </div>
                            </c:forEach>
                        </div>

                    </div>
                    <div class="about">
                        <div class="about_me">About me</div>
                        <div class="aboutText">${contact.about_me}</div>
                    </div>
                </div>
                <div class="right">
                    <div class="share">
                        <div class="sharePage">Share this page</div>
                        <a class="social" href="#">
                            <div class="fb">
                                Share on Facebook
                            </div>
                        </a>
                        <a class="social" href="#">
                            <div class="twitter">
                                Share on Twitter
                            </div>
                        </a>
                    </div>
                </div>
            </div>
            <div class="footer">
                <div class="number">0  9  5  7  9  6</div>
            </div>
        </div>
    </body>
</html>
