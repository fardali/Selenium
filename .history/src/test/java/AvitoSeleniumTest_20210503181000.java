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
    
    
    /*@Test
    public void contactTest(){ // this function tests form sending + logout and searching
        //FormSendTest formSend = new FormSendTest(this.driver);
        //SendFormResultPage sfrp = formSend.fillFormAndSend("daliyo7u","0642385701","tem7lll0u@gmail.com"); //after running tests twice change the phone number to a random phone number starting with 06XXXXXXXX and a random email
        //Logout logout = new Logout(this.driver);
        //LogoutResultPage lorp = logout.logout(); // logout testing 
        //SearchTest searchTest = new SearchTest(this.driver);  
        //SearchResultPage searchResultPage = searchTest.search("iphone"); // testing search function 
        //String seachText = searchResultPage.getSrearchresult();
        ContactTest contactUs = new ContactTest(this.driver);
        ContactConfirmationPage ccp = contactUs.contact("fardali youssef","tempEmail@tempEmail.com","this is an automated input sent by selinium test with Java, please ignore this message !");
        String message = ccp.getContactConfirmation();
        Assert.assertEquals("Merci pour votre message !",message);
        // Assert.assertTrue(message==);
        //String loggedin = sfrp.getRegistrationConfirmation();
        //Assert.assertTrue(loggedin=="testertester");
    }*/
    @Test
    public void searchTest(){
        SearchTest searchTest = new SearchTest(this.driver);  
        SearchResultPage searchResultPage = searchTest.search("iphone"); // testing search function 
        String text = searchResultPage.getSrearchresult();
        Assert.assertThat(text, CoreMatchers.containsString("Téléphones au Maroc"));
    }
    
    
    

    
    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
