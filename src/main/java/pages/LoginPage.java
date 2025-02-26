package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


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
        waiter.waitForPageOpened(driver, loginButton, 15);
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
}
