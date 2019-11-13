package com.projects.activities.pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;



public class ProgramListPage {
		WebDriver ldriver;
	
		public ProgramListPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
		@FindBy(linkText="Clear")
		WebElement clear;
	
		@FindBy(linkText="Apply")
		WebElement apply;
		
		@FindBy(linkText="Customize")
		WebElement customize;
	
		@FindBy(xpath="//*[@id=\"activitytablesprogrampriorityListing\"]/div[1]/div[2]/a")
		WebElement linkExportTable;
		
		@FindBy(id="activitytablesprogrampriorityListing_c1_filter")
		WebElement textProgramId;

		@FindBy(xpath="//*[@id=\"controlA\"]/div[2]/div[1]/ul/li/div")
		WebElement buttonExportTable;

		@FindBy(name="activitytablesprogrampriorityListing_renderplugin_exportoption")
		WebElement dropFileType;
		
		@FindBy(xpath="//*[@id=\"msg\"]/div/div[1]/a")
		WebElement linkDownloadTable;


		@FindBy(id="activitytablesprogrampriorityListing_c1")
		List<WebElement> programIdColoumn;

		@FindBy(id="activitytablesprogrampriorityListing_c2_filter")
		WebElement textProgramDesc;
		
		@FindBy(id="activitytablesprogrampriorityListing_c5_filter")
		WebElement textProgramCreator;
		
		@FindBy(xpath="//*[@id=\"activitytablesprogrampriorityListing_c5\"]/div")
		List<WebElement> programCreatorColoumn;

		@FindBy(xpath="//*[@id=\"activitytablesprogrampriorityListing_c2\"]/div")
		List<WebElement> programDescColoumn;
		
		@FindBy(id="activitytablesprogrampriorityListing_c3_filter")
		WebElement textProgramRank;

		@FindBy(id="activitytablesprogrampriorityListing_c3")
		List<WebElement> programRankColoumn;
		
		@FindBy(xpath="//*[@id=\"body\"]/div[12]/div[4]/a[2]")
		WebElement calapply;
		
		
		// Program Creation Date Elements
		@FindBy(xpath="//*[@id=\"activitytablesprogrampriorityListing_c4\"]/div[2]/a/img")
		WebElement calProgramCreationBtn;
				
		@FindBy(xpath="//*[@id=\"body\"]/div[12]/div[2]/table/thead/tr[1]/td")
		WebElement calCreationStartMonthYear;
				
		@FindBy(xpath="//*[@id=\"body\"]/div[12]/div[2]/table/thead/tr[2]/td[4]")
		WebElement calCreationStartRightAero;
				
		@FindBy(xpath="//*[@id=\"body\"]/div[12]/div[2]/table/tbody/tr/td[contains(text(),'1')]")
		WebElement calCreationStartDate;
		
				
		@FindBy(xpath="//*[@id=\"body\"]/div[12]/div[3]/table/thead/tr[1]/td")
		WebElement calCreationEndMonthYear;
				
		@FindBy(xpath="//*[@id=\"body\"]/div[12]/div[3]/table/thead/tr[2]/td[4]")
		WebElement calCreationEndRightAero;
				
		@FindBy(xpath="//*[@id=\"body\"]/div[12]/div[3]/table/tbody/tr/td[contains(text(),'20')]")
		WebElement calCreationEndDate;
				
		@FindBy(xpath="//*[@id=\"activitytablesprogrampriorityListing_c4\"]")
		List<WebElement> creationDateColoumn;
				
		@FindBy(id = "activitytablesprogrampriorityListing_c4_filter_from")
		WebElement calCreationStartDateById;
				
		@FindBy(id = "activitytablesprogrampriorityListing_c4_filter_to")
		WebElement calCreationEndDateById;
				
		@FindBy(xpath="//*[@id=\"activitytablesprogrampriorityListing_c1\"]/div[3]")
		WebElement DeletableItem;
		
		//Program Effective Date Elements
		@FindBy(xpath="//*[@id=\"activitytablesprogrampriorityListing_c6\"]/div[2]/a/img")
		WebElement calProgramEffectiveBtn;
			
		@FindBy(xpath="//*[@id=\"body\"]/div[12]/div[2]/table/thead/tr[1]/td")
		WebElement calEffectiveStartMonthYear;
		
		@FindBy(xpath="//*[@id=\"body\"]/div[12]/div[2]/table/thead/tr[2]/td[4]")
		WebElement calEffectiveStartRightAero;
		
		@FindBy(xpath="//div[2]//table[1]//tbody[1]//tr//td[contains(text(),'10')]")
		WebElement calEffectiveStartDate;
		
		@FindBy(xpath="//*[@id=\"body\"]/div[12]/div[3]/table/thead/tr[1]/td")
		WebElement calEffectiveEndMonthYear;
		
		@FindBy(xpath="//*[@id=\"body\"]/div[12]/div[3]/table/thead/tr[2]/td[4]")
		WebElement calEffectiveEndRightAero;
		
		@FindBy(xpath="//div[3]//table[1]//tbody[1]//tr//td[contains(text(),'30')]")
		WebElement calEffectiveEndDate;
		
		@FindBy(xpath="//*[@id=\"activitytablesprogrampriorityListing_c6\"]")
		List<WebElement> effetiveDateColoumn;
		
		@FindBy(xpath="//*[@id=\"body\"]/div[12]/div[2]/table/thead/tr[2]/td[2]")
		WebElement calStartLeftAero;
		
		@FindBy(xpath="//*[@id=\"body\"]/div[12]/div[3]/table/thead/tr[2]/td[2]")
		WebElement calEndLeftAero;
		
		
		
		
		//Program Expire Date Elements
		@FindBy(xpath="//*[@id=\"activitytablesprogrampriorityListing_c7\"]/div[2]/a/img")
		WebElement calProgramExpireBtn;
		
		@FindBy(xpath="//*[@id=\"body\"]/div[12]/div[2]/table/thead/tr[1]/td")
		WebElement calExpireStartMonthYear;
		
		@FindBy(xpath="//*[@id=\"body\"]/div[12]/div[2]/table/thead/tr[2]/td[4]")
		WebElement calExpireStartRightAero;
		
		@FindBy(xpath="//*[@id=\"body\"]/div[12]/div[2]/table/tbody/tr/td[contains(text(),'10')]")
		WebElement calExpireStartDate;
		
		@FindBy(xpath="//*[@id=\"body\"]/div[12]/div[3]/table/thead/tr[1]/td")
		WebElement calExpireEndMonthYear;
		
		@FindBy(xpath="//*[@id=\"body\"]/div[12]/div[3]/table/thead/tr[2]/td[4]")
		WebElement calExpireEndRightAero;
		
		@FindBy(xpath="//*[@id=\"body\"]/div[12]/div[3]/table/tbody/tr/td[contains(text(),'20')]")
		WebElement calExpireEndDate;
		
		@FindBy(xpath="//*[@id=\"activitytablesprogrampriorityListing_c7\"]")
		List<WebElement> expireDateColoumn;
			
		
		//Generate followups Elements
		@FindBy(id="activitytablesprogrampriorityListing_c8_filter")
		WebElement dropGenerateFollowups;
		
		@FindBy(id="activitytablesprogrampriorityListing_c8")
		List<WebElement> programFollowupsColoumn;
		
		
		@FindBy(id="activitytablesprogrampriorityListing")
		List<WebElement> tableProgram;
		
		
		
		
		public void clickClear() {
		   clear.click();
		}
	
		public void clickApply() {
			apply.click();
		}
		
		public void sendProgramID(String id) {
			textProgramId.sendKeys(id);	
		}
		
		public void sendProgramRank(String rank) {
			textProgramRank.sendKeys(rank);
			
		}
		public void clickEnter() {
			textProgramId.sendKeys(Keys.ENTER);
		}
		
		public void selectFollowups(String follow) {
			Select select=new Select(dropGenerateFollowups);
			select.selectByVisibleText(follow);
		}
		
		public void clickEffectiveButton() {
			calProgramEffectiveBtn.click();
		}
		
		public void clickcreationButton() {
			calProgramCreationBtn.click();
		}
		
		public void clickApplyButton() {
			calapply.click();
		}
		
		public void deleteProgramIDRecord(){
			DeletableItem.click();
		}
		
		public void clickProgramExpireButton() {
			calProgramExpireBtn.click();
		}
		
		public void sendCreatorName(String creator) {
			textProgramCreator.sendKeys(creator);
		}
		
		public void clickExportTableLink() {
			linkExportTable.click();
		}
		
		public void selectFileType(String text) {
			Select select=new Select(dropFileType);
			select.selectByVisibleText(text);
		}
		
		public void clickExportTableButton() {
			buttonExportTable.click();
		}
		
		public void clickDownloadTableLink() {
			linkDownloadTable.click();
		}
		
		
		public List<Integer> getIdList() {

			List<Integer> idList = new ArrayList<Integer>();
			for(WebElement ele: programIdColoumn)  {
				List<WebElement> rows = ele.findElements(By.className("row"));
				for(WebElement row: rows) {
					try {
						System.out.println("---> "+row.getText());
						idList.add(Integer.parseInt(row.getText()));
					}catch(NumberFormatException e) {
						System.out.println(NumberFormatException.class.getSimpleName() + " : "+e.getMessage());
					}catch(Exception e) {
						System.out.println(e.getMessage());
					}
				}
				
			}
			
			System.out.println("Total result: "+ idList.size());
			return idList;
		}
		
		
		
		public List<Integer> getRankList() {

			List<Integer> rankList = new ArrayList<Integer>();
			for(WebElement ele: programRankColoumn)  {
				List<WebElement> rows = ele.findElements(By.className("row"));
				for(WebElement row: rows) {
					try {
						System.out.println("---> "+row.getText());
						rankList.add(Integer.parseInt(row.getText()));
					}catch(NumberFormatException e) {
						System.out.println(NumberFormatException.class.getSimpleName() + " : "+e.getMessage());
					}catch(Exception e) {
						System.out.println(e.getMessage());
					}
				}
				
			}
			
			System.out.println("Total result: "+ rankList.size());
			return rankList;	
	}
		
		
		public void selectCreationDate(String start,String end) {
			String creationStartmonth=start;
			String creationEndmonth=end;
			
			
			while(true) {
				String text=calCreationStartMonthYear.getText();
				
				if(text.equalsIgnoreCase(creationStartmonth)) {
					break;
				}else {
					calStartLeftAero.click();
				}
			}
			
			System.out.println(calCreationStartDate.getText());
			calCreationStartDate.click();
			
			while(true) {
				String text=calCreationEndMonthYear.getText();
				
				if(text.equals(creationEndmonth)) {
					break;
				}else {
					calEndLeftAero.click();
				}
				
			}
			
			System.out.println(calCreationEndDate.getText());
			calCreationEndDate.click();	
		}
		
		
		public void selectEffectiveDate(String start,String end) {
			String effectiveStartmonth=start;
			String effectiveEndmonth=end;
			
			while(true) {
				String text=calEffectiveStartMonthYear.getText();
				
				if(text.equalsIgnoreCase(effectiveStartmonth)) {
					break;
				}else {
					calStartLeftAero.click();
				}
				
			}
			
			System.out.println(calEffectiveStartDate.getText());
			calEffectiveStartDate.click();
			
			while(true) {
				String text=calEffectiveEndMonthYear.getText();
				
				if(text.equals(effectiveEndmonth)) {
					break;
				}else {
					calEndLeftAero.click();
				}
				
			}
			
			System.out.println(calEffectiveEndDate.getText());
			calEffectiveEndDate.click();
		}
		
		
		
		
		public void selectExpireDate(String start,String end) {
			String expireStartmonth=start;
			String expireEndmonth=end;
			
			while(true) {
				String text=calExpireStartMonthYear.getText();
				
				if(text.equalsIgnoreCase(expireStartmonth)) {
					break;
				}else {
					calStartLeftAero.click();
				}
				
			}
			
			System.out.println(calExpireStartDate.getText());
			calExpireStartDate.click();
			
			while(true) {
				String text=calExpireEndMonthYear.getText();
				
				if(text.equals(expireEndmonth)) {
					break;
				}else {
					calEndLeftAero.click();
				}
				
			}
			
			System.out.println(calExpireEndDate.getText());
			calExpireEndDate.click();
		}
	
				
		public List<String> getFollowList() {

			List<String> followList = new ArrayList<String>();
			for(WebElement ele: programFollowupsColoumn)  {
				List<WebElement> rows = ele.findElements(By.className("row"));
				for(WebElement row: rows) {
					
						System.out.println("---> "+row.getText());
							
					}
			}
			
			System.out.println("Total result: "+ followList.size());
			return followList;	
			}
			
		
		
	}
