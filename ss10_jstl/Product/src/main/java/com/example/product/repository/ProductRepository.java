package com.example.product.repository;

import com.example.product.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository{

    @Override
    public List<Product> getAll() {
        List<Product> productList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from product");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String code = resultSet.getString("code");
                String brand = resultSet.getString("brand");
                String model = resultSet.getString("model");
                double price = resultSet.getDouble("price");
                String releaseDate = resultSet.getString("release_date");
                String description = resultSet.getString("description");
                int idAccessory = resultSet.getInt("id_accessory");
                Product product = new Product(id, code, brand, model, price,releaseDate,description,idAccessory);
                productList.add(product);
            }
        } catch (SQLException e) {
            System.out.println("Lỗi");
        }
        return productList;
    }
}
