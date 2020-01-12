package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ElementFinder {

    private static WebDriver driver;
    public static void initDriver(WebDriver browserDriver){
        driver = browserDriver;
    }

    public static WebElement findElementById(String id){
        return driver.findElement(By.id(id));
    }

    public static WebElement findElementByXpath(String xpath){
        return driver.findElement(By.xpath(xpath));
    }

    public static WebElement findElementByCssSelector(String cssSelector){
        return driver.findElement(By.cssSelector(cssSelector));
    }

    public  static List<WebElement> findElementListByCssSelector(String cssSelector){
        return driver.findElements(By.cssSelector(cssSelector));
    }
}
