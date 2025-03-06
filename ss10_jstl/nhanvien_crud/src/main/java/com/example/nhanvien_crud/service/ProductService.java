package com.example.nhanvien_crud.service;

import com.example.nhanvien_crud.model.Product;
import com.example.nhanvien_crud.repository.IProductRepository;
import com.example.nhanvien_crud.repository.ProductRepository;

import java.util.List;

public class ProductService implements IProductService{
    private IProductRepository productRepository = new ProductRepository();
    @Override
    public List<Product> getAll() {
        return productRepository.getAll();
    }

    @Override
    public void add(Product newProduct) {
        productRepository.add(newProduct);
    }

    @Override
    public Product findById(int id) {
        List<Product> products = productRepository.getAll();
        for (Product product: products){
            if(product.getId()==id){
                return product;
            }
        }
        return null;
    }

    @Override
    public boolean update(int id, Product product) {
        return productRepository.update(id,product);
    }

    @Override
    public boolean delete(int id) {
        return productRepository.delete(id);
    }

    @Override
    public List<Product> searchById(String keyword) {
        return productRepository.searchById(keyword);
    }


}
