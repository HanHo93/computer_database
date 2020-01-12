package Utils;

import org.openqa.selenium.WebDriver;

public class Common {

    public static WebDriver driver = null;
    public static void init(WebDriver cDriver){
        driver = cDriver;
    }
    public static void sleep(int seconds){
        try{
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void back(){
        driver.navigate().back();

    }
}
