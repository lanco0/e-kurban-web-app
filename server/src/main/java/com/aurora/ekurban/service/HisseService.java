package com.aurora.ekurban.service;

import com.aurora.ekurban.domain.Hisse;
import com.aurora.ekurban.domain.Hissedar;
import com.aurora.ekurban.domain.Kurban;
import com.aurora.ekurban.dto.HisseCreateDTO;
import com.aurora.ekurban.dto.HisseDTO;
import com.aurora.ekurban.repository.HisseRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.MissingFormatArgumentException;

@Service
public class HisseService {
    @Lazy
    @Autowired
    KurbanService kurbanService;
    @Lazy
    @Autowired
    HissedarService hissedarService;
    @Autowired
    HisseRepository hisseRepository;

    public HisseDTO convertHisseEntityToDTO(@NotNull Hisse hisse) {
        HisseDTO tempHisse = new HisseDTO();
        tempHisse.setId(hisse.getId());
        tempHisse.setKurbanDTO(kurbanService.convertKurbanEntityToDTO(hisse.getKurban()));
        tempHisse.setHissedarDTO(hissedarService.convertHissedarEntityToDTO(hisse.getHissedar()));
        return tempHisse;
    }

    public void addHisse(@NotNull HisseCreateDTO hisseCreateDTO) throws MissingFormatArgumentException {
        Kurban kurban = kurbanService.getKurban(hisseCreateDTO.getKurbanId());
        if(kurbanService.isAllHissesSold(kurban)) {
            throw new MissingFormatArgumentException("Hisse Listeniz Doludur...");
        }
        Hissedar hissedar;
        if(hisseCreateDTO.getHissedarId()!=null){
            hissedar = hissedarService.getHissedar(hisseCreateDTO.getHissedarId());
        } else {
            Long hissedarId = hissedarService.addHissedar(hisseCreateDTO.getHissedarCreateDTO());
            hissedar = hissedarService.getHissedar(hissedarId);
        }
        Hisse hisse = new Hisse(kurban, hissedar);
        kurban.getHisseList().add(hisse);
        kurbanService.saveAtRepository(kurban);
    }

    public HisseDTO updateHisse(Long id, @NotNull HisseCreateDTO hisseCreateDTO) {
        Hisse hisse = hisseRepository.findById(id).orElseThrow();
        Hissedar hissedar = hissedarService.getHissedar(hisseCreateDTO.getHissedarId());
        hisse.setHissedar(hissedar);
        hisseRepository.save(hisse);
        return convertHisseEntityToDTO(hisse);
    }

    public void deleteHissedarOnHisse(Long id) {
        Hisse hisse = hisseRepository.findById(id).orElseThrow();
        hisse.setHissedar(null);
        kurbanService.updateState(hisse.getKurban());
        hisseRepository.save(hisse);
    }
}
