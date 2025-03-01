package steps;

import constants.IConstants;
import entity.User;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;


public class LoginSteps {
    private LoginPage loginPage;

    public LoginSteps(WebDriver driver) {
        loginPage = new LoginPage(driver);
    }

    @Step("Login and wait for page opened")
    public LoginSteps loginAndWaitForPageOpened(String username, String password) {
        loginPage.openPage(IConstants.LOGIN_PAGE_URL);
        loginPage.login(username, password);
        return this;
    }

    @Step("Login and wait for page opened")
    public LoginSteps loginAndWaitForPageOpened(User user) {
        loginPage.openPage(IConstants.LOGIN_PAGE_URL);
        loginPage.login(user);
        return this;
    }
}
