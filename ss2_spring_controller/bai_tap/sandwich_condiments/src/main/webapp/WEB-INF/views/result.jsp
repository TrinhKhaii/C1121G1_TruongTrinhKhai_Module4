<%--
  Created by IntelliJ IDEA.
  User: truongtrinhkhai
  Date: 30/03/2022
  Time: 13:45
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Your Sandwich has</h1>
<c:forEach var="condiment" items="${condiment}">
<p>${condiment}</p>
</c:forEach>
</body>
</html>
