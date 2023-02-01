package Domaci7SwagLabs.Base;

import Domaci7SwagLabs.Pages.SwaglabsFooterPage;
import Domaci7SwagLabs.Pages.SwaglabsLogInPage;
import Domaci7SwagLabs.Pages.SwaglabsProductsPage;
import Domaci7SwagLabs.Pages.SwaglabsSocialNetworksPage;
import Domaci7SwagLabs.Tests.SwaglabsLogOutTests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;

public class SwaglabsBaseTest {


    public static WebDriver driver;
    public WebDriverWait wdwait;
    public ExcelReader excelReader;
    public String homeURL;

    public SwaglabsLogInPage swaglabsLogInPage;
    public SwaglabsProductsPage swaglabsProductsPage;
    public SwaglabsFooterPage swaglabsFooterPage;
    public SwaglabsSocialNetworksPage swaglabsSocialNetworksPage;


    @BeforeClass
    public void setUp() throws IOException {

        WebDriverManager.chromedriver().setup();

        excelReader = new ExcelReader("C:\\Users\\Administrator\\Desktop\\SwagLabs.xlsx");

        homeURL = excelReader.getStringData("URL", 1, 0);

    }

    public void logIn() {

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

    public void waitForClickability(WebElement element) {
        wdwait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForVisibility(WebElement element) {
        wdwait.until(ExpectedConditions.visibilityOf(element));
    }


}
