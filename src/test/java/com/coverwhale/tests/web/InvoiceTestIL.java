package com.coverwhale.tests.web;

import java.util.Date;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.coverwhale.actions.web.*;
import com.coverwhale.core.BaseConfiguration;
import com.coverwhale.core.DataRecorder;
import com.coverwhale.core.InvoicePDFReader;
import com.coverwhale.core.QuotePdfReader;
import com.coverwhale.utils.common.DateUtils;
import com.coverwhale.utils.selenium.WebUtils;
import com.coverwhale.validators.web.InvoiceDataValidatorIL;
import com.coverwhale.validators.web.quotes.QuoteDataValidatorIL;
import com.coverwhale.core.QuotePdfReader;


public class InvoiceTestIL extends BaseConfiguration {

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
    private InvoiceDataValidatorIL invoiceDataValidator;
    private QuoteDataValidatorIL quoteDataValidator;
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
        invoiceDataValidator = new InvoiceDataValidatorIL();
        quoteDataValidator = new QuoteDataValidatorIL();

        webUtils = new WebUtils(driver);
    }

    @Test(testName = "TC_12_01", description = "New Business")
    public void TC_12_01() {
        // Arrange
        Map<String, Object> testData = DataRecorder.getTestData("TC_12_01");
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

        // Save broker details
        appStatusPageActions.saveBrokerContactDetails("", "Anastasia");

        // Resume app to quote
        submissionStatusButtons.clickResumeAppToQuoteButton();

        // Submission page
        Map<String, String> submissionData = (Map<String, String>) testData.get("Submission");
        submissionPageActions.clickMotorTruckCargoCheckbox();
        submissionPageActions.clickNextButton();
        webUtils.sleep(2);

		// Insured page
        insuredPageActions.setInsuredData((Map<String, String>) testData.get("Insured"));
        insuredPageActions.clickNextButton();
        webUtils.sleep(2);
        // Producer page
        producerPageActions.clickNextButton();
        webUtils.sleep(2);

        // Limits page
        limitPageActions.clickNextButton();
        webUtils.sleep(2);

        // Operations page
        operationPageActions.setOperationData((Map<String, String>) testData.get("Operations"));
        operationPageActions.selectLocalTruckerCheckbox();
        operationPageActions.selectInEligibleOperation();
        operationPageActions.clickNextButton();
        webUtils.sleep(2);

        // Radius page
        radiusPageActions.setRadiusData((Map<String, String>) testData.get("Radius"));
        radiusPageActions.enterUnder200MilesValue();
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
        webUtils.sleep(3);
        vehiclePageActions.clickAddVehicleButton();
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
        trailerPageActions.setTrailerData((Map<String, String>) testData.get("Trailers"));
        webUtils.sleep(3);
        trailerPageActions.clickAddTrailersButton();
        trailerPageActions.enterVinNumberField();
        trailerPageActions.enterMakeOrManufacturer();
        trailerPageActions.enterModel();
        trailerPageActions.enterTrailerValue();
        trailerPageActions.selectBodyType();
        trailerPageActions.clickTrailerSaveButton();
        webUtils.sleep(3);
        trailerPageActions.clickNextButton();
        webUtils.sleep(3);

        // Drivers page
        Map<String, String> driverData = (Map<String, String>) testData.get("Drivers");
        webUtils.sleep(3);
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
        lossesPageActions.selectLossesConfirmedOption();
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
        webUtils.sleep(4);
        adminRatesPageActions.clickOnAdminRatesTab();
        webUtils.sleep(2);
        adminRatesPageActions.clickOnUpdateButton();
        webUtils.sleep(2);
        adminRatesPageActions.selectAPDCarrier();
        webUtils.sleep(2);
        adminRatesPageActions.enterAPDRate();
        webUtils.sleep(2);
        adminRatesPageActions.enterAPDDeductible();
        webUtils.sleep(2);

        adminRatesPageActions.clickSaveRatesButton();
        webUtils.sleep(2);

        // Admin Fees
        adminFeesPageActions.setAdminFeesData((Map<String, String>) testData.get("AdminFees"));
        webUtils.sleep(4);
        adminFeesPageActions.clickOnAdminFeesTab();
        webUtils.sleep(1);
        adminFeesPageActions.clickOnUpdateButton();
        webUtils.sleep(2);
        adminFeesPageActions.enterAPDCommission();
        webUtils.sleep(2);
        adminFeesPageActions.enterAPDPolicyFees();
        webUtils.sleep(2);
        adminFeesPageActions.enterAPDBrokerFees();
        webUtils.sleep(2);
        adminFeesPageActions.enterAPDUnderwritingFees();
        webUtils.sleep(2);

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

        // open and validate quote document after endorsement
        String previewQuoteDocURL = submissionStatusButtons.getDocumentURL();
        String previewQuoteDocNumber = previewQuoteDocURL.split("transportation/")[1].split("/")[0];
        submissionStatusButtons.openQuoteDocument();
        webUtils.sleep(8);
        QuotePdfReader.QUOTE_PDF_MAP.put("TC_12_01", previewQuoteDocNumber);
        quoteDataValidator.validateQuoteDoc("TC_12_01");

    }

    @Test(testName = "TC_12_02", description = "Adding a vehicle")
    public void TC_12_02() {

        // Create Endorsement
        submissionStatusButtons.clickCreateEndorsement();
        String dateToEnter = DateUtils.getFutureDateFromCurrent("MM/dd/yyyy", 14);
        submissionStatusButtons.enterEffectiveDate(dateToEnter);
        submissionStatusButtons.confirmCreateEndorsement();

        // Add a vehicle
        Map<String, String> VehicleData = (Map<String, String>) DataRecorder.VEHICLES_CACHE.get("VEHICLE_DATA_3");
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

        // open and validate quote document after endorsement
        String previewQuoteDocURL = submissionStatusButtons.getDocumentURL();
        String previewQuoteDocNumber = previewQuoteDocURL.split("transportation/")[1].split("/")[0];
        submissionStatusButtons.openQuoteDocument();
        webUtils.sleep(8);
        QuotePdfReader.QUOTE_PDF_MAP.put("TC_12_01", previewQuoteDocNumber);
        quoteDataValidator.validateQuoteDocAdditionalPremiumTaxes("TC_12_01");
        webUtils.sleep(2);

        // Open Invoice document
        String invoiceDocURL = submissionStatusButtons.getDocumentURL();
        String invoiceDocNumber = invoiceDocURL.split("transportation/")[1].split("/")[0];

        submissionStatusButtons.openInvoiceDocument();
        webUtils.sleep(5);

        InvoicePDFReader.INVOICE_DOC_MAP.put("TC_12_01", invoiceDocNumber);

        invoiceDataValidator.validatePdfDataForTC_12_01();

    }

    @Test(testName = "TC_12_03", description = "Remove and Add a Vehicle")
    public void TC_12_03() {

        // Create Endorsement
        submissionStatusButtons.clickCreateEndorsement();
        String date2ToEnter = DateUtils.getFutureDateFromCurrent("MM/dd/yyyy", 16);
        submissionStatusButtons.enterEffectiveDate(date2ToEnter);
        submissionStatusButtons.confirmCreateEndorsement();

        // Remove Vehicle
        submissionStatusButtons.clickVehiclesTab();
        submissionStatusButtons.clickRemoveVehicleButton(1);
        webUtils.acceptAlert(5);
        webUtils.sleep(2);

        // Add two vehicles
        vehiclePageActions.addVehicleData();
        webUtils.sleep(2);
        vehiclePageActions.addVehicleData();

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

        // open and validate quote document after endorsement
        String previewQuoteDocURL = submissionStatusButtons.getDocumentURL();
        String previewQuoteDocNumber = previewQuoteDocURL.split("transportation/")[1].split("/")[0];
        submissionStatusButtons.openQuoteDocument();
        webUtils.sleep(8);
        QuotePdfReader.QUOTE_PDF_MAP.put("TC_12_03", previewQuoteDocNumber);
        quoteDataValidator.validateQuoteDocAdditionalPremiumTaxes("TC_12_03");
        webUtils.sleep(2);

        // Open Invoice document
        String invoiceDocURL = submissionStatusButtons.getDocumentURL();
        String invoiceDocNumber = invoiceDocURL.split("transportation/")[1].split("/")[0];

        submissionStatusButtons.openInvoiceDocument();
        webUtils.sleep(5);

        InvoicePDFReader.INVOICE_DOC_MAP.put("TC_12_02", invoiceDocNumber);

        invoiceDataValidator.validatePdfDataForTC_12_02();


    }

    @Test(testName = "TC_12_04", description = "Cancellation")
    public void TC_12_04() {

        // Request To Cancel
        submissionStatusButtons.clickRequestCancel();
        String date5ToEnter = DateUtils.getFutureDateFromCurrent("MM/dd/yyyy", 19);
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

		InvoicePDFReader.INVOICE_DOC_MAP.put("TC_12_03", invoiceDocNumber);
        invoiceDataValidator.validatePdfDataForTC_12_03();

    }
    
    
    @Test(testName = "TC_12_05", description = "Request Reinstatement")
    public void TC_12_05() {
        // Request Reinstatement
        submissionStatusButtons.clickRequestReinstatementButton();
        submissionStatusButtons.clickRequestReinstatementAcknowledgeButton();
        submissionStatusButtons.closeBrokerContactModalIfExists();
        submissionStatusButtons.clickApproveBindButton();
        submissionStatusButtons.clickApproveBindInsideAreYouSureModal();
        submissionStatusButtons.confirmApproveBind();
        submissionStatusButtons.closeBrokerContactModalIfExists();
        submissionStatusButtons.waitForBoundBadgeToAppear();
        submissionStatusButtons.closeBrokerContactModalIfExists();

        // open and validate quote document after endorsement
        String previewQuoteDocURL = submissionStatusButtons.getDocumentURL();
        String previewQuoteDocNumber = previewQuoteDocURL.split("transportation/")[1].split("/")[0];
        submissionStatusButtons.openQuoteDocument();
        webUtils.sleep(8);
        QuotePdfReader.QUOTE_PDF_MAP.put("TC_12_05", previewQuoteDocNumber);
        quoteDataValidator.validateQuoteDocAdditionalPremiumTaxes("TC_12_05");
        webUtils.sleep(2);

        // Open Invoice document
   		String invoiceDocURL = submissionStatusButtons.getDocumentURL();
   		String invoiceDocNumber = invoiceDocURL.split("transportation/")[1].split("/")[0];

   		submissionStatusButtons.openInvoiceDocument();
   		webUtils.sleep(5);

   		InvoicePDFReader.INVOICE_DOC_MAP.put("TC_12_04", invoiceDocNumber);

        invoiceDataValidator.validatePdfDataForTC_12_04();
    }

}
