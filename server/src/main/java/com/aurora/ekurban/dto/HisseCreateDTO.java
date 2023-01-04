package com.aurora.ekurban.dto;

/**
 * Hisse oluşturmak için kullanılan DTO
 */
public class HisseCreateDTO {

    /**
     * hisseye eklenecek kurbanın id'si
     */
    private Long kurbanId;
    /**
     * eklenecek hissedar mevcut hissedarlar arasında varsa id'si
     */
    private Long hissedarId;
    /**
     * eklenecek hissedar mevcut hissedarlar arasında yoksa yeni hissedarın bilgileri
     */
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
