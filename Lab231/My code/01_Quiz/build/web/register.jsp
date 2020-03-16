<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>Register</title>
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
            <div class="title">Registration Form</div>
            <div class="content">
                <form action="register" method="post">
                    <table>
                        <tr>
                            <td>User Name: </td>
                            <td>
                                <input type="text" name="username" required=""/>
                            </td>
                        </tr>
                        <tr>
                            <td>Password: </td>
                            <td>
                                <input type="password" name="password" required=""/>
                            </td>
                        </tr>
                        <tr>
                            <td>User Type: </td>
                            <td>
                                <select name="type">
                                    <c:forEach items="${types}" var="i">
                                        <option value="${i.id}"> ${i.name}</option>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Email:  </td>
                            <td>
                                <input type="text" name="email" />
                            </td>
                        </tr>
                        <tr>
                            <td></td>
                            <td>
                                <input type="submit" value="Register"/>
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </body>
</html>
