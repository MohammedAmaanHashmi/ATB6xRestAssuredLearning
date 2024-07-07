package com.thetestingacademy.testng;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Lab265 {

    @Description("TC#1")
    @Test
    public void testCase() {

        //Assertion -> Expect Result = Actual Result
        //200 == 200

        //Two Types Assertions

        //Soft Assertions
//        SoftAssert s = new SoftAssert();
//        s.assertEquals("pramod", "Amaan", "NotEqual");
//        System.out.println("End of the program");
//        s.assertAll();

        //Hard Assertion
        Assert.assertEquals("Pramod","pramod");
        System.out.println("End of the program");


        //PUT -> token Hard reset
        //Get -> name is failing soft assert


    }
}
