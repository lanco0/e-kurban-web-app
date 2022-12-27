package com.aurora.ekurban.controller;

import com.aurora.ekurban.domain.User;
import com.aurora.ekurban.service.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1")
public class LoginController {
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/auth")
    public ResponseEntity<HttpStatus> loginOperation(@RequestBody User user) {

        List<User> userList = loginService.findUser(user.getEposta());

        if (userList.size() == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else if (userList.size() == 1) {
            String sifre = userList.get(0).getSifre();

            if (!sifre.equals(user.getSifre())) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
