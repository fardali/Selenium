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

public class Logout extends PageBase {

    //-------------------attributes 

    private By dropDownXpath = By.xpath("//*[@id='__next']/div/nav/div/ul/li[4]/div/button");
    private By logoutButton = By.xpath("//*[@id='__next']/div/nav/div/ul/li[4]/div/ul/li[5]/button");

    public Logout(WebDriver driver) {
        super(driver);
        this.driver.get("https://account.avito.ma/");
    }    

    public LogoutResultPage logout(){
        
        this.waitAndReturnElement(dropDownXpath).click();
        this.waitAndReturnElement(logoutButton).click();


        return new LogoutResultPage(this.driver);
    }





}