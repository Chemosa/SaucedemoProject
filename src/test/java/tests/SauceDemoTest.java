package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SauceDemoTest {
    @Test
    public void checkProductNameAndPriceInCart() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.className("submit-button")).click();
        driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-bolt-t-shirt")).click();
        driver.findElement(By.className("shopping_cart_link")).click();

        String productNameInCart = driver.findElement(By.xpath("//*[@id=\"item_1_title_link\"]")).getText();
        String productPriceInCart = driver.findElement(By.xpath("//*[@data-test='inventory-item-price']")).getText();
        Assert.assertEquals(productNameInCart, "Sauce Labs Bolt T-Shirt");
        Assert.assertEquals(productPriceInCart, "$15.99");

        driver.quit();
    }
}
