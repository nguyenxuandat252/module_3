package com.example.product_crud.repository;

import com.example.product_crud.model.Product;
import java.util.List;

public interface IProductRepository {
    List<Product> getAll();
    void add(Product product);
    Product findById(int id);
    void update(Product product);
}
