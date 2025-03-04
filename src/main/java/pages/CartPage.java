package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Log4j2
public class CartPage extends HeaderPage {
    private static final String PRODUCT_ITEM = "//*[text()='%s']/ancestor::*[@class=\"cart_item\"]";
    private static final String PRODUCT_NAME = "//*[text()='%s']";
    private static final String PRODUCT_PRICE = PRODUCT_ITEM + "//*[@class=\"inventory_item_price\"]";
    private static final String PRODUCT_QUANTITY = PRODUCT_ITEM + "//*[@class=\"cart_quantity\"]";
    private static final String REMOVE_BUTTON = PRODUCT_ITEM + "//button";
    private static final String CART_ITEM_CONTAINER = "//*[@class='cart_item']";

    @FindBy(id = "continue-shopping")
    WebElement continueShoppingButton;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    /**
     * This method gets name of the product from cart.
     * @param productName
     * @return
     */
    public String getProductNameFromCart(String productName) {
        String productNameInCart = driver.findElement(By.xpath(String.format(PRODUCT_NAME, productName))).getText();
        log.info("Name of product in cart: {}", productNameInCart);
        return productNameInCart;
    }

    /**
     * This method gets price of the product from cart.
     * @param productName
     * @return
     */
    public String getProductPriceFromCart(String productName) {
        String productPrice = driver.findElement(By.xpath(String.format(PRODUCT_PRICE, productName))).getText();
        log.info("Get price of the product: {}. Price is: {}", productName, productPrice);
        return productPrice;
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
        log.info("Remove product '{}' from cart", productName);
        return new CartPage(driver);
    }

    /**
     * This method click on 'Continue Shopping' button and return to Product page
     * @return
     */
    public ProductsPage clickContinueShopping() {
        continueShoppingButton.click();
        return new ProductsPage(driver);
    }
}
