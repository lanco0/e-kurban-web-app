package com.aurora.ekurban.service;

import com.aurora.ekurban.domain.Hissedar;
import com.aurora.ekurban.dto.HissedarCreateDTO;
import com.aurora.ekurban.dto.HissedarDTO;
import com.aurora.ekurban.repository.HissedarRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * hissedar CRUD işlemlerini gerçekleştirecek olan service katmanı
 */
@Service
public class HissedarService {

    @Autowired
    HissedarRepository hissedarRepository;
    @Lazy
    @Autowired
    KurbanService kurbanService;

    /**
     * hissedar entity'sini hissedarDTO'ya dönüştürür
     * @param hissedar
     * @return hissedarDTO
     */
    public HissedarDTO convertHissedarEntityToDTO(Hissedar hissedar) {
        HissedarDTO tempHissedar = new HissedarDTO();
        tempHissedar.setId(hissedar.getId());
        tempHissedar.setAd(hissedar.getAd());
        tempHissedar.setSoyad(hissedar.getSoyad());
        tempHissedar.setTel(hissedar.getTel());
        return tempHissedar;
    }

    /**
     * hissedarlar listesini hissedarDTO listesine dönüştürür
     * ekrana hissedarlar listesini göstermek için kullanılır
     * @return hissedarDTO listesi
     */
    public List<HissedarDTO> getAllHissedarList() {
        List<Hissedar> allHissedarList = hissedarRepository.findAll();
        List<HissedarDTO> hissedarDTOList = new ArrayList<>();
        allHissedarList.forEach(hissedar -> hissedarDTOList.add(convertHissedarEntityToDTO(hissedar)));
        return hissedarDTOList;
    }

    /**
     * hissedar id'sine göre hissedarDTO bulur
     * @param id
     * @return hissedarDTO
     */
    public HissedarDTO getHissedarDTO(Long id) {
        return convertHissedarEntityToDTO(getHissedar(id));
    }

    /**
     * hissedar id'sine göre hissedar entity'sini bulur
     * @param id
     * @return hissedar
     */
    public Hissedar getHissedar(Long id) {
        return hissedarRepository.findById(id).orElseThrow();
    }

    /**
     * hissedar ekleme işlemini gerçekleştirir
     * @param hissedarCreateDTO
     */
    public Long addHissedar(@NotNull HissedarCreateDTO hissedarCreateDTO) {
        Hissedar hissedar = new Hissedar(hissedarCreateDTO.getAd(),
                hissedarCreateDTO.getSoyad(),
                hissedarCreateDTO.getTel());
        hissedarRepository.save(hissedar);
        return hissedar.getId();
    }

    /**
     * hissedar güncelleme işlemini gerçekleştirir
     * @param hissedarCreateDTO
     */
    public HissedarDTO updateHissedar(Long id, @NotNull HissedarCreateDTO hissedarCreateDTO) {
        Hissedar hissedar = hissedarRepository.findById(id).orElseThrow();
        hissedar.setAd(hissedarCreateDTO.getAd());
        hissedar.setSoyad(hissedarCreateDTO.getSoyad());
        hissedar.setTel(hissedarCreateDTO.getTel());
        hissedarRepository.save(hissedar);
        return convertHissedarEntityToDTO(hissedar);
    }

    /**
     * hissedar silme işlemini gerçekleştirir
     * @param id
     */
    public void deleteHissedar(Long id) {
        hissedarRepository.delete(getHissedar(id));
    }
}
