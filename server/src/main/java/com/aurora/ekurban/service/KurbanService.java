package com.aurora.ekurban.service;

import com.aurora.ekurban.domain.Kurban;
import com.aurora.ekurban.dto.KurbanCreateDTO;
import com.aurora.ekurban.repository.KurbanRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KurbanService {

    @Autowired
    KurbanRepository kurbanRepository;

    private int kesimSequence = 1;

    public int getKesimSequence() {
        return kesimSequence++;
    }

    public Kurban addKurban(@NotNull KurbanCreateDTO kurbanCreateDTO){
        Kurban kurban = new Kurban(
                kurbanCreateDTO.getCins(), kurbanCreateDTO.getKunye(),
                kurbanCreateDTO.getKupeNo(), kurbanCreateDTO.getKilo(),
                kurbanCreateDTO.getYas(), kurbanCreateDTO.getFiyat(),
                getKesimSequence(), kurbanCreateDTO.getResimUrl());
        return kurbanRepository.save(kurban);
    }
}
