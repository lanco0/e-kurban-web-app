package com.aurora.ekurban.bdd.steps;

import com.aurora.ekurban.dto.HisseCreateDTO;
import com.aurora.ekurban.dto.HissedarCreateDTO;
import com.aurora.ekurban.dto.KurbanCreateDTO;
import com.aurora.ekurban.dto.KurbanDTO;
import com.aurora.ekurban.enumeration.KurbanCins;
import com.aurora.ekurban.enumeration.KurbanKunye;
import com.aurora.ekurban.service.HissedarService;
import com.aurora.ekurban.service.KurbanService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

public class HisseStepdefinitions {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    KurbanService kurbanService;

    @Autowired
    HissedarService hissedarService;

    @Autowired
    ScenarioContext scenerioContext;

    @Given("Aşağıdaki kurban eklenmiş olsun")
    public void asagidakiKurbanEklenmisOlsun(DataTable table) {
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);

        KurbanCreateDTO kurbanCreateDTO = new KurbanCreateDTO();

        for (Map<String, String> columns : rows) {
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
            KurbanDTO kurbanDTO = kurbanService.addKurban(kurbanCreateDTO);
            scenerioContext.setContext(columns.get("id") ,kurbanDTO.getId());
        }

    }

    @Given("Aşağıdaki hissedar eklenmiş olsun")
    public void asagidakiHissedarEklenmisOlsun(DataTable table) {
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);

        HissedarCreateDTO hissedarCreateDTO = new HissedarCreateDTO();

        for (Map<String, String> columns : rows) {
            if (columns.get("ad") != null) {
                hissedarCreateDTO.setAd(columns.get("ad"));
            }
            if (columns.get("soyad") != null) {
                hissedarCreateDTO.setSoyad(columns.get("soyad"));
            }
            if (columns.get("tel") != null) {
                hissedarCreateDTO.setTel(columns.get("tel"));
            }

            Long hissedarId = hissedarService.addHissedar(hissedarCreateDTO);
            scenerioContext.setContext(columns.get("id") , hissedarId);
        }

    }


    @When("{string} nolu kurbana {string} nolu hissedar eklenmek istendiğinde")
    public void noluKurbanaNoluHissedarEklenmekIstendiginde(String kurbanId, String hissedarId) throws Exception {
        HisseCreateDTO hisseCreateDTO = new HisseCreateDTO();
        hisseCreateDTO.setKurbanId((Long) scenerioContext.getContext(kurbanId));
        hisseCreateDTO.setHissedarId((Long) scenerioContext.getContext(hissedarId));

        ObjectWriter objectMapper = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String requestBody = objectMapper.writeValueAsString(hisseCreateDTO);

        ResultActions result = mockMvc.perform(post("/api/v1/hisseler")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andDo(print());

        scenerioContext.setContext("result", result);
    }

    @Then("Hisse ekleme işlemi başarılı olur")
    public void hisseEklemeIslemiBasariliOlur() {
        ResultActions result = (ResultActions) scenerioContext.getContext("result");
        Assert.assertEquals(HttpStatus.CREATED.value(), result.andReturn().getResponse().getStatus());
    }
}
