package tests;

import constants.IConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;
import steps.CartSteps;
import steps.HeaderSteps;
import steps.LoginSteps;
import steps.ProductsSteps;

import java.util.concurrent.TimeUnit;


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

    @BeforeMethod
    public void initTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        initPages();
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
