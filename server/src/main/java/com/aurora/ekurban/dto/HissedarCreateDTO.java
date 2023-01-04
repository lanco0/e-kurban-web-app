package com.aurora.ekurban.dto;

import javax.validation.constraints.NotNull;

/**
 * Hissedar oluşturmak için Client tarafından gönderilen hissedar bilgileri
 */
public class HissedarCreateDTO {

    /**
     * hissedarın adı,
     * Boş bırakılamaz
     */
    @NotNull
    private String ad;
    /**
     * hissedarın soyadı,
     * Boş bırakılamaz
     */
    @NotNull
    private String soyad;
    /**
     * hissedarın telefon numarası,
     * Boş bırakılamaz
     */
    @NotNull
    private String tel;

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
