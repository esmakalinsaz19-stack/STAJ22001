package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
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

public class LoginAutomationTest {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://ecommerce-staging.test.com/login");
    }

    @Test(priority = 1)
    public void testValidLogin() {
        driver.findElement(By.id("email")).sendKeys("testuser@ecommerce.com");
        driver.findElement(By.id("password")).sendKeys("ValidPassword123!");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        WebElement userProfile = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.id("user-profile"))
        );
        Assert.assertTrue(userProfile.isDisplayed(), "Oturum acma basarisiz!");
    }

    @Test(priority = 2)
    public void testInvalidPassword() {
        driver.findElement(By.id("email")).sendKeys("testuser@ecommerce.com");
        driver.findElement(By.id("password")).sendKeys("WrongPass123!");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        WebElement errorAlert = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert-danger"))
        );
        Assert.assertEquals(errorAlert.getText(), "E-posta veya parola hatalı");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
