<%-- 
    Document   : product
    Created on : Oct 4, 2019, 5:05:28 PM
    Author     : huyNguyen
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
            ArrayList<Product> products = (ArrayList<Product>) request.getAttribute("products");
        %>
    </head>
    <body>
        <a href="">View Cart</a>
        <table border="1">
            <tr>
                <td>Product</td>
                <td>Price</td>
                <td>Buy</td>
            </tr>
            <%
                for (Product product : products) {%>
            <tr>
                <td><%=product.getName()%></td>
                <td><%=product.getPrice()%></td>
                <td><button>Buy</button></td>
            </tr>
            <%}
            %>
        </table>
    </body>
</html>
