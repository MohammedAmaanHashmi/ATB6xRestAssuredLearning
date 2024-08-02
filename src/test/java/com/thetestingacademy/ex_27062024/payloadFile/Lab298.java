package com.thetestingacademy.ex_27062024.payloadFile;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.io.File;

public class Lab298 {


    RequestSpecification r = RestAssured.given();
    Response response;
    ValidatableResponse validatableResponse;

    @Test
    public void testPostRequest() {
        //POST Request
        //URL
        //BODY - PAYLOAD - JSON
        //HEADER - Content Type
        String Base_URL = "https://restful-booker.herokuapp.com";
        String Base_PATH = "/booking";

        File file=new File("src/test/resources/postRequest.json");

        r.baseUri(Base_URL);
        r.basePath(Base_PATH);
        r.contentType(ContentType.JSON).log().all();
        r.body(file);

        response = r.when().log().all().post();
        String responseString = response.asString();
        System.out.println(responseString);

        validatableResponse = response.then();
        validatableResponse.statusCode(200);
    }
}
