package com.aurora.ekurban.repository;

import com.aurora.ekurban.domain.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDbData {
    /**
     * Sisteme yetkili kullanıcının bilgileri ilk çaılışta eklenir
     * @param userReposiory kullanıcı bilgilerini database'e kaydeder
     * @return eklenen kullanıcıyı geri döndürür
     */
    @Bean
    CommandLineRunner initData(UserRepository userReposiory) {
        return args -> {
            User user = new User("user@ekurban.com", "1234");
            userReposiory.save(user);

        };
    }

}
