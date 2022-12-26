package com.aurora.ekurban.bdd.steps;

import com.aurora.ekurban.bdd.runner.CucumberIntegrationTest;
import com.aurora.ekurban.dto.KurbanCreateDTO;
import com.aurora.ekurban.service.KurbanService;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.test.web.servlet.MockMvc;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

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
    public void kullaniciKurbanEklemeSayfasinaBilgileriDoldurmayaBaslamistir(DataTable table){

    }
    /*W H E N*/
    @When("Kullanıcı kurban bilgilerinden en az bir tanesini boş bıraktığında")
    public void kullaniciKurbanBilgilerindenEnAzBirTanesiniBosBiraktiginda() {
    }
    /*T H E N*/
    @Then("Ekleme işlemi başarısız olur")
    public void eklemeIslemiBasarisizOlur() {
    }
}