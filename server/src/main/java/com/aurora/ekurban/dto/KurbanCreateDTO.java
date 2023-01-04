package com.aurora.ekurban.dto;

import com.aurora.ekurban.enumeration.KurbanCins;
import com.aurora.ekurban.enumeration.KurbanKunye;

import javax.validation.constraints.NotNull;

/**
 * Kurban oluşturmak için Client tarafından gönderilen kurban bilgileri
 */
public class KurbanCreateDTO {

    /**
     * kurbanın cinsi,
     * Boş bırakılamaz
     */
    @NotNull
    private KurbanCins cins;
    /**
     * kurbanın kunyesi,
     * Boş bırakılamaz
     */
    @NotNull
    private KurbanKunye kunye;
    /**
     * kurbanın küpe numarası,
     * Boş bırakılamaz
     */
    @NotNull
    private String kupeNo;
    /**
     * kurbanın kilosu,
     * Boş bırakılamaz
     */
    @NotNull
    private Integer kilo;
    /**
     * kurbanın yaşı,
     * Boş bırakılamaz
     */
    @NotNull
    private Integer yas;
    /**
     * kurbanın fiyatı,
     * Boş bırakılamaz
     */
    @NotNull
    private Integer fiyat;
    /**
     * kurbanın resim yolu,
     * Boş bırakılamaz
     */
    @NotNull
    private String resimUrl;

    public KurbanCreateDTO() {
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

}
