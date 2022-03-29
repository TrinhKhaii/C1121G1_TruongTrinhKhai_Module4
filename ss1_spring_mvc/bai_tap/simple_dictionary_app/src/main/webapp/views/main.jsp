<%--
  Created by IntelliJ IDEA.
  User: truongtrinhkhai
  Date: 29/03/2022
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Từ Điển Anh-Việt</h3>
<form action="/translate">
    <input type="text" id="vi" name="vi" value="${vi}">
    <input type="text" id="en" name="en" value="${en}"> <br> <br>
    <input type="submit" id="submit" value="Translate">
</form>
</body>
</html>
