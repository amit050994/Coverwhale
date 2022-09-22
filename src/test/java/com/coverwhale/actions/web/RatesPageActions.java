package com.coverwhale.actions.web;

import com.coverwhale.utils.selenium.WebUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Reporter;

/**
 * It contains all actions that can be performed on Home page of the application.
 *///textarea[@name='trailers_list']
public class RatesPageActions {

	private static final Logger LOGGER = LoggerFactory.getLogger(RatesPageActions.class);
	private WebDriver driver;
	private WebUtils webUtils;

	// locators

	@FindBy(xpath = "//div[./input[@id='rate_expiring_al']]/input[contains(@id,'mony')]")
	WebElement expiringAlRateField;

	@FindBy(xpath = "//input[@id='rate_expiring_apd']")
	WebElement expiringApdRateField;

	@FindBy(xpath = "//div[./input[@id='rate_expiring_mtc']]/input[contains(@id,'mony')]")
	WebElement expiringCargoRateField;

	@FindBy(xpath = "//div[./input[@id='rate_target_al']]/input[contains(@id,'mony')]")
	WebElement targetAlRateField;

	@FindBy(xpath = "//input[@id='rate_target_apd']")
	WebElement targetApdRateField;

	@FindBy(xpath = "//div[./input[@id='rate_targer_mtc']]/input[contains(@id,'mony')]")
	WebElement targetCargoRateField;

	@FindBy(xpath = "//div[contains(@action,'Rates')]//button[string()='Next']")
	WebElement nextButton;


	// METHODS


	public void populateExpiringAlRateField(String expiringAlRate) {
		Reporter.log("Populating the Expiring AL Rate field");
		LOGGER.info("Writing " + expiringAlRate + " in the Expiring AL Rate field");
		webUtils.enterText(expiringAlRateField, expiringAlRate);
	}

	public void populateExpiringApdRateField(String expiringApdRate) {
		Reporter.log("Populating the Expiring APD Rate field");
		LOGGER.info("Writing " + expiringApdRate + " in the Expiring APD Rate field");
		webUtils.enterText(expiringApdRateField, expiringApdRate);
	}

	public void populateExpiringCargoRateField(String expiringCargoRate) {
		Reporter.log("Populating the Expiring Cargo Rate field");
		LOGGER.info("Writing " + expiringCargoRate + " in the Expiring Cargo Rate field");
		webUtils.enterText(expiringCargoRateField, expiringCargoRate);
	}

	public void populateTargetAlRateField(String targetAlRate) {
		Reporter.log("Populating the Target AL Rate field");
		LOGGER.info("Writing " + targetAlRate + " in the Target AL Rate field");
		webUtils.enterText(targetAlRateField, targetAlRate);
	}

	public void populateTargetApdRateField(String targetApdRate) {
		Reporter.log("Populating the Target APD Rate field");
		LOGGER.info("Writing " + targetApdRate + " in the Target APD Rate field");
		webUtils.enterText(targetApdRateField, targetApdRate);
	}

	public void populateTargetCargoRateField(String targetCargoRate) {
		Reporter.log("Populating the Target Cargo Rate field");
		LOGGER.info("Writing " + targetCargoRate + " in the Target Cargo Rate field");
		webUtils.enterText(targetCargoRateField, targetCargoRate);
	}

	public void proceedToNextStep() {
		Reporter.log("Clicking the Next button and proceeding to Summary");
		webUtils.click(nextButton);
	}

	public RatesPageActions(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		webUtils = new WebUtils(driver);
	}
























	
	
}
