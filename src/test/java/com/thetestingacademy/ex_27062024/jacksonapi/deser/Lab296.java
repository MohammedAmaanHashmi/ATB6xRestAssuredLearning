package com.thetestingacademy.ex_27062024.jacksonapi.deser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import com.thetestingacademy.ex_27062024.gson.serialization.Booking;
import org.testng.annotations.Test;

public class Lab296 {

    @Test
    public void deSer() throws JsonProcessingException {
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
        ObjectMapper objectMapper = new ObjectMapper();
        Booking booking = objectMapper.readValue(jsonString, Booking.class);
        System.out.println(booking);
        System.out.println(booking.getFirstname());

    }






}
