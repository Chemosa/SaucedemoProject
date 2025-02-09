package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test (description = "Test that one product can be added to the Shopping cart.")
    public void addOneProductToCart() {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(USERNAME, PASSWORD);
        productsPage.addToCart(SAUCE_LABS_BACKPACK);
        headerPage.openShoppingCart();
        Assert.assertEquals(cartPage.getProductNameFromCart(0), SAUCE_LABS_BACKPACK);
        Assert.assertEquals(cartPage.getProductPriceFromCart(0), "$29.99");
    }

    @Test (description = "Test that few products can be added to the Shopping cart.")
    public void addFewProductsToCart() {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(USERNAME, PASSWORD);
        productsPage.addToCart(SAUCE_LABS_BACKPACK);
        productsPage.addToCart(SAUCE_LABS_BIKE_LIGHT);
        headerPage.openShoppingCart();
        Assert.assertEquals(cartPage.getProductNameFromCart(0), SAUCE_LABS_BACKPACK);
        Assert.assertEquals(cartPage.getProductNameFromCart(1), SAUCE_LABS_BIKE_LIGHT);
    }

    @Test (description = "Check that product can be removed from Shopping cart.")
    public void removeProductFromCart() {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(USERNAME, PASSWORD);
        productsPage.addToCart(SAUCE_LABS_BACKPACK);
        headerPage.openShoppingCart();
        cartPage.clickRemoveButton();
        Assert.assertTrue(cartPage.listOfProductsInCart().isEmpty());
    }

    @Test (description = "Check that Shopping cart initially is empty.")
    public void openShoppingCart() {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(USERNAME, PASSWORD);
        headerPage.openShoppingCart();
        Assert.assertTrue(cartPage.listOfProductsInCart().isEmpty());
    }

    @Test (description = "Check work of 'Continue Shopping' button")
    public void clickContinueShoppingButton() {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(USERNAME, PASSWORD);
        productsPage.addToCart(SAUCE_LABS_BACKPACK);
        headerPage.openShoppingCart();
        cartPage.clickContinueShopping();
        Assert.assertEquals(driver.getCurrentUrl(), PRODUCTS_PAGE_URL);
    }
}
