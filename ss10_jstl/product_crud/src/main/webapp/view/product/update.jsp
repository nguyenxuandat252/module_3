<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Cập nhật sản phẩm</title>
</head>
<body>
<h2>Cập nhật sản phẩm</h2>
<form action="/products?action=update" method="post">
    <input type="hidden" name="id" value="${product.id}">

    <label>Tên sản phẩm:</label>
    <input type="text" name="name" value="${product.name}" required><br>

    <label>Giá:</label>
    <input type="number" step="0.01" name="price" value="${product.price}" required><br>

    <label>Mô tả:</label>
    <textarea name="description">${product.description}</textarea><br>

    <button type="submit">Cập nhật</button>
    <a href="/products">Hủy</a>
</form>
</body>
</html>
