package com.aurora.ekurban.dto;

import com.aurora.ekurban.enumeration.KurbanCins;
import com.aurora.ekurban.enumeration.KurbanDurum;
import com.aurora.ekurban.enumeration.KurbanKunye;

import java.util.List;


public class KurbanDTO {

    private Long id;
    private KurbanCins cins;
    private KurbanKunye kunye;
    private KurbanDurum durum;
    private String kupeNo;
    private Integer kilo;
    private Integer yas;
    private Integer fiyat;
    private String resimUrl;
    private Integer kesimSirasi;
    private Integer hisseAdedi;
    private List<HisseDTO> hisseList;


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

    public List<HisseDTO> getHisseList() {
        return this.hisseList;
    }

    public void setHisseList(List<HisseDTO> hissedarList) {
        this.hisseList = hissedarList;
    }

    public Integer getHisseAdedi() {
        return hisseAdedi;
    }

    public void setHisseAdedi(Integer hisseAdedi) {
        this.hisseAdedi = hisseAdedi;
    }

    public Integer getKesimSirasi() {
        return kesimSirasi;
    }

    public void setKesimSirasi(Integer kesimSirasi) {
        this.kesimSirasi = kesimSirasi;
    }
}
