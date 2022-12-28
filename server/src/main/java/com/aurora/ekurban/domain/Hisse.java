package com.aurora.ekurban.domain;

import javax.persistence.*;

/**
 * Hisse domain class.
 * Yapilan kurbanin hisse bilgilerini tutar.
 * Yeni kurban eklendiginde kurbanin hisse bilgileri bu tabloya eklenir.
 * Hisselerin durumu, kurbanin durumuna gore degisir.
 */
@Entity
public class Hisse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    //TODO: ilgili hisseye ait kurban bilgisi
    //private Kurban kurban;

    //TODO: ilgili hissenin sahibi bilgisi
    //private Hissedar hissedar;

    private Integer hisseNo;

    public Hisse() {
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getHisseNo() {
        return hisseNo;
    }

    public void setHisseNo(Integer hisseNo) {
        this.hisseNo = hisseNo;
    }

    public Hisse(Integer hisseNo, Hissedar hissedar) {
        this.hisseNo = hisseNo;
    }
}
