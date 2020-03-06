package com.elements.pageObject;



import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.dashManagement.utilities.TestLogger;

public class ElementsPage {
	
		WebDriver ldriver;
		
		public ElementsPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		}
		
		

		@FindBy(xpath="//*[@id=\"content\"]/div[1]/div[3]/div[1]/img")
		WebElement iconProjects;
		
		@FindBy(id="menu-module-activity")
		WebElement drActivities;
		
		@FindBy(xpath="//*[@id=\"menu-programs\"]/a")
		WebElement drpProgram ;
		
		@FindBy(xpath="//*[@id=\"menu-elements\"]/a")
		WebElement drpElements ;

		@FindBy(xpath="//*[@id=\"programs_c1\"]/div[3]")
		WebElement listFirstId ;

		@FindBy(linkText="Execution")
		WebElement tabExecution;
		
		@FindBy(xpath="(//div[@class[contains(.,'aawgui_column aawgui_column_elementcount aawgui_weeklylabor_column_elementcount readonly')]])[1]")
		WebElement rowWeeklyLabor;
		
		@FindBy(xpath="(//div[@class='aawgui_checkbox'])[1]")
		WebElement rowWeeklyLaborAero;
		
		@FindBy(linkText="New Element")
		WebElement btnNewElement;
		
		@FindBy(linkText="Templated Element")
		WebElement linkTemplatedElement;
		
		@FindBy(id="DepartmentId")
		WebElement drpDepartment;
	
		@FindBy(id="DefaultRetakeTypeId")
		WebElement drpRetaketype;
		
		@FindBy(id="TaskTypeId")
		WebElement drpTasktype;
		
		@FindBy(id="Duration")
		WebElement txtDuration;
		
		@FindBy(id="ParticipantList")
		WebElement txtParticipantList;
		
		@FindBy(id="Commitments-3587")
		WebElement chkSecondCommitment;
		
		@FindBy(id="Clients-299")
		WebElement chk3rdClient;
		
		@FindBy(id="Aspects-3")
		WebElement chkFlexActivityAspect;
		
		@FindBy(id="ShopcomOrders-24861")
		WebElement chkShopcomOrder;

		@FindBy(id="ActivitySkills-6")
		WebElement chkSkills;
		
		@FindBy(id="Start")
		WebElement dateStart;
		
		@FindBy(id="End")
		WebElement dateEnd;
		
		@FindBy(id="UploadFile")
		WebElement btnUploadFile;
		
		@FindBy(linkText="Upload")
		WebElement btnUpload;
		
		@FindBy(linkText="Back")
		WebElement btnBack;
		
		@FindBy(xpath="//div[@colname[contains(.,'items')] and text()='Participants / Items']")
		WebElement btnParticipantItem;
		
		@FindBy(xpath="//*[contains(text(),\"Save and Close\")]")
		WebElement btnSaveAndClose;
		
		@FindBy(xpath="//*[contains(text(),\"Submit for Review\")]")
		WebElement btnSubmitReview;	
		
		@FindBy(linkText="Upload Participants / Items")
		WebElement btnUploadParticipant;

		@FindBy(xpath="(//div[text()='Add Template'])[1]")
		WebElement btnStoreAddTemplate;
		
		@FindBy(xpath="(//div[text()='Add Template'])[2]")
		WebElement btnItemAddTemplate;
		
		@FindBy(xpath="(//div[text()='Add Template'])[3]")
		WebElement btnConcludingAddTemplate;
		
		@FindBy(linkText="Link Existing")
		WebElement btnLinkExisting;
		
		@FindBy(xpath="//*[@id=\"globalTemplatesForElementImport_c5_filter\"]")
		WebElement drStatus;	

		@FindBy(linkText="Next")
		WebElement btnNext;
		
		@FindBy(xpath="//*[@id=\"globalTemplatesForElementImport_select\"]/div[4]/span[1]/input[1]")
		WebElement chkFirstTemplate;
			
		@FindBy(xpath="//*[@id=\"globalTemplatesForElementImport_select\"]/div[5]/span[1]/input[1]")
		WebElement chkSecondTemplate;
		
		@FindBy(xpath="//*[@id=\"SimpleAttachment0\"]")
		WebElement btnElementAttachment;	
		
		@FindBy(xpath="(//div[@class=\"formElement\"])[2]")
		WebElement txtStatus;
		
		@FindBy(linkText="» logout")
		WebElement btnLogout;
		
		@FindBy(xpath="//*[@id=\"activityceap_c2_filter\"]")
		WebElement filterId;
		
		@FindBy(linkText="Apply")
		WebElement btnApply;
		
		@FindBy(xpath="//*[@id=\"activityceap_c2\"]/div[3]")
		WebElement filteredElement;
		
		@FindBy(xpath="//*[@id=\"controlA\"]/div[2]/div[3]/ul/li[8]/a")
		WebElement btnReleaseElement;
		
		@FindBy(xpath="(//div[@colname[contains(.,'TEMPLATENUMBER')]])[2]")
		WebElement storeTempNum;
		
		@FindBy(xpath="(//div[@colname[contains(.,'TEMPLATENUMBER')]])[4]")
		WebElement itemTempNum;
		
		@FindBy(xpath="(//div[@colname[contains(.,'TEMPLATENUMBER')]])[6]")
		WebElement concludingTempNum;
		
		
		
		public WebElement getStoretempnum() {
			return storeTempNum;
			
		}
		
		public WebElement getItemtempnum() {
			return itemTempNum;
			
		}

		public WebElement getConcludingtempnum() {
			return concludingTempNum;
	
		}
	
		
		public void clickProjectsIcon() {
			iconProjects.click();		
		}
		
		public void moveToActivities() {
			Actions actions = new Actions(ldriver);
			actions.moveToElement(drActivities).build().perform();
		}
		
		public void clickProgram() {
			drpProgram.click();
		}
		
		public void clickElements() {
			drpElements.click();
		}
		
		public void clickFirstId() {
			listFirstId.click();
		}
		
		public void clickExecutionTab() {
			tabExecution.click();
		}
		
		public void clickWeeklyLaborRow() {
			rowWeeklyLabor.click();
		}
		
		public void clickNewElementButton() {
			btnNewElement.click();
		}
		
		public void clickTemplatedElement() {
			linkTemplatedElement.click();
		}
		
		public void openRowwWeeklyLabor() {
			 rowWeeklyLaborAero.click();
		}
		
		public void sendDuration(String duration) {
			txtDuration.sendKeys(duration);
		}
		
		public void sendParticipantList(String participant) {
			txtParticipantList.sendKeys(participant);
		}
			
		public void clickSecondCommitment() {
			chkSecondCommitment.click();
		}
		
		public void click3rdClient() {
			chk3rdClient.click();
		}
		
		public void clickFlexActivityAspect() {
			chkFlexActivityAspect.click();
		}
		
		public void clickShopcomOrder() {
			chkShopcomOrder.click();
		}
		
		public void clickSkills() {
			chkSkills.click();
		}
		
		public WebElement startDate() {
			return dateStart;
		}
		
		public WebElement endDate() {
			return dateEnd;
		}
		
		public void clickSaveClose() {
			btnSaveAndClose.click();
		}
		
		public void clickSubmitReview() {
			btnSubmitReview.click();
		}
		
		public void clickStoreAddTempButton() {
			btnStoreAddTemplate.click();
		}
		
		public void clickItemAddTempButton() {
			btnItemAddTemplate.click();
		}
		
		public void clickConcludingAddTempButton() {
			btnConcludingAddTemplate.click();
		}
			
		public void clickLinkExistingButton() {
			btnLinkExisting.click();
		}
			
		public void clickNextButton() {
			btnNext.click();
		}
		
		public void clickUploadButton() {
			btnUpload.click();
		}
		
		public void clickBackButton() {
			btnBack.click();
		}
		
		public void clickLogoutButton() {
			btnLogout.click();
		}
		

		public void clickChooseFile() {
			btnUploadFile.click();
		}
		
		public void selectFirstTemp() {
			chkFirstTemplate.click();
		}
		
		public void selectSecondTemp() {
			chkSecondTemplate.click();
		}
		
		public void clickParticipantItem() {
			btnParticipantItem.click();
		}
		
		public void clickUploadPartipant() {
			btnUploadParticipant.click();
		}
		
		public void clickElementAttachment() {
			btnElementAttachment.click();
		}
		
		public void sendID(String eleId) {
			filterId.sendKeys(eleId);
		}
		
		public void clickApply() {
			btnApply.click();
		}
		
		public void clickReleaseButton() {
			btnReleaseElement.click();
		}
		
		
		public void selectDeptByText(String dept) {
			Select select=new Select(drpDepartment);
			select.selectByVisibleText(dept);
		}
		
		public void selectRetakeTypeByText(String retakeType) {
			Select select=new Select(drpRetaketype);
			select.selectByVisibleText(retakeType);
		}
		
		public void selectTaskTypeByText(String taskType) {
			Select select=new Select(drpTasktype);
			select.selectByVisibleText(taskType);
		}
		
		public void selectStatusByText(String status) {
			Select select=new Select(drStatus);
			select.selectByVisibleText(status);
		}
		
		public WebElement getStatus() {
			return txtStatus;
		}
		
		
		public void clickFiteredElement() {
			filteredElement.click();
		}
		
		

		
		
		
		
		
		
		
		
		
		
		
		
	
		
		public void pressEscape() {
			dateStart.sendKeys(Keys.ESCAPE);
			}
		
		public void calmethod() {
			LocalDateTime ldt = LocalDateTime.now().plusDays(1);
			DateTimeFormatter formmat1 = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
			System.out.println(ldt);
			// Output "2018-05-12T17:21:53.658"
			
			String formatter = formmat1.format(ldt);
			System.out.println(formatter);
			// 2018-05-12
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
			
			//robot.setAutoDelay(2000);
			
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			
			//robot.keyPress(KeyEvent.VK_ENTER);
			//robot.keyRelease(KeyEvent.VK_ENTER);
}
		
		

		public static String getDate(Calendar cal){
			
			 return "" + cal.get(Calendar.YEAR) +"-" + (cal.get(Calendar.MONTH)+1) + "-" + cal.get(Calendar.DATE);
		   }
		
		public String setFutureDate5() {	
		     Calendar cal = Calendar.getInstance();
		     cal.setTimeZone(TimeZone.getTimeZone("GMT"));
		     cal.add(Calendar.DATE, 5);
		    
		        System.out.println("date after 5 days : " + getDate(cal));	    
		        return getDate(cal);
		   
		 
		}
		
		public String setFutureDate10() {	
		     Calendar cal = Calendar.getInstance();
		     cal.setTimeZone(TimeZone.getTimeZone("GMT"));
		     cal.add(Calendar.DATE, 10);
		        System.out.println("date after 10 days : " + getDate(cal));	    
		        return getDate(cal);
		}
		
		
		public String newfuturedate5(){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar cal = Calendar.getInstance();	
			//System.out.println("Current Date: "+sdf.format(cal.getTime()));
		        cal.add(Calendar.DAY_OF_MONTH, 5);  
			String newDate = sdf.format(cal.getTime());  
			System.out.println("Date after Addition: "+newDate);
			return newDate;
		   }
		
		public String newfuturedate10(){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar cal = Calendar.getInstance();	
			//System.out.println("Current Date: "+sdf.format(cal.getTime()));
		        cal.add(Calendar.DAY_OF_MONTH, 10);  
			String newDate = sdf.format(cal.getTime());  
			System.out.println("Date after Addition: "+newDate);
			return newDate;
		   }

}
