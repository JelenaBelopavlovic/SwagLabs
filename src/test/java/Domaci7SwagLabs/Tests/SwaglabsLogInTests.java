package Domaci7SwagLabs.Tests;

import Domaci7SwagLabs.Base.SwaglabsBaseTest;
import Domaci7SwagLabs.Pages.SwaglabsLogInPage;
import Domaci7SwagLabs.Pages.SwaglabsProductsPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class SwaglabsLogInTests extends SwaglabsBaseTest {

    @BeforeMethod
    public void setUpPage() {

        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(homeURL);

        swaglabsLogInPage = new SwaglabsLogInPage();
        swaglabsProductsPage = new SwaglabsProductsPage();

    }

    @Test (priority = 10)
    public void userCanLogIn() {

        String validUsername = excelReader.getStringData("LogIn", 1, 0);
        String validPassword = excelReader.getStringData("LogIn", 1,1);

        swaglabsLogInPage.enterUsername(validUsername);
        swaglabsLogInPage.enterPassword(validPassword);
        swaglabsLogInPage.clickOnLogInButton();

        String expectedURL = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        Assert.assertEquals(swaglabsProductsPage.getTitleText(), "PRODUCTS");

        boolean logInButton = false;
        try {
            logInButton = swaglabsLogInPage.LogInButton.isDisplayed();

        } catch (Exception e) {


        }
        Assert.assertFalse(logInButton);

    }

    @Test (priority = 20)
    public void userCanNotLogInWithReplacedUsernameAndPassword() {

        String validUsername = excelReader.getStringData("LogIn", 1, 0);
        String validPassword = excelReader.getStringData("LogIn", 1,1);

        swaglabsLogInPage.enterUsername(validPassword);
        swaglabsLogInPage.enterPassword(validUsername);
        swaglabsLogInPage.clickOnLogInButton();

        String expectedURL = "https://www.saucedemo.com/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

        Assert.assertTrue(swaglabsLogInPage.LogInButton.isDisplayed());
        Assert.assertTrue(swaglabsLogInPage.ErrorMessage.isDisplayed());

    }

    @Test (priority = 30)
    public void userCanNotLogInWithInvalidUsername() {

        for (int i=1; i<=excelReader.getLastRow("LogIn"); i++) {

            String invalidUsername = excelReader.getStringData("LogIn", i, 2);
            String validPassword = excelReader.getStringData("LogIn", 1, 1);

            swaglabsLogInPage.enterUsername(invalidUsername);
            swaglabsLogInPage.enterPassword(validPassword);
            swaglabsLogInPage.clickOnLogInButton();

            String expectedURL = "https://www.saucedemo.com/";
            Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

            Assert.assertTrue(swaglabsLogInPage.LogInButton.isDisplayed());
            Assert.assertTrue(swaglabsLogInPage.ErrorMessage.isDisplayed());

        }

    }


    @Test (priority = 40)
    public void userCanNotLogInWithInvalidPassword() {

        for (int i=1; i<=excelReader.getLastRow("LogIn"); i++) {

            String validUsername = excelReader.getStringData("LogIn", 1, 0);
            String invalidPassword = excelReader.getStringData("LogIn", i, 3);

            swaglabsLogInPage.enterUsername(validUsername);
            swaglabsLogInPage.enterPassword(invalidPassword);
            swaglabsLogInPage.clickOnLogInButton();

            String expectedURL = "https://www.saucedemo.com/";
            Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

            Assert.assertTrue(swaglabsLogInPage.LogInButton.isDisplayed());
            Assert.assertTrue(swaglabsLogInPage.ErrorMessage.isDisplayed());

        }

    }

    @Test (priority = 50)
    public void userCanNotLogInWithInvalidUsernameAndPassword() {

        for (int i=1; i<=excelReader.getLastRow("LogIn"); i++) {

            String invalidUsername = excelReader.getStringData("LogIn", i, 2);
            String invalidPassword = excelReader.getStringData("LogIn", i, 3);

            swaglabsLogInPage.enterUsername(invalidUsername);
            swaglabsLogInPage.enterPassword(invalidPassword);
            swaglabsLogInPage.clickOnLogInButton();

            String expectedURL = "https://www.saucedemo.com/";
            Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

            Assert.assertTrue(swaglabsLogInPage.LogInButton.isDisplayed());
            Assert.assertTrue(swaglabsLogInPage.ErrorMessage.isDisplayed());

        }

    }

    @Test (priority = 60)
    public void userCanNotLogInWithEmptyUsernameField() {

        for (int i=1; i<2; i++) {

            String emptyUsername = "";
            String validPassword = excelReader.getStringData("LogIn", 1, 1);

            swaglabsLogInPage.enterUsername(emptyUsername);
            swaglabsLogInPage.enterPassword(validPassword);
            swaglabsLogInPage.clickOnLogInButton();

            String expectedURL = "https://www.saucedemo.com/";
            Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

            Assert.assertTrue(swaglabsLogInPage.LogInButton.isDisplayed());
            Assert.assertTrue(swaglabsLogInPage.ErrorMessage.isDisplayed());

        }

    }

    @Test (priority = 70)
    public void userCanNotLogInWithEmptyPasswordField() {

        for (int i=1; i<2; i++) {

            String validUsername = excelReader.getStringData("LogIn", 1, 0);
            String emptyPassword = "";

            swaglabsLogInPage.enterUsername(validUsername);
            swaglabsLogInPage.enterPassword(emptyPassword);
            swaglabsLogInPage.clickOnLogInButton();

            String expectedURL = "https://www.saucedemo.com/";
            Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

            Assert.assertTrue(swaglabsLogInPage.LogInButton.isDisplayed());
            Assert.assertTrue(swaglabsLogInPage.ErrorMessage.isDisplayed());

        }

    }

    @Test (priority = 80)
    public void userCanNotLogInWithBothEmptyFields() {

            String emptyUsername = "";
            String emptyPassword = "";

            swaglabsLogInPage.enterUsername(emptyUsername);
            swaglabsLogInPage.enterPassword(emptyPassword);
            swaglabsLogInPage.clickOnLogInButton();

            String expectedURL = "https://www.saucedemo.com/";
            Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

            Assert.assertTrue(swaglabsLogInPage.LogInButton.isDisplayed());
            Assert.assertTrue(swaglabsLogInPage.ErrorMessage.isDisplayed());

    }

    @AfterMethod
    public void shutDown() {

       driver.manage().deleteAllCookies();
       driver.quit();
    }

}
