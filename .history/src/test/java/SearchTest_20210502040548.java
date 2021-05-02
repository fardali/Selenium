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



    private By footerBy = By.className("input-block-level no-margin");
    private By searchBarTogglerBy = By.xpath("//a[@class='input-block-level no-margin']/i");
    private By searchBarBy = By.name("q"); // the name of search box in Avito.ma
    
    public SearchTest(WebDriver driver) {
        super(driver);
        this.driver.get("https://www.avito.ma");
    }    
    
    public String getFooterText() {
        return this.waitAndReturnElement(footerBy).getText();
    }
    
    public SearchResultPage search(String searchQuery) {
        this.waitAndReturnElement(searchBarTogglerBy).click();
        
        this.waitAndReturnElement(searchBarBy).sendKeys(searchQuery + "\n");
        return new SearchResultPage(this.driver);
    }


}