package com.aurora.ekurban.controller;

import com.aurora.ekurban.domain.Kurban;
import com.aurora.ekurban.dto.KurbanDTO;
import com.aurora.ekurban.service.KurbanService;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/kurbanlar")
public class KurbanController {
    @Autowired
    KurbanService kurbanService;

    @GetMapping
    public ResponseEntity<List<Kurban>> getKurbanList() {
        return new ResponseEntity<List<Kurban>>(kurbanService.getKurbanList(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Kurban> getKurban(@PathVariable Long id) {
        return new ResponseEntity<Kurban>(kurbanService.getKurban(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<KurbanDTO> addKurban(@RequestBody @Valid KurbanDTO kurbanDTO) {
        return new ResponseEntity<KurbanDTO>(kurbanService.addKurban(kurbanDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<KurbanDTO> updateKurban(@PathVariable Long id, @RequestBody @Valid KurbanDTO kurbanDTO) {
        return new ResponseEntity<KurbanDTO>(kurbanService.updateKurban(id, kurbanDTO), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public void updateKurbanDurum(@PathVariable Long id,
                                  @RequestParam("KESILDI") @Nullable String kesildi,
                                  @RequestParam("TELEF") @Nullable String telef) {
        kurbanService.updateKurbanDurum(id, kesildi, telef);
    }

}
