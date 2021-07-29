package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.logs.JSErrorLogs;
import utils.logs.Log;

import static org.testng.AssertJUnit.*;

public class LoginPage extends BasePage {
    /**
     * Constructor
     */
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Web Elements
     */
    By userNameId = By.id("UserName");
    By passwordId = By.id("password");
    By loginButtonId = By.id("ys-fastlogin-button");
    By errorMessage = By.cssSelector("span[class='ys-xl inner'] strong");
    By emptyUserErrorMessage = By.cssSelector(".help-block[data-cv-field='UserName']");
    By emptyPassErrorMessage = By.cssSelector(".help-block[data-cv-field='Password']");


    By chooseArea = By.xpath("//span[@id='select2-ys-areaSelector-container']/span[@class='select2-selection__placeholder']");
    By chooseAreaXpath = By.xpath("//*[contains(@id,'ys-areaSelector-container')]");
    By editChooseArea = By.id("editing-view-port");
    By searchBox = By.id("placeholder");
    By allAreas = By.xpath("//*[contains(@id,'all-regions')]");


    /**
     * Page Methods
     */
    public LoginPage loginToYemeksepeti(String username, String password) {
        Log.info("Trying to login the Yemeksepeti.");
        writeText(userNameId, username);
        writeText(passwordId, password);
        click(loginButtonId);
        return this;
    }

    //Verify Username pass Condition
    public LoginPage verifyErrorMessage(String expectedText) {
        Log.info("Verifying login credentials.");
        waitVisibility(errorMessage);
        assertEquals(readText(errorMessage), expectedText);
        return this;
    }

    public LoginPage verifyLogError() {
        Log.info("Verifying javascript login errors.");
        assertTrue(JSErrorLogs.isLoginErrorLog(driver));
        return this;
    }

    public LoginPage verifyEmptyUserNameMessage(String expectedMessage) {
        Log.info("Verifying login credentials.");
        waitVisibility(emptyUserErrorMessage);
        assertEquals(readText(emptyUserErrorMessage), expectedMessage);
        return this;
    }

    public LoginPage verifyEmptyPassMessage(String expectedMessage) {
        Log.info("Verifying login credentials.");
        waitVisibility(emptyPassErrorMessage);
        assertEquals(readText(emptyPassErrorMessage), expectedMessage);
        return this;
    }

    public LoginPage failScenario() {
        fail();
        return this;
    }

    public LoginPage myFavoritePage() {
        Log.info("Opening my favorite restaurant list");
        WebElement chooseArea = driver.findElement(By.xpath("//*[contains(@id,'ys-areaSelector-container')]"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", chooseArea);
        WebElement element = driver.findElement(By.xpath("//span[@role='presentation']"));
        executor.executeScript("arguments[0].click();", element);

        return this;
    }
}