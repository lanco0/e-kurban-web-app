package com.aurora.ekurban.controller;

import com.aurora.ekurban.dto.KurbanCreateDTO;
import com.aurora.ekurban.dto.KurbanDTO;
import com.aurora.ekurban.enumeration.KurbanCins;
import com.aurora.ekurban.enumeration.KurbanDurum;
import com.aurora.ekurban.service.KurbanService;
import org.springframework.lang.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/kurbanlar")
public class KurbanController {
    @Autowired
    KurbanService kurbanService;

    @GetMapping
    public ResponseEntity<List<KurbanDTO>> getKurbanList(@RequestParam(value = "cins") @Nullable KurbanCins cins) {
        return new ResponseEntity<>(kurbanService.chooseKurbanList(cins), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<KurbanDTO> getKurban(@PathVariable Long id) {
        return new ResponseEntity<>(kurbanService.getKurbanDTO(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<KurbanDTO> addKurban(@RequestBody @Valid KurbanCreateDTO kurbanCreateDTO) {
        return new ResponseEntity<>(kurbanService.addKurban(kurbanCreateDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<KurbanDTO> updateKurban(@PathVariable Long id, @RequestBody @Valid KurbanCreateDTO kurbanCreateDTO) {
        return new ResponseEntity<>(kurbanService.updateKurban(id, kurbanCreateDTO), HttpStatus.OK);
    }

    @PutMapping("/{id}/durum")
    public ResponseEntity<KurbanDTO> updateKurbanDurum(@PathVariable Long id, @RequestParam KurbanDurum kurbanDurum) {
        return new ResponseEntity<>(kurbanService.updateKurbanDurum(id, kurbanDurum), HttpStatus.OK);
    }
}
