package Pages;
import Utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.time.Duration;

public class LoginPage extends BasePage {

    public LoginPage(Duration timeout)
    {
       super(timeout);
    }

  private By txtUsername = By.xpath("//input[@placeholder='Username']");
  private By txtPassword = By.id("password");
  private By btnLogin = By.id("login-button");

  public HomePage performLogin(String username , String password)
      {
          log.info("Performing login");
           enterText(txtUsername,username);
           enterText(txtPassword , password);
           click(btnLogin);
           return new HomePage(timeout);
      }

}

