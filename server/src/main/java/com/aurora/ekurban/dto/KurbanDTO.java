package com.aurora.ekurban.dto;

import com.aurora.ekurban.enumeration.KurbanCins;
import com.aurora.ekurban.enumeration.KurbanDurum;
import com.aurora.ekurban.enumeration.KurbanKunye;

import javax.validation.constraints.NotNull;


public class KurbanDTO {

    @NotNull
    private Long id;
    @NotNull
    private KurbanCins cins;
    @NotNull
    private KurbanKunye kunye;
    @NotNull
    private KurbanDurum durum;
    @NotNull
    private String kupeNo;
    @NotNull
    private Integer kilo;
    @NotNull
    private Integer yas;
    @NotNull
    private Integer fiyat;
    @NotNull
    private String resimUrl;
    @NotNull
    private Integer kesimSirasi;
    //private List<Hisse> hisseList;

    public KurbanDTO() {
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

    public String getResimUrl() {
        return resimUrl;
    }

    public void setResimUrl(String resimUrl) {
        this.resimUrl = resimUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public KurbanDurum getDurum() {
        return durum;
    }

    public void setDurum(KurbanDurum durum) {
        this.durum = durum;
    }

//    public List<Hisse> getHisseList() {
//        return hisseList;
//    }

//    public void setHisseList(List<Hisse> hisseList) {
//        this.hisseList = hisseList;
//    }

    public Integer getKesimSirasi() {
        return kesimSirasi;
    }

    public void setKesimSirasi(Integer kesimSirasi) {
        this.kesimSirasi = kesimSirasi;
    }
}
