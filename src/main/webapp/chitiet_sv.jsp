<%--
  Created by IntelliJ IDEA.
  User: MinhNN
  Date: 5/8/2022
  Time: 6:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="header.jsp"%>
<body>
<h3 class="success" style="color: rgba(8, 245, 221, 0.8);">${err}</h3>
<div class="border-qlms">
    <div class="header">
        <h2 class="name">Thông tin chi tiết sinh viên mượn sách</h2>
    </div>
    <table>
        <thead>
        <tr>
            <th>Tên sinh viên</th>
            <th>Mã sinh viên</th>
            <th>Lớp</th>
            <th>Thông tin liên hệ</th>
            <th>Gửi email thông báo</th>
        </tr>
        </thead>
        <tbody>
            <tr>
                <td>${sinhvien.ten_sv}</td>
                <td>${sinhvien.ma_sv}</td>
                <td>${sinhvien.lop}</td>
                <td>${sinhvien.email}</td>
                <td>
                    <form action="email" method="post">
                        <button id="xoa" class="button" type="submit" name="email" value="${sinhvien.ma_sv}">Thông báo</button>
                    </form>
                </td>
            </tr>
        </tbody>
    </table>
</div>
</div>
</body>
</html>
