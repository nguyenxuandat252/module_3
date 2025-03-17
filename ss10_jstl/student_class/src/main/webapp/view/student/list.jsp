<%--
  Created by IntelliJ IDEA.
  User: Windows
  Date: 07/03/2025
  Time: 9:31 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/students?action=search"method="post">
    <input type="text" name="text-search" placeholder="Id or Name">
    <input type="submit" value="Search">
</form>
<a href="/students?action=create">Create Student</a>
<table>
    <tr>
        <th>ID</th>
        <th>NAME</th>
        <th>AGE</th>
        <th>POINT</th>
        <th>CLASS_ID</th>
        <th>FUNCTION</th>
    </tr>
    <c:forEach var="student" items="${studentList}">
        <tr>
            <td>${student.getId()}</td>
            <td>${student.getName()}</td>
            <td>${student.getAge()}</td>
            <td>${student.getPoint()}</td>
            <td>${student.getNameClass()}</td>
            <td>
                <a href="/students?action=update&id=${student.id}">update</a>
                <a href="/students?action=delete&id=${student.id}" onclick="return confirm('Delete student ?')">Delete</a>
            </td>
        </tr>


    </c:forEach>
</table>
</body>
</html>
