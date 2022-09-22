package com.coverwhale.actions.web;

import com.coverwhale.utils.selenium.WebUtils;
import org.openqa.selenium.By;
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
 * It contains all actions that can be performed on Driver page of the application.
 */

public class DriversPageActions {

	private static final Logger LOGGER = LoggerFactory.getLogger(DriversPageActions.class);
	private WebDriver driver;
	private WebUtils webUtils;


	public Map<String, String> driverData = new LinkedHashMap<>();
	
	public void setDriverData(Map<String, String> driverDataForTestCase) {
		driverData = driverDataForTestCase;
	}
	
	// page locators

	@FindBy(xpath = "//a[@data-target='#BulkDriver']")
	WebElement bulkPasteButton;

	@FindBy(xpath = "//a[@data-target='#AddDriver']")
	WebElement addDriverButton;

	@FindBy(xpath = "//div[@class='card-body' and .//a[@data-target='#BulkDriver']]//button[string()='Next']")
	WebElement nextButton;


	// Bulk add drivers modal

	@FindBy(xpath = "//textarea[@name='drivers_list']")
	WebElement bulkAddDriversTextarea;

	@FindBy(xpath = "//div[@id='BulkDriver']//button[string()='Add Drivers']")
	WebElement bulkAddDriversButton;

	@FindBy(xpath = "//div[@id='BulkDriver']//button[@class='close']")
	WebElement closeBulkAddDriversModalButton;


	// Add driver modal

	@FindBy(css = "[id='name_first']")
	WebElement firstNameField;

	@FindBy(id = "name_last")
	WebElement lastNameField;

//	@FindBy(xpath = "//div[@id='AddDriver']//select[@name='driver_license_state']")
//	WebElement driverLicenceStateSelect;
//	Select driverLicenceStateDropdown = new Select(driverLicenceStateSelect);

	@FindBy(id = "driver_license_number")
	WebElement driverLicenceNumberField;

	@FindBy(id = "driver_date_of_birth")
	WebElement driverDateOfBirthPicker;

	@FindBy(id = "driver_date_of_hire")
	WebElement driverDateOfHirePicker;

	@FindBy(id = "years_cdl_experience")
	WebElement driverYearsOfCdlExperienceField;

	@FindBy(id = "driver_covered_y")
	WebElement coveredDriverRadioButton;

	@FindBy(id = "driver_covered_n")
	WebElement excludedDriverRadioButton;

	@FindBy(id = "accidents_total")
	WebElement accidentsField;

	@FindBy(id = "violations_total")
	WebElement violationsField;

	@FindBy(id = "suspensions_total")
	WebElement suspensionsField;

	@FindBy(id = "major_violations_total")
	WebElement majorviolationsField;

	@FindBy(xpath = "//form[.//input[@id='years_cdl_experience']]//button[string()='Continue']")
	WebElement continueButton;

	@FindBy(xpath = "//div[@id='AddDriver']//button[@class='close']")
	WebElement closeAddDriverModalButton;


	// Drivers table

	public void openEditDriverModal(String tableIndex) {
		String editButtonXpath = "//table[@id='driversTable']//tr[" + tableIndex + "]//a[string()='Edit']";
		Reporter.log("Opening Edit Driver modal");
		LOGGER.info("Clicking the Edit button");
		driver.findElement(By.xpath(editButtonXpath)).click();
	}

	public void openCheckDriverModal(String tableIndex) {
		String checkButtonXpath = "//table[@id='driversTable']//tr[" + tableIndex + "]//a[string()='Check']";
		Reporter.log("Opening Check Driver modal");
		LOGGER.info("Clicking the Check button");
		driver.findElement(By.xpath(checkButtonXpath)).click();
	}

	public void openRemoveDriverDialog(String tableIndex) {
		String removeButtonXpath = "//table[@id='driversTable']//tr[" + tableIndex + "]//a[string()='Remove']";
		Reporter.log("Opening Remove Driver dialog");
		LOGGER.info("Clicking the Remove button");
		driver.findElement(By.xpath(removeButtonXpath)).click();
	}


	// Check Report Modal

	@FindBy(id = "driverMVRLookUpURL")
	WebElement sambaSafetyButton;

	@FindBy(id = "chechDriverManuallyURL")
	WebElement enterManuallyButton;

	@FindBy(xpath = "//button[string()='Cancel']")
	WebElement cancelCheckReportModalButton;


	// New Driver Report

	@FindBy(xpath = "//main[.//h1[string()='New Driver Report']]//a[string()=' Back']")
	WebElement backButton;

	@FindBy(id = "accidents-tab")
	WebElement accidentsTab;

	@FindBy(id = "violations-tab")
	WebElement violationsTab;

	@FindBy(id = "suspensions-tab")
	WebElement suspensionsTab;

	@FindBy(xpath = "//a[string()=' Add Accident']")
	WebElement addAccidentButton;

	@FindBy(xpath = "//a[string()=' Add Violation']")
	WebElement addViolationButton;

	@FindBy(xpath = "//a[string()=' Add Suspension']")
	WebElement addSuspensionButton;


	// Add Accident modal

	@FindBy(id = "accident_accident_date")
	WebElement accidentDatePicker;

	@FindBy(id = "accident_description")
	WebElement accidentDescriptionField;

	@FindBy(id = "accident_city")
	WebElement accidentCityField;

	@FindBy(id = "accident_county")
	WebElement accidentCountyField;

	@FindBy(id = "accident_state")
	WebElement accidentStateField;

	@FindBy(id = "accident_order_number")
	WebElement accidentOrderNumberField;

	@FindBy(id = "accident_points")
	WebElement accidentPointsField;

	@FindBy(id = "accident_vehicle_speed")
	WebElement accidentVehicleSpeedField;

	@FindBy(id = "accident_reinstatement_date")
	WebElement accidentReinstatementDatePicker;

	@FindBy(id = "accident_action_taken")
	WebElement accidentActionTakenField;

	@FindBy(id = "accident_ticket_number")
	WebElement accidentTicketNumberField;

	@FindBy(id = "accident_enforcing_agency")
	WebElement accidentEnforcingAgencyField;

	@FindBy(id = "accident_jurisdiction")
	WebElement accidentJurisdictionField;

	@FindBy(id = "accident_severity")
	WebElement accidentSeverityField;

	@FindBy(id = "accident_violation_number")
	WebElement accidentViolationNumberField;

	@FindBy(id = "accident_license_plate")
	WebElement accidentLicencePlateField;

	@FindBy(id = "accident_fine_amount")
	WebElement accidentFineAmountField;

	@FindBy(id = "accident_state_code")
	WebElement accidentStateCodeField;

	@FindBy(id = "accident_acd_code")
	WebElement accidentAcdCodeField;

	@FindBy(id = "accident_injury_accident")
	WebElement injuryAccidentCheckbox;

	@FindBy(id = "accident_fatality_accident")
	WebElement fatalityAccidentCheckbox;

	@FindBy(id = "accident_fatality_count")
	WebElement accidentFatalityCountField;

	@FindBy(id = "accident_injury_count")
	WebElement accidentInjuryCountField;

	@FindBy(id = "accident_vehicles_involved_count")
	WebElement accidentVehiclesInvolvedCountField;

	@FindBy(id = "accident_report_number")
	WebElement accidentReportNumberField;

	@FindBy(id = "accident_policy_number")
	WebElement accidentPolicyNumberField;

	@FindBy(xpath = "//div[@id='AddDriverAccident']//button[string()='Save']")
	WebElement addAccidentModalSaveButton;

	@FindBy(xpath = "//div[@id='AddDriverAccident']//button[@class='close']")
	WebElement addAccidentModalCloseButton;

	// Add Violation Modal

	@FindBy(id = "violation_type")
	WebElement violationTypeField;

	@FindBy(id = "violation_issued_date")
	WebElement violationIssuedDatePicker;

	@FindBy(id = "violation_conviction_date")
	WebElement violationConvictionDatePicker;

	@FindBy(id = "violation_description")
	WebElement violationDescriptionField;

	@FindBy(id = "violation_points")
	WebElement violationPointsField;

	@FindBy(id = "violation_city")
	WebElement violationCityField;

	@FindBy(id = "violation_county")
	WebElement violationCountyField;

	@FindBy(id = "violation_state")
	WebElement violationStateField;

	@FindBy(id = "violation_ticket_number")
	WebElement violationTicketNumberField;

	@FindBy(id = "violation_disposition")
	WebElement violationDispositionField;

	@FindBy(id = "violation_category")
	WebElement violationCategoryField;

	@FindBy(id = "violation_court_name")
	WebElement violationCourtNameField;

	@FindBy(id = "violation_acd_code")
	WebElement violationAcdCodeField;

	@FindBy(id = "violation_state_code")
	WebElement violationStateCodeField;

	@FindBy(id = "violation_docket")
	WebElement violationDocketField;

	@FindBy(xpath = "//div[@id='AddDriverViolation']//button[string()='Save']")
	WebElement addViolationModalSaveButton;

	@FindBy(xpath = "//div[@id='AddDriverViolation']//button[@class='close']")
	WebElement addViolationModalCloseButton;


	// Add Suspension modal

	@FindBy(id = "suspension_state")
	WebElement suspensionStateField;

	@FindBy(id = "suspension_start_date")
	WebElement suspensionStartDatePicker;

	@FindBy(id = "suspension_end_date")
	WebElement suspensionEndDatePicker;

	@FindBy(id = "suspension_description")
	WebElement suspensionDescriptionField;

	@FindBy(xpath = "//div[@id='AddDriverSuspension']//button[string()='Save']")
	WebElement addSuspensionModalSaveButton;

	@FindBy(xpath = "//div[@id='AddDriverSuspension']//button[@class='close']")
	WebElement addSuspensionModalCloseButton;


	// METHODS

	// Page methods

	public void openBulkPasteModal() {
		Reporter.log("Opening Bulk Paste Driver dialog");
		LOGGER.info("Clicking the Bulk Paste buttin");
		webUtils.click(bulkPasteButton);
	}

	public void openAddDriverModal() {
		Reporter.log("Opening Add Driver modal");
		webUtils.sleep(5);
		webUtils.click(addDriverButton);
	}

	public void proceedToLossesPage() {
		Reporter.log("Proceeding to Losses page");
		webUtils.click(nextButton);
	}


	// Bulk Paste Modal

	public void populateBulkPasteDriversTextarea(String bulkDrivers) {
		Reporter.log("Populating the Bulk Paste Drivers textarea");
		LOGGER.info("Writing " + bulkDrivers + " into the Bulk Paste Drivers textarea");
		webUtils.enterText(bulkAddDriversTextarea, bulkDrivers);
	}

	public void clickBulkAddDriversButton() {
		Reporter.log("Bulk adding the new drivers");
		LOGGER.info("Clicking the Bulk Add Drivers button");
		webUtils.click(bulkAddDriversButton);
	}

	public void closeBulkPasteDriversModal() {
		Reporter.log("Closing the Bulk Paste Drivers dialog");
		LOGGER.info("Clicking the X button in the Bulk Paste Drivers modal");
		webUtils.click(closeBulkAddDriversModalButton);
	}


	// Add Driver modal

	public void enterDriverFirstName() {
		String driverFirstName = driverData.get("Driver First Name");
		Reporter.log("Entering driver first name: " + driverFirstName);
		webUtils.waitForElementVisibility(firstNameField, 2);
		webUtils.enterText(firstNameField, driverFirstName);
	}


	public void enterDriverLastName() {
		String driverLastName = driverData.get("Driver Last Name");
		Reporter.log("Entering driver last name: " + driverLastName);
		webUtils.enterText(lastNameField, driverLastName);

	}

	/*
	 * public void selectDriverLicenceState(String licenceState) {
	 * Reporter.log("Selecting the drivers licence state"); LOGGER.info("Selecting "
	 * + licenceState + " from the Driver Licence State dropdown");
	 * webUtils.selectDropDownByVisibleText(driverLicenceStateSelect, licenceState);
	 * }
	 */

	public void enterDriverLicenceNumber() {
		String driverLicenseNumber = driverData.get("Driver License Number");
		Reporter.log("Entering driver license number: " + driverLicenseNumber);
		webUtils.enterText(driverLicenceNumberField, driverLicenseNumber);
	}

	public void enterDriverDateOfBirth() {
		String driverDOB = driverData.get("Driver Date of Birth");
		Reporter.log("Entering driver date of birth: " + driverDOB);
		webUtils.enterText(driverDateOfBirthPicker, driverDOB);
	}

	public void selectDriverDateOfHire(String dateOfHire) {
		Reporter.log("Selecting the driver's date of hire");
		LOGGER.info("Writing " + dateOfHire + " in the driver date of hire field");
		webUtils.enterText(driverDateOfHirePicker, dateOfHire);
	}

	public void enterDriverYearsOfExperience() {
		String driverYearsOfExperience = driverData.get("Years Experience");
		Reporter.log("Entering driver years of experience: " + driverYearsOfExperience);
		webUtils.enterText(driverYearsOfCdlExperienceField, driverYearsOfExperience);
	}

	public void selectCoveredDriverRadioButton() {
		Reporter.log("Selecting the Covered Driver radio button");
		LOGGER.info("Clicking the Covered Driver radio button");
		webUtils.click(coveredDriverRadioButton);
	}

	public void selectExcludedDriverRadioButton() {
		Reporter.log("Selecting the Excluded Driver radio button");
		LOGGER.info("Clicking the Excluded Driver radio button");
		webUtils.click(excludedDriverRadioButton);
	}

	public void enterNumberOfAccidents() {
		String accidents = driverData.get("Accidents");
		Reporter.log("Entering driver number of accidents: " + accidents);
		webUtils.enterText(accidentsField, accidents);
	}

	public void enterNumberOfViolations() {
		String violations = driverData.get("Violations");
		Reporter.log("Entering driver number of violations: " + violations);
		webUtils.enterText(violationsField, violations);
	}

	public void enterNumberofSuspensions() {
		String suspensions = driverData.get("Suspensions");
		Reporter.log("Entering driver number of suspensions: " + suspensions);
		webUtils.enterText(suspensionsField, suspensions);
	}

	public void enterNumberofMajorViolations() {
		String majorviolations = driverData.get("Majorviolations");
		Reporter.log("Entering driver number of Major Violations: " + majorviolations);
		webUtils.enterText(majorviolationsField, majorviolations);
	}

	public void clickContinueButton() {
		Reporter.log("Adding a new driver");
		webUtils.retryingClick(continueButton);
	}

	public void closeAddDriverModal() {
		Reporter.log("Closing the Add Driver dialog");
		LOGGER.info("Clicking the X button on the Add Driver modal");
		webUtils.click(closeAddDriverModalButton);
	}

	public void clickSambaSafetyButton() {
		Reporter.log("Clicking the Samba Safety button");
		LOGGER.info("Clicking the Samba Safety button");
		webUtils.click(sambaSafetyButton);
	}

	public void openNewDriverReportDialog() {
		Reporter.log("Opening the New Driver Report dialog");
		LOGGER.info("CLicking the Enter Manually button");
		webUtils.click(enterManuallyButton);
	}


	// New Driver Report

	public void openAddAccidentModal() {
		Reporter.log("Opening the Add Accident modal");
		LOGGER.info("Clicking the Add Accident button");
		webUtils.click(addAccidentButton);
	}

	public void openAddViolationModal() {
		Reporter.log("Opening the Add Violation modal");
		LOGGER.info("Clicking the Add Violation button");
		webUtils.click(addViolationButton);
	}

	public void openAddSuspensionModal() {
		Reporter.log("Opening the Add Suspension modal");
		LOGGER.info("Clicking the Add Suspension button");
		webUtils.click(addSuspensionButton);
	}

	public void switchToAccidentsTab() {
		Reporter.log("Switching to Accidents tab");
		LOGGER.info("Clicking the Accidents tab");
		webUtils.click(accidentsTab);
	}

	public void switchToViolationsTab() {
		Reporter.log("Switching to Violations tab");
		LOGGER.info("Clicking the Violations tab");
		webUtils.click(violationsTab);
	}

	public void switchToSuspensionsTab() {
		Reporter.log("Switching to Suspensions tab");
		LOGGER.info("Clicking the Suspensions tab");
		webUtils.click(suspensionsTab);
	}

	public void goBack() {
		Reporter.log("Going back one page");
		LOGGER.info("Clicking the Back button");
		webUtils.click(backButton);
	}


	// Add Accident modal

	public void populateAccidentDateField(String accidentDate) {
		Reporter.log("Populating the Accident Date picker");
		LOGGER.info("Writing " + accidentDate + " in the accident date picker");
		webUtils.enterText(accidentDatePicker, accidentDate);
	}

	public void populateAccidentDescriptionField(String accidentDescription) {
		Reporter.log("Populating the Accident Description field");
		LOGGER.info("Writing " + accidentDescription + " in the Accident Description field");
		webUtils.enterText(accidentDescriptionField, accidentDescription);
	}

	public void populateAccidentCityField(String accidentCity) {
		Reporter.log("Populating the Accident City field");
		LOGGER.info("Writing " + accidentCity + " in the Accident City field");
		webUtils.enterText(accidentCityField, accidentCity);
	}

	public void populateAccidentCountyField(String accidentCounty) {
		Reporter.log("Populating the Accident County field");
		LOGGER.info("Writing " + accidentCounty + " in the Accident County field");
		webUtils.enterText(accidentCountyField, accidentCounty);
	}
	public void populateAccidentStateField(String accidentState) {
		Reporter.log("Populating the Accident State field");
		LOGGER.info("Writing " + accidentState + " in the Accident State field");
		webUtils.enterText(accidentStateField, accidentState);
	}
	public void populateAccidentOrderNumberField(String accidentOrderNumber) {
		Reporter.log("Populating the Accident Order Number field");
		LOGGER.info("Writing " + accidentOrderNumber + " in the Accident Order Number field");
		webUtils.enterText(accidentOrderNumberField, accidentOrderNumber);
	}
	public void populateAccidentPointsField(String accidentPoints) {
		Reporter.log("Populating the Accident Points field");
		LOGGER.info("Writing " + accidentPoints + " in the Accident Points field");
		webUtils.enterText(accidentPointsField, accidentPoints);
	}

	public void populateAccidentVehicleSpeedField(String accidentVehicleSpeed) {
		Reporter.log("Populating the Vehicle Speed field");
		LOGGER.info("Writing " + accidentVehicleSpeed + " in the Vehicle Speed field");
		webUtils.enterText(accidentVehicleSpeedField, accidentVehicleSpeed);
	}

	public void populateAccidentReinstatementDatePicker(String accidentReinstatementDate) {
		Reporter.log("Populating the Accident Reinstatement Date picker");
		LOGGER.info("Writing " + accidentReinstatementDate + " in the Accident Reinstatement Date picker");
		webUtils.enterText(accidentReinstatementDatePicker, accidentReinstatementDate);
	}

	public void populateAccidentActionTakenField(String accidentActionTaken) {
		Reporter.log("Populating the Accident Action Taken field");
		LOGGER.info("Writing " + accidentActionTaken + " in the Accident Action Taken field");
		webUtils.enterText(accidentActionTakenField, accidentActionTaken);
	}

	public void populateAccidentTicketNumberField(String accidentTicketNumber) {
		Reporter.log("Populating the Accident Ticket Number field");
		LOGGER.info("Writing " + accidentTicketNumber + " in the Accident Ticket Number field");
		webUtils.enterText(accidentTicketNumberField, accidentTicketNumber);
	}

	public void populateAccidentEnforcingAgencyField(String accidentEnforcingAgency) {
		Reporter.log("Populating the Accident Enforcing Agency field");
		LOGGER.info("Writing " + accidentEnforcingAgency + " in the Accident Enforcing Agency field");
		webUtils.enterText(accidentEnforcingAgencyField, accidentEnforcingAgency);
	}

	public void populateAccidentJurisdictionField(String accidentJurisdiction) {
		Reporter.log("Populating the Accident Jurisdiction field");
		LOGGER.info("Writing " + accidentJurisdiction + " in the Accident Jurisdiction field");
		webUtils.enterText(accidentJurisdictionField, accidentJurisdiction);
	}

	public void populateAccidentSeverityField(String accidentSeverity) {
		Reporter.log("Populating the Accident Severity field");
		LOGGER.info("Writing " + accidentSeverity + " in the Accident Severity field");
		webUtils.enterText(accidentSeverityField, accidentSeverity);
	}

	public void populateAccidentViolationNumberField(String accidentViolationNumber) {
		Reporter.log("Populating the Accident Violation Number field");
		LOGGER.info("Writing " + accidentViolationNumber + " in the Accident Violation Number field");
		webUtils.enterText(accidentViolationNumberField, accidentViolationNumber);
	}

	public void populateAccidentLicensePlateField(String accidentLicensePlate) {
		Reporter.log("Populating the Accident License Plate field");
		LOGGER.info("Writing " + accidentLicensePlate + " in the Accident License Plate field");
		webUtils.enterText(accidentLicencePlateField, accidentLicensePlate);
	}

	public void populateAccidentFineAmountField(String accidentFineAmount) {
		Reporter.log("Populating the Accident Fine Amount field");
		LOGGER.info("Writing " + accidentFineAmount + " in the Accident Fine Amount field");
		webUtils.enterText(accidentFineAmountField, accidentFineAmount);
	}

	public void populateAccidentStateCodeField(String accidentStateCode) {
		Reporter.log("Populating the Accident State Code field");
		LOGGER.info("Writing " + accidentStateCode + " in the Accident State Code field");
		webUtils.enterText(accidentStateCodeField, accidentStateCode);
	}

	public void populateAccidentAcdCodeField(String accidentAcdCode) {
		Reporter.log("Populating the Accident Acd Code field");
		LOGGER.info("Writing " + accidentAcdCode + " in the Accident Acd Code field");
		webUtils.enterText(accidentAcdCodeField, accidentAcdCode);
	}

	public void selectInjuryAccidentCheckbox() {
		Reporter.log("Selecting the Injury Accident checkbox");
		LOGGER.info("Clicking the Injury Accident checkbox");
		webUtils.click(injuryAccidentCheckbox);
	}

	public void selectFatalityAccidentCheckbox() {
		Reporter.log("Selecting the Fatality Accident checkbox");
		LOGGER.info("Clicking the Fatality Accident checkbox");
		webUtils.click(fatalityAccidentCheckbox);
	}

	public void populateAccidentFatalityCountField(String accidentFatalityCount) {
		Reporter.log("Populating the Accident Fatality Count field");
		LOGGER.info("Writing " + accidentFatalityCount + " in the Accident Fatality Count field");
		webUtils.enterText(accidentFatalityCountField, accidentFatalityCount);
	}

	public void populateAccidentInjuryCountField(String accidentInjuryCount) {
		Reporter.log("Populating the Accident Injury Count field");
		LOGGER.info("Writing " + accidentInjuryCount + " in the Accident Injury Count field");
		webUtils.enterText(accidentInjuryCountField, accidentInjuryCount);
	}

	public void populateAccidentVehiclesInvolvedCountField(String accidentVehiclesInvolvedCount) {
		Reporter.log("Populating the Accident Vehicles Involved Count field");
		LOGGER.info("Writing " + accidentVehiclesInvolvedCount + " in the Accident Vehicles Involved Count field");
		webUtils.enterText(accidentVehiclesInvolvedCountField, accidentVehiclesInvolvedCount);
	}

	public void populateAccidentReportNumberField(String accidentReportNumber) {
		Reporter.log("Populating the Accident Report Number field");
		LOGGER.info("Writing " + accidentReportNumber + " in the Accident Report Number field");
		webUtils.enterText(accidentReportNumberField, accidentReportNumber);
	}

	public void populateAccidentPolicyNumberField(String accidentPolicyNumber) {
		Reporter.log("Populating the Accident Policy Number field");
		LOGGER.info("Writing " + accidentPolicyNumber + " in the Accident Policy Number field");
		webUtils.enterText(accidentPolicyNumberField, accidentPolicyNumber);
	}

	public void submitDriverAccident() {
		Reporter.log("Submitting the Driver Accident");
		LOGGER.info("Clicking the Save button on Add Accident modal");
		webUtils.click(addAccidentModalSaveButton);
	}


	// Add Violation Modal

	public void populateViolationTypeField(String violationType) {
		Reporter.log("Populating the Violation Type field");
		LOGGER.info("Writing " + violationType + " in the Violation Type field");
		webUtils.enterText(violationTypeField, violationType);
	}

	public void populateViolationIssuedDatePicker(String violationIssuedDate) {
		Reporter.log("Populating the Violation Issued Date field");
		LOGGER.info("Writing " + violationIssuedDate + " in the Violation Issued Date field");
		webUtils.enterText(violationIssuedDatePicker, violationIssuedDate);
	}

	public void populateViolationConvictionDatePicker(String violationConvictionDate) {
		Reporter.log("Populating the Violation Conviction Date field");
		LOGGER.info("Writing " + violationConvictionDate + " in the Violation Conviction Date field");
		webUtils.enterText(violationConvictionDatePicker, violationConvictionDate);
	}

	public void populateViolationDescriptionField(String violationDescription) {
		Reporter.log("Populating the Violation Description field");
		LOGGER.info("Writing " + violationDescription + " in the Violation Description field");
		webUtils.enterText(violationDescriptionField, violationDescription);
	}

	public void populateViolationPointsField(String violationPoints) {
		Reporter.log("Populating the Violation Points field");
		LOGGER.info("Writing " + violationPoints + " in the Violation Points field");
		webUtils.enterText(violationPointsField, violationPoints);
	}

	public void populateViolationCityField(String violationCity) {
		Reporter.log("Populating the Violation City field");
		LOGGER.info("Writing " + violationCity + " in the Violation City field");
		webUtils.enterText(violationCityField, violationCity);
	}

	public void populateViolationCountyField(String violationCounty) {
		Reporter.log("Populating the Violation County field");
		LOGGER.info("Writing " + violationCounty + " in the Violation County field");
		webUtils.enterText(violationCountyField, violationCounty);
	}

	public void populateViolationStateField(String violationState) {
		Reporter.log("Populating the Violation State field");
		LOGGER.info("Writing " + violationState + " in the Violation State field");
		webUtils.enterText(violationStateField, violationState);
	}

	public void populateViolationTicketNumberField(String violationTicketNumber) {
		Reporter.log("Populating the Violation Ticket Number field");
		LOGGER.info("Writing " + violationTicketNumber + " in the Violation Ticket Number field");
		webUtils.enterText(violationTicketNumberField, violationTicketNumber);
	}

	public void populateViolationDispositionField(String violationDisposition) {
		Reporter.log("Populating the Violation Disposition field");
		LOGGER.info("Writing " + violationDisposition + " in the Violation Disposition field");
		webUtils.enterText(violationDispositionField, violationDisposition);
	}

	public void populateViolationCategoryField(String violationCategory) {
		Reporter.log("Populating the Violation Category field");
		LOGGER.info("Writing " + violationCategory + " in the Violation Category field");
		webUtils.enterText(violationCategoryField, violationCategory);
	}

	public void populateViolationCourtNameField(String violationCourtName) {
		Reporter.log("Populating the Violation Court Name field");
		LOGGER.info("Writing " + violationCourtName + " in the Violation Court Name field");
		webUtils.enterText(violationCourtNameField, violationCourtName);
	}

	public void populateViolationAcdCodeField(String violationAcdCode) {
		Reporter.log("Populating the Violation Acd Code field");
		LOGGER.info("Writing " + violationAcdCode + " in the Violation Acd Code field");
		webUtils.enterText(violationAcdCodeField, violationAcdCode);
	}

	public void populateViolationStateCodeField(String violationStateCode) {
		Reporter.log("Populating the Violation State Code field");
		LOGGER.info("Writing " + violationStateCode + " in the Violation State Code field");
		webUtils.enterText(violationStateCodeField, violationStateCode);
	}

	public void populateViolationDocketField(String violationDocket) {
		Reporter.log("Populating the Violation Docket field");
		LOGGER.info("Writing " + violationDocket + " in the Violation Docket field");
		webUtils.enterText(violationDocketField, violationDocket);
	}

	public void saveViolation() {
		Reporter.log("Saving a new violation");
		LOGGER.info("Clicking the Save button");
		webUtils.click(addViolationModalSaveButton);
	}


	// Add Suspension Modal

	public void populateSuspensionStateField(String suspensionState) {
		Reporter.log("Populating Suspension State field");
		LOGGER.info("Typing " + suspensionState + " into the Suspension State field");
		webUtils.enterText(suspensionStateField, suspensionState);
	}

	public void selectSuspensionStartDate(String suspensionStartDate) {
		Reporter.log("Selecting the suspension start date");
		LOGGER.info("Writing " + suspensionStartDate + " into Suspension Start Date picker");
		webUtils.enterText(suspensionStartDatePicker, suspensionStartDate);
	}

	public void selectSuspensionEndDate(String suspensionEndDate) {
		Reporter.log("Selecting the suspension end date");
		LOGGER.info("Writing " + suspensionEndDate + " into Suspension End Date picker");
		webUtils.enterText(suspensionEndDatePicker, suspensionEndDate);
	}

	public void populateSuspensionDescriptionField(String suspensionDescription) {
		Reporter.log("Populating the Suspension Description field");
		LOGGER.info("Writing " + suspensionDescription + " in the suspension description field");
		webUtils.enterText(suspensionDescriptionField, suspensionDescription);
	}

	public void saveSuspension() {
		Reporter.log("Saving a new suspension");
		LOGGER.info("Clicking the Save button");
		webUtils.click(addSuspensionModalSaveButton);
	}



	public DriversPageActions(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		webUtils = new WebUtils(driver);
	}

	






















	
	
}
