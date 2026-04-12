package Tests;

import Base.BaseTest;
import Pages.*;
import Utilities.ConfigReader;
import Utilities.DataProviderUtils;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.apache.logging.log4j.LogManager.getLogger;

public class YourCartPageTest extends BaseTest {
    protected Logger log = getLogger(this.getClass());

    @Test(dataProvider = "loginData" , dataProviderClass = DataProviderUtils.class)
    public void testCheckOut(String username, String password)
    {
        LoginPage loginPage= new LoginPage(driver,timeout);
        HomePage homePage = loginPage.performLogin(username, password);
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
        Assert.assertEquals(checkOutYourInfoPage.getHeaderText(),"Checkout: Your Information" ,
                "HeaderText mismatch in CheckOutYourInfoPage ");
        log.info("CheckOutYourInfoPage is Returned Successfully");

    }
}
