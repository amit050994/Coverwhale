package com.coverwhale.actions.web;

import com.coverwhale.utils.selenium.WebUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Reporter;

/**
 * It contains all actions that can be performed on Home page of the application.
 */
public class InstantDeclineQuoteModalActions {

	private static final Logger LOGGER = LoggerFactory.getLogger(InstantDeclineQuoteModalActions.class);
	private WebDriver driver;
	private WebUtils webUtils;

	// write your locators here

	@FindBy(xpath = "//div[@id='instantDeclineModal']//h5[string()=' Declined']")
	WebElement declineQuoteModalTitle;

	@FindBy(xpath = "//div[@id='instantDeclineModal']//img[contains(@src,'icon_alert-yellow.svg')]")
	WebElement yellowWarningTriangle;

	@FindBy(xpath = "//div[@id='instantDeclineModal']//button[string()='Close']")
	WebElement closeModalButton;

	public void closeModal() {
		Reporter.log("Closing Quote Declined modal.");

		LOGGER.info("Closing quote declined modal");
		webUtils.click(closeModalButton);
	}

	public InstantDeclineQuoteModalActions(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		webUtils = new WebUtils(driver);
	}
	
	
}
