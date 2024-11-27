package com.example;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class AppTest extends BaseTest
{

    @Test
    public void testHelloWorld() {
        driver.get("https://peryloth.com/");
        String title = driver.getTitle();
        Assert.assertEquals(title, "Luis Enrique Plata Osorio");
    }
}
