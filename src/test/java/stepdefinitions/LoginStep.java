package stepdefinitions;

import base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import utils.ExtentTestManager;
import com.aventstack.extentreports.Status;

import org.junit.Assert;

public class LoginStep extends BaseClass {

    LoginPage loginPage;

    @Given("User is on SauceDemo login page")
    public void user_is_on_sauce_demo_login_page() {
        ExtentTestManager.getTest().log(Status.INFO, "Navigating to SauceDemo login page");
        goToLoginPage(); 
        loginPage = new LoginPage(driver);
    }

    @When("User enters username {string} and password {string}")
    public void user_enters_username_and_password(String username, String password) {
        ExtentTestManager.getTest().log(Status.INFO, "Entering username: " + username);
        ExtentTestManager.getTest().log(Status.INFO, "Entering password: " + password);
		
		  loginPage.enterUsername(username); loginPage.enterPassword(password);
		 
       
    }

    @When("User clicks on Login button")
    public void user_clicks_on_login_button() {
        ExtentTestManager.getTest().log(Status.INFO, "Clicking login button");
        loginPage.clickLogin();
    }

    @Then("User should be {string}")
    public void user_should_be(String expectedResult) {
        boolean isInventoryVisible = false;
        boolean isErrorDisplayed = false;

        try {
            isInventoryVisible = loginPage.isInventoryPageDisplayed();
        } catch (Exception e) {
            isInventoryVisible = false;
        }

        try {
            isErrorDisplayed = loginPage.isLoginErrorDisplayed();
        } catch (Exception e) {
            isErrorDisplayed = false;
        }

        if (expectedResult.equalsIgnoreCase("success")) {
            ExtentTestManager.getTest().log(Status.PASS, "Inventory page is displayed");
            Assert.assertTrue("Expected inventory page but was not displayed.", isInventoryVisible);
        } else if (expectedResult.equalsIgnoreCase("failure")) {
            ExtentTestManager.getTest().log(Status.PASS, "Login failure confirmed, error displayed");
            Assert.assertTrue("Expected login failure but no error shown.", isErrorDisplayed);
        }
    }
}
