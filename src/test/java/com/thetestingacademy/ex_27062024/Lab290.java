package com.thetestingacademy.ex_27062024;

import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class Lab290 {
    //PayloadUsingMap
    //Post Request - Payload - String

    //     "{\n" +
//            "    \"firstname\" : \"Jim\",\n" +
//            "    \"lastname\" : \"Brown\",\n" +
//            "    \"totalprice\" : 111,\n" +
//            "    \"depositpaid\" : true,\n" +
//            "    \"bookingdates\" : {\n" +
//            "        \"checkin\" : \"2018-01-01\",\n" +
//            "        \"checkout\" : \"2019-01-01\"\n" +
//            "    },\n" +
//            "    \"additionalneeds\" : \"Breakfast\"\n" +
//            "}";

    RequestSpecification r = RestAssured.given();
    Response response;
    ValidatableResponse validatableResponse;


    @Description("TC#1 - Verify that create boooking is working with valid payload")
    @Test
    public void testNonBDDStylePositive() {
        //POST Request
        //URL
        //BODY - PAYLOAD - JSON
        //HEADER - Content Type
        String Base_URL = "https://restful-booker.herokuapp.com";
        String Base_PATH = "/booking";

        Faker faker = new Faker();
        String firstName = faker.name().firstName();

        String payload = "{\n" +
                "    \"firstname\" : \"" + firstName + "\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        r.baseUri(Base_URL);
        r.basePath(Base_PATH);
        r.contentType(ContentType.JSON).log().all();
        r.body(payload);

        response = r.when().log().all().post();
        String responseString = response.asString();
        System.out.println(responseString);

        validatableResponse = response.then();
        validatableResponse.statusCode(200);

    }


}
