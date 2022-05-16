<%@ page import="java.util.ArrayList" %>
<%@ page import="Model.Sach" %>
<%@ page import="DAO.DBQl_sach" %>
<%@ page import="java.util.List" %>
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
<%@include file="header.jsp"%>
<body>
<div class="border-qls">
    <h3 class="success" style="color: red">${err}</h3>
    <div class="header">
        <div class="box" style="display: flex; justify-content: center">
            <h2 class="name">Danh sách sách trong thư viện</h2>
        </div>

        <form action="tksach" method="post">
            <input type="text" name="text_tks" class="textsach" placeholder="Nhập tên sách cần tìm">
            <button type="submit" name="timkiemsach" class="btn">Tìm kiếm</button>
        </form>
    </div>
    <div>
        <a class="addsach" href="${pageContext.request.contextPath}/themsach">Thêm sách</a>
    </div>
    <div class="div-tbl">
        <table>
            <thead>
                <tr>
                    <th>STT</th>
                    <th>Tên sách</th>
                    <th>Thể loại</th>
                    <th>Vị trí</th>
                    <th>Tác giả</th>
                    <th>Số lượng</th>
                    <th>Còn lại</th>
                    <th>Chỉnh sửa</th>
                    <th>Xóa</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${bookList}" var="book" varStatus="loop">
                <tr>
                    <td>${loop.index+1}</td>
                    <td>${book.getTen_sach()}</td>
                    <td>${book.getLoai_sach().getTen_ls()}</td>
                    <td>${book.getVi_tri().getTen_vt()}</td>
                    <td>${book.getTac_gia().getTen_tg()}</td>
                    <td>${book.sl_bd}</td>
                    <td>${book.sl_cl}</td>
                    <td>
                        <a id="sua" href="${pageContext.request.contextPath}/chinhsua?id=${book.getId()}">Chỉnh sửa</a>
                    </td>
                    <td>
                        <form action="xoa" method="post">
                            <button id="xoa" class="button" type="submit" name="xoa" value="${book.getId()}" >Xoa</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>

</html>
