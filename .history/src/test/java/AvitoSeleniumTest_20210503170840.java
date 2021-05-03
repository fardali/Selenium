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
    
    //@Test
    /*public void testSearch() { // the search test is based on 3 xpaths and sending a form by filling one text area and chosing from a drop down values !
        SearchTest searchTest = new SearchTest(this.driver);  
        SearchResultPage searchResultPage = searchTest.search("iphone");
        String seachText = searchResultPage.getSrearchresult();
        //System.out.println(seachText);
        Assert.assertTrue(!seachText.contains("0 announces"));
    }*/
    @Test
    public void testing(){ // this function tests form sending + logout and searching
        FormSendTest formSend = new FormSendTest(this.driver);
        SendFormResultPage sfrp = formSend.fillFormAndSend("daliyo7u","0642385707","templll0u@gmail.com"); //after running tests twice change the phone number to a random phone number starting with 06XXXXXXXX and a random email
        Logout logout = new Logout(this.driver);
        LogoutResultPage lorp = logout.logout(); // logout testing 
        SearchTest searchTest = new SearchTest(this.driver);  
        SearchResultPage searchResultPage = searchTest.search("iphone"); // testing search function 
        String seachText = searchResultPage.getSrearchresult();
        
        Assert.assertTrue(!seachText.contains("0 announces"));
        //String loggedin = sfrp.getRegistrationConfirmation();
        //Assert.assertTrue(loggedin=="testertester");
    }
    
    
    

    
    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
