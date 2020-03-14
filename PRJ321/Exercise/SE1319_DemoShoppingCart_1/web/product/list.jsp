<%-- 
    Document   : list
    Created on : Oct 9, 2019, 4:56:11 PM
    Author     : sonnt
--%>

<%@page import="model.Order"%>
<%@page import="model.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
            ArrayList<Product> products = (ArrayList<Product>) session.getAttribute("products");
            Order order = (Order) session.getAttribute("cart");
            int quantity = order!=null?order.getLines().size():0;
        %>
    </head>
    <body>
        View your <a href="../order/cart">Cart(<%=quantity%>)</a>
        <table border="1px"> 
            <tr>
                <td>Product</td>
                <td>Price</td>
                <td></td>
            </tr>
            <% for (Product p : products) {
            %>
            <tr>
                <td><%=p.getName()%></td>
                <td><%=p.getPrice()%></td>
                <td>
                    <form action="../order/cart" method="post">
                        <input type="hidden" name="pid" value="<%=p.getId()%>"/>
                        <input type="submit" value="Buy"/>
                    </form>
                </td>
            </tr>
            <%}%>
        </table>
    </body>
</html>
