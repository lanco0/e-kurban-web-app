package com.aurora.ekurban.service;

import com.aurora.ekurban.domain.Kurban;
import com.aurora.ekurban.dto.KurbanCreateDTO;
import com.aurora.ekurban.dto.KurbanDTO;
import com.aurora.ekurban.enumeration.KurbanCins;
import com.aurora.ekurban.enumeration.KurbanDurum;
import com.aurora.ekurban.repository.KurbanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

/**
 * kurban CRUD işlemlerini gerçekleştirecek olan service katmanı
 */
@Service
public class KurbanService {
    @Lazy
    @Autowired
    HisseService hisseService;
    @Autowired
    KurbanRepository kurbanRepository;

    /**
     * küçükbaş hayvanların kesim sırasını belirler
     */
    private int kesimBuyukBasSequence = 1;
    /**
     * büyükbaş hayvanların kesim sırasını belirler
     */
    private int kesimKucukBasSequence = 1;

    public static final Integer BUYUK_BAS_HISSE = 7;
    public static final Integer KUCUK_BAS_HISSE = 1;

    public int getKesimBuyukBasSequence() {
        return kesimBuyukBasSequence++;
    }

    public int getKesimKucukBasSequence() {
        return kesimKucukBasSequence++;
    }

    /**
     * kurban entity'sini kurbanDTO'ya dönüştürür
     * @param kurban kurban entity'si
     * @return kurbanDTO
     */
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

    /**
     * Kurban Cinsi ve Durumuna göre kurban listesini döndürür
     * @param cins  kurban cins değeri
     * @param durum kurban durum değeri
     * @return kurbanDTO listesi
     */
    public List<KurbanDTO> chooseKurbanList(@Nullable KurbanCins cins, @Nullable KurbanDurum durum) {
        List<KurbanDTO> kurbanList;
        if (durum != null) {
            if (cins != null) kurbanList = getChosenCinsAndDurumList(cins, durum);
            else kurbanList = getChosenDurumList(durum);
        } else {
            if (cins != null) kurbanList = getChosenCinsList(cins);
            else kurbanList = getAllKurbanList();
        }
        return kurbanList;
    }

    public List<KurbanDTO> getChosenDurumList(@NotNull KurbanDurum durum) {
        List<Kurban> chosenDurumList = kurbanRepository.findAllByDurum(durum);
        return chosenDurumList.stream()
                .map(this::convertKurbanEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<KurbanDTO> getChosenCinsAndDurumList(KurbanCins kurbanCins, KurbanDurum kurbanDurum) {
        List<Kurban> chosenCinsAndDurumList = kurbanRepository.findAllByCinsAndDurum(kurbanCins, kurbanDurum);
        return chosenCinsAndDurumList.stream()
                .map(this::convertKurbanEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<KurbanDTO> getChosenCinsList(KurbanCins cins) {
        List<Kurban> chosenCinsList = kurbanRepository.findAllByCins(cins);
        return chosenCinsList.stream()
                .map(this::convertKurbanEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<KurbanDTO> getAllKurbanList() {
        List<Kurban> allKurbanList = kurbanRepository.findAll();
        return allKurbanList.stream()
                .map(this::convertKurbanEntityToDTO)
                .collect(Collectors.toList());
    }

    public KurbanDTO getKurbanDTO(Long id) {
        return convertKurbanEntityToDTO(getKurban(id));
    }

    public Kurban getKurban(Long id) {
        return kurbanRepository.findById(id).orElseThrow();
    }

    /**
     * kurban ekleme işlemini gerçekleştirir,
     * eğer kurban büyükbaş ise kesim sırasını büyükbaş sırasına göre belirler,
     * eğer kurban küçükbaş ise kesim sırasını küçükbaş sırasına göre belirler,
     * kurbanın hisse adedini belirler
     *
     * @param kurbanCreateDTO kurban ekleme işleminde kullanılacak olan kurbanCreateDTO
     * @return kurbanDTO
     */
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

    /**
     * kurban güncelleme işlemini gerçekleştirir,
     *
     * @param id güncellenecek kurbanın id değeri
     * @param kurbanCreateDTO kurban güncelleme işleminde kullanılacak olan kurbanCreateDTO
     * @return kurbanDTO
     */
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

    /**
     * kurban durumunu güncelleme işlemini gerçekleştirir,
     *
     * @param id güncellenecek kurbanın id değeri
     * @param kurbanDurum güncellenecek kurbanın yeni durumu
     * @return kurbanDTO
     */
    public KurbanDTO updateKurbanDurum(Long id, KurbanDurum kurbanDurum) {
        Kurban kurban = kurbanRepository.findById(id).orElseThrow();
        kurban.setDurum(kurbanDurum);

        kurbanRepository.save(kurban);
        return convertKurbanEntityToDTO(kurban);
    }

    /**
     * kurbanı repositorye kaydeder
     *
     * @param kurban kurban
     */
    public void save(Kurban kurban) {
        kurbanRepository.save(kurban);
    }

    /**
     * kurban listesinin doluluğunu kontrol eder
     *
     * @param kurban kurban
     * @return true or false
     */
    public boolean isAllHissesSold(Kurban kurban) {
        return (kurban.getCins() == KurbanCins.BUYUKBAS && kurban.getHisseList().size() == kurban.getHisseAdedi()) || (kurban.getCins() == KurbanCins.KUCUKBAS && kurban.getHisseList().size() == kurban.getHisseAdedi());
    }

    /**
     * kurbanın hisseleri tamamı satıldıysa kurbanı satıldı olarak işaretler,
     * kurbanın hisseleri tamamı satılmadıysa kurbanı satışta olarak işaretler
     * @param kurban kurban
     */
    public void updateDurum(Kurban kurban) {
        if (isAllHissesSold(kurban)) {
            kurban.setDurum(KurbanDurum.SATILDI);
        } else kurban.setDurum(KurbanDurum.SATISTA);
        this.save(kurban);
    }

}