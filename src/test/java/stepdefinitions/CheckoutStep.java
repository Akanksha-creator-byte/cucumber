package stepdefinitions;

import com.aventstack.extentreports.Status;
import base.BaseClass;
import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.*;

import utils.ExtentTestManager;

public class CheckoutStep extends BaseClass {

    LoginPage loginPage;
    InventoryPage inventoryPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    ConfirmationPage confirmationPage;
    
   
    @When("User logs in with username {string} and password {string}")
    public void user_logs_in_with_username_and_password(String username, String password) {
        goToLoginPage();  // Navigate explicitly
        loginPage = new LoginPage(driver);
        ExtentTestManager.getTest().log(Status.INFO, "Logging in with username: " + username);
        loginPage.login(username, password);
        inventoryPage = new InventoryPage(driver);
    }


    @When("User adds a product to the cart")
    public void user_adds_a_product_to_the_cart() {
        ExtentTestManager.getTest().log(Status.INFO, "Adding product to cart");
        inventoryPage.addSauceLabsBackpackToCart();
    }

    @When("User navigates to cart and proceeds to checkout")
    public void user_navigates_to_cart_and_proceeds_to_checkout() {
        ExtentTestManager.getTest().log(Status.INFO, "Navigating to cart and proceeding to checkout");
        inventoryPage.goToCart();
        System.out.println(driver.getCurrentUrl());
        cartPage = new CartPage(driver);
        cartPage.proceedToCheckout();
    }

    @When("User provides checkout details {string} {string} {string}")
    public void user_provides_checkout_details(String fname, String lname, String zip) {
        ExtentTestManager.getTest().log(Status.INFO, "Entering checkout details");
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.fillCheckoutDetails(fname, lname, zip);
    }

    @Then("Payment information, shipping info and total should be correct")
    public void payment_information_shipping_info_and_total_should_be_correct() {
        ExtentTestManager.getTest().log(Status.INFO, "Validating payment and shipping information");
        Assert.assertTrue("Summary info is not displayed.", checkoutPage.validateSummaryDisplayed());
    }

    @Then("User completes the order")
    public void user_completes_the_order() {
        ExtentTestManager.getTest().log(Status.INFO, "Completing the order");
        checkoutPage.completeOrder();
    }

    @Then("User should see confirmation message {string}")
    public void user_should_see_confirmation_message(String expectedMessage) {
        ExtentTestManager.getTest().log(Status.INFO, "Verifying confirmation message");
        confirmationPage = new ConfirmationPage(driver);
        Assert.assertEquals(expectedMessage, confirmationPage.getConfirmationText());
    }
}
