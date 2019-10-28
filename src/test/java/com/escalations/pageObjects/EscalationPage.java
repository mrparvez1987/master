package com.escalations.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

	public class EscalationPage {
		WebDriver ldriver;
	
	public EscalationPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
		@FindBy(xpath="//*[@id=\"content\"]/div[2]/div[2]/div[1]/img")
		WebElement iconEscalations;
	
		@FindBy(xpath="//*[@id=\"controlA\"]/div[2]/div/ul/li/a")
		WebElement btnNew;
	
		@FindBy(xpath="//*[@id=\"fm\"]/dl/div[1]")
		WebElement textstatus;
	
		@FindBy(id="ElementId")
		WebElement txtElementId;
		
		@FindBy(xpath="//*[starts-with(@id,\\\"ui-id\\\")]/a")
		WebElement lnkElementId;
		
		@FindBy(xpath="//*[@id=\"ClientId\"]")
		WebElement drpClient;
		
		@FindBy(id="Summary")
		WebElement txtSummery;
		
		@FindBy(id="DueDate")
		WebElement txtDueDate;
		
		@FindBy(id="ContactName")
		WebElement txtContactName;
		
		@FindBy(id="StoreList")
		WebElement txtSoreList;
		
		@FindBy(xpath="//*[@id=\"mceu_29\"]")
		WebElement frameDescIssue;
		
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
		
		public void selectClient(int clientIndex) {
			Select select=new Select(drpClient);
			select.selectByIndex(clientIndex);
		}
		
		public void sendSummery(String summery) {
			txtSummery.sendKeys(summery);	
		}
		
		public void sendDueDate(String dueDate) {
			txtDueDate.sendKeys(dueDate);	
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
	
	
	

}
