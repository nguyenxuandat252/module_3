package com.example.product.service;

import com.example.product.repository.ILoginRepository;
import com.example.product.repository.LoginRepository;

public class LoginService implements ILoginService{
    private ILoginRepository loginRepository = new LoginRepository();
    @Override
    public String existUser(String username, String password) {
        return loginRepository.existUser(username,password);
    }
}
