
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.google.common.base.Function;
import java.util.concurrent.TimeUnit ;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class LoginTest extends PageBase {

    String email = "rakahec265@goqoez.com";
    String password = "testing2021\n";

    Private By emailXpath=By.xpath("//*[@id='__next']/div/main/div/div/div/div[3]/form/div[1]/div/input");
    Private By passwordXpath=By.xpath("//*[@id='__next']/div/main/div/div/div/div[3]/form/div[2]/div/input");
    private By submit = By.xpath("//*[@id='__next']/div/main/div/div/div/div[4]/button");
    public LoginTest(WebDriver driver) {
    super(driver);
    this.driver.get("https://account.avito.ma/login");

}    


}