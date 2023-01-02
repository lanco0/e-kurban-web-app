package com.aurora.ekurban.bdd.steps;

import com.aurora.ekurban.dto.HissedarCreateDTO;
import com.aurora.ekurban.dto.KurbanCreateDTO;
import com.aurora.ekurban.enumeration.KurbanCins;
import com.aurora.ekurban.enumeration.KurbanKunye;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class DataTableTypes {

    @Autowired
    ScenarioContext scenerioContext;

    public KurbanCreateDTO toKurbanCreateDTO(Map<String, String> columns) {
        KurbanCreateDTO kurbanCreateDTO = new KurbanCreateDTO();
        if (columns.size() > 0) {
            if (columns.get("cins") != null) {
                kurbanCreateDTO.setCins(KurbanCins.valueOf(columns.get("cins")));
            }
            if (columns.get("kunye") != null) {
                kurbanCreateDTO.setKunye(KurbanKunye.valueOf(columns.get("kunye")));
            }
            if (columns.get("kupeNo") != null) {
                kurbanCreateDTO.setKupeNo(columns.get("kupeNo"));
            }
            if (columns.get("kilo") != null) {
                kurbanCreateDTO.setKilo(Integer.valueOf(columns.get("kilo")));
            }
            if (columns.get("yas") != null) {
                kurbanCreateDTO.setYas(Integer.valueOf(columns.get("yas")));
            }
            if (columns.get("fiyat") != null) {
                kurbanCreateDTO.setFiyat(Integer.valueOf(columns.get("fiyat")));
            }
            if (columns.get("resimUrl") != null) {
                kurbanCreateDTO.setResimUrl(columns.get("resimUrl"));
            }
        }
        return kurbanCreateDTO;
    }

    @DataTableType
    public List<KurbanCreateDTO> toKurbanCreateDTOList(@NotNull DataTable dataTable) {
        ArrayList<KurbanCreateDTO> kurbanCreateDTOList = new ArrayList<>();
        for (Map<String, String> columns : dataTable.asMaps()) {
            kurbanCreateDTOList.add(toKurbanCreateDTO(columns));
        }
        return kurbanCreateDTOList;
    }

    @DataTableType
    public HissedarCreateDTO toHissedarCreateDTO(@NotNull DataTable dataTable) {
        HissedarCreateDTO hissedarCreateDTO = new HissedarCreateDTO();
        if (dataTable.asMaps().size() > 0) {
            Map<String, String> columns = dataTable.asMaps().get(0);
            if (columns.get("Ad") != null) {
                hissedarCreateDTO.setAd(columns.get("Ad"));
            }
            if (columns.get("Soyad") != null) {
                hissedarCreateDTO.setSoyAd(columns.get("Soyad"));
            }
            if (columns.get("Telefon") != null) {
                hissedarCreateDTO.setTel(Long.valueOf(columns.get("Telefon")));
            }
        }
        return hissedarCreateDTO;
    }
}
