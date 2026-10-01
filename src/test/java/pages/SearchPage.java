package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class SearchPage {
    WebDriver driver;

    @FindBy(name = "q")
    private WebElement searchBox;

    @FindBy(css = ".product-card")
    private List<WebElement> productCards;

    @FindBy(id = "add-to-cart-button")
    private WebElement addToCartButton;

    @FindBy(css = ".cart-count")
    private WebElement cartBadge;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchProduct(String keyword) {
        searchBox.sendKeys(keyword + Keys.ENTER);
    }

    public int getProductCount() {
        return productCards.size();
    }

    public void selectFirstProduct() {
        if (!productCards.isEmpty()) {
            productCards.get(0).click();
        }
    }

    public void addToCart() {
        addToCartButton.click();
    }

    public String getCartCount() {
        return cartBadge.getText();
    }
}
