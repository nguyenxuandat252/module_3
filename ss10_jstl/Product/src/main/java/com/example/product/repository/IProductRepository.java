package com.example.product.repository;

import com.example.product.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> getAll();
}
