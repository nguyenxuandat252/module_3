package com.example.testmodule3.config;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "UTF-8", value = "/*")
public class FilterUTF8 implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        // Đặt mã hóa UTF-8 cho request
        servletRequest.setCharacterEncoding("UTF-8");

        // Đặt mã hóa UTF-8 cho response
        servletResponse.setCharacterEncoding("UTF-8");
        servletResponse.setContentType("text/html; charset=UTF-8");

        filterChain.doFilter(servletRequest, servletResponse);
    }
}