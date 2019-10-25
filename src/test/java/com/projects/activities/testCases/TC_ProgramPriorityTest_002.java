package com.projects.activities.testCases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.projects.activities.pageObjects.ProgramListPage;
import com.projects.activities.pageObjects.ProgramPriorityPage;
public class TC_ProgramPriorityTest_002 extends BaseClass {
	
	
	//Create New Program Priority by fill all the required fields
	@Test
	public void createProgramPriority() throws InterruptedException, IOException
	{
		AccessLogin login=new AccessLogin();
		login.loginAccess();
		
		ProgramPriorityPage program=new ProgramPriorityPage(driver);
		
		program.clickProjectsIcon();
		logger.info("Projects Icon clicked");
		program.moveToActivities();
		logger.info("Move to Activities");
		program.clickProgPriority();
		logger.info("Program Priority Clicked");
		program.clickNewProgPriority();
		logger.info("New Program Priority cliecked");
		program.sendProgramId("1500");
		logger.info("Program ID Send");
		program.clickProgramDesc();
		logger.info("Program Description Clicked");
		program.sendProgRank("5");
		logger.info("Rank Send");
		program.sendProgEffectiveDate("2019-10-10");
		logger.info("Effective Date Selected");
		program.sendProgExpireDate("2019-10-20");
		logger.info("Expire Date Selected");
		program.selectdrProgFollowups("1");
		logger.info("Followups 'Yes' Selected");
		program.clickProgSave();
		logger.info("Save button clicked");
		
		

		logger.info("validation started....");
		Thread.sleep(2000);
		String title=driver.getTitle();
		System.out.println("Current page title is:"+" "+title);
	
		
		boolean res=driver.getTitle().contentEquals("Program Priorities - Anderson Merchandisers");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
			
		}
		else
		{
			logger.info("test case failed....");
			captureScreen(driver,"createProgramPriority");
			Assert.assertTrue(false);
		}
	}
	
	//Validate Program ID without entering any ID
	@Test
	public void validateProgramId() throws InterruptedException, IOException
	{
		AccessLogin login=new AccessLogin();
		login.loginAccess();
		
		ProgramPriorityPage program=new ProgramPriorityPage(driver);
		
		program.clickProjectsIcon();
		logger.info("Projects Icon clicked");
		program.moveToActivities();
		logger.info("Move to Activities");
		program.clickProgPriority();
		logger.info("Program Priority Clicked");
		program.clickNewProgPriority();
		logger.info("New Program Priority cliecked");
		//program.sendProgramId("1500");
		logger.info("Program ID did not Send");
		//program.clickProgramIDesc();
		//logger.info("Program Description Clicked");
		program.sendProgRank("5");
		logger.info("Rank Send");
		program.sendProgEffectiveDate("2019-10-10");
		logger.info("Effective Date Selected");
		program.sendProgExpireDate("2019-10-20");
		logger.info("Expire Date Selected");
		program.selectdrProgFollowups("1");
		logger.info("Followups 'Yes' Selected");
		program.clickProgSave();
		logger.info("Save button clicked");
		
		
		logger.info("validation started....");
		Thread.sleep(2000);
		
		boolean res=driver.getPageSource().contains("This is a required field.");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
			
		}
		else
		{
			logger.info("test case failed....");
			captureScreen(driver,"validateProgramId");
			Assert.assertTrue(false);
		}
	}
	
	
	//Validate Program Rank without entering any Rank
	@Test
	public void validateProgramRank() throws InterruptedException, IOException
	{
		AccessLogin login=new AccessLogin();
		login.loginAccess();
		
		ProgramPriorityPage program=new ProgramPriorityPage(driver);
		
		program.clickProjectsIcon();
		logger.info("Projects Icon clicked");
		program.moveToActivities();
		logger.info("Move to Activities");
		program.clickProgPriority();
		logger.info("Program Priority Clicked");
		program.clickNewProgPriority();
		logger.info("New Program Priority cliecked");
		program.sendProgramId("1500");
		logger.info("Program ID Send");
		program.clickProgramDesc();
		logger.info("Program Description Clicked");
		//program.sendProgRank("5");
		logger.info("Rank not Selected");
		program.sendProgEffectiveDate("2019-10-10");
		logger.info("Effective Date Selected");
		program.sendProgExpireDate("2019-10-20");
		logger.info("Expire Date Selected");
		program.selectdrProgFollowups("0");
		logger.info("Followups 'No' Selected");
		program.clickProgSave();
		logger.info("Save button clicked");
		
		
		logger.info("validation started....");
		Thread.sleep(2000);
		
		boolean res=driver.getPageSource().contains("This is a required field.");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
			
		}
		else
		{
			logger.info("test case failed....");
			captureScreen(driver,"validateProgramRank");
			Assert.assertTrue(false);
		}
		
	}
	
	
	//Validate Rank with letter and number
	@Test
	public void validateProgramRankMix() throws InterruptedException, IOException
	{
		AccessLogin login=new AccessLogin();
		login.loginAccess();
		
		ProgramPriorityPage program=new ProgramPriorityPage(driver);
		
		program.clickProjectsIcon();
		logger.info("Projects Icon clicked");
		program.moveToActivities();
		logger.info("Move to Activities");
		program.clickProgPriority();
		logger.info("Program Priority Clicked");
		program.clickNewProgPriority();
		logger.info("New Program Priority cliecked");
		program.sendProgramId("1500");
		logger.info("Program ID Send");
		program.clickProgramDesc();
		logger.info("Program Description Clicked");
		program.sendProgRank("5abc");
		logger.info("Rank with number AND Letter Selected");
		program.sendProgEffectiveDate("2019-10-10");
		logger.info("Effective Date Selected");
		program.sendProgExpireDate("2019-10-20");
		logger.info("Expire Date Selected");
		program.selectdrProgFollowups("0");
		logger.info("Followups 'No' Selected");
		program.clickProgSave();
		logger.info("Save button clicked");
		
		
		logger.info("validation started....");
		Thread.sleep(2000);
		
		boolean res=driver.getPageSource().contains("This is not a valid entry. Please use digits only.");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
			
		}
		else
		{
			logger.info("test case failed....");
			captureScreen(driver,"validateProgramRankMix");
			Assert.assertTrue(false);
		}
		
	}
	//Validate Program Effective Date without selecting 
	@Test
	public void validateProgramEffectiveDate() throws InterruptedException, IOException
	{
		AccessLogin login=new AccessLogin();
		login.loginAccess();
		
		ProgramPriorityPage program=new ProgramPriorityPage(driver);
		
		program.clickProjectsIcon();
		logger.info("Projects Icon clicked");
		program.moveToActivities();
		logger.info("Move to Activities");
		program.clickProgPriority();
		logger.info("Program Priority Clicked");
		program.clickNewProgPriority();
		logger.info("New Program Priority cliecked");
		program.sendProgramId("1500");
		logger.info("Program ID Send");
		program.clickProgramDesc();
		logger.info("Program Description Clicked");
		program.sendProgRank("5");
		logger.info("Rank Send");
		//program.sendProgEffectiveDate("2019-10-10");
		logger.info("Effective Date not Selected");
		program.sendProgExpireDate("2019-10-20");
		logger.info("Expire Date Selected");
		program.selectdrProgFollowups("0");
		logger.info("Followups 'No' Selected");
		program.clickProgSave();
		logger.info("Save button clicked");
		
		
		logger.info("validation started....");
		Thread.sleep(2000);
		
		boolean res=driver.getPageSource().contains("This is a required field.");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
			
		}
		else
		{
			logger.info("test case failed....");
			captureScreen(driver,"validateProgramEffectiveDate");
			Assert.assertTrue(false);
		}
	}
	
	
	//Validate Program Expire Date without selecting 
	@Test
	public void validateProgramExpireDate() throws InterruptedException, IOException
	{
		AccessLogin login=new AccessLogin();
		login.loginAccess();
		
		ProgramPriorityPage program=new ProgramPriorityPage(driver);
		
		program.clickProjectsIcon();
		logger.info("Projects Icon clicked");
		program.moveToActivities();
		logger.info("Move to Activities");
		program.clickProgPriority();
		logger.info("Program Priority Clicked");
		program.clickNewProgPriority();
		logger.info("New Program Priority cliecked");
		program.sendProgramId("1500");
		logger.info("Program ID Send");
		program.clickProgramDesc();
		logger.info("Program Description Clicked");
		program.sendProgRank("5");
		logger.info("Rank Send");
		program.sendProgEffectiveDate("2019-10-10");
		logger.info("Effective Date Selected");
		//program.sendProgExpireDate("2019-10-20");
		logger.info("Expire Date not Selected");
		program.selectdrProgFollowups("0");
		logger.info("Followups 'No' Selected");
		program.clickProgSave();
		logger.info("Save button clicked");
		
		
		logger.info("validation started....");
		Thread.sleep(2000);
		
		boolean res=driver.getPageSource().contains("This is a required field.");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
			
		}
		else
		{
			logger.info("test case failed....");
			captureScreen(driver,"validateProgramExpireDate");
			Assert.assertTrue(false);
		}
		
	}
	
	//Validate Expire date with selecting past date than effective date
	@Test
	public void validateProgramExpireDatePast() throws InterruptedException, IOException
	{
		AccessLogin login=new AccessLogin();
		login.loginAccess();
		
		ProgramPriorityPage program=new ProgramPriorityPage(driver);
		
		program.clickProjectsIcon();
		logger.info("Projects Icon clicked");
		program.moveToActivities();
		logger.info("Move to Activities");
		program.clickProgPriority();
		logger.info("Program Priority Clicked");
		program.clickNewProgPriority();
		logger.info("New Program Priority cliecked");
		program.sendProgramId("1500");
		logger.info("Program ID Send");
		program.clickProgramDesc();
		logger.info("Program Description Clicked");
		program.sendProgRank("5");
		logger.info("Rank Send");
		program.sendProgEffectiveDate("2019-10-10");
		logger.info("Effective Date Selected");
		program.sendProgExpireDate("2019-10-05");
		logger.info("Expire Date Selected As Past");
		program.selectdrProgFollowups("0");
		logger.info("Followups 'No' Selected");
		program.clickProgSave();
		logger.info("Save button clicked");
	
		
		logger.info("validation started....");
		Thread.sleep(2000);
		
		boolean res=driver.getPageSource().contains("Expiration date must be equal to or greater than effective date.");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
			
		}
		else
		{
			logger.info("test case failed....");
			captureScreen(driver,"validateProgramExpireDatePast");
			Assert.assertTrue(false);
		}
		
	}
	
	//Validate delete button without selecting any program
	@Test
	public void validateProgramDel() throws InterruptedException, IOException
	{
		AccessLogin login=new AccessLogin();
		login.loginAccess();
		
		ProgramPriorityPage program=new ProgramPriorityPage(driver);
		
		program.clickProjectsIcon();
		logger.info("Projects Icon clicked");
		program.moveToActivities();
		logger.info("Move to Activities");
		program.clickProgPriority();
		logger.info("Program Priority Clicked");
		program.clickNewProgPriority();
		logger.info("New Program Priority cliecked");
		program.clickProgDelete();
		logger.info("Delete button clicked without selecting any program");
		
		driver.switchTo().alert().accept();
		
		
		logger.info("validation started....");
		Thread.sleep(2000);
		
		boolean res=driver.getPageSource().contains("No record id was specified.");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
			
		}
		else
		{
			logger.info("test case failed....");
			captureScreen(driver,"validateProgramDel");
			Assert.assertTrue(false);
		}
		
	}
	
	//validate delete button with selected record
	@Test
	public void validateProgramRecordDel() throws InterruptedException, IOException
	{
		AccessLogin login=new AccessLogin();
		login.loginAccess();
		
		ProgramPriorityPage program=new ProgramPriorityPage(driver);
		ProgramListPage programList=new ProgramListPage(driver);
		
		program.clickProjectsIcon();
		logger.info("Projects Icon clicked");
		program.moveToActivities();
		logger.info("Move to Activities");
		program.clickProgPriority();
		logger.info("Program Priority Clicked");
		program.clickNewProgPriority();
		logger.info("New Program Priority cliecked");
		program.sendProgramId("1500");
		logger.info("Program ID Send");
		program.clickProgramDesc();
		logger.info("Program Description Clicked");
		program.sendProgRank("5");
		logger.info("Rank Send");
		program.sendProgEffectiveDate("2019-10-12");
		logger.info("Effective Date Selected");
		program.sendProgExpireDate("2019-10-20");
		logger.info("Expire Date Selected");
		program.selectdrProgFollowups("0");
		logger.info("Followups 'No' Selected");
		program.clickProgSave();
		logger.info("Save button clicked");
		Thread.sleep(3000);
		
		programList.sendProgramID("1500");
		logger.info("Program ID Send");
		programList.clickApply();
		logger.info("Apply button clicked");
		programList.deleteProgramIDRecord();
		logger.info("deletable ID selected");
		program.clickProgDelete();
		logger.info("Id deleted");
		driver.switchTo().alert().accept();
		
		
		

		logger.info("validation started....");
		Thread.sleep(2000);
		//String title=driver.getTitle();
		//System.out.println("Current page title is:"+" "+title);
	
		
		boolean res=driver.getPageSource().contains("Record deleted.");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
			
		}
		else
		{
			logger.info("test case failed....");
			captureScreen(driver,"validateProgramRecordDel");
			Assert.assertTrue(false);
		}
	}


}
