package TestScript;

import PageObject.pages.AddComputerPage;
import PageObject.pages.HomePage;
import Utils.Common;
import Utils.Log;
import org.testng.annotations.*;
import java.lang.reflect.Method;
import java.util.List;

public class AddComputerTest extends BaseTest {
    private AddComputerPage add;
    private HomePage home;

    @BeforeClass
    public void beforeClass(){
        add = new AddComputerPage();
        home = new HomePage();
    }

    @BeforeMethod
    public void beforeMethod(Method method)
    {
        Log.info("==============Start test script: " + method.getName() + "============");
    }

    @Test(description = "ADD01 - Verify user is able to add a computer with all fields are valid")
    public void verify_User_AddsNewComputer_Successfully(){
       //Add a new computer
        int num = home.getTotalNumberOfComputer();
        home.clickOnCreateNewComputer();
        add.addComputerName();
        add.addIntroducedDate();
        add.addDiscontinuedDate();
        add.selectACompany();
        List<String> info = add.getComputerInfo();
        add.clickOnSubmitButton();

        //Filter and verify computer info
        home.verifyTheNumberOfComputerFound(home.getTotalNumberOfComputer(), num +1);
        home.filterWith(info.get(0));
        add.verifyTheNumberOfComputer(home.getNumberOfComputerRow(), 1);
        home.clickOnFirstComputer();
        add.verifyComputerInfoShowsCorrectly(info, add.getComputerInfo());

        //Delete created computer
        add.clickOnDeleteButton();
    }

    @Test(description = "ADD02 - Verify user is able to add a computer with required field only")
    public void verify_User_Add_Computer_Successfully_WithRequiredFieldsOnly(){
        //Add a new computer with name only
        int num = home.getTotalNumberOfComputer();
        home.clickOnCreateNewComputer();
        add.addComputerName();
        List<String> info = add.getComputerInfo();
        add.clickOnSubmitButton();

        //Filter and verify computer info
        home.verifyTheNumberOfComputerFound(home.getTotalNumberOfComputer(), num +1);
        home.filterWith(info.get(0));
        add.verifyTheNumberOfComputer(home.getNumberOfComputerRow(), 1);
        home.clickOnFirstComputer();
        add.verifyComputerInfoShowsCorrectly(info, add.getComputerInfo());

        //Delete created computer
        add.clickOnDeleteButton();
    }

    @Test(description = "ADD03 - Verify user is unable to add a computer without required field.")
    public void verify_User_IsUnableToAddAComputer_WithoutRequiredFields(){
        //Add a new computer without required fields (name)
        home.clickOnCreateNewComputer();
        add.addIntroducedDate();
        add.addDiscontinuedDate();
        add.selectACompany();
        add.clickOnSubmitButton();

        //Verify error message shows and user is on 'add a computer' page
        add.verifyTheNameFieldsIsHighlighted();
        add.verifyPageTitle();
        Common.back();
    }

    @AfterMethod
    public void afterMethod(Method method)
    {
        home.clickOnGlobalTitle();
    }

}
