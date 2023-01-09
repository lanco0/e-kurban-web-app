package com.aurora.ekurban.service;

import com.aurora.ekurban.domain.Hissedar;
import com.aurora.ekurban.dto.HissedarCreateDTO;
import com.aurora.ekurban.dto.HissedarDTO;
import com.aurora.ekurban.repository.HissedarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
     *
     * @param hissedar hissedar entity
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
     *
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
     *
     * @param id hissedar id
     * @return hissedarDTO
     */
    public HissedarDTO getHissedarDTO(Long id) {
        return convertHissedarEntityToDTO(getHissedar(id));
    }

    /**
     * hissedar id'sine göre hissedar entity'sini bulur
     *
     * @param id hissedar id
     * @return hissedar
     */
    public Hissedar getHissedar(Long id) {
        return hissedarRepository.findById(id).orElseThrow();
    }

    /**
     * hissedar ekleme işlemini gerçekleştirir
     *
     * @param hissedarCreateDTO hissedar oluşturmak için gerekli olan bilgiler
     */
    public Long addHissedar(@NotNull HissedarCreateDTO hissedarCreateDTO) throws IllegalArgumentException {
        validateHissedar(hissedarCreateDTO, null);
        Hissedar hissedar = new Hissedar(hissedarCreateDTO.getAd(),
                hissedarCreateDTO.getSoyad(),
                hissedarCreateDTO.getTel());
        hissedarRepository.save(hissedar);
        return hissedar.getId();
    }

    public void validateHissedar(@NotNull HissedarCreateDTO hissedarCreateDTO, Long id) {
        Optional<Hissedar> optionalHissedar = hissedarRepository.findHissedarByTel(hissedarCreateDTO.getTel());

        if (!(isValidAdSoyad(hissedarCreateDTO.getAd(), hissedarCreateDTO.getSoyad()))) {
            throw new IllegalArgumentException("Hissedar adı, soyadı ve telefon numarası boş olamaz! Ve ad ve soyad 3 karakterden az olamaz! Noktalama işaretleri kullanmayınız!");
        }
        if (id == null) {
            if (optionalHissedar.isPresent()) {
                throw new IllegalArgumentException("Bu telefon numarası ile daha önce kayıt yapılmış");
            }
        }
        // ayrı
        if (hissedarCreateDTO.getTel().length() != 11) {
            throw new IllegalArgumentException("Telefon numarası 11 haneli olmalıdır.");
        }


    }

    public boolean isValidAdSoyad(String ad, String soyad) {
        if ((ad != null) && (ad.length() > 2) && (ad.length() < 20) && ad.matches("[a-zA-Z ğüşöçıİĞÜŞÖÇ]+\\S\\D\\Z")) {
            return (soyad != null) && (soyad.length() >= 2) && (soyad.length() < 20) && soyad.matches("[a-zA-Z ğüşöçıİĞÜŞÖÇ]+\\D\\Z");
        }
        return false;
    }

    /**
     * hissedar güncelleme işlemini gerçekleştirir
     * @param hissedarCreateDTO hissedarı güncellemek için gerekli olan bilgiler
     */
    public Long updateHissedar(Long id, @NotNull HissedarCreateDTO hissedarCreateDTO) {
        // eski ad: bektaş
        // eski soyad: ışık
        // eski tel: 0123

        //senario1: sadece adı soyadı değişti
        // yeni ad: emre
        // yeni soyad: yavuz
        // yeni tel: 0123

        //senaryo2: sadece tel değişti ama teli başka bir hissedarın teli olabilir
        // yeni ad: bektaş
        // yeni soyad: ışık
        // yeni tel: 0123

        validateHissedar(hissedarCreateDTO, id);
        Hissedar hissedar = hissedarRepository.findById(id).orElseThrow();
        hissedar.setAd(hissedarCreateDTO.getAd());
        hissedar.setSoyad(hissedarCreateDTO.getSoyad());
        hissedar.setTel(hissedarCreateDTO.getTel());
        hissedarRepository.save(hissedar);
        return hissedar.getId();
    }

    /**
     * hissedar silme işlemini gerçekleştirir
     *
     * @param id silinecek hissedar id
     */
    public void deleteHissedar(Long id) {
        hissedarRepository.delete(getHissedar(id));
    }
}
