package com.aurora.ekurban.domain;

import javax.persistence.*;
@Entity
public class Hisse {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private Integer hisseNo;

    @ManyToOne
    @JoinColumn(name = "id")
    private Hissedar hissedar;

    public Hisse() {
    }

    public Hissedar getHissedar() {
        return hissedar;
    }

    public void setHissedar(Hissedar hissedar) {
        this.hissedar = hissedar;
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
        this.hissedar = hissedar;
    }
}
