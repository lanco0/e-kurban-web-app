package com.aurora.ekurban.controller;

import com.aurora.ekurban.domain.Kurban;
import com.aurora.ekurban.dto.KurbanCreateDTO;
import com.aurora.ekurban.service.KurbanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/kurban")
public class KurbanController {
    @Autowired
    KurbanService kurbanService;


    @GetMapping
    public ResponseEntity<List<Kurban>> getKurbanList(){
        return new ResponseEntity<>(kurbanService.getKurbanList(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Kurban> addKurban(@RequestBody @Valid KurbanCreateDTO kurbanCreateDTO) {
        return new ResponseEntity<>(kurbanService.addKurban(kurbanCreateDTO), HttpStatus.CREATED);
    }
}
