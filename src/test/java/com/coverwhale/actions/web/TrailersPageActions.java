package com.coverwhale.actions.web;

import com.coverwhale.utils.selenium.WebUtils;

import java.util.LinkedHashMap;
import java.util.Map;

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
public class TrailersPageActions {

	private static final Logger LOGGER = LoggerFactory.getLogger(TrailersPageActions.class);
	private WebDriver driver;
	private WebUtils webUtils;

	// page locators

	@FindBy(xpath = "//a[@data-target='#BulkTrailer']")
	WebElement bulkPasteButton;

	@FindBy(xpath = "//a[@data-target='#AddTrailer']")
	WebElement addTrailerButton;

	
	@FindBy(css = "#AddTrailerForm div.modal-footer button")
	WebElement addTrailerSaveButton;
	
	@FindBy(id = "doAutoScheduleTrailer")
	WebElement autoScheduleButton;

	@FindBy(xpath = "//div[@class='card-body' and .//a[@data-target='#BulkTrailer']]//button[string()='Next']")
	WebElement nextButton;

	// Bulk add trailers modal

	@FindBy(xpath = "//textarea[@name='trailers_list']")
	WebElement bulkAddTrailersTextarea;

	@FindBy(xpath = "//div[@id='BulkTrailer']//button[string()='Add Trailers']")
	WebElement bulkAddTrailersButton;

	@FindBy(xpath = "//div[@id='BulkTrailer']//button[@class='close']")
	WebElement closeBulkAddTrailersModalButton;

	// Add trailer modal

	@FindBy(id = "add-trailer-equipment-tab")
	WebElement trailerTab;

	@FindBy(id = "add-trailer-loss-payee-tab")
	WebElement lossPayeeTab;

	@FindBy(id = "trailer_loss_payee")
	WebElement trailerLossPayeeTextarea;

	@FindBy(xpath = "//div[@id='AddTrailer']//button[string()='Save']")
	WebElement saveTrailerButton;

	@FindBy(id = "trailer_owned")
	WebElement ownedTrailerCheckbox;

	@FindBy(id = "trailer_non_owned")
	WebElement nonOwne;

	@FindBy(id = "trailer_vehicle_id_number")
	WebElement vinField;

	@FindBy(xpath = "//div[@class='form-group' and ./label[@for='trailer_id_number']]//button[contains(string(),'VIN Lookup')]")
	WebElement vinLookupButton;

	@FindBy(id = "trailer_year")
	WebElement yearField;

	@FindBy(id = "trailer_make")
	WebElement makeOrManufacturerField;

	@FindBy(id = "trailer_model")
	WebElement modelField;

	@FindBy(xpath = "//div[./input[@id='trailer_value']]/input[contains(@id,'mony')]")
	WebElement valueField;
	
	@FindBy(css = "select.trailer-body-type[id='trailer-body-type']")
	WebElement bodyTypeDropdown;

	@FindBy(xpath = "//div[@id='AddTrailer']//button[@class='close']")
	WebElement closeAddTrailerModalButton;

	@FindBy(xpath = "//a[@class='btn btn-sm btn-link editTrailer']")
	WebElement changeButton;

	
	public Map<String, String> trailerData = new LinkedHashMap<>();
	
	public void setTrailerData(Map<String, String> trailerDataForTestCase) {
		trailerData = trailerDataForTestCase;
	}

	public void clickChangeOptionsButton() {
		Reporter.log("Clicking change Button in Options");
		webUtils.click(changeButton);
	}

	public TrailersPageActions(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		webUtils = new WebUtils(driver);
	}

	public void openBulkPasteModal() {
		Reporter.log("Opening the Bulk Paste modal");
		webUtils.click(bulkPasteButton);
	}

	public void openAddTrailerModal() {
		Reporter.log("Opening the Add Trailer modal");
		webUtils.click(addTrailerButton);
	}

	public void clickAutoScheduleButton() {
		Reporter.log("Clicking the Auto Schedule button");
		webUtils.click(autoScheduleButton);
	}

	public void clickNextButton() {
		Reporter.log("Moving on to the next step");
		LOGGER.info("Clicking the Next button");
		webUtils.click(nextButton);
	}

	public void populateBulkPasteField(String bulkTrailerList) {
		Reporter.log("Populating the Bulk Paste Trailers field");
		LOGGER.info("Writing values into the Bulk Paste Trailers field");
		webUtils.enterText(bulkAddTrailersTextarea, bulkTrailerList);
	}

	public void clickAddTrailersButton() {
		Reporter.log("Adding trailer(s)");
		LOGGER.info("Clicking the Add Trailers button");
		webUtils.retryingClick(addTrailerButton);
	}

	public void switchToTrailerTab() {
		Reporter.log("Switching to Trailer tab");
		LOGGER.info("Clicking the Trailer tab");
		webUtils.click(trailerTab);
	}

	public void switchToLossPayeeTab()	{
		Reporter.log("Switching to Loss Payee tab");
		LOGGER.info("Clicking the Loss Payee tab");
		webUtils.click(lossPayeeTab);
	}
	
	public void enterVinNumberField() {
		String vin = trailerData.get("Trailer VIN");
		Reporter.log("Entering Trailer VIN: " + vin);
		webUtils.waitForElementVisibility(vinField, 2);
		webUtils.enterText(vinField, vin);
	}
	
	
	public void lookupVin() {
		Reporter.log("Looking up the VIN");
		LOGGER.info("Clicking the VIN Lookup button");
		webUtils.click(vinLookupButton);
	}

	public void enterTrailerYear() {
		String trailerYear = trailerData.get("Trailer Year");
		Reporter.log("Entering Trailer Year: " + trailerYear);
		webUtils.enterText(yearField, trailerYear);
	}

	public void enterMakeOrManufacturer() {
		String trailerMake = trailerData.get("Trailer Make");
		Reporter.log("Entering Make or Manufacturer: " + trailerMake);
		webUtils.enterText(makeOrManufacturerField, trailerMake);
	}

	public void enterModel() {
		String trailerModel = trailerData.get("Trailer Model");
		Reporter.log("Entering Trailer Model: " + trailerModel);
		webUtils.enterText(modelField, trailerModel);
	}

	public void enterTrailerValue() {
		String trailerValue = trailerData.get("Trailer Value");
		Reporter.log("Entering tariler value: " + trailerValue);
		webUtils.enterText(valueField, trailerValue);
	}
	
	public void selectBodyType() {
		String bodyType = trailerData.get("BodyType");
		Reporter.log("Selecting body type: " + bodyType);
		webUtils.selectDropDownByVisibleText(bodyTypeDropdown, bodyType);
	}

	public void saveTrailer() {
		Reporter.log("Saving the new trailer(s)");
		webUtils.click(saveTrailerButton);
	}

	public void populateLossPayeeField(String lossPayee) {
		Reporter.log("Populating the Loss Payee field");
		LOGGER.info("Writing " + lossPayee + " in the Trailer Loss Payee field");
		webUtils.enterText(trailerLossPayeeTextarea, lossPayee);
	}

	public void closeAddTrailerModal() {
		Reporter.log("Closing the Add Trailer(s) modal");
		LOGGER.info("Clicking the X button in the Add Trailer modal");
		webUtils.click(closeAddTrailerModalButton);
	}
	
	public void clickTrailerSaveButton() {
		Reporter.log("Clicking on Save button");
		webUtils.retryingClick(addTrailerSaveButton);
	}

	
}
