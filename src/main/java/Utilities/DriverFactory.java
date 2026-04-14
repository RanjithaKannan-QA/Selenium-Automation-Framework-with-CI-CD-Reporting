package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;

public class DriverFactory {

   private static WebDriver driver;

    public static WebDriver initializeDriver(String browser) {


        if (browser.equalsIgnoreCase("Chrome"))
        {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--disable-notifications");
            chromeOptions.addArguments("--disable-extensions");
            chromeOptions.addArguments("--incognito");

            Map<String , Object> prefs = new HashMap<>();
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            prefs.put("profile.password_manager_leak_detection", false);
            chromeOptions.setExperimentalOption("prefs", prefs);

            boolean isCI = "true".equalsIgnoreCase(System.getenv("CI"));
            if(isCI){
                chromeOptions.addArguments("--headless=new");
                chromeOptions.addArguments("--no-sandbox");
                chromeOptions.addArguments("--disable-dev-shm-usage");
                chromeOptions.addArguments("--window-size=1920,1080");
            }

            driver = new ChromeDriver(chromeOptions);

        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else {
            throw new RuntimeException("Unsupported Browser : " + browser);
        }
        return driver;
    }

    public static WebDriver getDriver() {

            return driver;
    }
}
