<%--
  Created by IntelliJ IDEA.
  User: truongtrinhkhai
  Date: 31/03/2022
  Time: 10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3><a href="/create">Add new email configuration</a></h3>
<table border="1">
    <tr>
        <th>Language</th>
        <th>Page size</th>
        <th>Spams filter</th>
        <th>Signature</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${emailConfigurationList}" var="emailConfiguration">
        <tr>
            <td>${emailConfiguration.language}</td>
            <td>${emailConfiguration.pageSize}</td>
            <td>${emailConfiguration.spamsFilter}</td>
            <td>${emailConfiguration.signature}</td>
            <td><a href="/update/${emailConfiguration.id}">Update</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
