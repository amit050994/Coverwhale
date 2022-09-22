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

public class AdminRatesPageActions {

	private static final Logger LOGGER = LoggerFactory.getLogger(AdminRatesPageActions.class);
	private WebDriver driver;
	private WebUtils webUtils;

	public Map<String, String> adminRatesData = new LinkedHashMap<>();

	public void setAdminRatesData(Map<String, String> adminRatesDataForTestCase) {
		adminRatesData = adminRatesDataForTestCase;
	}

	@FindBy(id = "list-rates-admin-list")
	WebElement adminRatesTab;

	@FindBy(css = "a[data-target='#updateRates']")
	WebElement updateButton;

	// Automobile Liability options (AL)
	@FindBy(css = "select[id='carrier_al']")
	WebElement alCarrierDropdown;

	@FindBy(css = "input[id='rate_al']")
	WebElement alRateField;

	@FindBy(css = "input[id='deductible_al']")
	WebElement alDeductableField;

	// Automobile Physical Damage options (APD)
	@FindBy(css = "select[id='carrier_mtc']")
	WebElement mtcCarrierDropdown;

	@FindBy(css = "input[id='rate_mtc']")
	WebElement mtcRateField;

	@FindBy(css = "input[id='deductible_mtc']")
	WebElement mtcDeductableField;

	// Motor Truck Cargo (MTC)
	@FindBy(css = "select[id='carrier_apd']")
	WebElement apdCarrierDropdown;

	@FindBy(css = "input[id='rate_apd']")
	WebElement apdRateField;

	@FindBy(css = "input[id='deductible_apd']")
	WebElement apdDeductableField;

	// Truckers General Liability (TGL)
	@FindBy(css = "select[id='carrier_tgl']")
	WebElement tglCarrierDropdown;

	@FindBy(css = "input[id='rate_tgl']")
	WebElement tglRateField;

	@FindBy(css = "input[id='deductible_tgl']")
	WebElement tglDeductableField;

	// Non-Trucking Liability
	@FindBy(css = "select[id='carrier_ntl']")
	WebElement ntlCarrierDropdown;

	@FindBy(css = "input[id='rate_ntl']")
	WebElement ntlRateField;

	@FindBy(css = "input[id='deductible_ntl']")
	WebElement ntlDeductableField;
	
	
	@FindBy(css = "#updateRates div.modal-footer button")
	WebElement ratesSaveButton;

	public AdminRatesPageActions(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		webUtils = new WebUtils(driver);
	}

	public void clickOnAdminRatesTab() {
		Reporter.log("Clicking on admin rates tab");
		webUtils.click(adminRatesTab);
	}

	public void clickOnUpdateButton() {
		Reporter.log("Clicking on update button");
		webUtils.waitForElementVisibility(updateButton, 2);
		webUtils.click(updateButton);
	}
	
	public void clickSaveRatesButton() {
		Reporter.log("Clicking on save button insides rates modal.");
		webUtils.click(ratesSaveButton);
	}

	// AL
	public void selectALCarrier() {
		String alCarrier = adminRatesData.get("AL Carrier");
		Reporter.log("Selecting AL carrier as: " + alCarrier);
		webUtils.waitForElementVisibility(alCarrierDropdown, 2);
		webUtils.selectDropDownByVisibleText(alCarrierDropdown, alCarrier);
	}

	public void enterALRate() {
		String alRate = adminRatesData.get("AL Rate");
		Reporter.log("Entering AL Rate: " + alRate);
		webUtils.enterText(alRateField, alRate);
	}

	public void enterALDeductible() {
		String alDeductable = adminRatesData.get("AL Minimum Deductible");
		Reporter.log("Entering AL Deductible: " + alDeductable);
		webUtils.enterText(alDeductableField, alDeductable);
	}

	// APD
	public void selectAPDCarrier() {
		String apdCarrier = adminRatesData.get("APD Carrier");
		Reporter.log("Selecting APD carrier as: " + apdCarrier);
		webUtils.selectDropDownByVisibleText(apdCarrierDropdown, apdCarrier);
	}

	public void enterAPDRate() {
		String apdRate = adminRatesData.get("APD Rate");
		Reporter.log("Entering APD Rate: " + apdRate);
		webUtils.enterText(apdRateField, apdRate);
	}

	public void enterAPDDeductible() {
		String apdDeductable = adminRatesData.get("APD Minimum Deductible");
		Reporter.log("Entering APD Deductible: " + apdDeductable);
		webUtils.enterText(apdDeductableField, apdDeductable);
	}

	// MTC
	public void selectMTCCarrier() {
		String mtcCarrier = adminRatesData.get("MTC Carrier");
		Reporter.log("Selecting MTC carrier as: " + mtcCarrier);
		webUtils.selectDropDownByVisibleText(mtcCarrierDropdown, mtcCarrier);
	}

	public void enterMTCRate() {
		String mtcRate = adminRatesData.get("MTC Rate");
		Reporter.log("Entering MTC Rate: " + mtcRate);
		webUtils.enterText(mtcRateField, mtcRate);
	}

	public void enterMTCDeductible() {
		String mtcDeductable = adminRatesData.get("MTC Minimum Deductible");
		Reporter.log("Entering MTC Deductible: " + mtcDeductable);
		webUtils.enterText(mtcDeductableField, mtcDeductable);
	}
	
	// TGL
	public void selectTGLCarrier() {
		String tglCarrier = adminRatesData.get("TGL Carrier");
		Reporter.log("Selecting TGL carrier as: " + tglCarrier);
		webUtils.selectDropDownByVisibleText(tglCarrierDropdown, tglCarrier);
	}

	public void enterTGLRate() {
		String tglRate = adminRatesData.get("TGL Rate");
		Reporter.log("Entering TGL Rate: " + tglRate);
		webUtils.enterText(tglRateField, tglRate);
	}

	public void enterTGLDeductible() {
		String tglDeductable = adminRatesData.get("TGL Minimum Deductible");
		Reporter.log("Entering TGL Deductible: " + tglDeductable);
		webUtils.enterText(tglDeductableField, tglDeductable);
	}
	
	// NTL
	public void selectNTLCarrier() {
		String ntlCarrier = adminRatesData.get("NTL Carrier");
		Reporter.log("Selecting NTL carrier as: " + ntlCarrier);
		webUtils.selectDropDownByVisibleText(ntlCarrierDropdown, ntlCarrier);
	}

	public void enterNTLRate() {
		String ntlRate = adminRatesData.get("NTL Rate");
		Reporter.log("Entering NTL Rate: " + ntlRate);
		webUtils.enterText(ntlRateField, ntlRate);
	}

	public void enterNTLDeductible() {
		String ntlDeductable = adminRatesData.get("NTL Minimum Deductible");
		Reporter.log("Entering NTL Deductible: " + ntlDeductable);
		webUtils.enterText(ntlDeductableField, ntlDeductable);
	}
}
