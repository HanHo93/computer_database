package Utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ElementActions {

    public static void click(WebElement ele, String... eleName){
        ele.click();
        if(!eleName[0].isEmpty()){
            Log.info(String.format("Click %s", eleName[0]));
        }
    }

    public static String getText(WebElement ele, String... eleName){
        if(!eleName[0].isEmpty()){
            Log.info(String.format("Get text of %s", eleName[0]));
        }
        return ele.getText();
    }

    public static String getAttributeValue(WebElement ele, String att,  String... eleName){
        if(!eleName[0].isEmpty()){
            Log.info(String.format("Get attribute value of %s", eleName[0]));
        }
        return ele.getAttribute(att);
    }

    public static void inputText(WebElement ele, String value, String eleName){
        ele.clear();
        ele.sendKeys(value);
        String log = String.format("Type %s", value);
        if(!eleName.isEmpty()){
            log += String.format(" into %s", eleName);
        }
        Log.info(log);
    }

    public static void selectFromDropDown(WebElement ele, String visibleText, String eleName){
        Select dropdown = new Select(ele);
        dropdown.selectByVisibleText(visibleText);
        String log = String.format("Select %s", visibleText);
        if(!eleName.isEmpty()){
            log += String.format(" from %s", eleName);
        }
        Log.info(log);
    }
}
