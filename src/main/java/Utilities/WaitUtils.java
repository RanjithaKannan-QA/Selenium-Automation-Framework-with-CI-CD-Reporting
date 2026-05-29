package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class WaitUtils {

    public static WebElement waitForVisibility(WebDriver driver, By locator, Duration timeout){

        WebDriverWait wait = new WebDriverWait(driver , timeout);

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        return element;

    }

    public static WebElement waitForClickability(WebDriver driver, By locator, Duration timeout){

        WebDriverWait wait = new WebDriverWait(driver, timeout);

        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));

        return  element;

    }

    public  static boolean waitForUrlContains(WebDriver driver, String value,Duration timeout)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeout);

        boolean element =  wait.until(ExpectedConditions.urlContains(value));

        return element;
    }

}
