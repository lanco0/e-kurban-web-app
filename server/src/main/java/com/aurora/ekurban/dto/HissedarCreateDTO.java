package com.aurora.ekurban.dto;

import javax.validation.constraints.NotNull;

public class HissedarCreateDTO {

    @NotNull
    private String ad;
    @NotNull
    private String soyAd;
    @NotNull
    private Long tel;

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

    public Long getTel() {
        return tel;
    }

    public void setTel(Long tel) {
        this.tel = tel;
    }
}
