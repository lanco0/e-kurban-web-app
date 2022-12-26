package com.aurora.ekurban.controller;

import com.aurora.ekurban.domain.Kurban;
import com.aurora.ekurban.dto.KurbanCreateDTO;
import com.aurora.ekurban.service.KurbanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/")
public class KurbanController {
    @Autowired
    KurbanService kurbanService;

    @PostMapping(value = "kurban")
    public Kurban addKurban(@RequestBody KurbanCreateDTO kurbanCreateDTO){
        return kurbanService.addKurban(kurbanCreateDTO);
    }

    @GetMapping(value = "kurban")
    public void foo(){
        System.out.println("foo");
    }
}
