package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage {
	
	WebDriver driver;
	
	public InventoryPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="add-to-cart-sauce-labs-backpack")
	private WebElement addToCartBackpack;
	
	@FindBy(css = ".shopping_cart_link")
	private WebElement cartIcon;
	
	 @FindBy(className = "inventory_item")
	    List<WebElement> products;
	
	 public void addBackpackToCart() {
		 addToCartBackpack.click();
	 }
	    public void verifyInventoryPage() {
	        if(products.size() == 0)
	            throw new AssertionError("No products displayed, inventory page not loaded");
	    }

	    public void addProductToCart(String productName) {
	        for(WebElement product : products) {
	            if(product.getText().contains(productName)) {
	                product.findElement(By.tagName("button")).click();
	                break;
	            }
	        }
	    }


public void goToCart() {
    cartIcon.click();
}

}
