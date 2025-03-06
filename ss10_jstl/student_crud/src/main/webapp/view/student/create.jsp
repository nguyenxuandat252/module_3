<%--
  Created by IntelliJ IDEA.
  User: Windows
  Date: 05/03/2025
  Time: 11:02 CH
  To change this template use File | Settings | File Templates.
--%>
<<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Thêm sinh viên</title>
</head>
<body>
<h2>Thêm sinh viên</h2>
<form action="/students" method="post">
  <input type="hidden" name="action" value="create">
  <label>Tên:</label>
  <input type="text" name="name" required><br>

  <label>Tuổi:</label>
  <input type="number" name="age" required><br>

  <label>Email:</label>
  <input type="email" name="email" required><br>

  <button type="submit">Thêm</button>
</form>
<a href="/students">Quay lại</a>
</body>
</html>

