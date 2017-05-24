<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 22.05.2017
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Список пользователей</title>
</head>
    <body>
    <form action="<c:url value="/edit"/>" method="POST">

        <c:forEach var="user" items="${userList}">

                <input type="hidden" name="userID" value="${user.id}"/>
                <table>
                    <tr>
                        <td>Фамилия:</td><td><input type="text" name="lastName" value="${user.lastname}"/></td>
                    </tr>
                    <tr>
                        <td>Имя:</td><td><input type="text" name="firstName" value="${user.firstname}"/></td>
                    </tr>
                    <tr>
                        <td>Дата рождения:</td><td><input type="text" name="birthday" value="${user.birthday}"/></td>
                    </tr>
                </table>
            <td><a href="phonebook?action=view&userID=${user.id}">Карточка пользователя</a></td>

        </c:forEach>

        <c:if test="${userList==null}">
            Пользователей не найдено
            </c:if>
    </form>
    <tr>
    <td><a href="phonebook?action=add">Add</a></td>
    </tr>

    </body>
</html>
