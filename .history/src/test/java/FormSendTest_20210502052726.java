ort io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class FormSendTest extends PageBase {


    private By typename = By.name("category");
    private By selectPhoneOption = By.xpath("//*[@id='__next']/div/main/div/form/div[2]/div/div[1]/div[2]/div/select/option[2]");

    public FormSendTest(WebDriver driver) {
        super(driver);
        this.driver.get("https://www.avito.ma/fr/ai/misc");
    }    

    public void fillFormAndSend(){


    }


}