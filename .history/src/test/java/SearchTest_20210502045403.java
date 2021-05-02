import org.junit.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class SearchTest extends PageBase {



    //private By footerBy = By.className("input-block-level no-margin");
    private By xpathSearchBox = By.xpath("/html/body/div[2]/section[1]/section[2]/div[1]/div/div/form/div/div[1]/input");  // using the xpath is working 
    private By categoryDropDownXpath = By.xpath("//*[@id='__next']/main/div[3]/div[1]/div/div/form/div[1]/div[1]/div[1]/div/div/div/div/div/div[1]/li[3]");
    private By name = By.name("q"); // the name of search box in Avito.ma
    
    public SearchTest(WebDriver driver) {
        super(driver);
        this.driver.get("https://www.avito.ma");
    }    
    
    
    public SearchResultPage search(String searchQuery) {
        this.waitAndReturnElement(categoryDropDownXpath).click();
        this.waitAndReturnElement(xpath).click();
        
        this.waitAndReturnElement(xpath).sendKeys(searchQuery + "\n");
        return new SearchResultPage(this.driver);
    }


}