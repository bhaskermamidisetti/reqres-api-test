package com.reqres.api.test.stepDefinitions;

import com.reqres.api.test.service.AbstractSteps;
import com.reqres.api.test.service.ServiceApi;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static com.reqres.api.test.constants.ServiceUrlConstants.REQRES_ID;
import static com.reqres.api.test.constants.ServiceUrlConstants.RESPONSE;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;

public class TestApiSteps extends AbstractSteps {
    private ServiceApi serviceApi;

    public TestApiSteps() {
        serviceApi = new ServiceApi();
    }

    @Before
    public void beforeEachScenario() {
        super.beforeEachScenario();
    }

    @Given("^ReqRes Customer register using POST request with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void reqres_Customer_register_using_POST_request_with(String email, String password) {
        Response response = serviceApi.postRegister(email, password);
        Integer registrationId = response.jsonPath().get("id");
        response
                .then()
                .log().all()
                .statusCode(200)
                .body("id", equalTo(registrationId));

        getScenarioContext().set(REQRES_ID, registrationId);

    }

    @Then("^Login with registered user using POST request with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void login_with_registered_user_using_POST_request_with(String email, String password) {
        Response response = serviceApi.postLogin(email, password);
        response
                .then()
                .log()
                .all()
                .statusCode(200)
                .body("token", equalTo(response.jsonPath().get("token")));
    }

    @And("^Get the list of registered users$")
    public void get_the_list_of_registered_users() {
        Integer registrationId = getScenarioContext().getInteger(REQRES_ID);
        Response response = serviceApi.getUser(registrationId);
        response
                .then()
                .statusCode(200)
                .log().all()
                .body("data.id", equalTo(response.jsonPath().get("data.id")));
    }

    @And("^Get the list of resources$")
    public void get_the_list_of_resources() {
        Response response = serviceApi.getResources();
        response
                .then()
                .statusCode(200)
                .log().all()
                .body("total", equalTo(response.jsonPath().get("total")));
    }

    @Given("^Read Data from given Json$")
    public void readDataFromGivenJson() {
        JsonPath jsonPath = JsonPath.from(getClass().getClassLoader().getResourceAsStream("json/test.json"));

        getScenarioContext().setResponse(RESPONSE, jsonPath);
    }

    @Then("^assert the data$")
    public void assertTheData() {
        JsonPath jsonPath   = getScenarioContext().getResponse(RESPONSE);
        assertEquals("Janet", jsonPath.getString("data.first_name"));
        assertEquals("Weaver", jsonPath.getString("data.last_name"));
    }
}
