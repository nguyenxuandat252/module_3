<%--
  Created by IntelliJ IDEA.
  User: Windows
  Date: 05/03/2025
  Time: 10:50 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Danh sách sinh viên</title>
</head>
<body>
<h2>Danh sách sinh viên</h2>

<!-- Form tìm kiếm -->
<form action="/students" method="get">
    <input type="hidden" name="action" value="search">
    <label>Tìm kiếm: </label>
    <input type="text" name="keyword" placeholder="Nhập ID hoặc tên">
    <button type="submit">Tìm</button>
</form>

<a href="/students?action=create">Thêm sinh viên</a>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Tên</th>
        <th>Tuổi</th>
        <th>Email</th>
        <th>Hành động</th>
    </tr>
    <c:forEach var="student" items="${students}">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.age}</td>
            <td>${student.email}</td>
            <td>
                <a href="/students?action=update&id=${student.id}">Sửa</a> |
                <a href="/students?action=delete&id=${student.id}" onclick="return confirm('Xóa sinh viên  này?')">Xóa</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>


