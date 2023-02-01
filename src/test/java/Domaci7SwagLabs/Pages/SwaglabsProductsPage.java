package Domaci7SwagLabs.Pages;

import Domaci7SwagLabs.Base.SwaglabsBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SwaglabsProductsPage extends SwaglabsBaseTest {


    public SwaglabsProductsPage() {

        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "title")
    public WebElement Title;

    @FindBy (id = "react-burger-menu-btn")
    public WebElement MenuButton;

    @FindBy (id = "logout_sidebar_link")
    public WebElement LogOutItem;

    @FindBy (id = "shopping_cart_container")
    public WebElement Cart;

    @FindBy (id = "add-to-cart-sauce-labs-backpack")
    public WebElement AddBackpackButton;

    @FindBy (id = "remove-sauce-labs-backpack")
    public WebElement RemoveBackpackButton;

    @FindBy (id = "add-to-cart-sauce-labs-bike-light")
    public WebElement AddLightButton;

    @FindBy (id = "remove-sauce-labs-bike-light")
    public WebElement RemoveLightButton;

    @FindBy (id = "add-to-cart-sauce-labs-bolt-t-shirt")
    public WebElement AddBoltTshirtButton;

    @FindBy (id = "remove-sauce-labs-bolt-t-shirt")
    public WebElement RemoveBoltTshirtButton;

    @FindBy (id = "add-to-cart-sauce-labs-fleece-jacket")
    public WebElement AddJacketButton;

    @FindBy (id = "remove-sauce-labs-fleece-jacket")
    public WebElement RemoveJacketButton;

    @FindBy (id = "add-to-cart-sauce-labs-onesie")
    public WebElement AddOnesieButton;

    @FindBy (id = "remove-sauce-labs-onesie")
    public WebElement RemoveOnesieButton;

    @FindBy (id = "add-to-cart-test.allthethings()-t-shirt-(red)")
    public WebElement AddRedTshirtButton;

    @FindBy (id = "remove-test.allthethings()-t-shirt-(red)")
    public WebElement RemoveRedTshirtButton;


    //------------------------------------


    public String getTitleText() {

        return Title.getText();
    }

    public void clickOnMenuButton() {

        MenuButton.click();
    }

    public void clickOnLogOutItem() {

        LogOutItem.click();
    }

    public void addingBackpack() {

         AddBackpackButton.click();
    }

    public void removingBackpack() {

        RemoveBackpackButton.click();
    }

    public void addingLight() {
        AddLightButton.click();
    }

    public void removingLight() {
        RemoveLightButton.click();
    }

    public void addingBoltTshirt() {
        AddBoltTshirtButton.click();
    }

    public void removingBoltTshirt() {
        RemoveBoltTshirtButton.click();
    }

    public void addingJacket() {
        AddJacketButton.click();
    }

    public void removingJacket() {
        RemoveJacketButton.click();
    }

    public void addingOnesie() {
        AddOnesieButton.click();
    }

    public void removingOnesie() {
        RemoveOnesieButton.click();
    }


    public void addingRedTshirt() {
        AddRedTshirtButton.click();
    }

    public void removingRedTshirt() {
        RemoveRedTshirtButton.click();
    }

    public String checkingCart() {

        return Cart.getText();
    }


}
