package base;

import java.time.Duration;
import java.util.Properties;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ConfigReader;

public class BaseClass {
    public static WebDriver driver;
    public static Properties prop;

    public void launchBrowser() throws IOException {
        prop = ConfigReader.initProperties();
        
        // WebDriverManager handles the driver setup automatically
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       
    }
    public void goToLoginPage() {
        driver.get(prop.getProperty("url"));  // Navigate to login URL
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
