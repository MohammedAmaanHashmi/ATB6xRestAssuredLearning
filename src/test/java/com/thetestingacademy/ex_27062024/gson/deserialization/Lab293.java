package com.thetestingacademy.ex_27062024.gson.deserialization;

import com.google.gson.Gson;
import com.thetestingacademy.ex_27062024.gson.serialization.gen.Booking;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Lab293 {

    @Test
    public void deSerializationTest() {
        String jsonString = "{\n" +
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

        Gson gson = new Gson();
        Booking booking = gson.fromJson(jsonString, Booking.class);
        System.out.println(booking.getFirstname());
        System.out.println(booking.getLastname());

        Assert.assertEquals(booking.getFirstname(), "Amit");
    }
}
