package com.projects.activities.testCases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.projects.activities.pageObjects.ProjectListPage;
import com.projects.activities.pageObjects.ProjectPriorityPage;

public class TC_ProjectPriorityTest_003 extends BaseClass{
	
	
	//Create New Project Priority by fill all the required fields
	@Test
	public void createProgramPriority() throws InterruptedException, IOException
	{
		AccessLogin login=new AccessLogin();
		login.loginAccess();
		
		ProjectPriorityPage project=new ProjectPriorityPage(driver);
		
		project.clickProjectsIcon();
		logger.info("Projects Icon clicked");
		project.moveToActivities();
		logger.info("Move to Activities");
		project.clickProjPriority();
		logger.info("Project Priority Clicked");
		project.clickNewProjPriority();
		logger.info("New Project Priority cliecked");
		project.sendProjectId("1300");
		logger.info("Project ID Send");
		project.clickProjectDesc();
		logger.info("Project Description Clicked");
		project.sendProjRank("5");
		logger.info("Rank Send");
		project.sendProjEffectiveDate("2019-10-10");
		logger.info("Effective Date Selected");
		project.sendProjExpireDate("2019-10-20");
		logger.info("Expire Date Selected");
		project.selectProjFollowups("1");
		logger.info("Followups 'Yes' Selected");
		project.clickProjSave();
		logger.info("Save button clicked");
		
		

		logger.info("validation started....");
		Thread.sleep(2000);
		String title=driver.getTitle();
		System.out.println("Current page title is:"+" "+title);
	
		
		boolean res=driver.getTitle().contentEquals("Project Priorities - Anderson Merchandisers");
		
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
	
	//Validate Project ID without entering any ID
		@Test
		public void validateProjectId() throws InterruptedException, IOException
		{
			AccessLogin login=new AccessLogin();
			login.loginAccess();
			
			ProjectPriorityPage project=new ProjectPriorityPage(driver);
			
			project.clickProjectsIcon();
			logger.info("Projects Icon clicked");
			project.moveToActivities();
			logger.info("Move to Activities");
			project.clickProjPriority();
			logger.info("Project Priority Clicked");
			project.clickNewProjPriority();
			logger.info("New Project Priority cliecked");
			//project.sendProjectId("1300");
			logger.info("Project ID did not Send");
			//project.clickProjectDesc();
			//logger.info("Project Description Clicked");
			project.sendProjRank("5");
			logger.info("Rank Send");
			project.sendProjEffectiveDate("2019-10-10");
			logger.info("Effective Date Selected");
			project.sendProjExpireDate("2019-10-20");
			logger.info("Expire Date Selected");
			project.selectProjFollowups("1");
			logger.info("Followups 'Yes' Selected");
			project.clickProjSave();
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
				captureScreen(driver,"validateProjectId");
				Assert.assertTrue(false);
			}
		}
		
		//Validate Project Rank without entering any Rank
		@Test
		public void validateProjectRank() throws InterruptedException, IOException
		{
			AccessLogin login=new AccessLogin();
			login.loginAccess();
			
			ProjectPriorityPage project=new ProjectPriorityPage(driver);
			
			project.clickProjectsIcon();
			logger.info("Projects Icon clicked");
			project.moveToActivities();
			logger.info("Move to Activities");
			project.clickProjPriority();
			logger.info("Project Priority Clicked");
			project.clickNewProjPriority();
			logger.info("New Project Priority cliecked");
			project.sendProjectId("1300");
			logger.info("Project ID Send");
			project.clickProjectDesc();
			logger.info("Project Description Clicked");
			//project.sendProgRank("5");
			logger.info("Rank not Selected");
			project.sendProjEffectiveDate("2019-10-10");
			logger.info("Effective Date Selected");
			project.sendProjExpireDate("2019-10-20");
			logger.info("Expire Date Selected");
			project.selectProjFollowups("0");
			logger.info("Followups 'No' Selected");
			project.clickProjSave();
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
				captureScreen(driver,"validateProjectRank");
				Assert.assertTrue(false);
			}
			
		}
		
		//Validate Rank with letter and number
		@Test
		public void validateProjectRankMix() throws InterruptedException, IOException
		{
			AccessLogin login=new AccessLogin();
			login.loginAccess();
			
			ProjectPriorityPage project=new ProjectPriorityPage(driver);
			
			project.clickProjectsIcon();
			logger.info("Projects Icon clicked");
			project.moveToActivities();
			logger.info("Move to Activities");
			project.clickProjPriority();
			logger.info("Project Priority Clicked");
			project.clickNewProjPriority();
			logger.info("New Project Priority cliecked");
			project.sendProjectId("1500");
			logger.info("Project ID Send");
			project.clickProjectDesc();
			logger.info("Project Description Clicked");
			project.sendProjRank("5abc");
			logger.info("Rank with number AND Letter Selected");
			project.sendProjEffectiveDate("2019-10-10");
			logger.info("Effective Date Selected");
			project.sendProjExpireDate("2019-10-20");
			logger.info("Expire Date Selected");
			project.selectProjFollowups("0");
			logger.info("Followups 'No' Selected");
			project.clickProjSave();
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
				captureScreen(driver,"validateProjectRankMix");
				Assert.assertTrue(false);
			}
			
		}
		//Validate Project Effective Date without selecting 
		@Test
		public void validateProjectEffectiveDate() throws InterruptedException, IOException
		{
			AccessLogin login=new AccessLogin();
			login.loginAccess();
			
			ProjectPriorityPage project=new ProjectPriorityPage(driver);
			
			project.clickProjectsIcon();
			logger.info("Projects Icon clicked");
			project.moveToActivities();
			logger.info("Move to Activities");
			project.clickProjPriority();
			logger.info("Program Priority Clicked");
			project.clickNewProjPriority();
			logger.info("New Program Priority cliecked");
			project.sendProjectId("1300");
			logger.info("Project ID Send");
			project.clickProjectDesc();
			logger.info("Project Description Clicked");
			project.sendProjRank("5");
			logger.info("Rank Send");
			//project.sendProjEffectiveDate("2019-10-10");
			logger.info("Effective Date not Selected");
			project.sendProjExpireDate("2019-10-20");
			logger.info("Expire Date Selected");
			project.selectProjFollowups("0");
			logger.info("Followups 'No' Selected");
			project.clickProjSave();
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
				captureScreen(driver,"validateProjectEffectiveDate");
				Assert.assertTrue(false);
			}
		}
		
		
		//Validate Project Expire Date without selecting 
		@Test
		public void validateProectExpireDate() throws InterruptedException, IOException
		{
			AccessLogin login=new AccessLogin();
			login.loginAccess();
			
			ProjectPriorityPage project=new ProjectPriorityPage(driver);
			
			project.clickProjectsIcon();
			logger.info("Projects Icon clicked");
			project.moveToActivities();
			logger.info("Move to Activities");
			project.clickProjPriority();
			logger.info("Project Priority Clicked");
			project.clickNewProjPriority();
			logger.info("New Project Priority cliecked");
			project.sendProjectId("1500");
			logger.info("Project ID Send");
			project.clickProjectDesc();
			logger.info("Project Description Clicked");
			project.sendProjRank("5");
			logger.info("Rank Send");
			project.sendProjEffectiveDate("2019-10-10");
			logger.info("Effective Date Selected");
			//project.sendProjExpireDate("2019-10-20");
			logger.info("Expire Date not Selected");
			project.selectProjFollowups("0");
			logger.info("Followups 'No' Selected");
			project.clickProjSave();
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
				captureScreen(driver,"validateProectExpireDate");
				Assert.assertTrue(false);
			}
			
		}
		
		//Validate Expire date with selecting past date than effective date
		@Test
		public void validateProjectExpireDatePast() throws InterruptedException, IOException
		{
			AccessLogin login=new AccessLogin();
			login.loginAccess();
			
			ProjectPriorityPage project=new ProjectPriorityPage(driver);
			
			project.clickProjectsIcon();
			logger.info("Projects Icon clicked");
			project.moveToActivities();
			logger.info("Move to Activities");
			project.clickProjPriority();
			logger.info("Program Priority Clicked");
			project.clickNewProjPriority();
			logger.info("New Project Priority cliecked");
			project.sendProjectId("1500");
			logger.info("Project ID Send");
			project.clickProjectDesc();
			logger.info("Project Description Clicked");
			project.sendProjRank("5");
			logger.info("Rank Send");
			project.sendProjEffectiveDate("2019-10-10");
			logger.info("Effective Date Selected");
			project.sendProjExpireDate("2019-10-05");
			logger.info("Expire Date Selected As Past");
			project.selectProjFollowups("0");
			logger.info("Followups 'No' Selected");
			project.clickProjSave();
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
				captureScreen(driver,"validateProjectExpireDatePast");
				Assert.assertTrue(false);
			}
			
		}
		
		//Validate delete button without selecting any project
		@Test
		public void validateProjectDel() throws InterruptedException, IOException
		{
			AccessLogin login=new AccessLogin();
			login.loginAccess();
			
			ProjectPriorityPage project=new ProjectPriorityPage(driver);
			
			project.clickProjectsIcon();
			logger.info("Projects Icon clicked");
			project.moveToActivities();
			logger.info("Move to Activities");
			project.clickProjPriority();
			logger.info("Program Priority Clicked");
			project.clickNewProjPriority();
			logger.info("New Program Priority cliecked");
			project.clickProjDelete();
			logger.info("Delete button clicked without selecting any project");
			
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
				captureScreen(driver,"validateProjectDel");
				Assert.assertTrue(false);
			}
			
		}
		
		//validate delete button with selected record
		@Test
		public void validateProjectRecordDel() throws InterruptedException, IOException
		{
			AccessLogin login=new AccessLogin();
			login.loginAccess();
			
			ProjectPriorityPage project=new ProjectPriorityPage(driver);
			ProjectListPage projectList=new ProjectListPage(driver);
			
			project.clickProjectsIcon();
			logger.info("Projects Icon clicked");
			project.moveToActivities();
			logger.info("Move to Activities");
			project.clickProjPriority();
			logger.info("Project Priority Clicked");
			project.clickNewProjPriority();
			logger.info("New Project Priority cliecked");
			project.sendProjectId("1300");
			logger.info("Project ID Send");
			project.clickProjectDesc();
			logger.info("Project Description Clicked");
			project.sendProjRank("5");
			logger.info("Rank Send");
			project.sendProjEffectiveDate("2019-10-12");
			logger.info("Effective Date Selected");
			project.sendProjExpireDate("2019-10-20");
			logger.info("Expire Date Selected");
			project.selectProjFollowups("0");
			logger.info("Followups 'No' Selected");
			project.clickProjSave();
			logger.info("Save button clicked");
			Thread.sleep(3000);
			
			projectList.sendProjectID("1300");
			logger.info("Program ID Send");
			projectList.clickApply();
			logger.info("Apply button clicked");
			projectList.deleteProjectIDRecord();
			logger.info("deletable ID selected");
			project.clickProjDelete();
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
				captureScreen(driver,"validateProjectRecordDel");
				Assert.assertTrue(false);
			}
		}


}
