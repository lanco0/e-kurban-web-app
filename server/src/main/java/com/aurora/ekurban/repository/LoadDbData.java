package com.aurora.ekurban.repository;

import com.aurora.ekurban.domain.Hisse;
import com.aurora.ekurban.domain.Hissedar;
import com.aurora.ekurban.domain.Kurban;
import com.aurora.ekurban.domain.User;
import com.aurora.ekurban.enumeration.KurbanCins;
import com.aurora.ekurban.enumeration.KurbanKunye;
import com.aurora.ekurban.service.KalanGunService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class LoadDbData {
    /**
     * Sisteme yetkili kullanıcının bilgileri ilk çaılışta eklenir
     *
     * @param userReposiory kullanıcı bilgilerini database'e kaydeder
     * @return eklenen kullanıcıyı geri döndürür
     * @author mehmetercan
     */
    @Bean
    CommandLineRunner initData(UserRepository userReposiory, KurbanRepository kurbanRepository,
                               HissedarRepository hissedarRepository, KalanGunService kalanGunService) {
        return args -> {
            User user = new User("user@ekurban.com", "1234");

            Hissedar hissedar = new Hissedar("Mehmet", "Ercan", "12345678L");
            Kurban kurban = new Kurban(KurbanCins.BUYUKBAS, KurbanKunye.KOC, "21A1", 428
                    , 25, 53750, 1, "");
            Hisse hisse = new Hisse(kurban, hissedar);

            kurban.getHisseList().add(hisse);

            kurbanRepository.save(kurban);
            hissedarRepository.save(hissedar);
            userReposiory.save(user);

            kalanGunService.setKurbanBayrami(LocalDateTime.of(2023, 06, 29, 06, 19));

        };
    }
}
