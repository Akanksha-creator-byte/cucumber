package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.WaitUtil;

public class CartPage {
	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "checkout")
	private WebElement checkoutButton;

	public void proceedToCheckout() {
	    WaitUtil.waitForElementClickable(driver, checkoutButton, 10);
	    checkoutButton.click();
	}
}
