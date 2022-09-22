package com.coverwhale.actions.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Reporter;

import com.coverwhale.utils.selenium.WebUtils;

public class ReviewPageActions {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TerminalPageActions.class);
	private WebDriver driver;
	private WebUtils webUtils;

	@FindBy(css = "#list-review div.card-body form button")
	WebElement requestQuoteButton;
	
	@FindBy(id = "agree_terms")
	WebElement agreetoTermsAndConditionsCbox;

	@FindBy(id = "list-review-list")
	WebElement reviewTab;

	@FindBy(xpath = "//button[contains(@class,'btn btn-light')][.='Change Application']")
	WebElement changeApplicationButton;

	@FindBy(id = "list-limits-list")
	WebElement limitsTab;
	
	public ReviewPageActions(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		webUtils = new WebUtils(driver);
	}

	public void clickRequestQuoteButton() {
		Reporter.log("Clicking on Request Quote button");
		webUtils.retryingClick(requestQuoteButton);
	}
	
	public void clickReviewTab() {
		Reporter.log("Clicking on Review tab");
		webUtils.waitForElementVisibility(reviewTab, 5);
		webUtils.click(reviewTab);
	}
	
	public void agreeToTermsAndConditions() {
		Reporter.log("Agree to terms and conditions");
		webUtils.waitForElementVisibility(agreetoTermsAndConditionsCbox, 4);
		webUtils.retryingClick(agreetoTermsAndConditionsCbox);
	}

	public void clickChangeApplicationButton() {
		Reporter.log("Clicking Change Application button");
		webUtils.retryingClick(changeApplicationButton);
	}

	public void clickLimitsTab() {
		Reporter.log("Clicking on Limits Tab");
		webUtils.waitForElementVisibility(limitsTab, 5);
		webUtils.click(limitsTab);
	}

}
