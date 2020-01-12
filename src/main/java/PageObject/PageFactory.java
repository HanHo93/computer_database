package PageObject;

import org.openqa.selenium.WebDriver;

public class PageFactory {
    private static WebDriver driver;
    private enum Locators{
        ID,
        NAME,
        XPATH,
        CSS
    }
    public static void init(WebDriver pDriver){
        driver = pDriver;
    }
}
