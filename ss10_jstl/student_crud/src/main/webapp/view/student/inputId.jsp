<%--
  Created by IntelliJ IDEA.
  User: Windows
  Date: 05/03/2025
  Time: 11:02 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tìm sinh viên</title>
</head>
<body>
<h2>Tìm kiếm sinh viên theo ID</h2>
<form action="/students" method="get">
    <input type="hidden" name="action" value="find">
    <label>Nhập ID:</label>
    <input type="number" name="id" required><br>
    <button type="submit">Tìm</button>
</form>
<a href="/students">Quay lại</a>
</body>
</html>

