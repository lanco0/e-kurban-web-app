package com.aurora.ekurban.controller;

import com.aurora.ekurban.enumeration.KurbanDurum;
import com.aurora.ekurban.service.MesajService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MesajController {

    private final MesajService mesajService;

    public MesajController(MesajService mesajService) {
        this.mesajService = mesajService;
    }

    @GetMapping(("/mesaj/{kurbanId}/{hissedarId}"))
    public ResponseEntity<String> sendMesaj(@PathVariable("kurbanId") Long kurbanId
            , @PathVariable("hissedarId") Long hissedarId
            , @RequestParam("") KurbanDurum kurbanDurum) {
        String mesaj = mesajService.sendMesaj(kurbanId, hissedarId, kurbanDurum);
        return new ResponseEntity<>(mesaj, HttpStatus.OK);
    }

}
