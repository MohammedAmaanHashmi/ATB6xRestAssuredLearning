package com.thetestingacademy.ex_22062024.CRUD.FULL;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class Lab277 {

    String token;
    Integer bookingId;
    RequestSpecification requestSpecification = RestAssured.given();
    ValidatableResponse validatableResponse;
    Response response;

    @BeforeTest
    public void getAToken() {
        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("auth");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload);

        response = requestSpecification.when().post();

        validatableResponse = response.then();
        validatableResponse.statusCode(200);

        //Extract the token from this

        token = response.then().log().all().extract().path("token");
        Assert.assertNotNull(token);

    }

    @BeforeTest
    public void getBookingID() {
        String payload = "{\n" +
                "    \"firstname\" : \"Jim\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload);

        response = requestSpecification.when().post();
        String responseString = response.asString();
        System.out.println(responseString);

        validatableResponse.statusCode(200);

        bookingId = response.then().log().all().extract().path("bookingid");
        String firstName = response.then().log().all().extract().path("booking.firstname");
        System.out.println(firstName);
        System.out.println(bookingId);
        Assert.assertNotNull(bookingId);
    }

    @Test
    public void testPUTPositive() {
        //token and BookingID
        String payload = "{\n" +
                "    \"firstname\" : \"Amaan\",\n" +
                "    \"lastname\" : \"Hashmi\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("booking/" + bookingId);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token", token);

        //put request
        requestSpecification.body(payload).log().all();
        response = requestSpecification.when().put();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);


        String fullResponseJSONString = response.asString();
        System.out.println(fullResponseJSONString);

        // Verify all the keys and value pairs in the response
        // firstname, lastname, deposit, totla,. checkin

        //3 ways you can verify the response

        //1. RA - Matchers
        validatableResponse.body("firstname", Matchers.equalTo("Amaan"));
        validatableResponse.body("lastname", Matchers.equalTo("Hashmi"));

        //2. TestNG Asserts - Assert.assertEquals(firstNameResponse, "Amaan");
        String firstNameResponse = response.then().log().all().extract().path("firstname");
        Assert.assertEquals(firstNameResponse, "Amaan");

        //3. TestNG Assertion with JSON Path lib
        JsonPath jsonPath = new JsonPath(fullResponseJSONString);
        String firstNameJSONPathExtracted = jsonPath.getString("firstname");
        String lastNameJSONPathExtracted = jsonPath.getString("lastname");
        Integer totalPriceJSONPathExtracted = jsonPath.getInt("totalprice");
        String checkinDate = jsonPath.getString("bookingdates.checkin");
        Assert.assertEquals(firstNameJSONPathExtracted, "Amaan");
        Assert.assertEquals(lastNameJSONPathExtracted, "Hashmi");
        Assert.assertEquals(totalPriceJSONPathExtracted, 111);
        Assert.assertEquals(checkinDate, "2018-01-01");
        Assert.assertNotNull(totalPriceJSONPathExtracted);
        //4. AssertJ Matching
        assertThat(firstNameJSONPathExtracted)
                .isEqualTo("Amaan")
                .isNotBlank().isNotEmpty();

        assertThat(totalPriceJSONPathExtracted).isPositive().isNotZero();


    }

}
