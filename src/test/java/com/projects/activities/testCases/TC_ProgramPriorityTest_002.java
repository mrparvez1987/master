package com.projects.activities.testCases;

import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.dash2sell.database.DataTest;
import com.dash2sell.pageObjects.LoginPage;
import com.dashManagement.utilities.TestLogger;
import com.dashManagement.utilities.XLUtils;
import com.projects.activities.pageObjects.ProgramListPage;
import com.projects.activities.pageObjects.ProgramPriorityPage;




public class TC_ProgramPriorityTest_002 extends BaseClass {
	
	
	@Test(dataProvider="ProgramPageData")
	public void createProgramPriority(String uname,String pwd,String progId,String rank,String effDate,String expDate,String follow) throws InterruptedException, IOException
	{
		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(uname);
		logger.info("user name provided");
		
		lp.setPassword(pwd);
		
		logger.info("password provided");
		lp.clickSubmit();
		
		ProgramPriorityPage program=new ProgramPriorityPage(driver);
		
		program.clickProjectsIcon();
		logger.info("Projects Icon clicked");
		program.moveToActivities();
		logger.info("Move to Activities");
		program.clickProgPriority();
		logger.info("Program Priority Clicked");
		program.clickNewProgPriority();
		logger.info("New Program Priority cliecked");
		program.sendProgramId(progId);
		logger.info("Program ID Send");
		Thread.sleep(2000);
		program.clickProgramDesc();
		logger.info("Program Description Clicked");
		program.sendProgRank(rank);
		logger.info("Rank Send");
		program.sendProgEffectiveDate(effDate);
		logger.info("Effective Date Selected");
		program.sendProgExpireDate(expDate);
		logger.info("Expire Date Selected");
		program.selectdrProgFollowups(follow);
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
		
		
		
		DataTest dt= new DataTest();
		try {
			dt.validateProgramPageData(progId,rank,effDate,expDate,follow);
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	
	/*@DataProvider(name="ProgramPageData")
	String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/dash2sell/testData/ProgramPageData.xlsx";
	
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);
		
		String programdata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				programdata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);//1 0
			}
				
		}
	return programdata;
	}
	*/
	
	
	/*@DataProvider(name="ProgramPageData")
	public Object[][] getProgramPageData() {
		Object data [] []=TestUtil.getTestData("sheet1");
		return data;
	}
			*/
	
	@DataProvider(name="ProgramPageData")
	public Object[][] getProgramData() throws IOException {
		Object data[][]=XLUtils.getData(System.getProperty("user.dir")+"/src/test/java/com/dash2sell/testData/ProgramPageData.xlsx");
		return data;
	}
	
	
	
	
	//Validate Program ID without entering any ID
	
	@Test
	public void validateProgramId() throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		
		lp.setUserName(username);
		
		TestLogger.log("username: "+username);
		
		lp.setPassword(password);
		
		
		TestLogger.log("password: "+password);
		
		lp.clickSubmit();
		
		TestLogger.log("Submit button clicked");
			
		
		ProgramPriorityPage program=new ProgramPriorityPage(driver);
		
		program.clickProjectsIcon();
		TestLogger.log("Icon clicked");
		program.moveToActivities();
		TestLogger.log("Move to Activities");
		program.clickProgPriority();
		
		program.clickNewProgPriority();
		TestLogger.log("New Program Priority cliecked");
		
		TestLogger.log("Program ID did not Send");
		
		program.sendProgRank("2019-11-16");
	
		program.sendProgEffectiveDate("2019-10-10");
		
		program.sendProgExpireDate("2019-10-20");
		
		program.selectdrProgFollowups("1");
	
		program.clickProgSave();
		
		
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		//Thread.sleep(2000);
		
		boolean res=driver.getPageSource().contains("5555");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			TestLogger.log("expected find");
			
			
		}
		else
		{
			
			try {
				captureScreenrobot("validateProgramId");
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
			Assert.assertTrue(false, "not find expected..'this messege'.... ");
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
