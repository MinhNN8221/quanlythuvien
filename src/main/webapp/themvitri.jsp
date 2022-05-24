<%--
  Created by IntelliJ IDEA.
  User: huycao
  Date: 10/05/2022
  Time: 20:14
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="header.jsp" %>
</head>
<body>
<h3 class="success" style="color: rgba(8, 245, 221, 0.8);">${err}</h3>
<div class="formedit"  style="height: 200px;">
    <div class="title">
        <h3>Thêm vị trí</h3>
    </div>
    <div class="khung">
        <form action="themvitri" method="post">
            <label>Vị trí</label><br>
            <input style="margin-top: 10px" class="input" type="text" name="vitri" placeholder="Nhập tên vị trí" required><br>
            <button type="submit" name="themvitri" class="submit" style="margin-top: 10px">Thêm vị trí</button>
        </form>
    </div>

</div>

</body>
</html>