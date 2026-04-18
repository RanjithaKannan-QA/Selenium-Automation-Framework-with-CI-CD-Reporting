package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getExtendReports(){

        if (extent==null){

            String reportPathName = System.getProperty("user.dir") + "//reports//" + "ExtentReport.html" ;
            ExtentSparkReporter spark = new ExtentSparkReporter(reportPathName);

            spark.config().setTheme(Theme.DARK);
            spark.config().setDocumentTitle("SauceDemo Automation Report");
            spark.config().setReportName("E2E Testing Report");

            extent = new ExtentReports();
            extent.attachReporter(spark);
            extent.setSystemInfo("QA", "Ranjitha");
            extent.setSystemInfo("Environment", "Staging");

        }
        return extent;
    }
}
