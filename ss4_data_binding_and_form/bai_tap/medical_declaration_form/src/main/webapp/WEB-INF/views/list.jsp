<%--
  Created by IntelliJ IDEA.
  User: truongtrinhkhai
  Date: 31/03/2022
  Time: 19:05
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List</title>
</head>
<body>
<h3><a href="/create">Add new email configuration</a></h3>
<table border="1">
    <tr>
        <th>Tên</th>
        <th>Ngày sinh</th>
        <th>Giới tính</th>
        <th>Quốc tịch</th>
        <th>CMND</th>
        <th>Phương tiện</th>
        <th>Số hiệu</th>
        <th>Số ghế</th>
        <th>Ngày khởi hành</th>
        <th>Ngày kết thúc</th>
        <th>Thành phố từng đi qua</th>
        <th>Địa chỉ</th>
        <th>Số điện thoại</th>
        <th>Email</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${medicalDeclarationList}" var="medicalDeclaration">
        <tr>
            <td>${medicalDeclaration.name}</td>
            <td>${medicalDeclaration.dateOFBirth}</td>
            <td>${medicalDeclaration.gender}</td>
            <td>${medicalDeclaration.nationality}</td>
            <td>${medicalDeclaration.idCard}</td>
            <td>${medicalDeclaration.vehicle}</td>
            <td>${medicalDeclaration.vehicleNumber}</td>
            <td>${medicalDeclaration.chairNumber}</td>
            <td>${medicalDeclaration.departureDay}</td>
            <td>${medicalDeclaration.endDay}</td>
            <td>${medicalDeclaration.cityUsedToPass}</td>
            <td>${medicalDeclaration.address}, ${medicalDeclaration.wards}, ${medicalDeclaration.district}, ${medicalDeclaration.province}</td>
            <td>${medicalDeclaration.phoneNumber}</td>
            <td>${medicalDeclaration.email}</td>
            <td><a href="/update/${medicalDeclaration.id}">Update</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
