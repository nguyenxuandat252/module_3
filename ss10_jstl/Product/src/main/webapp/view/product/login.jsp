<%--
  Created by IntelliJ IDEA.
  User: Windows
  Date: 09/03/2025
  Time: 11:18 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="/view/product/style.css">
</head>
<body>
<form action="/login" method="post">
    <p>${mess}</p>
    <label>username</label>
    <input type="text" name="username"><br>
    <label>username</label>
    <input type="password" name="password"><br>
    <a href="/register">register now</a>
    <input type="submit" value="Login">
</form>
</body>
</html>
