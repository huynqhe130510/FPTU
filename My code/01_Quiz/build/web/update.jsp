<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>Update Quiz</title>
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
            <div class="title">Update quiz</div>
            <div class="content">
                <form action="update" method="post">
                    <table>
                        <tr>
                            <td>Question: </td>
                            <td><textarea name="question">${q.question}</textarea></td>
                        </tr>
                        <tr>
                            <td>Option 1: </td>
                            <td><input type="text" name="o1" value="${q.o1}"/></td>
                            <td><input type="hidden" name="id" value="${q.id}"/></td>
                        </tr>
                        <tr>
                            <td>Option 2: </td>
                            <td><input type="text" name="o2" value="${q.o2}"/></td>
                        </tr>
                        <tr>
                            <td>Option 3: </td>
                            <td><input type="text" name="o3" value="${q.o3}"/></td>
                        </tr>
                        <tr>
                            <td>Option 4:</td>
                            <td><input type="text" name="o4" value="${q.o4}"/></td>
                        </tr>
                        <tr>
                            <td>Answer(s): </td>
                            <td>

                                <input type="checkbox" name="answer" value="1" 
                                       <c:forEach items="${q.answer}" var="i">
                                           <c:if test="${i=='1'}" >checked=""</c:if>
                                       </c:forEach>/>Option 1
                                <input type="checkbox" name="answer" value="2" 
                                       <c:forEach items="${q.answer}" var="i">
                                           <c:if test="${i=='2'}" >checked=""</c:if>
                                       </c:forEach>/>Option 2
                                <input type="checkbox" name="answer" value="3" 
                                       <c:forEach items="${q.answer}" var="i">
                                           <c:if test="${i=='3'}" >checked=""</c:if>
                                       </c:forEach>/>Option 3
                                <input type="checkbox" name="answer" value="4" 
                                       <c:forEach items="${q.answer}" var="i">
                                           <c:if test="${i=='4'}" >checked=""</c:if>
                                       </c:forEach>/>Option 4
                            </td>
                        </tr>
                        <tr>
                            <td></td>
                            <td>
                                <input type="submit" value="Update"/>
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </body>
</html>
