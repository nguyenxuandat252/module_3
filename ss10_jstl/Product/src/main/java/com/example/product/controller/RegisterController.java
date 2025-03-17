package com.example.product.controller;

import com.example.product.model.User;
import com.example.product.service.IRegisterService;
import com.example.product.service.RegisterService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "RegisterController", value = "/register")
public class RegisterController extends HttpServlet {
    private IRegisterService registerService = new RegisterService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String phone = req.getParameter("phone");
        String mess = "";
        if (registerService.existUser(username)) {
            mess = "Username đã tồn tại, vui lòng chọn username khác!";
            req.setAttribute("mess", mess);
            req.getRequestDispatcher("/view/product/register.jsp").forward(req, resp);
        } else {
            User user = new User(username, password, name, address, phone);
            registerService.add(user);
            String role = registerService.getRoleByUsername(username);
            System.out.println(role);
            mess = "Đăng ký thành công!";
            req.setAttribute("mess", mess);
            req.getRequestDispatcher("/view/product/login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/view/product/register.jsp");
    }
}
