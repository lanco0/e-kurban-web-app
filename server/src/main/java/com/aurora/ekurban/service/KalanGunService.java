package com.aurora.ekurban.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;

@Service
public class KalanGunService {

    @Value("${kurbanBayrami}")
    String kurbanBayrami;

    public int getKurbanBayraminaKalanGun() {
        LocalDateTime kurbanBayramiTarihi = LocalDateTime.parse(kurbanBayrami);
        Duration diff = Duration.between(LocalDateTime.now(), kurbanBayramiTarihi);
        return (int) diff.toDays();
    }
}
