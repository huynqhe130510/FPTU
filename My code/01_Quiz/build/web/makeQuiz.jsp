<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>Make Quiz</title>
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
            <div class="title">
                Make quiz
            </div>
            <div class="content">
                <form action="makeQuiz" method="post">
                    <table>
                        <tr>
                            <td>Question: </td>
                            <td><textarea name="question"></textarea></td>
                        </tr>
                        <tr>
                            <td>Option 1: </td>
                            <td><input type="text" name="o1" /></td>
                        </tr>
                        <tr>
                            <td>Option 2: </td>
                            <td><input type="text" name="o2" /></td>
                        </tr>
                        <tr>
                            <td>Option 3: </td>
                            <td><input type="text" name="o3" /></td>
                        </tr>
                        <tr>
                            <td>Option 4:</td>
                            <td>
                                <input type="text" name="o4" />
                            </td>
                        </tr>
                        <tr>
                            <td>Answer(s): </td>
                            <td>
                                <input type="checkbox" name="answer" value="1"/>Option 1
                                <input type="checkbox" name="answer" value="2"/>Option 2
                                <input type="checkbox" name="answer" value="3"/>Option 3
                                <input type="checkbox" name="answer" value="4"/>Option 4
                            </td>
                        </tr>
                        <tr>
                            <td></td>
                            <td>
                                <input type="submit" value="Save"/>
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </body>
</html>
