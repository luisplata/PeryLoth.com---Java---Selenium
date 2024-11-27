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
            if (System.getProperty("os.name").toLowerCase().contains("win")) {
                System.setProperty("webdriver.chrome.driver", "D:\\QA_Automatiozacion\\chromedriver-win64\\chromedriver.exe");
            } else {
                System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
            }
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("firefox")) {
            if (System.getProperty("os.name").toLowerCase().contains("win")) {
                System.setProperty("webdriver.gecko.driver", "D:\\QA_Automatiozacion\\geckodriver-v0.35.0-win64\\geckodriver.exe");
            } else {
                System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");
            }
            FirefoxOptions options = new FirefoxOptions();
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
