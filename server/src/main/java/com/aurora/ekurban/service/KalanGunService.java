package com.aurora.ekurban.service;

import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;

@Service
public class KalanGunService {

    /**
     * Kurban bayramı günü bilgisine tutar
     */
    private LocalDateTime kurbanBayrami;

    public int getKurbanBayraminaKalanGun() {
        Duration diff = Duration.between(LocalDateTime.now(), kurbanBayrami);
        return (int) diff.toDays();
    }

    public LocalDateTime setKurbanBayrami(LocalDateTime kurbanBayramiGunu) {
        this.kurbanBayrami = kurbanBayramiGunu;
        return this.kurbanBayrami;
    }
}
