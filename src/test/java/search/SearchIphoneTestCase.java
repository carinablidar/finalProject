package search;

import base.TestCase;
import commons.LoggerUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static commons.Constants.*;

public class SearchIphoneTestCase implements TestCase {

    @Override
    @Test
    public void runTest() {
        WebDriver driver = new ChromeDriver();

        try {

            driver.get(URL);
            driver.manage().window().maximize();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(SEARCH_TEXTBOX_ID)));
            searchBox.sendKeys(SEARCH_TEXTBOX_IPHONE);
            searchBox.submit();

            LoggerUtility.infoTest("The user search for Iphone");

            Thread.sleep(3000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
