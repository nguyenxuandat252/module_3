package com.example.list_customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/show")
public class CustomerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Nguyễn Xuân Đạt", "1998-25-02", "Nghệ An", "https://hoangphucphoto.com/wp-content/uploads/2022/12/aenh-chan-dung.jpg"));
        customers.add(new Customer("Việt Béo 1", "1998-25-02", "Nghệ An", "https://hoangphucphoto.com/wp-content/uploads/2022/12/aenh-chan-dung.jpg"));
        customers.add(new Customer("Việt Béo 2", "1998-25-02", "Nghệ An", "https://hoangphucphoto.com/wp-content/uploads/2022/12/aenh-chan-dung.jpg"));
        customers.add(new Customer("Việt Béo 3", "1998-25-02", "Nghệ An", "https://hoangphucphoto.com/wp-content/uploads/2022/12/aenh-chan-dung.jpg"));
        req.setAttribute("customers",customers );
        req.getRequestDispatcher("/display.jsp").forward(req,resp);
    }
}
