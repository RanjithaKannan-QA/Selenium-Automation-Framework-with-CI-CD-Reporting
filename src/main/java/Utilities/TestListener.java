package Utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;



public class TestListener implements ITestListener {


    public void onTestFailure(ITestResult result) {
        WebDriver driver = DriverFactory.getDriver();

        String timestamp = new SimpleDateFormat("yyMMdd_HHmmss").format(new Date());
        String screenShotFileName = result.getName()+ "_" + timestamp ;


        File screenShotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenShotFile, new File(System.getProperty("user.dir") + "//screenshots//" + screenShotFileName + ".png"));
        } catch (IOException e) {
            //throw new RuntimeException(e);
            e.printStackTrace();
        }
    }

}
