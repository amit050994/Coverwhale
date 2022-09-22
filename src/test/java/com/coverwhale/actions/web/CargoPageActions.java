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
public class CargoPageActions {

	private static final Logger LOGGER = LoggerFactory.getLogger(CargoPageActions.class);
	private WebDriver driver;
	private WebUtils webUtils;

	// write your locators here

	@FindBy(css = "span[aria-labelledby='select2-newcommodity1title-container']")
	public WebElement commodity1Span;

	@FindBy(xpath = "//select[@id='mtc_limit_option']")
	public WebElement cargoLimit;
	
	@FindBy(css = "select[id='newcommodity.1.title']")
	public WebElement commodity1Dropdown;

	@FindBy(css = "input[id='newcommodity.1.percentage']")
	public WebElement commodity1PercentageField;
	
	@FindBy(xpath = "//div[@id='list-cargo']//button[.='Next']")
	public WebElement nextButton;
	
	@FindBy(id = "list-cargo-list")
	public WebElement cargoTabButton;

	@FindBy(css = "label[for='refrigeration_Y']")
	public WebElement yesRefrigeratedButton;


	public Map<String, String> cargoData = new LinkedHashMap<>();

	public CargoPageActions(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		webUtils = new WebUtils(driver);
	}

	public void setCargoData(Map<String, String> cargoDataForTestCase) {
		cargoData = cargoDataForTestCase;
	}
	
	public void clickNextButton() {
		Reporter.log("Clicking Next button");
		webUtils.retryingClick(nextButton);
	}
	
	public void selectCommodity1Dropdown() {
		String commodity1 = cargoData.get("Commodity 1");
		Reporter.log("Selecting Commodity # 1 as: " + commodity1);
		webUtils.jsClick(commodity1Span);
		webUtils.selectDropDownByValue(commodity1Dropdown, commodity1);
	}
	
	public void enterCommodity1Percentage() {
		String commodity1Percent = cargoData.get("Commodity 1 %");
		Reporter.log("Entering Commodity # 1 percentage: " + commodity1Percent);
		webUtils.enterText(commodity1PercentageField, commodity1Percent);
	}

	public void setLimitMotorTruckCargoDropdown() {
		Reporter.log("Selecting Limit Motor Truck Cargo");
		webUtils.selectDropDownByValue(cargoLimit,"250000");
	}
	
	public void setLimitMotorTruckCargoDropdown200000() {
		Reporter.log("Selecting Limit Motor Truck Cargo as $200000");
		webUtils.selectDropDownByValue(cargoLimit,"200000");
	}

	public void clickCargoTab() {
		Reporter.log("Clicking Cargo tab in left side panel");
		webUtils.waitForElementVisibility(cargoTabButton, 5);
		webUtils.retryingClick(cargoTabButton);
	}

	public void clickYesRefrigeratedGoodsHauledButton() {
		Reporter.log("Clicking on [Yes Refrigerated Goods Hauled] button");
		webUtils.waitForElementVisibility(yesRefrigeratedButton, 5);
		webUtils.click(yesRefrigeratedButton);
	}

}
