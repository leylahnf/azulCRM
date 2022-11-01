package cydeo.step_definitions;

import cydeo.pages.AzulLoginPage;
import cydeo.utilities.ConfigurationReader;
import cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class LoginStepDefinition {

    AzulLoginPage azulLoginPage = new AzulLoginPage();

    @Given("user goes to the login page")
    public void user_goes_to_the_login_page()  {

        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }
    @When("user enters valid email {string}")
    public void user_enters_valid_email(String string) {
     azulLoginPage.emailBox.sendKeys(string);
    }
    @When("user enters valid password {string}")
    public void user_enters_valid_password(String string) {
azulLoginPage.passwordBox.sendKeys(string);
    }
    @When("user clicks the Log In button")
    public void user_clicks_the_log_in_button() {
        azulLoginPage.logInButton.click();
    }
    @Then("user should be able to login successfully and verify title contains {string}")
    public void user_should_be_able_to_login_successfully_and_verify_title_contains(String expectedInTitle) {
      String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedInTitle));

    }


    @When("user logins invalid credentials {string} and {string}")
    public void userLoginsInvalidCredentialsAnd(String email, String passw) {
        azulLoginPage.login(email,passw);
    }

    @Then("user should see warning message {string}")
    public void userShouldSeeWarningMessage(String errorText) {
        String actualErrorMessage = azulLoginPage.errorMessage.getText();
        Assert.assertEquals(errorText, actualErrorMessage);
    }


    @When("user does not enter any password")
    public void user_does_not_enter_any_password() {
      azulLoginPage.passwordBox.sendKeys("");
    }
    @Then("user should be able to see {string} message")
    public void user_should_be_able_to_see_message(String message) {
        String warningMessage = azulLoginPage.errorMessage.getText();
        Assert.assertEquals(message, warningMessage);
    }
    @When("user does not enter any email")
    public void user_does_not_enter_any_email() {
       azulLoginPage.emailBox.sendKeys("");
    }


    @When("user clicks the {string} link")
    public void userClicksTheLink(String arg0) {
        azulLoginPage.forgetLink.click();
    }

    @Then("user should be able to land on {string} page after clicking the link")
    public void userShouldBeAbleToLandOnPageAfterClickingTheLink(String expectedText) {
       // String actualText = azulLoginPage.getPasswordText.getText();
      //  Assert.assertEquals(expectedText,actualText);
        Assert.assertTrue(azulLoginPage.getPasswordText.isDisplayed());
    }

    @When("user see the {string} link exists on the login page")
    public void user_see_the_link_exists_on_the_login_page(String string) {
       Assert.assertTrue(azulLoginPage.rememberMeLink.isDisplayed());
    }
    @Then("user verify link should be clickable")
    public void user_verify_link_should_be_clickable() {
        azulLoginPage.rememberMeLink.click();
        Assert.assertTrue(azulLoginPage.rememberMeLink.isSelected());
    }

    @Then("password should be in bullet signs by default")
    public void passwordShouldBeInBulletSignsByDefault() {
        String actualPasswordIn = azulLoginPage.passwordBox.getAttribute("type");
        String expectedPasswordIn = "password";
        Assert.assertEquals(expectedPasswordIn, actualPasswordIn);
    }



    @And("user enters valid password {string} and press Enter key of the keyboard for log in")
    public void userEntersValidPasswordAndPressEnterKeyOfTheKeyboardForLogIn(String passw) {
        azulLoginPage.passwordBox.sendKeys(passw+Keys.ENTER);
    }


    @Then("users should be able to see their own {string} in the profile menu")
    public void usersShouldBeAbleToSeeTheirOwnInTheProfileMenu(String expectedAccount) {
        String actualAccount = azulLoginPage.account.getText();
        Assert.assertEquals(expectedAccount,actualAccount);
    }
}
