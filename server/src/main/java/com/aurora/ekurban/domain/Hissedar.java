package com.aurora.ekurban.domain;

import javax.persistence.*;

/**
 * Hissedar bilgilerini tutan entity
 */
@Entity
public class Hissedar {

    /**
     * Hissedarın ID bilgisi veritabanında otomatik olarak artan bir şekilde oluşturulur
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * Hissedarın adı
     */
    private String ad;
    /**
     * Hissedarın soyadı
     */
    private String soyad;
    /**
     * Hissedarın telefon numarası
     */
    private String tel;

    public Hissedar() {
    }

    public Hissedar(String ad, String soyad, String tel) {
        this.ad = ad;
        this.soyad = soyad;
        this.tel = tel;
    }

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
