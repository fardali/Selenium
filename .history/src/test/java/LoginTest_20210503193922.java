
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

    private String email = "rakahec265@goqoez.com";
    private String password = "testing2021\n";

    private By emailXpath=By.xpath("//*[@id='__next']/div/main/div/div/div/div[3]/form/div[1]/div/input");
    private By passwordXpath=By.xpath("//*[@id='__next']/div/main/div/div/div/div[3]/form/div[2]/div/input");
    private By submit = By.xpath("//*[@id='__next']/div/main/div/div/div/div[4]/button");
    
    public LoginTest(WebDriver driver) {
        super(driver);
        this.driver.get("https://account.avito.ma/login");
    }    

    public LoginResultPage login(){

        this.waitAndReturnElement(emailXpath).click();
        this.waitAndReturnElement(emailXpath).sendKeys(email);

        this.waitAndReturnElement(passwordXpath).click();
        this.waitAndReturnElement(passwordXpath).sendKeys(password);

        this.waitAndReturnElement(submit).click();

        return new LoginResultPage(this.driver);


    }
}