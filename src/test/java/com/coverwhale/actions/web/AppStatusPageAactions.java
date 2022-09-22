package com.coverwhale.actions.web;

import java.util.List;
import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Reporter;

import com.coverwhale.utils.selenium.WebUtils;

/**
 * It contains all actions that can be performed on Home page of the application.
 */
public class AppStatusPageAactions {

	private static final Logger LOGGER = LoggerFactory.getLogger(AppStatusPageAactions.class);
	private WebDriver driver;
	private WebUtils webUtils;

	// broker contact modal
	@FindBy(css = "span[id^='select2-company']")
	public WebElement companyDropdown;
	
	@FindBy(xpath = "//input[@class='select2-search__field' and contains(@aria-controls, 'company_id')]")
	public WebElement companyInputBox;
	
	@FindBy(css = "ul[id^='select2-company_id'] li")
	public List<WebElement> companyResultsList;
	
	@FindBy(css = "span[id^='select2-submitted_user_id']")
	public WebElement userDropdown;
	
	@FindBy(xpath = "//input[@class='select2-search__field' and contains(@aria-controls, 'user_id')]")
	public WebElement userInputBox;
	
	@FindBy(css = "ul[id^='select2-submitted_user_id'] li")
	public List<WebElement> userResultsList;

	@FindBy(css = "#updateSubmittedUserForm button")
	public WebElement saveButton;

	
// TODO remove  hard waits here
	public void saveBrokerContactDetails (String company, String user) {
		Reporter.log("Selecting company: " + company + " and user: " + user);
		
		if (!company.isBlank()) {
			webUtils.click(companyDropdown);
			webUtils.waitForElementVisibility(companyInputBox, 5);
			webUtils.enterText(companyInputBox, company);
			webUtils.sleep(2);

			Optional<WebElement> companyResults = companyResultsList.stream().filter(companyResult -> companyResult.getAttribute("innerText").equals(company)).findFirst();
			if (companyResults.isPresent()) {
				webUtils.click(companyResults.get());
			}
		}
		
		if (!user.isBlank()) {
			webUtils.click(userDropdown);
			webUtils.waitForElementVisibility(userInputBox, 5);
			webUtils.enterText(userInputBox, user);
			webUtils.sleep(2);
			Optional<WebElement> userResults = userResultsList.stream().filter(userResult -> userResult.getAttribute("innerText").contains(user)).findFirst();
			if (userResults.isPresent()) {
				webUtils.click(userResults.get());
			}
			 webUtils.click(saveButton);
		}
	
		 webUtils.sleep(2);
	}
	

	public AppStatusPageAactions(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		webUtils = new WebUtils(driver);
	}

	
	
}
