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
    public void setUp() {
        String browser = "chrome";
        if (browser.equalsIgnoreCase("chrome")) {
            String chromeDriverPath = System.getProperty("chromeDriverPath", "D:\\QA_Automatiozacion\\chromedriver-win64\\chromedriver.exe");
            //String chromeBinaryPath = System.getProperty("chromeBinaryPath", "D:\\QA_Automatiozacion\\chromedriver-win64\\");
            System.setProperty("webdriver.chrome.driver", chromeDriverPath);
            ChromeOptions options = new ChromeOptions();
            //options.setBinary(chromeBinaryPath);
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
