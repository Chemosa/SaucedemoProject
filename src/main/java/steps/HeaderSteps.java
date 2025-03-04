package steps;

import entity.User;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.HeaderPage;
import pages.LoginPage;

import static constants.IConstants.LOGIN_PAGE_URL;

public class HeaderSteps {
    private HeaderPage headerPage;
    private LoginPage loginPage;

    public HeaderSteps(WebDriver driver) {
        headerPage = new HeaderPage(driver);
        loginPage = new LoginPage(driver);
    }

    @Step("Login, add product by name and open shopping cart")
    public HeaderSteps openShoppingCart() {
        headerPage.openShoppingCart();
        return this;
    }

    @Step("Open hidden menu and click Logout")
    public HeaderSteps openHiddenMenuPressLogoutNavigateBack() {
       headerPage
               .openHiddenMenu()
               .clickLogout()
               .navigateBack();
        return this;
    }

    @Step("Open hidden menu and click 'All Items'")
    public HeaderSteps openHiddenMenuPressAllItems() {
        headerPage
                .openHiddenMenu()
                .clickAllItems();
        return this;
    }
}
