package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.WaitUtil;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtil;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtil;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtil;

public class LoginPage {
 
	 private WebDriver driver;
	


	    public LoginPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this); // 🔴 THIS IS MANDATORY
	        
	    }
	
	@FindBy(id="user-name")
	private WebElement usernameField;
	
	@FindBy(id="password")
	private WebElement passwordField;
	
	@FindBy(id ="login-button")
	private WebElement loginButton;
	
	@FindBy(xpath = "//span[text()='Products']")
	private WebElement inventoryTitle;
	
	@FindBy(xpath = "//h3[contains(@data-test,'error')]")
	private WebElement errorMessage;


    public void login(String username, String password) {
        usernameField.clear();
        usernameField.sendKeys(username);
        passwordField.clear();
        passwordField.sendKeys(password);
        loginButton.click();
    }

	
	
	public void enterUsername(String username) {
		 WaitUtil.waitForElementVisible(driver, usernameField, 10);
		usernameField.clear();
		usernameField.sendKeys(username);
		
	}
	public void enterPassword(String password) {
		WaitUtil.waitForElementVisible(driver, passwordField, 10);
		passwordField.clear();
		passwordField.sendKeys(password);
		
	}
	public void clickLogin() {
		WaitUtil.waitForElementClickable(driver, loginButton, 10);
		loginButton.click();
	}
	
	public boolean isInventoryPageDisplayed() {
		WaitUtil.waitForElementVisible(driver, inventoryTitle, 10);
		return inventoryTitle.isDisplayed();
		
	}
	public boolean isLoginErrorDisplayed() {
	    try {
	        WaitUtil.waitForElementVisible(driver, errorMessage, 5);
	        return errorMessage.isDisplayed();
	    } catch (Exception e) {
	        return false;
	    }
	}
	
	
}
