package com.aurora.ekurban.bdd.steps;

import com.aurora.ekurban.domain.Hissedar;
import com.aurora.ekurban.dto.HissedarCreateDTO;
import com.aurora.ekurban.dto.HissedarDTO;
import com.aurora.ekurban.service.HissedarService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.zh_cn.而且;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.Map;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@Scope(SCOPE_CUCUMBER_GLUE)
public class HissedarStepDefinitions {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    HissedarService hissedarService;

    @Autowired
    ScenarioContext scenarioContext;

    @Given("Listede aşağıdaki bilgileri verilen hissedar mevcut olsun")
    public void listedeAsagidakiBilgileriVerilenHissedarMevcutOlsun(DataTable dataTable) throws Exception {
        HissedarCreateDTO hissedarCreateDTO = new HissedarCreateDTO();
        if (dataTable.asMaps().size() > 0) {
            Map<String, String> columns = dataTable.asMaps().get(0);
            if (columns.get("Ad") != null) {
                hissedarCreateDTO.setAd(columns.get("Ad"));
            }
            if (columns.get("Soyad") != null) {
                hissedarCreateDTO.setSoyad(columns.get("Soyad"));
            }
            if (columns.get("Telefon") != null) {
                hissedarCreateDTO.setTel(columns.get("Telefon"));
            }
        }
        Long hissedarId = hissedarService.addHissedar(hissedarCreateDTO);
        Hissedar hissedar = hissedarService.getHissedar(hissedarId);
        scenarioContext.setContext(hissedar.getTel(), hissedar);
    }


    @When("Hissedar bilgileri aşağıdaki bilgiler ile kaydedilmek istendiğinde")
    public void hissedarBilgileriAsagidakiBilgilerIleKaydedilmekIstendiginde(DataTable dataTable) throws Exception {
        HissedarCreateDTO hissedarCreateDTO = new HissedarCreateDTO();
        if (dataTable.asMaps().size() > 0) {
            Map<String, String> columns = dataTable.asMaps().get(0);
            if (columns.get("Ad") != null) {
                hissedarCreateDTO.setAd(columns.get("Ad"));
            }
            if (columns.get("Soyad") != null) {
                hissedarCreateDTO.setSoyad(columns.get("Soyad"));
            }
            if (columns.get("Telefon") != null) {
                hissedarCreateDTO.setTel(columns.get("Telefon"));
            }
        }

        ObjectWriter objectMapper = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String requestBody = objectMapper.writeValueAsString(hissedarCreateDTO);

        ResultActions result = mockMvc.perform(post("/api/v1/hissedarlar")
                        .content(requestBody)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print());
        scenarioContext.setContext("result", result);
    }

    @When("Kullanıcı hissedar listesini görüntülemek istediğinde")
    public void kullaniciHissedarListesiniGoruntulemekIstediginde() throws Exception {
        ResultActions result = mockMvc.perform(get("/api/v1/hissedarlar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print());
        scenarioContext.setContext("result", result);
        scenarioContext.setContext("hissedarList", hissedarService.getAllHissedarList());
    }

    @When("{string} telefon numaralı hissedarın bilgileri aşağıdaki gibi güncellenmek istendiğinde")
    public void telefonNumaraliHissedarinBilgileriAsagidakiGibiGuncellenmekIstendiginde(String hissedarTelNo, DataTable dataTable) throws Exception {
        HissedarCreateDTO hissedarCreateDTO = new HissedarCreateDTO();
        if (dataTable.asMaps().size() > 0) {
            Map<String, String> columns = dataTable.asMaps().get(0);
            if (columns.get("Ad") != null) {
                hissedarCreateDTO.setAd(columns.get("Ad"));
            }
            if (columns.get("Soyad") != null) {
                hissedarCreateDTO.setSoyad(columns.get("Soyad"));
            }
            if (columns.get("Telefon") != null) {
                hissedarCreateDTO.setTel(columns.get("Telefon"));
            }
        }

        Hissedar hissedar = (Hissedar) scenarioContext.getContext(hissedarTelNo);
        scenarioContext.setContext("hissedar", hissedar);

        ObjectWriter objectMapper = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String requestBody = objectMapper.writeValueAsString(hissedarCreateDTO);

        ResultActions result = mockMvc.perform(put("/api/v1/hissedarlar/{id}", hissedar.getId())
                        .content(requestBody)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print());
        scenarioContext.setContext("result", result);
    }

    @When("{string} telefon numaralı hissedar silinmek istendiğinde")
    public void telefonNumaraliHissedarSilinmekIstendiginde(String hissedarTelNo) throws Exception {
        Hissedar hissedar = (Hissedar) scenarioContext.getContext(hissedarTelNo);
        scenarioContext.setContext("hissedar", hissedar);
        ResultActions result = mockMvc.perform(delete("/api/v1/hissedarlar/{id}", hissedar.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print());
        scenarioContext.setContext("result", result);
    }

    @Then("Hissedar ekleme işlemi başarılı olur")
    public void hissedarEklemeIslemiBasariliOlur() {
        ResultActions result = (ResultActions) scenarioContext.getContext("result");
        Assert.assertEquals(HttpStatus.CREATED.value(), result.andReturn().getResponse().getStatus());
    }

    @Then("Hissedar ekleme işlemi başarısız olur")
    public void hissedarEklemeIslemiBasarisizOlur() {
        ResultActions result = (ResultActions) scenarioContext.getContext("result");
        Assert.assertEquals(HttpStatus.BAD_REQUEST.value(), result.andReturn().getResponse().getStatus());
    }

    @Then("Görütüleme işleminin başarılı olması")
    public void gorutulemeIslemininBasariliOlmasi() {
        ResultActions result = (ResultActions) scenarioContext.getContext("result");
        Assert.assertEquals(HttpStatus.OK.value(), result.andReturn().getResponse().getStatus());
    }

    @Then("Hissedar güncelleme işlemi başarılı olur")
    public void hissedarGuncellemeIslemiBasariliOlur() {
        ResultActions result = (ResultActions) scenarioContext.getContext("result");
        Assert.assertEquals(HttpStatus.OK.value(), result.andReturn().getResponse().getStatus());
    }

    @Then("Hissedar güncelleme işlemi başarısız olur")
    public void hissedarGuncellemeIslemiBasarisizOlur() {
        ResultActions result = (ResultActions) scenarioContext.getContext("result");
        Assert.assertEquals(HttpStatus.BAD_REQUEST.value(), result.andReturn().getResponse().getStatus());
    }

    @Then("Hissedar silme işlemi başarılı olmalıdır")
    public void hissedarSilmeIslemiBasariliOlmalidir() {
        ResultActions result = (ResultActions) scenarioContext.getContext("result");
        Assert.assertEquals(HttpStatus.NO_CONTENT.value(), result.andReturn().getResponse().getStatus());
    }

    @And("Listenin boş olması")
    public void listeninBosOlmasi() {
        Assert.assertEquals(0, ((ArrayList<?>) scenarioContext.getContext("hissedarList")).size());
    }

    @And("Listenin boş olmaması")
    public void listeninBosOlmamasi() {
        Assert.assertNotEquals(0, ((ArrayList<?>) scenarioContext.getContext("hissedarList")).size());
    }

    @And("Yeni soyadı {string} olmalıdır")
    public void yeniSoyadiOlmalidir(String soyad) throws Exception {
        ResultActions result = (ResultActions) scenarioContext.getContext("result");
        String response = result.andReturn().getResponse().getContentAsString();
        HissedarDTO hissedarDTO = new ObjectMapper().readValue(response, HissedarDTO.class);
        Assert.assertEquals(soyad, hissedarDTO.getSoyad());
    }


}
