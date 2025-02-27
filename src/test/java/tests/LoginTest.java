package tests;

import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest extends Preconditions {
    public static final String EMPTY_FIELD_PASSWORD_ERROR_TEXT = "Epic sadface: Password is required";
    public static final String EMPTY_IN_FIELD_USERNAME_ERROR_TEXT = "Epic sadface: Username is required";
    public static final String INCORRECT_DATA_IN_FIELDS = "Epic sadface: Username and password do not match any user in this service";

    @Test(description = "QA-1 This test login on site without username")
    public void loginWithEmptyUsernameTest() {
        loginSteps.loginAndWaitForPageOpened(userWithEmptyUsername);
        Assert.assertEquals(loginPage.getErrorMessageText(), EMPTY_IN_FIELD_USERNAME_ERROR_TEXT);
    }

    @Test
    public void loginWithEmptyPasswordTest() {
        loginSteps.loginAndWaitForPageOpened(userWithEmptyPassword);
        Assert.assertEquals(loginPage.getErrorMessageText(), EMPTY_FIELD_PASSWORD_ERROR_TEXT);
    }

    @Test
    public void loginWithEmptyFieldsTest() {
        loginSteps.loginAndWaitForPageOpened(userEmptyFields);
        Assert.assertEquals(loginPage.getErrorMessageText(), EMPTY_IN_FIELD_USERNAME_ERROR_TEXT);
    }

    @Test
    public void loginWithIncorrectFieldsTest() {
        loginSteps.loginAndWaitForPageOpened(userIncorrectFields);
        Assert.assertEquals(loginPage.getErrorMessageText(), INCORRECT_DATA_IN_FIELDS);
    }

    @Test (description = "Check that after logout user can NOT navigate back to Products page without login")
    public void navigateBackAfterLogout() {
        loginSteps.loginAndWaitForPageOpened(userSuccess);
        headerSteps.openHiddenMenuPressLogout();
        driver.navigate().back();
        Assert.assertEquals(driver.getCurrentUrl(), LOGIN_PAGE_URL);
        Assert.assertEquals(loginPage.getErrorMessageText(), ERROR_MESSAGE_NAVIGATE_BACK_TO_PRODUCTS);
    }
}
