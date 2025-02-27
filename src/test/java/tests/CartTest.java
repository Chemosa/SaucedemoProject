package tests;

import org.testng.Assert;
import org.testng.annotations.Test;


public class CartTest extends Preconditions {

    @Test (description = "Test that one product can be added to the Shopping cart.")
    public void addOneProductToCart() {
        productsSteps.loginAndAddProductToCart(userSuccess, SAUCE_LABS_BACKPACK);
        headerSteps.openShoppingCart();
        Assert.assertEquals(cartPage.getProductNameFromCart(SAUCE_LABS_BACKPACK), SAUCE_LABS_BACKPACK);
        Assert.assertEquals(cartPage.getProductPriceFromCart(SAUCE_LABS_BACKPACK), "$29.99");
    }

    @Test (description = "Test that few products can be added to the Shopping cart.")
    public void addFewProductsToCart() {
        productsSteps.loginAndAddProductToCart(userSuccess, SAUCE_LABS_BACKPACK, SAUCE_LABS_BIKE_LIGHT);
        headerSteps.openShoppingCart();
        Assert.assertEquals(cartPage.getProductNameFromCart(SAUCE_LABS_BACKPACK), SAUCE_LABS_BACKPACK);
        Assert.assertEquals(cartPage.getProductNameFromCart(SAUCE_LABS_BIKE_LIGHT), SAUCE_LABS_BIKE_LIGHT);
    }

    @Test (description = "Check that product can be removed from Shopping cart.")
    public void removeProductFromCart() {
        productsSteps.loginAndAddProductToCart(userSuccess, SAUCE_LABS_BACKPACK);
        headerSteps.openShoppingCart();
        cartPage.clickRemoveButton(SAUCE_LABS_BACKPACK);
        Assert.assertTrue(cartPage.listOfProductsInCart().isEmpty());
    }

    @Test (description = "Check that Shopping cart initially is empty.")
    public void openShoppingCart() {
        productsSteps.loginAndAddProductToCart(userSuccess, SAUCE_LABS_BACKPACK);
        headerSteps.openShoppingCart();
        Assert.assertTrue(cartPage.listOfProductsInCart().isEmpty());
    }

    @Test (description = "Check work of 'Continue Shopping' button")
    public void clickContinueShoppingButton() {
        productsSteps.loginAndAddProductToCart(userSuccess, SAUCE_LABS_BACKPACK);
        headerSteps.openShoppingCart();
        cartPage.clickContinueShopping();
        Assert.assertEquals(driver.getCurrentUrl(), PRODUCTS_PAGE_URL);
    }
}
