package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HeaderTest extends BaseTest{

    @Test (description = "Check that logo is 'Swag Labs'.")
    public void checkLogoText() {
        loginPage
                .openPage(LOGIN_PAGE_URL);
        loginPage
                .login(USERNAME, PASSWORD);
        Assert.assertEquals(headerPage.getLogoTextFromHeader(), LOGO);
    }

    @Test (description = "Check that 'All Items' link leads to https://www.saucedemo.com/inventory.html")
    public void clickAllItemsLink() {
        loginPage
                .openPage(LOGIN_PAGE_URL);
        loginPage
                .login(USERNAME, PASSWORD)
                .openShoppingCart()
                .openHiddenMenu()
                .clickAllItems();
        Assert.assertEquals(driver.getCurrentUrl(), PRODUCTS_PAGE_URL);
    }

    @Test (description = "Check work of Logout")
    public void checkLogout() {
        loginPage
                .openPage(LOGIN_PAGE_URL);
        loginPage
                .login(USERNAME, PASSWORD)
                .openHiddenMenu()
                .clickLogout();
        Assert.assertEquals(driver.getCurrentUrl(), LOGIN_PAGE_URL);
    }
}
