package com.aurora.ekurban.controller;

import com.aurora.ekurban.domain.User;
import com.aurora.ekurban.service.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoginController {
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/auth/q")
    public ResponseEntity<HttpStatus> loginOperation(@RequestParam(name = "name") String name, @RequestParam(name = "pass") String pass) {

        List<User> userList = loginService.findUser(name);

        if (userList.size() == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else if (userList.size() == 1) {
            String sifre = userList.get(0).getSifre();
            if (!sifre.equals(pass)) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<>(loginService.getAllUsers(), HttpStatus.OK);
    }


}
