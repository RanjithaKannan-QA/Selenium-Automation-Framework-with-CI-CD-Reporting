package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.time.Duration;

public class CheckOutCompletePage extends BasePage{

    public CheckOutCompletePage(Duration timeout){
        super(timeout);
    }

    private By successmessage = By.xpath("//h2[@class='complete-header']");
    private By backhomebtn = By.id("back-to-products");
    private By pageTitle = By.xpath("//span[@class='title']");


    public boolean isCheckOutCompletePageLoaded(){
       return isUrlContains("checkout-complete");
    }

    public String getHeaderText(){
       return getText(pageTitle);
    }
    public boolean isOrderSuccessful(){
        log.info("Checking if order success message is displayed");
        return isElementDisplayed(successmessage);
    }

    public String getSuccessMessage() {
        log.info("Fetching order Success Message");
        return getText(successmessage);

    }

    public HomePage clickBackHome(){
        log.info("Navigating to HomePage");
        click(backhomebtn);
        return new HomePage(timeout);

    }




}
