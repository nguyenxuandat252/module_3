<%--
  Created by IntelliJ IDEA.
  User: Windows
  Date: 05/03/2025
  Time: 11:19 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>
<style type="text/css">
    .login {
        height:180px; width:230px;
        margin:0;
        padding:10px;
        border:1px #CCC solid;
    }
    .login input {
        padding:5px; margin:5px
    }
</style>
<body>
<form action="/login" method="post">
    <div class="login">
        <p>${mess}</p>
        <h2>Login</h2>
        <input type="text" name="username" size="30" placeholder="username" />
        <input type="password" name="password" size="30" placeholder="password" />
        <input type="submit" value="Sign in"/>
    </div>
</form>
</body>
</html>
