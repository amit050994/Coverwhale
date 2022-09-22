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

public class AdminFeesPageActions {

	private static final Logger LOGGER = LoggerFactory.getLogger(AdminFeesPageActions.class);
	private WebDriver driver;
	private WebUtils webUtils;

	public Map<String, String> adminFeesData = new LinkedHashMap<>();

	public void setAdminFeesData(Map<String, String> adminFeesDataForTestCase) {
		adminFeesData = adminFeesDataForTestCase;
	}

	@FindBy(id = "list-fees-list")
	WebElement adminFeesTab;

	@FindBy(css = "a[data-target='#updateCommissionFees']")
	WebElement updateButton;

	// Commission & Fees

	// Automobile Liability options (AL)
	@FindBy(css = "input[id='commission_al']")
	WebElement alCommisionField;

	@FindBy(css = "input[id='fee_policy_al']")
	WebElement alPolicyField;

	@FindBy(css = "input[id='fee_service_al']")
	WebElement alBrokerFeesField;

	@FindBy(css = "input[id='fee_uw_al']")
	WebElement alUnderwritingFeesField;

	// Automobile Physical Damage options (APD)
	@FindBy(css = "input[id='commission_apd']")
	WebElement apdCommisionField;

	@FindBy(css = "input[id='fee_policy_apd']")
	WebElement apdPolicyField;

	@FindBy(css = "input[id='fee_service_apd']")
	WebElement apdBrokerFeesField;

	@FindBy(css = "input[id='fee_uw_apd']")
	WebElement apdUnderwritingFeesField;

	// Motor Truck Cargo (MTC)
	@FindBy(css = "input[id='commission_mtc']")
	WebElement mtcCommisionField;

	@FindBy(css = "input[id='fee_policy_mtc']")
	WebElement mtcPolicyField;

	@FindBy(css = "input[id='fee_service_mtc']")
	WebElement mtcBrokerFeesField;

	@FindBy(css = "input[id='fee_uw_mtc']")
	WebElement mtcUnderwritingFeesField;

	// Truckers General Liability (TGL)
	@FindBy(css = "input[id='commission_tgl']")
	WebElement tglCommisionField;

	@FindBy(css = "input[id='fee_policy_tgl']")
	WebElement tglPolicyField;

	@FindBy(css = "input[id='fee_service_tgl']")
	WebElement tglBrokerFeesField;

	@FindBy(css = "input[id='fee_uw_tgl']")
	WebElement tglUnderwritingFeesField;

	// Non-Trucking Liability
	@FindBy(css = "input[id='commission_ntl']")
	WebElement ntlCommisionField;

	@FindBy(css = "input[id='fee_policy_ntl']")
	WebElement ntlPolicyField;

	@FindBy(css = "input[id='fee_service_ntl']")
	WebElement ntlBrokerFeesField;

	@FindBy(css = "input[id='fee_uw_ntl']")
	WebElement ntlUnderwritingFeesField;

	@FindBy(css = "#updateCommissionFees div.modal-footer button")
	WebElement feesSaveButton;

	@FindBy(css = "#list-fees button.nextButton")
	WebElement nextButton;

	public AdminFeesPageActions(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		webUtils = new WebUtils(driver);
	}

	public void clickOnAdminFeesTab() {
		Reporter.log("Clicking on admin fees tab");
		webUtils.click(adminFeesTab);
	}

	public void clickNextButton() {
		Reporter.log("Clicking on next button");
		webUtils.click(nextButton);
	}

	public void clickOnUpdateButton() {
		Reporter.log("Clicking on update button");
		webUtils.waitForElementVisibility(updateButton, 5);
		webUtils.click(updateButton);
	}

	public void clickSaveFeesButton() {
		Reporter.log("Clicking on save button insides fees modal.");
		webUtils.click(feesSaveButton);
	}

	// AL
	public void enterALCommission() {
		String alCommission = adminFeesData.get("AL Commission%");
		Reporter.log("Entering AL commission %: " + alCommission);
		webUtils.waitForElementVisibility(alCommisionField, 5);
		webUtils.enterText(alCommisionField, alCommission);
	}

	public void enterALPolicyFees() {
		String alPolicyFees = adminFeesData.get("AL Policy Fee");
		Reporter.log("Entering AL Policy fees: " + alPolicyFees);
		webUtils.enterText(alPolicyField, alPolicyFees);
	}

	public void enterALBrokerFees() {
		String alBrokerFees = adminFeesData.get("AL Broker/Service Fee");
		Reporter.log("Entering AL broker fees: " + alBrokerFees);
		webUtils.enterText(alBrokerFeesField, alBrokerFees);
	}

	public void enterALUnderwritingFees() {
		String alUWFees = adminFeesData.get("AL uw fee");
		Reporter.log("Entering AL underwriting fees: " + alUWFees);
		webUtils.enterText(alUnderwritingFeesField, alUWFees);
	}

	// APD
	public void enterAPDCommission() {
		String apdCommission = adminFeesData.get("APD Commission%");
		Reporter.log("Entering APD commission %: " + apdCommission);
		webUtils.waitForElementVisibility(apdCommisionField, 5);
		webUtils.enterText(apdCommisionField, apdCommission);
	}

	public void enterAPDPolicyFees() {
		String apdPolicyFees = adminFeesData.get("APD Policy Fee");
		Reporter.log("Entering APD Policy fees: " + apdPolicyFees);
		webUtils.enterText(apdPolicyField, apdPolicyFees);
	}

	public void enterAPDBrokerFees() {
		String apdBrokerFees = adminFeesData.get("APD Broker/Service Fee");
		Reporter.log("Entering APD broker fees: " + apdBrokerFees);
		webUtils.enterText(apdBrokerFeesField, apdBrokerFees);
	}

	public void enterAPDUnderwritingFees() {
		String apdUWFees = adminFeesData.get("APD uw fee");
		Reporter.log("Entering APD underwriting fees: " + apdUWFees);
		webUtils.enterText(apdUnderwritingFeesField, apdUWFees);
	}

	// MTC
	public void enterMTCCommission() {
		String mtcCommission = adminFeesData.get("MTC Commission%");
		Reporter.log("Entering MTC commission %: " + mtcCommission);
		webUtils.enterText(mtcCommisionField, mtcCommission);
	}

	public void enterMTCPolicyFees() {
		String mtcPolicyFees = adminFeesData.get("MTC Policy Fee");
		Reporter.log("Entering MTC Policy fees: " + mtcPolicyFees);
		webUtils.enterText(mtcPolicyField, mtcPolicyFees);
	}

	public void enterMTCBrokerFees() {
		String mtcBrokerFees = adminFeesData.get("MTC Broker/Service Fee");
		Reporter.log("Entering MTC broker fees: " + mtcBrokerFees);
		webUtils.enterText(mtcBrokerFeesField, mtcBrokerFees);
	}

	public void enterMTCUnderwritingFees() {
		String mtcUWFees = adminFeesData.get("MTC uw fee");
		Reporter.log("Entering APD underwriting fees: " + mtcUWFees);
		webUtils.enterText(mtcUnderwritingFeesField, mtcUWFees);
	}

	// TGL
	public void enterTGLCommission() {
		String tglCommission = adminFeesData.get("TGL Commission%");
		Reporter.log("Entering TGL commission %: " + tglCommission);
		webUtils.enterText(tglCommisionField, tglCommission);
	}

	public void enterTGLPolicyFees() {
		String tglPolicyFees = adminFeesData.get("TGL Policy Fee");
		Reporter.log("Entering TGL Policy fees: " + tglPolicyFees);
		webUtils.enterText(tglPolicyField, tglPolicyFees);
	}

	public void enterTGLBrokerFees() {
		String tglBrokerFees = adminFeesData.get("TGL Broker/Service Fee");
		Reporter.log("Entering MTC broker fees: " + tglBrokerFees);
		webUtils.enterText(tglBrokerFeesField, tglBrokerFees);
	}

	public void enterTGLUnderwritingFees() {
		String tglUWFees = adminFeesData.get("TGL uw fee");
		Reporter.log("Entering TGL underwriting fees: " + tglUWFees);
		webUtils.enterText(tglUnderwritingFeesField, tglUWFees);
	}

	// NTL
	public void enterNTLCommission() {
		String ntlCommission = adminFeesData.get("NTL Commission%");
		Reporter.log("Entering NTL commission %: " + ntlCommission);
		webUtils.enterText(ntlCommisionField, ntlCommission);
	}

	public void enterNTLPolicyFees() {
		String ntlPolicyFees = adminFeesData.get("NTL Policy Fee");
		Reporter.log("Entering NTL Policy fees: " + ntlPolicyFees);
		webUtils.enterText(ntlPolicyField, ntlPolicyFees);
	}

	public void enterNTLBrokerFees() {
		String ntlBrokerFees = adminFeesData.get("NTL Broker/Service Fee");
		Reporter.log("Entering NTL broker fees: " + ntlBrokerFees);
		webUtils.enterText(ntlBrokerFeesField, ntlBrokerFees);
	}

	public void enterNTLUnderwritingFees() {
		String ntlUWFees = adminFeesData.get("NTL uw fee");
		Reporter.log("Entering TGL underwriting fees: " + ntlUWFees);
		webUtils.enterText(ntlUnderwritingFeesField, ntlUWFees);
	}

}
