package tests;

import static utils.extentreports.ExtentTestManager.startTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import java.lang.reflect.Method;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.listeners.TestListener;

//In order to eliminate attachment problem for Allure, you should add @Listener line.
//link: https://github.com/allure-framework/allure1/issues/730
@Listeners({ TestListener.class })
@Epic("Regression Tests")
@Feature("Login Tests")
public class LoginTests extends BaseTest {

    @Test(priority = 1, description = "Invalid Login Scenario with empty username and password.")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Description: Login test with empty username and empty password.")
    @Story("Empty username and password login test")
    public void invalidLoginTest_EmptyUserEmptyPassword(Method method) {
        startTest(method.getName(), "Invalid Login Scenario with empty username and password.");

        homePage
                .goToYemeksepeti()
                .goToLoginPage()
                .loginToYemeksepeti("", "")
                .verifyEmptyUserNameMessage("Lütfen kullanıcı adınızı/e-postanızı giriniz.")
                .verifyEmptyPassMessage("Lütfen şifrenizi giriniz.");
        driver.manage().deleteAllCookies();

    }

    @Test(priority = 2, description = "Invalid Login Scenario with wrong username and password.")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Login test with wrong username and wrong password.")
    @Story("Wrong username and password login test")
    public void invalidLoginTest_WrongUserNameWrongPassword(Method method) {
        startTest(method.getName(), "Invalid Login Scenario with wrong username and password.");

        homePage
            .goToYemeksepeti()
            .goToLoginPage()
            .loginToYemeksepeti("tumer.nura@gmail.com", "11122233444")
            .verifyErrorMessage("Hatalı giriş. Lütfen kullanıcı adı ve şifrenizi kontrol edip tekrar deneyiniz.");
        driver.manage().deleteAllCookies();

    }

    @Test(priority = 3, description = "Invalid Login Scenario with wrong username and empty password.")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Login test with wrong username and empty password.")
    @Story("Wrong username and empty password login test")
    public void invalidLoginTest_WrongUserNameEmptyPassword(Method method) {
        startTest(method.getName(), "Invalid Login Scenario with wrong username and empty password.");

        homePage
                .goToYemeksepeti()
                .goToLoginPage()
                .loginToYemeksepeti("tumer.nura@gmail.com", "")
                .verifyEmptyPassMessage("Lütfen şifrenizi giriniz.");
        driver.manage().deleteAllCookies();

    }

    @Test(priority = 4, description = "Invalid Login Scenario with correct username and empty password.")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Login test with correct username and empty password.")
    @Story("Correct username and empty password login test")
    public void invalidLoginTest_ValidUserNameEmptyPassword(Method method) {
        startTest(method.getName(), "Invalid Login Scenario with correct username and empty password.");

        homePage
                .goToYemeksepeti()
                .goToLoginPage()
                .loginToYemeksepeti("tumer.nuray@gmail.com", "")
                .verifyEmptyPassMessage("Lütfen şifrenizi giriniz.");
        driver.manage().deleteAllCookies();

    }

    @Test(priority = 5, description = "Invalid Login Scenario with correct username and wrong password.")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Login test with correct username and wrong password.")
    @Story("Correct username and wrong password login test")
    public void invalidLoginTest_CorrectUserNameWrongPassword(Method method) {
        startTest(method.getName(), "Invalid Login Scenario with correct username and wrong password.");

        homePage
                .goToYemeksepeti()
                .goToLoginPage()
                .loginToYemeksepeti("tumer.nuray@gmail.com", "asd")
                .verifyErrorMessage("Hatalı giriş. Lütfen kullanıcı adı ve şifrenizi kontrol edip tekrar deneyiniz.");
        driver.manage().deleteAllCookies();

    }

    @Test(priority = 6, description = "Invalid Login Scenario with empty username and wrong password.")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Login test with empty username and wrong password.")
    @Story("Empty username and wrong password login test")
    public void invalidLoginTest_EmptyUserNameInvalidPassword(Method method) {
        startTest(method.getName(), "Invalid Login Scenario with empty username and wrong password.");

        homePage
                .goToYemeksepeti()
                .goToLoginPage()
                .loginToYemeksepeti("", "asd")
                .verifyEmptyUserNameMessage("Lütfen kullanıcı adınızı/e-postanızı giriniz.");
        driver.manage().deleteAllCookies();

    }


    @Test(priority = 7, description = "Invalid Login Scenario with wrong username and correct password.")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Login test with wrong username and correct password.")
    @Story("Wrong username and correct password login test")
    public void invalidLoginTest_WrongUserNameCorrectPassword(Method method) {
        startTest(method.getName(), "Invalid Login Scenario with wrong username and correct password.");

        homePage
                .goToYemeksepeti()
                .goToLoginPage()
                .loginToYemeksepeti("tumer.nura@gmail.com", "12nT**12")
                .verifyErrorMessage("Hatalı giriş. Lütfen kullanıcı adı ve şifrenizi kontrol edip tekrar deneyiniz.");
        driver.manage().deleteAllCookies();

    }

    @Test(priority = 8, description = "Invalid Login Scenario with empty username and correct password.")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Login test with empty username and correct password.")
    @Story("Empty username and correct password login test")
    public void invalidLoginTest_EmptyUserNameCorrectPassword(Method method) {
        startTest(method.getName(), "Invalid Login Scenario with empty username and correct password.");

        homePage
                .goToYemeksepeti()
                .goToLoginPage()
                .loginToYemeksepeti("", "12nT**12")
                .verifyEmptyUserNameMessage("Lütfen kullanıcı adınızı/e-postanızı giriniz.");
        driver.manage().deleteAllCookies();

    }

    @Test(priority = 9, description = "Invalid Login Scenario with invalid username and correct password.")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Login test with invalid username and correct password.")
    @Story("Invalid username and correct password login test")
    public void invalidLoginTest_InvalidUserNameCorrectPassword(Method method) {
        startTest(method.getName(), "Invalid Login Scenario with invalid username and correct password.");

        homePage
                .goToYemeksepeti()
                .goToLoginPage()
                .loginToYemeksepeti("tumer.nuray", "12nT**12")
                .verifyErrorMessage("Hatalı giriş. Lütfen kullanıcı adı ve şifrenizi kontrol edip tekrar deneyiniz.");
        driver.manage().deleteAllCookies();

    }

    @Test(priority = 10, description = "Invalid Login Scenario with correct username and correct password.")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Login test with correct username and correct password.")
    @Story("Correct username and correct password login test")
    public void validLoginTest_CorrectUserNameCorrectPassword(Method method) {
        startTest(method.getName(), "Valid Login Scenario with correct username and correct password.");

        homePage
                .goToYemeksepeti()
                .goToLoginPage()
                .loginToYemeksepeti("tumer.nuray@gmail.com", "12nT**12");
        driver.manage().deleteAllCookies();

    }

    @Test(priority = 11, description = "FailScenario")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Login test FailScenario")
    @Story("Fail Scenario")
    public void validLoginTest_FailScenario(Method method) {
        startTest(method.getName(), "FailScenario");

        homePage
                .goToYemeksepeti()
                .goToLoginPage()
                .failScenario();
        driver.manage().deleteAllCookies();

    }

//    @Test(priority = 0, description = "Add a restaurant to my favorites list")
//    @Severity(SeverityLevel.CRITICAL)
//    @Description("Test Description: Add restaurant to my favorites list")
//    @Story("Add restaurant to my favorites list")
//    public void addRestaurantToMyFavorites(Method method) throws InterruptedException {
//        startTest(method.getName(), "Add restaurant to my favorites list");
//
//        homePage
//                .goToYemeksepeti()
//                .goToLoginPage()
//                .loginToYemeksepeti("tumer.nuray@gmail.com", "12nT**12")
//                .myFavoritePage();
//        driver.manage().deleteAllCookies();
//
//    }
}