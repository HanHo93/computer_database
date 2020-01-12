package TestScript;

import PageObject.PageFactory;
import Utils.Common;
import Utils.DriverFactory;
import Utils.ElementFinder;
import Utils.Log;
import global.ConfigReader;
import global.Const;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.FileNotFoundException;

public class BaseTest {

    private WebDriver driver;
    private ConfigReader config = new ConfigReader();

    @Parameters("browser")
    @BeforeTest
    public void initTest(String browserType) throws FileNotFoundException {
        driver = DriverFactory.getDriverInstance(browserType);
        config.loadFile(Const.CONFIG_FILE);
        PageFactory.init(driver);
        Common.init(driver);
        ElementFinder.initDriver(driver);
        String url = config.get("site_url");
        driver.get(url);
        Log.info("******************************************************");
        Log.info("Go to computer management site: " + url);
    }

    @AfterTest
    public void cleanUpTest(){
        driver.quit();
    }
}
