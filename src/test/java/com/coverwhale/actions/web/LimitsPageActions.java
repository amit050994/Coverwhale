package com.coverwhale.actions.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Reporter;

import com.coverwhale.utils.selenium.WebUtils;

/**
 * It contains all actions that can be performed on Home page of the
 * application.
 */
public class LimitsPageActions {

	private static final Logger LOGGER = LoggerFactory.getLogger(LimitsPageActions.class);
	private WebDriver driver;
	private WebUtils webUtils;

	// write your locators here

	@FindBy(xpath = "//select[contains(@name, 'num_power_units')]")
	public WebElement noOfTrucks;

	@FindBy(xpath = "//input[contains(@id, 'value_power_units')]/following-sibling::input")
	public WebElement valueOfTrucks;

	@FindBy(xpath = "//select[contains(@name, 'num_trailers')]")
	public WebElement noOfTrailers;

	@FindBy(xpath = "//input[contains(@id, 'value_trailers')]/following-sibling::input")
	public WebElement valueOfTrailers;

	@FindBy(xpath = "//select[contains(@name, 'limit_towing_storage')]")
	public WebElement towingLabourAndStorageLimit;

	@FindBy(xpath = "//select[contains(@name, 'trailer_interchange_limit')]")
	public WebElement trailerInterchnageLimit;
	
	@FindBy(css = "#list-limits button.nextButton")
	public WebElement nextButton;

	public LimitsPageActions(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		webUtils = new WebUtils(driver);
	}

	public void selectNoOfTrucks(String numberOfTrucks) {
		Reporter.log("Populating the numberOfTrucks field");
		LOGGER.info("Selecting " + numberOfTrucks + " in the Value field");
		webUtils.selectDropDownByVisibleText(noOfTrucks, numberOfTrucks);
	}

	public void populateValueofTrucks(String TrucksValue) {
		Reporter.log("Populating the TrucksValue field");
		LOGGER.info("Writing " + TrucksValue + " in the Value field");
		webUtils.enterText(valueOfTrucks, TrucksValue);
	}

	public void selectNoOfTrailers(String numberOfTrailers) {
		Reporter.log("Populating the numberOfTrailers field");
		LOGGER.info("Selecting " + numberOfTrailers + " in the Value field");
		webUtils.selectDropDownByVisibleText(noOfTrailers, numberOfTrailers);
	}

	public void populateValuerofTrailers(String TrailerValue) {
		Reporter.log("Populating the TrailerValue field");
		LOGGER.info("Writing " + TrailerValue + " in the Value field");
		webUtils.enterText(valueOfTrailers, TrailerValue);
	}

	public void selectTowingLabourAndStorageLimit(String StorageLimit) {
		Reporter.log("Populating the StorageLimit field");
		LOGGER.info("Selecting " + StorageLimit + " in the Value field");
		webUtils.selectDropDownByVisibleText(towingLabourAndStorageLimit, StorageLimit);
	}

	public void selectTrailerInterchnageLimit(String InterchnageLimit) {
		Reporter.log("Populating the StorageLimit field");
		LOGGER.info("Selecting " + InterchnageLimit + " in the Value field");
		webUtils.selectDropDownByVisibleText(trailerInterchnageLimit, InterchnageLimit);
	}
	
	public void clickNextButton() {
		Reporter.log("Clicking Next button");
		nextButton.click();
	}

}
