<%--
  Created by IntelliJ IDEA.
  User: Windows
  Date: 06/03/2025
  Time: 11:19 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Products</title>
</head>
<body>
<c:if test="${sessionScope.username eq 'admin'}">
    <p>Xin chào, <strong>${sessionScope.username}</strong>!</p>
    <a href="/logout">Đăng xuất</a>
</c:if>
<h1>Products</h1>
<form action="/products?action=search"method="post">
    <input type="text" name="text-search" placeholder="Id or Name">
    <input type="submit" value="Search">
</form>
<a href="/products?action=create">Create Product</a>
<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Price</th>
        <th>Quality</th>
        <th>Description</th>
        <th>Function</th>
    </tr>
    <c:forEach var="product" items="${products}">
        <tr>
            <td>${product.getId()}</td>
            <td>${product.getName()}</td>
            <td>${product.getPrice()}</td>
            <td>${product.getQuantity()}</td>
            <td>${product.getDescription()}</td>
            <td>
                <a href="/products?action=edit&id=${product.id}">edit</a>
                <a href="/products?action=delete&id=${product.id}" onclick="return confirm('Delete product ?')">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
