<%--
  Created by IntelliJ IDEA.
  User: Windows
  Date: 06/03/2025
  Time: 9:00 SA
  To change this template use File | Settings | File Templates.
--%>
<%-- Created by IntelliJ IDEA. User: Windows Date: 06/03/2025 Time: 9:00 SA --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <style>
        /* Reset CSS */
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: Arial, sans-serif;
        }

        /* Căn giữa màn hình */
        .full-screen {
            background-color: gainsboro;
            width: 100vw;
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        /* Form login */
        .form-login {
            background-color: white;
            width: 350px;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);
        }

        .form-login h1 {
            text-align: center;
            margin-bottom: 20px;
        }

        /* Căn trái nhãn */
        .form-login label {
            display: block;
            font-weight: bold;
            margin-bottom: 5px;
            text-align: left; /* Căn chữ sang trái */
        }

        /* Ô input có icon */
        .input-group {
            display: flex;
            align-items: center;
            background-color: #f0f0f0;
            border: 1px solid #ccc;
            border-radius: 5px;
            margin-bottom: 15px;
            padding: 8px;
            width: 100%;
        }

        .input-group span {
            margin-right: 8px;
        }

        .input-group input {
            width: 100%;
            border: none;
            outline: none;
            background: transparent;
            padding: 8px;
        }

        /* Checkbox */
        .remember-me {
            display: flex;
            align-items: center;
            margin-bottom: 15px;
        }

        .remember-me label {
            margin-left: 5px;
        }

        /* Nút Login */
        .login-btn {
            width: 100%;
            padding: 10px;
            background-color: #007bff;
            border: none;
            color: white;
            font-size: 16px;
            border-radius: 5px;
            cursor: pointer;
            transition: background 0.3s;
        }

        .login-btn:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<div class="full-screen">
    <div class="form-login">
        <h1>Login</h1>
        <form action="/login" method="post">
            <label>Username:</label>
            <div class="input-group">
                <span>👤</span>
                <input type="text" name="username" placeholder="Enter your username" required>
            </div>

            <label>Password:</label>
            <div class="input-group">
                <span>🔒</span>
                <input type="password" name="password" placeholder="Enter your password" required>
            </div>

            <div class="remember-me">
                <input type="checkbox" id="remember">
                <label for="remember">Ghi nhớ đăng nhập</label>
            </div>

            <button type="submit" class="login-btn">Login</button>
        </form>
    </div>
</div>
</body>
</html>
