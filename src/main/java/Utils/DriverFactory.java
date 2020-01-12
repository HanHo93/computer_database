package Utils;

import global.Const;
import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory {

    public static WebDriver getDriverInstance(String browserName) {
        WebDriver driver = null;
        switch (browserName) {
            case Const.BROWSER_CHROME:
                System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case Const.BROWSER_FIREFOX:
                System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            case Const.BROWSER_IE:
                System.setProperty("webdriver.ie.driver", "src/main/resources/drivers/IEDriverServer.exe");
                driver = new InternetExplorerDriver();
                break;
        }

        if (driver !=null) {
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Const.TIMEOUT_IN_SECONDS, TimeUnit.SECONDS);
        }
        return driver;
    }
}
