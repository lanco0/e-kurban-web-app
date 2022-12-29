package com.aurora.ekurban.bdd.steps;

import com.aurora.ekurban.domain.Hissedar;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MesajStepDefinitions {

    Hissedar hissedar;

    @Given("Hissedarın, halihazırda kurban seçip hissedar listesinde ismi olmalıdır")
    public void hissedarinHalihazirdaKurbanSecipHissedarListesindeIsmiOlmalidir() {
        hissedar = new Hissedar("Mehmet", "Ercan", 12345678L);
    }

    @When("Hissedarların kurbanı kesildiğinde")
    public void hissedarlarinKurbaniKesildiginde() {
    }

    @Then("Hissedarlara kurban kesildi mesajı gönderilir")
    public void hissedarlaraKurbanKesildiMesajiGonderilir() {
    }
}
