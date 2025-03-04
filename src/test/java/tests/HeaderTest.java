package tests;

import org.testng.Assert;
import org.testng.annotations.Test;


public class HeaderTest extends Preconditions{

    @Test (description = "Check that logo is 'Swag Labs'.")
    public void checkLogoText() {
        loginSteps.loginAndWaitForPageOpened(userSuccess);
        Assert.assertEquals(headerPage.getLogoTextFromHeader(), LOGO);
    }

    @Test (description = "Check that 'All Items' link leads to https://www.saucedemo.com/inventory.html")
    public void clickAllItemsLink() {
        loginSteps.loginAndWaitForPageOpened(userSuccess);
        headerSteps
                .openShoppingCart()
                .openHiddenMenuPressAllItems();
        Assert.assertEquals(driver.getCurrentUrl(), PRODUCTS_PAGE_URL);
    }

    @Test (description = "Check work of Logout")
    public void checkLogout() {
        loginSteps.loginAndWaitForPageOpened(userSuccess);
        headerSteps.openHiddenMenuPressLogoutNavigateBack();
        Assert.assertEquals(driver.getCurrentUrl(), LOGIN_PAGE_URL);
    }
}
