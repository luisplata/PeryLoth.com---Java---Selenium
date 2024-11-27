package com.example;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class AppTest
{

    @Test
    public void testHelloWorld() {
        String greeting = "Hello World!";
        Assert.assertEquals(greeting, "Hello World!");
    }
}
