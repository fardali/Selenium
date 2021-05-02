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
    private By checkbox = By.xpath("//*[@id='phone_hidden']");
    private By  = By.xpath("");
    private By  = By.xpath("");
    private By  = By.xpath("");
    private By  = By.xpath("");
    private By  = By.xpath("");
    private By  = By.xpath("");
    
    
    
    //-------------------------------------------------------------------------------------------------
    public FormSendTest(WebDriver driver) {
        super(driver);
        this.driver.get("https://www.avito.ma/account/create");
    }    

    public void fillFormAndSend(){
        this.waitAndReturnElement(typename).click();
        this.waitAndReturnElement(selectPhoneOption).click();

        this.waitAndReturnElement(cityInput).click();
        this.driver.manage().timeouts().implicitlyWait(22, TimeUnit.SECONDS);

        this.waitAndReturnElement(cityCasablanca).click();
        //this.driver.manage().timeouts().implicitlyWait(22, TimeUnit.SECONDS);

        this.waitAndReturnElement(cityInput).sendKeys("Casablanca\n");

        //this.waitAndReturnElement(secteurInput).click();
        //this.driver.manage().timeouts().implicitlyWait(22, TimeUnit.SECONDS);

       // this.waitAndReturnElement(secteurInput).sendKeys("2 Mars \n");
        //this.driver.manage().timeouts().implicitlyWait(22, TimeUnit.SECONDS);

        this.waitAndReturnElement(next).click();
        this.waitAndReturnElement(title).click();

        


        
        


    }


}