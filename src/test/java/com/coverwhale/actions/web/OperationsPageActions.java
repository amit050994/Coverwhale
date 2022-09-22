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
public class OperationsPageActions {

	private static final Logger LOGGER = LoggerFactory.getLogger(OperationsPageActions.class);
	private WebDriver driver;
	private WebUtils webUtils;
	
	public Map<String, String> operationData = new LinkedHashMap<>();
	
	public void setOperationData(Map<String, String> quoteDataForTestCase) {
		operationData = quoteDataForTestCase;
	}

	// write your locators here

	@FindBy(xpath = "//span[contains(@aria-labelledby, 'select2-state-cs-container')]")
	public WebElement stateOfOperations;

	@FindBy(xpath = "//span[contains(@id, 'select2-eld_vendor_name-container')]")
	public WebElement ELDvendorName;
	
	@FindBy(xpath = "//label[contains(@for, 'filings_al_federal_Y')]")
	public WebElement requireFederalFilings;
	
	@FindBy(xpath = "//label[contains(@for, 'filings_al_federal_N')]")
	public WebElement notRequireFederalFilings;
	
	@FindBy(css = "input[id=ineligible_operations_N]")
	public WebElement ineligibleOperationsNO;
	
	@FindBy(css = "input[id=ineligible_operations_Y]")
	public WebElement ineligibleOperationsYES;
	
	@FindBy(css = "label[for=filings_al_state_N]")
	public WebElement stateFilingALNO;
	
	@FindBy(css = "label[for=filings_al_state_Y]")
	public WebElement stateFilingALYES;

	@FindBy(xpath = "//label[contains(@for, 'prior_insurance_cancelled_nonrenewed_Y')]")
	public WebElement yesPriorInsuranceCancelledNonrenewed;
	
	@FindBy(xpath = "//label[contains(@for, 'prior_insurance_cancelled_nonrenewed_N')]")
	public WebElement noPriorInsurancenotCancelledNonrenewed;
	
	@FindBy(xpath = "//input[contains(@id, 'years_business')]")
	public WebElement operatingYears;
	
	@FindBy(xpath = "//input[contains(@id, 'annual_revenue')]/following-sibling::input")
	public WebElement GrossAnnualTruckingRevenue;
	
	@FindBy(xpath = "//input[contains(@id, 'annual_mileage')]/following-sibling::input")
	public WebElement AnnualMileage;
	
	@FindBy(xpath = "//label[contains(text(), 'Local Trucker')]/preceding-sibling::input")
	public WebElement localTruckerCheckbox;
	
	@FindBy(xpath = "//label[contains(text(), 'Intermediate')]/preceding-sibling::input")
	public WebElement IntermediateCheckbox;
	
	@FindBy(xpath = "//label[contains(text(), 'Long Haul Trucker')]/preceding-sibling::input")
	public WebElement LongHaulTruckereCheckbox;
	
	@FindBy(xpath = "//label[contains(text(), 'Intermodal or Port')]/preceding-sibling::input")
	public WebElement IntermodalOrPortCheckbox;
	
	@FindBy(xpath = "//label[contains(text(), 'Dump Trucks (Other)')]/preceding-sibling::input")
	public WebElement DumpTrucksOtherCheckbox;
	
	@FindBy(xpath = "//label[contains(text(), 'Dump Trucks (Sand and Gravel)')]/preceding-sibling::input")
	public WebElement DumpTrucksSandAndGravelCheckbox;
	
	@FindBy(xpath = "//label[contains(text(), 'End Dumper Units')]/preceding-sibling::input")
	public WebElement EndDumperUnitsCheckbox;
	
	@FindBy(xpath = "//label[contains(text(), 'Logging')]/preceding-sibling::input")
	public WebElement LoggingCheckbox;
	
	@FindBy(xpath = "//label[contains(text(), 'Refrigerated Trailer')]/preceding-sibling::input")
	public WebElement RefrigeratedTrailerCheckbox;
	
	@FindBy(xpath = "//label[contains(text(), 'Oversized or Overweight')]/preceding-sibling::input")
	public WebElement OversizedOrOverweightCheckbox;
	
	@FindBy(xpath = "//label[contains(text(), 'Automobile Hauler')]/preceding-sibling::input")
	public WebElement AutomobileHaulerCheckbox;
	
	@FindBy(xpath = "//label[contains(text(), 'Household Goods Mover')]/preceding-sibling::input")
	public WebElement HouseholdGoodsMoverCheckbox;
	
	@FindBy(xpath = "//label[contains(text(), 'Tankers')]/preceding-sibling::input")
	public WebElement TankersCheckbox;
	
	@FindBy(css = "#list-operations button")
	public WebElement nextButton;

	public OperationsPageActions(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		webUtils = new WebUtils(driver);
	}
	
	public void clickNextButton() {
		Reporter.log("Clicking Next button");
		webUtils.scrollingToElementofAPage(nextButton);
		webUtils.retryingClick(nextButton);
	}
	

	public void selectStateOfOperations(String StateofOperations) {
		Reporter.log("Populating the StateofOperations field");
		LOGGER.info("Selecting " + StateofOperations + " in the Value field");
		webUtils.jsClick(stateOfOperations);
	}

	public void clickELDvendorName() {
		Reporter.log("Open ELDvendorName Comobo)");
		LOGGER.info("Open ELDvendorName Comobo");
		webUtils.click(ELDvendorName);
	}
	

	public void SelectrequiredFederalFiling() {
		Reporter.log("Click on requireFederalFilings button)");
		LOGGER.info("Click on requireFederalFilings button)");
		webUtils.click(requireFederalFilings);
	}
	
	public void FederalFilingNotRequired() {
		Reporter.log("Click on notRequireFederalFilings button)");
		LOGGER.info("Click on notRequireFederalFilings button)");
		webUtils.click(notRequireFederalFilings);
	}

	
	public void yesPriorInsuranceCancelledNonrenewed() {
		Reporter.log("Click on yesPriorInsuranceCancelledNonrenewed button)");
		LOGGER.info("Click on yesPriorInsuranceCancelledNonrenewed button)");
		webUtils.click(yesPriorInsuranceCancelledNonrenewed);
	}
	
	public void noPriorInsurancenotCancelledNonrenewed() {
		Reporter.log("Click on noPriorInsurancenotCancelledNonrenewed button)");
		LOGGER.info("Click on noPriorInsurancenotCancelledNonrenewed button)");
		webUtils.click(noPriorInsurancenotCancelledNonrenewed);
	}
	
	public void populateperatingYears(String Years) {
		Reporter.log("Populating the operatingYears field");
		LOGGER.info("Writing " + operatingYears + " in the Value field");
		webUtils.enterText(operatingYears, Years);
	}


	public void populateAnnualMileage(String AnnualMilage) {
		Reporter.log("Populating the AnnualMileage field");
		LOGGER.info("Writing " + AnnualMileage + " in the Value field");
		webUtils.enterText(AnnualMileage, AnnualMilage);
	}

	
	public void selectFederalFilingsForAutoLiability() {
		String option = operationData.get("Federal Filings");
		webUtils.waitForElementVisibility(requireFederalFilings, 10);
		Reporter.log("Selecting [Do You Require Federal Filings for Auto Liability?] as " + option );
		if (option.equalsIgnoreCase("Yes")) {
			webUtils.jsClick(requireFederalFilings);
		} else if (option.equalsIgnoreCase("No")) {
			webUtils.jsClick(notRequireFederalFilings);
		}
	}
	
	public void selectInEligibleOperation() {
		String option = operationData.get("Ineligible Operations");
		Reporter.log("Selecting [Does insured conduct any of the following Ineligible Operations?] as " + option );
		if (option.equalsIgnoreCase("Yes")) {
			webUtils.scrollingToElementofAPage(ineligibleOperationsYES);
			webUtils.jsClick(ineligibleOperationsYES);
		} else if (option.equalsIgnoreCase("No")) {
			webUtils.scrollingToElementofAPage(ineligibleOperationsNO);
			webUtils.jsClick(ineligibleOperationsNO);
		}
	}
	
	public void selectFilingStateAutoliability(String option) {
		Reporter.log("Selecting [Do You Require State Filings for Auto Liability?] as " + option );
		webUtils.waitForElementPresence("input[id=filings_al_state_Y]_css",30000);
		if (option.equalsIgnoreCase("Yes")) {
			webUtils.scrollingToElementofAPage(stateFilingALYES);
			webUtils.jsClick(stateFilingALYES);
		} else if (option.equalsIgnoreCase("No")) {
			webUtils.scrollingToElementofAPage(stateFilingALNO);
			webUtils.jsClick(stateFilingALNO);
		}
	}
	
	public void enterGrossAnnualTruckingRevenue() {
		String annualRevenue = operationData.get("Gross Annual Trucking Revenue");
		Reporter.log("Entering the gross annual trucking revenue as: " + annualRevenue);
		webUtils.scrollingToElementofAPage(GrossAnnualTruckingRevenue);
		webUtils.enterText(GrossAnnualTruckingRevenue, annualRevenue);
	}
	
	public void selectLocalTruckerCheckbox() {
		Reporter.log("Selecting Local trucker checkobox");
		webUtils.scrollingToElementofAPage(localTruckerCheckbox);
		webUtils.click(localTruckerCheckbox);
	}
	

	
	
}
