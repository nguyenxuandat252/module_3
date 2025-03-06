<%--
  Created by IntelliJ IDEA.
  User: Windows
  Date: 05/03/2025
  Time: 1:44 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>Currency Converter</p>
<form action="/convert" method="post">
    <label>Rate:</label>
    <input name="rate" placeholder="enter rate">
    <br>
    <label>USD</label>
    <input name="usd" placeholder="enter usd">
    <button>Convert</button>
</form>
</body>
</html>
