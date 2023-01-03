package com.aurora.ekurban.controller;

import com.aurora.ekurban.service.KalanGunService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class KalanGunController {

    private final KalanGunService kalanGunService;

    public KalanGunController(KalanGunService kalanGunService) {
        this.kalanGunService = kalanGunService;
    }

    @GetMapping("/kurban-bayramina-kalan-gun")
    public ResponseEntity<Integer> getKalanGun() {
        Integer kalanGun = kalanGunService.getKurbanBayraminaKalanGun();
        return new ResponseEntity<>(kalanGun, HttpStatus.OK);
    }

}
