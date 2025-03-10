package com.example.product.service;

import com.example.product.model.Product;
import com.example.product.repository.IProductRepository;
import com.example.product.repository.ProductRepository;

import java.util.List;

public class ProductService implements IProductService{
    private IProductRepository productRepository = new ProductRepository();

    @Override
    public List<Product> getAll() {
        return productRepository.getAll();
    }
}
