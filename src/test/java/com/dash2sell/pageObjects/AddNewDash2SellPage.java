package com.dash2sell.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;



public class AddNewDash2SellPage {
WebDriver ldriver;
	
	public AddNewDash2SellPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	@FindBy(xpath="//img[@ src='/public/images/homepage/icons/dash2sell.png']")
	WebElement lnkDash2Sell;

	@FindBy(linkText="New Dash2Sell")
	WebElement lnkNewDash2Sell;

	@FindBy(name="PriorityId")
	WebElement drPriority;

	@FindBy(name="Description")
	WebElement txtDescrip;

	@FindBy(name="Chain")
	WebElement drChain;
	
	@FindBy(name="StartDateTime")
	WebElement dashStartDate;
	
	@FindBy(name="EndDateTime")
	WebElement dashEnddate;

	@FindBy(name="DepartmentId")
	WebElement drDept;

	@FindBy(name="ClientId")//client
	WebElement drClient;
	
	@FindBy(name="InstoreStartDateTime")
	WebElement storeStartDate;
	
	@FindBy(name="InstoreEndDateTime")
	WebElement storeEndDate;

	@FindBy(name="MaxResponses")
	WebElement txtMax;

	@FindBy(name="ParticipantList")
	WebElement txtPartiList;

	@FindBy(name="CategoryOneId")
	WebElement drCategory1;

	@FindBy(name="CategoryTwoId")
	WebElement drCategory2;
	
	@FindBy(name="IsLagRequired")
	WebElement drScog;

	@FindBy(name="IsPhotoRequired")
	WebElement drPhoto;
	
	@FindBy(id="SimpleAttachment0")
	WebElement attach;
	
	@FindBy(linkText="Submit for Approval")
	WebElement btnSubmit;
	
	@FindBy(id="dash2selltablesdash2sellListing")
	WebElement tableList;
	
	
	
	public void clickDash2Sell() {
		lnkDash2Sell.click();		
	}

	
	public void clickNewDash2Sell() {
		lnkNewDash2Sell.click();	
	}

	public void selectPriority(String prior) {
		Select select=new Select(drPriority);
		select.selectByVisibleText(prior);
	}

	public void description(String des) {
		txtDescrip.sendKeys(des);
		
	}

	public void selectChain(String chain) {
		Select select=new Select(drChain);
		select.selectByVisibleText(chain);
	}

	
	public void clickDashStartDate(String dstdate) {

		dashStartDate.clear();
		dashStartDate.sendKeys(dstdate);
	}
	
	public void clickDashSEndDate(String dedate) {
		dashEnddate.clear();
		dashEnddate.sendKeys(dedate);
	}
	
	
	public void selectDept(String dept) {
		Select select=new Select(drDept);
		select.selectByValue(dept);
	}
	

	public void selectClient(String client) {
		Select select=new Select(drClient);
		select.selectByVisibleText(client);
	}
	
	public void clickStoreStartDate(String ssdate) {
		storeStartDate.clear();
		storeStartDate.sendKeys(ssdate);
	}
	
	public void clickStoreEndDate(String sedate) {
		storeEndDate.clear();
		storeEndDate.sendKeys(sedate);
	}

	public void maxstore(String MaxResponses) {
		txtMax.sendKeys(MaxResponses);
	}

	public void participantList (String list) {
		txtPartiList.sendKeys(list);
	}

	public void selectCategory1(String category1) {
		Select select=new Select(drCategory1);
		select.selectByVisibleText(category1);
	}
	
	public void selectCategory2(String category2) {
		Select select=new Select(drCategory2);
		select.selectByVisibleText(category2);
	}
	
	
	public void selectScog(String scog) {
		Select select=new Select(drScog);
		select.selectByVisibleText(scog);
	}
	public void selectPhoto(String photo) {
		Select select=new Select(drPhoto);
		select.selectByVisibleText(photo);
	}
	
	public void clickAttachment(String file) {
		attach.sendKeys(file);
		
	} 
	
	public void clickSubmit() {
		btnSubmit.click();
	}
	
	public boolean enableDept() {
		drDept.isEnabled();
		return true;
	}
	



}
