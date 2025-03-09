package com.example.product.service;

import com.example.product.model.User;
import com.example.product.repository.IRegisterRepository;
import com.example.product.repository.RegisterRepository;

public class RegisterService implements IRegisterService{
    private IRegisterRepository registerRepository = new RegisterRepository();
    @Override
    public boolean existUser(String username) {
        return registerRepository.existUser(username);
    }

    @Override
    public boolean add(User user) {
        return registerRepository.add(user);
    }

    @Override
    public String getRoleByUsername(String username) {
        return registerRepository.getRoleByUsername(username);
    }
}
