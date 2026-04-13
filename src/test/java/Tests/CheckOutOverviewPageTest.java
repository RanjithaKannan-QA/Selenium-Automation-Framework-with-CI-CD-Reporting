package Tests;

import Base.BaseTest;
import Pages.*;
import Utilities.DataProviderUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckOutOverviewPageTest extends BaseTest {

    @Test(dataProvider = "checkoutData",dataProviderClass = DataProviderUtils.class)
    public void testFinish(String username, String password,String firstName, String lastName, String postalCode){

        LoginPage loginPage= new LoginPage(driver,timeout);
        HomePage homePage = loginPage.performLogin(username , password);
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

         CheckOutCompletePage checkOutCompletePage = checkOutOverviewPage.clickFinish();

         log.info("Verifying navigation to CheckOutCompletePage");
         Assert.assertTrue( checkOutCompletePage.isCheckOutCompletePageLoaded(),
                 "checkOutCompletePage Not Loaded : URL does not contain 'checkout-complete'");
         Assert.assertEquals(checkOutCompletePage.getHeaderText(),"Checkout: Complete!",
                 "HeaderText mismatch in 'CheckOutCompletePage'");


    }

}
