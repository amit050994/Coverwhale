package com.coverwhale.actions.web;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Reporter;

import com.coverwhale.utils.selenium.WebUtils;

public class TransportationActions {

	private static final Logger LOGGER = LoggerFactory.getLogger(TransportationActions.class);

	private WebDriver driver;
	private WebUtils webUtils;


	@FindBy(xpath = "//a[contains(.,'New Quote')]")
	WebElement newQuoteButton;
	
	@FindBy(xpath = "//a[contains(.,'New Quote')]")
	List<WebElement> newQuoteButtonList;
	
	@FindBy(css = "#app nav div a")
	WebElement coverwhaleHeaderLink;
	
	@FindBy(id = "searchAgencyName")
	WebElement searchField;
	
	@FindBy(xpath = "//button[@type='submit' and .='Search']")
	WebElement searchButton;
	
	@FindBy(xpath = "//a[contains(text(),'Submission #')]/parent::th/parent::tr/parent::thead/following::tbody/tr/td/a")
	WebElement firstSubmissionIdFromResult;


	public TransportationActions(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		webUtils = new WebUtils(driver);
	}
	
	public void openNewQuoteForm() {
		Reporter.log("Opening new quote form");
		if (newQuoteButtonList.size() < 1) {
			navigateToAdminLandingPage();
			webUtils.waitForElementVisibility(newQuoteButton, 10);
		}
		webUtils.click(newQuoteButton);
	}
	
	public void navigateToAdminLandingPage() {
		Reporter.log("Click on text CoverWhale that is present on header to nagigate to admin landing page to create new quote");
		webUtils.click(coverwhaleHeaderLink);
	}
	
	public void enterIntoSearchField(String itemToSearch) {
		Reporter.log("Searching " + itemToSearch + " from search bar in admin landing page");
		webUtils.waitForElementVisibility(searchField, 10);
		webUtils.enterText(searchField, itemToSearch);
	}
	
	public void clickSearchButton() {
		Reporter.log("Clicking on search button");
		webUtils.waitForElementVisibility(searchButton, 10);
		webUtils.click(searchButton);
	}
	
	public void clickFirstSearchResultWithSubmissionId() {
		Reporter.log("Clicking on submission Id in admin landing page");
		webUtils.waitForElementVisibility(firstSubmissionIdFromResult, 10);
		webUtils.click(firstSubmissionIdFromResult);
	}
}
