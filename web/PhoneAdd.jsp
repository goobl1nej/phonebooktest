<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 24.05.2017
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title></title>
</head>
<body>
<body>
<form action="<c:url value="/phonebook"/>" method="POST">
    <input type="hidden" name="userID" value="${user.id}"/>
    <table>
        <tr>
            <td>Ваш телефон:</td><td><input type="text" name="phone" value="${phone}"/></td>
            <td><a href="/phonebook?action=phone&userID=${user.id}">Добавить</a></td>
        </tr>
    </table>
</form>
</body>
</html>
