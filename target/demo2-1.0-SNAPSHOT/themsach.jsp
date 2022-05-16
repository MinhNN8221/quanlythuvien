<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: MinhNN
  Date: 4/25/2022
  Time: 10:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="header.jsp"%>
<body>
<h3 class="success" style="color: rgba(8, 245, 221, 0.8);">${err}</h3>
<div class="formedit">
    <div class="title">
        <h3>Thêm sách</h3>
    </div>
    <div class="khung">
        <form action="themsach" method="post">
            <label>Tên sách</label><br>
            <input class="input" type="text" name="tensach" placeholder="Nhập tên sách" required><br>
            <lablel>Thể loại</lablel><br>
            <select name="loaisach" id="loaisach">
                <c:forEach items="${list_ls}" var="loaisach">
                    <option value="${loaisach.getId_ls()}">${loaisach.getTen_ls()}</option>
                </c:forEach>
            </select>
            <label>Vị trí</label><br>
            <select name="vitri" id="vitri">
                <c:forEach items="${list_vt}" var="vitri">
                    <option value="${vitri.getId_vt()}">${vitri.getTen_vt()}</option>
                </c:forEach>
            </select>
            <label>Tác giả</label><br>
            <select name="tacgia" id="tacgia" >
                <c:forEach items="${list_tg}" var="tacgia">
                    <option value="${tacgia.getId_tg()}">
                            ${tacgia.getTen_tg()}
                    </option>
                </c:forEach>
            </select>
            <label>Số lượng</label><br>
            <input class="input" type="number" name="sl_bd" min="0" required><br>
            <label>Còn lại</label><br>
            <input class="input" type="number" name="sl_cl" min="0" required><br>
            <button type="submit" name="themsach" class="submit" value="${book.id}">Thêm sách</button>
            <input type="button" value="Trở lại" class="submit" onclick="location.href='${pageContext.request.contextPath}/qlsach'">
        </form>
    </div>
</div>
</body>
</html>
