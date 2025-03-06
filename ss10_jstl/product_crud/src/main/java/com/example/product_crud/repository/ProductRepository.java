package com.example.product_crud.repository;

import com.example.product_crud.model.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductRepository implements IProductRepository {
    private static final List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1, "Áo", 120000, "Size M"));
        products.add(new Product(2, "Quần", 140000, "Size S"));
    }

    @Override
    public List<Product> getAll() {
        return new ArrayList<>(products);
    }

    @Override
    public void add(Product product) {
        products.add(product);
    }

    @Override
    public Product findById(int id) {
        return products.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void update(Product product) {

    }


}
