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

public class SwaglabsProductsTests extends SwaglabsBaseTest {

    @BeforeMethod
    public void setUpPage() {

        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(homeURL);

        swaglabsLogInPage = new SwaglabsLogInPage();
        swaglabsProductsPage = new SwaglabsProductsPage();

    }


    @Test(priority = 10)
    public void addingProductsToCart() {

        logIn();

        swaglabsProductsPage.checkingCart();
        Assert.assertEquals(swaglabsProductsPage.checkingCart(), "");

        swaglabsProductsPage.addingBackpack();
        Assert.assertEquals(swaglabsProductsPage.checkingCart(), "1");
        Assert.assertTrue(swaglabsProductsPage.RemoveBackpackButton.isDisplayed());

        swaglabsProductsPage.addingLight();
        Assert.assertEquals(swaglabsProductsPage.checkingCart(), "2");
        Assert.assertTrue(swaglabsProductsPage.RemoveLightButton.isDisplayed());

        swaglabsProductsPage.addingBoltTshirt();
        Assert.assertEquals(swaglabsProductsPage.checkingCart(), "3");
        Assert.assertTrue(swaglabsProductsPage.RemoveBoltTshirtButton.isDisplayed());

        swaglabsProductsPage.addingJacket();
        Assert.assertEquals(swaglabsProductsPage.checkingCart(), "4");
        Assert.assertTrue(swaglabsProductsPage.RemoveJacketButton.isDisplayed());

        swaglabsProductsPage.addingOnesie();
        Assert.assertEquals(swaglabsProductsPage.checkingCart(), "5");
        Assert.assertTrue(swaglabsProductsPage.RemoveOnesieButton.isDisplayed());

        swaglabsProductsPage.addingRedTshirt();
        Assert.assertEquals(swaglabsProductsPage.checkingCart(), "6");
        Assert.assertTrue(swaglabsProductsPage.RemoveRedTshirtButton.isDisplayed());

    }

    @Test(priority = 20)
    public void removingProductsFromCart() {

        logIn();

        swaglabsProductsPage.checkingCart();
        Assert.assertEquals(swaglabsProductsPage.checkingCart(), "");

        swaglabsProductsPage.addingBackpack();
        Assert.assertEquals(swaglabsProductsPage.checkingCart(), "1");
        swaglabsProductsPage.removingBackpack();
        Assert.assertEquals(swaglabsProductsPage.checkingCart(), "");
        Assert.assertTrue(swaglabsProductsPage.AddBackpackButton.isDisplayed());

        swaglabsProductsPage.addingLight();
        Assert.assertEquals(swaglabsProductsPage.checkingCart(), "1");
        swaglabsProductsPage.removingLight();
        Assert.assertEquals(swaglabsProductsPage.checkingCart(), "");
        Assert.assertTrue(swaglabsProductsPage.AddLightButton.isDisplayed());

        swaglabsProductsPage.addingBoltTshirt();
        Assert.assertEquals(swaglabsProductsPage.checkingCart(), "1");
        swaglabsProductsPage.removingBoltTshirt();
        Assert.assertEquals(swaglabsProductsPage.checkingCart(), "");
        Assert.assertTrue(swaglabsProductsPage.AddBoltTshirtButton.isDisplayed());

        swaglabsProductsPage.addingJacket();
        Assert.assertEquals(swaglabsProductsPage.checkingCart(), "1");
        swaglabsProductsPage.removingJacket();
        Assert.assertEquals(swaglabsProductsPage.checkingCart(), "");
        Assert.assertTrue(swaglabsProductsPage.AddJacketButton.isDisplayed());

        swaglabsProductsPage.addingOnesie();
        Assert.assertEquals(swaglabsProductsPage.checkingCart(), "1");
        swaglabsProductsPage.removingOnesie();
        Assert.assertEquals(swaglabsProductsPage.checkingCart(), "");
        Assert.assertTrue(swaglabsProductsPage.AddOnesieButton.isDisplayed());

        swaglabsProductsPage.addingRedTshirt();
        Assert.assertEquals(swaglabsProductsPage.checkingCart(), "1");
        swaglabsProductsPage.removingRedTshirt();
        Assert.assertEquals(swaglabsProductsPage.checkingCart(), "");
        Assert.assertTrue(swaglabsProductsPage.AddRedTshirtButton.isDisplayed());

    }


    @AfterMethod
    public void shutDown() {

       driver.manage().deleteAllCookies();
       driver.quit();
    }

}




