package com.example.product.repository;

import com.example.product.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterRepository implements IRegisterRepository{
    Connection connection = BaseRepository.getConnectDB();
    @Override
    public boolean existUser(String username) {
        //Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id FROM user WHERE username = ?;");
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Lỗi hệ thống");
        }
        return false;
    }

    @Override
    public boolean add(User user) {
        //Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO user (username, password, name, address, phone) VALUES (?, ?, ?, ?, ?)");
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getName());
            preparedStatement.setString(4, user.getAddress());
            preparedStatement.setString(5, user.getPhone());
            int row = preparedStatement.executeUpdate();
            return row==1;
        } catch (SQLException e) {
            System.out.println("Lỗi hệ thống");
            return false;
        }
    }

    @Override
    public String getRoleByUsername(String username) {
        String role = null;
        String query = "SELECT role FROM user WHERE username = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, username);
            ResultSet resultSet  = preparedStatement.executeQuery();

            if (resultSet.next()) {
                role = resultSet.getString("role");
            }
        } catch (SQLException e) {
            System.out.println("Lỗi hệ thống");
        }

        return role; // Trả về role hoặc null nếu không tìm thấy
    }
}
