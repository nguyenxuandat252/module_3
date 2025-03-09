package com.example.product_accessory.controller;

import com.example.product_accessory.repository.BaseRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet (name = "LoginController",value = "/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Connection connection = BaseRepository.getConnectDB();
        String query="SELECT role FROM user WHERE username = ? AND password = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) { // Nếu tìm thấy tài khoản hợp lệ
                String role = resultSet.getString("role");
                HttpSession session = req.getSession();
                session.setAttribute("username", username);
                session.setAttribute("role", role);

                resp.sendRedirect("products"); // Điều hướng thay vì forward
            } else {
                // Đăng nhập thất bại
                req.setAttribute("error", "Invalid username or password!");
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database error!");
        }
    }
}
