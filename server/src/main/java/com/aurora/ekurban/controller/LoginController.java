package com.aurora.ekurban.controller;

import com.aurora.ekurban.domain.User;
import com.aurora.ekurban.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * Kullanıcının login ve logout olma işlemlerini gerçekleştiren contoller sınıfı
 */
@RestController
@RequestMapping("api/v1")
public class LoginController {

    /**
     * @param userService constructor ile servis inject ediliyor
     */
    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/giris")
    public Optional<User> loginOperation(@RequestBody User user) {
        return userService.validate(user);
    }

    @PostMapping("/cikis")
    public ResponseEntity<Boolean> logoutOperation(@RequestBody User user) {
        return new ResponseEntity<>(userService.logout(), HttpStatus.OK);
    }
}