package com.aurora.ekurban.bdd.steps;

import com.aurora.ekurban.service.KalanGunService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import java.time.Duration;
import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest
public class KalanGunStepDefinitions {
    private LocalDateTime kurbanBayrami;

    @Autowired
    KalanGunService kalanGunService;

    LocalDateTime kurbanbayrami;

    LocalDateTime bugun;

    @Autowired
    ScenarioContext scenarioContext;

    @Autowired
    MockMvc mockMvc;

    @Given("Kurban bayramı günü sistemde tanımlı olmalıdır")
    public void kurbanBayramiGunuSistemdeTanimliOlmalidir() {
        bugun = LocalDateTime.now();
        kurbanbayrami = kalanGunService.setKurbanBayrami(LocalDateTime.parse("2023-06-28T06:19:00.00"));
    }

    @When("Kullanıcı anasayfaya girdiğinde")
    public void kullaniciAnasayfayaGirdiginde() throws Exception {

        String result = mockMvc.perform(get("/api/v1/kurban-bayramina-kalan-gun"))
                .andDo(print()).andReturn().getResponse().getContentAsString();

        scenarioContext.setContext("result", result);
    }

    @Then("Kurban bayramına kalan günü görür")
    public void kurbanBayraminaKalanGunuGorur() {
        String result = (String) scenarioContext.getContext("result");
        long expectedvalue = Duration.between(bugun, kurbanbayrami).toDays();
        Assert.assertEquals(String.valueOf(expectedvalue), result);
    }


}
