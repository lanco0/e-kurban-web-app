package com.aurora.ekurban.dto;

/**
 * Hisse bilgilerini Client tarafından göndermek için kullanılan DTO
 */
public class HisseDTO {

    /**
     * hissenin ID'si
     */
    private Long id;
    /**
     * hissenin hangi kurban'a ait olduğu ID bilgisi
     */
    private Long kurbanId;
    /**
     * hissenin hangi hissedara ait olduğu ID bilgisi
     */
    private Long hissedarId;
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
