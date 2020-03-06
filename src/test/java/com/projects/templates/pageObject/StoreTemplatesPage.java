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
		
		@FindBy(xpath="//*[@id=\"content\"]/div[2]/div[2]/img")
		WebElement iconItemTemplate;
		
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
		
		@FindBy(xpath="//*[@class[contains(.,'Fields_grid_button_new')] and text()='New Field']")
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
		
		@FindBy(xpath="//div[@class[contains(.,'ui-dialog-content ui-widget-content')]]/textarea")
		WebElement boxValue;	
		
		@FindBy(xpath="//div[@class[contains(.,'betterbutton  grid_criteria_Fields_')] and text()='Add']")
		WebElement btnCriteriaAdd;	
			
		@FindBy(xpath="//*[contains(text(),\"Template #\")]")
		WebElement txtTemplate;	
		
		@FindBy(xpath="//*[@id=\"criteria_grid_grid_criteria_aawgui_Fields_grid_temporary_0_temporary_0\"]/div[11]/div/select")
		WebElement boxComp;
		
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
		
		@FindBy(xpath="//div[@class[contains(.,'criteria_grid_column_content criteria_grid_column_content_value')]]")
		WebElement valuecriteria;
		
		@FindBy(xpath="//div[text()='Save']")
		WebElement btnSave;	
		
		
		
		@FindBy(xpath="//select[@colname[contains(.,'featureid')]]")
		List<WebElement> multidrpfeatureLink;
		
		@FindBy(xpath="//select[@colname[contains(.,'scantypeid')]]")
		List<WebElement> multidrpScanType;
		
		@FindBy(xpath="//input[@colname[contains(.,'hyperlink')]]")
		List<WebElement> multitxtHyperlinkAddress;

		@FindBy(xpath="//input[@colname[contains(.,'floatmax')]]")
		List<WebElement> multitxtMaxAmount;
		
		@FindBy(xpath="//input[@colname[contains(.,'floatmin')]]")
		List<WebElement> multitxtMinAmount;
		
		@FindBy(xpath="//input[@colname[contains(.,'responsetext')]]")
		List<WebElement> multitxtResponseText;
		
		@FindBy(xpath="//select[@colname[contains(.,'multipleselection')]]")
		List<WebElement> multidrMultipleSelection;

		@FindBy(xpath="//select[@colname[contains(.,'exceptiontypeid')]]")
		List<WebElement> multidrpExceptionType;	
		
		@FindBy(xpath="//input[@class[contains(.,'aawgui_attachment_filepicker')]]")
		List<WebElement> multiupldAttachment;
			
		@FindBy(xpath="//div[@id[contains(.,'grid_criteria_aawgui_Fields_grid_temporary')] and text()='Add']")
		List<WebElement> multibtnCriteriaAdd;	
		
		@FindBy(xpath="//*[text()[contains(.,'Apply Changes')]]")
		List<WebElement> multibtnApplyChanges;
		
		@FindBy(xpath="//select[@colname[contains(.,'internalonly')]]")
		List<WebElement> multidrpInternalUse;
		
		@FindBy(xpath="//select[@colname[contains(.,'autoapprove')]]")
		List<WebElement> multidrpAutoApprove;	
		
		@FindBy(xpath="//input[@colname[contains(.,'maximum')]]")
		List<WebElement> multiMaxValue;
			
		@FindBy(xpath="//div[@colname[contains(.,'instructions')]]")
		List<WebElement> multiboxInstruction;
			
		@FindBy(xpath="//input[@colname[contains(.,'datemin')]]")
		List<WebElement> multiEarliestDate;
		
		@FindBy(xpath="//input[@colname[contains(.,'datemax')]]")
		List<WebElement> multiLatesttDate;			
		
		@FindBy(xpath="//*[@class[contains(.,'Fields_grid_button_new')] and text()='New Field']")
		List<WebElement> multiNewField;
		
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
		
		@FindBy(xpath="//div[@colname[contains(.,'instructions')]]")
		List<WebElement> multiInstruction;
			
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
		
		@FindBy(xpath="//input[@colname[contains(.,'metatypetext')]]")
		List<WebElement> multiSourceList;
		
		@FindBy(xpath="//*[@class[contains(.,'ui-button ui-corner-all ui-widget')] and text()='Apply Changes']")
		List<WebElement> ApplyChanges;
			
		
		
		
		
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
		
		public void clickItemTemplate() {
			iconItemTemplate.click();
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
		
		public void sendValue(String value) {
			boxValue.sendKeys(value);
		}
		
		public void clickValue() {
			valuecriteria.click();
		}
		
		public void clickSave() {
			btnSave.click();
		}
			
		public void clickCriteriaAddButton() {
			btnCriteriaAdd.click();
		}	
		
		
		
		
		
		public void selectComp(String comp) {
			Select select=new Select(boxComp);
			select.selectByVisibleText(comp);
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
		
		
		
		
		
		public List<WebElement> getApplyChangesButton() {
			return ApplyChanges;
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
		
		public List<WebElement> getMultiInstruction() {
			return multiInstruction;
		}
		
		public List<WebElement> getMultisource() {
			return multiSourceList;
		}	
		
		public List<WebElement> getMultiNewFieldButton() {
			return multiNewField;
		}
			
		public List<WebElement> getMultiEarliestDate() {
			return multiEarliestDate;
		}		
		
		public List<WebElement> getMultiLatestDate() {
			return multiLatesttDate;
		}
		
		public List<WebElement> getMultiInstructionBox() {
			return multiboxInstruction;
		}
		
		public List<WebElement> getMultiMaxValue() {
			return multiMaxValue;
		}
		
		public List<WebElement> getMultiAutoApproveDrop() {
			return multidrpAutoApprove;
		}
		
		public List<WebElement> getMultiInterUSeDrop() {
			return multidrpInternalUse;
		}
		
		public List<WebElement> getMultiApplyChangeBtn() {
			return multibtnApplyChanges;
		}	
		
		public List<WebElement> getMultiCriteriaAdd() {
			return multibtnCriteriaAdd;
		}
			
		public List<WebElement> getMultiUploadAttachment() {
			return multiupldAttachment;
		}
		
		public List<WebElement> getMultiExceptionType() {
			return multidrpExceptionType;
		}
		
		public List<WebElement> getMultiMultipleSelection() {
			return multidrMultipleSelection;
		}
		
		public List<WebElement> getMultiResponseText() {
			return multitxtResponseText;
		}
				
		public List<WebElement> getMultiMinAmount() {
			return multitxtMinAmount;
		}
		
		public List<WebElement> getMultiMaxAmount() {
			return multitxtMaxAmount;
		}
		
		public List<WebElement> getMultiHyperAddBox() {
			return multitxtHyperlinkAddress;
		}
		
		public List<WebElement> getMultiScanType() {
			return multidrpScanType;
		}
		
		public List<WebElement> getMultiFeatureLink() {
			return multidrpfeatureLink;
		}
			
		public WebElement tempText() {
			return txtTemplate;
		}
		
		
		
		public void uploadFile(String filePath) throws Exception {
			
			Robot robot=new Robot();
			robot.setAutoDelay(2000);
			
			StringSelection stringSelection=new StringSelection(filePath);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection,null);
			robot.setAutoDelay(3000);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);
			
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		}
		
		
		public void gotoBottomPage() throws Exception {
			
			Robot robot=new Robot();
			robot.setAutoDelay(2000);
			
			StringSelection stringSelection=new StringSelection(null);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection,null);
			robot.setAutoDelay(3000);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_END);
			
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_END);
					
		}
	
		
		
	
	    
	}
	
		
		
	
	
