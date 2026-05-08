package Tests;

import Base.BaseTest;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.YourCartPage;
import Utilities.DataProviderUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {


@Test(dataProvider = "loginData", dataProviderClass = DataProviderUtils.class)
    public void testAddProductsToCart(String username, String password)
    {
        LoginPage loginPage = new LoginPage(timeout);
        HomePage homePage = loginPage.performLogin(username , password);
        Assert.assertTrue(homePage.isHomePageLoaded(), "Login failed: URL did not contain 'inventory'");

        homePage.addProductToCart();
        YourCartPage yourCartPage = homePage.goToCart();
          boolean value1 = yourCartPage.isYourCartPageLoaded();
        Assert.assertTrue(value1 , "YourCartPage Not Loaded:URL does not contain 'cart'");
          String expectedValue = "Your Cart";
        String actualValue  = yourCartPage.getHeaderText();
        Assert.assertEquals(actualValue , expectedValue , "HeaderText mismatch in YourCartPage ");

        System.out.println(
                "Thread ID: " + Thread.currentThread().getId() +
                        " | " + Thread.currentThread().getName());


    }

}
