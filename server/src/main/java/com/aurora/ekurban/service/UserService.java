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

    public boolean isValidUser(User user) {
        List<User> userList = this.findUser(user.getEposta());

        if (userList.size() == 0) {
            return false;
        } else if (userList.size() == 1) {
            String passInDatabase = userList.get(0).getSifre();
            String userEnteredPass = user.getSifre();

            return passInDatabase.equals(userEnteredPass);
        }

        return false;
    }
}
