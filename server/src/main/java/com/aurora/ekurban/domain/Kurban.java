package com.aurora.ekurban.domain;

import com.aurora.ekurban.enumeration.KurbanCins;
import com.aurora.ekurban.enumeration.KurbanDurum;
import com.aurora.ekurban.enumeration.KurbanKunye;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Kurban domain class.
 * Yeni bir kurban oluşturmak için bu sınıfı kullanın.
 * Kurban sınıfı, kurbanın türü, cinsi, durumu, fiyatı, ağırlığı gibi bilgileri içerir.
 * Kurban sınıfı, kurbanın fotoğrafını da içerir.
 * Kurban sınıfı, kurbanın sahibi olan hissedarların sahip olduğu hisse sınıfını da içerir.
 */
@Entity
public class Kurban {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Enumerated(EnumType.STRING)
    private KurbanCins cins;
    @Enumerated(EnumType.STRING)
    private KurbanKunye kunye;
    @Enumerated(EnumType.STRING)
    private KurbanDurum durum;


    private String kupeNo;
    private Integer kilo;
    private Integer yas;
    private Integer fiyat;
    private Integer kesimSirasi;
    private String resimUrl;

    //List<Hisse> hisseList;

    public Kurban() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public KurbanCins getCins() {
        return cins;
    }

    public void setCins(KurbanCins cins) {
        this.cins = cins;
    }

    public KurbanKunye getKunye() {
        return kunye;
    }

    public void setKunye(KurbanKunye kunye) {
        this.kunye = kunye;
    }

    public KurbanDurum getDurum() {
        return durum;
    }

    public void setDurum(KurbanDurum durum) {
        this.durum = durum;
    }

    public String getKupeNo() {
        return kupeNo;
    }

    public void setKupeNo(String kupeNo) {
        this.kupeNo = kupeNo;
    }

    public Integer getKilo() {
        return kilo;
    }

    public void setKilo(Integer kilo) {
        this.kilo = kilo;
    }

    public Integer getYas() {
        return yas;
    }

    public void setYas(Integer yas) {
        this.yas = yas;
    }

    public Integer getFiyat() {
        return fiyat;
    }

    public void setFiyat(Integer fiyat) {
        this.fiyat = fiyat;
    }

    public Integer getKesimSirasi() {
        return kesimSirasi;
    }

    public void setKesimSirasi(Integer kesimSirasi) {
        this.kesimSirasi = kesimSirasi;
    }

    public String getResimUrl() {
        return resimUrl;
    }

    public void setResimUrl(String resimUrl) {
        this.resimUrl = resimUrl;
    }

    public Kurban(KurbanCins cins, KurbanKunye kunye, String kupeNo,
                  Integer kilo, Integer yas, Integer fiyat, Integer kesimSirasi, String resimUrl) {
        this.cins = cins;
        this.kunye = kunye;
        this.durum = KurbanDurum.SATISTA;
        this.kupeNo = kupeNo;
        this.kilo = kilo;
        this.yas = yas;
        this.fiyat = fiyat;
        this.kesimSirasi = kesimSirasi;
        this.resimUrl = resimUrl;
        //this.hisseList = new ArrayList<>();
    }
}
