package com.example.simple_login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        request.setAttribute("name",username);
        request.setAttribute("pass",password);
        String mess = "";
        if ("admin".equals(username) && "admin".equals(password)) {
            mess = "Welcome "+username+" to website";
        }else {
            mess="Login Error";
            request.setAttribute("mess",mess);
            request.getRequestDispatcher("/form.jsp").forward(request,response);

        }
        request.setAttribute("mess",mess);
        request.getRequestDispatcher("/display.jsp").forward(request,response);
    }
}