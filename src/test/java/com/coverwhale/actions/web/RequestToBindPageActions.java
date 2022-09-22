package com.coverwhale.actions.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Reporter;

import com.coverwhale.utils.selenium.WebUtils;

public class RequestToBindPageActions {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RequestToBindPageActions.class);
	private WebDriver driver;
	private WebUtils webUtils;

	@FindBy(id = "payment_12")
	WebElement paymentOptionsCoverWhaleFinancedRadioBox;

	@FindBy(id = "manual_sign_binding_method")
	WebElement billingmethodRadioBox;
	
	@FindBy(id = "agree_terms")
	WebElement agreetoTermsAndConditionsCbox;

	@FindBy(css = "input[id='retail_agent_email']")
	WebElement retailerEmailTextBox;

	@FindBy(id = "electronic_signature_checkbox")
	WebElement agreeToElectronicSignatureCbox;
	
	@FindBy(id = "electronic_signature_name")
	WebElement electronicSignatureNameField;

	@FindBy(css = "[id='retail_agent_email']")
	WebElement retailAgentEmail;

	@FindBy(xpath = "//button[contains(@class,'btn btn-primary')][.='Request to Bind']")
	WebElement requestToBindButton;

	@FindBy(css = "[id='manual_sign_binding_method']")
	WebElement bindMethodOption;

	public RequestToBindPageActions(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		webUtils = new WebUtils(driver);
	}

	public void selectCoverwhalePaymentOption() {
		Reporter.log("Clicking on payment option [Cover Whale Financed (Down Payment Collected by Retail Agent)] radio button");
		webUtils.waitForElementVisibility(paymentOptionsCoverWhaleFinancedRadioBox, 5);
		webUtils.retryingClick(paymentOptionsCoverWhaleFinancedRadioBox);
	}

	public void selectBillingMethodOption() {
		Reporter.log("Clicking on Binding Method [ Manual: Fill out, sign, and upload all required documents manually.] radio button");
		webUtils.waitForElementVisibility(billingmethodRadioBox, 5);
		webUtils.retryingClick(billingmethodRadioBox);
	}

	public void emptyRetailerEmailTextbox() {
		Reporter.log("Entering valid Insured Email Address: ");
		webUtils.clearTextBox(retailerEmailTextBox);
	}
	
	public void agreeToElectronicSignature() {
		Reporter.log("Clicking on [I Agree to use Electronic Signatures] checkbox");
		webUtils.click(agreeToElectronicSignatureCbox);
	}
	
	public void agreeToTermsAndConditions() {
		Reporter.log("Agree to terms and conditions");
		webUtils.retryingClick(agreetoTermsAndConditionsCbox);
	}
	
	public void enterElectronicSignatureName(String name) {
		Reporter.log("Entering electronic signature as: " + name );
		webUtils.enterText(electronicSignatureNameField, name);
	}

	public void emptyRetailAgentEmail() {
		Reporter.log("Removing Retail Agent Email");
		webUtils.clearTextBox(retailAgentEmail);
	}

	public void submitRequestToBind() {
		Reporter.log("Submitting request to bind." );
		webUtils.click(requestToBindButton);
	}

	public void selectBindingMethodOption() {
		Reporter.log("Clicking on bind option radio button");
		webUtils.waitForElementVisibility(bindMethodOption, 5);
		webUtils.retryingClick(bindMethodOption);
	}

}
