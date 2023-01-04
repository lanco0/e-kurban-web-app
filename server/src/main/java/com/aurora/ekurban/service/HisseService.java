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

/**
 * hisse işlemlerini gerçekleştirecek olan service katmanı
 */
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

    /**
     * hisse entity'sini hisseDTO'ya dönüştürür
     * @param  hisse
     * @return hisseDTO
     */
    public HisseDTO convertHisseEntityToDTO(@NotNull Hisse hisse) {
        HisseDTO tempHisse = new HisseDTO();
        tempHisse.setId(hisse.getId());
        tempHisse.setKurbanId(hisse.getKurban().getId());
        tempHisse.setHissedarId(hisse.getHissedar().getId());
        tempHisse.setAd(hisse.getHissedar().getAd());
        tempHisse.setSoyad(hisse.getHissedar().getSoyad());
        tempHisse.setTel(hisse.getHissedar().getTel());
        return tempHisse;
    }

    /**
     * Kurbana ait hisse oluşturur,
     * eğer kurbana hissedar eklenirken hissedar mevcut ise hissedarı bulur ve kurbana ekler,
     * değilse yeni hissedar oluşturur ve kurbana ekler
     * kurban hisseleri doluysa hata fırlatır
     * @param hisseCreateDTO
     */
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
        hisseRepository.save(hisse);
        kurbanService.save(kurban);
    }

    /**
     * hisseyi günceller
     * yeni hissedarı mevcut hissedar ile değiştirir
     * @param hisseCreateDTO
     */
    public void updateHisse(Long id, @NotNull HisseCreateDTO hisseCreateDTO) {
        Hisse hisse = hisseRepository.findById(id).orElseThrow();
        Hissedar hissedar = hissedarService.getHissedar(hisseCreateDTO.getHissedarId());
        hisse.setHissedar(hissedar);
        kurbanService.save(kurbanService.getKurban(hisseCreateDTO.getKurbanId()));
    }

    /**
     * hissedeki hissedarı siler
     * @param id
     */
    public void deleteHissedarOnHisse(Long id) {
        Hisse hisse = hisseRepository.findById(id).orElseThrow();
        Kurban kurban = kurbanService.getKurban(hisse.getKurban().getId());
        kurban.getHisseList().remove(hisse);
        kurbanService.updateDurum(hisse.getKurban());
        hisseRepository.delete(hisse);
    }
}
