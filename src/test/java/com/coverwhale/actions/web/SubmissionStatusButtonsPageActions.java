package com.coverwhale.actions.web;

import com.coverwhale.utils.selenium.WebUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Reporter;

import java.util.List;

public class SubmissionStatusButtonsPageActions {

	private static final Logger LOGGER = LoggerFactory.getLogger(SubmissionStatusButtonsPageActions.class);
	private WebDriver driver;
	private WebUtils webUtils;

	@FindBy(name = "company_id")
	public WebElement companyDropdown;

	@FindBy(xpath = "//button[contains(.,'Finish App to Quote')]")
	public WebElement finsihApptoQuoteButton;

	@FindBy(xpath = "//button[contains(.,'Resume Application to Quote')]")
	public WebElement resumeApptoQuoteButton;

	// Click on Change Application Button
	@FindBy(xpath = "//button[contains(.,'Change Application')]")
	public WebElement changeApplicationButton;
	
	@FindBy(css = "#validateConfirmQuoteForm button")
	public WebElement approveQuoteButton;

	@FindBy(xpath = "//div[@id='submissionStatusButtons']//a[.='Request to Bind']")
	public WebElement requestToBindButton;

	@FindBy(css = "#approveQuoteForm button")
	public WebElement confirmApproveQuoteButton;

	@FindBy(xpath = "(//a[@class='btn btn-primary btn-lg btn-block'])[1]")
	public WebElement approveBindButton;

	@FindBy(xpath = "//button[.='Approve Bind']")
	public WebElement approveBindButtonAfterReinstatementDialogues;

	@FindBy(css = "a[data-target='#approveBind']")
	public WebElement approveBindAreYouSureButton;

	@FindBy(xpath = "(//input[@name='bind_approved_al'])[2]")
	public WebElement excludeALButton ;

	@FindBy(css = "#approveBind div.modal-footer button")
	public WebElement confirmApproveBindButton;

	@FindBy(xpath = "//div[@id='submissionStatusButtons']//a[.='Create Endorsement']")
	public WebElement createEndorsementButton;

	@FindBy(css = "a[href='#confirmRequestQuote']")
	public WebElement requestQuoteButton;

	@FindBy(css = "#confirmRequestQuote div.modal-footer button.btn.btn-primary.btn-lg")
	public WebElement confirmRequestQuoteButton;

	@FindBy(css = "[id='agree_terms']")
	public WebElement agreeTermsInsideRequestQuote;

	@FindBy(css = "#createEndorsementModal div.modal-footer button.btn-primary")
	public WebElement confirmCreateEndorsementButton;

	@FindBy(css = "#updateSubmittedUserForm button")
	public WebElement saveButton;

	@FindBy(xpath = "//div[@id='submissionStatusButtons']//a[.='Request Cancel']")
	public WebElement requestCancelButton;

	@FindBy(xpath = "//a[contains(text(),'Approve Cancel')]")
	public WebElement approveCancelButton;

	@FindBy(xpath = "//button[.='Approve Cancel']")
	public WebElement confirmApproveCancelButton;

	@FindBy(css = "button[data-target='#reinstatement']")
	public WebElement requestReinstatementButton;

	@FindBy(xpath = "//a[.='Acknowledge']")
	public WebElement requestReinstatementAcknowledgeButton;

	// Status badges
	@FindBy(xpath = "//span[contains(@class,'badge-pill') and contains(text(),'Quoted')]")
	public WebElement badgeQuoted;

	@FindBy(xpath = "(//a[@class='btn btn-primary btn-lg btn-block'])[1]")
	public WebElement badgeRequestToBindUnderwritingReview;

	@FindBy(xpath = "//span[contains(@class,'badge-pill')][.='Bound']")
	public WebElement badgeBound;

	@FindBy(xpath = "//span[contains(@class,'badge-pill')][.='You must Request Quote']")
	public WebElement badgeYouMustRequestQuote;

	@FindBy(xpath = "//span[contains(@class,'badge-pill')][.='Underwriting Review']")
	public WebElement badgeUnderwritingReview;

	@FindBy(css = "#requestCancelModal div.modal-footer button.btn.btn-danger.btn-lg")
	public WebElement confirmRequestCancelButton;

	@FindBy(xpath = "//span[contains(@class,'badge-pill')][.='Cancel Requested']")
	public WebElement badgeRequestToCancel;

	@FindBy(xpath = "//span[contains(@class,'badge-pill')][.='Canceled']")
	public WebElement badgeCancel;

	@FindBy(css = "a[data-target='#submissionOverviewModal']")
	public WebElement submissionOverview;

	@FindBy(css = "button[class='btn btn-primary ml-2 save-submission-overview']")
	public WebElement saveChanges;



	// limits tabs

	@FindBy(css = "a[aria-controls='limits']")
	public WebElement limitsTab;

	// endorsement tabs
	// drivers
	@FindBy(css = "a[aria-controls='drivers']")
	public WebElement driversNavTab;

	@FindBy(css = "a.editDriver")
	public WebElement editDriverButton;

	@FindBy(id = "edit_name_first")
	public WebElement editFirstNameField;

	@FindBy(css = "input[id='edit_total_major_violations']")
	WebElement major_ViolField;

	@FindBy(id = "vehicle_id_number")
	public WebElement editVinNumberField;

	@FindBy(css = "#EditDriver div.modal-footer button")
	public WebElement continueButtonInDriversView;

	@FindBy(css = "input[name='effective_date_transaction']")
	public WebElement effectiveDateCalendarInsideCreateEndorsement;

	@FindBy(css = "input[name='effective_date_transaction_cancel']")
	public WebElement effectiveDateCalendarInsideRequestCancelModal;

	// vehicles
	@FindBy(css = "a[aria-controls='vehicles']")
	public WebElement vehiclesNavTab;

	@FindBy(css = "a.deleteVehicle")
	public List<WebElement> removeVehicleButtonlist;

	@FindBy(css = "a.deleteVehicle")
	public WebElement removeVehicleButton;

	@FindBy(css = "a.editVehicle")
	public WebElement changeVehicleButton;

	@FindBy(css = "a[id='list-insured-list']")
	public WebElement insuredTab;


	// trailers
	@FindBy(css = "a[aria-controls='trailers']")
	public WebElement trailersNavTab;

	@FindBy(css = "a.deleteTrailer")
	public List<WebElement> removeTrailerButtonlist;

	@FindBy (css = "a.deleteTrailer")
	public WebElement removeTrailerButton;

	// document links
	@FindBy(xpath = "//div[@id='submissionStatusButtons']//a//h3[.='Invoice']")
	public WebElement invoiceDocumentLink;
	
	@FindBy(xpath = "//div[@id='submissionStatusButtons']//a//h3[.='Preview Quote']")
	public WebElement quoteDocumentLink;

	@FindBy(xpath = "//div[@id='submissionStatusButtons']//a//h3[.='Preview Quote']//parent::a")
	public WebElement invoiceDocumentLinkUrl;

	// fade popup that blocks the UI
	@FindBy(css = "div.modal-backdrop.fade.show")
	public List<WebElement> fadePopUp;

	// fade popup that blocks the UI
	@FindBy(xpath = "//h5[.='Broker Contact']//following-sibling::button")
	public List<WebElement> brokerContactModalCloseButton;
	
	// Bind request received OK button in modal
	@FindBy(css = "#submissionReminderRequestToQuote div.modal-footer button")
	public WebElement bindRequestReceivedButton;
	
	@FindBy(xpath = "//button[@type='submit' and .='Resume Application to Quote']")
	public WebElement confirmResumeApplicationToQuoteModal;
	
	@FindBy(css = "#files-tab")
	public WebElement filesTab;
	
	@FindBy(xpath = "//div[@class='code' and contains(text(),'404')]")
	public List<WebElement> notFoundErrror;
	
	@FindBy(xpath = "//div[@id='filesList' and contains(@class,table-striped) ]//tbody//tr//form//select//option[@selected and .='CWIS Invoice']/parent::select/parent::form/parent::td/following-sibling::td[2]//a")
	public List<WebElement> downloadLatesCWISInvoiceDocument;

	public boolean doesSubmissionExists() {
		Reporter.log("Checking if the submission exists or not, orr we get a [404 Not found] for submission");
		
		return notFoundErrror.size() < 1;
	}
	
	public boolean downloadLatestCWISInvoiceDocument() {
		boolean isFilePresentToDownload = false;
		Reporter.log("Checking latest CWIS Invoice download button in Files tab");
		if (downloadLatesCWISInvoiceDocument.size() > 0) {
			isFilePresentToDownload = true;
			webUtils.scrollingToElementofAPage(downloadLatesCWISInvoiceDocument.get(0));
			Reporter.log("Downloading latest CWIS Invoice document button from Files tab");
			webUtils.retryingClick(downloadLatesCWISInvoiceDocument.get(0));
			webUtils.sleep(8); // just so that the document gets downloaded peacefully :)
		}
		
		return isFilePresentToDownload;
	}

	public void clickFinishAppToQuoteButton() {
		Reporter.log("Clicking [Finish App to Quote] button");
		webUtils.waitForElementVisibility(finsihApptoQuoteButton, 30);
		webUtils.retryingClick(finsihApptoQuoteButton);
	}
	
	public void clickOnFilesTab() {
		Reporter.log("Clicking tab [Files]");
		webUtils.waitForElementVisibility(filesTab, 30);
		webUtils.retryingClick(filesTab);
	}
	
	public void clickOKButtonInBindRequestReceivedModal() {
		Reporter.log("Clicking [OK] button in modal [Bind Request Received!]");
		webUtils.waitForElementVisibility(bindRequestReceivedButton, 30);
		webUtils.actionClick(bindRequestReceivedButton);
		webUtils.retryingClick(bindRequestReceivedButton);
	}

	public void clickResumeAppToQuoteButton() {
		Reporter.log("Clicking [Resume Application to Quote] button");
		webUtils.refreshBrowser();
		webUtils.waitForElementVisibility(resumeApptoQuoteButton, 30);
		webUtils.click(resumeApptoQuoteButton);
	}
	
	public void confirmResumeApplicationToQuoteModal() {
		Reporter.log("Clicking OK button in [Resume Application to Quote] modal");
		webUtils.waitForElementVisibility(confirmResumeApplicationToQuoteModal, 30);
		webUtils.retryingClick(confirmResumeApplicationToQuoteModal);
	}

	public void clickApproveQuoteButton() {
		Reporter.log("Clicking [Approve Quote] button");
		webUtils.waitForElementVisibility(approveQuoteButton, 180);
		webUtils.retryingClick(approveQuoteButton);
	}

	public void clickInsuredTab() {
		Reporter.log("Clicking [Approve Quote] button");
		webUtils.waitForElementVisibility(insuredTab, 180);
		webUtils.click(insuredTab);
	}

	public void confirmApproveQuote() {
		Reporter.log("Clicking [Approve Quote] button");
		webUtils.waitForElementVisibility(confirmApproveQuoteButton, 30);
		webUtils.retryingClick(confirmApproveQuoteButton);
	}

	public void clickOnLimitsTab() {
		Reporter.log("Clicking On Limits Tab");
		webUtils.waitForElementVisibility(limitsTab, 30);
		webUtils.click(limitsTab);
	}

	public void clickRequestToBindButton() {
		Reporter.log("Clicking [Request to Bind] button");
	//	webUtils.scrollingToElementofAPage(requestToBindButton);
		webUtils.waitForElementVisibility(requestToBindButton, 60);
		webUtils.retryingClick(requestToBindButton);
	}

	public void clickRequestReinstatementButton() {
		Reporter.log("Clicking [Request Reinstatement] button");
		webUtils.waitForElementVisibility(requestReinstatementButton, 30);
		webUtils.retryingClick(requestReinstatementButton);
	}

	public void clickRequestReinstatementAcknowledgeButton() {
		Reporter.log("Clicking [Request Reinstatement Acknowledge] button");
		webUtils.waitForElementVisibility(requestReinstatementAcknowledgeButton, 30);
		webUtils.retryingClick(requestReinstatementAcknowledgeButton);
	}

	public void clickRequestQuote() {
		Reporter.log("Clicking [Request Quote] button");
		webUtils.refreshBrowser();
		webUtils.waitForElementVisibility(requestQuoteButton, 30);
		webUtils.scrollingToElementofAPage(requestQuoteButton);
		webUtils.click(requestQuoteButton);
	}

	public void closeBrokerContactModalIfExists() {
		Reporter.log("Clicking on close button of [Broker Contact] modal");
		if (brokerContactModalCloseButton.size() > 0) {
			webUtils.clickUntilElementIsInvisible(brokerContactModalCloseButton);
		}
	}

	public void agrreToRequestQuote() {
		Reporter.log("Checking box [ I agree to the Terms of Use, Privacy Policy and Brokerage Agreement.]");
		webUtils.waitForElementVisibility(agreeTermsInsideRequestQuote, 30);
		webUtils.retryingClick(agreeTermsInsideRequestQuote);
	}

	public void confirmRequestQuote() {
		Reporter.log("Clicking [Request Quote] button present inside are you sure?  modal");
		webUtils.waitForElementVisibility(confirmRequestQuoteButton, 30);
		webUtils.retryingClick(confirmRequestQuoteButton);
	}

	public void clickApproveBindButton() {
		Reporter.log("Clicking [Approve Bind] button");
		webUtils.waitForElementVisibility(approveBindButton, 30);
		webUtils.retryingClick(approveBindButton);
	}

	public void clickApproveBindInsideAreYouSureModal() {
		Reporter.log("Clicking [Request to Bind] button present inside [Approve Bind - Are You Sure?] modal");
		webUtils.waitForElementVisibility(approveBindAreYouSureButton, 30);
		webUtils.retryingClick(approveBindAreYouSureButton);
	}

	public void clickExcludeALRadioButton() {
		Reporter.log("Clicking Exclude AL Radio Button button present inside [Approve Bind - Are You Sure?] modal");
		webUtils.waitForElementVisibility(excludeALButton, 30);
		webUtils.retryingClick(excludeALButton);
	}

	public void confirmApproveBind() {
		Reporter.log("Clicking [Request to Bind] button that comes after passing are you sure modal");
		webUtils.waitForElementVisibility(confirmApproveBindButton, 30);
		webUtils.retryingClick(confirmApproveBindButton);
	}

	public void clickCreateEndorsement() {
		Reporter.log("Clicking [Create Endorsement] button.");
		webUtils.waitForElementVisibility(createEndorsementButton, 30);
		webUtils.retryingClick(createEndorsementButton);
	}

	public void confirmCreateEndorsement() {
		Reporter.log("Clicking [Create Endorsement] button present inside modal with Effetcive date.");
		webUtils.waitForElementVisibility(confirmCreateEndorsementButton, 30);
		webUtils.retryingClick(confirmCreateEndorsementButton);
	}

	public void clickRequestCancel() {
		Reporter.log("Clicking [Request Cancel] button.");
		webUtils.waitForElementVisibility(requestCancelButton, 30);
		webUtils.retryingClick(requestCancelButton);
	}
	public void confirmRequestCancel() {
		Reporter.log("Clicking [Request Cancel] button present inside modal with Effective date.");
		webUtils.waitForElementVisibility(confirmRequestCancelButton, 30);
		webUtils.retryingClick(confirmRequestCancelButton);
	}
	public void clickApproveCancel() {
		Reporter.log("Clicking [Approve Cancel] button after you requested to cancel");
		webUtils.waitForElementVisibility(approveCancelButton, 30);
		webUtils.retryingClick(approveCancelButton);
	}
	public void confirmApproveCancel() {
		Reporter.log("Clicking [Approve Cancel] button  inside 'Approve Cancel' modal");
		webUtils.waitForElementVisibility(confirmApproveCancelButton, 30);
		webUtils.retryingClick(confirmApproveCancelButton);
	}

	// badges
	public void waitForQuotedBadgeToAppear() {
		Reporter.log("Waiting for [Quoted] badge to appear");
		webUtils.waitForElementVisibility(badgeQuoted, 300);
	}

	public void waitForBadgeRequestToBindUnderwritingReview() {
		Reporter.log("Waiting for [Request to Bind (Underwriting Review)] badge to appear");
		webUtils.waitForElementVisibility(badgeRequestToBindUnderwritingReview, 300);
	}

	public void waitForBoundBadgeToAppear() {
		Reporter.log("Waiting for [Bound] badge to appear");
		webUtils.waitForElementVisibility(badgeBound, 300);
	}

	public void waitForYouMustRequestBadgeToAppear() {
		Reporter.log("Waiting for [You must Request Quote] badge to appear");
		webUtils.waitForElementVisibility(badgeYouMustRequestQuote, 300);
	}

	public void waitForUnderwritingReviewBadgeToAppear() {
		Reporter.log("Waiting for [Underwriting Review] badge to appear");
		webUtils.waitForElementVisibility(badgeUnderwritingReview, 300);
	}

	public void waitForRequestToCancelBadgeToAppear() {
		Reporter.log("Waiting for [Request to Cancel] badge to appear");
		webUtils.waitForElementVisibility(badgeRequestToCancel, 300);
	}

	public void waitForCanceledBadgeToAppear() {
		Reporter.log("Waiting for [Canceled] badge to appear");
		webUtils.waitForElementVisibility(badgeCancel, 300);
	}

	// date format is 10/26/2021
	public void enterEffectiveDate(String date) {
		Reporter.log("Entering effective date as" + date);
		webUtils.waitForElementVisibility(effectiveDateCalendarInsideCreateEndorsement, 10);
		webUtils.setValueAttribute(effectiveDateCalendarInsideCreateEndorsement, date);
	}

	public void enterEffectiveDateInRequestCancelModal(String date) {
		Reporter.log("Entering effective date as" + date + "in [Request Cancel Modal]");
		webUtils.waitForElementVisibility(effectiveDateCalendarInsideRequestCancelModal, 10);
		webUtils.setValueAttribute(effectiveDateCalendarInsideRequestCancelModal, date);
	}

	// endorsement tabs

	// Drivers
	public void clickDriversTab() {
		Reporter.log("Clicking [Drivers] tab inside endorsement nav bar");
		webUtils.waitForElementVisibility(driversNavTab, 30);
		webUtils.click(driversNavTab);
	}

	public void clickEditDriverButton() {
		Reporter.log("Clicking [Edit] button inside drivers tab");
		webUtils.waitForElementVisibility(editDriverButton, 30);
		webUtils.click(editDriverButton);
	}

	public void clickContinueDriverButton() {
		Reporter.log("Clicking [Continue] button inside drivers tab");
		webUtils.waitForElementVisibility(continueButtonInDriversView, 30);
		webUtils.click(continueButtonInDriversView);
	}

	public void enterFirstNameInDriverEditForm(String name) {
		Reporter.log("Entering name as : " + name + " in edit driver form");
		webUtils.waitForElementVisibility(editFirstNameField, 30);
		webUtils.enterText(editFirstNameField, name);
	}

	public void enterNumberOfMajorViolOnDriverTab(String autoFillMajorViol) {
		Reporter.log("Entering driver number of MajorViol:"+autoFillMajorViol+"in edit driver form");
		webUtils.waitForElementVisibility(editFirstNameField, 30);
		webUtils.enterText(major_ViolField,autoFillMajorViol);
	}

	// Vehicles
	public void clickVehiclesTab(){
		Reporter.log("Clicking [Vehicles] tab inside endorsement nav bar");
		webUtils.waitForElementVisibility(vehiclesNavTab, 30);
		webUtils.click(vehiclesNavTab);
	}

	public void clickRemoveVehicleButton(int indexToRemove) {
		Reporter.log("Clicking [Remove] button inside vehicles tab");
		webUtils.waitForElementVisibility(removeVehicleButton, 30);
		webUtils.actionClick(removeVehicleButtonlist.get(indexToRemove));
	}

	public void clickChangeVehicleButton() {
		Reporter.log("Clicking [Change] button inside vehicles tab");
		webUtils.waitForElementVisibility(changeVehicleButton, 30);
		webUtils.actionClick(changeVehicleButton);
	}
	public void enterVinNumberInDriverEditForm(String vin) {
		Reporter.log("Entering vin as : " + vin + " in edit vehicle form");
		webUtils.waitForElementVisibility(editVinNumberField, 30);
		webUtils.enterText(editVinNumberField, vin);
	}


	// Trailers
	public void clickTrailersTab(){
		Reporter.log("Clicking [Trailers] tab inside endorsement nav bar");
		webUtils.waitForElementVisibility(trailersNavTab, 30);
		webUtils.click(trailersNavTab);
	}

	public void clickRemoveTrailerButton(int indexToRemove) {
		Reporter.log("Clicking [Remove] button inside trailers tab");
		webUtils.waitForElementVisibility(removeTrailerButton, 30);
		webUtils.actionClick(removeTrailerButtonlist.get(indexToRemove));
	}

	// Document links
	public void openInvoiceDocument() {
		Reporter.log("Opening invoice document");
		webUtils.waitForElementVisibility(invoiceDocumentLink, 30);
		webUtils.click(invoiceDocumentLink);
	}
	
	public void openQuoteDocument() {
		Reporter.log("Opening quote document");
		webUtils.waitForElementVisibility(quoteDocumentLink, 30);
		webUtils.click(quoteDocumentLink);
	}

	// Change Application
	public void clickChangeApplication() {
		Reporter.log("Click on Change Application");
		webUtils.click(changeApplicationButton);
	}

	public String getDocumentURL() {
		Reporter.log("Getting invoice document URL");
		webUtils.waitForElementVisibility(invoiceDocumentLinkUrl, 30);
		String invoiceDocumentURL = webUtils.getTextUsingAttribute(invoiceDocumentLinkUrl, "href");
		Reporter.log("Document URL is: " + invoiceDocumentURL);

		return invoiceDocumentURL;
	}

	public SubmissionStatusButtonsPageActions(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		webUtils = new WebUtils(driver);
	}

	public void clickSubmissionOverview() {
		Reporter.log("Clicking Submission Overview button");
		webUtils.waitForElementVisibility(submissionOverview, 30);
		webUtils.scrollToElementAndClickUsingJS(submissionOverview);
	}

	public void confirmChanges() {
		Reporter.log("Clicking Save changes button");
		webUtils.waitForElementVisibility(saveChanges, 30);
		webUtils.retryingClick(saveChanges);
	}
}
