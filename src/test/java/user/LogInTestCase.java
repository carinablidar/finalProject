package user;

import base.TestCase;
import commons.LoggerUtility;
import commons.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static commons.Constants.*;

public class LogInTestCase implements TestCase {


    @Override
    @Test
    public void runTest() {
        WebDriver driver = new ChromeDriver();

        try {

            driver.get(URL + "login?returnUrl=%2F");
            driver.manage().window().maximize();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement logInEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(LOGIN_EMAIL)));
            logInEmail.click();
            logInEmail.sendKeys(Utils.randomEmail());
            LoggerUtility.infoTest("The user filled the email");

            WebElement logInPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(LOGIN_PASSWORD)));
            logInPassword.click();
            logInPassword.sendKeys(LOGIN_PASSWORD_TEXT);
            logInPassword.submit();
            LoggerUtility.infoTest("The user filled the password and log in");

            Thread.sleep(3000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
        }
    }



