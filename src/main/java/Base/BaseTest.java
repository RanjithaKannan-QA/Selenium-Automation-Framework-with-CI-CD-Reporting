package Base;

import Utilities.ConfigReader;
import Utilities.DriverFactory;
import Utilities.Log;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class BaseTest {

   protected WebDriver driver;
   protected Duration timeout;
   protected Logger log = Log.getLogger(this.getClass());

  @BeforeMethod
    public void setUp()
    {
         String  browserName = ConfigReader.getProperty("browser");
         driver  = DriverFactory.initializeDriver(browserName);
         driver.manage().window().maximize();
         timeout = Duration.ofSeconds(Integer.parseInt(ConfigReader.getProperty("timeout")));
         String URL = ConfigReader.getProperty("url");
         driver.get(URL);
         log.info("Launched browser '{}' and navigated to url {}" , browserName, URL);
    }

   @AfterMethod
    public void tearDown()
    {
        if (driver!=null) {
            driver.quit();
        }
        log.info("Browser closed successfully");
    }
    }
