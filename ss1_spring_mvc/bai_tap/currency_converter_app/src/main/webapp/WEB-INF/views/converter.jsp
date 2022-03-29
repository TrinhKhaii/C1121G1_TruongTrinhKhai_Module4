<%--
  Created by IntelliJ IDEA.
  User: truongtrinhkhai
  Date: 29/03/2022
  Time: 06:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/convert">
    <label for="num_1">Number 1</label>
    <input id="num_1" type="text" name="num1" value="${num1}">
    <br/>
    <label for="exchange_rate">Exchange Rate</label>
    <input id="exchange_rate" name="exchange_rate" type="text" value="23000">
    <br/>
    <label for="num_2">Number 2</label>
    <input id="num_2" type="text" name="num2" value="${num2}">
    <input type="submit">
    <p>${mess}</p>
</form>
</body>
</html>
