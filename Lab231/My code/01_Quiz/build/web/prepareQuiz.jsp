<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>Prepare Quiz</title>
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

            <div class="title">Welcome ${user.username}</div>
            <div class="content">
                <form action="takeQuiz" method="post">
                    Enter number of questions: <br>
                    <input type="number" name="numOfQues" min="1" max="${maxQuestion}" required=""/>
                    <input type="submit" value="Start" />
                </form>
            </div>
        </div>
    </body>
</html>
