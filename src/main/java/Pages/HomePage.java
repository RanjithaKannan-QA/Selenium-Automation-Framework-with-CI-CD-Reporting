package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.time.Duration;

public class HomePage extends BasePage {

    public HomePage(Duration timeout)
    {
     super(timeout) ;
    }

   private By txtMenu = By.id("react-burger-menu-btn");
   private By txtproduct = By.xpath("//span[@class = 'title']");
   private By addonesiebtn =  By.id("add-to-cart-sauce-labs-onesie");
   private By addtshirtbtn = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
   private By addbagbtn = By.id("add-to-cart-sauce-labs-backpack");
   private By cartIcon = By.id("shopping_cart_container");

  public boolean isMenuDisplayed()
  {
    return isElementDisplayed(txtMenu);
  }

  public boolean isHomePageLoaded(){
      return  isUrlContains("inventory");
  }
  public String getHeaderText(){
     return getText(txtproduct);
  }

//    public void verifyPageLoad(){
//        log.info("Verifying navigation to HomePage");
//                Assert.assertTrue(homePageNew.isHomePageLoaded(),"HomePage Not loaded : URL does not contain 'inventory'");
//    }

  public void addProductToCart() {
      log.info("Adding products to cart");
      click(addonesiebtn);
      click(addtshirtbtn);
      click(addbagbtn);

  }

  public YourCartPage goToCart(){
      log.info("Navigating to  Cart");
      click(cartIcon);
      return new YourCartPage(timeout);

  }


}
