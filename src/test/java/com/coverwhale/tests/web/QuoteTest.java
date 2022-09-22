package com.coverwhale.tests.web;

import java.util.Map;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.coverwhale.actions.web.CreateQuoteApplicationPage;
import com.coverwhale.actions.web.LoginActions;
import com.coverwhale.actions.web.TransportationActions;
import com.coverwhale.core.BaseConfiguration;
import com.coverwhale.core.DataRecorder;
import com.coverwhale.utils.common.CustomAssertion;
import com.coverwhale.utils.selenium.WebUtils;

public class QuoteTest extends BaseConfiguration {

	private LoginActions loginActions;
	private CreateQuoteApplicationPage quotePageActions;
	private TransportationActions transportActions;
	private WebUtils webUtils;

	@BeforeClass
	public void setUp() {
		loginActions = new LoginActions(driver);
		quotePageActions = new CreateQuoteApplicationPage(driver);
		transportActions = new TransportationActions(driver);
		webUtils = new WebUtils(driver);
	}

	@Test(testName = "TC_01_01", description = "User's mailing address state is not in the list of licensed states")
	public void TC_01_01() {
		// Arrange
		Map<String, Object> testData = DataRecorder.getTestData("TC_01_01");
		Map<String, String> profileData = (Map<String, String>) testData.get("Profile");
		quotePageActions.setQuoteData((Map<String, String>) testData.get("Quote"));

		// Act
		loginActions.login(profileData.get("username"), profileData.get("password"));
		transportActions.openNewQuoteForm();
		quotePageActions.enterYearsOperatinginYourName();
		quotePageActions.enterMailingAddress();
		quotePageActions.enterCity();
		quotePageActions.enterCountry();
		quotePageActions.enterZip();
		quotePageActions.selectState();

		// Assert
		String licensedModalText = quotePageActions.getLicensedModalText();
		CustomAssertion.assertEquals(licensedModalText,
				"We are not yet licensed in this state. We are adding new states all the time. Please contact us with any questions.");
	}

	@Test(testName = "TC_01_02", description = "User's mailing address state is not in the list of licensed states")
	public void TC_01_02() {
		// Arrange
		Map<String, Object> testData = DataRecorder.getTestData("TC_01_02");
		quotePageActions.setQuoteData((Map<String, String>) testData.get("Quote"));

		// Act
		webUtils.refreshBrowser();
		transportActions.openNewQuoteForm();
		quotePageActions.enterYearsOperatinginYourName();
		quotePageActions.enterMailingAddress();
		quotePageActions.enterCity();
		quotePageActions.enterCountry();
		quotePageActions.enterZip();
		quotePageActions.selectState();

		// Assert
		String licensedModalText = quotePageActions.getLicensedModalText();
		CustomAssertion.assertEquals(licensedModalText, "We are not yet licensed in this state. We are adding new states all the time. Please contact us with any questions.");
	}

	@Test(testName = "TC_01_03", description = "User's mailing address state is not in the list of licensed states")
	public void TC_01_03() {
		// Arrange
		Map<String, Object> testData = DataRecorder.getTestData("TC_01_03");
		quotePageActions.setQuoteData((Map<String, String>) testData.get("Quote"));

		// Act
		webUtils.refreshBrowser();
		transportActions.openNewQuoteForm();
		quotePageActions.enterDotNumber();
		quotePageActions.enterMailingAddress();
		quotePageActions.enterCity();
		quotePageActions.enterCountry();
		quotePageActions.enterZip();
		quotePageActions.selectState();

		// Assert
		String licensedModalText = quotePageActions.getLicensedModalText();
		CustomAssertion.assertEquals(licensedModalText, "We are not yet licensed in this state. We are adding new states all the time. Please contact us with any questions.");
	}

	@Test(testName = "TC_01_04", description = "User's mailing address state is not in the list of licensed states")
	public void TC_01_04() {
		// Arrange
		Map<String, Object> testData = DataRecorder.getTestData("TC_01_04");
		quotePageActions.setQuoteData((Map<String, String>) testData.get("Quote"));

		// Act
		webUtils.refreshBrowser();
		transportActions.openNewQuoteForm();
		quotePageActions.enterDotNumber();

		// Assert
		String licensedModalText = quotePageActions.getLicensedModalText();
		CustomAssertion.assertEquals(licensedModalText, "We are not yet licensed in this state. We are adding new states all the time. Please contact us with any questions.");
	}

	@Test(testName = "TC_01_05", description = "User's mailing address state is not in the list of licensed states")
	public void TC_01_05() {
		// Arrange
		Map<String, Object> testData = DataRecorder.getTestData("TC_01_05");
		quotePageActions.setQuoteData((Map<String, String>) testData.get("Quote"));

		// Act
		webUtils.refreshBrowser();
		transportActions.openNewQuoteForm();
		quotePageActions.enterYearsOperatinginYourName();
		quotePageActions.enterMailingAddress();
		quotePageActions.enterCity();
		quotePageActions.enterCountry();
		quotePageActions.enterZip();
		quotePageActions.selectState();

		// Assert
		String licensedModalText = quotePageActions.getLicensedModalText();
		CustomAssertion.assertEquals(licensedModalText, "We are not yet licensed in this state. We are adding new states all the time. Please contact us with any questions.");
	}
}
