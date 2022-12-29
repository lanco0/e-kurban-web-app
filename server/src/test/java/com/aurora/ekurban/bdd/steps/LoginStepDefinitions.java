package com.aurora.ekurban.bdd.steps;

import com.aurora.ekurban.domain.User;
import com.aurora.ekurban.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest
public class LoginStepDefinitions {
    @Autowired
    UserService userService;
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ScenarioContext scenarioContext;
    String username, password;
    User user;
    ObjectMapper objectMapper = new ObjectMapper();

    @Given("Kullanıcının giriş bilgileri kendisine verilmiştir {string} ve {string}")
    public void kullanicininGirisBilgileriKendisineVerilmistirVe(String username, String password) {
        user = new User(username, password);
    }

    @When("Mail adresi ve şifre ile giriş yapılır")
    public void mailAdresiVeSifreIleGirisYapilir() throws Exception {
        String requestBody = objectMapper.writeValueAsString(user);

        ResultActions result = mockMvc.perform(post("/api/v1/giris")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody)).andDo(print());

        scenarioContext.setContext("resultWhenLogin", result);
    }

    @Then("Kullanıcı sisteme girmiş olur")
    public void kullaniciSistemeGirmisOlur() throws Exception {
        ResultActions result = (ResultActions) scenarioContext.getContext("resultWhenLogin");
        Assert.assertEquals(HttpStatus.OK.value(), result.andReturn().getResponse().getStatus());
    }

    @Then("Kullanıcı sistemde kayıtlı olmadığı için sisteme giriş yapamaz")
    public void kullaniciSistemdeKayitliOlmadigiIcinSistemGirisYapamaz() throws Exception {
        ResultActions result = (ResultActions) scenarioContext.getContext("resultWhenLogin");
        Assert.assertEquals(HttpStatus.NOT_FOUND.value(), result.andReturn().getResponse().getStatus());
    }

    @Given("Kullanıcı sisteme login olmuş olmalıdır {string} ve {string}")
    public void kullaniciSistemeLoginOlmusOlmalidirVe(String username, String password) {
        user = new User(username, password);
    }

    @When("Kullanıcı çıkış yapmak istediğinde")
    public void kullaniciCikisYapmakIstediginde() throws Exception {
        String requestBody = objectMapper.writeValueAsString(user);

        ResultActions result = mockMvc.perform(post("/api/v1/cikis")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody)).andDo(print());

        scenarioContext.setContext("resultWhenLogout", result.andReturn().getResponse().getContentAsString());
    }

    @Then("Kullanıcı sistenden çıkış yapar")
    public void kullaniciSistendenCikisYapar() {
        String result = (String) scenarioContext.getContext("resultWhenLogout");
        Assert.assertEquals("true", result);
    }
}