<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Room Management</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    <style>
        .container {
            max-width: 900px;
            margin: 20px auto;
            padding: 20px;
            background: #f8f9fa;
            border-radius: 10px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
        }
        table th {
            background: #007bff;
            color: white;
            text-align: center;
        }
        .btn {
            margin-right: 5px;
        }
    </style>
</head>
<body>

<div class="container">
    <h2 class="text-center mb-4">Room Management</h2>

    <!-- Search Form -->
    <form action="/rooms" method="post" class="mb-3">
        <input type="hidden" name="action" value="search">
        <div class="input-group">
            <input type="text" name="search" class="form-control" placeholder="Search by Room Code">
            <button class="btn btn-primary">Search</button>
        </div>
    </form>

    <!-- Add Room -->
    <form action="/rooms" method="get">
        <input type="hidden" name="action" value="add">
        <button class="btn btn-success w-100">Add New Room</button>
    </form>

    <!-- Room Table -->
    <table class="table table-striped table-bordered mt-3">
        <thead>
        <tr>
            <th>STT</th>
            <th>Mã phòng trọ</th>
            <th>Tên người thuê trọ</th>
            <th>Số điện thoại</th>
            <th>Ngày bắt đầu thuê</th>
            <th>Hình thức thanh toán</th>
            <th>Ghi chú</th>
            <th>Chọn</th>
            <th>Hành động</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="room" items="${roomDtos}" varStatus="status">
            <tr>
                <td class="text-center">${status.index + 1}</td>
                <td>${room.code}</td>
                <td>${room.name}</td>
                <td>${room.phone}</td>
                <td>${room.startDate}</td>
                <td>${room.form}</td>
                <td>${room.note}</td>
                <td class="text-center">
                    <input type="checkbox" name="id" value="${room.id}">
                </td>
                <td class="text-center">
                    <form action="/rooms" method="post" class="d-inline">
                        <input type="hidden" name="action" value="delete">
                        <input type="hidden" name="id" value="${room.id}">
                        <button class="btn btn-danger btn-sm">Delete</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
