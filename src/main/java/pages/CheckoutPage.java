package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "first-name")
    private WebElement firstName;

    @FindBy(id = "last-name")
    private WebElement lastName;

    @FindBy(id = "postal-code")
    private WebElement postalCode;

    @FindBy(id = "continue")
    private WebElement continueButton;

    @FindBy(className = "summary_info")
    private WebElement summaryInfo;

    @FindBy(id = "finish")
    private WebElement finishButton;

    @FindBy(className="complete-header")
    WebElement orderConfirmation;

    public void fillCheckoutDetails(String fname, String lname, String zip) {
        firstName.sendKeys(fname);
        lastName.sendKeys(lname);
        postalCode.sendKeys(zip);
        continueButton.click();
    }

    public boolean validateSummaryDisplayed() {
        return summaryInfo.isDisplayed();
    }
    
    public void clickContinue() {
        continueButton.click();
    }

    public void completeOrder() {
        finishButton.click();
    }
    public void verifyOrderConfirmation() {
        if(!orderConfirmation.isDisplayed())
            throw new AssertionError("Order confirmation not displayed");
    }
}
