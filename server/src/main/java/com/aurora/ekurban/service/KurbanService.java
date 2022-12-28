package com.aurora.ekurban.service;

import com.aurora.ekurban.domain.Kurban;
import com.aurora.ekurban.dto.KurbanCreateDTO;
import com.aurora.ekurban.dto.KurbanDTO;
import com.aurora.ekurban.enumeration.KurbanCins;
import com.aurora.ekurban.enumeration.KurbanDurum;
import com.aurora.ekurban.repository.KurbanRepository;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KurbanService {

    @Autowired
    KurbanRepository kurbanRepository;

    private int kesimSequence = 1;
    private static final Integer BUYUK_BAS_HISSE = 7;
    private static final Integer KUCUK_BAS_HISSE = 1;

    public int getKesimSequence() {
        return kesimSequence++;
    }

    public KurbanDTO convertEntityToDto(@NotNull Kurban kurban) {
        KurbanDTO tempKurban = new KurbanDTO();
        tempKurban.setId(kurban.getId());
        tempKurban.setCins(kurban.getCins());
        tempKurban.setKunye(kurban.getKunye());
        tempKurban.setDurum(kurban.getDurum());
        tempKurban.setKupeNo(kurban.getKupeNo());
        tempKurban.setKilo(kurban.getKilo());
        tempKurban.setYas(kurban.getYas());
        tempKurban.setKesimSirasi(kurban.getKesimSirasi());
        tempKurban.setHisseAdedi(kurban.getHisseAdedi());
        tempKurban.setResimUrl(kurban.getResimUrl());
        tempKurban.setHissedarList(kurban.getHissedarList());
        return tempKurban;
    }

    public List<KurbanDTO> choseKurbanList(@Nullable KurbanCins kurbanCins) {
        if (kurbanCins != null) return getChosenCinsList(kurbanCins);
        return getAllKurbanList();
    }

    public List<KurbanDTO> getChosenCinsList(KurbanCins kurbanCins) {
        List<Kurban> chosenCinsList = kurbanRepository.findAllByKurbanCinsThanEqual(kurbanCins);
        List<KurbanDTO> kurbanDTOList = new ArrayList<>();
        chosenCinsList.forEach(kurban -> kurbanDTOList.add(convertEntityToDto(kurban)));
        return kurbanDTOList;
    }

    public List<KurbanDTO> getAllKurbanList() {
        List<Kurban> allKurbanList = kurbanRepository.findAll();
        List<KurbanDTO> kurbanDTOList = new ArrayList<>();
        allKurbanList.forEach(kurban -> kurbanDTOList.add(convertEntityToDto(kurban)));
        return kurbanDTOList;
    }

    public KurbanDTO getKurbanDTO(Long id) {
        Kurban kurban = kurbanRepository.findById(id).orElseThrow();
        return convertEntityToDto(kurban);
    }

    public KurbanDTO addKurban(@NotNull KurbanCreateDTO kurbanCreateDTO) throws Error {
        Kurban kurban = new Kurban(kurbanCreateDTO.getCins(), kurbanCreateDTO.getKunye(), kurbanCreateDTO.getKupeNo(),
                kurbanCreateDTO.getKilo(), kurbanCreateDTO.getYas(), kurbanCreateDTO.getFiyat(), getKesimSequence(),
                kurbanCreateDTO.getResimUrl());

        if (kurban.getCins() == KurbanCins.BUYUKBAS) {
            kurban.setHisseAdedi(BUYUK_BAS_HISSE);
        } else kurban.setHisseAdedi(KUCUK_BAS_HISSE);

        kurbanRepository.save(kurban);
        return convertEntityToDto(kurban);
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
        return convertEntityToDto(kurban);
    }

    public KurbanDTO updateKurbanDurum(Long id, KurbanDurum kurbanDurum) {
        Kurban kurban = kurbanRepository.findById(id).orElseThrow();
        kurban.setDurum(kurbanDurum);
        kurbanRepository.save(kurban);
        return convertEntityToDto(kurban);
    }
}