package com.projects.activities.testCases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.projects.activities.pageObjects.ClientListPage;
import com.projects.activities.pageObjects.ClientPriorityPage;




public class TC_ClientPriorityTest_004 extends BaseClass {
	//Create New Client Priority by fill all the required fields
		@Test
		public void ValidatecreateClientPriority() throws InterruptedException, IOException
		{
			AccessLogin login=new AccessLogin();
			login.loginAccess();
			
			ClientPriorityPage client=new ClientPriorityPage(driver);
			
			client.clickProjectsIcon();
			logger.info("Projects Icon clicked");
			client.moveToActivities();
			logger.info("Move to Activities");
			client.clickClientPriority();
			logger.info("Client Priority Clicked");
			client.clickNewClientPriority();
			logger.info("New Client Priority cliecked");
			client.sendClientNumber("100200");
			logger.info("Client Number Send");
			client.clickClientName();
			logger.info("Client Name Clicked");
			client.sendClientRank("5");
			logger.info("Rank Send");
			client.sendClientEffectiveDate("2019-10-10");
			logger.info("Effective Date Selected");
			client.sendClientExpireDate("2019-10-20");
			logger.info("Expire Date Selected");
			client.selectClientFollowups("1");
			logger.info("Followups 'Yes' Selected");
			client.clickClientSave();
			logger.info("Save button clicked");
			
			

			logger.info("validation started....");
			Thread.sleep(2000);
			String title=driver.getTitle();
			System.out.println("Current page title is:"+" "+title);
		
			
			boolean res=driver.getTitle().contentEquals("Client Priorities - Anderson Merchandisers");
			
			if(res==true)
			{
				Assert.assertTrue(true);
				logger.info("test case passed....");
				
			}
			else
			{
				logger.info("test case failed....");
				captureScreen(driver,"ValidatecreateClientPriority");
				Assert.assertTrue(false);
			}
		}
		
		//Validate Client ID without entering any ID
		@Test
		public void validateClientnumber() throws InterruptedException, IOException
		{
			AccessLogin login=new AccessLogin();
			login.loginAccess();
			
			ClientPriorityPage client=new ClientPriorityPage(driver);
			
			client.clickProjectsIcon();
			logger.info("Projects Icon clicked");
			client.moveToActivities();
			logger.info("Move to Activities");
			client.clickClientPriority();
			logger.info("client Priority Clicked");
			client.clickNewClientPriority();
			logger.info("New Client Priority cliecked");
			//client.sendClienNumberd("100200");
			logger.info("client ID did not Send");
			//client.clickClientDesc();
			//logger.info("Client Name Clicked");
			client.sendClientRank("5");
			logger.info("Rank Send");
			client.sendClientEffectiveDate("2019-10-10");
			logger.info("Effective Date Selected");
			client.sendClientExpireDate("2019-10-20");
			logger.info("Expire Date Selected");
			client.selectClientFollowups("1");
			logger.info("Followups 'Yes' Selected");
			client.clickClientSave();
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
				captureScreen(driver,"validateClientnumber");
				Assert.assertTrue(false);
			}
		}
		
		
		//Validate Client Rank without entering any Rank
		@Test
		public void validateClientRank() throws InterruptedException, IOException
		{
			AccessLogin login=new AccessLogin();
			login.loginAccess();
			
			ClientPriorityPage client=new ClientPriorityPage(driver);
			
			client.clickProjectsIcon();
			logger.info("Projects Icon clicked");
			client.moveToActivities();
			logger.info("Move to Activities");
			client.clickClientPriority();
			logger.info("Client Priority Clicked");
			client.clickNewClientPriority();
			logger.info("New Client Priority cliecked");
			client.sendClientNumber("100200");
			logger.info("Client Number Send");
			client.clickClientName();
			logger.info("Client Nameription Clicked");
			//client.sendClientRank("5");
			logger.info("Rank not Selected");
			client.sendClientEffectiveDate("2019-10-10");
			logger.info("Effective Date Selected");
			client.sendClientExpireDate("2019-10-20");
			logger.info("Expire Date Selected");
			client.selectClientFollowups("0");
			logger.info("Followups 'No' Selected");
			client.clickClientSave();
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
				captureScreen(driver,"validateClientRank");
				Assert.assertTrue(false);
			}
			
		}
		
		
		//Validate Rank with letter and number
		@Test
		public void validateClientRankMix() throws InterruptedException, IOException
		{
			AccessLogin login=new AccessLogin();
			login.loginAccess();
			
			ClientPriorityPage client=new ClientPriorityPage(driver);
			
			client.clickProjectsIcon();
			logger.info("Projects Icon clicked");
			client.moveToActivities();
			logger.info("Move to Activities");
			client.clickClientPriority();
			logger.info("Client Priority Clicked");
			client.clickNewClientPriority();
			logger.info("New Client Priority cliecked");
			client.sendClientNumber("100200");
			logger.info("Client ID Send");
			client.clickClientName();
			logger.info("Client Name Clicked");
			client.sendClientRank("5abc");
			logger.info("Rank with number AND Letter Selected");
			client.sendClientEffectiveDate("2019-10-10");
			logger.info("Effective Date Selected");
			client.sendClientExpireDate("2019-10-20");
			logger.info("Expire Date Selected");
			client.selectClientFollowups("0");
			logger.info("Followups 'No' Selected");
			client.clickClientSave();
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
				captureScreen(driver,"validateClientRankMix");
				Assert.assertTrue(false);
			}
			
		}
		
		
		//Validate Client Effective Date without selecting 
		@Test
		public void validateClientEffectiveDate() throws InterruptedException, IOException
		{
			AccessLogin login=new AccessLogin();
			login.loginAccess();
			
			ClientPriorityPage client=new ClientPriorityPage(driver);
			
			client.clickProjectsIcon();
			logger.info("Projects Icon clicked");
			client.moveToActivities();
			logger.info("Move to Activities");
			client.clickClientPriority();
			logger.info("client Priority Clicked");
			client.clickNewClientPriority();
			logger.info("New client Priority cliecked");
			client.sendClientNumber("100200");
			logger.info("client number Send");
			client.clickClientName();
			logger.info("client Name Clicked");
			client.sendClientRank("5");
			logger.info("Rank Send");
			//client.sendClientEffectiveDate("2019-10-10");
			logger.info("Effective Date not Selected");
			client.sendClientExpireDate("2019-10-20");
			logger.info("Expire Date Selected");
			client.selectClientFollowups("0");
			logger.info("Followups 'No' Selected");
			client.clickClientSave();
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
				captureScreen(driver,"validateClientEffectiveDate");
				Assert.assertTrue(false);
			}
		}
		
		
		//Validate Client Expire Date without selecting 
		@Test
		public void validateClientExpireDate() throws InterruptedException, IOException
		{
			AccessLogin login=new AccessLogin();
			login.loginAccess();
			
			ClientPriorityPage client=new ClientPriorityPage(driver);
			
			client.clickProjectsIcon();
			logger.info("Projects Icon clicked");
			client.moveToActivities();
			logger.info("Move to Activities");
			client.clickClientPriority();
			logger.info("Client Priority Clicked");
			client.clickNewClientPriority();
			logger.info("New client Priority cliecked");
			client.sendClientNumber("100200");
			logger.info("client Number Send");
			client.clickClientName();
			logger.info("client Name Clicked");
			client.sendClientRank("5");
			logger.info("Rank Send");
			client.sendClientEffectiveDate("2019-10-10");
			logger.info("Effective Date Selected");
			//client.sendClientExpireDate("2019-10-20");
			logger.info("Expire Date not Selected");
			client.selectClientFollowups("0");
			logger.info("Followups 'No' Selected");
			client.clickClientSave();
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
				captureScreen(driver,"validateClientExpireDate");
				Assert.assertTrue(false);
			}
			
		}
		
		//Validate Expire date with selecting past date than effective date
		@Test
		public void validateClientExpireDatePast() throws InterruptedException, IOException
		{
			AccessLogin login=new AccessLogin();
			login.loginAccess();
			
			ClientPriorityPage client=new ClientPriorityPage(driver);
			
			client.clickProjectsIcon();
			logger.info("Projects Icon clicked");
			client.moveToActivities();
			logger.info("Move to Activities");
			client.clickClientPriority();
			logger.info("client Priority Clicked");
			client.clickNewClientPriority();
			logger.info("New client Priority cliecked");
			client.sendClientNumber("100200");
			logger.info("client Number Send");
			client.clickClientName();
			logger.info("client Name Clicked");
			client.sendClientRank("5");
			logger.info("Rank Send");
			client.sendClientEffectiveDate("2019-10-10");
			logger.info("Effective Date Selected");
			client.sendClientExpireDate("2019-10-05");
			logger.info("Expire Date Selected As Past");
			client.selectClientFollowups("0");
			logger.info("Followups 'No' Selected");
			client.clickClientSave();
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
				captureScreen(driver,"validateClientExpireDatePast");
				Assert.assertTrue(false);
			}
			
		}
		
		//Validate delete button without selecting any program
		@Test
		public void validateClientDel() throws InterruptedException, IOException
		{
			AccessLogin login=new AccessLogin();
			login.loginAccess();
			
			ClientPriorityPage client=new ClientPriorityPage(driver);
			
			client.clickProjectsIcon();
			logger.info("Projects Icon clicked");
			client.moveToActivities();
			logger.info("Move to Activities");
			client.clickClientPriority();
			logger.info("client Priority Clicked");
			client.clickNewClientPriority();
			logger.info("New client Priority cliecked");
			client.clickClientDelete();
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
				captureScreen(driver,"validateClientDel");
				Assert.assertTrue(false);
			}
			
		}
		
		//validate delete button with selected record
		@Test
		public void validateClientRecordDel() throws InterruptedException, IOException
		{
			AccessLogin login=new AccessLogin();
			login.loginAccess();
			
			ClientPriorityPage client=new ClientPriorityPage(driver);
			ClientListPage clientList=new ClientListPage(driver);
			
			client.clickProjectsIcon();
			logger.info("Projects Icon clicked");
			client.moveToActivities();
			logger.info("Move to Activities");
			client.clickClientPriority();
			logger.info("Client Priority Clicked");
			client.clickNewClientPriority();
			logger.info("New Client Priority cliecked");
			client.sendClientNumber("100200");
			logger.info("Client Number Send");
			client.clickClientName();
			logger.info("Client Name Clicked");
			client.sendClientRank("5");
			logger.info("Rank Send");
			client.sendClientEffectiveDate("2019-10-12");
			logger.info("Effective Date Selected");
			client.sendClientExpireDate("2019-10-20");
			logger.info("Expire Date Selected");
			client.selectClientFollowups("0");
			logger.info("Followups 'No' Selected");
			client.clickClientSave();
			logger.info("Save button clicked");
			Thread.sleep(3000);
			
			clientList.sendClientNumber("100200");
			logger.info("Program ID Send");
			clientList.clickApply();
			logger.info("Apply button clicked");
			clientList.deleteClientNumberRecord();
			logger.info("deletable ID selected");
			client.clickClientDelete();
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
				captureScreen(driver,"validateClientRecordDel");
				Assert.assertTrue(false);
			}
		}

		
}
