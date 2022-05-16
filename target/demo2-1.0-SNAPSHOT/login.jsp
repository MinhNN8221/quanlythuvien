<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: MinhNN
  Date: 4/16/2022
  Time: 11:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="./css/login.css">
</head>

<body>
<c:if test="${param.error=='sai'}">
    <h3 style="color: red">Sai tên đăng nhập hoặc mật khẩu</h3>
</c:if>
<div id="login">
    <form action="login" method="post">
        <h3 id="text">Đăng nhập hệ thống quản lý thư viện</h3>
        <label><b>Tài khoản</b></label><br>
        <input class="login" type="text" name="username" size="35px" placeholder="Nhập tên người dùng"><br>
        <label><b>Mật khẩu</b></label><br>
        <input class="login" type="password" name="password" size="35px" placeholder="Nhập mật khẩu"><br>
        <input type="submit" value="Đăng nhập" id="btn">
    </form>
</div>
</body>
</html>