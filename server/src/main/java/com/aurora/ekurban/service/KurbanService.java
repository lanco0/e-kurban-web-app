package com.aurora.ekurban.service;

import com.aurora.ekurban.domain.Kurban;
import com.aurora.ekurban.dto.KurbanCreateDTO;
import com.aurora.ekurban.dto.KurbanDTO;
import com.aurora.ekurban.enumeration.KurbanCins;
import com.aurora.ekurban.enumeration.KurbanDurum;
import com.aurora.ekurban.repository.KurbanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class KurbanService {
    @Autowired
    HisseService hisseService;
    @Autowired
    KurbanRepository kurbanRepository;

    private int kesimBuyukBasSequence = 1;
    private int kesimKucukBasSequence = 1;
    private static final Integer BUYUK_BAS_HISSE = 7;
    private static final Integer KUCUK_BAS_HISSE = 1;

    public int getKesimBuyukBasSequence() {
        return kesimBuyukBasSequence++;
    }

    public int getKesimKucukBasSequence() {
        return kesimKucukBasSequence++;
    }

    public KurbanDTO convertKurbanEntityToDTO(@NotNull Kurban kurban) {
        KurbanDTO tempKurban = new KurbanDTO();
        tempKurban.setId(kurban.getId());
        tempKurban.setCins(kurban.getCins());
        tempKurban.setKunye(kurban.getKunye());
        tempKurban.setDurum(kurban.getDurum());
        tempKurban.setKupeNo(kurban.getKupeNo());
        tempKurban.setKilo(kurban.getKilo());
        tempKurban.setYas(kurban.getYas());
        tempKurban.setFiyat(kurban.getFiyat());
        tempKurban.setKesimSirasi(kurban.getKesimSirasi());
        tempKurban.setHisseAdedi(kurban.getHisseAdedi());
        tempKurban.setResimUrl(kurban.getResimUrl());
        tempKurban.setHisseList(kurban.getHisseList().stream()
                .map(hisseService::convertHisseEntityToDTO)
                .collect(Collectors.toList()));
        return tempKurban;
    }

    public List<KurbanDTO> choseKurbanList(@Nullable KurbanCins cins) {
        if (cins != null) return getChosenCinsList(cins);
        return getAllKurbanList();
    }

    public List<KurbanDTO> getChosenCinsList(KurbanCins cins) {
        List<Kurban> chosenCinsList = kurbanRepository.findAllByCins(cins);
        List<KurbanDTO> kurbanDTOList = new ArrayList<>();
        chosenCinsList.forEach(kurban -> kurbanDTOList.add(convertKurbanEntityToDTO(kurban)));
        return kurbanDTOList;
    }

    public List<KurbanDTO> getAllKurbanList() {
        List<Kurban> allKurbanList = kurbanRepository.findAll();
        List<KurbanDTO> kurbanDTOList = new ArrayList<>();
        allKurbanList.forEach(kurban -> kurbanDTOList.add(convertKurbanEntityToDTO(kurban)));
        return kurbanDTOList;
    }

    public KurbanDTO getKurbanDTO(Long id) {
        return convertKurbanEntityToDTO(getKurban(id));
    }

    public Kurban getKurban(Long id) {
        return kurbanRepository.findById(id).orElseThrow();
    }

    public KurbanDTO addKurban(@NotNull KurbanCreateDTO kurbanCreateDTO) throws Error {
        Kurban kurban = new Kurban();

        kurban.setCins(kurbanCreateDTO.getCins());
        kurban.setKunye(kurbanCreateDTO.getKunye());
        kurban.setKupeNo(kurbanCreateDTO.getKupeNo());
        kurban.setKilo(kurbanCreateDTO.getKilo());
        kurban.setYas(kurbanCreateDTO.getYas());
        kurban.setFiyat(kurbanCreateDTO.getFiyat());
        kurban.setResimUrl(kurbanCreateDTO.getResimUrl());
        kurban.setDurum(KurbanDurum.SATISTA);

        if (kurbanCreateDTO.getCins().equals(KurbanCins.BUYUKBAS)) {
            kurban.setKesimSirasi(getKesimBuyukBasSequence());
        } else kurban.setKesimSirasi(getKesimKucukBasSequence());

        if (kurban.getCins() == KurbanCins.BUYUKBAS) {
            kurban.setHisseAdedi(BUYUK_BAS_HISSE);
        } else kurban.setHisseAdedi(KUCUK_BAS_HISSE);

        kurbanRepository.save(kurban);
        return convertKurbanEntityToDTO(kurban);
    }

    public KurbanDTO updateKurban(Long id, @NotNull KurbanCreateDTO kurbanCreateDTO) throws Error {
        Kurban kurban = kurbanRepository.findById(id).orElseThrow();

        kurban.setCins(kurbanCreateDTO.getCins());
        kurban.setKunye(kurbanCreateDTO.getKunye());
        kurban.setKupeNo(kurbanCreateDTO.getKupeNo());
        kurban.setKilo(kurbanCreateDTO.getKilo());
        kurban.setYas(kurbanCreateDTO.getYas());
        kurban.setFiyat(kurbanCreateDTO.getFiyat());
        kurban.setResimUrl(kurbanCreateDTO.getResimUrl());

        kurbanRepository.save(kurban);
        return convertKurbanEntityToDTO(kurban);
    }

    public KurbanDTO updateKurbanDurum(Long id, KurbanDurum kurbanDurum) {
        Kurban kurban = kurbanRepository.findById(id).orElseThrow();
        kurban.setDurum(kurbanDurum);

        kurbanRepository.save(kurban);
        return convertKurbanEntityToDTO(kurban);
    }
}