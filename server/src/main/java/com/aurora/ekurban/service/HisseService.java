package com.aurora.ekurban.service;

import com.aurora.ekurban.domain.Hisse;
import com.aurora.ekurban.domain.Hissedar;
import com.aurora.ekurban.domain.Kurban;
import com.aurora.ekurban.dto.HisseCreateDTO;
import com.aurora.ekurban.dto.HisseDTO;
import com.aurora.ekurban.repository.HisseRepository;
import com.aurora.ekurban.repository.HissedarRepository;
import com.aurora.ekurban.repository.KurbanRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

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
    @Autowired
    private KurbanRepository kurbanRepository;
    @Autowired
    private HissedarRepository hissedarRepository;

    public HisseDTO convertHisseEntityToDTO(@NotNull Hisse hisse) {
        HisseDTO tempHisse = new HisseDTO();
        tempHisse.setId(hisse.getId());
        tempHisse.setKurbanDTO(kurbanService.convertKurbanEntityToDTO(hisse.getKurban()));
        tempHisse.setHissedarDTO(hissedarService.convertHissedarEntityToDTO(hisse.getHissedar()));
        return tempHisse;
    }

    public HisseCreateDTO addHisse(@NotNull HisseCreateDTO hisseCreateDTO) {
        Kurban kurban = kurbanRepository.findById(hisseCreateDTO.getKurbanId()).orElseThrow();
        Hissedar hissedar = hissedarRepository.findById(hisseCreateDTO.getHissedarId()).orElseThrow();
        Hisse hisse = new Hisse(kurban, hissedar);
        hisseRepository.save(hisse);
        return hisseCreateDTO;
    }

    public HisseCreateDTO updateHisse(Long id, @NotNull HisseCreateDTO hisseCreateDTO) {
        Hisse hisse = hisseRepository.findById(id).orElseThrow();
        Hissedar hissedar = hissedarRepository.findById(hisseCreateDTO.getHissedarId()).orElseThrow();
        hisse.setHissedar(hissedar);
        hisseRepository.save(hisse);
        return hisseCreateDTO;
    }

    public void deleteHissedarOnHisse(Long id) {
        Hisse hisse = hisseRepository.findById(id).orElseThrow();
        hisse.setHissedar(null);
        hisseRepository.save(hisse);

    }

}
