package com.reqres.api.test.service;

import com.reqres.api.test.context.ScenarioContext;
import com.reqres.api.test.context.TestContext;
import com.reqres.api.test.utils.ConfigUtils;


public class AbstractSteps {

    private TestContext testContext;
    private ScenarioContext scenarioContext;

    public void beforeEachScenario() {
        testContext = TestContext.getTestContext();
        scenarioContext = testContext.getScenarioContext();

        if (!ConfigUtils.isLoaded()) {
            ConfigUtils.load();
        }
    }

    public void afterEachScenario(){
        testContext.reset();
    }

    public TestContext getTestContext() {
        return testContext;
    }

    public ScenarioContext getScenarioContext() {
        return scenarioContext;
    }
}