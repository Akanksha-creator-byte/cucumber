package stepdefinitions;

import base.BaseClass;
import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.InventoryPage;
import pages.LoginPage;

public class InventoryStepDef extends BaseClass {

    LoginPage loginPage;
    InventoryPage inventoryPage;

    @Given("User is logged into SauceDemo with valid credentials")
    public void user_is_logged_into_saucedemo_with_valid_credentials() {
        System.out.println("🔹 Logging in with valid credentials");
        goToLoginPage();
        loginPage = new LoginPage(driver);
        loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        Assert.assertTrue("❌ Inventory page is not displayed", loginPage.isInventoryPageDisplayed());
        inventoryPage = new InventoryPage(driver);
        System.out.println("✅ Logged in successfully");
    }

    @When("User lands on the Inventory page")
    public void user_lands_on_inventory_page() {
        System.out.println("🔹 Verifying Inventory Page URL");
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
    }

    @Then("Inventory page title should be {string}")
    public void inventory_page_title_should_be(String expectedTitle) {
        System.out.println("🔹 Checking Inventory page title");
        Assert.assertEquals(expectedTitle, inventoryPage.getPageTitle());

    }

    @Then("At least one product should be displayed")
    public void at_least_one_product_should_be_displayed() {
        System.out.println("🔹 Checking if products are displayed");
        Assert.assertTrue(inventoryPage.isAtLeastOneProductDisplayed());
    }

    @When("User sorts the products by {string}")
    public void user_sorts_the_products_by(String sortOption) {
        System.out.println("🔹 Sorting products by: " + sortOption);
        System.out.println("📍 Current URL: " + driver.getCurrentUrl());
        System.out.println("📍 Page Title: " + driver.getTitle());
        inventoryPage.selectSortOption(sortOption);
    }


    @Then("First product name should be {string}")
    public void first_product_name_should_be(String expectedName) {
        System.out.println("🔹 Checking first product name");
        Assert.assertEquals(expectedName, inventoryPage.getFirstProductName());
    }

    @Then("First product price should be {string}")
    public void first_product_price_should_be(String expectedPrice) {
        System.out.println("🔹 Checking first product price");
        Assert.assertEquals(expectedPrice, inventoryPage.getFirstProductPrice());
    }

    @When("User adds {string} to the cart")
    public void user_adds_to_the_cart(String productName) {
        if (productName.equals("Sauce Labs Backpack")) {
            inventoryPage.addSauceLabsBackpackToCart();
            System.out.println("✅ Added " + productName + " to cart");
        } else {
            System.out.println("⚠️ Add to cart not implemented for: " + productName);
        }
    }

    @When("User removes {string} from the cart")
    public void user_removes_from_the_cart(String productName) {
        if (productName.equals("Sauce Labs Backpack")) {
            inventoryPage.removeSauceLabsBackpackFromCart();
            System.out.println("✅ Removed " + productName + " from cart");
        } else {
            System.out.println("⚠️ Remove from cart not implemented for: " + productName);
        }
    }

    @Then("Cart badge count should be {string}")
    public void cart_badge_count_should_be(String expectedCount) {
        String actualCount = inventoryPage.getCartBadgeCount();
        System.out.println("🔍 Expected cart count: " + expectedCount + ", Actual: " + actualCount);
        Assert.assertEquals("❌ Cart count mismatch!", expectedCount, actualCount);
    }
}
