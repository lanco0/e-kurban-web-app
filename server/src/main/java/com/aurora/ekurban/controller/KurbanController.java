package com.aurora.ekurban.controller;

import com.aurora.ekurban.domain.Kurban;
import com.aurora.ekurban.dto.KurbanCreateDTO;
import com.aurora.ekurban.service.KurbanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/kurban")
public class KurbanController {
    @Autowired
    KurbanService kurbanService;

    @PostMapping
    public Kurban addKurban(@RequestBody KurbanCreateDTO kurbanCreateDTO){
        return null;
    }
}
