package Tests;

import Base.BaseTest;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.YourCartPage;
import Utilities.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

@Test
    public void testAddProductsToCart() {
        LoginPage loginPage = new LoginPage(driver, timeout);
        HomePage homePage = loginPage.performLogin(ConfigReader.getProperty("username") , ConfigReader.getProperty("password"));
        Assert.assertTrue(homePage.isHomePageLoaded(), "Login failed: URL did not contain 'inventory'");

        homePage.addProductToCart();
        YourCartPage yourCartPage = homePage.goToCart();
          boolean value1 = yourCartPage.isYourCartPageLoaded();
        Assert.assertTrue(value1 , "YourCartPage Not Loaded:URL does not contain 'cart'");
          String expectedValue = "Your Cart";
        String actualValue  = yourCartPage.getHeaderText();
        Assert.assertEquals(actualValue , expectedValue , "HeaderText mismatch in YourCartPage ");

    }

}
