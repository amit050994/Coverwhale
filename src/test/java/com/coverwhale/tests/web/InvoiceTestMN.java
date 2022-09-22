package com.coverwhale.tests.web;

import java.util.Date;
import java.util.Map;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.coverwhale.actions.web.AdminFeesPageActions;
import com.coverwhale.actions.web.AdminRatesPageActions;
import com.coverwhale.actions.web.AppStatusPageAactions;
import com.coverwhale.actions.web.CargoPageActions;
import com.coverwhale.actions.web.CreateQuoteApplicationPage;
import com.coverwhale.actions.web.DriversPageActions;
import com.coverwhale.actions.web.InsuredPageActions;
import com.coverwhale.actions.web.LimitsPageActions;
import com.coverwhale.actions.web.LoginActions;
import com.coverwhale.actions.web.LossesPageActions;
import com.coverwhale.actions.web.OperationsPageActions;
import com.coverwhale.actions.web.ProducerPageActions;
import com.coverwhale.actions.web.RadiusPageActions;
import com.coverwhale.actions.web.RatesPageActions;
import com.coverwhale.actions.web.RequestToBindPageActions;
import com.coverwhale.actions.web.ReviewPageActions;
import com.coverwhale.actions.web.SubmissionPageActions;
import com.coverwhale.actions.web.SubmissionStatusButtonsPageActions;
import com.coverwhale.actions.web.SummaryPageActions;
import com.coverwhale.actions.web.TerminalPageActions;
import com.coverwhale.actions.web.TrailersPageActions;
import com.coverwhale.actions.web.TransportationActions;
import com.coverwhale.actions.web.VehiclePageActions;
import com.coverwhale.core.BaseConfiguration;
import com.coverwhale.core.DataRecorder;
import com.coverwhale.core.InvoicePDFReader;
import com.coverwhale.utils.common.DateUtils;
import com.coverwhale.utils.selenium.WebUtils;
import com.coverwhale.validators.web.InvoiceDataValidatorMN;
import com.coverwhale.core.QuotePdfReader;
import com.coverwhale.validators.web.quotes.QuoteDataValidatorMN;

public class InvoiceTestMN extends BaseConfiguration {

    private LoginActions loginActions;
    private CreateQuoteApplicationPage quotePageActions;
    private TransportationActions transportActions;
    private AppStatusPageAactions appStatusPageActions;
    private SubmissionStatusButtonsPageActions submissionStatusButtons;
    private SubmissionPageActions submissionPageActions;
    private InsuredPageActions insuredPageActions;
    private ProducerPageActions producerPageActions;
    private LimitsPageActions limitPageActions;
    private OperationsPageActions operationPageActions;
    private RadiusPageActions radiusPageActions;
    private CargoPageActions cargoPageActions;
    private TerminalPageActions terminalPageActions;
    private VehiclePageActions vehiclePageActions;
    private TrailersPageActions trailerPageActions;
    private DriversPageActions driverPageActions;
    private LossesPageActions lossesPageActions;
    private RatesPageActions ratesPageActions;
    private SummaryPageActions summaryPageActions;
    private AdminRatesPageActions adminRatesPageActions;
    private AdminFeesPageActions adminFeesPageActions;
    private ReviewPageActions reviewPageActions;
    private RequestToBindPageActions requestBindPageActions;
    private InvoiceDataValidatorMN invoiceDataValidator;
    private QuoteDataValidatorMN quoteDataValidator;
    private WebUtils webUtils;

    @BeforeClass
    public void setUp() {
        loginActions = new LoginActions(driver);
        quotePageActions = new CreateQuoteApplicationPage(driver);
        transportActions = new TransportationActions(driver);
        appStatusPageActions = new AppStatusPageAactions(driver);
        submissionStatusButtons = new SubmissionStatusButtonsPageActions(driver);
        submissionPageActions = new SubmissionPageActions(driver);
        insuredPageActions = new InsuredPageActions(driver);
        producerPageActions = new ProducerPageActions(driver);
        limitPageActions = new LimitsPageActions(driver);
        operationPageActions = new OperationsPageActions(driver);
        radiusPageActions = new RadiusPageActions(driver);
        cargoPageActions = new CargoPageActions(driver);
        terminalPageActions = new TerminalPageActions(driver);
        vehiclePageActions = new VehiclePageActions(driver);
        trailerPageActions = new TrailersPageActions(driver);
        driverPageActions = new DriversPageActions(driver);
        lossesPageActions = new LossesPageActions(driver);
        ratesPageActions = new RatesPageActions(driver);
        summaryPageActions = new SummaryPageActions(driver);
        adminRatesPageActions = new AdminRatesPageActions(driver);
        adminFeesPageActions = new AdminFeesPageActions(driver);
        reviewPageActions = new ReviewPageActions(driver);
        requestBindPageActions = new RequestToBindPageActions(driver);
        invoiceDataValidator = new InvoiceDataValidatorMN();
        quoteDataValidator = new QuoteDataValidatorMN();

        webUtils = new WebUtils(driver);
    }

    @Test(testName = "TC_13_01", description = "New Business")
    public void TC_13_01() {
        // Arrange
        Map<String, Object> testData = DataRecorder.getTestData("TC_13_01");
        Map<String, String> CargoData = (Map<String, String>) testData.get("Cargo");
        Map<String, String> profileData = (Map<String, String>) testData.get("Profile");
        Map<String, String> quoteData = (Map<String, String>) testData.get("Quote");
        quotePageActions.setQuoteData(quoteData);

        // Quote form
        loginActions.login(profileData.get("username"), profileData.get("password"));
        transportActions.openNewQuoteForm();
        quotePageActions.enterDotNumber();
        quotePageActions.enterYearsOperatinginYourName();
        webUtils.sleep(2);
        quotePageActions.selectNoOfTrucks();
        quotePageActions.enterValueofTrucks();
        quotePageActions.selectNoOfTrailers();
        quotePageActions.enterValueOfTrailers();
        quotePageActions.agreeToTermsAndUse();
        quotePageActions.clickNextButton();
        webUtils.sleep(2);

        // Save broker details
        appStatusPageActions.saveBrokerContactDetails("", "Anastasia");
        webUtils.sleep(2);

        // Resume app to quote
        submissionStatusButtons.clickResumeAppToQuoteButton();

        // Submission page
        Map<String, String> submissionData = (Map<String, String>) testData.get("Submission");
        submissionPageActions.selectAutoLiability(submissionData.get("PIP"), submissionData.get("UM/PD"));
        submissionPageActions.clickAutomobilePhysicalDamageCheckbox();
        submissionPageActions.clickMotorTruckCargoCheckbox();
        submissionPageActions.clickNextButton();
        webUtils.sleep(2);

        // Insured page
        insuredPageActions.setInsuredData((Map<String, String>) testData.get("Insured"));
        insuredPageActions.clickDashcamAddressSameAsMailingAddressCB();
        insuredPageActions.clickNextButton();
        webUtils.sleep(2);

        // Producer page
        producerPageActions.clickNextButton();
        webUtils.sleep(3);

        // Limits page
        limitPageActions.clickNextButton();
        webUtils.sleep(2);

        // Operations page
        operationPageActions.setOperationData((Map<String, String>) testData.get("Operations"));
        operationPageActions.selectFilingStateAutoliability("No");
        operationPageActions.selectFederalFilingsForAutoLiability();
        operationPageActions.selectLocalTruckerCheckbox();
        operationPageActions.selectInEligibleOperation();
        operationPageActions.clickNextButton();
        webUtils.sleep(2);

        // Radius page
        radiusPageActions.setRadiusData((Map<String, String>) testData.get("Radius"));
        radiusPageActions.enter500MilesPlusValue();
        radiusPageActions.clickNextButton();
        webUtils.sleep(2);

        // Cargo page
        Map<String, String> cargoData = (Map<String, String>) testData.get("Cargo");
        cargoData.put("Commodity 1", "building_materials");
        cargoPageActions.setCargoData(cargoData);
        cargoPageActions.selectCommodity1Dropdown();
        cargoPageActions.enterCommodity1Percentage();
        cargoPageActions.clickNextButton();
        webUtils.sleep(2);

        // Terminal page
        terminalPageActions.clickNextButton();
        webUtils.sleep(2);

        // Vehicle Page
        vehiclePageActions.setVehicleData((Map<String, String>) testData.get("Vehicles"));
        vehiclePageActions.clickAddVehicleButton();
        webUtils.sleep(3);
        vehiclePageActions.enterVIN();
        vehiclePageActions.enterVehicleYear();
        vehiclePageActions.enterMakeOrManufacturer();
        vehiclePageActions.enterModel();
        vehiclePageActions.enterVehicleValue();
        vehiclePageActions.selectVehicleClass();
        vehiclePageActions.selectVehicleBodyType();
        vehiclePageActions.clickAddVehicleSaveButton();
        webUtils.sleep(3);
        vehiclePageActions.clickNextButton();
        webUtils.sleep(3);

        // Trailer page
        trailerPageActions.clickNextButton();
        webUtils.sleep(3);

        // Drivers page
        Map<String, String> driverData = (Map<String, String>) testData.get("Drivers");
        driverData.put("Driver Date of Birth", "12/11/1990");  // TODO to fix this in excel reading code
        driverPageActions.setDriverData(driverData);
        webUtils.sleep(2);
        driverPageActions.openAddDriverModal();
        driverPageActions.enterDriverFirstName();
        driverPageActions.enterDriverLastName();
        driverPageActions.enterDriverLicenceNumber();
        driverPageActions.enterDriverDateOfBirth();
        driverPageActions.enterDriverYearsOfExperience();
        driverPageActions.enterNumberOfAccidents();
        driverPageActions.enterNumberOfViolations();
        driverPageActions.enterNumberofSuspensions();
        driverPageActions.enterNumberofMajorViolations();
        webUtils.sleep(2);
        driverPageActions.clickContinueButton();
        webUtils.sleep(3);
        driverPageActions.proceedToLossesPage();
        webUtils.sleep(3);

        // Losses page
        lossesPageActions.proceedToNextStep();
        webUtils.sleep(2);

        // Rates Page
        ratesPageActions.proceedToNextStep();
        webUtils.sleep(2);

        // Summary Page
        Map<String, String> summaryData = (Map<String, String>) testData.get("Summary");
        summaryPageActions.enterSummaryAccount(summaryData.get("Summary Account"));
        summaryPageActions.enterSummaryDriverExperience(summaryData.get("Summary Driver Experience"));
        summaryPageActions.proceedToNextStep();

        // Admin Rates
        adminRatesPageActions.setAdminRatesData((Map<String, String>) testData.get("AdminRates"));
        adminRatesPageActions.clickOnAdminRatesTab();
        adminRatesPageActions.clickOnUpdateButton();
        adminRatesPageActions.selectALCarrier();
        webUtils.sleep(2);
        adminRatesPageActions.enterALRate();
        adminRatesPageActions.enterALDeductible();
        webUtils.sleep(2);
        adminRatesPageActions.clickSaveRatesButton();
        webUtils.sleep(2);

        // Admin Fees
        adminFeesPageActions.setAdminFeesData((Map<String, String>) testData.get("AdminFees"));
        adminFeesPageActions.clickOnAdminFeesTab();
        webUtils.sleep(1);
        adminFeesPageActions.clickOnUpdateButton();
        adminFeesPageActions.enterALCommission();
        adminFeesPageActions.enterALPolicyFees();
        adminFeesPageActions.enterALBrokerFees();
        adminFeesPageActions.enterALUnderwritingFees();
        adminFeesPageActions.clickSaveFeesButton();
        webUtils.sleep(2);

        // Request Quote
        reviewPageActions.clickReviewTab();
        reviewPageActions.agreeToTermsAndConditions();
        reviewPageActions.clickRequestQuoteButton();

        // Approve Quote
        submissionStatusButtons.clickApproveQuoteButton();
        submissionStatusButtons.confirmApproveQuote();
        submissionStatusButtons.waitForQuotedBadgeToAppear();

        // Request to Bind
        submissionStatusButtons.clickRequestToBindButton();
        requestBindPageActions.selectCoverwhalePaymentOption();
        requestBindPageActions.selectBillingMethodOption();
        requestBindPageActions.agreeToElectronicSignature();
        requestBindPageActions.enterElectronicSignatureName("AB");
        requestBindPageActions.submitRequestToBind();
        submissionStatusButtons.waitForBadgeRequestToBindUnderwritingReview();

        // Approve Bind
        submissionStatusButtons.clickApproveBindButton();
        submissionStatusButtons.clickApproveBindInsideAreYouSureModal();
        submissionStatusButtons.confirmApproveBind();
        submissionStatusButtons.waitForBoundBadgeToAppear();

        // open and validate quote document
        String quoteDocURL = submissionStatusButtons.getDocumentURL();
        String quoteDocNumber = quoteDocURL.split("transportation/")[1].split("/")[0];

        webUtils.sleep(8);
        submissionStatusButtons.openQuoteDocument();
        webUtils.sleep(8);

        QuotePdfReader.QUOTE_PDF_MAP.put("TC_13_01", quoteDocNumber);
        quoteDataValidator.validateQuoteDataForTC_13_01();
        webUtils.sleep(10);
    }

    @Test(testName = "TC_13_02", description = "Adding a vehicle")
    public void TC_13_02() {

        // Create Endorsement
        submissionStatusButtons.clickCreateEndorsement();
        String dateToEnter = DateUtils.getFutureDateFromCurrent("MM/dd/yyyy", 14);
        submissionStatusButtons.enterEffectiveDate(dateToEnter);
        submissionStatusButtons.confirmCreateEndorsement();

        // Add a vehicle
        Map<String, String> VehicleData = (Map<String, String>) DataRecorder.VEHICLES_CACHE.get("VEHICLE_DATA_5");
        vehiclePageActions.setVehicleData(VehicleData);
        submissionStatusButtons.clickVehiclesTab();
        vehiclePageActions.clickAddVehicleButton();
        vehiclePageActions.enterVIN();
        vehiclePageActions.enterVehicleYear();
        vehiclePageActions.enterMakeOrManufacturer();
        vehiclePageActions.enterModel();
        vehiclePageActions.enterVehicleValue();
        vehiclePageActions.selectVehicleClass();
        vehiclePageActions.selectVehicleBodyType();
        vehiclePageActions.clickAddVehicleSaveButton();
        webUtils.sleep(2);

        // Request Quote
        reviewPageActions.clickReviewTab();
        reviewPageActions.agreeToTermsAndConditions();
        reviewPageActions.clickRequestQuoteButton();

        // Approve Quote
        submissionStatusButtons.clickApproveQuoteButton();
        submissionStatusButtons.confirmApproveQuote();
        submissionStatusButtons.waitForQuotedBadgeToAppear();

        // Request Bind
        submissionStatusButtons.clickRequestToBindButton();
        requestBindPageActions.agreeToElectronicSignature();
        requestBindPageActions.enterElectronicSignatureName("AB");
        requestBindPageActions.submitRequestToBind();
        submissionStatusButtons.waitForBadgeRequestToBindUnderwritingReview();

        // Approve Bind
        submissionStatusButtons.clickApproveBindButton();
        submissionStatusButtons.clickApproveBindInsideAreYouSureModal();
        submissionStatusButtons.confirmApproveBind();
        submissionStatusButtons.waitForBoundBadgeToAppear();

        // Open Invoice document
        String invoiceDocURL = submissionStatusButtons.getDocumentURL();
        String invoiceDocNumber = invoiceDocURL.split("transportation/")[1].split("/")[0];

        submissionStatusButtons.openInvoiceDocument();
        webUtils.sleep(5);
        InvoicePDFReader.INVOICE_DOC_MAP.put("TC_13_02", invoiceDocNumber);
        invoiceDataValidator.validatePdfDataForTC_13_02();

        // open and validate quote document after endorsement
        String previewQuoteDocURL = submissionStatusButtons.getDocumentURL();
        String previewQuoteDocNumber = previewQuoteDocURL.split("transportation/")[1].split("/")[0];
        submissionStatusButtons.openQuoteDocument();
        webUtils.sleep(8);
        QuotePdfReader.QUOTE_PDF_MAP.put("TC_13_01", previewQuoteDocNumber);
        quoteDataValidator.validateQuoteDocAdditionalPremiumTaxes("TC_13_01");

    }

    @Test(testName = "TC_13_03", description = "Non Premium Bearing Endorsement")
    public void TC_13_03() {

        // Create Endorsement
        submissionStatusButtons.clickCreateEndorsement();
        String date4ToEnter = DateUtils.getFutureDateFromCurrent("MM/dd/yyyy", 15);
        submissionStatusButtons.enterEffectiveDate(date4ToEnter);
        submissionStatusButtons.confirmCreateEndorsement();

        // Edit driver details
        submissionStatusButtons.clickDriversTab();
        submissionStatusButtons.clickEditDriverButton();
        submissionStatusButtons.enterFirstNameInDriverEditForm("Eva");
        submissionStatusButtons.clickContinueDriverButton();
        webUtils.sleep(2);

        // Request Quote
        reviewPageActions.clickReviewTab();
        reviewPageActions.agreeToTermsAndConditions();
        reviewPageActions.clickRequestQuoteButton();

        // Approve Quote
        submissionStatusButtons.clickApproveQuoteButton();
        submissionStatusButtons.confirmApproveQuote();
        submissionStatusButtons.waitForQuotedBadgeToAppear();

        // Request Bind
        submissionStatusButtons.clickRequestToBindButton();
        requestBindPageActions.agreeToElectronicSignature();
        requestBindPageActions.enterElectronicSignatureName("AB");
        requestBindPageActions.submitRequestToBind();
        submissionStatusButtons.waitForBadgeRequestToBindUnderwritingReview();

        // Approve Bind
        submissionStatusButtons.clickApproveBindButton();
        submissionStatusButtons.clickApproveBindInsideAreYouSureModal();
        submissionStatusButtons.confirmApproveBind();
        submissionStatusButtons.waitForBoundBadgeToAppear();

        // Open Invoice document
        String invoiceDocURL = submissionStatusButtons.getDocumentURL();
        String invoiceDocNumber = invoiceDocURL.split("transportation/")[1].split("/")[0];
        submissionStatusButtons.openInvoiceDocument();
        webUtils.sleep(5);
        InvoicePDFReader.INVOICE_DOC_MAP.put("TC_13_03", invoiceDocNumber);
        invoiceDataValidator.validatePdfDataForTC_13_03();

        // open and validate quote document after endorsement
        String previewQuoteDocURL = submissionStatusButtons.getDocumentURL();
        String previewQuoteDocNumber = previewQuoteDocURL.split("transportation/")[1].split("/")[0];
        submissionStatusButtons.openQuoteDocument();
        webUtils.sleep(8);
        QuotePdfReader.QUOTE_PDF_MAP.put("TC_13_03", previewQuoteDocNumber);
        quoteDataValidator.validateQuoteDocAdditionalPremiumTaxes("TC_13_03");
    }

    @Test(testName = "TC_13_04", description = "Cancellation")
    public void TC_13_04() {

        // Request To Cancel
        submissionStatusButtons.clickRequestCancel();
        String date5ToEnter = DateUtils.getFutureDateFromCurrent("MM/dd/yyyy", 16);
        submissionStatusButtons.enterEffectiveDateInRequestCancelModal(date5ToEnter);
        submissionStatusButtons.confirmRequestCancel();
        submissionStatusButtons.waitForRequestToCancelBadgeToAppear();

        // Cancel
        submissionStatusButtons.clickApproveCancel();
        submissionStatusButtons.confirmApproveCancel();
        submissionStatusButtons.waitForCanceledBadgeToAppear();

        // Open Invoice document
        String invoiceDocURL = submissionStatusButtons.getDocumentURL();
        String invoiceDocNumber = invoiceDocURL.split("transportation/")[1].split("/")[0];
        submissionStatusButtons.openInvoiceDocument();
        webUtils.sleep(5);
        InvoicePDFReader.INVOICE_DOC_MAP.put("TC_13_04", invoiceDocNumber);
        invoiceDataValidator.validatePdfDataForTC_13_04();

        // open and validate quote document after endorsement
        String previewQuoteDocURL = submissionStatusButtons.getDocumentURL();
        String previewQuoteDocNumber = previewQuoteDocURL.split("transportation/")[1].split("/")[0];
        submissionStatusButtons.openQuoteDocument();
        webUtils.sleep(8);
        QuotePdfReader.QUOTE_PDF_MAP.put("TC_13_04", previewQuoteDocNumber);
        quoteDataValidator.validateQuoteDocAdditionalPremiumTaxes("TC_13_04");
    }

    @Test(testName = "TC_13_05", description = "Request Reinstatement")
    public void TC_13_05() {

        // Request Reinstatement
        submissionStatusButtons.clickRequestReinstatementButton();
        submissionStatusButtons.clickRequestReinstatementAcknowledgeButton();
        submissionStatusButtons.clickApproveBindButton();
        submissionStatusButtons.clickApproveBindInsideAreYouSureModal();
        submissionStatusButtons.confirmApproveBind();
        submissionStatusButtons.waitForBoundBadgeToAppear();

        // Open Invoice document
        String invoiceDocURL = submissionStatusButtons.getDocumentURL();
        String invoiceDocNumber = invoiceDocURL.split("transportation/")[1].split("/")[0];
        submissionStatusButtons.openInvoiceDocument();
        webUtils.sleep(5);
        InvoicePDFReader.INVOICE_DOC_MAP.put("TC_13_05", invoiceDocNumber);
        invoiceDataValidator.validatePdfDataForTC_13_05();

        // open and validate quote document after endorsement
        String previewQuoteDocURL = submissionStatusButtons.getDocumentURL();
        String previewQuoteDocNumber = previewQuoteDocURL.split("transportation/")[1].split("/")[0];
        submissionStatusButtons.openQuoteDocument();
        webUtils.sleep(8);
        QuotePdfReader.QUOTE_PDF_MAP.put("TC_13_05", previewQuoteDocNumber);
        quoteDataValidator.validateQuoteDocAdditionalPremiumTaxes("TC_13_05");
    }
}