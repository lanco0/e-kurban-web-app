package com.aurora.ekurban.definitions.loginstepdefs;

import com.aurora.ekurban.service.LoginService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest//(controllers = LoginController.class)
public class LoginStepDefinitions {
    @Autowired
    LoginService loginService;
    @Autowired
    MockMvc mockMvc;
    String username, password;
    ResultActions result;


    @Given("Kullanıcının giriş bilgileri kendisine verilmiştir {string} ve {string}")
    public void kullanicininGirisBilgileriKendisineVerilmistirVe(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @When("Mail adresi ve şifre ile giriş yapılır")
    public void mailAdresiVeSifreIleGirisYapilir() throws Exception {
        result = mockMvc.perform(get("/auth/q?name=" + username + "&pass=" + password)).andDo(print());
    }

    @Then("Kullanıcı sisteme girmiş olur")
    public void kullaniciSistemeGirmisOlur() throws Exception {
        result.andExpect(status().isOk()).andDo(print());
    }


}























