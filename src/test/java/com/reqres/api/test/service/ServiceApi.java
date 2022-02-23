package com.reqres.api.test.service;

import com.reqres.api.test.utils.ConfigUtils;
import com.reqres.api.test.constants.ServiceUrlConstants;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ServiceApi {

    public Response postLogin(String email, String password) {
        return given()
                .header("Content-Type", "application/json")
                .log().all()
                .body("{\n" +
                        "    \"email\": \"" + email + "\",\n" +
                        "    \"password\": \"" + password + "\"\n" +
                        "}")
                .post(ConfigUtils.getBaseURL().concat(ServiceUrlConstants.LOGIN_SERVICE_API_URL));
    }

    public Response postRegister(String email, String password) {
        return given()
                .header("Content-Type", "application/json")
                .log().all()
                .body("{\n" +
                        "    \"email\": \"" + email + "\",\n" +
                        "    \"password\": \"" + password + "\"\n" +
                        "}")
                .post(ConfigUtils.getBaseURL().concat(ServiceUrlConstants.REGISTER_SERVICE_API_URL));
    }

    public Response getUser(Integer registrationId) {
        return given()
                .header("Content-Type", "application/json")
                .pathParam("registrationId", registrationId)
                .log().all()
                .get(ConfigUtils.getBaseURL().concat(ServiceUrlConstants.GET_USERS_API_URL));
    }

    public Response getResources() {
        return given()
                .header("Content-Type", "application/json")
                .log().all()
                .get(ConfigUtils.getBaseURL().concat(ServiceUrlConstants.GET_RESOURCES_API_URL));
    }
}

