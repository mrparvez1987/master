package com.projects.activities.pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ClientPriorityPage {
WebDriver ldriver;
	
	public ClientPriorityPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	
	}
	
	
	//projects Icon
	@FindBy(xpath="//*[@id=\"content\"]/div[1]/div[3]/div[1]/img")
	WebElement iconProjects;
	
	//Activities drop down
	@FindBy(id="menu-module-activity")
	WebElement drActivities;
	
	@FindBy(id="menu-clientpriority")
	WebElement menuClientPriority;
	
	
	@FindBy(linkText="New Client Priority")
	WebElement lnkClientPriority;
	
	@FindBy(id="Client_ClientNumber")
	WebElement txtClientNumber;
	
	@FindBy(xpath="//*[starts-with(@id,\"ui-id\")]/a")
	WebElement txtClientName;
	
	@FindBy(id="Rank")
	WebElement txtClientRank;
	
	@FindBy(id="Effectivedate")
	WebElement txtClientEffectiveDate;
	
	@FindBy(id="Expirationdate")
	WebElement txtClientExpireDate;
	
	@FindBy(id="Generatefollowups")
	WebElement drClientFollowups;
	
	@FindBy(xpath="//*[@id=\"controlA\"]/div[2]/div[1]/ul/li/div")
	WebElement btnClientSave;
	
	@FindBy(linkText="Delete")
	WebElement btnProgDel;
	
	
	
	public void clickProjectsIcon() {
		iconProjects.click();		
	}

	//hover over on activities 
	
	public void moveToActivities() {
		Actions actions = new Actions(ldriver);
		actions.moveToElement(drActivities).build().perform();
	}
	
	public void clickClientPriority() {
		menuClientPriority.click();	
	}
	
	public void clickNewClientPriority() {
		lnkClientPriority.click();	
	}
	
	public void sendClientNumber(String clientnumber) {
		txtClientNumber.sendKeys(clientnumber);
	}
	
	public void clickClientName() {
		txtClientName.click();
	}
	
	
	public void sendClientRank(String progRank) {
		txtClientRank.sendKeys(progRank);
	}
	
	public void sendClientEffectiveDate(String clientEffectiveDate) {
		txtClientEffectiveDate.sendKeys(clientEffectiveDate);
	}
	
	public void sendClientExpireDate(String clientExpireDate) {
		txtClientExpireDate.sendKeys(clientExpireDate);
		txtClientExpireDate.sendKeys(Keys.ESCAPE);
	}
	
	public void selectClientFollowups(String clientFollowups) {
		Select select=new Select(drClientFollowups);
		select.selectByValue(clientFollowups);
	}
	
	public void clickClientSave() {
		btnClientSave.click();	
	}
	
	public void clickClientDelete() {
		btnProgDel.click();	
	}

}
