package pages;

import entity.User;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
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
     * This method performs login with credentials from Preconditions.
     * @param user
     * @return
     */
    public ProductsPage login(User user) {
        waiter.waitForPageOpened(driver, LOGIN_PAGE_URL, 15);
        usernameInput.sendKeys(user.getUsername());
        passwordInput.sendKeys(user.getPassword());
        loginButton.click();
        if(driver.getCurrentUrl().equals(PRODUCTS_PAGE_URL)){
            log.info("User '{}' is successfully login", user.getUsername());
        }
        return new ProductsPage(driver);
    }

    /**
     * This method performs login with inputted credentials.
     * @param username
     * @param password
     * @return
     */
    public ProductsPage login(String username, String password) {
        waiter.waitForPageOpened(driver, LOGIN_PAGE_URL, 15);
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
        if(driver.getCurrentUrl().equals(PRODUCTS_PAGE_URL)){
            log.info("User '{}' is successfully login", username);
        }
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
