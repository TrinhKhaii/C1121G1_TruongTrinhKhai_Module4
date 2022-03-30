<%--
  Created by IntelliJ IDEA.
  User: truongtrinhkhai
  Date: 30/03/2022
  Time: 11:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h1>Sandwich Condiments</h1>
<form action="/save" method="post">
        <input type="checkbox" name="condiments" value="lettuce">Lettuce
        <input type="checkbox" name="condiments" value="tomato">Tomato
        <input type="checkbox" name="condiments" value="mustard">Mustard
        <input type="checkbox" name="condiments" value="sprouts">Sprouts
    <input type="submit" value="Save">
</form>
</body>
</html>
