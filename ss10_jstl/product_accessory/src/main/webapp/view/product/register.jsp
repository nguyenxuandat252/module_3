<%--
  Created by IntelliJ IDEA.
  User: Windows
  Date: 08/03/2025
  Time: 8:50 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Register</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f7f7f7;
      margin: 0;
      padding: 0;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
    }

    h2 {
      text-align: center;
      color: #333;
    }

    form {
      background-color: #fff;
      padding: 20px;
      border-radius: 8px;
      box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
      width: 100%;
      max-width: 400px;
      margin-top: 20px;
    }

    form div {
      margin-bottom: 15px;
    }

    label {
      display: block;
      font-weight: bold;
      margin-bottom: 5px;
      color: #333;
    }

    input[type="text"],
    input[type="password"],
    textarea {
      width: 100%;
      padding: 8px;
      margin: 5px 0;
      border: 1px solid #ddd;
      border-radius: 4px;
      box-sizing: border-box;
    }

    input[type="text"]:focus,
    input[type="password"]:focus,
    textarea:focus {
      border-color: #0056b3;
      outline: none;
    }

    button {
      background-color: #007bff;
      color: #fff;
      padding: 10px 20px;
      border: none;
      border-radius: 4px;
      width: 100%;
      cursor: pointer;
    }

    button:hover {
      background-color: #0056b3;
    }

    .error {
      color: red;
      text-align: center;
      margin-top: 20px;
    }
  </style>
</head>
<body>
<form action="/register" method="POST">
  <div>
    <label for="username">Username:</label>
    <input type="text" id="username" name="username" required>
  </div>
  <div>
    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required>
  </div>
  <div>
    <label for="name">Full Name:</label>
    <input type="text" id="name" name="name" required>
  </div>
  <div>
    <label for="phone">Phone Number:</label>
    <input type="tel" id="phone" name="phone" pattern="\d{10}" title="Enter a valid 10 digit phone number" required>
  </div>
  <div>
    <label for="address">Address:</label>
    <textarea id="address" name="address" required></textarea>
  </div>
  <div>
    <button type="submit">Register</button>
  </div>
</form>
</body>
</html>
