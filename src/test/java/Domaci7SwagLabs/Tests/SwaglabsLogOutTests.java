package Domaci7SwagLabs.Tests;

import Domaci7SwagLabs.Base.SwaglabsBaseTest;
import Domaci7SwagLabs.Pages.SwaglabsFooterPage;
import Domaci7SwagLabs.Pages.SwaglabsLogInPage;
import Domaci7SwagLabs.Pages.SwaglabsProductsPage;
import Domaci7SwagLabs.Pages.SwaglabsSocialNetworksPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class SwaglabsLogOutTests extends SwaglabsBaseTest {

    @BeforeMethod
    public void setUpPage() {

        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(homeURL);

        swaglabsLogInPage = new SwaglabsLogInPage();
        swaglabsProductsPage = new SwaglabsProductsPage();

    }

    @Test
    public void userCanLogOut() {

        logIn();

        swaglabsProductsPage.clickOnMenuButton();
        waitForClickability(swaglabsProductsPage.LogOutItem);
        swaglabsProductsPage.clickOnLogOutItem();

        String expectedURL = "https://www.saucedemo.com/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        Assert.assertTrue(swaglabsLogInPage.LogInButton.isDisplayed());

    }


    @AfterMethod
    public void shutDown() {

        driver.manage().deleteAllCookies();
        driver.quit();
    }


}
