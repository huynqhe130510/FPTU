<%-- 
    Document   : cart
    Created on : Oct 9, 2019, 8:16:51 AM
    Author     : sonnt
--%>

<%@page import="model.Customer"%>
<%@page import="java.util.ArrayList"%>
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
            ArrayList<Customer> customers = (ArrayList<Customer>)session.getAttribute("customers");
        %>
    </head>
    <body>
        <form>
            <select>
                <%for (Customer c : customers) {
                %>
                <option value="<%=c.getId()%>"><%=c.getName()%></option>
                <%}%>
            </select>
        </form>    
        
        <table> 
            <tr>
                <td>Product</td>
                <td>Quantity</td>
                <td>Price</td>
                <td>Total</td>
            </tr>
            <% for (OrderLine line : order.getLines()) {
            %>
            <tr>
                <td><%=line.getProduct().getName()%></td>
                <td><%=line.getQuantity()%></td>
                <td><%=line.getPrice()%></td>
                <td><%=line.total()%></td>
            </tr>
            <%}%>
            <tr>
                <td colspan="3">Total</td>
                <td><%=order.total()%></td>
            </tr>
        </table>
    </body>
</html>
