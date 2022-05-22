<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: MinhNN
  Date: 5/1/2022
  Time: 10:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="header.jsp"%>
<body>
<h3 class="success" style="color: rgba(8, 245, 221, 0.8);">${success}</h3>
<h3 class="success" style="color: rgba(255, 76, 62, 1);">${error}</h3>
<div class="formadd">
    <div class="title">
        <h3>Thêm người mượn sách</h3>
    </div>
    <div class="khung">
        <form action="themsv" method="post">
            <lable>Tên sinh viên</lable>
            <input type="text" class="input" name="tensv" placeholder="Nhập tên sinh viên" required><br>
            <lable>Mã sinh viên</lable>
            <input type="text" class="input" name="masv" placeholder="Nhập mã sinh viên" required><br>
            <lable>Lớp</lable>
            <input type="text" class="input" name="lopsv" placeholder="Nhập tên lớp" required><br>
            <lable>Thông tin liên hệ(email)</lable>
            <input type="email" class="input" name="email" placeholder="Nhập thông tin liên hệ" required><br>
            <label>Tên sách</label><br>
            <select name="sach" id="loaisach">
                <c:forEach items="${listsach}" var="sach">
                    <option value="${sach.getId()}">${sach.getTen_sach()}</option>
                </c:forEach>
            </select>
            <label>Số lượng</label><br>
            <input class="input" type="number" name="sl_bd" value="1" readonly><br>
            <label>Ngày phải trả</label><br>
            <input class="input" type="date" name="date" id="date"><br>
            <button type="submit" name="themsv" class="submit" value="${sach.id}">Thêm sách</button>
            <input type="button" value="Trở lại" class="submit" onclick="location.href='${pageContext.request.contextPath}/qlmuon'">
        </form>
    </div>
</div>
</body>
</html>
