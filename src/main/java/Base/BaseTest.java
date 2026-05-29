package Base;

import Utilities.ConfigReader;
import Utilities.DriverFactory;
import Utilities.Log;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {


   protected Duration timeout;
   protected Logger log = Log.getLogger(this.getClass());

  @Parameters("browserName")
  @BeforeMethod
    public void setUp(String browserName)
    {

         DriverFactory.initializeDriver(browserName);
         WebDriver driver = DriverFactory.getDriver();

         driver.manage().window().maximize();
         timeout = Duration.ofSeconds(Integer.parseInt(ConfigReader.getProperty("timeout")));
         String URL = ConfigReader.getProperty("url");
         driver.get(URL);
         log.info("Launched browser '{}' and navigated to url {}" , browserName, URL);
         log.info("Thread ID : " + Thread.currentThread().getId()
                + " Browser : " + browserName);
    }

   @AfterMethod
    public void tearDown()
    {
       DriverFactory.quitDriver();
        log.info("Browser closed successfully");
    }
    }
