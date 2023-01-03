package com.aurora.ekurban.dto;

public class HissedarDTO {

    private Long id;
    private String ad;
    private String soyAd;
    private Long tel;
    private Integer haveHisse;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Integer getHaveHisse() {
        return haveHisse;
    }

    public void setHaveHisse(Integer haveHisse) {
        this.haveHisse = haveHisse;
    }
}
