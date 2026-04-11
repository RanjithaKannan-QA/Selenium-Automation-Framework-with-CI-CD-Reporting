package Tests;

import Base.BaseTest;
import Pages.*;
import Utilities.ConfigReader;
import Utilities.DataProviderUtils;
import Utilities.ExcelUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;

public class CheckOutYourInfoPageTest extends BaseTest {

    @Test(dataProvider = "checkoutData" , dataProviderClass = DataProviderUtils.class)
    public void testUpdateInformation(String firstName, String lastName, String postalCode){

        LoginPage loginPage= new LoginPage(driver,timeout);
        HomePage homePage = loginPage.performLogin(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));
        log.info("Verifying HomePage is loaded after login");
        Assert.assertTrue(homePage.isHomePageLoaded(),"Login failed: URL did not contain 'inventory'");

        homePage.addProductToCart();
        YourCartPage yourCartPage = homePage.goToCart();
        log.info("Verifying navigation to YourCartPage");
        Assert.assertTrue(yourCartPage.isYourCartPageLoaded(),"YourCartPage Not Loaded:URL does not contain 'cart'");

        CheckOutYourInfoPage checkOutYourInfoPage = yourCartPage.clickCheckOut();
        log.info("Verifying navigation to Checkout Information Page ");
        Assert.assertTrue(checkOutYourInfoPage.isCheckOutYourInfoPageLoaded(),
                "CheckOutYourInfoPage Not Loaded : URL does not contain 'checkout-step-one'");

        checkOutYourInfoPage.updateInfo(firstName,lastName,postalCode);
        CheckOutOverviewPage checkOutOverviewPage = checkOutYourInfoPage.clickContinue();

        log.info("verifying navigation to CheckOutOverviewPage");
        Assert.assertTrue(checkOutOverviewPage.isCheckOutOverviewPageLoaded(),
                "CheckOutOverviewPage Not Loaded : URL does not contain 'checkout-step-two'");

        Assert.assertEquals(checkOutOverviewPage.getHeaderText(), "Checkout: Overview",
                "HeaderText mismatch in 'CheckOutOverviewPage' " );


    }
}
