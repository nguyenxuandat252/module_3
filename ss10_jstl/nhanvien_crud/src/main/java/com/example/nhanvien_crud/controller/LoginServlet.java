package com.example.nhanvien_crud.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if ("admin".equals(username) && "12345678".equals(password)) {
            // Lưu session nếu là Admin
            HttpSession session = req.getSession();
            session.setAttribute("username", "admin");
            resp.sendRedirect("/products"); // Chuyển hướng đến trang Admin
        } else {
            resp.sendRedirect("/view/product/login.jsp?error=1"); // Quay lại login nếu sai
        }
    }
}
