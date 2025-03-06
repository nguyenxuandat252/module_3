package com.example.nhanvien_crud.service;

import com.example.nhanvien_crud.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAll();

    void add(Product newProduct);

    Product findById(int id);

    boolean update(int id, Product product);

    boolean delete(int id);

    List<Product> searchById(String keyword);
}
