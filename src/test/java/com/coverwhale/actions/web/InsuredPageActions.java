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
public class InsuredPageActions {

	private static final Logger LOGGER = LoggerFactory.getLogger(InsuredPageActions.class);
	private WebDriver driver;
	private WebUtils webUtils;

	public Map<String, String> insuredData = new LinkedHashMap<>();
	
	public void setInsuredData(Map<String, String> quoteDataForTestCase) {
		insuredData = quoteDataForTestCase;
	}

	// write your locators here

	@FindBy(xpath = "//select[contains(@id, 'entity_type')]")
	public WebElement entityType;

	@FindBy(xpath = "//input[contains(@id, 'dot_number')]")
	public WebElement dotNumber;

	@FindBy(xpath = "//input[contains(@id, 'legal_name')]")
	public WebElement insuredName;

	@FindBy(xpath = "//input[contains(@id, 'dba_name')]")
	public WebElement doingBusinessAs;

	@FindBy(xpath = "//input[contains(@id, 'mailing_street')]")
	public WebElement mailingAddress;

	@FindBy(xpath = "//input[contains(@id, 'mailing_city')]")
	public WebElement mailingCity;

	@FindBy(xpath = "//input[contains(@id, 'mailing_county')]")
	public WebElement mailingCountry;

	@FindBy(xpath = "//select[contains(@id, 'mailing_state')]")
	public WebElement mailingState;

	@FindBy(xpath = "//input[contains(@id, 'mailing_zip')]")
	public WebElement mailingZip;

	@FindBy(xpath = "//input[contains(@id, 'sameGarageAddressCheck')]")
	public WebElement garageAddressSameAsMailingAddressCB;

	@FindBy(xpath = "//input[contains(@id, 'sameShippingAddressCheck')]")
	public WebElement dashcamAddressSameAsMailingAddressCB;

	@FindBy(xpath = "//input[contains(@id, 'phy_street')]")
	public WebElement garageAddress;

	@FindBy(xpath = "//input[contains(@id, 'phy_city')]")
	public WebElement garageCity;

	@FindBy(xpath = "//input[contains(@id, 'phy_county')]")
	public WebElement garageCountry;

	@FindBy(xpath = "//select[contains(@id, 'phy_state')]")
	public WebElement garageState;

	@FindBy(xpath = "//input[contains(@id, 'phy_zip')]")
	public WebElement garageZip;

	@FindBy(xpath = "//input[contains(@id, 'insurance_contact_first_name')]")
	public WebElement insuranceFirstName;

	@FindBy(xpath = "//input[contains(@id, 'insurance_contact_last_name')]")
	public WebElement insuranceLastName;

	@FindBy(xpath = "//input[contains(@id, 'phone_input')]")
	public WebElement insurancePhoneNo;

	@FindBy(xpath = "//input[contains(@id, 'insurance_contact_email')]")
	public WebElement insuranceEmail;

	@FindBy(css = "[id='shipping_street']")
	public WebElement address;

	@FindBy(css = "[id='shipping_city']")
	public WebElement city;

	@FindBy(css = "[id='shipping_county']")
	public WebElement county;

	@FindBy(css = "[id='shipping_state']")
	public WebElement state;

	@FindBy(css = "[id='shipping_zip']")
	public WebElement zip;

	@FindBy(css = "input[id='sameShippingAddressCheck']")
	public WebElement shippingaddressCheckbox;

	@FindBy(css = "#list-insured  button.nextButton")
	public WebElement nextButton;

	@FindBy(css = "button[onclick='addAdditionalInsured()']")
	public WebElement addButton;

	@FindBy(css = "input[id=insured_waiver_subrogation_N]")
	public WebElement waiverOfSubrogationNOChecbox;
	
	@FindBy(css = "input[id=insured_waiver_subrogation_N]")
	public WebElement waiverOfSubrogationYESCheckbox;
	
	@FindBy(css = "input[id=insured_pn_tgl_N]")
	public WebElement primaryAndNoncontributoryForTGLNOCheckbox;
	
	@FindBy(css = "input[id=insured_pn_tgl_Y]")
	public WebElement primaryAndNoncontributoryForTGLYESCheckbox;
	
	@FindBy(css = "input[id=insured_pn_al_N]")
	public WebElement primaryAndNoncontributoryForALNOCheckbox;
	
	@FindBy(css = "input[id=insured_pn_al_Y]")
	public WebElement primaryAndNoncontributoryForALYESCheckbox;

	@FindBy(css = "button[data-target='#additionalInsuredModalPolicy']")
	public WebElement addAdditionalInsuredlink;

	@FindBy(css = "input[class='form-control ai_name']")
	public WebElement additionalInsuredNameTextbox;

	@FindBy(css = "input[class='form-control googleAutoComplete ai_street']")
	public WebElement additionalInsuredAddressTextbox;

	@FindBy(css = "input[class='form-control ai_city']")
	public WebElement additionalInsuredCityTextbox;

	@FindBy(css = "input[class='form-control ai_county']")
	public WebElement additionalInsuredCountyTextbox;

	@FindBy(xpath = "(//select[@name='ai_state'])[1]")
	public WebElement additionalInsuredStateDropdown;

	@FindBy(css = "input[class='form-control ai_zip']")
	public WebElement additionalInsuredZipTextbox;
	
	@FindBy(css = "input[id='sameShippingAddressCheck']")
	public WebElement sameShippingAddressCheck;

	public InsuredPageActions(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		webUtils = new WebUtils(driver);
	}

	public void enterShippingAddress() {
		String shippingAddress = insuredData.get("Shipping Address");
		Reporter.log("Entering Shipping Address: " + shippingAddress);
		webUtils.enterText(address, shippingAddress);
	}
	public void enterShippingCity() {
		String shippingCity = insuredData.get("Shipping City");
		Reporter.log("Entering Shipping City: " + shippingCity);
		webUtils.enterText(city, shippingCity);
	}
	public void enterShippingCounty() {
		String shippingCounty = insuredData.get("Shipping County");
		Reporter.log("Entering Shipping County: " + shippingCounty);
		webUtils.enterText(county, shippingCounty);
	}
	public void enterShippingState() {
		String shippingState = insuredData.get("Shipping State");
		Reporter.log("Selecting Shipping state: " + shippingState);
		webUtils.selectDropDownByVisibleText(state, shippingState);
	}
	public void enterShippingZip() {
		String shippingZip = insuredData.get("Shipping Zip");
		Reporter.log("Selecting mailing state: " + shippingZip);
		webUtils.enterText(zip, shippingZip);
	}

	public void clickShippingCheckbox() {
		Reporter.log("Marking the ShippingAddressCheckbox");
		LOGGER.info("Marking the checkbox");
		webUtils.click(shippingaddressCheckbox);
	}

	public void clickNextButton() {
		Reporter.log("Clicking Next button");
		webUtils.scrollingToElementofAPage(nextButton);
		webUtils.jsClick(nextButton);
	}

	public void clickDashcamAddressSameAsMailingAddressCB(){
		Reporter.log("Clicking Dashcam Address Same As Mailing Address CheckBox");
		webUtils.jsClick(dashcamAddressSameAsMailingAddressCB);
	}

	public void clickAddButton() {
		Reporter.log("Clicking Add button");
		webUtils.click(addButton);
	}

	public void enterName() {
		String additionalInfoName = insuredData.get("Additional Insured Name");
		Reporter.log("Entering Name: " + additionalInfoName);
		webUtils.enterText(additionalInsuredNameTextbox, additionalInfoName);
	}

	public void enterAddress() {
		String additionalInfoAddress = insuredData.get("Additional Insured Address");
		Reporter.log("Entering Address: " + additionalInfoAddress);
		webUtils.enterText(additionalInsuredAddressTextbox, additionalInfoAddress);
	}

	public void enterCity() {
		String additionalInfoCity = insuredData.get("Additional Insured City");
		Reporter.log("Entering City: " + additionalInfoCity);
		webUtils.enterText(additionalInsuredCityTextbox, additionalInfoCity);
	}

	public void enterCounty() {
		String additionalInfoCounty = insuredData.get("Additional Insured County");
		Reporter.log("Entering County: " + additionalInfoCounty);
		webUtils.enterText(additionalInsuredCountyTextbox, additionalInfoCounty);
	}

	public void enterState() {
		String additionalInfoState = insuredData.get("Additional Insured State");
		Reporter.log("Entering State: " + additionalInfoState);
		webUtils.selectDropDownByVisibleText(additionalInsuredStateDropdown, additionalInfoState);
	}

	public void enterZip() {
		String additionalInfoZip = insuredData.get("Additional Insured Zip");
		Reporter.log("Entering Zip: " + additionalInfoZip);
		webUtils.enterText(additionalInsuredZipTextbox, additionalInfoZip);
	}

	public void clickAddAdditionalInsuredLink() {
		Reporter.log("Clicking Next button");
		webUtils.scrollingToElementofAPage(addAdditionalInsuredlink);
		webUtils.click(addAdditionalInsuredlink);
	}

	/**
	 * option Yes/No
	 */
	public void selectWaiverOfSubrogation() {
		String option = insuredData.get("Waiver of Subrogation");
		Reporter.log("Selecting [Do you need Waiver of Subrogation?] as " + option );
		if (option.equalsIgnoreCase("Yes")) {
			webUtils.scrollingToElementofAPage(waiverOfSubrogationYESCheckbox);
			webUtils.jsClick(waiverOfSubrogationYESCheckbox);
		} else if (option.equalsIgnoreCase("No")) {
			webUtils.scrollingToElementofAPage(waiverOfSubrogationNOChecbox);
			webUtils.jsClick(waiverOfSubrogationNOChecbox);
		}
	}
	
	/**
	 * option Yes/No
	 */
	public void selectPrimaryAndNoncontributoryForTGL() {
		String option = insuredData.get("Primary and Noncontributory for TGL");
		Reporter.log("Selecting [Do you need Primary and Noncontributory for TGL?] as " + option );
		if (option.equalsIgnoreCase("Yes")) {
			webUtils.scrollingToElementofAPage(primaryAndNoncontributoryForTGLYESCheckbox);
			webUtils.jsClick(primaryAndNoncontributoryForTGLYESCheckbox);
		} else if (option.equalsIgnoreCase("No")) {
			webUtils.scrollingToElementofAPage(primaryAndNoncontributoryForTGLNOCheckbox);
			webUtils.jsClick(primaryAndNoncontributoryForTGLNOCheckbox);
		}
	}
	
	
	/**
	 * @param option Yes/No
	 */
	public void selectPrimaryAndNoncontributoryForAL() {
		String option = insuredData.get("Primary and Noncontributory for AL");
		Reporter.log("Selecting [Do you need Primary and Noncontributory for AL?] as " + option );
		if (option.equalsIgnoreCase("Yes")) {
			webUtils.scrollingToElementofAPage(primaryAndNoncontributoryForALNOCheckbox);
			webUtils.jsClick(primaryAndNoncontributoryForALYESCheckbox);			
		} else if (option.equalsIgnoreCase("No")) {
			webUtils.scrollingToElementofAPage(primaryAndNoncontributoryForALYESCheckbox);
			webUtils.jsClick(primaryAndNoncontributoryForALNOCheckbox);			
		}
	}
	
	public void clickSameShippingAddressCheck() {
		Reporter.log("Checking same shipping address check button");
		webUtils.scrollingToElementofAPage(sameShippingAddressCheck);
		webUtils.jsClick(sameShippingAddressCheck);
	}

}
