<%--
  Created by IntelliJ IDEA.
  ru.test.User: root
  Date: 18.05.2017
  Time: 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
    <title>Контакт</title>
  </head>
  <body>
  <form action="<c:url value="/phonebook"/>" method="POST">
    <table>
      <tr>
        <td><a href="phonebook?action=add">Новый пользователь</a></td>
      </tr>
      <tr>
        <td><a href="phonebook?action=all">Вывести список пользователей</a></td>
      </tr>
      <tr>
        <td><input type="text" name="userID" value="${userID}"></td>
        <td><input type="submit" value="Посмотреть" name="View"/></td>
      </tr>
    </table>
  </form>
  </body>
</html>
