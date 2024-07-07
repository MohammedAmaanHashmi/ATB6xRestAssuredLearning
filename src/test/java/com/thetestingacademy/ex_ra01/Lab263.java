package com.thetestingacademy.ex_ra01;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class Lab263 {

    @Description("TC#1 - verify 263 GET Request 1")
    @Test
    public void getRequest() {
        RestAssured.
                given().
                baseUri("https://restful-booker.herokuapp.com")
                .basePath("/ping")
                .when()
                .get()
                .then()
                .statusCode(201);

    }
}
