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
    <title></title>
</head>
    <body>
    <form action="<c:url value="/edit"/>" method="POST">

                <input type="hidden" name="userID" value="${user.id}"/>
                <table>
                    <tr>
                        <td>Фамилия:</td><td><input type="text" name="lastName" value="${user.lastname}"/></td>
                    </tr>
                    <tr>
                        <td>Имя:</td><td><input type="text" name="firstName" value="${user.firstname}"/></td>
                    </tr>
                    <tr>
                        <td>Отчество:</td><td><input type="text" name="middleName" value="${user.middlename}"/></td>
                    </tr>
                    <tr>
                        <td>Дата рождения:</td><td><input type="text" name="birthday" value="${user.birthday}"/></td>

                    </tr>
                    <%--${fn:length(user.emails)}--%>
                    <c:forEach var="email" items="${user.emails}">
                        <td><input type="hidden" c></td>
                        <tr>
                            <td>Электронная почта:</td><td><input type="text" name="email" value="${email.email}"/></td>
                        </tr>
                    </c:forEach>
                    <%--${fn:length(user.phones)}  --%>
                    <c:forEach var="phone" items="${user.phones}">
                        <tr>
                            <td>Телефон:</td><td><input type="text" name="phone" value="${phone.phone}"/></td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td><a href="phonebook?action=view&userID=${user.id}&ps=view">Просмотр пользователя</a></td>
                    </tr>
                </table>

        <c:if test="${user==null}">
            Пользователя не найдено
            </c:if>
    </form>
    <tr>
    <td><a href="phonebook?action=all">К списку пользователей</a></td>
    </tr>

    </body>
</html>
