package cart;

import base.TestCase;
import commons.LoggerUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static commons.Constants.*;

public class AddToCartTestCase implements TestCase {
    @Test
    @Override
    public void runTest() {
        WebDriver driver = new ChromeDriver();

        try {

            driver.get(URL + "books");
            driver.manage().window().maximize();
            WebElement imageElement = driver.findElement(By.xpath("//img[@alt='Picture of Fahrenheit 451 by Ray Bradbury']"));
            imageElement.click();
            LoggerUtility.infoTest("The user clicked on a book");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement addToCartButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(CART_ADD_BUTTON)));
            addToCartButton.click();
            LoggerUtility.infoTest("The user added a book to shopping cart");

            WebElement goToShoppingCart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(CART_SHOPPING)));
            goToShoppingCart.click();
            LoggerUtility.infoTest("The user goes to shopping cart");

            JavascriptExecutor jse = (JavascriptExecutor)driver;
            jse.executeScript("window.scrollBy(0,150)");

            Thread.sleep(3000);

            WebElement termsButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(CART_TERMS)));
            termsButton.click();
            LoggerUtility.infoTest("The user see the selected book in shopping cart");

            jse.executeScript("window.scrollBy(0,250)");

            Thread.sleep(6000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
