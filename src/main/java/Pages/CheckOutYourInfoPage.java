package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.time.Duration;


public class CheckOutYourInfoPage extends BasePage {

    public CheckOutYourInfoPage(Duration timeout){

        super(timeout);

    }

    private By firstnameField =  By.id("first-name");
    private By lastnameField = By.id("last-name");
    private By postalField = By.id("postal-code");
    private By continuebtn = By.id("continue");
    private By pageTitle = By.xpath("//span[@class='title']");

    public boolean isCheckOutYourInfoPageLoaded(){
       return isUrlContains("checkout-step-one");
    }

    public String getHeaderText(){
       return getText(pageTitle);
    }

    public void updateInfo(String firstName, String lastName,String postalCode) {
        log.info("Entering checkout user details");
        enterText(firstnameField, firstName);
        enterText(lastnameField, lastName);
        enterText(postalField, postalCode);
    }

    public CheckOutOverviewPage clickContinue(){
       log.info("Clicking Continue button");
       click(continuebtn);
       return new CheckOutOverviewPage(timeout);
    }

}
