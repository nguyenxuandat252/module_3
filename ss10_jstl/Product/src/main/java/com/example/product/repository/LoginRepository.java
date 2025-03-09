package com.example.product.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginRepository implements ILoginRepository{
    @Override
    public String existUser(String username, String password) {
        Connection connection = BaseRepository.getConnectDB();
        String role = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT role FROM user WHERE username = ? and password = ?;");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                role = resultSet.getString("role");
                return role;
            }
        } catch (SQLException e) {
            System.out.println("Lỗi hệ thống");
        }
        return role;
    }
}
