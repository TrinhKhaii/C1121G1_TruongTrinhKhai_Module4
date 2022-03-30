<%--
  Created by IntelliJ IDEA.
  User: truongtrinhkhai
  Date: 30/03/2022
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<form action="/calculator">
    <label for="num-1">Number 1</label>
    <input type="text" id="num-1" name="num1" value="${num1}">
    <br/> <br/>
    <label for="num-2">Number 2</label>
    <input type="text" id="num-2" name="num2" value="${num2}">
    <br/> <br/>
    <input type="submit" name="submit" value="Addition">
    <br/> <br/>
    <input type="submit" name="submit" value="Substraction">
    <br/> <br/>
    <input type="submit" name="submit" value="Multiplication">
    <br/> <br/>
    <input type="submit" name="submit" value="Division">
</form>
<h3>Result</h3>
<input type="text" name="result" value="${result}">
</body>
</html>
