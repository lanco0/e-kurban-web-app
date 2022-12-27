package com.aurora.ekurban.bdd.steps;

import com.aurora.ekurban.bdd.runner.CucumberIntegrationTest;
import com.aurora.ekurban.dto.KurbanCreateDTO;
import com.aurora.ekurban.enumeration.KurbanCins;
import com.aurora.ekurban.enumeration.KurbanKunye;
import com.aurora.ekurban.service.KurbanService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@Scope(SCOPE_CUCUMBER_GLUE)
public class KurbanCreateStepDefinitions extends CucumberIntegrationTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    KurbanService kurbanService;
    KurbanCreateDTO kurbanCreateDTO;

    @Autowired
    ScenarioContext scenerioContext;

    /*G I V E N*/
    @Given("Kullanıcı kurban ekleme sayfasına bilgileri doldurmaya başlamıştır")
    public void kullaniciKurbanEklemeSayfasinaBilgileriDoldurmayaBaslamistir(DataTable table) {
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);
        for (Map<String, String> columns : rows) {
            kurbanCreateDTO = new KurbanCreateDTO();
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
    }

    /*W H E N*/
    @When("Kullanıcı kurbanı eklemek istediğinde")
    public void kullaniciKurbaniEklemekIstediginde() throws Exception {
        ObjectWriter objectMapper = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String requestBody = objectMapper.writeValueAsString(kurbanCreateDTO);

        ResultActions result = mockMvc.perform(post("/api/v1/kurban")
                        .content(requestBody)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print());
        scenerioContext.setContext("result", result);
    }

    /*T H E N*/
    @Then("Ekleme işlemi başarısız olur")
    public void eklemeIslemiBasarisizOlur() {
        ResultActions result = (ResultActions) scenerioContext.getContext("result");
        Assert.assertEquals(HttpStatus.FORBIDDEN.value(), result.andReturn().getResponse().getStatus());

    }

    @Then("Ekleme işlemi başarılı olur")
    public void eklemeIslemiBasariliOlur() {
        ResultActions result = (ResultActions) scenerioContext.getContext("result");
        Assert.assertEquals(HttpStatus.OK.value(), result.andReturn().getResponse().getStatus());
    }
}