package com.coverwhale.actions.web;

import java.util.LinkedHashMap;
import java.util.Map;

import com.coverwhale.core.DataRecorder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Reporter;

import com.coverwhale.utils.selenium.WebUtils;

public class VehiclePageActions {

	private static final Logger LOGGER = LoggerFactory.getLogger(TerminalPageActions.class);
	private WebDriver driver;
	private WebUtils webUtils;
	private SubmissionStatusButtonsPageActions submissionStatusButtons;


	@FindBy(css = "#list-vehicles button.nextButton")
	WebElement nextButton;
	
	@FindBy(css = "a[data-target='#AddVehicle']")
	WebElement addVehicleButton;

	@FindBy(css = "a[id='add-additional-insured-tab']")
	WebElement additionalInsuredTab;

	@FindBy(css = "input[id='vehicle_id_number']")
	WebElement vehicleIdentificationNumberField;
	
	@FindBy(css = "input[id='vin_year']")
	WebElement vehicleYearField;
	
	@FindBy(css = "input[id='vin_make']")
	WebElement vehicleMakeOrManufacturarField;
	
	@FindBy(css = "input[id='vin_model']")
	WebElement vehicleModalField;
	
	@FindBy(css = "input[id='vin_value']")
	WebElement vehicleValue;
	
	@FindBy(css = "select[id='vin_class']")
	WebElement vehicleClassDropdown;
	
	@FindBy(css = "select[id='body_type']")
	WebElement vehicleBodyTypeDropdown;
	
	@FindBy(xpath = "(//button[contains(text(),'Save')])[9]")
	WebElement saveButton;

	@FindBy(xpath = "(//a[@class='btn btn-sm btn-link  editVehicle'])[last()]")
	WebElement changeButton;

	@FindBy(css = "#AddVehicleForm div.modal-footer button")
	WebElement vehicleSaveButton;

	@FindBy(css = "input[name='ai_name']")
	public WebElement additionalInsuredNameTextbox;

	@FindBy(css = "input[name='ai_street']")
	public WebElement additionalInsuredAddressTextbox;

	@FindBy(css = "input[name='ai_city']")
	public WebElement additionalInsuredCityTextbox;

	@FindBy(css = "input[name='ai_county']")
	public WebElement additionalInsuredCountyTextbox;

	@FindBy(css = "[name='ai_state']")
	public WebElement additionalInsuredStateDropdown;

	@FindBy(css = "input[name='ai_zip']")
	public WebElement additionalInsuredZipTextbox;
		
	
	public Map<String, String> vehicleData = new LinkedHashMap<>();
	public VehiclePageActions(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		webUtils = new WebUtils(driver);
	}
	
	public void setVehicleData(Map<String, String> vehicleDataForTestCase) {
		vehicleData = vehicleDataForTestCase;
	}

	public void addVehicleData() {
		Map<String, String> VehicleData = (Map<String, String>) DataRecorder.VEHICLES_CACHE.get("VEHICLE_DATA_5");
		    this.setVehicleData(VehicleData);
			submissionStatusButtons = new SubmissionStatusButtonsPageActions(driver);
			submissionStatusButtons.clickVehiclesTab();
			this.clickAddVehicleButton();
			this.enterVIN();
			this.enterVehicleYear();
			this.enterMakeOrManufacturer();
			this.enterModel();
			this.enterVehicleValue();
			this.selectVehicleClass();
			this.selectVehicleBodyType();
			this.clickAddVehicleSaveButton();
			webUtils.sleep(2);

	}

	public void clickNextButton() {
		Reporter.log("Clicking on Next button");
		webUtils.retryingClick(nextButton);
	}
	
	public void clickAddVehicleButton() {
		Reporter.log("Clicking on Add vehicle button");
		webUtils.retryingClick(addVehicleButton);
	}

	public void clickAdditionalInsuredTab() {
		Reporter.log("Clicking on Additional Insured Tab");
		webUtils.click(additionalInsuredTab);
	}

	public void enterName() {
		String additionalInfoName = vehicleData.get("Additional Insured Name");
		Reporter.log("Entering Name: " + additionalInfoName);
		webUtils.enterText(additionalInsuredNameTextbox, additionalInfoName);
	}

	public void enterAddress() {
		String additionalInfoAddress = vehicleData.get("Additional Insured Address");
		Reporter.log("Entering Address: " + additionalInfoAddress);
		webUtils.enterText(additionalInsuredAddressTextbox, additionalInfoAddress);
	}

	public void enterCity() {
		String additionalInfoCity = vehicleData.get("Additional Insured City");
		Reporter.log("Entering City: " + additionalInfoCity);
		webUtils.enterText(additionalInsuredCityTextbox, additionalInfoCity);
	}

	public void enterCounty() {
		String additionalInfoCounty = vehicleData.get("Additional Insured County");
		Reporter.log("Entering County: " + additionalInfoCounty);
		webUtils.enterText(additionalInsuredCountyTextbox, additionalInfoCounty);
	}

	public void enterState() {
		String additionalInfoState = vehicleData.get("Additional Insured State");
		Reporter.log("Entering State: " + additionalInfoState);
		webUtils.selectDropDownByVisibleText(additionalInsuredStateDropdown, additionalInfoState);
	}

	public void enterZip() {
		String additionalInfoZip = vehicleData.get("Additional Insured Zip");
		Reporter.log("Entering Zip: " + additionalInfoZip);
		webUtils.enterText(additionalInsuredZipTextbox, additionalInfoZip);
	}

	public void clickSaveButton() {
		Reporter.log("Clicking on Save button");
		webUtils.click(saveButton);
	}

	public void clickAddVehicleSaveButton() {
		Reporter.log("Clicking on Add Vehicle Save button");
		webUtils.click(vehicleSaveButton);
	}

	public void clickChangeOptionsButton() {
		Reporter.log("Clicking change Button in Options");
		webUtils.click(changeButton);
	}
	
	public void selectVehicleClass() {
		String vehicleClass = vehicleData.get("Class");
		Reporter.log("Selecting vehicle class as: " + vehicleClass);
		webUtils.selectDropDownByValue(vehicleClassDropdown, vehicleClass);
	}
	
	public void selectVehicleBodyType() {
		String vehicleBody = vehicleData.get("BodyType");
		Reporter.log("Selecting vehicle Body type as: " + vehicleBody);
		webUtils.selectDropDownByVisibleText(vehicleBodyTypeDropdown, vehicleBody);
	}

	public void enterVIN() {
		String vin = vehicleData.get("VIN");
		Reporter.log("Entering VIN: " + vin);
		webUtils.waitForElementVisibility(vehicleIdentificationNumberField, 3);
		webUtils.enterText(vehicleIdentificationNumberField, vin);
	}
	
	public void enterVehicleYear() {
		String year = vehicleData.get("Year");
		Reporter.log("Entering vehicle year: " + year);
		webUtils.enterText(vehicleYearField, year);
	}
	
	public void enterMakeOrManufacturer() {
		String make = vehicleData.get("Make");
		Reporter.log("Entering make or manufacturer: " + make);
		webUtils.enterText(vehicleMakeOrManufacturarField, make);
	}
	
	public void enterModel() {
		String model = vehicleData.get("Model");
		Reporter.log("Entering model: " + model);
		webUtils.enterText(vehicleModalField, model);
	}
	
	public void enterVehicleValue() {
		String value = vehicleData.get("Value");
		Reporter.log("Entering vehicle value: " + value);
		webUtils.enterText(vehicleValue, value);
	}


	
}
