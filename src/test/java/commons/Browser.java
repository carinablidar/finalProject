package commons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Browser {

    WebDriver driver;
    Properties prop;

    public WebDriver init_driver(Properties prop)
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get(prop.getProperty("url"));

        return driver;
    }

    public Properties init_properties()
    {
        prop = new Properties();
        try {
            FileInputStream ip = new FileInputStream("src/test/resources/details.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e)
        {
            e.printStackTrace();
        }

        return prop;


    }
}