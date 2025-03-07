<%--
  Created by IntelliJ IDEA.
  User: Windows
  Date: 07/03/2025
  Time: 11:06 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/students?action=create" method="post">
  <label>Name:</label>
  <input type="text" name="name" required><br>

  <label>Price:</label>
  <input type="number" name="age" required><br>

  <label>Quantity:</label>
  <input type="number" name="point" required><br>

  <label>Description:</label>
  <input type="number" name="classId" required><br>

  <button type="submit">Create</button>
</form>
</body>
</html>
