package com.coverwhale.actions.web;

import java.util.LinkedHashMap;
import java.util.Map;

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
public class CreateQuoteApplicationPage {

	private static final Logger LOGGER = LoggerFactory.getLogger(CreateQuoteApplicationPage.class);
	private WebDriver driver;
	private WebUtils webUtils;
	public Map<String, String> quoteData = new LinkedHashMap<>();

	// write your locators here

	@FindBy(xpath = "//input[contains(@name, 'dot_number')]")
	public WebElement dotNumber;

	@FindBy(xpath = "//input[contains(@name, 'years_business')]")
	public WebElement yearsOperatinginYourName;

	@FindBy(xpath = "//input[contains(@name, 'legal_name')]")
	public WebElement insuredNameField;

	@FindBy(xpath = "//input[contains(@name, 'dba_name')]")
	public WebElement doingBusinessAs;

	@FindBy(xpath = "//input[contains(@name, 'mailing_street')]")
	public WebElement address;

	@FindBy(xpath = "//input[contains(@name, 'mailing_city')]")
	public WebElement city;

	@FindBy(xpath = "//input[contains(@name, 'mailing_county')]")
	public WebElement country;

	@FindBy(xpath = "//select[contains(@name, 'mailing_state')]")
	public WebElement state;

	@FindBy(xpath = "//input[contains(@name, 'mailing_zip')]")
	public WebElement zip;

	@FindBy(xpath = "//input[contains(@id, 'sameGarageAddressCheck')]")
	public WebElement GarageaddressCheckbox;

	@FindBy(xpath = "//input[contains(@id, 'phy_street')]")
	public WebElement Garageaddress;

	@FindBy(xpath = "//input[contains(@id, 'phy_city')]")
	public WebElement garageCity;

	@FindBy(xpath = "//input[contains(@name, 'phy_county')]")
	public WebElement garageCountry;

	@FindBy(xpath = "//select[contains(@id, 'phy_state')]")
	public WebElement garageState;

	@FindBy(xpath = "//input[contains(@name, 'phy_zip')]")
	public WebElement garageZip;

	@FindBy(xpath = "//select[contains(@id, 'num_power_units')]")
	public WebElement numberOfTrucksDropdown;

	@FindBy(xpath = "//input[contains(@id, 'mony_input')]")
	public WebElement valueOfTrucksField;

	@FindBy(xpath = "//select[contains(@id, 'num_trailers')]")
	public WebElement numberofTrailersDropdown;

	@FindBy(xpath = "(//input[contains(@id, 'mony_input')])[2]")
	public WebElement valueOfTrailersField;

	@FindBy(xpath = "//input[contains(@id, 'agree_terms')]")
	public WebElement agreeTerms;

	@FindBy(xpath = "//button[contains(string(),'Next - Let') and ('Finish the App')]")
	public WebElement nextButton;

	@FindBy(css = "#licensedstatesModal div[role='alert'] h5")
	public WebElement licensedStatesModalText;

	// Finish App to Quote modal
	@FindBy(xpath = "//div[@id='submissionReminder']//button[string()='Close']")
	public WebElement closeFinishAppModalButton;

	@FindBy(xpath = "//div[@id='submissionReminder']//button[string()='Finish App to Quote']")
	public WebElement finishAppToQuoteButton;



	public CreateQuoteApplicationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		webUtils = new WebUtils(driver);
	}


	public void enterInsuredName() {
		String insuredName = quoteData.get("InsuredName");
		Reporter.log("Populating the InsuredName field");
		webUtils.enterText(insuredNameField, insuredName);
	}


	public void clickcheckbox() {
		Reporter.log("Marking the GarageaddressCheckbox");
		LOGGER.info("Marking the checkbox");
		webUtils.click(GarageaddressCheckbox);
	}

	public void populateGaragAddress(String Address) {
		Reporter.log("Populating the Address field");
		LOGGER.info("Writing " + Address + " in the Value field");
		webUtils.enterText(Garageaddress, Address);
	}

	public void populateGaragCity(String City) {
		Reporter.log("Populating the City field");
		LOGGER.info("Writing " + City + " in the Value field");
		webUtils.enterText(garageCity, City);
	}

	public void populateGaragCountry(String Country) {
		Reporter.log("Populating the Country field");
		LOGGER.info("Writing " + Country + " in the Value field");
		webUtils.enterText(garageCountry, Country);
	}

	public void populateGaragState(String State) {
		Reporter.log("Populating the State field");
		LOGGER.info("Writing " + State + " in the Value field");
		webUtils.enterText(garageState, State);
	}

	public void populateGaragZip(String Zip) {
		Reporter.log("Populating the Zip field");
		LOGGER.info("Writing " + Zip + " in the Value field");
		webUtils.enterText(garageZip, Zip);
	}

	public void selectNoOfTrucks() {
		String numberOfTrucks = quoteData.get("Number of Trucks");
		LOGGER.info("Selecting " + numberOfTrucks + " in the Number of Trucks dropdown");
		webUtils.selectDropDownByVisibleText(numberOfTrucksDropdown, numberOfTrucks);
	}

	public void enterValueofTrucks() {
		Reporter.log("Populating the Trucks Value field");
		String valueOfTrucks  = quoteData.get("Total Value of Trucks");
		webUtils.enterText(valueOfTrucksField, valueOfTrucks);
	}

	public void selectNoOfTrailers() {
		Reporter.log("Populating the number of trailers field");
		String numberOfTrailers = quoteData.get("Number of Trailers");
		webUtils.selectDropDownByVisibleText(numberofTrailersDropdown, numberOfTrailers);
	}

	public void enterValueOfTrailers() {
		Reporter.log("Populating the Trailer Value field");
		String valueOfTrailers = quoteData.get("Total Value of Trailers");
		webUtils.enterText(valueOfTrailersField, valueOfTrailers);
	}
	
	public void setQuoteData(Map<String, String> quoteDataForTestCase) {
		quoteData = quoteDataForTestCase;
	}
	
	public void enterDotNumber() {
		String dottNumber = quoteData.get("DOT Number");
		Reporter.log("Entering dot number: " + dottNumber);
		webUtils.enterText(dotNumber, dottNumber);
	}

	public void enterDoingBusinessAs() {
		String dba = quoteData.get("DBA");
		Reporter.log("Entering DBA: " + dba);
		webUtils.enterText(doingBusinessAs, dba);
	}

	public void enterYearsOperatinginYourName() {
		String yearsOfOperating = quoteData.get("YearsOfOperating");
		Reporter.log("Entering years of operating in your name: " + yearsOfOperating);
		webUtils.enterText(yearsOperatinginYourName, yearsOfOperating);
	}
	
	public void enterMailingAddress() {
		String mailingAddress = quoteData.get("Mailing Address");
		Reporter.log("Entering mailing address: " + mailingAddress);
		webUtils.enterText(address, mailingAddress);
	}

	public void enterCity() {
		String mailingCity = quoteData.get("City");
		Reporter.log("Entering mailing city: " + mailingCity);
		webUtils.enterText(city, mailingCity);
	}

	public void enterCountry() {
		String mailingCountry = quoteData.get("Country");
		Reporter.log("Entering mailing country: " + mailingCountry);
		webUtils.enterText(country, mailingCountry);
	}
	
	public void enterGarageCounty() {
		String garageCounty = quoteData.get("Garage County");
		Reporter.log("Entering garage county: " + garageCounty);
		webUtils.enterText(garageCountry, garageCounty);
	}

	public void selectState() {
		String mailingState = quoteData.get("State");
		Reporter.log("Selecting mailing state: " + mailingState);
		webUtils.selectDropDownByVisibleText(state, mailingState);
	}

	public void enterZip() {
		String mailingZip = quoteData.get("Zip");
		Reporter.log("Entering mailing zip: " + mailingZip);
		webUtils.enterText(zip, mailingZip);
	}

	public void agreeToTermsAndUse() {
		Reporter.log("Agreeing to quote terms and conditions");
		agreeTerms.click();
	}

	public String getLicensedModalText() {
		Reporter.log("Getting the text from license modal");
		webUtils.waitForElementVisibility(licensedStatesModalText, 1);

		return webUtils.getTextUsingAttribute(licensedStatesModalText, "innerText").trim();
	}

	public void clickFinishAppToQuoteButton() {
		Reporter.log("Clicking the Finish App to Quote button");
		webUtils.click(finishAppToQuoteButton);
	}

	public void clickNextButton() {
		Reporter.log("Clicking the Next - Let's Finish the App button");
		webUtils.click(nextButton);
	}

	public void happypath() {
		enterDotNumber();
		enterYearsOperatinginYourName();
		enterInsuredName();
		enterMailingAddress();
		enterCity();
		selectState();
		enterZip();
		clickcheckbox();
		selectNoOfTrucks();
		enterValueofTrucks();
		selectNoOfTrailers();
		enterValueOfTrailers();
		agreeToTermsAndUse();
		clickNextButton();
		clickFinishAppToQuoteButton();

	}

}
