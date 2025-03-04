package tests;

import constants.IConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import listeners.TestListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;
import pages.*;
import steps.CartSteps;
import steps.HeaderSteps;
import steps.LoginSteps;
import steps.ProductsSteps;
import java.util.concurrent.TimeUnit;


@Listeners(TestListener.class)
public class BaseTest implements IConstants, ITestConstants {
    WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    HeaderPage headerPage;
    LoginSteps loginSteps;
    ProductsSteps productsSteps;
    HeaderSteps headerSteps;
    CartSteps cartSteps;
    SoftAssert softAssert;

    @BeforeMethod
    public void initTest(ITestContext iTestContext) {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--window-size=1920, 1080");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        initPages();
        iTestContext.setAttribute("driver", driver);
        softAssert = new SoftAssert();
    }

    public void initPages() {
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        headerPage = new HeaderPage(driver);
        loginSteps = new LoginSteps(driver);
        productsSteps = new ProductsSteps(driver);
        headerSteps = new HeaderSteps(driver);
        cartSteps = new CartSteps(driver);
    }

    @AfterMethod
    public void endTest() {
        driver.quit();
    }
}
