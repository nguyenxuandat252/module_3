package com.example.product_crud.service;

import com.example.product_crud.model.Product;
import com.example.product_crud.repository.IProductRepository;
import com.example.product_crud.repository.ProductRepository;
import java.util.List;

public class ProductService implements IProductService {
    private final IProductRepository productRepository = new ProductRepository();

    @Override
    public List<Product> getAll() {
        return productRepository.getAll();
    }

    @Override
    public void add(Product product) {
        int newId = productRepository.getAll().stream()
                .mapToInt(Product::getId)
                .max()
                .orElse(0) + 1;
        product.setId(newId);
        productRepository.add(product);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public void update(Product product) {
        productRepository.update(product);
    }
}
