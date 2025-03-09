package com.example.product_accessory.controller;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter ("/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession(false);
        String uri = req.getRequestURI();

        // Các trang không yêu cầu đăng nhập
        if (uri.endsWith("/view/product/login.jsp") || uri.endsWith("/products") || uri.endsWith("/view/product/register.jsp")) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        if (session == null || session.getAttribute("username") == null) {
            res.sendRedirect("/view/product/login.jsp"); // Chưa đăng nhập → Chuyển hướng login
            return;
        }

        String role = (String) session.getAttribute("role");
        if (uri.contains("/admin") && !"ADMIN".equals(role)) {
            res.sendRedirect("/products"); // Không phải admin → Chuyển về trang chủ
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
