<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Nhập ID sản phẩm</title>
</head>
<body>
<h2>Nhập ID sản phẩm để cập nhật</h2>
<form action="/products?action=update" method="get">
  <label>ID sản phẩm:</label>
  <input type="number" name="id" required>
  <button type="submit">Tìm</button>
</form>
<a href="/products">Quay lại danh sách</a>
</body>
</html>
