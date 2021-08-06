package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import pages.HomePage;
import utils.logs.Log;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public WebDriver driver;
    public HomePage homePage;

    public WebDriver getDriver() {
        return driver;
    }


    @BeforeClass
    @Parameters("browser")
    public void classLevelSetup(String browser) throws Exception {

        //Check if parameter passed from TestNG is 'firefox'
        if (browser.equalsIgnoreCase("firefox")) {
            //create firefox instance
            System.setProperty("webdriver.gecko.driver", "./src/test/resources/driver/geckodriver.exe");
            driver = new FirefoxDriver();
        }
        //Check if parameter passed as 'chrome'
        else if (browser.equalsIgnoreCase("chrome")) {
            //set path to chromedriver.exe
            System.setProperty("webdriver.chrome.driver", "./src/test/resources/driver/chromedriver.exe");
            //create chrome instance
            ChromeOptions co = new ChromeOptions();
            co.addArguments("test-type");
            co.addArguments("--allow-silent-push");
            co.addArguments("--disable-gtesteolocation");
            co.addArguments("--disable-save-password-bubble");
            co.addArguments("--enable-automatic-password-saving");
            co.addArguments("start-maximized");
            co.addArguments("--disable-popup-blocking");
            driver = new ChromeDriver(co);
        }

        //Check if parameter passed as 'Edge'
        else if (browser.equalsIgnoreCase("Edge")) {
            //set path to Edge.exe
            System.setProperty("webdriver.edge.driver", "./src/test/resources/driver/msedgedriver.exe");
            //create Edge instance
            driver = new EdgeDriver();
        } else {
            //If no browser passed throw exception
            throw new Exception("Browser is not correct");
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @BeforeMethod
    public void methodLevelSetup() {
        homePage = new HomePage(driver);
    }

    @AfterMethod
    public void methodLevelTeardown(){
        driver.manage().deleteAllCookies();

    }

    @AfterClass
    public void teardown() {
        Log.info("Tests are ending!");
        driver.quit();
    }
}