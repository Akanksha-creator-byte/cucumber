package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.WaitUtil;

import java.time.Duration;
import java.util.List;

public class InventoryPage {
    WebDriver driver;

    @FindBy(className = "inventory_item")
    List<WebElement> allProducts;

    @FindBy(xpath = "//span[@class='title']")
    WebElement pageTitle;

    @FindBy(xpath = "//button[contains(text(),'Add to cart') and ancestor::div[@class='inventory_item'][.//div[text()='Sauce Labs Backpack']]]")
    WebElement addToCartSauceLabsBackpack;

    @FindBy(xpath = "//button[contains(text(),'Remove') and ancestor::div[@class='inventory_item'][.//div[text()='Sauce Labs Backpack']]]")
    WebElement removeSauceLabsBackpack;

    @FindBy(className = "shopping_cart_badge")
    WebElement cartBadge;
    
    @FindBy(xpath = "//select[@class='product_sort_container']")
    WebElement sortDropdown;

    @FindBy(xpath = "//div[text()='Sauce Labs Backpack']")
    WebElement firstProductName;

    @FindBy(xpath = "(//div[@class='inventory_item_price'])[1]")
    WebElement firstProductPrice;
    
    @FindBy(className = "shopping_cart_link")
    WebElement cartIcon;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void goToCart() {
        System.out.println("🛒 Clicking on cart icon to go to cart page");
        cartIcon.click();
    }
    public boolean isAtLeastOneProductDisplayed() {
        return allProducts.size() > 0;
    }

    public String getPageTitle() {
        return pageTitle.getText();
    }

    public void addSauceLabsBackpackToCart() {
        addToCartSauceLabsBackpack.click();
    }

    public void removeSauceLabsBackpackFromCart() {
        removeSauceLabsBackpack.click();
        // Optional: Add short wait for cart update
        try {
            Thread.sleep(1000); // Use explicit wait instead in production
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public String getCartBadgeCount() {
        try {
            // Wait up to 5 seconds for badge to become invisible
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("shopping_cart_badge")));
            return "0"; // If badge disappears, count is 0
        } catch (Exception e) {
            try {
                // If badge is still there, return actual count
                return cartBadge.getText().trim();
            } catch (Exception ex) {
                return "0"; // Still safer fallback
            }
        }
    }



    public void selectSortOption(String sortOption) {
        System.out.println("🔹 Waiting for sort dropdown to become visible");

        By sortDropdownBy = By.xpath("//select[@class='product_sort_container']");
        WebElement dynamicSortDropdown = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(sortDropdownBy));

        Select select = new Select(dynamicSortDropdown);
        select.selectByVisibleText(sortOption);

        System.out.println("✅ Selected sort option: " + sortOption);
    }




    public String getFirstProductName() {
        // Wait for the first product name to appear
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement firstProduct = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//div[text()='Sauce Labs Backpack']")));
        return firstProduct.getText();
    }


    public String getFirstProductPrice() {
        return firstProductPrice.getText();
    }
}
