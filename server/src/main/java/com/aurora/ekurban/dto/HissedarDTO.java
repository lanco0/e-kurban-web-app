package com.aurora.ekurban.dto;

/**
 * Hissedar bilgilerini Client tarafından göndermek için kullanılan DTO
 */
public class HissedarDTO {

    /**
     * hissedarın ID'si
     */
    private Long id;
    /**
     * hissedarın adı
     */
    private String ad;
    /**
     * hissedarın soyadı
     */
    private String soyad;
    /**
     * hissedarın telefon numarası
     */
    private String tel;
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
