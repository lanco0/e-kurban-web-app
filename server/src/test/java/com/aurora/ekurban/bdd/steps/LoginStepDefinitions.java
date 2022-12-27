package com.aurora.ekurban.bdd.steps;

import com.aurora.ekurban.domain.User;
import com.aurora.ekurban.service.LoginService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class LoginStepDefinitions {
    @Autowired
    LoginService loginService;
    @Autowired
    MockMvc mockMvc;
    String username, password;
    ResultActions result;
    User user;
    ObjectMapper objectMapper = new ObjectMapper();

    @Given("Kullanıcının giriş bilgileri kendisine verilmiştir {string} ve {string}")
    public void kullanicininGirisBilgileriKendisineVerilmistirVe(String username, String password) {
        user = new User(username, password);
    }

    @When("Mail adresi ve şifre ile giriş yapılır")
    public void mailAdresiVeSifreIleGirisYapilir() throws Exception {
        //result = mockMvc.perform(get("/auth/q?name=" + username + "&pass=" + password)).andDo(print());
        String requestBody = objectMapper.writeValueAsString(user);

        result = mockMvc.perform(post("/auth")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody)).andDo(print());

    }

    @Then("Kullanıcı sisteme girmiş olur")
    public void kullaniciSistemeGirmisOlur() throws Exception {
        result.andExpect(status().isOk()).andDo(print());
    }


    @Then("Kullanıcı sistemde kayıtlı olmadığı için sisteme giriş yapamaz")
    public void kullaniciSistemdeKayitliOlmadigiIcinSistemGirisYapamaz() throws Exception {
        result.andExpect((status().isNotFound())).andDo(print());
    }
}























