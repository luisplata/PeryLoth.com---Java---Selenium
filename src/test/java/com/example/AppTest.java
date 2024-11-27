package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest extends BaseTest
{
    private String baseUrl = "https://peryloth.com/";
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        driver.get(baseUrl);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Ejecutando pruebas...");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testPageTitle() {
        String expectedTitle = "Luis Enrique Plata Osorio";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "El título de la página no es correcto.");
    }

    @Test
    public void testSingleH1() {
        List<WebElement> h1Elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.tagName("h1")));
        Assert.assertEquals(h1Elements.size(), 1, "Debe haber solo 1 etiqueta <h1> en la página.");
        System.out.println("Se encontró el <h1> con el siguiente contenido: " + h1Elements.get(0).getText());
        Assert.assertEquals(h1Elements.get(0).getText(), "Luis Enrique Plata Osorio", "El contenido del <h1> no es correcto.");
    }

    @Test
    public void testSingleH2() {

        List<WebElement> h2Elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.tagName("h2")));
        Assert.assertEquals(h2Elements.size(), 2, "Debe haber solo 2 etiqueta <h2> en la página.");
        for (WebElement h2 : h2Elements) {
            System.out.println(h2.getText());
            Assert.assertTrue(h2.getText().equals("Unity Developer") || h2.getText().equals("Projects"), "El contenido del <h2> no es correcto.");
        }
    }

    @Test
    public void testImageInDiv() {
        WebElement imageDiv = driver.findElement(By.cssSelector("div.image img"));
        Assert.assertTrue(imageDiv.isDisplayed(), "La imagen no está visible dentro del div con clase 'image'.");
    }

    @Test
    public void testButtonsRedirection() {
        List<WebElement> buttons = driver.findElements(By.cssSelector("div > ul > li > a"));
        Assert.assertEquals(buttons.size(), 14, "Debe haber 14 botones que redirijan a otros links.");

        for (WebElement button : buttons) {
            String link = button.getAttribute("href");
            Assert.assertNotNull(link, "El botón no tiene un enlace válido.");
        }
    }

    @Test
    public void testArticlesInDiv() {
        List<WebElement> articles = driver.findElements(By.cssSelector("div.inner > article > a"));
        Assert.assertTrue(articles.size() >= 1, "Debe haber al menos 1 <article> dentro del div con clase 'inner'.");
        System.out.println("Se encontraron " + articles.size() + " artículos.");

        for (WebElement article : articles) {
            Assert.assertNotNull(article.getAttribute("href"), "El artículo no contiene un enlace válido.");
        }
    }

    @Test
    public void testArticlesInDivWithImages() {
        List<WebElement> images = driver.findElements(By.cssSelector("div.inner > article > a > img"));
        Assert.assertTrue(images.size() >= 1, "Debe haber al menos 1 <article> dentro del div con clase 'inner'.");
        System.out.println("Se encontraron " + images.size() + " artículos.");

        for (WebElement img : images) {
            Assert.assertNotNull(img.getAttribute("src"), "La imagen no contiene un enlace válido.");
        }
    }
    @Test
    public void testPageLoadTime() {
        long start = System.currentTimeMillis();
        driver.navigate().refresh();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
        long end = System.currentTimeMillis();
        long loadTime = end - start;
        System.out.println("El tiempo de carga de la página fue: " + loadTime + " ms.");
        Assert.assertTrue(loadTime < 3000, "La página debe cargar en menos de 3 segundos.");
    }


}
