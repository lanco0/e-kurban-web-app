package com.aurora.ekurban.service;

import com.aurora.ekurban.domain.User;
import com.aurora.ekurban.repository.UserReposiory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserReposiory userReposiory;

    public UserService(UserReposiory userReposiory) {
        this.userReposiory = userReposiory;
    }

    public List<User> findUser(String eposta) {
        return userReposiory.findUserByEposta(eposta);
    }

}
