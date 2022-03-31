<%--
  Created by IntelliJ IDEA.
  User: truongtrinhkhai
  Date: 31/03/2022
  Time: 10:37
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Form</title>
</head>
<body>
<form:form modelAttribute="emailConfiguration" method="post" action="/create">
    <fieldset>
        <legend>Login</legend>
        <table>
            <tr>
                <td>
                    <form:label path="language">Language: </form:label>
                </td>
                <td>
                    <form:select  path="language">
                        <form:options items="${languages}"/>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td><form:label path="pageSize">Page size: </form:label></td>
                <td>
                    Show
                    <form:select  path="pageSize">
                        <form:options items="${pageSize}"/>
                    </form:select>
                    emails per page
                </td>
            </tr>
            <tr>
                <td><form:label path="spamsFilter">Spams filter: </form:label></td>
                <td>
                    <form:checkbox path="spamsFilter"/> Enable spams filter
                </td>
            </tr>
            <tr>
                <td><form:label path="signature">Signature: </form:label></td>
                <td><form:textarea path="signature" rows = "5" cols = "30" /></td>
            </tr>
            <tr>
                <td><form:button>Update</form:button></td>
            </tr>
        </table>
    </fieldset>
</form:form>
</body>
</html>
