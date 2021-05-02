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

    //------------------------------first input page params -----------------------------------------------------------
    private By typename = By.name("category");
    private By selectPhoneOption = By.xpath("//*[@id='__next']/div/main/div/form/div[2]/div/div[1]/div[2]/div/select/option[2]");
    private By cityXpathInput = By.xpath("//*[@id='__next']/div/main/div/form/div[2]/div/div[1]/div[4]/div[1]/div/div[1]/input");
    private By secteurInput = By.xpath("//*[@id='__next']/div/main/div/form/div[2]/div/div[1]/div[5]/div/div/div[1]/input");
     // next button 

     private By next=By.xpath("//*[@id='__next']/div/main/div/form/div[3]/div[2]/button");
    
    //---------------------------------------------------------------------------------------------------------
    public FormSendTest(WebDriver driver) {
        super(driver);
        this.driver.get("https://www.avito.ma/fr/ai/misc");
    }    

    public void fillFormAndSend(){
        this.waitAndReturnElement(typename).click();
        this.waitAndReturnElement(selectPhoneOption).click();

        this.waitAndReturnElement(cityXpathInput).click();
        this.waitAndReturnElement(cityXpathInput).sendKeys("Casablanca \n");

        this.waitAndReturnElement(secteurInput).click();
        this.waitAndReturnElement(secteurInput).sendKeys("2 Mars \n");

        this.waitAndReturnElement(next).click();
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        


        
        


    }


}