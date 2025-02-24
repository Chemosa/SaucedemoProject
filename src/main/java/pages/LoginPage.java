package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//*[@data-test='username']")
    WebElement usernameInput;

    @FindBy(name = "password")
    WebElement passwordInput;

    @FindBy(className = "submit-button")
    WebElement loginButton;

    @FindBy(xpath = "//*[@data-test='error']")
    WebElement errorMessage;


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
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
        return new ProductsPage(driver);
    }

    /**
     * This method gets error messages from Login page.
     * @return
     */
    public String getErrorMessageText() {
        return errorMessage.getText();
    }

    public LoginPage waitForLoginPageOpened() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(loginButton));
        return new LoginPage(driver);
    }
}
