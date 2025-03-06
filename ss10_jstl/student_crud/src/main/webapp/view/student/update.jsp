<%--
  Created by IntelliJ IDEA.
  User: Windows
  Date: 05/03/2025
  Time: 11:03 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cập nhật sinh viên</title>
</head>
<body>
<h2>Cập nhật sinh viên</h2>
<form action="/students" method="post">
    <input type="hidden" name="action" value="update">
    <input type="hidden" name="id" value="${student.id}">

    <label>Tên:</label>
    <input type="text" name="name" value="${student.name}" required><br>

    <label>Tuổi:</label>
    <input type="number" name="age" value="${student.age}" required><br>

    <label>Email:</label>
    <input type="email" name="email" value="${student.email}" required><br>

    <button type="submit">Cập nhật</button>
</form>
<a href="/students">Quay lại</a>
</body>
</html>

