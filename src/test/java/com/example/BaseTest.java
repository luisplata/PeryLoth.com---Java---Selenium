package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTest {

    protected WebDriver driver;

    @BeforeClass
    @Parameters("browser")
    public void setUp(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            String chromeDriverPath = System.getProperty("chromeDriverPath", "/path/to/local/chromedriver");
            String chromeBinaryPath = System.getProperty("chromeBinaryPath", "/path/to/local/google-chrome");
            System.setProperty("webdriver.chrome.driver", chromeDriverPath);
            ChromeOptions options = new ChromeOptions();
            options.setBinary(chromeBinaryPath);
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("firefox")) {
            String firefoxBinaryPath = System.getProperty("firefoxPath", "/path/to/local/firefox");
            String  firefoxDriverPath = System.getProperty("firefoxDriverPath", "/path/to/local/firefox");
            System.setProperty("webdriver.gecko.driver",firefoxDriverPath);
            FirefoxOptions options = new FirefoxOptions();
            options.setBinary(firefoxBinaryPath);
            driver = new FirefoxDriver(options);

        }
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
