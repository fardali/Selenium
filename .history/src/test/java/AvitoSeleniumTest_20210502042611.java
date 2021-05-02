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
import java.util.*;  


public class AvitoSeleniumTest {
    public WebDriver driver;
    
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    
    @Test
    public void testSearch() {
        SearchTest searchTest = new SearchTest(this.driver);
        //Assert.assertTrue(searchTest.getFooterText().contains("2021 ELTE Faculty of Informatics"));
               
        SearchResultPage searchResultPage = searchTest.search("iphone");
        String bodyText = searchResultPage.getSrearchresult();
        System.out.println(bodyText);
        Assert.assertTrue(bodyText.contains("0 annonces"));
        //Assert.assertTrue(bodyText.contains("For Students"));
    }
    
    
    
    

    
    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
