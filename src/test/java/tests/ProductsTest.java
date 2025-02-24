package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static pages.LoginPage.LOGIN_BUTTON;

public class ProductsTest extends BaseTest {

    @Test
    public void isAddToCartButtonDisplayedTest() {
        loginPage
                .openPage(LOGIN_PAGE_URL);
        waiter.waitForPageOpened(driver, LOGIN_BUTTON, 10);
        loginPage
                .login(USERNAME, PASSWORD);
        Assert.assertTrue(productsPage.isAddToCartButtonDisplayed(SAUCE_LABS_BOLT_T_SHIRT));
    }

    @Test
    public void isRemoveButtonDisplayedTest() {
        loginPage
                .openPage(LOGIN_PAGE_URL);
        waiter.waitForPageOpened(driver, LOGIN_BUTTON, 10);
        loginPage
                .login(USERNAME, PASSWORD)
                .addToCart(SAUCE_LABS_BOLT_T_SHIRT);
        Assert.assertTrue(productsPage.isRemoveButtonDisplayed(SAUCE_LABS_BOLT_T_SHIRT));
    }
}
