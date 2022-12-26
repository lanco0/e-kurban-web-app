package com.aurora.ekurban.bdd.steps;

import com.aurora.ekurban.bdd.runner.CucumberIntegrationTest;
import com.aurora.ekurban.domain.enums.KurbanCins;
import com.aurora.ekurban.domain.enums.KurbanDurum;
import com.aurora.ekurban.domain.enums.KurbanKunye;
import com.aurora.ekurban.dto.KurbanCreateDTO;
import com.aurora.ekurban.service.KurbanService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.protocol.HTTP;
import org.jetbrains.annotations.NotNull;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Map;

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
            kurbanCreateDTO.setCins(KurbanCins.valueOf(columns.get("cins")));
            kurbanCreateDTO.setKunye(KurbanKunye.valueOf(columns.get("kunye")));
            kurbanCreateDTO.setKupeNo(columns.get("kupeNo"));
            kurbanCreateDTO.setKilo(Integer.valueOf(columns.get("kilo")));
            kurbanCreateDTO.setYas(Integer.valueOf(columns.get("yas")));
            kurbanCreateDTO.setFiyat(Integer.valueOf(columns.get("fiyat")));
            kurbanCreateDTO.setResimUrl(columns.get("resimUrl"));
        }
    }

    @Given("Kurban bilgilerini aşağıdaki gibi girmiş olmalıdır")
    public void kurbanBilgileriniAsagidakiGibiGirmisOlmalidir(@NotNull DataTable table) {
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);
        for (Map<String, String> columns : rows) {
            kurbanCreateDTO = new KurbanCreateDTO();
            kurbanCreateDTO.setCins(KurbanCins.valueOf(columns.get("cins")));
            kurbanCreateDTO.setKunye(KurbanKunye.valueOf(columns.get("kunye")));
            kurbanCreateDTO.setKupeNo(columns.get("kupeNo"));
            kurbanCreateDTO.setKilo(Integer.valueOf(columns.get("kilo")));
            kurbanCreateDTO.setYas(Integer.valueOf(columns.get("yas")));
            kurbanCreateDTO.setFiyat(Integer.valueOf(columns.get("fiyat")));
            kurbanCreateDTO.setResimUrl(columns.get("resimUrl"));
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
        Assert.assertEquals(200, result.andReturn().getResponse().getStatus());
    }
}