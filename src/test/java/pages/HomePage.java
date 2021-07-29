package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.logs.Log;

import java.util.List;

public class HomePage extends BasePage {

    /**
     * Constructor
     */
    public HomePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Variables
     */
    String baseURL = "http://www.yemeksepeti.com/";

    /**
     * Web Elements
     */

    /**
     * Page Methods
     */
    //Go to Homepage
    public HomePage goToYemeksepeti() {
        Log.info("Opening Yemeksepeti Website.");
        driver.get(baseURL);
        return this;
    }

    //Go to LoginPage
    public LoginPage goToLoginPage() {
        List<WebElement> elementName = driver.findElements(By.cssSelector(".cityPlatesContainer .cityContainer .plateNo"));
        int plateNo = getRandomInteger(80, 0);

        int listsize = elementName.size();
        for (int i = 0; i < listsize; i++) {
            elementName.get(plateNo).click();
            break;
        }

        Log.info("Going to Login Page..");
        return new LoginPage(driver);
    }


}