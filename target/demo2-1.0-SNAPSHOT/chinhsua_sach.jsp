<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--  Created by IntelliJ IDEA.
  User: MinhNN
  Date: 4/24/2022
  Time: 9:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="header.jsp"%>
<body>
<h3 class="success" style="color: rgba(8, 245, 221, 0.8);">${err}</h3>
<div class="formedit">
    <div class="title">
        <h3>Chỉnh sửa sách</h3>
    </div>
    <div class="khung">
        <form action="${pageContext.request.contextPath}/chinhsua" method="post">
            <input type="hidden" name="id" value="${book.id}" />
            <label>Tên sách</label><br>
            <input class="input" type="text" name="tensach" value="${book.getTen_sach()}" required><br>
            <lablel>Thể loại</lablel><br>
            <select name="loaisach" id="loaisach">
                <c:forEach items="${list_ls}" var="loaisach">
                    <option value="${loaisach.getId_ls()}"
                        <c:if test="${loaisach.getId_ls()==book.getLoai_sach().getId_ls()}">selected="true"</c:if>>
                    ${loaisach.getTen_ls()}
                    </option>
                </c:forEach>
            </select>
            <label>Vị trí</label><br>
            <select name="vitri" id="vitri">
                <c:forEach items="${list_vt}" var="vitri">
                    <option value="${vitri.getId_vt()}"
                        <c:if test="${vitri.getId_vt()==book.getVi_tri().getId_vt()}">selected="true"</c:if>>
                    ${vitri.getTen_vt()}
                    </option>
                </c:forEach>
            </select>
            <label>Tác giả</label><br>
            <select name="tacgia" id="tacgia">
                <c:forEach items="${list_tg}" var="tacgia">
                    <option value="${tacgia.getId_tg()}"
                        <c:if test="${tacgia.getId_tg()==book.getTac_gia().getId_tg()}">selected="true"</c:if>>
                    ${tacgia.getTen_tg()}
                    </option>
                </c:forEach>
            </select>
            <label>Số lượng</label><br>
            <input class="input" type="number" min="1" name="sl_bd" value="${book.sl_bd}" required><br>
            <label>Còn lại</label><br>
            <input class="input" type="number" min="0" name="sl_cl" value="${book.sl_cl}" required><br>
            <button type="submit" name="capnhat" class="submit" value="${book.id}">Cập nhật</button>
            <input type="button" value="Trở lại" class="submit" onclick="location.href='${pageContext.request.contextPath}/qlsach'">
        </form>
    </div>
</div>
</body>
</html>
