<%--
  Created by IntelliJ IDEA.
  User: Windows
  Date: 06/03/2025
  Time: 11:54 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Form</title>
</head>
<body>
<form action="/products?action=create" method="post">
<%--    <input type="hidden" name="action" value="create">--%>
    <label>Name:</label>
    <input type="text" name="name" required><br>

    <label>Price:</label>
    <input type="number" name="price" required><br>

    <label>Quantity:</label>
    <input type="number" name="quantity" required><br>

    <label>Description:</label>
    <input type="text" name="description" required><br>

    <button type="submit">Add</button>
</form>
</body>
</html>
