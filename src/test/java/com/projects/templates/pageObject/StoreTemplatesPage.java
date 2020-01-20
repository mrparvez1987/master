package com.projects.templates.pageObject;


import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


	public class StoreTemplatesPage {
	WebDriver ldriver;
	private Alert alert;
		
		public StoreTemplatesPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		}
		
		@FindBy(xpath="//*[@id=\"content\"]/div[1]/div[3]/div[1]/img")
		WebElement iconProjects;
		
		@FindBy(id="menu-module-activity")
		WebElement autoActivities;
		
		@FindBy(xpath="//*[@id=\"menu-templates\"]/a")
		WebElement menuTemplates;
		
		@FindBy(linkText="New Template")
		WebElement btnNewTemplate;
		
		@FindBy(xpath="//*[@id=\"content\"]/div[2]/div[1]/img")
		WebElement iconStoreTemplate;
		
		@FindBy(xpath="//*[@id=\"content\"]/div[2]/div[1]")
		WebElement iconElementTemplate;
		
		@FindBy(xpath="//*[@id=\"Description\"]")
		WebElement txtDescription;
		
		@FindBy(xpath="//*[@id=\"IsMultiExecution\"]")
		WebElement chkMultiExecution;
		
		@FindBy(xpath="//*[@id=\"toggle_field_detail\"]")
		WebElement btnToggleDetail;
		
		@FindBy(xpath="//*[@id=\"toggle_metadata_dictionary\"]")
		WebElement btnMetaDataDictionary;
		
		@FindBy(xpath="//*[@class[contains(.,'Fields_grid_button_new')]]")
		WebElement btnNewField;
		
		@FindBy(xpath="//*[@id=\"aawgui_Fields_grid_temporary_0\"]/div[15]/div[1]/select")
		WebElement drFieldType;
		
		@FindBy(xpath="//*[@id=\"aawgui_Fields_grid_temporary_0\"]/div[15]/div[2]/select")
		WebElement drOptional;
		
		@FindBy(xpath="//*[@id=\"aawgui_Fields_grid_temporary_0\"]/div[15]/div[3]/select")
		WebElement drIdentifier;	
		
		@FindBy(xpath="//input[@colname[contains(.,'label')]]")
		WebElement txtCaption;
	
		@FindBy(xpath="//input[@colname[contains(.,'minimum')]]")
		WebElement txtMinValue;
		
		@FindBy(xpath="//input[@colname[contains(.,'maximum')]]")
		WebElement txtMaxValue;
	
		@FindBy(xpath="//input[@colname[contains(.,'itemattachmentname')]]")
		WebElement txtLooseAttachment;
		
		@FindBy(xpath="//*[starts-with(@id,\"ui-id\")]/li[1]/a")
		WebElement nameLooseAttachment;
				
		@FindBy(xpath="//div[@colname[contains(.,'instructions')]]")
		WebElement boxInstruction;
		
		@FindBy(xpath="//iframe[@id[contains(.,'ifr')]]")
		WebElement txtInstruction;
		
		@FindBy(xpath="//*[text()[contains(.,'Apply Changes')]]")
		WebElement btnApplyChanges;
		
		@FindBy(xpath="//*[@id=\"grid_responses_aawgui_Fields_grid_temporary_0_1_button_new\"]")
		WebElement btnAddResponse;
		
		@FindBy(xpath="//input[@colname[contains(.,'responsetext')]]")
		WebElement txtResponseText;
		
		@FindBy(xpath="//*[starts-with(@id,\"ui-id\")]/li[1]/a")
		WebElement elementResponse;
		
		@FindBy(xpath="//*[@id=\"criteria_grid_grid_responses_aawgui_Fields_grid_temporary_0_temporary_0\"]/div[10]/div/select")
		WebElement drReportResponse;	

		@FindBy(xpath="//select[@colname[contains(.,'multipleselection')]]")
		WebElement drMultipleSelection;
		
		@FindBy(xpath="//*[@id=\"criteria_grid_grid_responses_aawgui_Fields_grid_temporary_0_temporary_1\"]/div[12]/img")
		WebElement delResponse;
		
		@FindBy(xpath="//select[@colname[contains(.,'autoapprove')]]")
		WebElement drAutoApprovePic;
		
		@FindBy(xpath="//*[@id=\"aawgui_Fields_grid_temporary_0\"]/div[14]/div[22]/div/input")
		WebElement upldAttachment;
		
		@FindBy(xpath="//select[@colname[contains(.,'featureid')]]")
		WebElement drpfeatureLink;
		
		@FindBy(xpath="//select[@colname[contains(.,'exceptiontypeid')]]")
		WebElement drpExceptionType;	

		@FindBy(xpath="//input[@colname[contains(.,'datemin')]]")
		WebElement txtEarliestDate;
		
		@FindBy(xpath="//input[@colname[contains(.,'datemax')]]")
		WebElement txtLatesttDate;		
		
		@FindBy(xpath="//input[@colname[contains(.,'floatmin')]]")
		WebElement txtMinAmount;
		
		@FindBy(xpath="//input[@colname[contains(.,'floatmax')]]")
		WebElement txtMaxAmount;
		
		@FindBy(xpath="//select[@colname[contains(.,'scantypeid')]]")
		WebElement drpScanType;
		
		@FindBy(xpath="//select[@colname[contains(.,'autoapprove')]]")
		WebElement drpAutoApprove;
		
		@FindBy(xpath="//select[@colname[contains(.,'internalonly')]]")
		WebElement drpInternalUse;
		
		@FindBy(xpath="//input[@colname[contains(.,'hyperlink')]]")
		WebElement txtHyperlinkAddress;
		
		
		
		
		@FindBy(xpath="//input[@colname[contains(.,'label')]]")
		List<WebElement> multiCaption;
		
		@FindBy(xpath="//input[@colname[contains(.,'hyperlink')]]")
		List<WebElement> multiHyperlink;
		
		@FindBy(xpath="//input[@class[contains(.,'aawgui_attachment_filepicker')]]")
		List<WebElement> multiAttach;
		
		@FindBy(xpath="//option[text()='Numeric']")
		List<WebElement> multiNumericDropList;
		
		@FindBy(xpath="//option[text()='Text']")
		List<WebElement> multiTextDropList;
		
		@FindBy(xpath="//option[text()='List']")
		List<WebElement> multiListDropList;

		@FindBy(xpath="//option[text()='Picture']")
		List<WebElement> multiPictureDropList;
		
		@FindBy(xpath="//option[text()='Instructions']")
		List<WebElement> multiInstructionsDropList;

		@FindBy(xpath="//option[text()='In-Line Attachment']")
		List<WebElement> multiInLineAttachmentDropList;
	
		@FindBy(xpath="//option[text()='Feature Link']")
		List<WebElement> multiFeatureLinkDropList;

		@FindBy(xpath="//option[text()='Exception']")
		List<WebElement> multiExceptionDropList;
		
		@FindBy(xpath="//option[text()='Date']")
		List<WebElement> multiDateDropList;
		
		@FindBy(xpath="//option[text()='Currency']")
		List<WebElement> multiCurrencyDropList;
		
		@FindBy(xpath="//option[text()='Loose Attachment']")
		List<WebElement> multiLooseAttachmentDropList;
		
		@FindBy(xpath="//input[@colname[contains(.,'itemattachmentname')]]")
		List<WebElement> multiLooseAttachment;
		
		@FindBy(xpath="//option[text()='Scan Type']")
		List<WebElement> multiScanTypeDropList;
		
		@FindBy(xpath="//option[text()='Single Screen Wrapper']")
		List<WebElement> multiSingleScreenWrapperDropList;
		
		@FindBy(xpath="//option[text()='Signature']")
		List<WebElement> multiSignatureDropList;
		
		@FindBy(xpath="//option[text()='Hyperlink (URL, web address)']")
		List<WebElement> multiHyperDropList;
		
		@FindBy(xpath="//option[text()='Shopcom Order']")
		List<WebElement> multiShopcomDropList;
		
		@FindBy(id="//*[@id=\"ui-id-10\"]/li[1]/a")
		List<WebElement> responseList;
		
		
		
		@FindBy(xpath="//*[@id=\"controlA\"]/div[2]/div[3]/ul/li[1]/div")
		WebElement btnSubmitForReview;
		
		@FindBy(xpath="//*[@id=\"controlA\"]/div[2]/div[3]/ul/li[2]/div")
		WebElement btnCopyToNew;
		
		@FindBy(xpath="//*[@id=\"controlA\"]/div[2]/div[3]/ul/li[3]/div")
		WebElement btnToggleAdvanceMood;
		
		@FindBy(xpath="//*[@id=\"controlA\"]/div[2]/div[3]/ul/li[4]/div")
		WebElement btnEmulator;
		
		@FindBy(xpath="//*[@id=\"controlA\"]/div[2]/div[3]/ul/li[5]/div")
		WebElement btnExportToExcel;
		
		@FindBy(xpath="//*[@id=\"controlA\"]/div[2]/div[1]/ul/li[2]/div")
		WebElement btnSaveAndClose;
			
		
		
		
		
		
		public List<WebElement> getResponseElement() {
			return responseList;
		}
	
		public void clickProjectsIcon() {
			iconProjects.click();		
		}
		
		public void moveToActivities() {
			Actions actions = new Actions(ldriver);
			actions.moveToElement(autoActivities).build().perform();
		}
		
		public void clickTemplatesMenu() {
			menuTemplates.click();
		}
		
		public void clickNewTemplateButton() {
			btnNewTemplate.click();
		}
		
		public void clickStoreTemplate() {
			iconStoreTemplate.click();
		}
		
		public void clickElementTemplate(){
			iconElementTemplate.click();
		}
		
		public void sendDescription(String desc) {
			txtDescription.sendKeys(desc);
		}
		
		public void clickMultiExecutionBox() {
			chkMultiExecution.click();
		}
		
		public void clickToggleDetail() {
			btnToggleDetail.click();
		}
		
		public void clickMetaDataDictionary() {
			btnMetaDataDictionary.click();
		}
		
		public void clickNewFieldButton() {
			btnNewField.click();
		}
		
		
		
		public void sendCaption(String caption) {
			txtCaption.sendKeys(caption);
		}
		
		public void sendMinValue(String minValue) {
			txtMinValue.sendKeys(minValue);
		}
		
		public void sendMaxValue(String maxValue) {
			txtMaxValue.sendKeys(maxValue);
		}
		
		public void sendLooseAttachment(String loos) {
			txtLooseAttachment.sendKeys(loos);
		}
		
		public void getLoosAttachmentName() {
			nameLooseAttachment.click();
		}
		
		public void clickInstruction() {
			boxInstruction.click();
		}
		
		public void sendInstruction(String instruction) {	
			txtInstruction.sendKeys(instruction);
		}
		
		public void clickApplyChangesButton() {
			btnApplyChanges.click();
		}
		
		public void clickSubmitForReveiw() {
			btnSubmitForReview.click();
		}
			
		public void clickAddResponse() {
			btnAddResponse.click();
		}
		
		public void sendResponseText(String response) {
			txtResponseText.sendKeys(response);
		}
		public WebElement getResponse() {
			return txtResponseText;
		}
		
		public WebElement response() {
			return elementResponse;
		}
		
		public void clickResponseElement() {
			elementResponse.click();
		}
		
		public void acceptAlert(){
			alert = ldriver.switchTo().alert();
			alert.accept();
		}
		public void clickDeleteResponse() {
			delResponse.click();
		}
		
		public void clickAttachment() {
			upldAttachment.click();
		}
		
		public void sendEarliestDate(String earlieastDate) {
			txtEarliestDate.sendKeys(earlieastDate);
		}
		
		public void sendLatesttDate(String latestDate) {
			txtLatesttDate.sendKeys(latestDate);
		}
		
		public WebElement getEarliestDate() {
			return txtEarliestDate;
		}
		
		public WebElement getLatestDate() {
			return txtLatesttDate;
		}
		
		public void sendMinAmount(String minAmount) {
			txtMinAmount.sendKeys(minAmount);
		}	

		public void sendMaxAmount(String maxAmount) {
			txtMaxAmount.sendKeys(maxAmount);
		}	

		public WebElement getMinAmount() {
			return txtMinAmount;
		}
		
		public WebElement getMaxAmount() {
			return txtMaxAmount;
		}
		
		public void sendHyperlinkAddress(String hyperlink) {
			txtHyperlinkAddress.sendKeys(hyperlink);
		}
		
		
		
		
		
		
		
		public void selectFieldType(String fieldType) {
			Select select=new Select(drFieldType);
			select.selectByValue(fieldType);
		}
		
		public void selectFieldTypeByText(String fieldText) {
			Select select=new Select(drFieldType);
			select.selectByVisibleText(fieldText);
		}
		
		public void selectOptional(String option) {
			Select select=new Select(drOptional);
			select.selectByValue(option);
		}
		
		public void selectIdentifierField(String identifier) {
			Select select=new Select(drIdentifier);
			select.selectByValue(identifier);
		}
		
		public void selectReportResponse(String report) {
			Select select=new Select(drReportResponse);
			select.selectByValue(report);
		}
		
		public void selectMultipleSelection(String multiple) {
			Select select=new Select(drMultipleSelection);
			select.selectByValue(multiple);
		}
		
		public void selectAutoApprovePictures(String autoApprovePic) {
			Select select=new Select(drAutoApprovePic);
			select.selectByValue(autoApprovePic);
		}
		
		public void selectFeatureLinkType(String featureLink) {
			Select select=new Select(drpfeatureLink);
			select.selectByValue(featureLink);
		}
		
		public void selectExcetptionType(String exceptionType) {
			Select select=new Select(drpExceptionType);
			select.selectByValue(exceptionType);
		}
		
		public void selectScanType(String scanType) {
			Select select=new Select(drpScanType);
			select.selectByValue(scanType);
		}
		
		public void selectAutoApprovePic(String autoApprove) {
			Select select=new Select(drpAutoApprove);
			select.selectByValue(autoApprove);
		}
		
		public void selectInternalUse(String internalUse) {
			Select select=new Select(drpInternalUse);
			select.selectByValue(internalUse);
		}
		
		
		
		
		
		
		public List<WebElement> getMultiCaption() {
			return multiCaption;
		}
		
		public List<WebElement> getMultihyperlink() {
			return multiHyperlink;
		}
		
		public List<WebElement> getMultiattach() {
			return multiAttach;
		}
		
		public List<WebElement> getMultiNumericdroplist() {
			return multiNumericDropList;
		}	
		
		public List<WebElement> getMultiTextdroplist() {
			return multiTextDropList;
		}	
		
		public List<WebElement> getMultiListdroplist() {
			return multiListDropList;
		}	
		
		public List<WebElement> getMultiPicturedroplist() {
			return multiPictureDropList;
		}	
		
		public List<WebElement> getMultiInstructionsdroplist() {
			return multiInstructionsDropList;
		}	
		
		public List<WebElement> getMultiInLineAttachmentdroplist() {
			return multiInLineAttachmentDropList;
		}	
		
		public List<WebElement> getMultiFeatureLinkdroplist() {
			return multiFeatureLinkDropList;
		}	

		public List<WebElement> getMultiDatedroplist() {
			return multiDateDropList;
		}
		
		public List<WebElement> getMultiCurrencydroplist() {
			return multiCurrencyDropList;
		}
		
		public List<WebElement> getMultiLooseAttachmentdroplist() {
			return multiLooseAttachmentDropList;
		}
		
		public List<WebElement> getMultiScanTypedroplist() {
			return multiScanTypeDropList;
		}
		
		public List<WebElement> getMultiSingleScreenWrapperdroplist() {
			return multiSingleScreenWrapperDropList;
		}
		
		public List<WebElement> getMultiSignaturedroplist() {
			return multiSignatureDropList;
		}
		
		public List<WebElement> getMultihyperdroplist() {
			return multiHyperDropList;
		}
		
		public List<WebElement> getMultiShopcomdroplist() {
			return multiShopcomDropList;
		}
		
		public List<WebElement> getMultiLooseAttachment() {
			return multiLooseAttachment;
		}
		
		public void uploadFile(String filePath) throws Exception {
			

			Robot robot=new Robot();
			robot.setAutoDelay(1000);
			
			StringSelection stringSelection=new StringSelection(filePath);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection,null);
			robot.setAutoDelay(2000);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);
			
			//robot.setAutoDelay(2000);
			
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		}
		
		
	
		
	
	}
