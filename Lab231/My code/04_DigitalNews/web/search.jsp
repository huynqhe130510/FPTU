<%-- 
    Document   : search
    Created on : Feb 18, 2020, 10:43:55 AM
    Author     : Asus
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>Search</title>
    </head>
    <body>
        <div class="boddy">
            <div class="pre"></div>
            <div class="header"><h1>My Digital News</h1></div>
            <div class="menu"><h4>News</h4></div>
            <div class="content">
                <div class="left">
                    <c:if test="${searchResults.size() == 0}">
                        <div class="error"><h3>Not found !!!</h3></div>
                    </c:if>
                    <c:if test="${searchResults.size() > 0}">
                        <c:forEach items="${searchResults}" var="i">
                            <tr>
                                <td>
                                    <div class="result">
                                        <a href="news?id=${i.id}">
                                            <h3>${i.title}</h3>
                                        </a>
                                        ${i.short_content}<br>
                                        <div class="publisher">
                                            ${i.writer} | ${i.date_published}
                                        </div>
                                    </div>
                                </td>
                            </tr>
                        </c:forEach>
                        <div class="pageIndex">
                            <c:forEach items="${listCount}" var="i">
                                <c:if test="${page_Index == i}">
                                    <a class="curIndex" href="search?index=${i}">${i}</a> 
                                </c:if>
                                <c:if test="${page_Index != i}">
                                    <a href="search?index=${i}">${i}</a> 
                                </c:if>
                            </c:forEach>
                        </div>
                    </c:if>
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
                                    <input type="text" name="searchInput" required=""/>
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
