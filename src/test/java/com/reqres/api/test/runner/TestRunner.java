package com.reqres.api.test.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json"},
        glue = {"com.reqres.api.test.stepDefinitions"},
        features = {"src/test/resources/features"},
        tags = {"@reqres"},
        format = {"pretty", "html:target/report"}
)
public class TestRunner {
}