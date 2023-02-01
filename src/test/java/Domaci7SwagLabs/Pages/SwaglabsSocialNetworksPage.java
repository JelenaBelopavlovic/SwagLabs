package Domaci7SwagLabs.Pages;

import Domaci7SwagLabs.Base.SwaglabsBaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwaglabsSocialNetworksPage extends SwaglabsBaseTest {

    public SwaglabsSocialNetworksPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".css-1dbjc4n.r-dnmrzs.r-1vvnge1")
    public WebElement TwitterButton;

    @FindBy (css = ".x6s0dn4.x78zum5.x1s65kcs.x1pi30zi.x1e558r4")
    public WebElement LogInFacebookButton;

    @FindBy (css = "div[class = 'sign-in-modal']")
    public WebElement SignInLinkedInButton;



}
