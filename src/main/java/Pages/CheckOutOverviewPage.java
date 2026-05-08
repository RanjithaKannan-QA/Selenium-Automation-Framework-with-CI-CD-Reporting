package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.time.Duration;

public class CheckOutOverviewPage extends BasePage {

    public CheckOutOverviewPage (Duration timeout){
        super(timeout);
    }

    private By finishbtn = By.id("finish");
    private By pageTitle = By.xpath("//span[@class='title']");

    public String getHeaderText(){
       return getText(pageTitle);
    }

    public boolean isCheckOutOverviewPageLoaded(){
       return isUrlContains("checkout-step-two");
    }

    public CheckOutCompletePage clickFinish(){
        log.info("Clicking on Finish button");
        click(finishbtn);
        return new  CheckOutCompletePage(timeout);
    }

}
