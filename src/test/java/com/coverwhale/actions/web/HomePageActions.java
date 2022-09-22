package com.coverwhale.actions.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.coverwhale.utils.selenium.WebUtils;

/**
 * It contains all actions that can be performed on Home page of the application.
 */
public class HomePageActions {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(HomePageActions.class);
	private WebDriver driver;
	private WebUtils webUtils;

	// write your locators here
	
	@FindBy(id = "username")
	WebElement usernameField;
	
	
	public HomePageActions(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		webUtils = new WebUtils(driver);
	}
	
	
}
