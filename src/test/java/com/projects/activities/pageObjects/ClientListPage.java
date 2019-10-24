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

public class ClientListPage {
	
	WebDriver ldriver;
	
	public ClientListPage(WebDriver rdriver) {
	ldriver=rdriver;
	PageFactory.initElements(rdriver, this);
}

	@FindBy(linkText="Clear")
	WebElement clear;

	@FindBy(linkText="Apply")
	WebElement apply;
	
	@FindBy(linkText="Customize")
	WebElement customize;

	@FindBy(linkText="Export Table")
	WebElement exportTable;
	
	@FindBy(id="activitytablesclientpriorityListing_c1_filter")
	WebElement textClientNumber;
	
	@FindBy(xpath="//*[@id=\"activitytablesclientpriorityListing\"]/div[1]/div[2]/a")
	WebElement linkExportTable;
	
	@FindBy(xpath="//*[@id=\"controlA\"]/div[2]/div[1]/ul/li/div")
	WebElement buttonExportTable;

	@FindBy(name="activitytablesclientpriorityListing_renderplugin_exportoption")
	WebElement dropFileType;
	
	@FindBy(xpath="//*[@id=\"msg\"]/div/div[1]/a")
	WebElement linkDownloadTable;
	
	@FindBy(id="activitytablesclientpriorityListing_c1")
	List<WebElement> clientNumberColoumn;

	@FindBy(id="activitytablesclientpriorityListing_c2_filter")
	WebElement textClientName;
	
	@FindBy(id="activitytablesclientpriorityListing_c5_filter")
	WebElement textClientCreator;


	@FindBy(id="activitytablesclientpriorityListing_c2")
	List<WebElement> clientNameColoumn;
	
	@FindBy(id="activitytablesclientpriorityListing_c3_filter")
	WebElement textClientRank;

	@FindBy(id="activitytablesclientpriorityListing_c3")
	List<WebElement> clientRankColoumn;
	
	@FindBy(xpath="//*[@id=\"body\"]/div[12]/div[4]/a[2]")
	WebElement calapply;
	
	//Client Effective Date Elements
	@FindBy(xpath="//*[@id=\"activitytablesclientpriorityListing_c6\"]/div[2]/a/img")
	WebElement calClientEffectiveBtn;
		
	@FindBy(xpath="//*[@id=\"body\"]/div[12]/div[2]/table/thead/tr[1]/td")
	WebElement calEffectiveStartMonthYear;
	
	@FindBy(xpath="//*[@id=\"body\"]/div[12]/div[2]/table/thead/tr[2]/td[4]")
	WebElement calEffectiveStartRightAero;
	
	@FindBy(xpath="//*[@id=\"body\"]/div[12]/div[2]/table/tbody/tr/td[contains(text(),'15')]")
	WebElement calEffectiveStartDate;
	
	@FindBy(xpath="//*[@id=\"body\"]/div[12]/div[3]/table/thead/tr[1]/td")
	WebElement calEffectiveEndMonthYear;
	
	@FindBy(xpath="//*[@id=\"body\"]/div[12]/div[3]/table/thead/tr[2]/td[4]")
	WebElement calEffectiveEndRightAero;
	
	@FindBy(xpath="//*[@id=\"body\"]/div[12]/div[3]/table/tbody/tr/td[contains(text(),'20')]")
	WebElement calEffectiveEndDate;
	
	@FindBy(xpath="//*[@id=\"activitytablesclientpriorityListing_c6\"]/div")
	List<WebElement> effetiveDateColoumn;
	
	//Client Expire Date Elements
	@FindBy(xpath="//*[@id=\"activitytablesclientpriorityListing_c7\"]/div[2]/a/img")
	WebElement calClientExpireBtn;
				
	@FindBy(xpath="//*[@id=\"body\"]/div[12]/div[2]/table/thead/tr[1]/td")
	WebElement calExpireStartMonthYear;
			
	@FindBy(xpath="//*[@id=\"body\"]/div[12]/div[2]/table/thead/tr[2]/td[4]")
	WebElement calExpireStartRightAero;
			
	@FindBy(xpath="//*[@id=\"body\"]/div[12]/div[2]/table/tbody/tr/td[contains(text(),'15')]")
	WebElement calExpireStartDate;
			
	@FindBy(xpath="//*[@id=\"body\"]/div[12]/div[3]/table/thead/tr[1]/td")
	WebElement calExpireEndMonthYear;
			
	@FindBy(xpath="//*[@id=\"body\"]/div[12]/div[3]/table/thead/tr[2]/td[4]")
	WebElement calExpireEndRightAero;
			
	@FindBy(xpath="//*[@id=\"body\"]/div[12]/div[3]/table/tbody/tr/td[contains(text(),'20')]")
	WebElement calExpireEndDate;
			
	@FindBy(xpath="//*[@id=\"activitytablesclientpriorityListing_c7\"]/div")
	List<WebElement> expireDateColoumn;
	
	@FindBy(xpath="//*[@id=\"body\"]/div[12]/div[2]/table/thead/tr[2]/td[2]")
	WebElement calStartLeftAero;
	
	@FindBy(xpath="//*[@id=\"body\"]/div[12]/div[3]/table/thead/tr[2]/td[2]")
	WebElement calEndLeftAero;
	
	// Client Creation Date Elements
	@FindBy(xpath="//*[@id=\"activitytablesclientpriorityListing_c4\"]/div[2]/a/img")
	WebElement calClientCreationBtn;
			
	@FindBy(xpath="//*[@id=\"body\"]/div[12]/div[2]/table/thead/tr[1]/td")
	WebElement calCreationStartMonthYear;
			
	@FindBy(xpath="//*[@id=\"body\"]/div[12]/div[2]/table/thead/tr[2]/td[4]")
	WebElement calCreationStartRightAero;
			
	@FindBy(xpath="//*[@id=\"body\"]/div[12]/div[2]/table/tbody/tr/td[contains(text(),'12')]")
	WebElement calCreationStartDate;
			
	@FindBy(xpath="//*[@id=\"body\"]/div[12]/div[3]/table/thead/tr[1]/td")
	WebElement calCreationEndMonthYear;
	
	@FindBy(xpath="//*[@id=\"body\"]/div[12]/div[3]/table/thead/tr[2]/td[4]")
	WebElement calCreationEndRightAero;
			
	@FindBy(xpath="//*[@id=\"body\"]/div[12]/div[3]/table/tbody/tr/td[contains(text(),'17')]")
	WebElement calCreationEndDate;
			
	@FindBy(xpath="//*[@id=\"activitytablesclientpriorityListing_c4\"]/div")
	List<WebElement> creationDateColoumn;
		
	@FindBy(xpath="//*[@id=\"activitytablesclientpriorityListing_c1\"]/div[3]")
	WebElement DeletableItem;
	

	//Generate followups Elements
	@FindBy(id="activitytablesclientpriorityListing_c8_filter")
	WebElement dropGenerateFollowups;
	
	@FindBy(xpath="//*[@id=\"activitytablesclientpriorityListing_c8\"]/div")
	List<WebElement> clientFollowupsColoumn;
			
	
	

	
	
	
	public void clickClear() {
		   clear.click();
		}
	
	public void clickApply() {
			apply.click();
		}
	
	public void sendClientNumber(String id) {
		textClientNumber.sendKeys(id);	
	}
	
	public void sendClientRank(String rank) {
		textClientRank.sendKeys(rank);
		
	}
	public void clickEnter() {
		textClientNumber.sendKeys(Keys.ENTER);
	}
	
	public void selectFollowups(String follow) {
		Select select=new Select(dropGenerateFollowups);
		select.selectByVisibleText(follow);
	}

	public void clickEffectiveButton() {
		calClientEffectiveBtn.click();
	}
	
	public void clickcreationButton() {
		calClientCreationBtn.click();
	}
	
	public void clickApplyButton() {
		calapply.click();
	}
	
	
	public void deleteClientNumberRecord(){
		DeletableItem.click();
	}
	
	public void clickClientExpireButton() {
		calClientExpireBtn.click();
	}
	
	
	public void sendCreatorName(String creator) {
		textClientCreator.sendKeys(creator);
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
		for(WebElement ele: clientNumberColoumn)  {
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
		for(WebElement ele: clientRankColoumn)  {
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
		for(WebElement ele: clientFollowupsColoumn)  {
			List<WebElement> rows = ele.findElements(By.className("row"));
			for(WebElement row: rows) {
				
					System.out.println("---> "+row.getText());
						
				}
		}
		
		System.out.println("Total result: "+ followList.size());
		return followList;	
		}

}
