package com.example.product.repository;

import com.example.product.model.User;

public interface IRegisterRepository {
    boolean existUser(String username);
    boolean add(User user);
    String getRoleByUsername(String username);
}
