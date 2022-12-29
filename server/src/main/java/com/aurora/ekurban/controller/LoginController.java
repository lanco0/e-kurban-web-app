package com.aurora.ekurban.controller;

import com.aurora.ekurban.domain.User;
import com.aurora.ekurban.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class LoginController {
    private final UserService userService;

    /**
     *
     * @param userService constructor ile servis inject ediliyor
     */
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/giris")
    public Optional<User> loginOperation(@RequestBody User user) {
        return userService.validate(user);
    }
}