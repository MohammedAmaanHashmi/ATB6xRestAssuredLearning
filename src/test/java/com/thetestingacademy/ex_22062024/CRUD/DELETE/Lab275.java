package com.thetestingacademy.ex_22062024.CRUD.DELETE;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Lab275 {
    RequestSpecification r = RestAssured.given();
    Response response;
    ValidatableResponse vr;
    String token = "d187f366841ebbb";
    String bookingID = "1928";
    String BASE_URL = "https://restful-booker.herokuapp.com";
    String Base_PATH = "/booking";

    @Test
    public void testDeleteRequestNonBDDStyle() {
        String BASE_PATH_UPDATED = Base_PATH + "/" + bookingID;
        System.out.println(BASE_PATH_UPDATED);

        r.baseUri(BASE_URL);
        r.basePath(BASE_PATH_UPDATED);
        r.cookie("token", token);

        response = r.when().log().all().delete();

        vr = response.then().log().all();
        vr.statusCode(201);

    }
}
