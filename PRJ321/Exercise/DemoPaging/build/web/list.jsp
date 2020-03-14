<%-- 
    Document   : list
    Created on : Oct 14, 2019, 8:13:11 AM
    Author     : sonnt
--%>

<%@page import="util.HtmlHelper"%>
<%@page import="model.Dummy"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
            ArrayList<Dummy> dummies = 
            (ArrayList<Dummy>)request.getAttribute("dummies");
            Integer pageindex = (Integer)request.getAttribute("pageindex");
            Integer pagecount = (Integer)request.getAttribute("pagecount");
        %>
        <link href="css/paging.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <form action="list" method="post">
            <input type="text" name="search">
            <input type="submit" value="Search">
        </form>
        <%=HtmlHelper.pager(pageindex, pagecount, 2, (String)session.getAttribute("search")) %>
        <table>
            <tr>
                <th>Id</th>
                <th>Name</th>
            </tr>
            <%for (Dummy d : dummies) {
            %>
            <tr>
                <td><%=d.getId() %></td>
                <td><%=d.getName()%></td>
            </tr>
            <%}%>
        </table>  
            <%=HtmlHelper.pager(pageindex, pagecount, 2, (String)session.getAttribute("search")) %>
    </body>
</html>
