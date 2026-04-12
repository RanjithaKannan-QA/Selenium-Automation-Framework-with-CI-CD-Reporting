package Utilities;

import org.testng.annotations.DataProvider;

public class DataProviderUtils {

    @DataProvider(name = "checkoutData")
    public Object[][] getCheckoutData() {
        return ExcelUtils.getExcelData("CheckoutData");

    }

    @DataProvider(name="loginData")
    public Object[][] getLoginData(){
        return ExcelUtils.getExcelData("LoginData");
    }
}
