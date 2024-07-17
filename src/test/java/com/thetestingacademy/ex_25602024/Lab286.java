package com.thetestingacademy.ex_25602024;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class Lab286 {


    @Test
    public void testDemo1() {
        //Random user or password

        Faker faker = new Faker();
        String username = faker.name().username();
        String phoneNumber = faker.phoneNumber().cellPhone();
        System.out.println(username);
        System.out.println(phoneNumber);
    }


}
