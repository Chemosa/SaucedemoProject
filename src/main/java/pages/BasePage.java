package pages;

import constants.IConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import waiters.Waiter;


public abstract class BasePage implements IConstants {
    WebDriver driver;
    Waiter waiter = new Waiter();

    BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openPage(String url) {
        driver.get(url);
    }

    public void navigateBack() {
        driver.navigate().back();
    }
}
