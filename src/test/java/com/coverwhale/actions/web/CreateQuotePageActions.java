package com.coverwhale.actions.web;

import com.coverwhale.utils.selenium.WebUtils;
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
 */
public class CreateQuotePageActions {

	private static final Logger LOGGER = LoggerFactory.getLogger(CreateQuotePageActions.class);
	private WebDriver driver;
	private WebUtils webUtils;

	// write your locators here

	@FindBy(id = "create_transportation_dot_number")
	WebElement dotNumberField;

	@FindBy(id = "years_business")
	WebElement yearsOperatingField;

	@FindBy(id = "legal_name")
	WebElement insuredNameField;

	@FindBy(id = "dba_name")
	WebElement doingBusinessAsField;

	@FindBy(id = "mailing_street")
	WebElement mailingAddressField;

	@FindBy(id = "mailing_city")
	WebElement mailingCityField;

	@FindBy(id = "mailing_county")
	WebElement mailingCountyField;

	@FindBy(id = "mailing_state")
	WebElement mailingStateSelect;
	Select mailingStateDropdown = new Select(mailingStateSelect);

	@FindBy(id = "mailing_zip")
	WebElement mailingZipField;

	@FindBy(id = "sameGarageAddressCheck")
	WebElement garageMailingAddressSameCheckbox;

	@FindBy(id = "phy_street")
	WebElement garageAddressField;

	@FindBy(id = "phy_city")
	WebElement garageCityField;

	@FindBy(id = "phy_county")
	WebElement garageCountyField;

	@FindBy(id = "phy_state")
	WebElement garageStateSelect;
	Select garageStateDropdown = new Select(garageStateSelect);

	@FindBy(id = "phy_zip")
	WebElement garageZipField;

	@FindBy(id = "num_power_units")
	WebElement numberOfTrucksSelect;
	Select numberOfTrucksDropdown = new Select(numberOfTrucksSelect);

	@FindBy(id = "num_trailers")
	WebElement numberOfTrailersSelect;
	Select numberOfTrailersDropdown = new Select(numberOfTrailersSelect);

	@FindBy(id = "value_power_units")
	WebElement valueOfTrucksField;

	@FindBy(id = "value_trailers")
	WebElement valueOfTrailersField;

	@FindBy(id = "agree_terms")
	WebElement termsOfUseCheckbox;

	@FindBy(xpath = "//button[contains(string(),'Finish the App')]")
	WebElement nextButton;

	public CreateQuotePageActions(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		webUtils = new WebUtils(driver);
	}

	public void populateDotNumberField(String dot) {
		Reporter.log("Populating the DOT number field");
		LOGGER.info("Writing " + dot + " in the DOT number field");
		webUtils.enterText(dotNumberField, dot);
	}

	public void populateYearsOperatingField(String yearsOperating) {
		Reporter.log("Populating the Years operating in your name field");
		LOGGER.info("Writing " + yearsOperating + " in the Years operating in your name field");
		webUtils.enterText(yearsOperatingField, yearsOperating);
	}

	public void populateInsuredNameField(String insuredName) {
		Reporter.log("Populating the Insured Name field");
		LOGGER.info("Writing " + insuredName + " in the Insured Name field");
		webUtils.enterText(insuredNameField, insuredName);
	}

	public void populateDoingBusinessAsField(String dba) {
		Reporter.log("Populating the DBA field");
		LOGGER.info("Writing " + dba + " in the Doing Business As (DBA) field");
		webUtils.enterText(doingBusinessAsField, dba);
	}

	public void populateMailingAddressField(String mailingAddress) {
		Reporter.log("Populating the Mailing Address field");
		LOGGER.info("Writing " + mailingAddress + " in the Mailing Address field");
		webUtils.enterText(mailingAddressField, mailingAddress);
	}

	public void populateMailingCityField(String mailingCity) {
		Reporter.log("Populating the Mailing City field");
		LOGGER.info("Writing " + mailingCity + " in the Mailing City field");
		webUtils.enterText(mailingCityField, mailingCity);
	}

	public void populateMailingCountyField(String mailingCounty) {
		Reporter.log("Populating the Mailing County field");
		LOGGER.info("Writing " + mailingCounty + " in the Mailing County field");
		webUtils.enterText(mailingCountyField, mailingCounty);
	}

	public void selectMailingState(String mailingState) {
		Reporter.log("Selecting the mailing state");
		LOGGER.info("Selecting " + mailingState + " from the Mailing State dropdown");
		mailingStateDropdown.selectByValue(mailingState);
	}

	public void populateMailingZipField(String mailingZip) {
		Reporter.log("Populating the Mailing Zip field");
		LOGGER.info("Writing " + mailingZip + " in the Mailing Zip field");
		webUtils.enterText(mailingZipField, mailingZip);
	}

	public void populateGarageAddressField(String garageAddress) {
		Reporter.log("Populating the Garage Address field");
		LOGGER.info("Writing " + garageAddress + " in the Garage Address field");
		webUtils.enterText(garageAddressField, garageAddress);
	}

	public void populateGarageCityField(String garageCity) {
		Reporter.log("Populating the Garage City field");
		LOGGER.info("Writing " + garageCity + " in the Garage City field");
		webUtils.enterText(garageCityField, garageCity);
	}

	public void populateGarageCountyField(String garageCounty) {
		Reporter.log("Populating the  Garage County field");
		LOGGER.info("Writing " + garageCounty + " in the  Garage County field");
		webUtils.enterText(garageCountyField, garageCounty);
	}

	public void selectGarageState(String garageState) {
		Reporter.log("Selecting the garage state");
		LOGGER.info("Selecting " + garageState + " from the Garage State dropdown");
		garageStateDropdown.selectByValue(garageState);
	}

	public void populateGarageZipField(String garageZip) {
		Reporter.log("Populating the  Garage Zip field");
		LOGGER.info("Writing " + garageZip + " in the Garage Zip field");
		webUtils.enterText(garageZipField, garageZip);
	}

	public void selectNumberOfTrucks(String numberOfTrucks) {
		Reporter.log("Select the number of trucks");
		LOGGER.info("Selecting " + numberOfTrucks + " in the Number of Trucks dropdown");
		numberOfTrucksDropdown.selectByValue(numberOfTrucks);
	}

	public void selectNumberOfTrailers(String numberOfTrailers) {
		Reporter.log("Select the number of trailers");
		LOGGER.info("Selecting " + numberOfTrailers + " in the Number of Trailers dropdown");
		numberOfTrailersDropdown.selectByValue(numberOfTrailers);
	}

	public void populateValueOfTrucksField(String valueOfTrucks) {
		Reporter.log("Populating the Value of Trucks field");
		LOGGER.info("Writing " + valueOfTrucks + " in the Value of Trucks field");
		webUtils.enterText(valueOfTrucksField, valueOfTrucks);
	}

	public void populateValueOfTrailersField(String valueOfTrailers) {
		Reporter.log("Populating the Value of Trailers field");
		LOGGER.info("Writing " + valueOfTrailers + " in the Value of Trailers field");
		webUtils.enterText(valueOfTrailersField, valueOfTrailers);
	}

	public void clickTermsOfUseCheckbox() {
		Reporter.log("Agreeing to Terms of Use");
		LOGGER.info("Clicking the Terms of Use & Privacy Policy checkbox");
		webUtils.click(termsOfUseCheckbox);
	}

	public void clickNextButton() {
		Reporter.log("Moving on to the next step");
		LOGGER.info("Clicking the Next - Let's Finish the App button");
		webUtils.click(nextButton);
	}
	
	
}
