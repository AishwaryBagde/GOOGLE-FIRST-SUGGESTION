package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.JavascriptExecutor;
//Selenium Imports
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
///


public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01()throws InterruptedException{
        System.out.println("Start Test case: testCase01");
        // boolean status = false;

        //1. Launch Browser (Chrome) :ChromeDriver()
        //2. Load URL :driver.get("https://www.google.com/")
        driver.get("https://www.google.com/");  
        Thread.sleep(3000);
        //3. Click on search bar and Type text in the Text Field Using Locator "XPath":"//input[@title='Search']" / click(); / "Aishwary Bagde"
        WebElement searchBar=  driver.findElementByXPath("//input[@aria-label='Search']");
        searchBar.click();
        searchBar.sendKeys("Aishwary Bagde");
        Thread.sleep(500);
        // 4.Click Enter on search bar :sendkeys(keys.ENTER);
        searchBar.sendKeys(Keys.ENTER); 
        //wait for 3 sec 
        Thread.sleep(3000);
        // 5. Storing the number of links in LIST of the search result with your name in it Using Locator "XPath":"//div[@class='yuRUbf']//a" List<WebElement> links ;
        List <WebElement> links = driver.findElementsByXPath("//div[@class='yuRUbf']//a");
        //6. Iterrate the webElement in for each loop :for(WebElement link : links {}
        //7 In for each loop get the attribute and print the links :sout(link.getAttribute("href") )
        for(WebElement link: links){
            System.out.println("The Search Result Links are : "+ link.getAttribute("href"));
        }
    }


}
