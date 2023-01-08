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

import javax.transaction.Transactional;
import java.util.MissingFormatArgumentException;

/**
 * hisse işlemlerini gerçekleştirecek olan service katmanı
 */
@Service
@Transactional
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
     * @param  hisse hisse entity'si
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
     * Repository'den hisse entity'sini döndürür
     * @param id hisse id'si
     * @return hisse
     */
    public Hisse getHisseById(Long id) {
        return hisseRepository.findById(id).orElseThrow();
    }

    /**
     * Kurbana ait hisse oluşturur,
     * eğer kurbana hissedar eklenirken hissedar mevcut ise hissedarı bulur ve kurbana ekler,
     * değilse yeni hissedar oluşturur ve kurbana ekler
     * kurban hisseleri doluysa hata fırlatır
     * @param hisseCreateDTO hisse id'si, kurban id'si, hissedar id'si
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
        hisseRepository.save(hisse);
        kurban.getHisseList().add(hisse);
        kurbanService.updateDurum(kurban);
    }

    /**
     * hisseyi günceller
     * yeni hissedarı mevcut hissedar ile değiştirir
     * @param hisseCreateDTO hisse id'si, kurban id'si, yeni hissedar id'si
     */
    public void updateHisse(Long id, @NotNull HisseCreateDTO hisseCreateDTO) {
        Hisse hisse = getHisseById(id);
        Hissedar hissedar = hissedarService.getHissedar(hisseCreateDTO.getHissedarId());
        hisse.setHissedar(hissedar);
        kurbanService.save(kurbanService.getKurban(hisseCreateDTO.getKurbanId()));
    }

    /**
     * hissedeki hissedarı siler
     * @param id hisse id
     */
    public void deleteHissedarOnHisse(Long id) {
        Hisse hisse = getHisseById(id);
        Kurban kurban = hisse.getKurban();
        hisseRepository.deleteById(id);
        kurbanService.updateDurum(kurban);
    }
}
