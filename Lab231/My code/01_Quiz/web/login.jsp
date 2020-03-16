<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>Login</title>
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
                </div>
            </div>
            <div class="title">
                Login Form
            </div>
            <div class="content">
                <form action="login" method="post">
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
                        <td></td>
                        <td>
                            <input type="submit" value="Sign in"/>
                            <a href="register">Register</a>
                        </td>
                    </tr>
                </table>
            </form>
            </div>
        </div>
    </body>
</html>
