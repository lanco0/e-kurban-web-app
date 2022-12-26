package com.aurora.ekurban.repository;

import com.aurora.ekurban.domain.User;
import com.aurora.ekurban.service.LoginService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDbData {

    @Bean
    CommandLineRunner initData(LoginService loginService,
                               LoginReposiory loginReposiory) {
        return args -> {
            User user = new User("user", "1234");
            loginReposiory.save(user);
        };
    }

}
