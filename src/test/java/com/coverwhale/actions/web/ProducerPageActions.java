package com.coverwhale.actions.web;

import com.coverwhale.utils.selenium.WebUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Reporter;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * It contains all actions that can be performed on Producer page of the application.
 */

public class ProducerPageActions {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProducerPageActions.class);
	private WebDriver driver;
	private WebUtils webUtils;


	private Map<String, String> producerData = new LinkedHashMap<>();

	public void setProducerData(Map<String, String> producerDataForTestCase){
		producerData = producerDataForTestCase;
	}

	@FindBy(css = "#list-producer button.nextButton")
	WebElement nextButton;

	@FindBy(css = "input[id='retail_agent_first_name']")
	WebElement firstName;

	@FindBy(css = "[id='retail_agent_last_name']")
	WebElement lastName;

	@FindBy(css = "[id='retail_agent_agency_name']")
	WebElement agencyName;

	@FindBy(css = "input[id='retail_agent_street']")
	WebElement address;

	@FindBy(css = "input[id='retail_agent_city']")
	WebElement city;

	@FindBy(css = "input[id='retail_agent_county']")
	WebElement county;

	@FindBy(css = "select[id='retail_agent_state']")
	WebElement state;

	@FindBy(css = "input[id='retail_agent_zip']")
	WebElement zip;

	@FindBy(xpath = "(//input[contains(@id,'phone_input')])[2]")
	WebElement phoneNumber;

	@FindBy(css = "input[id='retail_agent_email']")
	WebElement email;


	public ProducerPageActions(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		webUtils = new WebUtils(driver);
	}
	public void enterFirstName() {
		String retailFirstName = producerData.get("First Name");
		Reporter.log("Enter Retail Agent First Name:" + retailFirstName);
		webUtils.enterText(firstName, retailFirstName);
	}

	public void enterLastName() {
		String retailLastName = producerData.get("Last Name");
		Reporter.log("Enter Retail Agent Last Name: "+ retailLastName);
		webUtils.enterText(lastName, retailLastName);
	}

	public void enterAgencyName() {
		String retailAgencyName = producerData.get("Agency Name");
		Reporter.log("Enter Retail Agent Agency Name:"+ retailAgencyName);
		webUtils.enterText(agencyName, retailAgencyName);
	}

	public void enterAddress() {
		String retailAddress = producerData.get("Address");
		Reporter.log("Enter Retail Agent Address:"+ retailAddress);
		webUtils.enterText(address, retailAddress);
	}

	public void enterCity() {
		String retailCity = producerData.get("City");
		Reporter.log("Enter Retail Agent City:"+ retailCity);
		webUtils.enterText(city, retailCity);
	}

	public void enterCounty() {
		String retailCounty = producerData.get("County");
		Reporter.log("Enter Retail Agent County:" + retailCounty);
		webUtils.enterText(county, retailCounty);
	}

	public void selectState() {
		String retailState = producerData.get("State");
		Reporter.log("Select Retail Agent State:"+ retailState);
		webUtils.selectDropDownByVisibleText(state, retailState);
	}

	public void enterZip() {
		String retailZip = producerData.get("ZIP");
		Reporter.log("Enter Retail Agent Zip:"+ retailZip);
		webUtils.enterText(zip, retailZip);
	}

	public void enterPhoneNumber() {
		String retailPhoneNumber = producerData.get("Phone");
		Reporter.log("Enter Phone Number:"+ retailPhoneNumber);
		webUtils.enterText(phoneNumber, retailPhoneNumber);
	}

	public void enterEmailAddress() {
		String retailEmail = producerData.get("E-Mail Address");
		Reporter.log("Enter Email Address:"+ retailEmail);
		webUtils.enterText(email, retailEmail);
	}

	public void clickNextButton() {
		Reporter.log("Clicking on Next button");
		webUtils.retryingClick(nextButton);
	}
	
}
