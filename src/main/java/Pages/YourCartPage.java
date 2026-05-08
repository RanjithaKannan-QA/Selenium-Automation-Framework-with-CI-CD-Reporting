package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.time.Duration;

public class YourCartPage extends  BasePage {

    public YourCartPage (Duration timeout){

        super(timeout);
    }

    private By checkoutbtn = By.id("checkout");
    private By removebagbtn  = By.id("remove-sauce-labs-backpack");
    private By yourcarttxt = By.xpath("//span[@class='title']");



    public boolean isYourCartPageLoaded(){
       return isUrlContains("cart");
    }

    public String getHeaderText(){
        return getText(yourcarttxt);
    }
    public void removeItem(){
        log.info("Removing item from cart");
        click(removebagbtn);
    }
     public CheckOutYourInfoPage clickCheckOut(){
        log.info("Clicking on CheckOut button");
        click(checkoutbtn);
        return new CheckOutYourInfoPage(timeout);
     }


}
