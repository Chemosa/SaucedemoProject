package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends HeaderPage {

    public static final String PRODUCT_ITEM = "//*[text()='%s']/ancestor::*[@class" +
            "='inventory_item']";
    public static final String ADD_PRODUCT_TO_CART_BUTTON = PRODUCT_ITEM + "//button[contains(text(), 'Add')]";
    public static final String REMOVE_PRODUCT_FROM_CART_BUTTON = PRODUCT_ITEM + "//button[contains(text(), 'Remove')]";
    public static final String PRODUCT_PRICE = PRODUCT_ITEM + "//*[@class=\"inventory_item_price\"]";

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    /**
     * This method clicks on 'Add to Cart' buttons for all products, which names were conveyed to method.
     * @param productNames
     * @return
     */
    public ProductsPage addToCart(String... productNames) {
        for (String productName : productNames) {
            driver.findElement(By.xpath(String.format(ADD_PRODUCT_TO_CART_BUTTON, productName))).click();
        }
        return this;
    }

    /**
     * This method checks is 'Add to Cart' button is displayed on Products page.
     * @param productName
     * @return
     */
    public boolean isAddToCartButtonDisplayed(String productName) {
        return driver.findElement(By.xpath(String.format(ADD_PRODUCT_TO_CART_BUTTON, productName))).isDisplayed();
    }

    /**
     * This method checks is 'Remove' button is displayed on Products page.
     * @param productName
     * @return
     */
    public boolean isRemoveButtonDisplayed(String productName) {
        return driver.findElement(By.xpath(String.format(REMOVE_PRODUCT_FROM_CART_BUTTON, productName))).isDisplayed();
    }

    /**
     * This method gets product prices from Products page.
     * @param productName
     * @return
     */
    public String getProductPrice(String productName) {
        return driver.findElement(By.xpath(String.format(PRODUCT_PRICE, productName))).getText();
    }
}
