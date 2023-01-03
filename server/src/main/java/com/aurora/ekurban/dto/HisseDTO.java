package com.aurora.ekurban.dto;

public class HisseDTO {

    private Long id;
    private Long kurbanId;
    private Long hissedarId;
    private String ad;
    private String soyAd;
    private String tel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getKurbanId() {
        return kurbanId;
    }

    public void setKurbanId(Long kurbanId) {
        this.kurbanId = kurbanId;
    }

    public Long getHissedarId() {
        return hissedarId;
    }

    public void setHissedarId(Long hissedarId) {
        this.hissedarId = hissedarId;
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
