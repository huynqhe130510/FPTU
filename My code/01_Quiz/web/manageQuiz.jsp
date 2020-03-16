<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>Manage Quiz</title>
    </head>
    <body>
        <div class="container">
            <div class="top"></div>
            <div class="menu">
                <div class="link">
                    <a href="home">Home</a>
                    <a href="takeQuiz">Take Quiz</a>
                    <a href="makeQuiz">Make Quiz</a>
                    <a href="manageQuiz">Manage Quiz</a>
                    <a href="logout">Log out</a>
                </div>
            </div>
            <br>
            <div class="title">Number of questions: ${totalQues}</div>
            <div class="content">
                <table>
                    <tr>
                        <th>Question</th>
                        <th>Date Created</th>
                    </tr>

                    <c:forEach items="${questions}" var="i">
                        <tr>
                            <td>${i.question}</td> 
                            <td>${i.createdDate}</td>
                            <td>
                                <form action="update" method="get">
                                    <input type="hidden" name="id" value="${i.id}"/>
                                    <input type="submit" value="Update"/>
                                </form>
                            </td>
                            <td>
                                <form action="delete" method="post">
                                    <input type="hidden" name="id" value="${i.id}"/>
                                    <input type="submit" value="Delete"/>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </body>
</html>
