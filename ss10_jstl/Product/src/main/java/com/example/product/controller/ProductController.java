package com.example.product.controller;

import com.example.product.model.Product;
import com.example.product.service.IProductService;
import com.example.product.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductController", value = "/products")
public class ProductController extends HttpServlet {
    private IProductService productService =new ProductService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = "Đăng nhập";
        String logout = "Đăng xuất";
        HttpSession session = req.getSession();
        if(session.getAttribute("username")==null){
            session.setAttribute("status",login);
        }else {
            session.setAttribute("status",logout);
        }


        List<Product> productList = productService.getAll();
        int page = 1; // Mặc định trang đầu tiên
        int itemsPerPage = 8; // Số sản phẩm mỗi trang

        // Lấy số trang từ request (nếu có)
        String pageParam = req.getParameter("page");
        if (pageParam != null) {
            page = Integer.parseInt(pageParam);
        }

        // Tính toán vị trí bắt đầu & kết thúc
        int start = (page - 1) * itemsPerPage;
        int end = Math.min(start + itemsPerPage, productList.size());

        // Lấy danh sách sản phẩm cho trang hiện tại
        List<Product> pageProducts = productList.subList(start, end);

        // Gửi dữ liệu đến JSP
        req.setAttribute("productList", pageProducts);
        req.setAttribute("currentPage", page);
        req.setAttribute("totalPages", (int) Math.ceil((double) productList.size() / itemsPerPage));

        req.getRequestDispatcher("/view/product/home.jsp").forward(req, resp);

    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList = productService.getAll();
        request.setAttribute("productList", productList);
        request.getRequestDispatcher("/view/product/home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action==null){
            action = "";
        }
        switch (action){
            default:
                listProduct(req,resp);
        }
    }
}
