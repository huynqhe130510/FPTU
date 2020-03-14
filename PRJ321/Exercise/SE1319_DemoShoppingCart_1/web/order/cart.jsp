<%-- 
    Document   : cart
    Created on : Oct 9, 2019, 5:03:33 PM
    Author     : sonnt
--%>

<%@page import="model.OrderLine"%>
<%@page import="model.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
           Order order = (Order)session.getAttribute("cart");
        %>
    </head>
    <body>
        <% if(order == null){ %>
            You did not buy anything!
        <%}else{%>
            <table border="1px"> 
            <tr>
                <td>Product</td>
                <td>Price</td>
                <td>Quantity</td>
                <td>Total</td>
            </tr>
            <% for (OrderLine l : order.getLines()) {
            %>
            <tr>
                <td><%=l.getProduct().getName() %></td>
                <td><%=l.getPrice()%></td>
                <td>
                    <%=l.getQuantity()%>
                </td>
                <td>
                    <%=l.getTotal()%>
                </td>
            </tr>
            <%}%>
            <tr>
                <td colspan="3">Total:</td>
                
                <td><%=order.getTotal()%></td>
            </tr>
        </table>
        
        <%}%>
    </body>
</html>
