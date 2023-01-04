package com.aurora.ekurban.dto;

import com.aurora.ekurban.enumeration.KurbanCins;
import com.aurora.ekurban.enumeration.KurbanDurum;
import com.aurora.ekurban.enumeration.KurbanKunye;

import java.util.List;

/**
 * Kurban bilgilerini Client'a göndermek için kullanılan DTO
 */
public class KurbanDTO {

    /**
     * kurbanın ID'si
     */
    private Long id;
    /**
     * kurbanın cinsi
     */
    private KurbanCins cins;
    /**
     * kurbanın künyesi
     */
    private KurbanKunye kunye;
    /**
     * kurbanın durumu
     */
    private KurbanDurum durum;
    /**
     * kurbanın küpe numarası
     */
    private String kupeNo;
    /**
     * kurbanın kilosu
     */
    private Integer kilo;
    /**
     * kurbanın yaşı
     */
    private Integer yas;
    /**
     * kurbanın fiyatı
     */
    private Integer fiyat;
    /**
     * kurbanın resim yolu
     */
    private String resimUrl;
    /**
     * kurbanın kesim sırası
     */
    private Integer kesimSirasi;
    /**
     * kurbanın cinsine göre sahip olabileceği hisse adedi sayısı
     */
    private Integer hisseAdedi;
    /**
     * kurbanın sahip olduğu hisselerin tutulduğu liste
     */
    private List<HisseDTO> hisseList;


    public KurbanDTO() {
    }

    public KurbanCins getCins() {
        return cins;
    }

    public void setCins(KurbanCins cins) {
        this.cins = cins;
    }

    public KurbanKunye getKunye() {
        return kunye;
    }

    public void setKunye(KurbanKunye kunye) {
        this.kunye = kunye;
    }

    public String getKupeNo() {
        return kupeNo;
    }

    public void setKupeNo(String kupeNo) {
        this.kupeNo = kupeNo;
    }

    public Integer getKilo() {
        return kilo;
    }

    public void setKilo(Integer kilo) {
        this.kilo = kilo;
    }

    public Integer getYas() {
        return yas;
    }

    public void setYas(Integer yas) {
        this.yas = yas;
    }

    public Integer getFiyat() {
        return fiyat;
    }

    public void setFiyat(Integer fiyat) {
        this.fiyat = fiyat;
    }

    public String getResimUrl() {
        return resimUrl;
    }

    public void setResimUrl(String resimUrl) {
        this.resimUrl = resimUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public KurbanDurum getDurum() {
        return durum;
    }

    public void setDurum(KurbanDurum durum) {
        this.durum = durum;
    }

    public List<HisseDTO> getHisseList() {
        return this.hisseList;
    }

    public void setHisseList(List<HisseDTO> hissedarList) {
        this.hisseList = hissedarList;
    }

    public Integer getHisseAdedi() {
        return hisseAdedi;
    }

    public void setHisseAdedi(Integer hisseAdedi) {
        this.hisseAdedi = hisseAdedi;
    }

    public Integer getKesimSirasi() {
        return kesimSirasi;
    }

    public void setKesimSirasi(Integer kesimSirasi) {
        this.kesimSirasi = kesimSirasi;
    }
}
