import org.junit.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.hamcrest.core.StringContains;
import org.junit.Assert;
import com.github.javafaker.*;
import static java.lang.Math.*;

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
    public void testAll(){

        Faker faker = new Faker();
        String name = faker.name().fullName(); 
        String email = faker.internet().safeEmailAddress();
        int phone = (int)Math.floor(Math.random()*(99999999-10000000+1)+10000000);
 
    
        //========================================search test===================================================
        SearchTest searchTest = new SearchTest(this.driver);  
        SearchResultPage searchResultPage = searchTest.search("iphone"); // testing search function 
        String text = searchResultPage.getSrearchresult();
        Assert.assertThat(text, StringContains.containsString("phones au Maroc"));
        //---------------------------------------contact us test---------------------------------------------------------------
        ContactTest contactUs = new ContactTest(this.driver);
        ContactConfirmationPage ccp = contactUs.contact(name,email,"this is an automated input sent by selinium test with Java, please ignore this message !");
        String message = ccp.getContactConfirmation();
        Assert.assertEquals("Merci pour votre message !",message);
        //--------------------------------- registration test -------------------------------------------------------------------

        RegisterTest formSend = new RegisterTest(this.driver);
        SendFormResultPage sfrp = formSend.fillFormAndSend(name,"06"+phone,email);
        String msg = sfrp.getRegistrationConfirmation();
        //Assert.assertEquals("Vous avez quelque chose à vendre?",msg);
        //----------------------------------- logout test-----------------------------------------------------------
        Logout logout = new Logout(this.driver);
        LogoutResultPage lorp = logout.logout(); // logout testing 
        String lmsg = lorp.getLogoutConfirmation();
        Assert.assertEquals("Connexion",lmsg);

        //------------------------------login test ----------------------------------------------------------------------

        LoginTest login = new LoginTest(this.driver);
        LoginResultPage lrp = login.login();
        String mes =lrp.getLoginConfirmation();
        Assert.assertEquals("Vous avez quelque chose à vendre?",mes);
        //----------------------------------- logout test 2-----------------------------------------------------------
        Logout logout2 = new Logout(this.driver);
        LogoutResultPage lorp2 = logout2.logout(); // logout testing 
        String lmsg2 = lorp2.getLogoutConfirmation();
        Assert.assertEquals("Connexion",lmsg2);



    }
    
    
    

    
    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
