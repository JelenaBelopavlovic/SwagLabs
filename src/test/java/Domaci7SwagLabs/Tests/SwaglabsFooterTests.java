package Domaci7SwagLabs.Tests;

import Domaci7SwagLabs.Base.SwaglabsBaseTest;
import Domaci7SwagLabs.Pages.SwaglabsFooterPage;
import Domaci7SwagLabs.Pages.SwaglabsLogInPage;
import Domaci7SwagLabs.Pages.SwaglabsProductsPage;
import Domaci7SwagLabs.Pages.SwaglabsSocialNetworksPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SwaglabsFooterTests extends SwaglabsBaseTest {

    @BeforeMethod
    public void setUpPage() {

        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(homeURL);

        swaglabsLogInPage = new SwaglabsLogInPage();
        swaglabsProductsPage = new SwaglabsProductsPage();
        swaglabsFooterPage = new SwaglabsFooterPage();
        swaglabsSocialNetworksPage = new SwaglabsSocialNetworksPage();

    }

    @Test (priority = 10)
    public void twitterButtonOpensTwitterPage()  {

        logIn();
        swaglabsFooterPage.clickOnButtonForTwitter();

        List <String> tabs = new ArrayList <String> (driver.getWindowHandles());
        String actualURL = driver.switchTo().window(tabs.get(1)).getCurrentUrl();

        String expectedURL = "https://twitter.com/saucelabs";
        Assert.assertEquals(actualURL, expectedURL);

        waitForClickability(swaglabsSocialNetworksPage.TwitterButton);
        Assert.assertTrue(swaglabsSocialNetworksPage.TwitterButton.isDisplayed());

    }

    @Test (priority = 20)
    public void facebookButtonOpensFacebookPage() {

        logIn();
        swaglabsFooterPage.clickOnButtonForFacebook();

        List <String> tabs = new ArrayList <String> (driver.getWindowHandles());
        String actualURL = driver.switchTo().window(tabs.get(1)).getCurrentUrl();

        String expectedURL = "https://www.facebook.com/saucelabs";
        Assert.assertEquals(actualURL, expectedURL);

        waitForClickability(swaglabsSocialNetworksPage.LogInFacebookButton);
        Assert.assertTrue(swaglabsSocialNetworksPage.LogInFacebookButton.isDisplayed());

    }

    @Test (priority = 30)
    public void linkedInButtonOpensLinkedInPage() throws InterruptedException {

        logIn();
        swaglabsFooterPage.clickOnButtonForLinkedIn();

        List <String> tabs = new ArrayList <String> (driver.getWindowHandles());
        String actualURL = driver.switchTo().window(tabs.get(1)).getCurrentUrl();

        Thread.sleep(5000);

        String expectedURL = "https://www.linkedin.com/company/sauce-labs/?original_referer=";
        Assert.assertEquals(actualURL, expectedURL);

        waitForClickability(swaglabsSocialNetworksPage.SignInLinkedInButton);
        Assert.assertTrue(swaglabsSocialNetworksPage.SignInLinkedInButton.isDisplayed());

    }

    @AfterMethod
    public void shutDown() {

        driver.manage().deleteAllCookies();
        driver.quit();
    }

}
