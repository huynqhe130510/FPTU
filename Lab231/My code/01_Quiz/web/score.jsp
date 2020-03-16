<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>Result</title>
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
            <div class="title">Your score ${point}(${point*10}%)</div>
            <div class="content">
                Take another test 
                <a href="takeQuiz">
                    <input type="button" value="Start"/>
                </a>
            </div>
        </div>
    </div>
</body>
</html>
