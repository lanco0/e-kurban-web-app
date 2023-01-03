package com.aurora.ekurban.dto;

public class HisseCreateDTO {

    private Long kurbanId;
    private Long hissedarId;
    private HissedarCreateDTO hissedarCreateDTO;

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

    public HissedarCreateDTO getHissedarCreateDTO() {
        return hissedarCreateDTO;
    }

    public void setHissedarCreateDTO(HissedarCreateDTO hissedarCreateDTO) {
        this.hissedarCreateDTO = hissedarCreateDTO;
    }
}
