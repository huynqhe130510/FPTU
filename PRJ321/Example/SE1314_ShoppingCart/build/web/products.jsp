<%-- 
    Document   : products
    Created on : Oct 9, 2019, 8:09:17 AM
    Author     : sonnt
--%>

<%@page import="model.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
          ArrayList<Product> products = (ArrayList<Product>)session.getAttribute("products");
        %>
    </head>
    <body>
        <table> 
            <tr>
                <td>Product</td>
                <td>Price</td>
                <td></td>
            </tr>
            <%
                for (Product p : products) {
            %>
            <tr>
                <td><%=p.getName()%></td>
                <td><%=p.getPrice()%></td>
                <td>
                    <form action="cart" method="post">
                        <input name="pid" type="hidden" value="<%=p.getId()%>"/>
                        <input type="submit" value="Buy"/>
                    </form>
                </td>
            </tr>
            <%}%>
        </table>
    </body>
</html>
