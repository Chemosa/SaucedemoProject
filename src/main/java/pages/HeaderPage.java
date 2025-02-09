package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPage extends BasePage {

    public static final By SHOPPING_CART_BUTTON = By.id("shopping_cart_container");
    public static final By LOGO = By.className("app_logo");
    public static final By OPEN_MENU = By.id("react-burger-menu-btn");
    public static final By ALL_ITEMS_LINK = By.id("inventory_sidebar_link");
    public static final By LOGOUT_LINK = By.id("logout_sidebar_link");

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    public void openShoppingCart() {
        driver.findElement(SHOPPING_CART_BUTTON).click();
    }
    public String logoTextInHeader() {
        return driver.findElement(LOGO).getText();
    }
    public void openHiddenMenu() {
        driver.findElement(OPEN_MENU).click();
    }
    public void clickAllItems() {
        driver.findElement(ALL_ITEMS_LINK).click();
    }
    public void clickLogout() {
        driver.findElement(LOGOUT_LINK).click();
    }
}
