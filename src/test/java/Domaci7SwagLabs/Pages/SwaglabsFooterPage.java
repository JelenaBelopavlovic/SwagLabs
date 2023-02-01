package Domaci7SwagLabs.Pages;

import Domaci7SwagLabs.Base.SwaglabsBaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwaglabsFooterPage extends SwaglabsBaseTest {

   public SwaglabsFooterPage() {

      PageFactory.initElements(driver, this);
   }


    @FindBy (className = "social_twitter")
    public WebElement ButtonForTwitter;

    @FindBy (className = "social_facebook")
    public WebElement ButtonForFacebook;

    @FindBy (className = "social_linkedin")
    public WebElement ButtonForLinkedIn;

    //------------------------------------

   public void clickOnButtonForTwitter() {

      ButtonForTwitter.click();
   }

   public void clickOnButtonForFacebook() {

      ButtonForFacebook.click();
   }

   public void clickOnButtonForLinkedIn() {

      ButtonForLinkedIn.click();
   }


}
