package com.example.nhanvien_crud.repository;

import com.example.nhanvien_crud.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private static List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1, "SamSung", 1000000, 11, "ok"));
        products.add(new Product(2, "Nokia", 5000000, 15, "ok"));
        products.add(new Product(3, "Iphone", 7000000, 21, "ok"));
        products.add(new Product(4, "Oppo", 15000000, 101, "ok"));
    }

    @Override
    public List<Product> getAll() {
        return products;
    }

    @Override
    public void add(Product newProduct) {
        products.add(newProduct);
    }

    @Override
    public boolean update(int id, Product newProduct) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                products.set(i, newProduct);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                products.remove(product);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Product> searchById(String keyWord) {

        List<Product> result = new ArrayList<>();
        for (Product student : products) {
            if (String.valueOf(student.getId()).equals(keyWord) || student.getName().toLowerCase().contains(keyWord.toLowerCase())) {
                result.add(student);
            }
        }
        return result;
    }


}
