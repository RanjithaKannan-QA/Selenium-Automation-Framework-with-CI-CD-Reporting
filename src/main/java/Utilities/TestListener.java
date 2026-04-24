package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class TestListener implements ITestListener {

    private static  ExtentReports extent = ExtentManager.getExtendReports();
    private static ExtentTest test ;
    private static Logger log = Log.getLogger(TestListener.class);
    private static Map<String, ExtentTest> testMap = new HashMap<>();

    public void onStart(ITestContext context) {
      System.out.println("Test Execution Started Successfully");
       log.info("=========Test Execution Started :" + context.getName() + "=========");
    }

    public void onTestStart(ITestResult result) {

         Object[] params = result.getParameters();
         String paramName = "";
         if(params.length>0)
         {
             paramName = "-[" + params[0].toString() + "]";
         }
         String testName = result.getMethod().getMethodName() + paramName ;

         if(testMap.containsKey(testName)){
             test =testMap.get(testName);
             test.info("Retry Attempt Started...");
         }else {
             test = extent.createTest(testName, "Test Started");
             testMap.put(testName , test);
         }
    }

    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS,"Test Passed Successfully");
    }

    public void onTestFailure(ITestResult result) {
        if(result.wasRetried()){
            return;
        }

        test.log(Status.FAIL,"Test Failed");
        test.fail(result.getThrowable());

        WebDriver driver = DriverFactory.getDriver();

        String timestamp = new SimpleDateFormat("yyMMdd_HHmmss").format(new Date());
        String screenShotFileName = result.getName()+ "_" + timestamp + ".png" ;
        String screenShotFilePath = System.getProperty("user.dir") + "/screenshots/" + screenShotFileName;

        File screenShotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenShotFile, new File(screenShotFilePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String relativePath = "../screenshots/" + screenShotFileName;
        test.addScreenCaptureFromPath(relativePath , " Failure Screenshot");
    }


    public void onTestSkipped(ITestResult result) {
       if(result.wasRetried()){
           return;
       }
       String message = "Test : " + result.getMethod().getMethodName() + "was Skipped" ;
       test.skip(message);
       if(result.getThrowable() != null){
           test.skip(result.getThrowable());
       }

    }

    public void onFinish(ITestContext context) {
        log.info("Test Execution Completed Successfully");
       extent.flush();
    }
}
