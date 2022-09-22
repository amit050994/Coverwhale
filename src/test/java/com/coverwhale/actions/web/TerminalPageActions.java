package com.coverwhale.actions.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Reporter;

import com.coverwhale.utils.selenium.WebUtils;

public class TerminalPageActions {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TerminalPageActions.class);
	private WebDriver driver;
	private WebUtils webUtils;

	@FindBy(css = "#list-terminals .submissionFormInput.nextButton")
	WebElement nextButton;


	public TerminalPageActions(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		webUtils = new WebUtils(driver);
	}

	public void clickNextButton() {
		Reporter.log("Clicking on Next button");
		webUtils.retryingClick(nextButton);
	}

}
