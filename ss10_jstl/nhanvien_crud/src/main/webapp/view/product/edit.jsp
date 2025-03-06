<%--
  Created by IntelliJ IDEA.
  User: Windows
  Date: 06/03/2025
  Time: 1:04 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Form</title>
</head>
<body>
<form action="/products?action=edit" method="post">
    <label>Name:</label>

    <input type="hidden" name="id" value="${product.getId()}" required><br>
    <input type="text" name="name" value="${product.getName()}" required><br>

    <label>Price:</label>
    <input type="number" name="price" value="${product.getPrice()}" required><br>

    <label>Quantity:</label>
    <input type="number" name="quantity" value="${product.getQuantity()}" required><br>

    <label>Description:</label>
    <input type="text" name="description" value="${product.getDescription()}" required><br>

    <button type="submit">Complete</button>
</form>
</body>
</html>
