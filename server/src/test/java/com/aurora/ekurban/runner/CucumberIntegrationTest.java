package com.aurora.ekurban.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        plugin = {"pretty", "html:target/cucumber/test.html"},
        glue = {"com.aurora.ekurban.definitions",
                "com.aurora.ekurban.configurations"})
public class CucumberIntegrationTest {
}
