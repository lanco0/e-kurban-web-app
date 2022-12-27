package com.aurora.ekurban.bdd.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.aurora.ekurban.bdd.steps",
        plugin = {"pretty", "html:target/cucumber/test.html"}
        )
public class CucumberIntegrationTest {
}
