package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;

public class SearchAndCartTest {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://ecommerce-staging.test.com");
    }

    @Test
    public void testSearchAndAddToCart() {
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Laptop" + Keys.ENTER);

        List<WebElement> products = wait.until(
            ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".product-card"))
        );
        Assert.assertTrue(products.size() > 0, "Arama sonucu bos dondu!");

        products.get(0).click();

        WebElement addToCartBtn = wait.until(
            ExpectedConditions.elementToBeClickable(By.id("add-to-cart-button"))
        );
        addToCartBtn.click();

        WebElement cartBadge = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".cart-count"))
        );
        Assert.assertEquals(cartBadge.getText(), "1", "Urun sepete eklenemedi!");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
