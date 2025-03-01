package tests;

import org.testng.Assert;
import org.testng.annotations.Test;


public class ProductsTest extends Preconditions {

    @Test
    public void isAddToCartButtonDisplayedTest() {
        loginSteps.loginAndWaitForPageOpened(userSuccess);
        Assert.assertTrue(productsPage.isAddToCartButtonDisplayed(SAUCE_LABS_BOLT_T_SHIRT));
    }

    @Test
    public void isRemoveButtonDisplayedTest() {
       productsSteps.loginAndAddProductToCart(userSuccess, SAUCE_LABS_BOLT_T_SHIRT);
       Assert.assertTrue(productsPage.isRemoveButtonDisplayed(SAUCE_LABS_BOLT_T_SHIRT));
    }
}
