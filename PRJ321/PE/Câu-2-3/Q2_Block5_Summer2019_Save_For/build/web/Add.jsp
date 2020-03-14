
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:useBean id="k" class="dao.AddDAO" scope="request"/>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="add" method="post">
            <table align="center">
                <tr>
                    <td>
                        ID:
                    </td>
                    <td>
                        <input type="text" name="id">
                    </td>
                </tr>
                <tr>
                    <td>
                        Name:
                    </td>
                    <td>
                        <input type="text" name="name">
                    </td>
                </tr>
                <tr>
                    <td>
                        Gender:
                    </td>
                    <td>
                        <input type="radio" name="gender" value="1" checked>Male
                        <input type="radio" name="gender" value="0">Female
                    </td>
                </tr>
                <tr>
                    <td>
                        Skill
                    </td>
                    <td>
                    </td>
                </tr>
                <c:forEach items="${k.allSkill}" var="x">
                    <tr>
                        <td>
                            <input type="checkbox" name="${x.sid}" value="yes"> ${x.name}
                        </td>
                        <td>
                        </td>
                    </tr>
                </c:forEach>
                <tr>
                    <td>
                        <input type="submit" value="Save">
                    </td>
                    <td>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
