<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <style>
        table {
            border: 1px solid #000;
        }

        th, td {
            border: 1px dotted #555;
        }
    </style>
    <title>Document</title>
</head>
<body>
There are ${customerList.size()} customer(s) in list.
<table>
    <caption>Customers List</caption>
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Address</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${customerList}" var="customer">
        <tr>
            <td>
                    ${customer.getId()}
            </td>
            <td>
                <a href="/info?id=${customer.getId()}">${customer.getName()}</a>
            </td>
            <td>
                    ${customer.getEmail()}
            </td>
            <td>
                    ${customer.getAddress()}
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>