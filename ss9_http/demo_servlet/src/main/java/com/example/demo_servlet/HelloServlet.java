package com.example.demo_servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HelloServlet", urlPatterns = "/hello")
public class HelloServlet  extends HttpServlet {
    @Override
    public void init() throws ServletException {
        //chạy một lần duy nhâ khi khởi tạo
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // chạy khi có request bằng get
        // có 3 cách tạo request get : thẻ a, thay đổi thanh url, method = get
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // chạy khi có request bằng post
        // khi method = port + submit form
    }

    @Override
    public void destroy() {
        // chạy 1 lần duy nhâ khi phá hủy
    }
}
