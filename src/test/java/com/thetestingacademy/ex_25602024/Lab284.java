package com.thetestingacademy.ex_25602024;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Lab284 {

    @Parameters("browser")
    @Test(priority = 1)
    public void testDemo1(String value) {
        System.out.println("Browser is " + value);
        //Open the Browser and select the data
        switch (value) {
            case "chrome":
                //Chrome code
                System.out.println("Chrome Browser and running the TC");
                break;

            case "edge":
                //Edge code
                System.out.println("Edge Browser and running the TC");
                break;

            case "firefox":
                //Firefox code
                System.out.println("firefox Browser and running the TC");
                break;

            default:
                System.out.println("No idea What To Start");
        }
    }
}
