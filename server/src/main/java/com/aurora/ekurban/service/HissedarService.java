package com.aurora.ekurban.service;

import com.aurora.ekurban.domain.Hissedar;
import com.aurora.ekurban.dto.HissedarCreateDTO;
import com.aurora.ekurban.dto.HissedarDTO;
import com.aurora.ekurban.dto.KurbanDTO;
import com.aurora.ekurban.enumeration.KurbanCins;
import com.aurora.ekurban.enumeration.KurbanDurum;
import com.aurora.ekurban.repository.HisseRepository;
import com.aurora.ekurban.repository.HissedarRepository;
import com.aurora.ekurban.repository.KurbanRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HissedarService {

    @Autowired
    HissedarRepository hissedarRepository;
    @Lazy
    @Autowired
    KurbanService kurbanService;
    @Autowired
    KurbanRepository kurbanRepository;
    @Autowired
    HisseRepository hisseRepository;

    public HissedarDTO convertHissedarEntityToDTO(@NotNull Hissedar hissedar) {
        HissedarDTO tempHissedar = new HissedarDTO();
        tempHissedar.setId(hissedar.getId());
        tempHissedar.setAd(hissedar.getAd());
        tempHissedar.setSoyAd(hissedar.getSoyAd());
        tempHissedar.setTel(hissedar.getTel());
        return tempHissedar;
    }

    public List<HissedarDTO> getAllHissedarList() {
        List<Hissedar> allHissedarList = hissedarRepository.findAll();
        List<HissedarDTO> hissedarDTOList = new ArrayList<>();
        allHissedarList.forEach(hissedar -> hissedarDTOList.add(convertHissedarEntityToDTO(hissedar)));
        return hissedarDTOList;
    }

    public HissedarDTO getHissedarDTO(Long id) {
        return convertHissedarEntityToDTO(getHissedar(id));
    }

    public Hissedar getHissedar(Long id) {
        return hissedarRepository.findById(id).orElseThrow();
    }

    public HissedarCreateDTO addHissedar(@NotNull HissedarCreateDTO hissedarCreateDTO) {
        Hissedar hissedar = new Hissedar(hissedarCreateDTO.getAd(), hissedarCreateDTO.getSoyAd(), hissedarCreateDTO.getTel());
        hissedarRepository.save(hissedar);
        return hissedarCreateDTO;
    }

    public void deleteHissedar(Long hissedarId) {
        hissedarRepository.delete(getHissedar(hissedarId));
    }

//        Kurban kurban = kurbanRepository.findById(kurbanId).orElseThrow();
//        Hisse hisse = new Hisse(kurban,hissedar);
//        kurban.getHisseList().add(hisse);
//        hisseRepository.save(hisse);
//        kurbanRepository.save(kurban);
//        KurbanDTO chosenKurbanDTO = kurbanService.convertKurbanEntityToDTO(kurban);
//        setKurbanState(chosenKurbanDTO);

    private static void setKurbanState(@NotNull KurbanDTO chosenKurbanDTO) {
        boolean isAllHissesSold = chosenKurbanDTO.getCins() == KurbanCins.BUYUKBAS && chosenKurbanDTO.getHissedarList().size() == chosenKurbanDTO.getHisseAdedi() ||
                chosenKurbanDTO.getCins() == KurbanCins.KUCUKBAS && chosenKurbanDTO.getHissedarList().size() == chosenKurbanDTO.getHisseAdedi();

        if (isAllHissesSold) {
            chosenKurbanDTO.setDurum(KurbanDurum.SATILDI);
        } else chosenKurbanDTO.setDurum(KurbanDurum.SATISTA);
    }

    public HissedarDTO updateHissedar(Long id, @NotNull HissedarCreateDTO hissedarCreateDTO) {
        Hissedar hissedar = hissedarRepository.findById(id).orElseThrow();
        hissedar.setAd(hissedarCreateDTO.getAd());
        hissedar.setSoyAd(hissedarCreateDTO.getSoyAd());
        hissedar.setTel(hissedarCreateDTO.getTel());
        hissedarRepository.save(hissedar);
        return convertHissedarEntityToDTO(hissedar);
    }

    public void deleteHissedar(Long kurbanId, Long hissedarId) {
        hissedarRepository.delete(getHissedar(hissedarId));
        setKurbanState(kurbanService.getKurbanDTO(kurbanId));
    }
}
