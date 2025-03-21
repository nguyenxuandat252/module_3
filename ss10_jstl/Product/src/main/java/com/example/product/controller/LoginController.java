package com.example.product.controller;

import com.example.product.service.ILoginService;
import com.example.product.service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginController", value = "/login")
public class LoginController extends HttpServlet {
    private ILoginService loginService = new LoginService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String role = loginService.existUser(username, password);
        String mess="";
        if (role != null) {
            HttpSession session = req.getSession();
            session.setAttribute("username", username);
            session.setAttribute("role", role);
            resp.sendRedirect("/products");
        }else {
            mess="Đăng nhập thất bại kiểm tra lại thông tin đăng nhập!";
            req.setAttribute("mess",mess);
            req.getRequestDispatcher("view/product/login.jsp").forward(req, resp);
        }

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/view/product/register.jsp");
    }

}
