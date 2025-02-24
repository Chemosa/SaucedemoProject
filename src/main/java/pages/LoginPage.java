package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {
    public static final By USERNAME_INPUT = By.xpath("//*[@data-test='username']");
    public static final By PASSWORD_INPUT = By.name("password");
    public static final By LOGIN_BUTTON = By.className("submit-button");
    public static final By ERROR_MESSAGE = By.xpath("//*[@data-test='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    /**
     * This method performs login with inputted credentials.
     * @param username
     * @param password
     * @return
     */
    public ProductsPage login(String username, String password) {
        driver.findElement(USERNAME_INPUT).sendKeys(username);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        return new ProductsPage(driver);
    }

    /**
     * This method gets error messages from Login page.
     * @return
     */
    public String getErrorMessageText() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }
}
