package TestScript;

import PageObject.pages.HomePage;
import Utils.Log;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class HomePageTest extends BaseTest {
    private HomePage home;

    @BeforeClass
    public void beforeClass() {
        home = new HomePage();
    }

    @BeforeMethod
    public void beforeMethod(Method method) {
        Log.info("==============Start test script: " + method.getName() + "============");
    }

    @Test(description = "FI_01 - Verify user is able to filter by computer name.")
    public void verify_User_IsAbleToFilter_ByComputerName() {
        home.filterWith(home.validKeyword);
        home.verifyAllSearchResult(home.validKeyword);
    }

    @Test(description = "FI_11 - Verify no results display when entering an invalid computer name")
    public void verify_User_IsAbleToDeleteSearchKeyword_ByRemoveIcon() {
        home.filterWith(home.invalidKeyword);
        home.verifyNoResultFoundTextDisplayed();
    }

    @AfterMethod
    public void afterMethod(Method method)
    {
        home.clickOnGlobalTitle();
    }

}
