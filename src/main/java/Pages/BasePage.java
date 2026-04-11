package Pages;
import Utilities.Log;
import Utilities.WaitUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.testng.Assert;

import java.time.Duration;

public class BasePage {

   protected WebDriver driver;
   protected Duration timeout ;
   protected Logger log = Log.getLogger(this.getClass());

    public BasePage(WebDriver driver, Duration timeout){

        this.driver = driver;
        this.timeout = timeout;
    }

    public void enterText(By locator, String text)
    {
        log.info("Entering text into the field '{}'" ,locator);
        WaitUtils.waitForElement(driver, locator , timeout).sendKeys(text);
    }

    public void click(By locator)
    {
        log.info("clicking on element '{}'", locator);
        WaitUtils.waitForElement(driver, locator , timeout ).click();
    }

    public boolean isElementDisplayed(By locator){
        try{
            log.info("Checking visibility of element at '{}'", locator );
            WebElement element =  WaitUtils.waitForElement(driver,locator,timeout);
            boolean result = element.isDisplayed();
            log.info("Element '{}' displayed status: '{}'", locator , result );
            return result;
        }
        catch (TimeoutException e)
        {
            log.warn("Element '{}' is not displayed within timeout. Exception{} : ", locator , e.getMessage());
            return false;
        }
    }

    public boolean isUrlContains(String value)
    {
        String currentUrl = driver.getCurrentUrl();
        boolean result = currentUrl.contains(value);
        log.info("The currentUrl : {}", currentUrl );
        log.info("Validating if url contains '{}' :  {}", value ,result );
        return result;

    }

    public String getText(By locator)
    {
       log.info("Fetching text from element '{}'", locator );
        WebElement element =WaitUtils.waitForElement(driver, locator, timeout);
        String  elementText = element.getText().trim();
        log.info("the element text is : '{}'" ,elementText);
        return elementText;

    }


}
