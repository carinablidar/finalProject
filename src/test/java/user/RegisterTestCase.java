package user;

import base.TestCase;
import commons.LoggerUtility;
import commons.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static commons.Constants.*;

public class RegisterTestCase implements TestCase {

    @Override
    @Test
    public void runTest() {
        WebDriver driver = new ChromeDriver();

        try {

            driver.get(URL+"register?returnUrl=%2F");
            driver.manage().window().maximize();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement registerCheckBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(REGISTER_CHECKBOX)));
            registerCheckBox.click();
            LoggerUtility.infoTest("The user goes to Register");


            WebElement registerFirstName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(REGISTER_FIRST_NAME)));
            registerFirstName.click();
            registerFirstName.sendKeys(REGISTER_FIRST_NAME_TEXT);
            LoggerUtility.infoTest("The user filled the First Name");

            WebElement registerLastName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(REGISTER_LAST_NAME)));
            registerLastName.click();
            registerLastName.sendKeys(REGISTER_LAST_NAME_TEXT);
            LoggerUtility.infoTest("The user filled the Last Name");

            Thread.sleep(2000);

            JavascriptExecutor jse = (JavascriptExecutor)driver;
            jse.executeScript("window.scrollBy(0,250)");

            WebElement dayComboBox = driver.findElement(By.name("DateOfBirthDay"));
            Select daySelect = new Select(dayComboBox);
            daySelect.selectByVisibleText("9");
            LoggerUtility.infoTest("The user filled day of birth");

            WebElement monthComboBox = driver.findElement(By.name("DateOfBirthMonth"));
            Select monthSelect = new Select(monthComboBox);
            monthSelect.selectByVisibleText("May");
            LoggerUtility.infoTest("The user filled month of birth");

            WebElement yearComboBox = driver.findElement(By.name("DateOfBirthYear"));
            Select yearSelect = new Select(yearComboBox);
            yearSelect.selectByVisibleText("1995");
            LoggerUtility.infoTest("The user filled year of birth");


            WebElement registerEmail = driver.findElement(By.id(REGISTER_EMAIL));
            registerEmail.click();
            registerEmail.sendKeys(Utils.randomEmail());
            LoggerUtility.infoTest("The user filled the email");


            WebElement registerCompany = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(REGISTER_COMPANY)));
            registerCompany.click();
            registerCompany.sendKeys(REGISTER_COMPANY_TEXT);
            LoggerUtility.infoTest("The user filled the company");

            JavascriptExecutor jsi = (JavascriptExecutor)driver;
            jsi.executeScript("window.scrollBy(0,250)");

            WebElement registerNewsletter = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(REGISTER_NEWSLETTER)));
            registerNewsletter.isSelected();
            LoggerUtility.infoTest("The user click on checkbox of newsletter");

            WebElement registerPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(REGISTER_PASSWORD)));
            registerPassword.click();
            registerPassword.sendKeys(REGISTER_PASSWORD_TEXT);
            LoggerUtility.infoTest("The user filled the password");

            WebElement registerConfirmPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(REGISTER_CONFIRM_PASSWORD)));
            registerConfirmPassword.click();
            registerConfirmPassword.sendKeys(REGISTER_CONFIRM_PASSWORD_TEXT);
            LoggerUtility.infoTest("The user confirm the password");

            WebElement registerSubmit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(REGISTER_SUBMIT)));
            registerSubmit.submit();
            LoggerUtility.infoTest("The user click on register");


            Thread.sleep(5000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    }

