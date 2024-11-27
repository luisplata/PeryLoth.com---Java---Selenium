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
            String chromeBinaryPath = System.getProperty("chromePath", "/path/to/local/google-chrome");

            if (System.getProperty("os.name").toLowerCase().contains("win")) {
                System.setProperty("webdriver.chrome.driver", "D:\\QA_Automatiozacion\\chromedriver-win64\\chromedriver.exe");
            } else {
                System.setProperty("webdriver.chrome.driver", chromeDriverPath);
            }
            ChromeOptions options = new ChromeOptions();
            options.setBinary(chromeBinaryPath);
            options.addArguments("--headless"); // Modo sin interfaz gráfica
            options.addArguments("--no-sandbox"); // Evita problemas de permisos en contenedores
            options.addArguments("--disable-dev-shm-usage"); // Usa /tmp para almacenamiento compartido
            options.addArguments("--remote-allow-origins=*"); // Permite todas las conexiones remotas
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("firefox")) {
            String firefoxBinaryPath = System.getProperty("firefoxPath", "/path/to/local/firefox");
            if (System.getProperty("os.name").toLowerCase().contains("win")) {
                System.setProperty("webdriver.gecko.driver", "D:\\QA_Automatiozacion\\geckodriver-v0.35.0-win64\\geckodriver.exe");
            } else {
                System.setProperty("webdriver.gecko.driver", firefoxBinaryPath);
            }
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--headless"); // Modo sin interfaz gráfica
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
