package com.coverwhale.actions.web;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Reporter;

import com.coverwhale.utils.selenium.WebUtils;

/**
 * It contains all actions that can be performed on Login page of the
 * application. *
 */
public class LoginActions {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginActions.class);

	private WebDriver driver;
	private WebUtils webUtils;


	@FindBy(id = "email")
	WebElement emailField;
	
	@FindBy(id = "email")
	List<WebElement> emailFieldList;

	@FindBy(id = "password")
	WebElement passwordField;

	@FindBy(xpath = "//button[contains(.,'Login')]")
	WebElement loginButton;
	
	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	List<WebElement> logoutButton;
	
	@FindBy(xpath = "(//a[@id='navbarDropdown'])[1]")
	WebElement navDropdown;


	public LoginActions(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		webUtils = new WebUtils(driver);
	}
	
	
	/**
	 * It will perform login operation with default credentials present in
	 * config.properties file.
	 */
	public void login(String username, String password) {
		Reporter.log("Looging in with default credentials..........");

		if (emailFieldList.size() > 0) {
			webUtils.enterText(emailField, username);
			webUtils.enterText(passwordField, password);
			webUtils.click(loginButton);
		}
		
	}

	/**
	 * It will perform logout from application
	 */
	public void logOut() {
		Reporter.log("Looging OUt.");
		webUtils.waitForElementVisibility(navDropdown, 5);
		webUtils.click(navDropdown);
		if (logoutButton.size() > 0) {
			webUtils.click(logoutButton.get(0));
		}
		webUtils.waitForElementVisibility(emailField, 10);
	}

}
