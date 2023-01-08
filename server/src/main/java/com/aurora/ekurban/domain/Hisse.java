package com.aurora.ekurban.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * Hisse bilgileri, kurbanın hissedarlarına ait bilgileri tutar
 */
@Entity
@Table(name = "Hisse")
public class Hisse {

    /**
     * Hisse ID'si veritabanında otomatik olarak artan bir şekilde oluşturulur
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne(
            fetch = FetchType.LAZY,
            cascade = CascadeType.REMOVE,
            targetEntity = Kurban.class,
            optional = false)
    @JoinColumn(name = "kurban_id")
    @JsonIgnoreProperties("hisseList")
    private Kurban kurban;
    @ManyToOne(cascade = CascadeType.REMOVE,
            fetch = FetchType.LAZY,
            targetEntity = Hissedar.class,
            optional = false)
    @JoinColumn(name = "hissedar_id")
    private Hissedar hissedar;

    public Hisse() {
    }

    public Hisse(Kurban kurban, Hissedar hissedar) {
        this.kurban = kurban;
        this.hissedar = hissedar;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Kurban getKurban() {
        return kurban;
    }

    public void setKurban(Kurban kurban) {
        this.kurban = kurban;
    }

    public Hissedar getHissedar() {
        return hissedar;
    }

    public void setHissedar(Hissedar hissedar) {
        this.hissedar = hissedar;
    }
}
