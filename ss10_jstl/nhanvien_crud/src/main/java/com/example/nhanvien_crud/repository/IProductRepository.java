package com.example.nhanvien_crud.repository;

import com.example.nhanvien_crud.model.Product;

import java.util.List;

public interface IProductRepository {
  List<Product> getAll();
  void add(Product newProduct);
  boolean update(int id,Product product);
  boolean delete(int id);

  List<Product> searchById(String keyword);
}
