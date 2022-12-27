package com.aurora.ekurban.service;

import com.aurora.ekurban.domain.Kurban;
import com.aurora.ekurban.dto.KurbanDTO;
import com.aurora.ekurban.enumeration.KurbanDurum;
import com.aurora.ekurban.repository.KurbanRepository;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KurbanService {

    @Autowired
    KurbanRepository kurbanRepository;

    private int kesimSequence = 1;

    public int getKesimSequence() {
        return kesimSequence++;
    }

    public List<Kurban> getKurbanList() {
        return kurbanRepository.findAll();
    }

    public Kurban getKurban(Long id) {
        return kurbanRepository.findById(id).orElseThrow();
    }

    public KurbanDTO addKurban(@NotNull KurbanDTO kurbanDTO) throws Error {
        Kurban kurban = new Kurban(
                kurbanDTO.getCins(), kurbanDTO.getKunye(),
                kurbanDTO.getKupeNo(), kurbanDTO.getKilo(),
                kurbanDTO.getYas(), kurbanDTO.getFiyat(),
                getKesimSequence(), kurbanDTO.getResimUrl());
        kurbanRepository.save(kurban);
        return kurbanDTO;
    }

    public KurbanDTO updateKurban(Long id, @NotNull KurbanDTO kurbanDTO) {
        Kurban kurban = getKurban(id);
        kurban.setCins(kurbanDTO.getCins());
        kurban.setKunye(kurbanDTO.getKunye());
        kurban.setKupeNo(kurbanDTO.getKupeNo());
        kurban.setKilo(kurbanDTO.getKilo());
        kurban.setYas(kurbanDTO.getYas());
        kurban.setFiyat(kurbanDTO.getFiyat());
        kurban.setResimUrl(kurbanDTO.getResimUrl());
        kurbanRepository.save(kurban);
        return kurbanDTO;
    }

    public void updateKurbanDurum(Long id, @Nullable String kesildi, @Nullable String telef) {
        Kurban kurban = getKurban(id);
        if (kesildi != null) {
            kurban.setDurum(KurbanDurum.KESILDI);
        }
        if (telef != null) {
            kurban.setDurum(KurbanDurum.TELEF);
        }
    }
}
