package com.example.product.service;

import com.example.product.model.User;

public interface IRegisterService {
    boolean existUser(String username);
    boolean add(User user);
    String getRoleByUsername(String username);
}
