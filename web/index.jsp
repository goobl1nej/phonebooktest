<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 18.05.2017
  Time: 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Контакт</title>
  </head>
  <body>
  <form action="<c:url value="/phonebook"/>" method="POST">
    <table>
      <tr>
        <td><a href="phonebook?action=add">Add</a></td>
        <td><a href="phonebook?action=all">All</a></td>
      </tr>
    </table>
  </form>
  </body>
</html>
