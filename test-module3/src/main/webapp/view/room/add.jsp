<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Room</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="card shadow-lg">
        <div class="card-header bg-primary text-white text-center">
            <h3>Add New Room</h3>
        </div>
        <div class="card-body">
            <form action="/rooms" method="post" onsubmit="return validateForm()">
                <input type="hidden" name="action" value="add">

                <div class="mb-3">
                    <label class="form-label">Room Code</label>
                    <input type="text" name="code" class="form-control" required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Name</label>
                    <input type="text" name="name" id="name" class="form-control" required oninput="validateName()">
                    <div id="nameError" class="invalid-feedback"></div>
                </div>

                <div class="mb-3">
                    <label class="form-label">Phone</label>
                    <input type="text" name="phone" id="phone" class="form-control" required oninput="validatePhone()">
                    <div id="phoneError" class="invalid-feedback"></div>
                </div>

                <div class="mb-3">
                    <label class="form-label">Start Date</label>
                    <input type="date" name="startDate" id="startDate" class="form-control" required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Payment Method</label>
                    <select name="idPay" class="form-select" required>
                        <option value="">-- Select Payment Method --</option>
                        <option value="1">Theo Tháng</option>
                        <option value="2">Theo Quý</option>
                        <option value="3">Theo Năm</option>
                    </select>
                </div>

                <div class="mb-3">
                    <label class="form-label">Note</label>
                    <textarea name="note" id="note" class="form-control" rows="3" required oninput="validateNote()"></textarea>
                    <div id="noteError" class="invalid-feedback"></div>
                </div>

                <button type="submit" class="btn btn-success w-100">Add Room</button>
            </form>
        </div>
    </div>
</div>

<script>
    function validateName() {
        const nameInput = document.getElementById("name");
        const nameError = document.getElementById("nameError");
        const regex = /^[A-Za-zÀ-ỹ\s]{5,50}$/;

        if (!regex.test(nameInput.value)) {
            nameError.innerText = "Tên từ 5-50 ký tự, chỉ chứa chữ cái và khoảng trắng!";
            nameInput.classList.add("is-invalid");
            return false;
        } else {
            nameError.innerText = "";
            nameInput.classList.remove("is-invalid");
            return true;
        }
    }

    function validatePhone() {
        const phoneInput = document.getElementById("phone");
        const phoneError = document.getElementById("phoneError");
        const regex = /^[0-9]{1,10}$/;

        if (!regex.test(phoneInput.value)) {
            phoneError.innerText = "Số điện thoại chỉ chứa số, tối đa 10 ký tự!";
            phoneInput.classList.add("is-invalid");
            return false;
        } else {
            phoneError.innerText = "";
            phoneInput.classList.remove("is-invalid");
            return true;
        }
    }

    function validateNote() {
        const noteInput = document.getElementById("note");
        const noteError = document.getElementById("noteError");

        if (noteInput.value.length > 200) {
            noteError.innerText = "Ghi chú không được vượt quá 200 ký tự!";
            noteInput.classList.add("is-invalid");
            return false;
        } else {
            noteError.innerText = "";
            noteInput.classList.remove("is-invalid");
            return true;
        }
    }

    function validateForm() {
        return validateName() && validatePhone() && validateNote();
    }
</script>

</body>
</html>
