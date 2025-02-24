package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class CartPage extends HeaderPage {
    private static final String PRODUCT_ITEM = "//*[text()='%s']/ancestor::*[@class=\"cart_item\"]";
    private static final String PRODUCT_NAME = "//*[text()='%s']";
    private static final String PRODUCT_PRICE = PRODUCT_ITEM + "//*[@class=\"inventory_item_price\"]";
    private static final String PRODUCT_QUANTITY = PRODUCT_ITEM + "//*[@class=\"cart_quantity\"]";
    private static final String REMOVE_BUTTON = PRODUCT_ITEM + "//button";
    private static final String CART_ITEM_CONTAINER = "//*[@class='cart_item']";
    public static final By CONTINUE_SHOPPING_BUTTON = By.id("continue-shopping");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    /**
     * This method gets name of the product from cart.
     * @param productName
     * @return
     */
    public String getProductNameFromCart(String productName) {
        return driver.findElement(By.xpath(String.format(PRODUCT_NAME, productName))).getText();
    }

    /**
     * This method gets price of the product from cart.
     * @param productName
     * @return
     */
    public String getProductPriceFromCart(String productName) {
        return driver.findElement(By.xpath(String.format(PRODUCT_PRICE, productName))).getText();
    }

    /**
     * This method makes list with all products from cart.
     * @return
     */
    public List<WebElement> listOfProductsInCart() {
        return driver.findElements(By.xpath(PRODUCT_ITEM));
    }

    /**
     * This method click on 'Remove' button on Cart page
     * @param productName
     * @return
     */
    public CartPage clickRemoveButton(String productName) {
        driver.findElement(By.xpath(String.format(REMOVE_BUTTON, productName))).click();
        return new CartPage(driver);
    }

    /**
     * This method click on 'Continue Shopping' button and return to Product page
     * @return
     */
    public ProductsPage clickContinueShopping() {
        driver.findElement(CONTINUE_SHOPPING_BUTTON).click();
        return new ProductsPage(driver);
    }
}
