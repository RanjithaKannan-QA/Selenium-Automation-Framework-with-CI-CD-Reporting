package Utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    private int count = 0;
    private static final int retryLimit = 2;

    public boolean retry(ITestResult result) {

        if (!result.isSuccess()) {
            if (count < retryLimit) {
                count++;
                return true;
            }
        }
                return false;
            }
        }


