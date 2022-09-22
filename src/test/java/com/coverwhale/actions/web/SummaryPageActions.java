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
public class SummaryPageActions {

	private static final Logger LOGGER = LoggerFactory.getLogger(SummaryPageActions.class);
	private WebDriver driver;
	private WebUtils webUtils;

	// locators

	@FindBy(id = "summary_account")
	WebElement summaryAccountField;

	@FindBy(id = "summary_driver_experience")
	WebElement summaryDriverExperienceField;

	@FindBy(xpath = "//div[@id='list-summary']//button[string()='Next']")
	WebElement nextButton;


	public void enterSummaryAccount(String summaryAccount) {
		Reporter.log("Entering the Summary Account");
		webUtils.enterText(summaryAccountField, summaryAccount);
	}

	public void enterSummaryDriverExperience(String summaryDriverExperience) {
		Reporter.log("Entering the Summary driver experience");
		webUtils.enterText(summaryDriverExperienceField, summaryDriverExperience);
	}

	public void proceedToNextStep() {
		Reporter.log("Clicking the Next button and proceeding to review");
		webUtils.click(nextButton);
	}

	public SummaryPageActions(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		webUtils = new WebUtils(driver);
	}
























	
	
}
