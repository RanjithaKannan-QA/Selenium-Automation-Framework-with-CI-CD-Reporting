package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class WaitUtils {

    public static WebElement waitForElement(WebDriver driver, By locator, Duration timeout){

        WebDriverWait wait = new WebDriverWait(driver , timeout);

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        return element;

    }
}
