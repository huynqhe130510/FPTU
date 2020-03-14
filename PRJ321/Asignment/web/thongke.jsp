<%-- 
    Document   : thongke
    Created on : Nov 7, 2019, 5:05:56 PM
    Author     : huyNguyen
--%>

<%@page import="model.Thong_Ke"%>
<%@page import="model.Chi_Tiet_Don_Hang"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css">
        <link href="css/thongke.css" rel="stylesheet" type="text/css"/>
        <script src="https://kit.fontawesome.com/a076d05399.js"></script>
        <script src="jquery-3.3.1.min.js"></script>
        <script src="bootstrap/js/bootstrap.bundle.js"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thống kê</title>

        <%
            ArrayList<Thong_Ke> thong_Kes = (ArrayList<Thong_Ke>) request.getAttribute("thong_Kes");
            String sum = (String) request.getAttribute("sum");
            String quantity = (String) request.getAttribute("quantity");
        %>
    </head>
    <body>
        <div class="fixed-top">
            <div class="containerGroup">
                <a href="ao"><img src="imageFile/logo.jpg" height="100px" width="150px"></a>
                <a href="ao" class="btn btn-success">Tiếp tục mua hàng</a>
                <a href="logout" class="btn btn-danger logout">Đăng xuất</a>
            </div>
        </div>
        <div class="thongke">
            <form class="form-group" action="thongke" method="post">
                Từ ngày: <input class="form-control" type="date" name="from" value="<%= request.getParameter("from")%>" >
                Đến ngày: <input class="form-control" type="date" name="to" value="<%= request.getParameter("to")%>"><br>
                <input class="btn btn-primary xem" type="submit" value="Xem">
            </form>
            <table class="table">
                <tr class="table-success">
                    <th>STT</th>
                    <th>Tên khách hàng</th>
                    <th>Số điện thoại</th>
                    <th>Địa chỉ</th>
                    <th>Tên áo</th>
                    <th>Chất liệu</th>
                    <th>Số lượng</th>
                    <th>Đơn giá</th>
                    <th>Tổng</th>
                </tr>
                <%
                    int i;
                    for (i = 0; i < thong_Kes.size(); i++) {%>
                <tr class="table">
                    <td><b><%= i + 1%></b></td>
                    <td><%= thong_Kes.get(i).getTen()%></td>
                    <td><%= thong_Kes.get(i).getSdt()%></td>
                    <td><%= thong_Kes.get(i).getDia_chi()%></td>
                    <td><%= thong_Kes.get(i).getTen_ao()%></td>
                    <td><%= thong_Kes.get(i).getChat_lieu()%></td>
                    <td class="soluong"><b><%= thong_Kes.get(i).getSo_luong()%></b></td>
                    <td><%= thong_Kes.get(i).getDon_gia()%> VNĐ</td>
                    <td class="tong"><b><%= thong_Kes.get(i).getTong()%> VNĐ</b></td>
                </tr>
                <%}%>
                <tr>
                    <td colspan="6" style="text-align: left; color: red"><h4>Tổng cộng:</h4></td>
                    <td colspan="2" style="color: red"><h4 id="quantity"><%= quantity%></h4></td>
                    <td style="color: red"><h4><%=sum%> VNĐ</h4></td>
                </tr>
            </table>
        </div>
    </body>
</html>
