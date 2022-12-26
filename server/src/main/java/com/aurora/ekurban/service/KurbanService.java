package com.aurora.ekurban.service;

import com.aurora.ekurban.domain.Kurban;
import com.aurora.ekurban.dto.KurbanCreateDTO;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

@Service
public class KurbanService {
    private int kesimSequence = 1;

    public int getKesimSequence() {
        return kesimSequence++;
    }

    public Kurban addKurban(@NotNull KurbanCreateDTO kurbanCreateDTO){
        Kurban kurban = new Kurban(
                kurbanCreateDTO.getCins(), kurbanCreateDTO.getKunye(),
                kurbanCreateDTO.getDurum(), kurbanCreateDTO.getKupeNo(),
                kurbanCreateDTO.getKilo(), kurbanCreateDTO.getYas(),
                kurbanCreateDTO.getFiyat(),getKesimSequence(),
                kurbanCreateDTO.getResimUrl());


        return kurban;
    }
}
