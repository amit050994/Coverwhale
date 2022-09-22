package com.coverwhale.tests.web;

import com.coverwhale.actions.web.*;
import com.coverwhale.core.BaseConfiguration;
import com.coverwhale.core.DataRecorder;
import com.coverwhale.core.InvoicePDFReader;
import com.coverwhale.utils.common.DateUtils;
import com.coverwhale.utils.selenium.WebUtils;
import com.coverwhale.validators.web.InvoiceDataValidatorTX;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Map;

public class InvoiceTestTX extends BaseConfiguration {

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
    private InvoiceDataValidatorTX invoiceDataValidator;
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
        invoiceDataValidator = new InvoiceDataValidatorTX();

        webUtils = new WebUtils(driver);
    }

    @Test(testName = "TC_04_01", description = "Non Premium Bearing Endorsement")
    public void TC_04_01() {
        // Arrange
        Map<String, Object> testData = DataRecorder.getTestData("TC_04_01");
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
        submissionPageActions.selectAutoLiability(submissionData.get("PIP"), submissionData.get("UM/PD"));
        submissionPageActions.clickTruckersGeneralLiabilityCheckbox();
        submissionPageActions.clicknonTruckingLiabilityCheckbox();
        submissionPageActions.clickNextButton();

//		// Insured page
        insuredPageActions.setInsuredData((Map<String, String>) testData.get("Insured"));
        insuredPageActions.clickDashcamAddressSameAsMailingAddressCB();
        insuredPageActions.selectWaiverOfSubrogation();
        insuredPageActions.selectPrimaryAndNoncontributoryForTGL();
        insuredPageActions.selectPrimaryAndNoncontributoryForAL();
        webUtils.sleep(2);
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
        driverData.put("Driver Date of Birth", "12/11/1990");  // TODO to fix this in excel reading code
        driverPageActions.setDriverData(driverData);

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
        adminRatesPageActions.enterALRate();
        adminRatesPageActions.enterALDeductible();

        adminRatesPageActions.selectAPDCarrier();
        adminRatesPageActions.enterAPDRate();
        adminRatesPageActions.enterAPDDeductible();

        adminRatesPageActions.selectMTCCarrier();
        adminRatesPageActions.enterMTCRate();
        adminRatesPageActions.enterMTCDeductible();

        adminRatesPageActions.selectTGLCarrier();
        adminRatesPageActions.enterTGLRate();
        adminRatesPageActions.enterTGLDeductible();

        adminRatesPageActions.selectNTLCarrier();
        adminRatesPageActions.enterNTLRate();
        adminRatesPageActions.enterNTLDeductible();

        adminRatesPageActions.clickSaveRatesButton();

        // Admin Fees
        adminFeesPageActions.setAdminFeesData((Map<String, String>) testData.get("AdminFees"));
        adminFeesPageActions.clickOnAdminFeesTab();
        adminFeesPageActions.clickOnUpdateButton();
        adminFeesPageActions.enterALCommission();
        adminFeesPageActions.enterALPolicyFees();
        adminFeesPageActions.enterALBrokerFees();
        adminFeesPageActions.enterALUnderwritingFees();

        adminFeesPageActions.enterAPDCommission();
        adminFeesPageActions.enterAPDPolicyFees();
        adminFeesPageActions.enterAPDBrokerFees();
        adminFeesPageActions.enterAPDUnderwritingFees();

        adminFeesPageActions.enterMTCCommission();
        adminFeesPageActions.enterMTCPolicyFees();
        adminFeesPageActions.enterMTCBrokerFees();
        adminFeesPageActions.enterMTCUnderwritingFees();

        adminFeesPageActions.enterTGLCommission();
        adminFeesPageActions.enterTGLPolicyFees();
        adminFeesPageActions.enterTGLBrokerFees();
        adminFeesPageActions.enterTGLUnderwritingFees();

        adminFeesPageActions.enterNTLCommission();
        adminFeesPageActions.enterNTLPolicyFees();
        adminFeesPageActions.enterNTLBrokerFees();
        adminFeesPageActions.enterNTLUnderwritingFees();

        adminFeesPageActions.clickSaveFeesButton();

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

        // Create Endorsement
        submissionStatusButtons.clickCreateEndorsement();
        String dateToEnter = DateUtils.getFutureDateFromCurrent("MM/dd/yyyy", 14);
        submissionStatusButtons.enterEffectiveDate(dateToEnter);
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
		webUtils.sleep(8);

		InvoicePDFReader.INVOICE_DOC_MAP.put("TC_04_01", invoiceDocNumber);
		invoiceDataValidator.validatePdfDataForTC_04_01();
    }

    @Test(testName = "TC_04_02", description = "Non Premium Bearing Endorsement")
    public void TC_04_02() {
        // Arrange
        Map<String, Object> testData = DataRecorder.getTestData("TC_04_02");
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
        submissionPageActions.selectAutoLiability(submissionData.get("PIP"), submissionData.get("UM/PD"));
        submissionPageActions.clickTruckersGeneralLiabilityCheckbox();
        submissionPageActions.clicknonTruckingLiabilityCheckbox();
        submissionPageActions.clickNextButton();

//		// Insured page
        insuredPageActions.setInsuredData((Map<String, String>) testData.get("Insured"));
        insuredPageActions.clickDashcamAddressSameAsMailingAddressCB();
        insuredPageActions.selectWaiverOfSubrogation();
        insuredPageActions.selectPrimaryAndNoncontributoryForTGL();
        insuredPageActions.selectPrimaryAndNoncontributoryForAL();
        webUtils.sleep(2);
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
        driverData.put("Driver Date of Birth", "12/11/1990");  // TODO to fix this in excel reading code
        driverPageActions.setDriverData(driverData);

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
        adminRatesPageActions.enterALRate();
        adminRatesPageActions.enterALDeductible();

        adminRatesPageActions.selectAPDCarrier();
        adminRatesPageActions.enterAPDRate();
        adminRatesPageActions.enterAPDDeductible();

        adminRatesPageActions.selectMTCCarrier();
        adminRatesPageActions.enterMTCRate();
        adminRatesPageActions.enterMTCDeductible();

        adminRatesPageActions.selectTGLCarrier();
        adminRatesPageActions.enterTGLRate();
        adminRatesPageActions.enterTGLDeductible();

        adminRatesPageActions.selectNTLCarrier();
        adminRatesPageActions.enterNTLRate();
        adminRatesPageActions.enterNTLDeductible();

        adminRatesPageActions.clickSaveRatesButton();

        // Admin Fees
        adminFeesPageActions.setAdminFeesData((Map<String, String>) testData.get("AdminFees"));
        adminFeesPageActions.clickOnAdminFeesTab();
        adminFeesPageActions.clickOnUpdateButton();
        adminFeesPageActions.enterALCommission();
        adminFeesPageActions.enterALPolicyFees();
        adminFeesPageActions.enterALBrokerFees();
        adminFeesPageActions.enterALUnderwritingFees();

        adminFeesPageActions.enterAPDCommission();
        adminFeesPageActions.enterAPDPolicyFees();
        adminFeesPageActions.enterAPDBrokerFees();
        adminFeesPageActions.enterAPDUnderwritingFees();

        adminFeesPageActions.enterMTCCommission();
        adminFeesPageActions.enterMTCPolicyFees();
        adminFeesPageActions.enterMTCBrokerFees();
        adminFeesPageActions.enterMTCUnderwritingFees();

        adminFeesPageActions.enterTGLCommission();
        adminFeesPageActions.enterTGLPolicyFees();
        adminFeesPageActions.enterTGLBrokerFees();
        adminFeesPageActions.enterTGLUnderwritingFees();

        adminFeesPageActions.enterNTLCommission();
        adminFeesPageActions.enterNTLPolicyFees();
        adminFeesPageActions.enterNTLBrokerFees();
        adminFeesPageActions.enterNTLUnderwritingFees();

        adminFeesPageActions.clickSaveFeesButton();

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

        // Create Endorsement
        submissionStatusButtons.clickCreateEndorsement();
        String dateToEnter = DateUtils.getFutureDateFromCurrent("MM/dd/yyyy", 14);
        submissionStatusButtons.enterEffectiveDate(dateToEnter);
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
        webUtils.sleep(8);

        InvoicePDFReader.INVOICE_DOC_MAP.put("TC_04_02", invoiceDocNumber);
        invoiceDataValidator.validatePdfDataForTC_04_02();
    }

    @Test(testName = "TC_04_03", description = "Non Premium Bearing Endorsement")
    public void TC_04_03() {
        // Arrange
        Map<String, Object> testData = DataRecorder.getTestData("TC_04_03");
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
        submissionPageActions.selectAutoLiability(submissionData.get("PIP"), submissionData.get("UM/PD"));
        submissionPageActions.clickTruckersGeneralLiabilityCheckbox();
        submissionPageActions.clicknonTruckingLiabilityCheckbox();
        submissionPageActions.clickNextButton();

//		// Insured page
        insuredPageActions.setInsuredData((Map<String, String>) testData.get("Insured"));
        insuredPageActions.clickDashcamAddressSameAsMailingAddressCB();
        insuredPageActions.selectWaiverOfSubrogation();
        insuredPageActions.selectPrimaryAndNoncontributoryForTGL();
        insuredPageActions.selectPrimaryAndNoncontributoryForAL();
        webUtils.sleep(2);
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
        driverData.put("Driver Date of Birth", "12/11/1990");  // TODO to fix this in excel reading code
        driverPageActions.setDriverData(driverData);

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
        adminRatesPageActions.enterALRate();
        adminRatesPageActions.enterALDeductible();

        adminRatesPageActions.selectAPDCarrier();
        adminRatesPageActions.enterAPDRate();
        adminRatesPageActions.enterAPDDeductible();

        adminRatesPageActions.selectMTCCarrier();
        adminRatesPageActions.enterMTCRate();
        adminRatesPageActions.enterMTCDeductible();

        adminRatesPageActions.selectTGLCarrier();
        adminRatesPageActions.enterTGLRate();
        adminRatesPageActions.enterTGLDeductible();

        adminRatesPageActions.selectNTLCarrier();
        adminRatesPageActions.enterNTLRate();
        adminRatesPageActions.enterNTLDeductible();

        adminRatesPageActions.clickSaveRatesButton();

        // Admin Fees
        adminFeesPageActions.setAdminFeesData((Map<String, String>) testData.get("AdminFees"));
        adminFeesPageActions.clickOnAdminFeesTab();
        adminFeesPageActions.clickOnUpdateButton();
        adminFeesPageActions.enterALCommission();
        adminFeesPageActions.enterALPolicyFees();
        adminFeesPageActions.enterALBrokerFees();
        adminFeesPageActions.enterALUnderwritingFees();

        adminFeesPageActions.enterAPDCommission();
        adminFeesPageActions.enterAPDPolicyFees();
        adminFeesPageActions.enterAPDBrokerFees();
        adminFeesPageActions.enterAPDUnderwritingFees();

        adminFeesPageActions.enterMTCCommission();
        adminFeesPageActions.enterMTCPolicyFees();
        adminFeesPageActions.enterMTCBrokerFees();
        adminFeesPageActions.enterMTCUnderwritingFees();

        adminFeesPageActions.enterTGLCommission();
        adminFeesPageActions.enterTGLPolicyFees();
        adminFeesPageActions.enterTGLBrokerFees();
        adminFeesPageActions.enterTGLUnderwritingFees();

        adminFeesPageActions.enterNTLCommission();
        adminFeesPageActions.enterNTLPolicyFees();
        adminFeesPageActions.enterNTLBrokerFees();
        adminFeesPageActions.enterNTLUnderwritingFees();

        adminFeesPageActions.clickSaveFeesButton();

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

        // Create Endorsement
        submissionStatusButtons.clickCreateEndorsement();
        String dateToEnter = DateUtils.getFutureDateFromCurrent("MM/dd/yyyy", 14);
        submissionStatusButtons.enterEffectiveDate(dateToEnter);
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
        webUtils.sleep(8);

        InvoicePDFReader.INVOICE_DOC_MAP.put("TC_04_03", invoiceDocNumber);
        invoiceDataValidator.validatePdfDataForTC_04_03();
    }

    @Test(testName = "TC_04_04", description = "Non Premium Bearing Endorsement")
    public void TC_04_04() {
        // Arrange
        Map<String, Object> testData = DataRecorder.getTestData("TC_04_04");
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
        submissionPageActions.selectAutoLiability(submissionData.get("PIP"), submissionData.get("UM/PD"));
        submissionPageActions.clickTruckersGeneralLiabilityCheckbox();
        submissionPageActions.clicknonTruckingLiabilityCheckbox();
        submissionPageActions.clickNextButton();

//		// Insured page
        insuredPageActions.setInsuredData((Map<String, String>) testData.get("Insured"));
        insuredPageActions.clickDashcamAddressSameAsMailingAddressCB();
        insuredPageActions.selectWaiverOfSubrogation();
        insuredPageActions.selectPrimaryAndNoncontributoryForTGL();
        insuredPageActions.selectPrimaryAndNoncontributoryForAL();
        webUtils.sleep(2);
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
        driverData.put("Driver Date of Birth", "12/11/1990");  // TODO to fix this in excel reading code
        driverPageActions.setDriverData(driverData);

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
        adminRatesPageActions.enterALRate();
        adminRatesPageActions.enterALDeductible();

        adminRatesPageActions.selectAPDCarrier();
        adminRatesPageActions.enterAPDRate();
        adminRatesPageActions.enterAPDDeductible();

        adminRatesPageActions.selectMTCCarrier();
        adminRatesPageActions.enterMTCRate();
        adminRatesPageActions.enterMTCDeductible();

        adminRatesPageActions.selectTGLCarrier();
        adminRatesPageActions.enterTGLRate();
        adminRatesPageActions.enterTGLDeductible();

        adminRatesPageActions.selectNTLCarrier();
        adminRatesPageActions.enterNTLRate();
        adminRatesPageActions.enterNTLDeductible();

        adminRatesPageActions.clickSaveRatesButton();

        // Admin Fees
        adminFeesPageActions.setAdminFeesData((Map<String, String>) testData.get("AdminFees"));
        adminFeesPageActions.clickOnAdminFeesTab();
        adminFeesPageActions.clickOnUpdateButton();
        adminFeesPageActions.enterALCommission();
        adminFeesPageActions.enterALPolicyFees();
        adminFeesPageActions.enterALBrokerFees();
        adminFeesPageActions.enterALUnderwritingFees();

        adminFeesPageActions.enterAPDCommission();
        adminFeesPageActions.enterAPDPolicyFees();
        adminFeesPageActions.enterAPDBrokerFees();
        adminFeesPageActions.enterAPDUnderwritingFees();

        adminFeesPageActions.enterMTCCommission();
        adminFeesPageActions.enterMTCPolicyFees();
        adminFeesPageActions.enterMTCBrokerFees();
        adminFeesPageActions.enterMTCUnderwritingFees();

        adminFeesPageActions.enterTGLCommission();
        adminFeesPageActions.enterTGLPolicyFees();
        adminFeesPageActions.enterTGLBrokerFees();
        adminFeesPageActions.enterTGLUnderwritingFees();

        adminFeesPageActions.enterNTLCommission();
        adminFeesPageActions.enterNTLPolicyFees();
        adminFeesPageActions.enterNTLBrokerFees();
        adminFeesPageActions.enterNTLUnderwritingFees();

        adminFeesPageActions.clickSaveFeesButton();

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

        // Create Endorsement
        submissionStatusButtons.clickCreateEndorsement();
        String dateToEnter = DateUtils.getFutureDateFromCurrent("MM/dd/yyyy", 14);
        submissionStatusButtons.enterEffectiveDate(dateToEnter);
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
        webUtils.sleep(8);

        InvoicePDFReader.INVOICE_DOC_MAP.put("TC_04_04", invoiceDocNumber);
        invoiceDataValidator.validatePdfDataForTC_04_04();
    }

    @Test(testName = "TC_04_05", description = "Adding a Vehicle")
    public void TC_04_05() {
        // Arrange
        Map<String, Object> testData = DataRecorder.getTestData("TC_04_05");
        
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
        submissionPageActions.selectAutoLiability(submissionData.get("PIP"), submissionData.get("UM/PD"));
        submissionPageActions.clickTruckersGeneralLiabilityCheckbox();
        submissionPageActions.clicknonTruckingLiabilityCheckbox();
        submissionPageActions.clickNextButton();

//		// Insured page
        insuredPageActions.setInsuredData((Map<String, String>) testData.get("Insured"));
        insuredPageActions.clickDashcamAddressSameAsMailingAddressCB();
        insuredPageActions.selectWaiverOfSubrogation();
        insuredPageActions.selectPrimaryAndNoncontributoryForTGL();
        insuredPageActions.selectPrimaryAndNoncontributoryForAL();
        webUtils.sleep(2);
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
        webUtils.sleep(2);
        vehiclePageActions.clickAddVehicleButton();
        webUtils.sleep(2);
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
        webUtils.sleep(2);
        trailerPageActions.clickAddTrailersButton();
        webUtils.sleep(2);
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
        driverData.put("Driver Date of Birth", "12/11/1990");  // TODO to fix this in excel reading code
        webUtils.sleep(2);
        driverPageActions.setDriverData(driverData);
        webUtils.sleep(2);

        driverPageActions.openAddDriverModal();
        webUtils.sleep(2);
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
        adminRatesPageActions.enterALRate();
        adminRatesPageActions.enterALDeductible();

        adminRatesPageActions.selectAPDCarrier();
        adminRatesPageActions.enterAPDRate();
        adminRatesPageActions.enterAPDDeductible();

        adminRatesPageActions.selectMTCCarrier();
        adminRatesPageActions.enterMTCRate();
        adminRatesPageActions.enterMTCDeductible();

        adminRatesPageActions.selectTGLCarrier();
        adminRatesPageActions.enterTGLRate();
        adminRatesPageActions.enterTGLDeductible();

        adminRatesPageActions.selectNTLCarrier();
        adminRatesPageActions.enterNTLRate();
        adminRatesPageActions.enterNTLDeductible();

        adminRatesPageActions.clickSaveRatesButton();

        // Admin Fees
        adminFeesPageActions.setAdminFeesData((Map<String, String>) testData.get("AdminFees"));
        adminFeesPageActions.clickOnAdminFeesTab();
        adminFeesPageActions.clickOnUpdateButton();
        adminFeesPageActions.enterALCommission();
        adminFeesPageActions.enterALPolicyFees();
        adminFeesPageActions.enterALBrokerFees();
        adminFeesPageActions.enterALUnderwritingFees();

        adminFeesPageActions.enterAPDCommission();
        adminFeesPageActions.enterAPDPolicyFees();
        adminFeesPageActions.enterAPDBrokerFees();
        adminFeesPageActions.enterAPDUnderwritingFees();

        adminFeesPageActions.enterMTCCommission();
        adminFeesPageActions.enterMTCPolicyFees();
        adminFeesPageActions.enterMTCBrokerFees();
        adminFeesPageActions.enterMTCUnderwritingFees();

        adminFeesPageActions.enterTGLCommission();
        adminFeesPageActions.enterTGLPolicyFees();
        adminFeesPageActions.enterTGLBrokerFees();
        adminFeesPageActions.enterTGLUnderwritingFees();

        adminFeesPageActions.enterNTLCommission();
        adminFeesPageActions.enterNTLPolicyFees();
        adminFeesPageActions.enterNTLBrokerFees();
        adminFeesPageActions.enterNTLUnderwritingFees();

        adminFeesPageActions.clickSaveFeesButton();

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

        // Open Invoice document
		String invoiceDocURL = submissionStatusButtons.getDocumentURL();
		String invoiceDocNumber = invoiceDocURL.split("transportation/")[1].split("/")[0];

		submissionStatusButtons.openInvoiceDocument();
		webUtils.sleep(5);

		InvoicePDFReader.INVOICE_DOC_MAP.put("TC_04_05", invoiceDocNumber);

        invoiceDataValidator.validatePdfDataForTC_04_05();

    }

    @Test(testName = "TC_04_06", description = "Adding a Trailer")
    public void TC_04_06() {

        // Create Endorsement
        submissionStatusButtons.clickCreateEndorsement();
        String date1ToEnter = DateUtils.getFutureDateFromCurrent("MM/dd/yyyy", 15);
        submissionStatusButtons.enterEffectiveDate(date1ToEnter);
        submissionStatusButtons.confirmCreateEndorsement();

        // Add a trailer
        Map<String, String> TrailerData = (Map<String, String>) DataRecorder.TRAILERS_CACHE.get("TRAILER_DATA_3");
        trailerPageActions.setTrailerData(TrailerData);
        submissionStatusButtons.clickTrailersTab();
        trailerPageActions.clickAddTrailersButton();
        webUtils.sleep(3);
        trailerPageActions.enterVinNumberField();
        trailerPageActions.enterMakeOrManufacturer();
        trailerPageActions.enterModel();
        trailerPageActions.enterTrailerValue();
        trailerPageActions.selectBodyType();
        trailerPageActions.clickTrailerSaveButton();
        webUtils.sleep(3);
        trailerPageActions.clickNextButton();
        webUtils.sleep(3);

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

   		InvoicePDFReader.INVOICE_DOC_MAP.put("TC_04_06", invoiceDocNumber);

        invoiceDataValidator.validatePdfDataForTC_04_06();

    }

    @Test(testName = "TC_04_07", description = "Remove a Vehicle")
    public void TC_04_07() {

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

   		InvoicePDFReader.INVOICE_DOC_MAP.put("TC_04_07", invoiceDocNumber);
   		
        invoiceDataValidator.validatePdfDataForTC_04_07();

    }

    @Test(testName = "TC_04_08", description = "Remove a Trailer")
    public void TC_04_08() {

        // Create Endorsement
        submissionStatusButtons.clickCreateEndorsement();
        String date3ToEnter = DateUtils.getFutureDateFromCurrent("MM/dd/yyyy", 17);
        submissionStatusButtons.enterEffectiveDate(date3ToEnter);
        submissionStatusButtons.confirmCreateEndorsement();

        // Remove Trailer
        submissionStatusButtons.clickTrailersTab();
        submissionStatusButtons.clickRemoveTrailerButton(1);
        webUtils.acceptAlert(5);
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

   		InvoicePDFReader.INVOICE_DOC_MAP.put("TC_04_08", invoiceDocNumber);

        invoiceDataValidator.validatePdfDataForTC_04_08();
    }

    @Test(testName = "TC_04_09", description = "Cancellation")
    public void TC_04_09() {

        // Request To Cancel
        submissionStatusButtons.clickRequestCancel();
        String date4ToEnter = DateUtils.getFutureDateFromCurrent("MM/dd/yyyy", 18);
        submissionStatusButtons.enterEffectiveDateInRequestCancelModal(date4ToEnter);
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

   		InvoicePDFReader.INVOICE_DOC_MAP.put("TC_04_09", invoiceDocNumber);

        invoiceDataValidator.validatePdfDataForTC_04_09();

    }
    
  
	@Test(testName = "TC_04_10", description = "Request Reinstatement")
	public void TC_04_10() {

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

		InvoicePDFReader.INVOICE_DOC_MAP.put("TC_04_10", invoiceDocNumber);

		invoiceDataValidator.validatePdfDataForTC_04_10();
	}
	
	@Test(testName = "TC_04_11", description = "Request Refrigeration")

	public void TC_04_11() {
		 // Arrange
        Map<String, Object> testData = DataRecorder.getTestData("TC_04_11");

        Map<String, String> CargoData = (Map<String, String>) testData.get("Cargo");
        Map<String, String> profileData = (Map<String, String>) testData.get("Profile");
        Map<String, String> quoteData = (Map<String, String>) testData.get("Quote");

        quotePageActions.setQuoteData(quoteData);

        Map<String, String> firstLoginData =  (Map<String, String>) DataRecorder.PROFILES_CACHE.get("AGENT_RETAILER");
        // Quote form
        loginActions.logOut(); // just in case if the app is logged in with different user then desired
        loginActions.login(firstLoginData.get("username"), firstLoginData.get("password"));
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

        // Resume app to quote
        submissionStatusButtons.confirmResumeApplicationToQuoteModal();

        // Submission page
        Map<String, String> submissionData = (Map<String, String>) testData.get("Submission");
        submissionPageActions.selectAutoLiability(submissionData.get("PIP"), submissionData.get("UM/PD"));
        submissionPageActions.clickTruckersGeneralLiabilityCheckbox();
        submissionPageActions.clicknonTruckingLiabilityCheckbox();
        submissionPageActions.clickNextButton();

		// Insured page
        insuredPageActions.setInsuredData((Map<String, String>) testData.get("Insured"));
        insuredPageActions.selectWaiverOfSubrogation();
        insuredPageActions.selectPrimaryAndNoncontributoryForTGL();
        insuredPageActions.selectPrimaryAndNoncontributoryForAL();
        insuredPageActions.clickSameShippingAddressCheck();
        webUtils.sleep(2);
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
       // operationPageActions.enterGrossAnnualTruckingRevenue();
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
        cargoPageActions.setLimitMotorTruckCargoDropdown200000();
        cargoPageActions.selectCommodity1Dropdown();
        cargoPageActions.enterCommodity1Percentage();
        cargoPageActions.clickYesRefrigeratedGoodsHauledButton();
        cargoPageActions.clickNextButton();
        webUtils.sleep(2);

        // Terminal page
        terminalPageActions.clickNextButton();
        webUtils.sleep(2);

        // Vehicle Page
        vehiclePageActions.setVehicleData((Map<String, String>) testData.get("Vehicles"));
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
        driverData.put("Driver Date of Birth", "12/11/1990");  // TODO to fix this in excel reading code
        driverPageActions.setDriverData(driverData);
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

        // Request Quote
        reviewPageActions.clickReviewTab();
        reviewPageActions.agreeToTermsAndConditions();
        reviewPageActions.clickRequestQuoteButton();

        submissionStatusButtons.waitForQuotedBadgeToAppear();

        // Request to Bind
        submissionStatusButtons.clickRequestToBindButton();
        requestBindPageActions.selectCoverwhalePaymentOption();
        requestBindPageActions.selectBillingMethodOption();
        requestBindPageActions.agreeToElectronicSignature();
        requestBindPageActions.enterElectronicSignatureName("AB");
        requestBindPageActions.submitRequestToBind();
//        submissionStatusButtons.waitForBadgeRequestToBindUnderwritingReview();
        webUtils.sleep(3);

        submissionStatusButtons.clickOKButtonInBindRequestReceivedModal();
        
        String currentSubmissionURL = webUtils.getCurrentURL();
        Reporter.log("Submission url is : " + currentSubmissionURL);
        String submissionId = currentSubmissionURL.split("transportation/")[1].split("/")[0];
        System.out.println("Submission ID Adidas : " + submissionId);
        
        loginActions.logOut();
        loginActions.login(profileData.get("username"), profileData.get("password"));
        
        transportActions.enterIntoSearchField(submissionId);
        transportActions.clickSearchButton();
        transportActions.clickFirstSearchResultWithSubmissionId();
        
        // Approve Bind
        submissionStatusButtons.clickApproveBindButton();
        submissionStatusButtons.clickApproveBindInsideAreYouSureModal();
        submissionStatusButtons.confirmApproveBind();
        submissionStatusButtons.waitForBoundBadgeToAppear();

        // Create Endorsement
        submissionStatusButtons.clickCreateEndorsement();
        String dateToEnter = DateUtils.getFutureDateFromCurrent("MM/dd/yyyy", 14);
        submissionStatusButtons.enterEffectiveDate(dateToEnter);
        submissionStatusButtons.confirmCreateEndorsement();
        
     // Add a vehicle
        Map<String, String> vehicleData = (Map<String, String>) DataRecorder.VEHICLES_CACHE.get("VEHICLE_DATA_3");
        vehiclePageActions.setVehicleData(vehicleData);
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

		InvoicePDFReader.INVOICE_DOC_MAP.put("TC_04_11", invoiceDocNumber);
		invoiceDataValidator.validatePdfDataForTC_04_11();
		
		// we can enable this when we will have next test i.e TC_04_12
		// loginActions.logOut();
	}
}