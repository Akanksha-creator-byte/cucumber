package stepdefinitions;

import java.io.IOException;

import base.BaseClass;
import io.cucumber.java.en.*;
import pages.*;

public class SauceDemoStepDef extends BaseClass {

    LoginPage loginPage;
    InventoryPage inventoryPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;

    @Given("User is on SauceDemo login page")
    public void user_is_on_login_page() throws IOException {
    	launchBrowser(); // From BaseClass
        loginPage = new LoginPage(driver);
    }

    @When("User enters username {string} and password {string}")
    public void user_enters_credentials(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("Clicks on login button")
    public void clicks_on_login_button() {
        loginPage.clickLogin();
    }

    @Then("User should be navigated to inventory page")
    public void verify_inventory_page() {
        inventoryPage = new InventoryPage(driver);
        inventoryPage.verifyInventoryPage();
    }

    @When("User logs in with username {string} and password {string}")
    public void user_logs_in(String username, String password) {
        user_enters_credentials(username, password);
        clicks_on_login_button();
    }

    @When("Adds product {string} to cart")
    public void adds_product_to_cart(String productName) {
        inventoryPage = new InventoryPage(driver);
        inventoryPage.addProductToCart(productName);
    }

    @When("Clicks on cart icon")
    public void clicks_on_cart_icon() {
        inventoryPage.goToCart();
    }

    @When("Clicks on checkout button")
    public void clicks_on_checkout_button() {
        cartPage = new CartPage(driver);
        cartPage.proceedToCheckout();
    }

    @When("Enters checkout details with first name {string}, last name {string}, and postal code {string}")
    public void enters_checkout_details(String fname, String lname, String postal) {
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.fillCheckoutDetails(fname, lname, postal);
    }

    @When("Clicks on continue button")
    public void clicks_on_continue_button() {
        checkoutPage.clickContinue();
    }

    @When("Clicks on finish button")
    public void clicks_on_finish_button() {
        checkoutPage.completeOrder();
    }

    @Then("Order confirmation page is displayed")
    public void order_confirmation_page_is_displayed() {
        checkoutPage.verifyOrderConfirmation();
    }

    @Then("Cart should display {int} products")
    public void cart_should_display_products(Integer count) {
        cartPage = new CartPage(driver);
        cartPage.verifyCartCount(count);
    }

    @Then("Error message should be displayed")
    public void error_message_should_be_displayed() {
        loginPage.verifyErrorMessage();
    }
}
