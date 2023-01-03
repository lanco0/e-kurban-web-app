package com.aurora.ekurban.service;

import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;

@Service
public class KalanGunService {

    private final LocalDateTime kurbanBayrami = LocalDateTime.of(2023, 6, 28, 6, 19);

    public int getKurbanBayraminaKalanGun() {
        Duration diff = Duration.between(LocalDateTime.now(), kurbanBayrami);
        return (int) diff.toDays();
    }
}
