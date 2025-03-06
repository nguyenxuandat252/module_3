<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm sản phẩm</title>
</head>
<body>
<h2>Thêm sản phẩm mới</h2>
<form action="/products?action=create" method="post">
    <label>Tên sản phẩm:</label>
    <input type="text" name="name" required><br>

    <label>Giá:</label>
    <input type="number" step="0.01" name="price" required><br>

    <label>Mô tả:</label>
    <textarea name="description"></textarea><br>

    <button type="submit">Thêm</button>
    <a href="/products">Hủy</a>
</form>
</body>
</html>
