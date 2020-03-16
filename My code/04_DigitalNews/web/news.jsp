<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.News"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>News</title>
    </head>
    <body>
        <div class="boddy">
            <div class="pre"></div>
            <div class="header"><h1>My Digital News</h1></div>
            <div class="menu"><h4>News</h4></div>
            <div class="content">
                <div class="left">
                    <table border="0">
                        <tr>
                            <td><h3><div class="title">${news.title}</div></h3></td>
                        </tr>
                        <tr>
                            <td><img class="img" src="image/${news.image_link}"></td>
                        </tr>
                        <tr>
                            <td><div class="text">${news.content}</div></td>
                        </tr>
                        <tr>
                            <td><div class="publisher">${news.writer} | ${news.date_published}</div></td>
                        </tr>
                    </table>
                </div>

                <div class="right">
                    <table border="0">
                        <tr>
                            <td>
                                <h3>Digital News</h3>
                                ${lastest.short_content}
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <h3>Search</h3>
                                <form action="news" method="post">
                                    <input type="text" name="searchInput" />
                                    <input type="submit" value="Go" />
                                </form>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <h3>Last Articles</h3>
                                <c:forEach items="${top5}" var="i">
                                    <a href="news?id=${i.id}"><div class="lineTitle">${i.title}</div></a><br>
                                    </c:forEach>
                            </td>
                        </tr>
                    </table>
                </div>
            </div>
            <div class="footer"></div>
        </div>
    </body>
</html>
