package deckofcards.cucumber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/cucumber/feature/deckofcards"},
        plugin = {"pretty", "html:target/cucumber-html-report", "json:target/cucumber-json-report-tests.json"},
        glue = {"deckofcards.cucumber.stepsdef"})

public class IntegrationTest {
	
}