package com.projects.activities.pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProjectPriorityPage {
	
WebDriver ldriver;
	
	public  ProjectPriorityPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	
	}
	
	
	//projects Icon
	@FindBy(xpath="//*[@id=\"content\"]/div[1]/div[3]/div[1]/img")
	WebElement iconProjects;
	
	//Activities drop down
	@FindBy(id="menu-module-activity")
	WebElement drActivities;
	
	@FindBy(id="menu-projectpriority")
	WebElement menuProjPriority;
	
	@FindBy(linkText="New Project Priority")
	WebElement lnkProjPriority;
	
	@FindBy(id="Project_Id")
	WebElement txtProjId;
	
	@FindBy(xpath="//*[starts-with(@id,\"ui-id\")]/a")
	WebElement txtProjDesc;
	
	@FindBy(id="Rank")
	WebElement txtProjRank;
	
	@FindBy(id="Effectivedate")
	WebElement txtProjEffectiveDate;
	
	@FindBy(id="Expirationdate")
	WebElement txtProjExpireDate;
	
	@FindBy(id="Generatefollowups")
	WebElement drProjFollowups;
	
	@FindBy(xpath="//*[@id=\"controlA\"]/div[2]/div[1]/ul/li/div")
	WebElement btnProjSave;
	
	@FindBy(linkText="Delete")
	WebElement btnProjDel;
	
	
	
	
	public void clickProjectsIcon() {
		iconProjects.click();		
	}

	public void moveToActivities() {
		Actions actions = new Actions(ldriver);
		actions.moveToElement(drActivities).build().perform();
	}
	
	public void clickProjPriority() {
		menuProjPriority.click();	
	}
	
	public void clickNewProjPriority() {
		lnkProjPriority.click();	
	}
	
	public void sendProjectId(String projId) {
		txtProjId.sendKeys(projId);
	}
	
	public void clickProjectDesc() {
		txtProjDesc.click();
	}
	
	public void sendProjRank(String projRank) {
		txtProjRank.sendKeys(projRank);
	}
	
	public void sendProjEffectiveDate(String projEffectiveDate) {
		txtProjEffectiveDate.sendKeys(projEffectiveDate);
	}
	
	public void sendProjExpireDate(String ProjExpireDate) {
		txtProjExpireDate.sendKeys(ProjExpireDate);
		txtProjExpireDate.sendKeys(Keys.ESCAPE);
	}
	
	public void selectProjFollowups(String ProjFollowups) {
		Select select=new Select(drProjFollowups);
		select.selectByValue(ProjFollowups);
	}
	
	public void clickProjSave() {
		btnProjSave.click();	
	}
	
	public void clickProjDelete() {
		btnProjDel.click();	
	}
			

}
