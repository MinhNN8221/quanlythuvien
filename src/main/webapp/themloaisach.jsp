<%--
  Created by IntelliJ IDEA.
  User: huycao
  Date: 10/05/2022
  Time: 20:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="header.jsp" %>
</head>
<body>
<h3 class="success" style="color: rgba(8, 245, 221, 0.8);">${err}</h3>
<div class="formedit" style="height: 200px;">
    <div class="title">
        <h3>Thêm loại sách</h3>
    </div>
    <div class="khung">
        <form action="themloaisach" method="post">
            <label>Loại sách</label><br>
            <input style="margin: 5px 0" class="input" type="text" name="loaisach" placeholder="Nhập tên loại sách" required><br>
            <button type="submit" name="themloaisach" class="submit" style="width: 130px; margin-top: 10px">Thêm loại sách</button>
        </form>
    </div>

</div>

</body>
</html>