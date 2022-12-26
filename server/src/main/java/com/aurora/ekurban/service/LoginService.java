package com.aurora.ekurban.service;

import com.aurora.ekurban.domain.User;
import com.aurora.ekurban.repository.LoginReposiory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {
    private final LoginReposiory loginReposiory;

    public LoginService(LoginReposiory loginReposiory) {
        this.loginReposiory = loginReposiory;
    }

    public List<User> findUser(String eposta) {
        return loginReposiory.findUserByEposta(eposta);
    }

    public List<User> getAllUsers() {
        return loginReposiory.findAll();
    }

}
