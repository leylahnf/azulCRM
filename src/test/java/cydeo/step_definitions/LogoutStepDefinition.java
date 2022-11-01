package cydeo.step_definitions;

import cydeo.pages.AzulDashboardPage;
import cydeo.pages.AzulLoginPage;
import cydeo.utilities.ConfigurationReader;
import cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class LogoutStepDefinition {


    AzulLoginPage azulLoginPage = new AzulLoginPage();
    AzulDashboardPage dashboardPage = new AzulDashboardPage();



    @Given("User is on the login page and enters valid credentials {string} and {string}")
    public void userIsOnTheLoginPageAndEntersValidCredentialsAnd(String email, String password) {

        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        azulLoginPage.login(email, password);
    }
    @When("user clicks on user account menu")
    public void user_clicks_on_user_account_menu() {

        dashboardPage.userAccount.click();
    }
    @When("user clicks on logout link")
    public void user_clicks_on_logout_link() {
        dashboardPage.logOutText.click();
    }
    @Then("user should go back to login page, verify title {string}")
    public void user_should_go_back_to_login_page_verify_title(String expectedTitle) {
       String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    @And("user try to go back home page by clicking the back button")
    public void userTryToGoBackHomePageByClickingTheBackButton() {
        Driver.getDriver().navigate().back();
    }

    @Then("user still is on the login page")
    public void userStillIsOnTheLoginPage() {
        Assert.assertTrue(azulLoginPage.emailBox.isDisplayed());
    }

    @When("user closes the browser")
    public void user_closes_the_browser() {

      // Driver.closeDriver();
       Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.CONTROL+"w");
    }

//    @And("user is logged out")
//    public void userIsLoggedOut() {
//        Assert.assertFalse(dashboardPage.userAccount.isDisplayed());
//    }


    @And("user open new browser and try to navigate to home page")
    public void userOpenNewBrowserAndTryToNavigateToHomePage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }



}
