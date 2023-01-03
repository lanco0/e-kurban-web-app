package com.aurora.ekurban.domain;

import com.aurora.ekurban.enumeration.KurbanCins;
import com.aurora.ekurban.enumeration.KurbanDurum;
import com.aurora.ekurban.enumeration.KurbanKunye;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Kurban bilgilerini tutan entity
 */
@Entity
public class Kurban {

    /**
     * Kurbanın ID'si veritabanında otomatik olarak artan bir şekilde oluşturulur
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * kurbanın cinsi
     */
    @Enumerated(EnumType.STRING)
    private KurbanCins cins;
    /**
     * kurbanın künyesi
     */
    @Enumerated(EnumType.STRING)
    private KurbanKunye kunye;
    /**
     * kurbanın durumu
     */
    @Enumerated(EnumType.STRING)
    private KurbanDurum durum;

    /**
     * kurbanın küpe numarası
     */
    private String kupeNo;
    /**
     * kurbanın kilosu
     */
    private Integer kilo;
    /**
     * kurbanın yaşı
     */
    private Integer yas;
    /**
     * kurbanın fiyatı
     */
    private Integer fiyat;
    /**
     * kurbanın kesim sırası
     */
    private Integer kesimSirasi;
    /**
     * kurbanın cinsine göre sahip olabileceği hisse adedi sayısı
     */
    private Integer hisseAdedi;
    /**
     * kurbanın resim yolu
     */
    private String resimUrl;

    /**
     * kurbanın sahip olduğu hisselerin tutulduğu liste
     * @see Hisse (Hisse ile @OneToMany ilişkisi vardır)
     */
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            targetEntity = Hisse.class,
            mappedBy = "kurban")
    @JsonIgnoreProperties("kurban")
    private List<Hisse> hisseList = new ArrayList<>();

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

    public List<Hisse> getHisseList() {
        return hisseList;
    }

    public void setHisseList(List<Hisse> hisseList) {
        this.hisseList = hisseList;
    }

    public Integer getHisseAdedi() {
        return hisseAdedi;
    }

    public void setHisseAdedi(Integer hisseAdedi) {
        this.hisseAdedi = hisseAdedi;
    }

    public Kurban(KurbanCins cins, KurbanKunye kunye, String kupeNo,
                  Integer kilo, Integer yas, Integer fiyat,
                  Integer kesimSirasi, String resimUrl) {
        this.cins = cins;
        this.kunye = kunye;
        this.durum = KurbanDurum.SATISTA;
        this.kupeNo = kupeNo;
        this.kilo = kilo;
        this.yas = yas;
        this.fiyat = fiyat;
        this.kesimSirasi = kesimSirasi;
        this.resimUrl = resimUrl;
        this.hisseList = new ArrayList<>();
    }
}
