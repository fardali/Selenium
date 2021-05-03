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

public class ContactTest extends PageBase {

    //-------------------attributes 

    private By nameXpath = By.xpath("/html/body/div[2]/div[4]/div/div[1]/div/div/form/div[2]/div[1]/div/input");
    private By emailXpath = By.xpath("/html/body/div[2]/div[4]/div/div[1]/div/div/form/div[2]/div[2]/div/input");
    private By textXpath = By.xpath("//*[@id='support_body']");
    private By sendXpath = By.xpath("/html/body/div[2]/div[4]/div/div[1]/div/div/form/div[3]/input");

    public ContactTest(WebDriver driver) {
        super(driver);
        this.driver.get("https://www2.avito.ma/support/form/0?id=3");
    }    

    public ContactConfirmationPage contact(String name,String email,String text){
        this.waitAndReturnElement(nameXpath).click();
        this.waitAndReturnElement(nameXpath).sendKeys(name);

        this.waitAndReturnElement(emailXpath).click();
        this.waitAndReturnElement(emailXpath).sendKeys(email);

        this.waitAndReturnElement(textXpath).click();
        this.waitAndReturnElement(textXpath).sendKeys(text);

        this.waitAndReturnElement(sendXpath).click();

        return new ContactConfirmationPage(this.driver);
    }
}
