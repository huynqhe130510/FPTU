<%-- 
    Document   : ao
    Created on : Oct 12, 2019, 11:50:51 AM
    Author     : huyNguyen
--%>

<%@page import="model.Chi_Tiet_Don_Hang"%>
<%@page import="model.Don_Hang"%>
<%@page import="model.Ao"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css">
        <link href="css/ao.css" rel="stylesheet" type="text/css"/>
        <script src="https://kit.fontawesome.com/a076d05399.js"></script>
        <script src="jquery-3.3.1.min.js"></script>
        <script src="bootstrap/js/bootstrap.bundle.js"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bán hàng</title>

        <%
            ArrayList<Ao> aos = (ArrayList<Ao>) session.getAttribute("aos");
            Chi_Tiet_Don_Hang chi_Tiet_Don_Hang = (Chi_Tiet_Don_Hang) session.getAttribute("chi_Tiet_Don_Hang");
            int quantity = chi_Tiet_Don_Hang != null ? chi_Tiet_Don_Hang.getDon_Hangs().size() : 0;
        %>
    </head>
    <body>
        <div class="fixed-top">
            <div class="containerGroup">
                <a href="#"><img src="imageFile/logo.jpg" height="100px" width="150px"></a>
                <a href="thongke" class="btn btn-primary thongke">Thống kê</a>
                <a href="logout" class="btn btn-danger logout">Đăng xuất</a>
                <a href="mua" class="btn btn-success cart">Giỏ hàng(<%=quantity%>)</a>
            </div>
        </div>
        <div class="ao">
            <form action="ao" method="post">
                <div class="search input-group">
                    <input type="text" placeholder="Tìm kiếm" name="search"<% if (request.getParameter("search") != null)%> value="<%= request.getParameter("search")%>" class="form-control inputSearch">
                    <input class="btn btn-success" type="submit" value="Tìm kiếm">
                </div>
            </form>
            <div class="table-responsive table_ao">
                <table class="table">
                    <tr class="table-success">
                        <th>STT</th>
                        <th>Tên áo</th>
                        <th>Giá</td>
                        <th>Loại vải</th>
                        <th>Mua hàng</th>
                    </tr>
                    <% 
                        int i = 1;
                        for (Ao ao : aos) {
                    %>
                    <tr>
                        <th><%=i++%></th>
                        <td><b id="ten_ao"><%= ao.getTen_ao()%></b></td>
                        <td><%= ao.getGia()%> VNĐ</td>
                        <td><%= ao.getChat_lieu()%></td>
                        <td>
                            <form action="mua" method="post">
                                <input type="hidden" name="Ma_Ao" value="<%=ao.getMa_ao()%>"/>
                                <input class="btn btn-outline-success" type="submit" value="Mua"/>
                            </form>
                        </td>
                    </tr>
                    <%}
                    %>
                </table>
            </div>
        </div>
    </body>
</html>
