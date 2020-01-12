package PageObject.pages;

import Utils.Assertions;
import Utils.ElementActions;
import Utils.ElementFinder;
import org.openqa.selenium.WebElement;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AddComputerPage extends BasePage{

    // ELEMENTS
    private WebElement pageTitle(){return ElementFinder.findElementByCssSelector("#main > h1");}
    private WebElement nameTxt(){return ElementFinder.findElementById("name");}
    private WebElement introducedTxt(){return ElementFinder.findElementById("introduced");}
    private WebElement discontinuedTxt(){return ElementFinder.findElementById("discontinued");}
    private WebElement companyDll(){return ElementFinder.findElementById("company");}
    private WebElement submitBtn(){return ElementFinder.findElementByCssSelector(".btn.primary");}
    private WebElement deleteBtn(){return ElementFinder.findElementByCssSelector(".btn.danger");}
    private WebElement computerNameError(){return ElementFinder.findElementByXpath("//*[@class='clearfix error']/label[contains(text(), \"Computer name\")]");}



    // ACTIONS
    public void addComputerName(){
        ElementActions.inputText(nameTxt(), "Automation " + LocalDateTime.now(), "'Computer name' field");
    }

    public void addIntroducedDate(){
        ElementActions.inputText(introducedTxt(), "2019-01-01", "'Introduced Date' field");
    }

    public void addDiscontinuedDate(){
        ElementActions.inputText(discontinuedTxt(), "2020-01-01", "'Discontinued Date' field");
    }

    public void selectACompany(){
        ElementActions.selectFromDropDown(companyDll(), "Canon", "'Company' drop down list");
    }

    public void clickOnSubmitButton(){
        ElementActions.click(submitBtn(), "'Create this computer' button");
    }

    public void clickOnDeleteButton(){
        ElementActions.click(deleteBtn(), "'Delete' button");
    }

    public List<String> getComputerInfo(){
        List<String> data = new ArrayList<>();
        data.add(ElementActions.getAttributeValue(nameTxt(), "value", "'Computer name' field"));
        data.add(ElementActions.getAttributeValue(introducedTxt(),"value", "'Introduced Date' field"));
        data.add(ElementActions.getAttributeValue(discontinuedTxt(), "value", "'Discontinued Date' field"));
        return data;
    }

    //ASSERTIONS
    public void verifyPageTitle(){
        Assertions.verifyEquals(pageTitle().getText(),"Add a computer", "page title");
    }
    public void verifyComputerInfoShowsCorrectly(Object actual, Object expected){
        Assertions.verifyEquals(actual, expected, " computer info");
    }

    public void verifyTheNumberOfComputer(Object actual, Object expected){
        Assertions.verifyEquals(actual, expected, "number of computer");
    }

    public void verifyTheNameFieldsIsHighlighted(){
        Assertions.verifyTrue(computerNameError().isDisplayed() && computerNameError().getCssValue("color").equals("rgba(157, 38, 29, 1)"), "Name field is highlighted");
    }
}
