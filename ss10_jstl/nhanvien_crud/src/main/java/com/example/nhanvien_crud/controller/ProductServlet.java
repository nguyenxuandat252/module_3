package com.example.nhanvien_crud.controller;

import com.example.nhanvien_crud.model.Product;
import com.example.nhanvien_crud.service.IProductService;
import com.example.nhanvien_crud.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/products")
public class ProductServlet extends HttpServlet {
    private IProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                req.getRequestDispatcher("/view/product/add.jsp").forward(req, resp);
                break;
            case "edit":
                int id = Integer.parseInt(req.getParameter("id"));
                Product product = productService.findById(id);
                req.setAttribute("product", product);
                req.getRequestDispatcher("/view/product/edit.jsp").forward(req, resp);
                break;
            case "delete":
                int id1 = Integer.parseInt(req.getParameter("id"));
                productService.delete(id1);
                resp.sendRedirect("/products");
                break;
            default:
                listProduct(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String username = req.getParameter("username");
//        String password = req.getParameter("password");
//        if("admin".equals(username)&&"12345678".equals(password)){
//            HttpSession session = req.getSession();
//            session.setAttribute("username", "admin");
//            session.setAttribute("password", "12345678");
//
//        }else {
//            req.getRequestDispatcher("/view/product/login.jsp").forward(req,resp);
//        }
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createProduct(req, resp);
                break;
            case "edit":
                int id = Integer.parseInt(req.getParameter("id"));
                String name = req.getParameter("name");
                double price = Double.parseDouble(req.getParameter("price"));
                int quantity = Integer.parseInt(req.getParameter("quantity"));
                String description = req.getParameter("description");
                Product product = new Product(id, name, price, quantity, description);
                productService.update(id, product);
                resp.sendRedirect("/products");
                break;
            case "search":
                String idSearch = req.getParameter("text-search");
                List<Product> products = productService.searchById(idSearch);
                req.setAttribute("products", products);
                req.getRequestDispatcher("/view/product/list.jsp").forward(req, resp);
            default:
                listProduct(req, resp);
                break;
        }

    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = productService.getAll();
        request.setAttribute("products", products);
        request.getRequestDispatcher("/view/product/list.jsp").forward(request, response);
    }

    private void createProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        String description = req.getParameter("description");
        Product product = new Product(productService.getAll().size() + 1, name, price, quantity, description);
        productService.add(product);
        resp.sendRedirect("/products");
    }
}
