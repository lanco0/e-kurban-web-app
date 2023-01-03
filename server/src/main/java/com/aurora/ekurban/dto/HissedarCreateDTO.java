package com.aurora.ekurban.dto;

import javax.validation.constraints.NotNull;

public class HissedarCreateDTO {

    @NotNull
    private String ad;
    @NotNull
    private String soyAd;
    @NotNull
    private String tel;

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyAd() {
        return soyAd;
    }

    public void setSoyAd(String soyAd) {
        this.soyAd = soyAd;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
