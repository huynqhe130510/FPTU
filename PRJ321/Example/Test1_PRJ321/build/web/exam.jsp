<%-- 
    Document   : exam
    Created on : Sep 27, 2019, 5:05:25 PM
    Author     : huyNguyen
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Exam"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <% ArrayList<Exam> exams = (ArrayList<Exam>) request.getAttribute("exams"); %>
    </head>
    <body>
        <table>
            <tr>
                <td>sid</td>
                <td>subid</td>
                <td>score</td>
            </tr>
            <% for (Exam exam : exams) {
            %>
            <tr>
                <td><%=exam.getStudent().getId()%></td>
                <td><%=exam.getSubject().getId()%></td>
                <td><%=exam.getScore()%></td>
            </tr>
            <%}%>
        </table>
    </body>
</html>
