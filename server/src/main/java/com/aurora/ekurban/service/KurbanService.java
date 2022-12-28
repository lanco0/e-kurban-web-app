package com.aurora.ekurban.service;

import com.aurora.ekurban.domain.Kurban;
import com.aurora.ekurban.dto.KurbanCreateDTO;
import com.aurora.ekurban.dto.KurbanDTO;
import com.aurora.ekurban.enumeration.KurbanDurum;
import com.aurora.ekurban.repository.KurbanRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KurbanService {

    @Autowired
    KurbanRepository kurbanRepository;

    private int kesimSequence = 1;

    public int getKesimSequence() {
        return kesimSequence++;
    }

    public List<KurbanDTO> getKurbanList() {
        List<Kurban> all = kurbanRepository.findAll();
        List<KurbanDTO> kurbanDTOList = new ArrayList<>();
        all.forEach(kurban -> {
            KurbanDTO tempKurban = new KurbanDTO();
            tempKurban.setId(kurban.getId());
            tempKurban.setCins(kurban.getCins());
            tempKurban.setDurum(kurban.getDurum());
            tempKurban.setKilo(kurban.getKilo());
            tempKurban.setFiyat(kurban.getFiyat());
            tempKurban.setKupeNo(kurban.getKupeNo());
            tempKurban.setYas(kurban.getYas());
            tempKurban.setKunye(kurban.getKunye());
            tempKurban.setResimUrl(kurban.getResimUrl());
            tempKurban.setKesimSirasi(kurban.getKesimSirasi());
            kurbanDTOList.add(tempKurban);
        });
        return kurbanDTOList;
    }

    public KurbanDTO getKurbanDTO(Long id) {
        Kurban kurban = kurbanRepository.findById(id).orElseThrow();
        KurbanDTO tempKurban = new KurbanDTO();
        tempKurban.setId(kurban.getId());
        tempKurban.setCins(kurban.getCins());
        tempKurban.setKunye(kurban.getKunye());
        tempKurban.setDurum(kurban.getDurum());
        tempKurban.setKupeNo(kurban.getKupeNo());
        tempKurban.setKilo(kurban.getKilo());
        tempKurban.setYas(kurban.getYas());
        tempKurban.setFiyat(kurban.getFiyat());
        tempKurban.setResimUrl(kurban.getResimUrl());
        return tempKurban;
    }

    public KurbanDTO addKurban(@NotNull KurbanCreateDTO kurbanCreateDTO) throws Error {
        Kurban kurban = new Kurban(
                kurbanCreateDTO.getCins(), kurbanCreateDTO.getKunye(),
                kurbanCreateDTO.getKupeNo(), kurbanCreateDTO.getKilo(),
                kurbanCreateDTO.getYas(), kurbanCreateDTO.getFiyat(),
                getKesimSequence(), kurbanCreateDTO.getResimUrl());
        kurbanRepository.save(kurban);
        return getKurbanDTO(kurban.getId());
    }

    public KurbanDTO updateKurban(Long id, @NotNull KurbanCreateDTO kurbanCreateDTO) {
        Kurban kurban = kurbanRepository.findById(id).orElseThrow();
        kurban.setCins(kurbanCreateDTO.getCins());
        kurban.setKunye(kurbanCreateDTO.getKunye());
        kurban.setKupeNo(kurbanCreateDTO.getKupeNo());
        kurban.setKilo(kurbanCreateDTO.getKilo());
        kurban.setYas(kurbanCreateDTO.getYas());
        kurban.setFiyat(kurbanCreateDTO.getFiyat());
        kurban.setResimUrl(kurbanCreateDTO.getResimUrl());
        kurbanRepository.save(kurban);
        return getKurbanDTO(kurban.getId());
    }

    public KurbanDTO updateKurbanDurum(Long id, KurbanDurum kurbanDurum) {
        Kurban kurban = kurbanRepository.findById(id).orElseThrow();
        kurban.setDurum(kurbanDurum);
        kurbanRepository.save(kurban);
        return getKurbanDTO(kurban.getId());
    }
}
