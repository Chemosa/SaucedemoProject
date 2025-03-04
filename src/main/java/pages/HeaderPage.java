package pages;

import entity.User;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class HeaderPage extends BasePage {

    public static final By SHOPPING_CART_BUTTON = By.id("shopping_cart_container");
    public static final By LOGO = By.className("app_logo");
    public static final By OPEN_MENU = By.id("react-burger-menu-btn");
    public static final By ALL_ITEMS_LINK = By.id("inventory_sidebar_link");
    public static final By LOGOUT_LINK = By.id("logout_sidebar_link");

    @FindBy(id = "continue-shopping")
    WebElement continueShoppingButton;


    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    /**
     * This method clicks on 'Shopping Cart' button and leads to Cart page
     * @return
     */
    public CartPage openShoppingCart() {
        driver.findElement(SHOPPING_CART_BUTTON).click();
        waiter.waitForElementDisplayed(driver, continueShoppingButton, 15);
        return new CartPage(driver);
    }

    /**
     * This method gets text of Logo from the header.
     * @return
     */
    public String getLogoTextFromHeader() {
        return driver.findElement(LOGO).getText();
    }

    /**
     * This method click on 'Burger' button and opens hidden menu.
     * @return
     */
    public HeaderPage openHiddenMenu() {
        driver.findElement(OPEN_MENU).click();
        return new HeaderPage(driver);
    }

    /**
     * This method clicks on 'All Items' button and returns to Product page.
     * @return
     */
    public ProductsPage clickAllItems() {
        driver.findElement(ALL_ITEMS_LINK).click();
        return new ProductsPage(driver);
    }

    /**
     * This method clicks on 'Logout' button and returns to Login page
     * @return
     */
    public LoginPage clickLogout() {
        driver.findElement(LOGOUT_LINK).click();
        waiter.waitForPageOpened(driver, LOGIN_PAGE_URL, 15);
        log.info("User was logout");
        return new LoginPage(driver);
    }
}
