package com.aurora.ekurban.domain;

import com.aurora.ekurban.enumeration.KurbanDurum;

import javax.persistence.*;

/**
 * Hissedarlara kesecekleri kurbanlarının durumları hakkında sistemde kayıtlı olan mesajları şablon olarak tutan sınıf
 * @author mehmetercan
 */
@Entity
public class Mesaj {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * Hissedara gönderilecek olan mesajın içeriği
     */
    private String mesaj;

    /**
     * Hissedara gönderilecek olan mesajın türü
     * Bu türler şunlardır: KESİLDİ, TELEF,
     */
    private KurbanDurum tur;

    public Mesaj() {
    }

    public Mesaj(String mesaj, KurbanDurum tur) {
        this.mesaj = mesaj;
        this.tur = tur;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMesaj() {
        return mesaj;
    }

    public void setMesaj(String mesaj) {
        this.mesaj = mesaj;
    }

    public KurbanDurum getTur() {
        return tur;
    }

    public void setTur(KurbanDurum tur) {
        this.tur = tur;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
