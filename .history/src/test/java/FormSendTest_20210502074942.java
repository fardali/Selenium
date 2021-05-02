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

public class FormSendTest extends PageBase {

    //-------------------------- second for params -------------------------------------------------------------------------------
   
    private By typeradioType1 = By.id("p_ad");
    private By typeradioType2 = By.id("c_ad");
    private By nameInputXpath  = By.xpath("//*[@id='name']");
    private By phoneNumberXpath = By.xpath("/html/body/div[2]/div[4]/div[1]/div[1]/div/form/div[1]/div[4]/div/div/input");
    private By checkboxXpath = By.xpath("//*[@id='phone_hidden']");
    private By emailXpath = By.xpath("//*[@id='email']");
    private By emailRetypeXpath = By.xpath("/html/body/div[2]/div[4]/div[1]/div[1]/div/form/div[1]/div[7]/div/div/input");
    private By passwordxpath = By.xpath("//*[@id='passwd']");
    private By passwordRetypeXpath = By.xpath("/html/body/div[2]/div[4]/div[1]/div[1]/div/form/div[1]/div[9]/div/div/input");
    private By submitButton = By.xpath("//*[@id='create']");
    //private By  = By.xpath("");
    
    
    
    //-------------------------------------------------------------------------------------------------
    public FormSendTest(WebDriver driver) {
        super(driver);
        this.driver.get("https://www.avito.ma/account/create");
    }    

    public SendFormResultPage fillFormAndSend(String name,String number,String email){
        this.waitAndReturnElement(typeradioType2).click();
        this.waitAndReturnElement(typeradioType1).click();

        this.waitAndReturnElement(nameInputXpath).click();
        this.waitAndReturnElement(nameInputXpath).sendKeys(name);

        this.waitAndReturnElement(phoneNumberXpath).click();
        this.waitAndReturnElement(phoneNumberXpath).sendKeys(number);

        this.waitAndReturnElement(checkboxXpath).click();

        this.waitAndReturnElement(emailXpath).click();
        this.waitAndReturnElement(emailXpath).sendKeys(email);

        this.waitAndReturnElement(emailRetypeXpath).click();
        this.waitAndReturnElement(emailRetypeXpath).sendKeys(email);

        this.waitAndReturnElement(passwordxpath).click();
        this.waitAndReturnElement(passwordxpath).sendKeys("1fardali@gmail.com");

        this.waitAndReturnElement(passwordRetypeXpath).click();
        this.waitAndReturnElement(passwordRetypeXpath).sendKeys("1fardali@gmail.com\n");
        

        return new SendFormResultPage(this.driver);
    }


}