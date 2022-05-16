<%--
  Created by IntelliJ IDEA.
  User: MinhNN
  Date: 4/16/2022
  Time: 11:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Quản lý thư viện</title>
    <link rel="stylesheet" href="./css/header.css">
    <link rel="stylesheet" href="./css/ql_sach.css">
    <link rel="stylesheet" href="./css/chinhsua_sach.css">
    <script src="https://kit.fontawesome.com/8318d3271c.js" crossorigin="anonymous"></script>
</head>
<body>
<div class="head">
    <a href="home.jsp"><i class="fas fa-home"></i>Trang chủ</a>
    <a href="${pageContext.request.contextPath}/qlsach">Quản lý sách</a>
    <div class="dropdown">
        <button class="nut_dropdown">Thông tin sách</button>
        <div class="noidung_dropdown">
            <a href="themloaisach.jsp">Thể loại</a>
            <a href="themtacgia.jsp">Tác giả</a>
            <a href="themvitri.jsp">Vị trí</a>
        </div>
    </div>
    <div class="dropdown">
        <button class="nut_dropdown">Quản lý mượn sách</button>
        <div>
            <div class="noidung_dropdown">
                <a href="${pageContext.request.contextPath}/qlmuon">Danh sách sinh viên mượn</a>
                <a href="${pageContext.request.contextPath}/qltra">Danh sách sinh viên đã trả</a>
            </div>
        </div>
    </div>

    <a href="${pageContext.request.contextPath}/themsv">Thêm người đọc</a>
    <div class="dropdown">
        <button class="nut_dropdown"><i class="far fa-user"></i> Tài khoản</button>
        <div>
            <div class="noidung_dropdown">
<%--                <a href="#">Đổi mật khẩu</a>--%>
                <a href="login.jsp">Đăng xuất</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>
