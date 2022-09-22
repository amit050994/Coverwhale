package com.coverwhale.actions.web;

import com.coverwhale.utils.selenium.WebUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

/**
 * It contains all actions that can be performed on Home page of the application.
 */
public class TransportationPageActions {

	private static final Logger LOGGER = LoggerFactory.getLogger(TransportationPageActions.class);
	private WebDriver driver;
	private WebUtils webUtils;

	// write your locators here

	@FindBy(xpath = "//a[contains(string(), 'New Quote')]")
	WebElement newQuoteButton;

	@FindBy(xpath = "//input[@id='searchAgencyName']")
	WebElement searchField;

	@FindBy(xpath = "//select[@id='searchAgencyName']")
	WebElement searchStateSelect;
	Select searchStateDropdown = new Select(searchStateSelect);

	@FindBy(xpath = "//select[@id='searchAgencyStatus']")
	WebElement searchStatusSelect;
	Select searchStatusDropdown = new Select(searchStatusSelect);

	@FindBy(xpath = "//input[@id='years_of_business']")
	WebElement yearsOfBusinessField;

	@FindBy(xpath = "//input[@id='number_of_trucks']")
	WebElement numberOfTrucksField;

	@FindBy(id = "hide_endorsements")
	WebElement hideEndorsementsCheckbox;

	@FindBy(id = "renewals")
	WebElement renewalsCheckbox;

	@FindBy(xpath = "//button[string()='Search']")
	WebElement searchButton;

	@FindBy(xpath = "//th/a[contains(string(),'Submission Date')]")
	WebElement submissionDateColumnHeader;

	@FindBy(xpath = "//th/a[contains(string(),'Submission #')]")
	WebElement submissionNumberColumnHeader;

	@FindBy(xpath = "//th/a[contains(string(),'Effective Date')]")
	WebElement effectiveDateColumnHeader;

	@FindBy(xpath = "//th/a[contains(string(),'Agency Name')]")
	WebElement AgencyNameColumnHeader;

	@FindBy(xpath = "//th/a[contains(string(),'DOT Number)]")
	WebElement dotNumberColumnHeader;

	@FindBy(xpath = "//th/a[contains(string(),'Legal Name')]")
	WebElement legalNameColumnHeader;

	@FindBy(xpath = "//th/a[contains(string(),'State')]")
	WebElement stateColumnHeader;

	@FindBy(xpath = "//th/a[contains(string(),'Coverages')]")
	WebElement coveragesColumnHeader;

	@FindBy(xpath = "//th/a[contains(string(),'TIV')]")
	WebElement tivColumnHeader;

	@FindBy(xpath = "//th/a[contains(string(),'Status')]")
	WebElement statusColumnHeader;



	public TransportationPageActions(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		webUtils = new WebUtils(driver);
	}

	public void requestNewQuote() {
		Reporter.log("Requesting a new quote");
		LOGGER.info("Clicking the New Quote button");
		webUtils.click(newQuoteButton);
	}
	
	
}
