package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class LoginTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://ecommerce-staging.test.com/login");
    }

    @Test
    public void testValidLogin() {
        driver.findElement(By.id("email")).sendKeys("testuser@ecommerce.com");
        driver.findElement(By.id("password")).sendKeys("ValidPassword123!");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        WebElement userProfile = driver.findElement(By.className("user-menu"));
        Assert.assertTrue(userProfile.isDisplayed(), "Oturum acma basarisiz!");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
