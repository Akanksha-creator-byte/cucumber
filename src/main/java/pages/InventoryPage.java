package pages;

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
	
	
	
	 public void addBackpackToCart() {
		 addToCartBackpack.click();
	 }
	

public void goToCart() {
    cartIcon.click();
}

}
