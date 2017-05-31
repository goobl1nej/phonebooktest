<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  ru.test.User: root
  Date: 22.05.2017
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="ru.test.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>Карточка пользователя</title>

</head>
    <body>
    <form action="<c:url value="/phonebook"/>" method="POST">
        <input type="hidden" name="userID" value="${user.id}"/>
                <table align="center">
                    <td align="left"><a href="phonebook?action=all">К списку пользователей</a></td><td align="right">Фамилия:</td><td>${user.lastname}</td><td rowspan="4"></td>
                    </tr>
                    <tr>
                        <td align="left"><a href="phonebook?action=view&userID=${user.id}&ps=view">Редактировать пользователя</a></td><td align="right">Имя:</td><td>${user.firstname}</td>
                    </tr>
                    <tr>
                        <td></td><td align="right">Отчество:</td><td>${user.middlename}</td>
                    </tr>
                    <tr>
                        <td></td><td align="right">Дата рождения:</td><td>${user.birthday}</td>

                    </tr>
                    <%  User userEm = (User)request.getAttribute("user");
                        if (userEm.getEmails()!=null && !userEm.getEmails().isEmpty()) {
                    %>
                    <tr>
                        <td></td><td align="right"><a href="EmailAdd.jsp?userID=${user.id}"><img src="images/add.png" height="15px" width="15px"></a>Электронная почта(ы):</td>
                    </tr>
                    <c:forEach var="email" items="${user.emails}">
                        <tr>
                            <td></td><td></td><td>${email.email}</td>
                            <td><a href="EmailEdit.jsp?userID=${user.id}&emailID=${email.id}&email=${email.email}"><img src="images/edit.png" width="15px" height="15px"></a>
                                <a href="EmailDelete.jsp?emailID=${email.id}"><img src="images/del.png" width="15px" height="15px"></a></td>
                        </tr>
                    </c:forEach>
                    <% } else { %>
                    <%--<input type="hidden" name="userID" value="${user.id}"/>--%>
                    <tr>
                        <td></td><td></td><td><input type="text" name="email" value="${email}"/><input type="submit" value="Добавить" name="AddEmail"/></td>
                    </tr>
                    <% } %>
                    <%
                        User userPh = (User)request.getAttribute("user");
                        if (userPh.getPhones()!=null && !userPh.getPhones().isEmpty()) {
                    %>
                    <tr>
                        <td></td><td align="right"><a href="PhoneAdd.jsp?userID=${user.id}"><img src="images/add.png" height="15px" width="15px"></a>Телефон(ы):</td>
                    </tr>
                    <c:forEach var="phone" items="${user.phones}">
                        <tr>
                            <td></td><td></td><td>${phone.phone}</td>
                            <td><a href="PhoneEdit.jsp?userID=${user.id}&phoneID=${phone.id}&phone=${phone.phone}"><img src="images/edit.png" width="15px" height="15px"></a>
                                <a href="PhoneDelete.jsp?phoneID=${phone.id}"><img src="images/del.png" width="15px" height="15px"></a></td>
                        </tr>
                    </c:forEach>
                    <% } else {%>
                    <%--<input type="hidden" name="userID" value="${user.id}"/>--%>
                    <tr>
                        <td></td><td></td><td><input type="text" name="phone" value="${phone}"/><input type="submit" name="AddPhone" value="Добавить"></td>
                    </tr>
                    <% } %>
                </table>

        <c:if test="${user==null}">
            Пользователя не найдено
            </c:if>
    </form>
    </body>
</html>
