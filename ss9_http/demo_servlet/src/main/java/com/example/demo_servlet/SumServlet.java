package com.example.demo_servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SumServlet", urlPatterns = {"/sum","/tinhtong"})
public class SumServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("do get");
        req.getRequestDispatcher("/form.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("do port");
        int num1 = Integer.parseInt(req.getParameter("n1"));
        int num2 = Integer.parseInt(req.getParameter("n2"));
        int sum = num1+num2;
        req.setAttribute("sum",sum);
        req.getRequestDispatcher("/result.jsp").forward(req,resp);
    }
}
