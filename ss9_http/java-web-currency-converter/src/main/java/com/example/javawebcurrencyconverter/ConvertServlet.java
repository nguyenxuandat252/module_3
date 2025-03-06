package com.example.javawebcurrencyconverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ConvertServlet", urlPatterns = "/convert")
public class ConvertServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int num1 = Integer.parseInt(req.getParameter("rate"));
        int num2 = Integer.parseInt(req.getParameter("usd"));
        int result = num1*num2;
        req.setAttribute("usd",num2);
        req.setAttribute("vnd",result);
        req.getRequestDispatcher("/display.jsp").forward(req,resp);
    }
}
