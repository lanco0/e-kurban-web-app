package com.aurora.ekurban.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Hissedar domain class.
 * Yeni kurban hissedarı eklemek için kullanılır.
 * Hissedar sınıfı, hissedarın adı, soyadı, telefonu, adresi gibi bilgileri içerir.
 */
@Entity
public class Hissedar {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String ad;
    private String soyAd;
    private Long tel;
    public Hissedar() {
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

    public Hissedar( String ad, String soyAd, Long tel) {
        this.ad = ad;
        this.soyAd = soyAd;
        this.tel = tel;
    }
}
