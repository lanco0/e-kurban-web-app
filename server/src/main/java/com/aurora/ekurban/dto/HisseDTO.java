package com.aurora.ekurban.dto;

public class HisseDTO {

    private Long id;
    private Integer buyHisse;
    private KurbanDTO kurbanDTO;
    private HissedarDTO hissedarDTO;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getBuyHisse() {
        return buyHisse;
    }

    public void setBuyHisse(Integer buyHisse) {
        this.buyHisse = buyHisse;
    }

    public KurbanDTO getKurbanDTO() {
        return kurbanDTO;
    }

    public void setKurbanDTO(KurbanDTO kurbanDTO) {
        this.kurbanDTO = kurbanDTO;
    }

    public HissedarDTO getHissedarDTO() {
        return hissedarDTO;
    }

    public void setHissedarDTO(HissedarDTO hissedarDTO) {
        this.hissedarDTO = hissedarDTO;
    }
}
