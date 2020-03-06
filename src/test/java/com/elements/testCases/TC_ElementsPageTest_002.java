package com.elements.testCases;


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.dashManagement.database.DataTest;
import com.dashManagement.utilities.BaseClass;
import com.dashManagement.utilities.TestLogger;
import com.dashManagement.utilities.XLUtils;
import com.elements.pageObject.ElementsPage;
import com.escalations.testCases.LoginPage;



public class TC_ElementsPageTest_002 extends BaseClass {
	
	@Test(dataProvider="ElementData")
	public void validateElementCreation(String user,String pass,String dept,String retake,String task,String duration,String participant,String user2,String pass2) throws Exception {
		TC_ElementsPageTest_002 elementTestPage =new TC_ElementsPageTest_002();
		ElementsPage elementPage=new ElementsPage(driver);

		elementTestPage.getLogin(user,pass);
		
		elementPage.clickProjectsIcon();
		TestLogger.log("Project Icon Clicked");
		elementPage.moveToActivities();
		TestLogger.log("Move to Activities");
		elementPage.clickProgram();
		TestLogger.log("Program menu clicked");
		elementPage.clickFirstId();
		TestLogger.log("program list clicked");
		elementPage.clickExecutionTab();
		TestLogger.log("Execution tab clicked");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		elementPage.openRowwWeeklyLabor();
		TestLogger.log("Row weekly Labor opened");
		elementPage.clickWeeklyLaborRow();
		TestLogger.log("Weekly Labor row clicked");
		elementPage.clickNewElementButton();
		TestLogger.log("New Element Button clicked");
		elementPage.clickTemplatedElement();
		TestLogger.log("Templated Element Selected");
		Thread.sleep(2000);	
		
	
		
		String url=driver.getCurrentUrl();
		TestLogger.log("Current URL: "+url);
		URL nurl = new URL(url);
		String path = nurl.getPath();
		String elementid = path.substring(path.lastIndexOf('/') + 1);
		TestLogger.log("ID from current url: "+elementid);
		
		String statustext=elementPage.getStatus().getText();
		String status=(String) statustext.subSequence(15, 22);
		TestLogger.log("Current status :"+status);
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		elementPage.selectDeptByText(dept);
		TestLogger.log("Dept Selected");
		elementPage.selectRetakeTypeByText(retake);
		TestLogger.log("Default Retake Style Selected");
		elementPage.selectTaskTypeByText(task);
		TestLogger.log("Task type Selected");
		
		elementPage.startDate().clear();
		String sdate=elementPage.newfuturedate5();
		System.out.println(sdate);
		elementPage.startDate().sendKeys(sdate);
		elementPage.pressEscape();	
		
		elementPage.endDate().clear();
		String edate=elementPage.newfuturedate10();
		System.out.println(edate);
		elementPage.endDate().sendKeys(edate);
		elementPage.pressEscape();
		
		TestLogger.log("End Date Selected");
		elementPage.sendDuration(duration);
		TestLogger.log("Duration Selected");
		elementPage.sendParticipantList(participant);
		TestLogger.log("Participant list provided");
		elementPage.clickSecondCommitment();
		TestLogger.log("Second commitment checked");
		elementPage.click3rdClient();
		TestLogger.log("Client selected");
		elementPage.clickFlexActivityAspect();
		TestLogger.log("Aspect selected");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		elementPage.clickShopcomOrder();
		TestLogger.log("Shomcom order selected");
		elementPage.clickSkills();
		TestLogger.log("Skills selected");
		gotoBottomPage();
		
		
		elementPage.clickStoreAddTempButton();
		TestLogger.log("Store Temp Add button clicked");
		elementPage.clickLinkExistingButton();
		TestLogger.log("Link Existing button clicked for store temp");
		elementPage.selectStatusByText("Approved");
		TestLogger.log("Status Approve selected for store temp filter");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		elementPage.selectFirstTemp();
		TestLogger.log("First store Temp selected");
		elementPage.clickNextButton();
		TestLogger.log("Next button clicked for store temp");
	
		String storeTempNum=elementPage.getStoretempnum().getText();
		TestLogger.log("The store Temp number is :"+storeTempNum);
		gotoBottomPage();
		
		elementPage.clickItemAddTempButton();
		TestLogger.log("Item Temp Add button clicked");
		elementPage.clickLinkExistingButton();
		TestLogger.log("Link Existing button clicked for item temp");
		elementPage.selectStatusByText("Approved");
		TestLogger.log("Status Approve selected for item temp filter");
		elementPage.selectFirstTemp();
		TestLogger.log("First item Temp selected");
		elementPage.clickNextButton();
		TestLogger.log("Next button clicked for item temp");
		gotoBottomPage();
		elementPage.clickParticipantItem();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		elementPage.clickUploadPartipant();
		TestLogger.log("Participant/Item button clicked");
		elementPage.clickChooseFile();
		TestLogger.log("Choose file button clicked");
		
		elementPage.uploadFile(System.getProperty("user.dir")+"\\Attachments\\2items5store"+".csv");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		elementPage.clickUploadButton();
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		elementPage.clickBackButton();
		TestLogger.log("Back button clicked");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		elementPage.clickBackButton();
		TestLogger.log("Back button clicked");
			
		String itemTempNum=elementPage.getItemtempnum().getText();
		TestLogger.log("The item Temp number is :"+itemTempNum);
		gotoBottomPage();
		
		
		elementPage.clickConcludingAddTempButton();
		TestLogger.log("Concluding Temp Add button clicked");
		elementPage.clickLinkExistingButton();
		TestLogger.log("Link Existing button clicked for item temp");
		elementPage.selectStatusByText("Approved");
		TestLogger.log("Status Approve selected for concluding temp filter");
		elementPage.selectSecondTemp();
		TestLogger.log("Second concluding Temp selected");
		elementPage.clickNextButton();
		TestLogger.log("Next button clicked for concluding temp");
		String concludingTempNum=elementPage.getConcludingtempnum().getText();
		TestLogger.log("The concluding Temp number is :"+concludingTempNum);	
		gotoBottomPage();
		
		
		
		elementPage.clickElementAttachment();
		elementPage.uploadFile(System.getProperty("user.dir")+"\\Attachments\\Image"+".jpg");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		//Thread.sleep(2000);
		elementPage.clickSubmitReview();
		TestLogger.log("Submit for Review button clicked");
		driver.switchTo().alert().accept();
		//elementPage.clickSaveClose();
		
		String pstatustext=elementPage.getStatus().getText();
		String pstatus=(String) pstatustext.subSequence(15, 22);
		TestLogger.log("Current status :"+pstatus);
		
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		elementPage.clickLogoutButton();
		
		elementTestPage.getLogin(user2, pass2);
		
		elementPage.clickProjectsIcon();
		TestLogger.log("Project Icon Clicked");
		elementPage.moveToActivities();
		TestLogger.log("Move to Activities");
		elementPage.clickElements();
		TestLogger.log("Elements menu clicked");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		elementPage.sendID(elementid);
		TestLogger.log("Element id sent");
		elementPage.clickApply();
		TestLogger.log("Apply button clicked");
		elementPage.clickFiteredElement();
		TestLogger.log("Elements filtered with id");
		
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		elementPage.clickReleaseButton();
		TestLogger.log("Release button clicked");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		
		boolean b=driver.getPageSource().contains("Project element has been added to the release queue.");
		
		
		if(b==true)
		{
			Assert.assertTrue(true);
			TestLogger.log("test case passed....Save successful.");
			
		}else	{
			
			captureScreenrobot("validateElementCreation");
			Assert.assertTrue(false,"Template Did not Save successful....");
		}
		
		
		String rstatustext=elementPage.getStatus().getText();
		String rstatus=(String) rstatustext.subSequence(15, 24);
		TestLogger.log("Current status :"+rstatus);
		
		DataTest dt= new DataTest();
		dt.validateElementData(dept,retake,task,sdate,edate,duration,participant,elementid,rstatus,itemTempNum,storeTempNum,concludingTempNum);
			
	}
	
		@DataProvider(name="ElementData")
		public Object[][] getData() throws IOException {
			Object data[][]=XLUtils.getData("ElementData.xlsx");
			return data;
	}
		
		
		
		
		
		@Test(dataProvider="DateElementData")
		public void validateDateElementPage(String user,String pass,String dept,String retake,String task,String duration,String participant) throws Exception {
			TC_ElementsPageTest_002 elementTestPage =new TC_ElementsPageTest_002();
			ElementsPage elementPage=new ElementsPage(driver);

			elementTestPage.getLogin(user,pass);
			elementTestPage.getelementPage();
			
			String url=driver.getCurrentUrl();
			TestLogger.log("Current URL: "+url);
			URL nurl = new URL(url);
			String path = nurl.getPath();
			String elementid = path.substring(path.lastIndexOf('/') + 1);
			TestLogger.log("ID from current url: "+elementid);
			
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			
			elementPage.selectDeptByText(dept);
			TestLogger.log("Dept Selected");
			elementPage.selectRetakeTypeByText(retake);
			TestLogger.log("Default Retake Style Selected");
			elementPage.selectTaskTypeByText(task);
			TestLogger.log("Task type Selected");
			
			elementPage.startDate().clear();
			String sdate=elementPage.newfuturedate10();
			System.out.println(sdate);
			elementPage.startDate().sendKeys(sdate);
			elementPage.pressEscape();	
			
			elementPage.endDate().clear();
			String edate=elementPage.newfuturedate5();
			System.out.println(edate);
			elementPage.endDate().sendKeys(edate);
			elementPage.pressEscape();
			
			TestLogger.log("End Date Selected");
			elementPage.sendDuration(duration);
			TestLogger.log("Duration Selected");
			elementPage.sendParticipantList(participant);
			TestLogger.log("Participant list provided");
			elementPage.clickSecondCommitment();
			TestLogger.log("Second commitment checked");
			elementPage.click3rdClient();
			elementPage.clickSaveClose();
			
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			
			boolean b=driver.getPageSource().contains("End date/time should fall after start date");
			
			
			if(b==true)
			{
				Assert.assertTrue(true);
				TestLogger.log("test case passed....");
				
			}else	{
				
				captureScreenrobot("validateDateElementPage");
				Assert.assertTrue(false,"Test fail...");
			}
			
		}
		
		@DataProvider(name="DateElementData")
		public Object[][] getData2() throws IOException {
			Object data[][]=XLUtils.getData("DateElementData.xlsx");
			return data;
	}
		
		
		
		@Test(dataProvider="CommitmentElementData")
		public void validateCommitmentElementPage(String user,String pass,String dept,String retake,String task,String duration,String participant) throws Exception {
			TC_ElementsPageTest_002 elementTestPage =new TC_ElementsPageTest_002();
			ElementsPage elementPage=new ElementsPage(driver);
			

			elementTestPage.getLogin(user,pass);
			elementTestPage.getelementPage();	
			
			String url=driver.getCurrentUrl();
			TestLogger.log("Current URL: "+url);
			URL nurl = new URL(url);
			String path = nurl.getPath();
			String elementid = path.substring(path.lastIndexOf('/') + 1);
			TestLogger.log("ID from current url: "+elementid);
			
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			
			elementPage.selectDeptByText(dept);
			TestLogger.log("Dept Selected");
			elementPage.selectRetakeTypeByText(retake);
			TestLogger.log("Default Retake Style Selected");
			elementPage.selectTaskTypeByText(task);
			TestLogger.log("Task type Selected");
			
			elementPage.startDate().clear();
			String sdate=elementPage.newfuturedate5();
			System.out.println(sdate);
			elementPage.startDate().sendKeys(sdate);
			elementPage.pressEscape();	
			
			elementPage.endDate().clear();
			String edate=elementPage.newfuturedate10();
			System.out.println(edate);
			elementPage.endDate().sendKeys(edate);
			elementPage.pressEscape();
			
			TestLogger.log("End Date Selected");
			elementPage.sendDuration(duration);
			TestLogger.log("Duration Selected");
			elementPage.sendParticipantList(participant);
			TestLogger.log("Participant list provided");
			//elementPage.clickSecondCommitment();
			//TestLogger.log("Second commitment checked");
			//elementPage.click3rdClient();
			elementPage.clickSaveClose();
			
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			
			boolean b=driver.getPageSource().contains("At least one commitment must be selected.");
			
			
			if(b==true)
			{
				Assert.assertTrue(true);
				TestLogger.log("test case passed....");
				
			}else	{
				
				captureScreenrobot("validateCommitmentElementPage");
				Assert.assertTrue(false,"Test fail...");
			}
			
			
		}
		
		@DataProvider(name="CommitmentElementData")
		public Object[][] getData3() throws IOException {
			Object data[][]=XLUtils.getData("CommitmentElementData.xlsx");
			return data;
	}
		
		
		@Test(dataProvider="DurationElementData")
		public void validateDurationElementPage(String user,String pass,String dept,String retake,String task,String participant) throws Exception {
			TC_ElementsPageTest_002 elementTestPage =new TC_ElementsPageTest_002();
			ElementsPage elementPage=new ElementsPage(driver);
			

			elementTestPage.getLogin(user,pass);
			elementTestPage.getelementPage();	
			
			String url=driver.getCurrentUrl();
			TestLogger.log("Current URL: "+url);
			URL nurl = new URL(url);
			String path = nurl.getPath();
			String elementid = path.substring(path.lastIndexOf('/') + 1);
			TestLogger.log("ID from current url: "+elementid);
			
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			
			elementPage.selectDeptByText(dept);
			TestLogger.log("Dept Selected");
			elementPage.selectRetakeTypeByText(retake);
			TestLogger.log("Default Retake Style Selected");
			elementPage.selectTaskTypeByText(task);
			TestLogger.log("Task type Selected");
			
			elementPage.startDate().clear();
			String sdate=elementPage.newfuturedate5();
			System.out.println(sdate);
			elementPage.startDate().sendKeys(sdate);
			elementPage.pressEscape();	
			
			elementPage.endDate().clear();
			String edate=elementPage.newfuturedate10();
			System.out.println(edate);
			elementPage.endDate().sendKeys(edate);
			elementPage.pressEscape();
			TestLogger.log("End Date Selected");
			//elementPage.sendDuration(duration);
			//TestLogger.log("Duration Selected");
			elementPage.sendParticipantList(participant);
			TestLogger.log("Participant list provided");
			elementPage.clickSecondCommitment();
			TestLogger.log("Second commitment checked");
			//elementPage.click3rdClient();
			elementPage.clickSaveClose();
		
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			
			boolean b=driver.getPageSource().contains("This is a required field.");
			
			
			if(b==true)
			{
				Assert.assertTrue(true);
				TestLogger.log("test case passed....");
				
			}else	{
				
				captureScreenrobot("validateDurationElementPage");
				Assert.assertTrue(false,"Test fail...");
			}
		}
			@DataProvider(name="DurationElementData")
			public Object[][] getData5() throws IOException {
				Object data[][]=XLUtils.getData("DurationElementData.xlsx");
				return data;
			
			
		}
			
			
			@Test(dataProvider="DurationLetterElementData")
			public void validateDurationLetterElementPage(String user,String pass,String dept,String retake,String task,String duration,String participant) throws Exception {
				TC_ElementsPageTest_002 elementTestPage =new TC_ElementsPageTest_002();
				ElementsPage elementPage=new ElementsPage(driver);
				

				elementTestPage.getLogin(user,pass);
				elementTestPage.getelementPage();	
				
				String url=driver.getCurrentUrl();
				TestLogger.log("Current URL: "+url);
				URL nurl = new URL(url);
				String path = nurl.getPath();
				String elementid = path.substring(path.lastIndexOf('/') + 1);
				TestLogger.log("ID from current url: "+elementid);
				
				driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
				
				elementPage.selectDeptByText(dept);
				TestLogger.log("Dept Selected");
				elementPage.selectRetakeTypeByText(retake);
				TestLogger.log("Default Retake Style Selected");
				elementPage.selectTaskTypeByText(task);
				TestLogger.log("Task type Selected");
				
				elementPage.startDate().clear();
				String sdate=elementPage.newfuturedate5();
				System.out.println(sdate);
				elementPage.startDate().sendKeys(sdate);
				elementPage.pressEscape();	
				
				elementPage.endDate().clear();
				String edate=elementPage.newfuturedate10();
				System.out.println(edate);
				elementPage.endDate().sendKeys(edate);
				elementPage.pressEscape();
				TestLogger.log("End Date Selected");
				elementPage.sendDuration(duration);
				TestLogger.log("Duration Selected");
				elementPage.sendParticipantList(participant);
				TestLogger.log("Participant list provided");
				elementPage.clickSecondCommitment();
				TestLogger.log("Second commitment checked");
				elementPage.clickSaveClose();
			
				driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
				
				boolean b=driver.getPageSource().contains("This is not a valid entry. Please use digits only.");
				
				
				if(b==true)
				{
					Assert.assertTrue(true);
					TestLogger.log("test case passed....");
					
				}else	{
					
					captureScreenrobot("validateDurationLetterElementPage");
					Assert.assertTrue(false,"Test fail...");
				}
			}
				@DataProvider(name="DurationLetterElementData")
				public Object[][] getData6() throws IOException {
					Object data[][]=XLUtils.getData("DurationLetterElementData.xlsx");
					return data;
				
				
			}
		
		@Test(dataProvider="TemplateElementData")
		public void validateTemplatelementPage(String user,String pass,String dept,String retake,String task,String duration,String participant) throws Exception {
			TC_ElementsPageTest_002 elementTestPage =new TC_ElementsPageTest_002();
			ElementsPage elementPage=new ElementsPage(driver);
			

			elementTestPage.getLogin(user,pass);
			elementTestPage.getelementPage();	
			
			String url=driver.getCurrentUrl();
			TestLogger.log("Current URL: "+url);
			URL nurl = new URL(url);
			String path = nurl.getPath();
			String elementid = path.substring(path.lastIndexOf('/') + 1);
			TestLogger.log("ID from current url: "+elementid);
			
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			
			elementPage.selectDeptByText(dept);
			TestLogger.log("Dept Selected");
			elementPage.selectRetakeTypeByText(retake);
			TestLogger.log("Default Retake Style Selected");
			elementPage.selectTaskTypeByText(task);
			TestLogger.log("Task type Selected");
			
			elementPage.startDate().clear();
			String sdate=elementPage.newfuturedate5();
			System.out.println(sdate);
			elementPage.startDate().sendKeys(sdate);
			elementPage.pressEscape();	
			
			elementPage.endDate().clear();
			String edate=elementPage.newfuturedate10();
			System.out.println(edate);
			elementPage.endDate().sendKeys(edate);
			elementPage.pressEscape();
			
			TestLogger.log("End Date Selected");
			elementPage.sendDuration(duration);
			TestLogger.log("Duration Selected");
			elementPage.sendParticipantList(participant);
			TestLogger.log("Participant list provided");
			elementPage.clickSecondCommitment();
			TestLogger.log("Second commitment checked");
			elementPage.click3rdClient();
			elementPage.clickSubmitReview();
			
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			
			Alert alert = driver.switchTo().alert();
			String textAlert=alert.getText();
			System.out.println(textAlert);
			
			boolean b=textAlert.contains("Please add templates and try again.");
			
			
			if(b==true)
			{
				Assert.assertTrue(true);
				TestLogger.log("test case passed....");
				
			}else	{
				
				captureScreenrobot("validateTemplatelementPage");
				Assert.assertTrue(false,"Test fail...");
			}
			
			
		}
		
		@DataProvider(name="TemplateElementData")
		public Object[][] getData4() throws IOException {
			Object data[][]=XLUtils.getData("TemplateElementData.xlsx");
			return data;
	}
		
		
		public void getLogin(String username,String password) {

			LoginPage lp=new LoginPage(driver);
			lp.setUserName(username);
			TestLogger.log("Usename :"+username);
			lp.setPassword(password);
			TestLogger.log("password: "+password);
			lp.clickSubmit();	
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		}
		
		


		public void getelementPage() throws Exception {
			
			ElementsPage elementPage=new ElementsPage(driver);
			
			elementPage.clickProjectsIcon();
			TestLogger.log("Project Icon Clicked");
			elementPage.moveToActivities();
			TestLogger.log("Move to Activities");
			elementPage.clickProgram();
			TestLogger.log("Program menu clicked");
			elementPage.clickFirstId();
			TestLogger.log("program list clicked");
			elementPage.clickExecutionTab();
			TestLogger.log("Execution tab clicked");
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			elementPage.openRowwWeeklyLabor();
			TestLogger.log("Row weekly Labor opened");
			elementPage.clickWeeklyLaborRow();
			TestLogger.log("Weekly Labor row clicked");
			elementPage.clickNewElementButton();
			TestLogger.log("New Element Button clicked");
			elementPage.clickTemplatedElement();
			TestLogger.log("Templated Element Selected");
			Thread.sleep(2000);	
		}
		
			
			
			
			
		
	

}
