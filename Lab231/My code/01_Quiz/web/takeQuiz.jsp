<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>Take Quiz</title>
        <script>
            function startTimer(duration, display) {
                var timer = duration, minutes, seconds;
                setInterval(function () {
                    minutes = parseInt(timer / 60, 10);
                    seconds = parseInt(timer % 60, 10);

                    minutes = minutes < 10 ? "0" + minutes : minutes;
                    seconds = seconds < 10 ? "0" + seconds : seconds;

                    display.textContent = minutes + ":" + seconds;

                    if (--timer < 0) {
                        document.getElementById("myForm").submit();
                    }
                }, 1000);
            }

            window.onload = function () {
                var seconds = ${num} * 60, display = document.getElementById('time');
                startTimer(seconds, display);
            };
            var currentQuestion = 0;
            function loadQuestion(index) {
                document.querySelector("#questiondiv" + index).style.display = "block";
            }
            function loadNextQuestion() {
                if (currentQuestion === ${num} - 1) {
                    document.getElementById('myForm').onsubmit = function () {
                        return true;
                    };
                    document.getElementById("myForm").submit();
                } else {

                    document.getElementById('myForm').onsubmit = function () {
                        return false;
                    };
                    document.querySelector('#questiondiv' + currentQuestion).style.display = "none";

                    currentQuestion++;
                    document.getElementById('btnpre').style.display = "inline";
                    if (currentQuestion === ${num} - 1) {
                        document.getElementById('btnnext').textContent = "Finish";
                    }

                    loadQuestion(currentQuestion);
                }
            }
            function loadPreQuestion() {
                document.getElementById('myForm').onsubmit = function () {
                    return false;
                };
                document.querySelector('#questiondiv' + currentQuestion).style.display = "none";

                currentQuestion--;
                if (currentQuestion === 0) {
                    document.getElementById('btnpre').style.display = "none";
                }
                if (currentQuestion < ${num} - 1) {
                    document.getElementById('btnnext').textContent = "Next";
                }
                loadQuestion(currentQuestion);
            }
            function submit() {
                document.getElementById('myForm').onsubmit = function () {
                    return true;
                };
                document.getElementById("myForm").submit();
            }
        </script>
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
            <div class="title"><h3>Welcome ${user.getUsername()}</h3></div>

            <div class="timer">Time remaining <span id="time"></span></div>
            <div class="content">
                <form id="myForm" action="takingQuiz" method="post">
                    <c:forEach var="i" begin="0" end="${num-1}">
                        <div id="questiondiv${i}" class="option">
                            <br>Question ${i+1}: ${question[i].question}<br>
                            <input type="hidden" name="num" value="${num}">
                            <input type="checkbox" name="q${i+1}" value="1"/>${question[i].o1}<br>
                            <input type="checkbox" name="q${i+1}" value="2"/>${question[i].o2}<br>
                            <input type="checkbox" name="q${i+1}" value="3"/>${question[i].o3}<br>
                            <input type="checkbox" name="q${i+1}" value="4"/>${question[i].o4}<br>
                        </div>
                        <script>
                            document.querySelector('#questiondiv${i}').style.display = "none";
                        </script>
                    </c:forEach>
                    <script>
                        loadQuestion(currentQuestion);
                    </script>
                    <button id="btnpre" onclick="loadPreQuestion();" style="display: none;">Previous</button>
                    <button id="btnnext" onclick="loadNextQuestion();">Next</button>
                    <button id="btnsubmit" onclick="submit();">Submit</button>
                </form>
            </div>
        </div>
    </body>
</html>
