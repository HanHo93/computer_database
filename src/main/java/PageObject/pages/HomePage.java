package PageObject.pages;

import Utils.Assertions;
import Utils.ElementActions;
import Utils.ElementFinder;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HomePage extends BasePage {

    public String validKeyword = "an";
    public String invalidKeyword = "wzno";

    // ELEMENTS
    private WebElement globalTitle(){return ElementFinder.findElementByCssSelector(".fill > a");}
    private WebElement addBtn(){ return ElementFinder.findElementById("add"); }
    private WebElement computerNumTxt(){ return ElementFinder.findElementByCssSelector("#main >h1"); }
    private WebElement searchTxt(){ return ElementFinder.findElementById("searchbox"); }
    private WebElement searchBtn(){ return ElementFinder.findElementById("searchsubmit"); }
    private List<WebElement> computerRow(){ return ElementFinder.findElementListByCssSelector(".computers.zebra-striped > tbody tr"); }
    private WebElement computerName(){ return ElementFinder.findElementByCssSelector(".computers.zebra-striped > tbody > tr > td > a"); }
    private WebElement randomComputerName(int row) {
        return ElementFinder.findElementByXpath("//*[@class='computers zebra-striped']/tbody/tr["+row+"]/td/a"); }
    private List<WebElement> computerNameLst(){
        return ElementFinder.findElementListByCssSelector(".computers.zebra-striped > tbody>tr>td>a"); }
    private WebElement nextArea(){ return ElementFinder.findElementByCssSelector(".next"); }
    private WebElement nextBtn(){ return ElementFinder.findElementByCssSelector(".next > a"); }
    private WebElement noResult(){ return ElementFinder.findElementByCssSelector(".well > em"); }


    // ACTIONS
    public void clickOnCreateNewComputer(){
        ElementActions.click(addBtn(), "'Add new computer' button");
    }

    public void clickOnGlobalTitle(){
        ElementActions.click(globalTitle(), "'Global page' title");
    }

    public int getTotalNumberOfComputer(){
        String number = ElementActions.getText(computerNumTxt(), "'Computer found' text");
        number = number.split(" ")[0];
        return Integer.parseInt(number);
    }

    public void filterWith(String keyword){
        ElementActions.inputText(searchTxt(), keyword, "'Search' box");
        ElementActions.click(searchBtn(), "'Search' button");
    }

    public int getNumberOfComputerRow(){
        return computerRow().size();
    }

    public void clickOnFirstComputer(){
        ElementActions.click(computerName(), "'Computer name' link");
    }

    public void clickOnNextButton(){
        ElementActions.click(nextBtn(), "'Next' button");
    }

    // ASSERTIONS
    public void verifyTheNumberOfComputerFound(Object actual, Object expected){
        Assertions.verifyEquals(actual, expected, "number of computer found ");
    }

    public List<String> getComputerNameList(List<WebElement> lst) {
        List<String> computerName = new ArrayList<>();
        for (WebElement ele : lst) {
            computerName.add(ele.getText());
        }
        return computerName;
    }

    public void verifySearchResultContains(String keyword){
        for(String i : getComputerNameList(computerNameLst())){
            Assertions.verifyTrue(i.toLowerCase().contains(keyword.toLowerCase()), i + " contains " + keyword);
        }
    }

    public void verifyAllSearchResult(String keyword){
        boolean isNextDisabled = nextArea().getAttribute("class").contains("disabled");
        verifySearchResultContains(keyword);
        while(!isNextDisabled){
            clickOnNextButton();
            verifySearchResultContains(keyword);
            isNextDisabled = nextArea().getAttribute("class").contains("disabled");
        }
    }

    public void verifyNoResultFoundTextDisplayed(){
        Assertions.verifyEquals(noResult().getText().trim(), "Nothing to display", "'No result' text");
    }
}
