<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 23.05.2017
  Time: 12:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<form action="<c:url value="/edit"/>" method="POST">
    <table>
        <tr>
            <td>Фамилия:</td><td><input type="text" name="lastName" value="${lastname}"/></td>
        </tr>
        <tr>
            <td>Имя:</td><td><input type="text" name="firstName" value="${firstname}"/></td>
        </tr>
        <tr>
            <td>Отчество:</td><td><input type="text" name="middleName" value="${middlename}"/></td>
        </tr>
        <tr>
            <td>Дата рождения:</td><td><input type="text" name="birthday" value="${birthday}"/></td>
        </tr>
        <tr>
            <td>Электронная почта:</td><td><input type="text" name="email" value="${email}"/></td>
        </tr>
        <tr>
            <td>Телефон:</td><td><input type="text" name="phone" value="${phone}"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="OK" name="OK"/></td>
        </tr>

    </table>
</form>
</body>
</html>
