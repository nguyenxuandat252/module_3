<%--
  Created by IntelliJ IDEA.
  User: Windows
  Date: 07/03/2025
  Time: 2:09 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <head>
        <title>Edit Form</title>
    </head>
<body>
<form action="/students?action=update" method="post">
    <label>Name:</label>

    <input type="hidden" name="id" value="${student.getId()}" required><br>
    <input type="text" name="name" value="${student.getName()}" required><br>

    <label>age:</label>
    <input type="number" name="age" value="${student.getAge()}" required><br>

    <label>point:</label>
    <input type="number" name="point" value="${student.getPoint()}" required><br>

    <label>class id:</label>
    <input type="text" name="classId" value="${student.getClassId()}" required><br>

    <button type="submit">Complete</button>
</form>
</body>
</html>
