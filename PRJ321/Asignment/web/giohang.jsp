<%-- 
    Document   : giohang
    Created on : Oct 12, 2019, 1:51:27 PM
    Author     : huyNguyen
--%>

<%@page import="model.Chi_Tiet_Don_Hang"%>
<%@page import="model.Don_Hang"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css">
        <link href="css/giohang.css" rel="stylesheet" type="text/css"/>
        <script src="https://kit.fontawesome.com/a076d05399.js"></script>
        <script src="jquery-3.3.1.min.js"></script>
        <script src="bootstrap/js/bootstrap.bundle.js"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Giỏ hàng</title>
        <%
            Chi_Tiet_Don_Hang chi_Tiet_Don_Hang = (Chi_Tiet_Don_Hang) session.getAttribute("chi_Tiet_Don_Hang");
        %>
    </head>
    <body>
        <div class="fixed-top">
            <div class="containerGroup">
                <a href="ao"><img src="imageFile/logo.jpg" height="100px" width="150px"></a>
                <a href="logout" class="btn btn-danger logout">Đăng xuất</a>
            </div>
        </div>
        <% if (chi_Tiet_Don_Hang == null || chi_Tiet_Don_Hang.getDon_Hangs().size() == 0) { %>
        <div class="text-center"><h2>Bạn chưa mua mặt hàng nào !</h2></div>
        <div class="row continue">
            <a href="ao" class="btn btn-primary">Quay lại mua hàng</a>
        </div>
        <%} else {%>
        <div class="row giohang">
            <div class="col-6">
                <table class="table"> 
                    <tr class="table-success">
                        <th>STT</th>
                        <th>Tên áo</th>
                        <th>Số lượng</th>
                        <th>Tổng</th>
                        <th>Xóa</th>
                    </tr>
                    <%
                        int i = 0;
                        for (Don_Hang don_Hang : chi_Tiet_Don_Hang.getDon_Hangs()) {
                            i++;
                    %>
                    <tr>
                        <th><%=i%></th>
                        <td><%=don_Hang.getAo().getTen_ao()%></td>
                        <td><%=don_Hang.getSo_luong()%></td>
                        <td><%=don_Hang.getTotal()%> VNĐ</td>
                        <td><form action="delete" method="get">
                                <input type="hidden" name="del" value="<%= don_Hang.getAo().getMa_ao()%>">
                                <button class="btn btn-danger">Xóa</button>
                            </form>
                        </td>
                    </tr>
                    <%}%>
                    <tr>
                        <th colspan="2"><h4 id="t">Tổng</h4></th>
                        <th id="tong"><h4><%=chi_Tiet_Don_Hang.getQuantity()%></h4></th>
                        <th id="tong"><h4><%=chi_Tiet_Don_Hang.getTotal()%> VNĐ</h4></th>
                    </tr>
                </table>
            </div>
            <div class="col-6">
                <form class="form-control" id="frm" action="insert" method="POST"> 
                    <table>
                        <tr>
                            <th>Tên khách hàng:</th>
                            <td><input type="text" name="ten_khack_hang" required=""><br></td>
                        </tr>
                        <tr>
                            <th>Số điện thoại: </th>
                            <td><input type="tel" name="sdt" pattern="[0-9]+" maxlength="11" required=""><br></td>
                        </tr>
                        <tr>
                            <th>Địa chỉ: </th>
                            <td><input type="text" name="dia_chi" required=""><br></td>
                        </tr>
                    </table>
            </div>
        </div>
        <div class="row buy">
            <input class="btn btn-success" type="submit" value="Mua hàng""/>
        </div>
    </form>
    <div class="row continue">
        <a href="ao" class="btn btn-primary">Tiếp tục mua hàng</a>
    </div>
    <%}%>
</body>
</html>
