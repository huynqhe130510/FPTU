<%-- 
    Document   : login
    Created on : Oct 2, 2019, 9:00:03 PM
    Author     : huyNguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css">
        <link href="css/login.css" rel="stylesheet" type="text/css"/>
        <script src="https://kit.fontawesome.com/a076d05399.js"></script>
        <script src="jquery-3.3.1.min.js"></script>
        <script src="bootstrap/js/bootstrap.bundle.js"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script>

        <title>Đăng nhập</title>
    </head>
    <body>
        <div class="fixed-top">
            <div class="containerGroup">
                <a href="#"><img src="imageFile/logo.jpg" height="100px" width="150px"></a>
            </div>
        </div>

        <div class="form-login">
            <form class="text-center border border-light p-5" action="login" method="post">
                <p class="h4 mb-4">Đăng nhập</p>
                <input type="text" name="username" class="form-control mb-4" placeholder="Tên người dùng" required>
                <input type="password" name="password" class="form-control mb-4" placeholder="Mật khẩu" required>
                <div class="d-flex justify-content-around">
                    <div>
                        <input type="checkbox" name="remember" value="remember"/> Nhớ tài khoản & mật khẩu
                    </div>
                </div>
                <button class="btn btn-info btn-block my-4" type="submit">Đăng nhập</button>
            </form>
        </div>
    </body>
</html>
