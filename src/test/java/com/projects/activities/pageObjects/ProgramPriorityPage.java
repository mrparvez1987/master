package com.projects.activities.pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProgramPriorityPage {
	WebDriver ldriver;
	
		public ProgramPriorityPage(WebDriver rdriver) {
			ldriver=rdriver;
			PageFactory.initElements(rdriver, this);
		
		}
	
	
		@FindBy(xpath="//*[@id=\"content\"]/div[1]/div[3]/div[1]/img")
		WebElement iconProjects;
		
		@FindBy(id="menu-module-activity")
		WebElement drActivities;
		
		@FindBy(id="menu-programpriority")
		WebElement menuProgPriority;
		
		@FindBy(linkText="New Program Priority")
		WebElement lnkProgPriority;
		
		@FindBy(id="Program_Id")
		WebElement txtProgId;
		
		@FindBy(xpath="//*[starts-with(@id,\"ui-id\")]/a")
		WebElement txtProgDesc;
		
		@FindBy(id="Rank")
		WebElement txtProgRank;
		
		@FindBy(id="Effectivedate")
		WebElement txtProgEffectiveDate;
		
		@FindBy(id="Expirationdate")
		WebElement txtProgExpireDate;
		
		@FindBy(id="Generatefollowups")
		WebElement drProgFollowups;
		
		@FindBy(xpath="//*[@id=\"controlA\"]/div[2]/div[1]/ul/li/div")
		WebElement btnProgSave;
		
		@FindBy(linkText="Delete")
		WebElement btnProgDel;
		
		@FindBy(xpath="//*[@id=\\\"Program_Description\\")
		WebElement textProgDesc;
		
		public void textprogdesc() {
			String text=textProgDesc.getText();
			System.out.println(text);
		}
	
		public void clickProjectsIcon() {
			iconProjects.click();		
		}
	
		public void moveToActivities() {
			Actions actions = new Actions(ldriver);
			actions.moveToElement(drActivities).build().perform();
		}
		
		public void clickProgPriority() {
			menuProgPriority.click();	
		}
		
		public void clickNewProgPriority() {
			lnkProgPriority.click();	
		}
		
		public void sendProgramId(String progId) {
			txtProgId.sendKeys(progId);
		}
		
		public void clickProgramDesc() {
			txtProgDesc.click();
		}
		
		public void sendProgRank(String progRank) {
			txtProgRank.sendKeys(progRank);
		}
		
		public void sendProgEffectiveDate(String progEffectiveDate) {
			txtProgEffectiveDate.sendKeys(progEffectiveDate);
		}
		
		public void sendProgExpireDate(String ProgExpireDate) {
			txtProgExpireDate.sendKeys(ProgExpireDate);
			txtProgExpireDate.sendKeys(Keys.ESCAPE);
		}
		
		public void selectdrProgFollowups(String ProgFollowups) {
			Select select=new Select(drProgFollowups);
			select.selectByValue(ProgFollowups);
		}
		
		public void clickProgSave() {
			btnProgSave.click();	
		}
		
		public void clickProgDelete() {
			btnProgDel.click();	
		}
		
		
	}
