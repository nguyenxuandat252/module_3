package com.example.product_discount_calculator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CeculatorServlet", value = "/ceculator")
public class CeculatorServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int price = Integer.parseInt(req.getParameter("gia"));
        int discount = Integer.parseInt(req.getParameter("ck"));
        double result = price* discount;
        req.setAttribute("result",result);
        req.getRequestDispatcher("/display.jsp").forward(req,resp);
    }
}
