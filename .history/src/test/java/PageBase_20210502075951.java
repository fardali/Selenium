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


class PageBase {
    protected WebDriver driver;
    protected WebDriverWait wait;
    
    
    public PageBase(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }
    
    protected WebElement waitAndReturnElement(By locator) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return this.driver.findElement(locator);
    } 
    
    public String getSrearchresult() {
        WebElement bodyElement = this.waitAndReturnElement(By.xpath("//*[@id='__next']/main/div[3]/div[3]/div[1]/div/h1"));
        return bodyElement.getText();
    }
    public String getRegistrationConfirmation() {
        WebElement bodyElement = this.waitAndReturnElement(By.xpath("//*[@id='__next']/div/nav/div/ul/li[4]/div/button/span/span/span"));
        return bodyElement.getText();
    }
    public String getLogoutPage() {
        WebElement bodyElement = this.waitAndReturnElement(By.xpath("//*[@id='__next']/div/main/div/div/div/div[1]/div/h4"));
        return bodyElement.getText();
    }
   
}
