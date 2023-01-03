package com.aurora.ekurban.dto;

public class HisseDTO {

    private Long id;
    private Long kurbanId;
    private Long hissedarId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getKurbanId() {
        return kurbanId;
    }

    public void setKurbanId(Long kurbanId) {
        this.kurbanId = kurbanId;
    }

    public Long getHissedarId() {
        return hissedarId;
    }

    public void setHissedarId(Long hissedarId) {
        this.hissedarId = hissedarId;
    }
}
