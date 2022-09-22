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
public class SubmissionPageActions {

	private static final Logger LOGGER = LoggerFactory.getLogger(SubmissionPageActions.class);
	private WebDriver driver;
	private WebUtils webUtils;

	// write your locators here
	@FindBy(xpath = "//input[contains(@id, 'quote_request_al')]")
	public WebElement autoLiabilityCB;

	@FindBy(xpath = "//a[contains(text(),'Submission Overview')]")
	public WebElement submissionOverviewButton;
	
	@FindBy(xpath = "//span[contains(text(), 'Not Available in State:')]")
	public WebElement notAvailableMessage;

	@FindBy(xpath = "//select[contains(@name, 'opt_al_pip')]")
	public WebElement selectPersonalInjuryProtection;

	@FindBy(xpath = "//select[contains(@name, 'opt_al_um')]")
	public WebElement selectUninsuredMotorists;

	@FindBy(xpath = "//input[contains(@id, 'quote_request_apd')]")
	public WebElement automobilePhysicalDamageCB;

	@FindBy(xpath = "//input[contains(@id, 'quote_request_mtc')]")
	public WebElement motorTruckCargoCB;

	@FindBy(xpath = "//input[contains(@id, 'quote_request_tgl')]")
	public WebElement truckersGeneralLiabilityCB;

	@FindBy(xpath = "//input[contains(@id, 'quote_request_ntl')]")
	public WebElement nonTruckingLiabilityCB;

	@FindBy(xpath = "//label[contains(text(), 'Effective Date')]/parent::div/descendant::i")
	public WebElement openCalender;

	@FindBy(xpath = "//i[contains(@class, 'gj-icon chevron-right')]")
	public WebElement clickRightArrowOfCalender;
	
	@FindBy(xpath = "//button[contains(.,'Next')]")
	public WebElement nextButton;

	@FindBy(xpath = "//select[@name='opt_al_um']")
	public WebElement acceptDropdown;

	@FindBy(xpath = "(//select[@name='opt_al_um']/option)[2]")
	public WebElement acceptButton;

	@FindBy(xpath = "//a[@id='list-cargo-list']")
	public WebElement cargoTab;
	
	public SubmissionPageActions(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		webUtils = new WebUtils(driver);
	}

	public void clickautoLiabilityCBeCheckbox() {
		Reporter.log("Marking the automobilePhysicalDamageCheckbox");
		LOGGER.info("Marking the automobilePhysicalDamageCheckbox");
		webUtils.click(autoLiabilityCB);
	}
	public String stateMessage() {
		
		Reporter.log("Getting the text from State message");
		webUtils.waitForElementVisibility(notAvailableMessage, 1);
		return webUtils.getTextUsingAttribute(notAvailableMessage, "innerText").trim();
	}
	
	public void selectPersonalInjuryProtection(String PersonalInjuryProtection) {
		Reporter.log("Populating the numberOfTrucks field");
		LOGGER.info("Selecting " + selectPersonalInjuryProtection + " in the Value field");
		webUtils.selectDropDownByVisibleText(selectPersonalInjuryProtection, PersonalInjuryProtection);
	}

	public void selectUninsuredMotorist(String Motorists) {
		Reporter.log("Populating the numberOfTrucks field");
		LOGGER.info("Selecting " + selectUninsuredMotorists + " in the Value field");
		webUtils.selectDropDownByVisibleText(selectUninsuredMotorists, Motorists);
	}

	public void clickAutomobilePhysicalDamageCheckbox() {
		Reporter.log("Marking the automobilePhysicalDamageCheckbox");
		LOGGER.info("Marking the automobilePhysicalDamageCheckbox");
		webUtils.click(automobilePhysicalDamageCB);
	}

	public void clickMotorTruckCargoCheckbox() {
		Reporter.log("Marking the motorTruckCargoCheckbox");
		LOGGER.info("Marking the motorTruckCargoCheckbox");
		webUtils.click(motorTruckCargoCB);
	}

	public void clickTruckersGeneralLiabilityCheckbox() {
		Reporter.log("Marking the truckersGeneralLiabilityCheckbox");
		webUtils.click(truckersGeneralLiabilityCB);
	}

	public void clicknonTruckingLiabilityCheckbox() {
		Reporter.log("Marking the nonTruckingLiabilityCheckbox");
		webUtils.click(nonTruckingLiabilityCB);
	}

	public void clicknonEffectiveDateCalender() {
		Reporter.log("Marking the openCalender");
		LOGGER.info("Marking the openCalender");
		webUtils.click(openCalender);
	}

	public void clickRightArrowOfCalender() {
		Reporter.log("Marking the clickRightArrowOfCalender");
		LOGGER.info("Marking the clickRightArrowOfCalender");
		webUtils.click(clickRightArrowOfCalender);
	}
	
	public void clickNextButton() {
		Reporter.log("Clicking Next button");
		webUtils.retryingClick(nextButton);
	}

	public void clickSubmissionOverviewButton() {
		Reporter.log("Clicking Submission Overview button");
		webUtils.scrollingToElementofAPage(submissionOverviewButton);
		webUtils.scrollToElementAndClickUsingJS(submissionOverviewButton);
	}

	public void clickAcceptButtonInDropdown() {
		Reporter.log("Clicking Accept button in Uninsured Motorists/Property Damage dropdown");
		webUtils.click(acceptDropdown);
		webUtils.click(acceptButton);
	}

	public void clickCargoTab() {
		Reporter.log("Clicking Cargo button");
		webUtils.click(cargoTab);
	}



	public void selectAutoLiability(String pip, String umpd) {
		Reporter.log("Selecting Auto Liability as PIP: " + pip + "and UM/PD as: " + umpd);
		if (!pip.isBlank()) {
			selectPersonalInjuryProtection(pip);
		}
		if (!umpd.isBlank()) {
			selectUninsuredMotorist(umpd);
		}
	}
}
