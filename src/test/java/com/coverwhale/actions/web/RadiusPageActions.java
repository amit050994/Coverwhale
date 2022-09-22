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

public class RadiusPageActions {

	private static final Logger LOGGER = LoggerFactory.getLogger(LimitsPageActions.class);
	private WebDriver driver;
	private WebUtils webUtils;

	// write your locators here

	@FindBy(css = "input[id=radius_501]")
	public WebElement fiveHundredPlusMilesField;

	@FindBy(css = "input[id=radius_0_50]")
	public WebElement UnderfiftyMilesField;

	@FindBy(css = "input[id='radius_201_500']")
	public WebElement UnderTwoHundredMilesField;
	
	@FindBy(css = "#list-radius button")
	public WebElement nextButton;
	
    public Map<String, String> radiusData = new LinkedHashMap<>();
	
	public void setRadiusData(Map<String, String> radiusDataForTestCase) {
		radiusData = radiusDataForTestCase;
	}

	public RadiusPageActions(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		webUtils = new WebUtils(driver);
	}
	
	public void enter500MilesPlusValue() {
		String fiveHundredMiles = radiusData.get("500+ Miles");
		Reporter.log("Entering 500+ miles value as : " + fiveHundredMiles);
		webUtils.enterText(fiveHundredPlusMilesField, fiveHundredMiles);
	}
	
	public void clickNextButton() {
		Reporter.log("Clicking Next button");
		nextButton.click();

	}

	public void enterUnder50MilesValue() {
			String fiftyMiles = radiusData.get("0");
			Reporter.log("Entering under 50 miles value as : " + fiftyMiles);
			webUtils.enterText(UnderfiftyMilesField, fiftyMiles);
		}

	public void enterUnder200MilesValue() {
		String twoHundredMiles = radiusData.get("0");
		Reporter.log("Entering under 200 miles value as : " + twoHundredMiles);
		webUtils.enterText(UnderTwoHundredMilesField, twoHundredMiles);
	}


	}

