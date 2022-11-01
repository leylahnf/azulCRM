package cydeo.pages;

import cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AzulLoginPage {

    public AzulLoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//input[@name='USER_LOGIN']")
    public WebElement emailBox;

    @FindBy(xpath = "//input[@name='USER_PASSWORD']")
    public WebElement passwordBox;

    @FindBy(xpath = "//input[@TYPE='submit']")
    public WebElement logInButton;

    @FindBy(xpath = "//div[@class='errortext']")
    public WebElement errorMessage;

    public void login(String username,String passw){
       emailBox.sendKeys(username);
       passwordBox.sendKeys(passw);
       logInButton.click();
    }

    @FindBy(xpath = "//a[.='Forgot your password?']")
    public WebElement forgetLink;

    @FindBy(xpath = "//div[.='Get Password']")
    public WebElement getPasswordText;

    @FindBy(xpath = "//input[@id='USER_REMEMBER']")
    public WebElement rememberMeLink;


    @FindBy(xpath = "//span[@id='user-name']")
    public WebElement account;


}
