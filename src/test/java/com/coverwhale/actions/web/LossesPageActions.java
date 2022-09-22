package com.coverwhale.actions.web;

import com.coverwhale.utils.selenium.WebUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Reporter;

/**
 * It contains all actions that can be performed on Home page of the application.
 *///textarea[@name='trailers_list']
public class LossesPageActions {

	private static final Logger LOGGER = LoggerFactory.getLogger(LossesPageActions.class);
	private WebDriver driver;
	private WebUtils webUtils;

	// locators

		// year 1

	@FindBy(id = "loss_count_al_year1")
	WebElement autoLiabilityLossCountYear1Field;

	@FindBy(xpath = "//div[./input[@id='loss_paid_al_year1']]/input[contains(@id,'mony')]")
	WebElement autoLiabilityLossPaidYear1Field;

	@FindBy(id = "loss_count_apd_year1")
	WebElement physicalDamageLossCountYear1Field;

	@FindBy(xpath = "//div[./input[@id='loss_paid_apd_year1']]/input[contains(@id,'mony')]")
	WebElement physicalDamageLossPaidYear1Field;

	@FindBy(id = "loss_count_mtc_year1")
	WebElement cargoLossCountYear1Field;

	@FindBy(xpath = "//div[./input[@id='loss_paid_mtc_year1']]/input[contains(@id,'mony')]")
	WebElement cargoLossPaidYear1Field;

	@FindBy(id = "loss_count_tgl_year1")
	WebElement truckersGeneralLiabilityLossCountYear1Field;

	@FindBy(xpath = "//div[./input[@id='loss_paid_tgl_year1']]/input[contains(@id,'mony')]")
	WebElement truckersGeneralLiabilityLossPaidYear1Field;


	// year 2

	@FindBy(id = "loss_count_al_year2")
	WebElement autoLiabilityLossCountYear2Field;

	@FindBy(xpath = "//div[./input[@id='loss_paid_al_year2']]/input[contains(@id,'mony')]")
	WebElement autoLiabilityLossPaidYear2Field;

	@FindBy(id = "loss_count_apd_year2")
	WebElement physicalDamageLossCountYear2Field;

	@FindBy(xpath = "//div[./input[@id='loss_paid_apd_year2']]/input[contains(@id,'mony')]")
	WebElement physicalDamageLossPaidYear2Field;

	@FindBy(id = "loss_count_mtc_year2")
	WebElement cargoLossCountYear2Field;

	@FindBy(xpath = "//div[./input[@id='loss_paid_mtc_year2']]/input[contains(@id,'mony')]")
	WebElement cargoLossPaidYear2Field;

	@FindBy(id = "loss_count_tgl_year2")
	WebElement truckersGeneralLiabilityLossCountYear2Field;

	@FindBy(xpath = "//div[./input[@id='loss_paid_tgl_year2']]/input[contains(@id,'mony')]")
	WebElement truckersGeneralLiabilityLossPaidYear2Field;


	// year 3

	@FindBy(id = "loss_count_al_year3")
	WebElement autoLiabilityLossCountYear3Field;

	@FindBy(xpath = "//div[./input[@id='loss_paid_al_year3']]/input[contains(@id,'mony')]")
	WebElement autoLiabilityLossPaidYear3Field;

	@FindBy(id = "loss_count_apd_year3")
	WebElement physicalDamageLossCountYear3Field;

	@FindBy(xpath = "//div[./input[@id='loss_paid_apd_year3']]/input[contains(@id,'mony')]")
	WebElement physicalDamageLossPaidYear3Field;

	@FindBy(id = "loss_count_mtc_year3")
	WebElement cargoLossCountYear3Field;

	@FindBy(xpath = "//div[./input[@id='loss_paid_mtc_year3']]/input[contains(@id,'mony')]")
	WebElement cargoLossPaidYear3Field;

	@FindBy(id = "loss_count_tgl_year3")
	WebElement truckersGeneralLiabilityLossCountYear3Field;

	@FindBy(xpath = "//div[./input[@id='loss_paid_tgl_year3']]/input[contains(@id,'mony')]")
	WebElement truckersGeneralLiabilityLossPaidYear3Field;


	// year 4

	@FindBy(id = "loss_count_al_year4")
	WebElement autoLiabilityLossCountYear4Field;

	@FindBy(xpath = "//div[./input[@id='loss_paid_al_year4']]/input[contains(@id,'mony')]")
	WebElement autoLiabilityLossPaidYear4Field;

	@FindBy(id = "loss_count_apd_year4")
	WebElement physicalDamageLossCountYear4Field;

	@FindBy(xpath = "//div[./input[@id='loss_paid_apd_year4']]/input[contains(@id,'mony')]")
	WebElement physicalDamageLossPaidYear4Field;

	@FindBy(id = "loss_count_mtc_year4")
	WebElement cargoLossCountYear4Field;

	@FindBy(xpath = "//div[./input[@id='loss_paid_mtc_year4']]/input[contains(@id,'mony')]")
	WebElement cargoLossPaidYear4Field;

	@FindBy(id = "loss_count_tgl_year4")
	WebElement truckersGeneralLiabilityLossCountYear4Field;

	@FindBy(xpath = "//div[./input[@id='loss_paid_tgl_year4']]/input[contains(@id,'mony')]")
	WebElement truckersGeneralLiabilityLossPaidYear4Field;


	// year 5

	@FindBy(id = "loss_count_al_year5")
	WebElement autoLiabilityLossCountYear5Field;

	@FindBy(xpath = "//div[./input[@id='loss_paid_al_year5']]/input[contains(@id,'mony')]")
	WebElement autoLiabilityLossPaidYear5Field;

	@FindBy(id = "loss_count_apd_year5")
	WebElement physicalDamageLossCountYear5Field;

	@FindBy(xpath = "//div[./input[@id='loss_paid_apd_year5']]/input[contains(@id,'mony')]")
	WebElement physicalDamageLossPaidYear5Field;

	@FindBy(id = "loss_count_mtc_year5")
	WebElement cargoLossCountYear5Field;

	@FindBy(xpath = "//div[./input[@id='loss_paid_mtc_year5']]/input[contains(@id,'mony')]")
	WebElement cargoLossPaidYear5Field;

	@FindBy(id = "loss_count_tgl_year5")
	WebElement truckersGeneralLiabilityLossCountYear5Field;

	@FindBy(xpath = "//div[./input[@id='loss_paid_tgl_year5']]/input[contains(@id,'mony')]")
	WebElement truckersGeneralLiabilityLossPaidYear5Field;


	// general page locators

	@FindBy(xpath = "//label[@for='loss_confirmed_year3_Y']")
	WebElement lossesConfirmedButton;

	@FindBy(xpath = "//label[@for='loss_confirmed_year1_N']")
	WebElement lossInfoPendingButton;

	@FindBy(xpath = "//div[contains(@action,'updateLosses')]//button[string()='Next']")
	WebElement nextButton;

	// METHODS

		// Year 1

	public void populateAutoLiabilityLossCountYear1Field(String autoLiabilityLossCountYear1) {
		Reporter.log("Populating the Auto Liability Loss Count Year 1 field");
		LOGGER.info("Writing " + autoLiabilityLossCountYear1 + " in the Auto Liability Loss Count Year 1 field");
		webUtils.enterText(autoLiabilityLossCountYear1Field, autoLiabilityLossCountYear1);
	}

	public void populateAutoLiabilityLossPaidYear1Field(String autoLiabilityLossPaidYear1) {
		Reporter.log("Populating the Auto Liability Loss Paid Year 1 field");
		LOGGER.info("Writing " + autoLiabilityLossPaidYear1 + " in the Auto Liability Loss Paid Year 1 field");
		webUtils.enterText(autoLiabilityLossPaidYear1Field, autoLiabilityLossPaidYear1);
	}

	public void populatePhysicalDamageLossCountYear1Field(String physicalDamageLossCountYear1) {
		Reporter.log("Populating the Physical Damage Loss Count Year 1 field");
		LOGGER.info("Writing " + physicalDamageLossCountYear1 + " in the PhysicalDamage Loss Count Year 1 field");
		webUtils.enterText(physicalDamageLossCountYear1Field, physicalDamageLossCountYear1);
	}

	public void populatePhysicalDamageLossPaidYear1Field(String physicalDamageLossPaidYear1) {
		Reporter.log("Populating the Physical Damage Loss Paid Year 1 field");
		LOGGER.info("Writing " + physicalDamageLossPaidYear1 + " in the PhysicalDamage Loss Paid Year 1 field");
		webUtils.enterText(physicalDamageLossPaidYear1Field, physicalDamageLossPaidYear1);
	}

	public void populateCargoLossCountYear1Field(String cargoLossCountYear1) {
		Reporter.log("Populating the Cargo Loss Count Year 1 field");
		LOGGER.info("Writing " + cargoLossCountYear1 + " in the Cargo Loss Count Year 1 field");
		webUtils.enterText(cargoLossCountYear1Field, cargoLossCountYear1);
	}

	public void populateCargoLossPaidYear1Field(String cargoLossPaidYear1) {
		Reporter.log("Populating the Cargo Loss Paid Year 1 field");
		LOGGER.info("Writing " + cargoLossPaidYear1 + " in the Cargo Loss Paid Year 1 field");
		webUtils.enterText(cargoLossPaidYear1Field, cargoLossPaidYear1);
	}

	public void populateTruckersGeneralLiabilityLossCountYear1Field(String truckersGeneralLiabilityLossCountYear1) {
		Reporter.log("Populating the Truckers General Liability Loss Count Year 1 field");
		LOGGER.info("Writing " + truckersGeneralLiabilityLossCountYear1 + " in the Truckers General Liability Loss Count Year 1 field");
		webUtils.enterText(truckersGeneralLiabilityLossCountYear1Field, truckersGeneralLiabilityLossCountYear1);
	}

	public void populateTruckersGeneralLiabilityLossPaidYear1Field(String truckersGeneralLiabilityLossPaidYear1) {
		Reporter.log("Populating the Truckers General Liability Loss Paid Year 1 field");
		LOGGER.info("Writing " + truckersGeneralLiabilityLossPaidYear1 + " in the Truckers General Liability Loss Paid Year 1 field");
		webUtils.enterText(truckersGeneralLiabilityLossPaidYear1Field, truckersGeneralLiabilityLossPaidYear1);
	}

	// Year 2

	public void populateAutoLiabilityLossCountYear2Field(String autoLiabilityLossCountYear2) {
		Reporter.log("Populating the Auto Liability Loss Count Year 2 field");
		LOGGER.info("Writing " + autoLiabilityLossCountYear2 + " in the Auto Liability Loss Count Year 2 field");
		webUtils.enterText(autoLiabilityLossCountYear2Field, autoLiabilityLossCountYear2);
	}

	public void populateAutoLiabilityLossPaidYear2Field(String autoLiabilityLossPaidYear2) {
		Reporter.log("Populating the Auto Liability Loss Paid Year 2 field");
		LOGGER.info("Writing " + autoLiabilityLossPaidYear2 + " in the Auto Liability Loss Paid Year 2 field");
		webUtils.enterText(autoLiabilityLossPaidYear2Field, autoLiabilityLossPaidYear2);
	}

	public void populatePhysicalDamageLossCountYear2Field(String physicalDamageLossCountYear2) {
		Reporter.log("Populating the Physical Damage Loss Count Year 2 field");
		LOGGER.info("Writing " + physicalDamageLossCountYear2 + " in the PhysicalDamage Loss Count Year 2 field");
		webUtils.enterText(physicalDamageLossCountYear2Field, physicalDamageLossCountYear2);
	}

	public void populatePhysicalDamageLossPaidYear2Field(String physicalDamageLossPaidYear2) {
		Reporter.log("Populating the Physical Damage Loss Paid Year 2 field");
		LOGGER.info("Writing " + physicalDamageLossPaidYear2 + " in the PhysicalDamage Loss Paid Year 2 field");
		webUtils.enterText(physicalDamageLossPaidYear2Field, physicalDamageLossPaidYear2);
	}

	public void populateCargoLossCountYear2Field(String cargoLossCountYear2) {
		Reporter.log("Populating the Cargo Loss Count Year 2 field");
		LOGGER.info("Writing " + cargoLossCountYear2 + " in the Cargo Loss Count Year 2 field");
		webUtils.enterText(cargoLossCountYear2Field, cargoLossCountYear2);
	}

	public void populateCargoLossPaidYear2Field(String cargoLossPaidYear2) {
		Reporter.log("Populating the Cargo Loss Paid Year 2 field");
		LOGGER.info("Writing " + cargoLossPaidYear2 + " in the Cargo Loss Paid Year 2 field");
		webUtils.enterText(cargoLossPaidYear2Field, cargoLossPaidYear2);
	}

	public void populateTruckersGeneralLiabilityLossCountYear2Field(String truckersGeneralLiabilityLossCountYear2) {
		Reporter.log("Populating the Truckers General Liability Loss Count Year 2 field");
		LOGGER.info("Writing " + truckersGeneralLiabilityLossCountYear2 + " in the Truckers General Liability Loss Count Year 2 field");
		webUtils.enterText(truckersGeneralLiabilityLossCountYear2Field, truckersGeneralLiabilityLossCountYear2);
	}

	public void populateTruckersGeneralLiabilityLossPaidYear2Field(String truckersGeneralLiabilityLossPaidYear2) {
		Reporter.log("Populating the Truckers General Liability Loss Paid Year 2 field");
		LOGGER.info("Writing " + truckersGeneralLiabilityLossPaidYear2 + " in the Truckers General Liability Loss Paid Year 2 field");
		webUtils.enterText(truckersGeneralLiabilityLossPaidYear2Field, truckersGeneralLiabilityLossPaidYear2);
	}

	// Year 3

	public void populateAutoLiabilityLossCountYear3Field(String autoLiabilityLossCountYear3) {
		Reporter.log("Populating the Auto Liability Loss Count Year 3 field");
		LOGGER.info("Writing " + autoLiabilityLossCountYear3 + " in the Auto Liability Loss Count Year 3 field");
		webUtils.enterText(autoLiabilityLossCountYear3Field, autoLiabilityLossCountYear3);
	}

	public void populateAutoLiabilityLossPaidYear3Field(String autoLiabilityLossPaidYear3) {
		Reporter.log("Populating the Auto Liability Loss Paid Year 3 field");
		LOGGER.info("Writing " + autoLiabilityLossPaidYear3 + " in the Auto Liability Loss Paid Year 3 field");
		webUtils.enterText(autoLiabilityLossPaidYear3Field, autoLiabilityLossPaidYear3);
	}

	public void populatePhysicalDamageLossCountYear3Field(String physicalDamageLossCountYear3) {
		Reporter.log("Populating the Physical Damage Loss Count Year 3 field");
		LOGGER.info("Writing " + physicalDamageLossCountYear3 + " in the PhysicalDamage Loss Count Year 3 field");
		webUtils.enterText(physicalDamageLossCountYear3Field, physicalDamageLossCountYear3);
	}

	public void populatePhysicalDamageLossPaidYear3Field(String physicalDamageLossPaidYear3) {
		Reporter.log("Populating the Physical Damage Loss Paid Year 3 field");
		LOGGER.info("Writing " + physicalDamageLossPaidYear3 + " in the PhysicalDamage Loss Paid Year 3 field");
		webUtils.enterText(physicalDamageLossPaidYear3Field, physicalDamageLossPaidYear3);
	}

	public void populateCargoLossCountYear3Field(String cargoLossCountYear3) {
		Reporter.log("Populating the Cargo Loss Count Year 3 field");
		LOGGER.info("Writing " + cargoLossCountYear3 + " in the Cargo Loss Count Year 3 field");
		webUtils.enterText(cargoLossCountYear3Field, cargoLossCountYear3);
	}

	public void populateCargoLossPaidYear3Field(String cargoLossPaidYear3) {
		Reporter.log("Populating the Cargo Loss Paid Year 3 field");
		LOGGER.info("Writing " + cargoLossPaidYear3 + " in the Cargo Loss Paid Year 3 field");
		webUtils.enterText(cargoLossPaidYear3Field, cargoLossPaidYear3);
	}

	public void populateTruckersGeneralLiabilityLossCountYear3Field(String truckersGeneralLiabilityLossCountYear3) {
		Reporter.log("Populating the Truckers General Liability Loss Count Year 3 field");
		LOGGER.info("Writing " + truckersGeneralLiabilityLossCountYear3 + " in the Truckers General Liability Loss Count Year 3 field");
		webUtils.enterText(truckersGeneralLiabilityLossCountYear3Field, truckersGeneralLiabilityLossCountYear3);
	}

	public void populateTruckersGeneralLiabilityLossPaidYear3Field(String truckersGeneralLiabilityLossPaidYear3) {
		Reporter.log("Populating the Truckers General Liability Loss Paid Year 3 field");
		LOGGER.info("Writing " + truckersGeneralLiabilityLossPaidYear3 + " in the Truckers General Liability Loss Paid Year 3 field");
		webUtils.enterText(truckersGeneralLiabilityLossPaidYear3Field, truckersGeneralLiabilityLossPaidYear3);
	}

	// Year 4

	public void populateAutoLiabilityLossCountYear4Field(String autoLiabilityLossCountYear4) {
		Reporter.log("Populating the Auto Liability Loss Count Year 4 field");
		LOGGER.info("Writing " + autoLiabilityLossCountYear4 + " in the Auto Liability Loss Count Year 4 field");
		webUtils.enterText(autoLiabilityLossCountYear4Field, autoLiabilityLossCountYear4);
	}

	public void populateAutoLiabilityLossPaidYear4Field(String autoLiabilityLossPaidYear4) {
		Reporter.log("Populating the Auto Liability Loss Paid Year 4 field");
		LOGGER.info("Writing " + autoLiabilityLossPaidYear4 + " in the Auto Liability Loss Paid Year 4 field");
		webUtils.enterText(autoLiabilityLossPaidYear4Field, autoLiabilityLossPaidYear4);
	}

	public void populatePhysicalDamageLossCountYear4Field(String physicalDamageLossCountYear4) {
		Reporter.log("Populating the Physical Damage Loss Count Year 4 field");
		LOGGER.info("Writing " + physicalDamageLossCountYear4 + " in the PhysicalDamage Loss Count Year 4 field");
		webUtils.enterText(physicalDamageLossCountYear4Field, physicalDamageLossCountYear4);
	}

	public void populatePhysicalDamageLossPaidYear4Field(String physicalDamageLossPaidYear4) {
		Reporter.log("Populating the Physical Damage Loss Paid Year 4 field");
		LOGGER.info("Writing " + physicalDamageLossPaidYear4 + " in the PhysicalDamage Loss Paid Year 4 field");
		webUtils.enterText(physicalDamageLossPaidYear4Field, physicalDamageLossPaidYear4);
	}

	public void populateCargoLossCountYear4Field(String cargoLossCountYear4) {
		Reporter.log("Populating the Cargo Loss Count Year 4 field");
		LOGGER.info("Writing " + cargoLossCountYear4 + " in the Cargo Loss Count Year 4 field");
		webUtils.enterText(cargoLossCountYear4Field, cargoLossCountYear4);
	}

	public void populateCargoLossPaidYear4Field(String cargoLossPaidYear4) {
		Reporter.log("Populating the Cargo Loss Paid Year 4 field");
		LOGGER.info("Writing " + cargoLossPaidYear4 + " in the Cargo Loss Paid Year 4 field");
		webUtils.enterText(cargoLossPaidYear4Field, cargoLossPaidYear4);
	}

	public void populateTruckersGeneralLiabilityLossCountYear4Field(String truckersGeneralLiabilityLossCountYear4) {
		Reporter.log("Populating the Truckers General Liability Loss Count Year 4 field");
		LOGGER.info("Writing " + truckersGeneralLiabilityLossCountYear4 + " in the Truckers General Liability Loss Count Year 4 field");
		webUtils.enterText(truckersGeneralLiabilityLossCountYear4Field, truckersGeneralLiabilityLossCountYear4);
	}

	public void populateTruckersGeneralLiabilityLossPaidYear4Field(String truckersGeneralLiabilityLossPaidYear4) {
		Reporter.log("Populating the Truckers General Liability Loss Paid Year 4 field");
		LOGGER.info("Writing " + truckersGeneralLiabilityLossPaidYear4 + " in the Truckers General Liability Loss Paid Year 4 field");
		webUtils.enterText(truckersGeneralLiabilityLossPaidYear4Field, truckersGeneralLiabilityLossPaidYear4);
	}

	// Year 5

	public void populateAutoLiabilityLossCountYear5Field(String autoLiabilityLossCountYear5) {
		Reporter.log("Populating the Auto Liability Loss Count Year 5 field");
		LOGGER.info("Writing " + autoLiabilityLossCountYear5 + " in the Auto Liability Loss Count Year 5 field");
		webUtils.enterText(autoLiabilityLossCountYear5Field, autoLiabilityLossCountYear5);
	}

	public void populateAutoLiabilityLossPaidYear5Field(String autoLiabilityLossPaidYear5) {
		Reporter.log("Populating the Auto Liability Loss Paid Year 5 field");
		LOGGER.info("Writing " + autoLiabilityLossPaidYear5 + " in the Auto Liability Loss Paid Year 5 field");
		webUtils.enterText(autoLiabilityLossPaidYear5Field, autoLiabilityLossPaidYear5);
	}

	public void populatePhysicalDamageLossCountYear5Field(String physicalDamageLossCountYear5) {
		Reporter.log("Populating the Physical Damage Loss Count Year 5 field");
		LOGGER.info("Writing " + physicalDamageLossCountYear5 + " in the PhysicalDamage Loss Count Year 5 field");
		webUtils.enterText(physicalDamageLossCountYear5Field, physicalDamageLossCountYear5);
	}

	public void populatePhysicalDamageLossPaidYear5Field(String physicalDamageLossPaidYear5) {
		Reporter.log("Populating the Physical Damage Loss Paid Year 5 field");
		LOGGER.info("Writing " + physicalDamageLossPaidYear5 + " in the PhysicalDamage Loss Paid Year 5 field");
		webUtils.enterText(physicalDamageLossPaidYear5Field, physicalDamageLossPaidYear5);
	}

	public void populateCargoLossCountYear5Field(String cargoLossCountYear5) {
		Reporter.log("Populating the Cargo Loss Count Year 5 field");
		LOGGER.info("Writing " + cargoLossCountYear5 + " in the Cargo Loss Count Year 5 field");
		webUtils.enterText(cargoLossCountYear5Field, cargoLossCountYear5);
	}

	public void populateCargoLossPaidYear5Field(String cargoLossPaidYear5) {
		Reporter.log("Populating the Cargo Loss Paid Year 5 field");
		LOGGER.info("Writing " + cargoLossPaidYear5 + " in the Cargo Loss Paid Year 5 field");
		webUtils.enterText(cargoLossPaidYear5Field, cargoLossPaidYear5);
	}

	public void populateTruckersGeneralLiabilityLossCountYear5Field(String truckersGeneralLiabilityLossCountYear5) {
		Reporter.log("Populating the Truckers General Liability Loss Count Year 5 field");
		LOGGER.info("Writing " + truckersGeneralLiabilityLossCountYear5 + " in the Truckers General Liability Loss Count Year 5 field");
		webUtils.enterText(truckersGeneralLiabilityLossCountYear5Field, truckersGeneralLiabilityLossCountYear5);
	}

	public void populateTruckersGeneralLiabilityLossPaidYear5Field(String truckersGeneralLiabilityLossPaidYear5) {
		Reporter.log("Populating the Truckers General Liability Loss Paid Year 5 field");
		LOGGER.info("Writing " + truckersGeneralLiabilityLossPaidYear5 + " in the Truckers General Liability Loss Paid Year 5 field");
		webUtils.enterText(truckersGeneralLiabilityLossPaidYear5Field, truckersGeneralLiabilityLossPaidYear5);
	}

		// Page

	public void selectLossesConfirmedOption() {
		Reporter.log("Selecting the Losses Confirmed option");
		LOGGER.info("Clicking the Losses Confirmed button");
		webUtils.click(lossesConfirmedButton);
	}

	public void selectLossesInfoPendingOption() {
		Reporter.log("Selecting the Losses Info Pending option");
		LOGGER.info("Clicking the Losses Info Pending button");
		webUtils.click(lossInfoPendingButton);
	}

	public void proceedToNextStep() {
		Reporter.log("Clicking the Next button");
		webUtils.click(nextButton);
	}


	public LossesPageActions(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		webUtils = new WebUtils(driver);
	}
























	
	
}
