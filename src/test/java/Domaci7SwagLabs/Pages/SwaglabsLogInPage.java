package Domaci7SwagLabs.Pages;

import Domaci7SwagLabs.Base.SwaglabsBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SwaglabsLogInPage extends SwaglabsBaseTest {

    public SwaglabsLogInPage() {

        PageFactory.initElements(driver, this);
    }


    @FindBy (id = "user-name")
    public WebElement UsernameField;

    @FindBy (id = "password")
    public WebElement PasswordField;

    @FindBy (css = "input[class='submit-button btn_action']")
    public WebElement LogInButton;

    @FindBy (css = ".error-message-container.error")
    public WebElement ErrorMessage;


    // ----------------------

    public void enterUsername(String username) {

        UsernameField.clear();
        UsernameField.sendKeys(username);
    }

    public void enterPassword(String password) {

        PasswordField.clear();
        PasswordField.sendKeys(password);
    }

    public void clickOnLogInButton() {

        LogInButton.click();
    }

}
