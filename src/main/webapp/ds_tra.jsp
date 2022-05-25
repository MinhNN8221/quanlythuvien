<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: MinhNN
  Date: 5/1/2022
  Time: 3:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="header.jsp"%>
<body>
<div class="border-qlms">
    <div class="header">
        <h2 class="name">Danh sách sinh viên đã trả sách</h2>
        <form action="tksvien" method="post">
            <input type="text" name="text_tksv" class="textsv2" placeholder="Nhập tên sinh viên cần tìm">
            <button type="submit" name="timkiemsv2" class="btn" style="height: 30px;  margin-left: 5px;">Tìm kiếm</button>
        </form>
    </div>
    <div>
        <table>
            <thead>
                <tr>
                    <th>STT</th>
                    <th>Tên sinh viên</th>
                    <th>Tên sách mượn</th>
                    <th>Mã sinh viên</th>
                    <th>Lớp</th>
                    <th>Ngày mượn</th>
                    <th>Ngày trả</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${traList}" var="tra" varStatus="loop">
                    <tr>
                        <td>${loop.index+1}</td>
                        <td>${tra.getSinh_vien().getTen_sv()}</td>
                        <td>${tra.getSach().getTen_sach()}</td>
                        <td>${tra.getSinh_vien().getMa_sv()}</td>
                        <td>${tra.getSinh_vien().getLop()}</td>
                        <td>${tra.getNgay_muon()}</td>
                        <td>${tra.getNgay_tra()}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <input type="button" value="Trở lại" class="quaylai" width="20px" onclick="location.href='${pageContext.request.contextPath}/qlmuon'">
    </div>
</div>
</body>
</html>
