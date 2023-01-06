package com.aurora.ekurban.bdd.steps;

import com.aurora.ekurban.bdd.runner.CucumberIntegrationTest;
import com.aurora.ekurban.dto.KurbanCreateDTO;
import com.aurora.ekurban.dto.KurbanDTO;
import com.aurora.ekurban.enumeration.KurbanCins;
import com.aurora.ekurban.enumeration.KurbanKunye;
import com.aurora.ekurban.service.KurbanService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.jetbrains.annotations.NotNull;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;
import java.util.Map;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@Scope(SCOPE_CUCUMBER_GLUE)
@WebMvcTest
public class KurbanStepDefinitions extends CucumberIntegrationTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    KurbanService kurbanService;
    KurbanCreateDTO kurbanCreateDTO;
    KurbanDTO kurbanDTO;

    @Autowired
    ScenarioContext scenerioContext;

    /*G I V E N*/
    @Given("Kullanıcı kurban ekleme sayfasına bilgileri doldurmaya başlamıştır")
    public void kullaniciKurbanEklemeSayfasinaBilgileriDoldurmayaBaslamistir(@NotNull DataTable table) {
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

    @Given("Kurban Listesine aşağıdaki kurban eklenmiş olsun")
    public void kurbanListesindeSadeceAsagidakiKurbanEklenmisOlsun(DataTable table) {
        kullaniciKurbanEklemeSayfasinaBilgileriDoldurmayaBaslamistir(table);
        KurbanDTO kurbanDTO = kurbanService.addKurban(kurbanCreateDTO);
        scenerioContext.setContext("kurbanId", kurbanDTO.getId());
    }

    /*W H E N*/

    @When("Kullanıcı kurban listesininin tamamını görüntülemek isterse")
    public void kullaniciKurbanListesinininTamaminiGoruntulemekIsterse() throws Exception {
        ResultActions result = mockMvc.perform(get("/api/v1/kurbanlar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print());
        scenerioContext.setContext("result", result);
    }

    @When("Kullanıcı kurban listesininin {string} olanları görüntülemek isterse")
    public void kullaniciKurbanListesinininOlanlariGoruntulemekIsterse(String cins) throws Exception {

        ResultActions result = mockMvc.perform(get("/api/v1/kurbanlar")
                        .queryParam("cins", cins)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print());
        scenerioContext.setContext("result", result);
    }


    @When("Kullanıcı kurbanı eklemek istediğinde")
    public void kullaniciKurbaniEklemekIstediginde() throws Exception {
        ObjectWriter objectMapper = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String requestBody = objectMapper.writeValueAsString(kurbanCreateDTO);

        ResultActions result = mockMvc.perform(post("/api/v1/kurbanlar")
                        .content(requestBody)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print());
        scenerioContext.setContext("result", result);
    }

    @When("Yeni Kurban eklenmek istendiğinde")
    public void yeniKurbanEklenmekIstendiginde(DataTable table) throws Exception {
        scenerioContext.setContext("oldListSize", kurbanService.getAllKurbanList().size());
        kullaniciKurbanEklemeSayfasinaBilgileriDoldurmayaBaslamistir(table);
        kullaniciKurbaniEklemekIstediginde();
    }

    @When("Aşağıdaki bilgiler ile güncellenmek istendiğinde")
    public void asagidakiBilgilerIleGuncellenmekIstendiginde(DataTable table) throws Exception {
        kullaniciKurbanEklemeSayfasinaBilgileriDoldurmayaBaslamistir(table);
        ObjectWriter objectMapper = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String requestBody = objectMapper.writeValueAsString(kurbanCreateDTO);
        KurbanDTO kurbanDTO = kurbanService.getKurbanDTO((Long) scenerioContext.getContext("kurbanId"));
        scenerioContext.setContext("kurbanKunye", kurbanDTO.getKunye());

        ResultActions result = mockMvc.perform(put("/api/v1/kurbanlar/{id}", scenerioContext.getContext("kurbanId"))
                        .content(requestBody)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print());
        scenerioContext.setContext("result", result);
    }

    /*T H E N*/

    @Then("Kurbanlar başarılı şekilde ekrana yansıtılır")
    public void kurbanlarBasariliSekildeEkranaYansitilir() {
        Assert.assertEquals(HttpStatus.OK.value(), ((ResultActions) scenerioContext.getContext("result")).andReturn().getResponse().getStatus());
    }

    @Then("Ekleme işlemi başarısız olur")
    public void eklemeIslemiBasarisizOlur() {
        ResultActions result = (ResultActions) scenerioContext.getContext("result");
        Assert.assertEquals(HttpStatus.BAD_REQUEST.value(), result.andReturn().getResponse().getStatus());
    }

    @Then("Ekleme işlemi başarılı olur")
    public void eklemeIslemiBasariliOlur() {
        ResultActions result = (ResultActions) scenerioContext.getContext("result");
        Assert.assertEquals(HttpStatus.CREATED.value(), result.andReturn().getResponse().getStatus());
    }

    @Then("Kurban listesinde mevcut kurban sayısı {int} artmalı")
    public void kurbanListesindeMevcutKurbanSayisiArtmali(int size) {
        Assert.assertEquals(scenerioContext.getContext("oldListSize"), kurbanService.getAllKurbanList().size() - size);
    }

    @Then("Güncelleme işlemi başarısız olur")
    public void guncellemeIslemiBasarisizOlur() throws Exception {
        ResultActions result = (ResultActions) scenerioContext.getContext("result");
        Assert.assertEquals(HttpStatus.BAD_REQUEST.value(), result.andReturn().getResponse().getStatus());

    }

    @Then("Güncelleme işlemi başarılı olur")
    public void guncellemeIslemiBasariliOlur() {
        ResultActions result = (ResultActions) scenerioContext.getContext("result");
        Assert.assertEquals(HttpStatus.OK.value(), result.andReturn().getResponse().getStatus());
    }

    @Then("Kunye ismi {string} olmalıdır")
    public void kunyeIsmiOlmalidir(String kunye) {
        Assert.assertEquals(kunye, scenerioContext.getContext("kurbanKunye"));
    }
}