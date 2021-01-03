package com.cedaniel200.app.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

//comentari primer commit hpol

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = {"src/test/resources/feature/restar.feature"},
glue = {"com.cedaniel200.app.stepdefinitionsns"},
snippets = SnippetType.CAMELCASE)
public class Restar {
}
