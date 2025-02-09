package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends HeaderPage {

    public static final By PRODUCT_NAME = By.className("inventory_item_name");
    public static final By PRODUCT_PRICE = By.className("inventory_item_price");
    public static final By REMOVE_BUTTON = By.className("cart_button");
    public static final By CONTINUE_SHOPPING_BUTTON = By.id("continue-shopping");


    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getProductNameFromCart(int productIndex) {
        List<WebElement> productsInCart = driver.findElements(PRODUCT_NAME);
        String productNameInCart = productsInCart.get(productIndex).getText();
        return productNameInCart;
    }

    public String getProductPriceFromCart(int productIndex) {
        List<WebElement> productsInCart = driver.findElements(PRODUCT_PRICE);
        String productPriceInCart = productsInCart.get(productIndex).getText();
        return productPriceInCart;
    }

    public List<WebElement> listOfProductsInCart() {
        List<WebElement> listOfProductsInCart =driver.findElements(PRODUCT_NAME);
        return listOfProductsInCart;
    }

    public void clickRemoveButton() {
        driver.findElement(REMOVE_BUTTON).click();
    }

    public void clickContinueShopping() {
        driver.findElement(CONTINUE_SHOPPING_BUTTON).click();
    }
}
