package Tests;

import Base.BaseTest;
import Pages.HomePage;
import Pages.LoginPage;
import Utilities.DataProviderUtils;
import Utilities.RetryAnalyzer;
import Utilities.TestListener;
import org.apache.commons.io.filefilter.FalseFileFilter;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {


    @Test(dataProvider = "loginData", dataProviderClass = DataProviderUtils.class )
    public void testValidLogin(String username , String password) {


        LoginPage loginPage = new LoginPage(timeout);
        HomePage homePage = loginPage.performLogin(username, password);
        boolean value1 = homePage.isHomePageLoaded();
        Assert.assertTrue(value1, "Login failed: URL did not contain 'inventory'");
        boolean value2 = homePage.isMenuDisplayed();
        Assert.assertTrue(value2, "HomePage UI issue: Menu button not visible");
        String expectedText = "Products";
        String actualText = homePage.getHeaderText();
        Assert.assertEquals(actualText,expectedText, "HeaderText mismatch in HomePage" );

        System.out.println(
                "Thread ID: " + Thread.currentThread().getId() +
                        " | " + Thread.currentThread().getName());


    }
}
