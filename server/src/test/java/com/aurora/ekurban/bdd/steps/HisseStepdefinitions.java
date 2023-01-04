package com.aurora.ekurban.bdd.steps;

import com.aurora.ekurban.dto.HissedarCreateDTO;
import com.aurora.ekurban.dto.KurbanCreateDTO;
import com.aurora.ekurban.enumeration.KurbanCins;
import com.aurora.ekurban.enumeration.KurbanKunye;
import com.aurora.ekurban.service.HisseService;
import com.aurora.ekurban.service.KurbanService;
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

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

public class HisseStepdefinitions {

    @Autowired
    MockMvc mockMvc;
    HissedarCreateDTO hissedarCreateDTO;
    @Autowired
    KurbanService kurbanService;

    @Autowired
    HisseService hisseService;

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
        }
        Long kurbanId = kurbanService.addKurban(kurbanCreateDTO);
        scenerioContext.setContext("kurban",kurbanService.getKurban(kurbanId));

    }

    @Given("Aşağıdaki hissedar eklenmiş olsun")
    public void asagidakiHissedarEklenmisOlsun() {
    }


    @Given("Kurbanid ve hissedarid belirlenmiştir")
    public void kurbanidVeHissedaridBelirlenmistir(@NotNull DataTable table) {
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);
        hissedarCreateDTO = new HissedarCreateDTO();
        for (Map<String, String> columns : rows) {
            if (columns.get("ad") != null) {
                hissedarCreateDTO.setAd(columns.get("ad"));
            }
            if (columns.get("soyad") != null) {
                hissedarCreateDTO.setAd(columns.get("soyad"));
            }
            if (columns.get("tel") != null) {
                hissedarCreateDTO.setAd(columns.get("tel"));
            }
        }

    }

    @When("Hisse eklenmek istendiğinde")
    public void hisseEklenmekIstendiginde() throws Exception {
        ResultActions result = mockMvc.perform(post("/api/v1/hisseler")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(""))
                .andDo(print());

        scenerioContext.setContext("result", result);
    }

    @Then("İlgili kurbana hisse eklenmiş olur")
    public void i̇lgiliKurbanaHisseEklenmisOlur() {
        ResultActions result = (ResultActions) scenerioContext.getContext("result");
        Assert.assertEquals(HttpStatus.CREATED, result.andReturn().getResponse().getStatus());
    }



}
