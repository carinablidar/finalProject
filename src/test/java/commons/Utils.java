package commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class Utils {
    private WebDriver webDriver;

    private static String myRandomEmail;
    public Utils(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public static String randomEmail() {
        if (myRandomEmail == null) {
            String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
            Random random = new Random();
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < 10; i++) {
                sb.append(chars.charAt(random.nextInt(chars.length())));
            }

            myRandomEmail = sb + "@testing.com";
        }
        return myRandomEmail;
    }
}
