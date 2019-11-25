package com.escalations.pageObjects;


import java.util.Calendar;
import java.util.TimeZone;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

	public class EscalationPage {
		WebDriver ldriver;
		private Alert alert;
	public EscalationPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
		@FindBy(xpath="//*[@id=\"content\" ] /div[2] //*[@alt=\"Escalations\"]")
		WebElement iconEscalations;
	
		@FindBy(xpath="//*[@id=\"controlA\"]/div[2]/div/ul/li/a")
		WebElement btnNew;
	
		@FindBy(xpath="//*[@id=\"fm\"]/dl/div[1]")
		WebElement textstatus;
	
		@FindBy(id="ElementId")
		WebElement txtElementId;
		
		@FindBy(xpath="//*[@id=\"ui-id-1\"]/li/a")
		WebElement lnkElementId;
		
		@FindBy(xpath="//*[@id='ClientId']")
		WebElement drpClient;
		
		@FindBy(id="Summary")
		WebElement txtSummery;
		
		@FindBy(id="DueDate")
		WebElement txtDueDate;
		
		@FindBy(id="ContactName")
		WebElement txtContactName;
		
		@FindBy(id="StoreList")
		WebElement txtSoreList;
		
		@FindBy(xpath="//*[@id=\"Description_ifr\"]")
		WebElement frameDescIssue;
		
		@FindBy(xpath="//*[@id=\"AndersonAtFault\"]")
		WebElement drpResult;
		
		@FindBy(xpath="//*[@id=\"Resolution_ifr\"]")
		WebElement frameResulation;
		
		@FindBy(xpath="//*[@id=\"PlannedDuration\"]")
		WebElement drpPlanDuration;
		
		@FindBy(xpath="//*[@id=\"controlA\"]/div[2]/div[3]/ul/li[1]/a")
		WebElement btnReview;
		
		@FindBy(xpath="//*[@id=\"controlA\"]/div[2]/div[3]/ul/li[2]/a")
		WebElement btnNoAction;
		
		@FindBy(xpath="//*[@id=\"controlA\"]/div[2]/div[1]/ul/li/div")
		WebElement btnSaveClose;
		
		@FindBy(linkText="Back")
		WebElement btnBack;
		
		@FindBy(xpath="//*[@id=\"field-inline-button-details-ElementId\"]")
		WebElement btnDetails;
		
		@FindBy(xpath="//*[@id=\"field-inline-button-responses-ElementId\"]")
		WebElement btnResponses;
		
		@FindBy(xpath="//*[@id=\"field-inline-button-pictures-ElementId\"]")
		WebElement btnPictures;
		
		@FindBy(xpath="//*[@id=\"content\"]/a")
		WebElement btnSubmitResponse;
		

		@FindBy(xpath="//*[@id=\"Elements_grid_row_117902\"]/div[6]/div/input")
		WebElement nameElement;
		
		
		public WebElement getElementIdName() {
		return lnkElementId;
		}
		
		public WebElement getElementName() {
			return nameElement;
		}
		
		public void clickSubmitResponses() {
			btnSubmitResponse.click();
		}
		
		public void clickDetailsButton() {
			btnDetails.click();
		}
		
		public void clickResponsesButton() {
			btnResponses.click();
		}
		
		public void clickPicturesButton() {
			btnPictures.click();
		}
		
		
		public WebElement newButton() {
			return btnNew;
		}
		public void clickEscalationIcon() {
			iconEscalations.click();		
		}
		
		public void clickNewButton() {
			btnNew.click();		
		}
		
		public void sendElementID(String element) {
			txtElementId.sendKeys(element);	
		}
		
		public void clickElementId() {
			lnkElementId.click();		
		}
		
		public void clickClient() {
			drpClient.click();
			
			System.out.println(drpClient.getText());
		}
		
		public void selectClient(int clientIndex) {
			Select select=new Select(drpClient);
			select.selectByIndex(clientIndex);
		}
		
		
		public WebElement getSummary() {
			return txtSummery;
		}
		public void sendSummery(String summery) {
			txtSummery.sendKeys(summery);	
		}
		
		public void sendDueDate(String dueDate) {
			txtDueDate.sendKeys(dueDate);	
		}
		
		public void clearDueDate() {
			txtDueDate.clear();
		}
		
		public void sendContactName(String contactName) {
			txtContactName.sendKeys(contactName);	
		}
		
		public void sendStoreList(String store) {
			txtSoreList.sendKeys(store);	
		}
		
		public void sendDescIssue(String descIssue) {
			frameDescIssue.sendKeys(descIssue);	
		}
		
		public void selectResult(String clientText) {
			Select select=new Select(drpResult);
			select.selectByVisibleText(clientText);
		}
		
		public void sendResulation(String resulation) {
			frameResulation.sendKeys(resulation);	
		}
		
		public void selectPlanDuration(String duration) {
			Select select=new Select(drpPlanDuration);
			select.selectByValue(duration);
		}
		
		public void clickReviewButton() {
			btnReview.click();		
		}
		
		public void clickNoActionButton() {
			btnNoAction.click();		
		}
		
		public void clickSaveCloseButton() {
			btnSaveClose.click();		
		}
		
		public void clickBackButton() {
			btnBack.click();
		}
		public void acceptAlert(){
			alert = ldriver.switchTo().alert();
			alert.accept();
		}
		
		
		public void SENDDueDateField(String dueDate) {
			txtDueDate.sendKeys(dueDate);
		}
		
		public void clickDueDateField() {
			txtDueDate.click();
		}
		
		public void pressEscape() {
			txtDueDate.sendKeys(Keys.ESCAPE);
			}
		
		public String setFutureDate() {	
		     Calendar cal = Calendar.getInstance();
		     cal.setTimeZone(TimeZone.getTimeZone("GMT"));
		     cal.add(Calendar.DATE, 5);
		        System.out.println("date after 5 days : " + getDate(cal));	    
		        return getDate(cal);
		}
		
		
		public String setPastDate() {
			 Calendar cal = Calendar.getInstance();
		     cal.setTimeZone(TimeZone.getTimeZone("GMT"));
		     cal.add(Calendar.DATE, -5);
		        System.out.println("date BEFORE 5 days : " + getDate(cal));	    
		        return getDate(cal);
		 }
		
		
		public static String getDate(Calendar cal){
	        return "" + cal.get(Calendar.YEAR) +"-" + (cal.get(Calendar.MONTH)+1) + "-" + cal.get(Calendar.DATE);
	    }
	

}
