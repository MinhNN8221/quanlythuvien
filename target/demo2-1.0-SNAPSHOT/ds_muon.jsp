<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: MinhNN
  Date: 5/1/2022
  Time: 8:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="header.jsp"%>
<body>
<div class="border-qlms">
    <div class="header">
        <h2 class="name">Danh sách sinh viên đang mượn sách</h2>
        <form action="tksvien" method="post">
            <input type="text" name="text_tksv" class="textsv" placeholder="Nhập tên sinh viên cần tìm">
            <button type="submit" name="timkiemsv1" class="btn" style="height: 30px; margin-left: 5px;">Tìm kiếm</button>
        </form>
    </div>
    <div >
        <table>
            <thead>
                <tr>
                    <th>STT</th>
                    <th>Tên sinh viên</th>
                    <th>Tên sách mượn</th>
                    <th>Ngày mượn</th>
                    <th>Ngày phải trả</th>
                    <th>Chi tiết</th>
                    <th>Xác nhận</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${muonList}" var="muon" varStatus="loop">
                    <tr>
                        <td>${loop.index+1}</td>
                        <td>${muon.getSinh_vien().getTen_sv()}</td>
                        <td>${muon.getSach().getTen_sach()}</td>
                        <td>${muon.getNgay_muon()}</td>
                        <td>${muon.getNgay_tra()}</td>
                        <td>
                            <a id="sua" href="${pageContext.request.contextPath}/xemchitiet?id=${muon.getSinh_vien().getMa_sv()}">Xem chi tiết</a>
                        </td>
                        <td>
                            <form action="qlmuon" method="post">
                                <button id="datra" class="button" type="submit" name="xacnhan" value="${muon.getId()}">Đã trả</button>
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
