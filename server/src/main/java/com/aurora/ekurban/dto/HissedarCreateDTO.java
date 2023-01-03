package com.aurora.ekurban.dto;

import javax.validation.constraints.NotNull;

public class HissedarCreateDTO {

    @NotNull
    private String ad;
    @NotNull
    private String soyad;
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
