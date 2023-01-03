package com.aurora.ekurban.bdd.steps;

import com.aurora.ekurban.bdd.runner.CucumberIntegrationTest;
import com.aurora.ekurban.dto.HissedarCreateDTO;
import com.aurora.ekurban.dto.KurbanCreateDTO;
import com.aurora.ekurban.dto.KurbanDTO;
import com.aurora.ekurban.service.KurbanService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
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

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@Scope(SCOPE_CUCUMBER_GLUE)
public class HissedarStepDefinitions extends CucumberIntegrationTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ScenarioContext scenerioContext;
    @Autowired
    KurbanService kurbanService;


    /*G I V E N*/
    @Given("Aşağıdaki kurbanlar eklenmiş olsun")
    public void asagidakiKurbanlarEklenmisOlsun(List<KurbanCreateDTO> kurbanCreateDTOS) {
        kurbanCreateDTOS.forEach(kurbanCreateDTO -> {
            KurbanDTO kurbanDTO = kurbanService.addKurban(kurbanCreateDTO);
            this.scenerioContext.setContext(kurbanDTO.getKupeNo(), kurbanDTO);
        });
    }

    /*W H E N*/
    @When("{string} nolu küpe numarasına aşağıdaki hissedar eklendiğinde")
    public void noluKupeNumarasinaAsagidakiHissedarEklendiginde(HissedarCreateDTO hissedarCreateDTO, String kupeNo) throws Exception {
        KurbanDTO kurbanDTO = (KurbanDTO) this.scenerioContext.getContext(kupeNo);

        ObjectWriter objectMapper = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String requestBody = objectMapper.writeValueAsString(hissedarCreateDTO);

        ResultActions result = mockMvc.perform(post("/api/v1/kurbanlar/{kurbanId}/hissedar", kurbanDTO.getId())
                        .content(requestBody)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print());
        scenerioContext.setContext("result", result);

    }

    /*T H E N*/
    @Then("Hissedar ekleme işlemi başarılı olur")
    public void hissedarEklemeIslemiBasariliOlur() {
        ResultActions result = (ResultActions) scenerioContext.getContext("result");
        Assert.assertEquals(HttpStatus.CREATED.value(), result.andReturn().getResponse().getStatus());
    }

}