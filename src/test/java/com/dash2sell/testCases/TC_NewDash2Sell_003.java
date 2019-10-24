package com.dash2sell.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.dash2sell.pageObjects.AddNewDash2SellPage;
import com.dash2sell.pageObjects.LoginPage;

public class TC_NewDash2Sell_003 extends BaseClass {
	
	
	//Fill all the field in New Dash2Sell page
	@Test
	public void addNewDash2Sell() throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("User name is provided");
		lp.setPassword(password);
		logger.info("Passsword is provided");
		lp.clickSubmit();
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		AddNewDash2SellPage add=new AddNewDash2SellPage(driver);
		add.clickDash2Sell();
		add.clickNewDash2Sell();
		Thread.sleep(3000);
	
		logger.info("providing dash2sell details....");
		
		add.selectPriority("High");
		logger.info("priority selected...");
		
		add.description("Automation test 200");
		logger.info("description provided...");
		
		add.selectChain("Walmart");
		logger.info("chain selected...");
		
		add.clickDashStartDate("2019-08-20");
		logger.info("Start date Selected...");
		
		add.clickDashSEndDate("2019-08-22");
		logger.info("End date Selected...");
					
		add.selectDept("8");
		logger.info("deperment selected...");
			
		add.selectClient("Acme");
		logger.info("client selected...");
		
		add.clickStoreStartDate("2019-08-25");
		logger.info("Store Start date selected...");
		
		add.clickStoreEndDate("2019-08-27");
		logger.info("Store End date selected...");
		
		add.maxstore("1");
		logger.info("Max store provided...");
		
		add.participantList("1,2,3");
		logger.info("Participant list provided...");
		
		add.selectCategory1("D22 - Bedding");
		logger.info("category 1 selected...");
		
		add.selectCategory2("Kraft");
		logger.info("category 2 selected...");
		
		add.selectScog("No");
		logger.info("Scog no Selected...");
		
		add.selectPhoto("Yes");
		logger.info("photo No selected...");
		
		add.clickAttachment(System.getProperty("user.dir")+"/Attachments/sidekick"+".pdf");
		logger.info("Attachment selected...");
		
		add.clickSubmit();
		logger.info("Submitted for Approval...");
		
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		
		logger.info("validation started....");
		Thread.sleep(3000);
		boolean res=driver.getPageSource().contains("Dash2sell has been submitted for approval.");
		
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
			
		}
		else
		{
			logger.info("test case failed....");
			captureScreen(driver,"addNewDash2Sell");
			Assert.assertTrue(false);
		}
			
	}
	
	
	//Fill all the field in New Dash2Sell page without select priority
		@Test
		public void validatePriority() throws InterruptedException, IOException {
			LoginPage lp=new LoginPage(driver);
			lp.setUserName(username);
			logger.info("User name is provided");
			lp.setPassword(password);
			logger.info("Passsword is provided");
			lp.clickSubmit();
			
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			
			AddNewDash2SellPage add=new AddNewDash2SellPage(driver);
			add.clickDash2Sell();
			add.clickNewDash2Sell();
			Thread.sleep(3000);
		
			logger.info("providing dash2sell details....");
			
			//add.selectPriority("High");
			logger.info("priority not selected...");
			
			add.description("Automation test 200");
			logger.info("description provided...");
			
			add.selectChain("Walmart");
			logger.info("chain selected...");
			
			add.clickDashStartDate("2019-08-20");
			logger.info("Start date Selected...");
			
			add.clickDashSEndDate("2019-08-22");
			logger.info("End date Selected...");
						
			add.selectDept("8");
			logger.info("deperment selected...");
				
			add.selectClient("Acme");
			logger.info("client selected...");
			
			add.clickStoreStartDate("2019-08-25");
			logger.info("Store Start date selected...");
			
			add.clickStoreEndDate("2019-08-27");
			logger.info("Store End date selected...");
			
			add.maxstore("1");
			logger.info("Max store provided...");
			
			add.participantList("1,2,3");
			logger.info("Participant list not provided...");
			
			add.selectCategory1("D22 - Bedding");
			logger.info("category 1 selected...");
			
			add.selectCategory2("Kraft");
			logger.info("category 2 selected...");
			
			add.selectScog("No");
			logger.info("Scog no Selected...");
			
			add.selectPhoto("Yes");
			logger.info("photo No selected...");
			
			add.clickAttachment(System.getProperty("user.dir")+"/Attachments/sidekick"+".pdf");
			logger.info("Attachment selected...");
			
			add.clickSubmit();
			logger.info("Submitted for Approval...");
			
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			
			logger.info("validation started....");
			Thread.sleep(3000);
			boolean res=driver.getPageSource().contains("This is a required field.");
			
			
			if(res==true)
			{
				Assert.assertTrue(true);
				logger.info("test case passed....");
				
			}
			else
			{
				logger.info("test case failed....");
				captureScreen(driver,"validatePriority");
				Assert.assertTrue(false);
			}
				
		}
		//Fill all the field in New Dash2Sell page without Description
		@Test
		public void validateDescription() throws InterruptedException, IOException {
			LoginPage lp=new LoginPage(driver);
			lp.setUserName(username);
			logger.info("User name is provided");
			lp.setPassword(password);
			logger.info("Passsword is provided");
			lp.clickSubmit();
			
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			
			AddNewDash2SellPage add=new AddNewDash2SellPage(driver);
			add.clickDash2Sell();
			add.clickNewDash2Sell();
			Thread.sleep(3000);
		
			logger.info("providing dash2sell details....");
			
			add.selectPriority("High");
			logger.info("priority selected...");
			
			//add.description("Automation test 200");
			logger.info("description not provided...");
			
			add.selectChain("Walmart");
			logger.info("chain selected...");
			
			add.clickDashStartDate("2019-08-20");
			logger.info("Start date Selected...");
			
			add.clickDashSEndDate("2019-08-22");
			logger.info("End date Selected...");
						
			add.selectDept("8");
			logger.info("deperment selected...");
				
			add.selectClient("Acme");
			logger.info("client selected...");
			
			add.clickStoreStartDate("2019-08-25");
			logger.info("Store Start date selected...");
			
			add.clickStoreEndDate("2019-08-27");
			logger.info("Store End date selected...");
			
			add.maxstore("1");
			logger.info("Max store provided...");
			
			add.participantList("1,2,3");
			logger.info("Participant list not provided...");
			
			add.selectCategory1("D22 - Bedding");
			logger.info("category 1 selected...");
			
			add.selectCategory2("Kraft");
			logger.info("category 2 selected...");
			
			add.selectScog("No");
			logger.info("Scog no Selected...");
			
			add.selectPhoto("Yes");
			logger.info("photo No selected...");
			
			add.clickAttachment(System.getProperty("user.dir")+"/Attachments/sidekick"+".pdf");
			logger.info("Attachment selected...");
			
			add.clickSubmit();
			logger.info("Submitted for Approval...");
			
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			
			logger.info("validation started....");
			Thread.sleep(3000);
			boolean res=driver.getPageSource().contains("This is a required field.");
			
			
			if(res==true)
			{
				Assert.assertTrue(true);
				logger.info("test case passed....");
				
			}
			else
			{
				logger.info("test case failed....");
				captureScreen(driver,"validateDescription");
				Assert.assertTrue(false);
			}
				
		}
		
		//Fill all the field in New Dash2Sell page without Select Chain
		@Test
		public void validateChain() throws InterruptedException, IOException {
			LoginPage lp=new LoginPage(driver);
			lp.setUserName(username);
			logger.info("User name is provided");
			lp.setPassword(password);
			logger.info("Passsword is provided");
			lp.clickSubmit();
					
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
					
			AddNewDash2SellPage add=new AddNewDash2SellPage(driver);
			add.clickDash2Sell();
			add.clickNewDash2Sell();
			Thread.sleep(3000);
				
			logger.info("providing dash2sell details....");
					
			add.selectPriority("High");
			logger.info("priority selected...");
					
			add.description("Automation test 200");
			logger.info("description provided...");
					
			//add.selectChain("Walmart");
			logger.info("chain not selected...");
					
			add.clickDashStartDate("2019-08-20");
			logger.info("Start date Selected...");
					
			add.clickDashSEndDate("2019-08-22");
			logger.info("End date Selected...");
								
			//add.selectDept("8");
			//logger.info("deperment selected...");
						
			add.selectClient("Acme");
			logger.info("client selected...");
					
			add.clickStoreStartDate("2019-08-25");
			logger.info("Store Start date selected...");
					
			add.clickStoreEndDate("2019-08-27");
			logger.info("Store End date selected...");
					
			add.maxstore("1");
			logger.info("Max store provided...");
					
			add.participantList("1,2,3");
			logger.info("Participant list not provided...");
					
			add.selectCategory1("D22 - Bedding");
			logger.info("category 1 selected...");
					
			add.selectCategory2("Kraft");
			logger.info("category 2 selected...");
					
			add.selectScog("No");
			logger.info("Scog no Selected...");
					
			add.selectPhoto("Yes");
			logger.info("photo No selected...");
					
			add.clickAttachment(System.getProperty("user.dir")+"/Attachments/sidekick"+".pdf");
			logger.info("Attachment selected...");
					
			add.clickSubmit();
			logger.info("Submitted for Approval...");
					
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
					
			logger.info("validation started....");
			Thread.sleep(3000);
			boolean res=driver.getPageSource().contains("The following participants were not found in the alignment file, and have been removed from the list:");
					
					
			if(res==true)
			{
				Assert.assertTrue(true);
				logger.info("test case passed....");
						
			}
			else
			{
				logger.info("test case failed....");
				captureScreen(driver,"validateChain");
				Assert.assertTrue(false);
			}
						
		}

		//Fill all the field in New Dash2Sell page without Select Department
		@Test
		public void validateDepartment() throws InterruptedException, IOException {
			LoginPage lp=new LoginPage(driver);
			lp.setUserName(username);
			logger.info("User name is provided");
			lp.setPassword(password);
			logger.info("Passsword is provided");
			lp.clickSubmit();
			
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			
			AddNewDash2SellPage add=new AddNewDash2SellPage(driver);
			add.clickDash2Sell();
			add.clickNewDash2Sell();
			Thread.sleep(3000);
		
			logger.info("providing dash2sell details....");
			
			add.selectPriority("High");
			logger.info("priority selected...");
			
			add.description("Automation test 200");
			logger.info("description provided...");
			
			add.selectChain("Walmart");
			logger.info("chain selected...");
			
			add.clickDashStartDate("2019-08-20");
			logger.info("Start date Selected...");
			
			add.clickDashSEndDate("2019-08-22");
			logger.info("End date Selected...");
						
			//add.selectDept("8");
			logger.info("deperment not selected...");
				
			add.selectClient("Acme");
			logger.info("client selected...");
			
			add.clickStoreStartDate("2019-08-25");
			logger.info("Store Start date selected...");
			
			add.clickStoreEndDate("2019-08-27");
			logger.info("Store End date selected...");
			
			add.maxstore("1");
			logger.info("Max store provided...");
			
			add.participantList("1,2,3");
			logger.info("Participant list not provided...");
			
			add.selectCategory1("D22 - Bedding");
			logger.info("category 1 selected...");
			
			add.selectCategory2("Kraft");
			logger.info("category 2 selected...");
			
			add.selectScog("No");
			logger.info("Scog no Selected...");
			
			add.selectPhoto("Yes");
			logger.info("photo No selected...");
			
			add.clickAttachment(System.getProperty("user.dir")+"/Attachments/sidekick"+".pdf");
			logger.info("Attachment selected...");
			
			add.clickSubmit();
			logger.info("Submitted for Approval...");
			
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			
			logger.info("validation started....");
			Thread.sleep(3000);
			boolean res=driver.getPageSource().contains("This is a required field.");
			
			
			if(res==true)
			{
				Assert.assertTrue(true);
				logger.info("test case passed....");
				
			}
			else
			{
				logger.info("test case failed....");
				captureScreen(driver,"validateDepartment");
				Assert.assertTrue(false);
			}
				
		}
		
				
				//Fill all the field in New Dash2Sell page without Select Client
				@Test
				public void validateClient() throws InterruptedException, IOException {
					LoginPage lp=new LoginPage(driver);
					lp.setUserName(username);
					logger.info("User name is provided");
					lp.setPassword(password);
					logger.info("Passsword is provided");
					lp.clickSubmit();
					
					driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
					
					AddNewDash2SellPage add=new AddNewDash2SellPage(driver);
					add.clickDash2Sell();
					add.clickNewDash2Sell();
					Thread.sleep(3000);
				
					logger.info("providing dash2sell details....");
					
					add.selectPriority("High");
					logger.info("priority selected...");
					
					add.description("Automation test 200");
					logger.info("description provided...");
					
					add.selectChain("Walmart");
					logger.info("chain selected...");
					
					add.clickDashStartDate("2019-08-20");
					logger.info("Start date Selected...");
					
					add.clickDashSEndDate("2019-08-22");
					logger.info("End date Selected...");
								
					add.selectDept("8");
					logger.info("deperment selected...");
						
					//add.selectClient("Acme");
					logger.info("client not selected...");
					
					add.clickStoreStartDate("2019-08-25");
					logger.info("Store Start date selected...");
					
					add.clickStoreEndDate("2019-08-27");
					logger.info("Store End date selected...");
					
					add.maxstore("1");
					logger.info("Max store provided...");
					
					add.participantList("1,2,3");
					logger.info("Participant list not provided...");
					
					add.selectCategory1("D22 - Bedding");
					logger.info("category 1 selected...");
					
					add.selectCategory2("Kraft");
					logger.info("category 2 selected...");
					
					add.selectScog("No");
					logger.info("Scog no Selected...");
					
					add.selectPhoto("Yes");
					logger.info("photo No selected...");
					
					add.clickAttachment(System.getProperty("user.dir")+"/Attachments/sidekick"+".pdf");
					logger.info("Attachment selected...");
					
					add.clickSubmit();
					logger.info("Submitted for Approval...");
					
					Thread.sleep(3000);
					driver.switchTo().alert().accept();
					
					logger.info("validation started....");
					Thread.sleep(3000);
					boolean res=driver.getPageSource().contains("This is a required field.");
					
					
					if(res==true)
					{
						Assert.assertTrue(true);
						logger.info("test case passed....");
						
					}
					else
					{
						logger.info("test case failed....");
						captureScreen(driver,"validateClient");
						Assert.assertTrue(false);
					}
						
				}
				
				//Fill all the field in New Dash2Sell page with '0' max store more 
				
				@Test
				public void validateMaxstore() throws InterruptedException, IOException {
					LoginPage lp=new LoginPage(driver);
					lp.setUserName(username);
					logger.info("User name is provided");
					lp.setPassword(password);
					logger.info("Passsword is provided");
					lp.clickSubmit();
					
					driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
					
					AddNewDash2SellPage add=new AddNewDash2SellPage(driver);
					add.clickDash2Sell();
					add.clickNewDash2Sell();
					Thread.sleep(3000);
				
					logger.info("providing dash2sell details....");
					
					add.selectPriority("High");
					logger.info("priority selected...");
					
					add.description("Automation test 200");
					logger.info("description provided...");
					
					add.selectChain("Walmart");
					logger.info("chain selected...");
					
					add.clickDashStartDate("2019-08-20");
					logger.info("Start date Selected...");
					
					add.clickDashSEndDate("2019-08-22");
					logger.info("End date Selected...");
								
					add.selectDept("8");
					logger.info("deperment selected...");
						
					add.selectClient("Acme");
					logger.info("client selected...");
					
					add.clickStoreStartDate("2019-08-25");
					logger.info("Store Start date selected...");
					
					add.clickStoreEndDate("2019-08-27");
					logger.info("Store End date selected...");
					
					add.maxstore("0");
					logger.info("Max store not provided...");
					
					add.participantList("1,2,3");
					logger.info("Participant list '1,2,3' provided...");
					
					add.selectCategory1("D22 - Bedding");
					logger.info("category 1 selected...");
					
					add.selectCategory2("Kraft");
					logger.info("category 2 selected...");
					
					add.selectScog("No");
					logger.info("Scog no Selected...");
					
					add.selectPhoto("Yes");
					logger.info("photo No selected...");
					
					add.clickAttachment(System.getProperty("user.dir")+"/Attachments/sidekick"+".pdf");
					logger.info("Attachment selected...");
					
					add.clickSubmit();
					logger.info("Submitted for Approval...");
					
					Thread.sleep(3000);
					driver.switchTo().alert().accept();
					
					logger.info("validation started....");
					Thread.sleep(3000);
					boolean res=driver.getPageSource().contains("Max Store Approvals cannot be 0");
					
					
					if(res==true)
					{
						Assert.assertTrue(true);
						logger.info("test case passed....");
						
					}
					else
					{
						logger.info("test case failed....");
						captureScreen(driver,"validateMaxstore");
						Assert.assertTrue(false);
					}
						
				}
				
		

				//Fill all the field in New Dash2Sell page without Participant list
				
				@Test
				public void validateParticipantlist() throws InterruptedException, IOException {
					LoginPage lp=new LoginPage(driver);
					lp.setUserName(username);
					logger.info("User name is provided");
					lp.setPassword(password);
					logger.info("Passsword is provided");
					lp.clickSubmit();
					
					driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
					
					AddNewDash2SellPage add=new AddNewDash2SellPage(driver);
					add.clickDash2Sell();
					add.clickNewDash2Sell();
					Thread.sleep(3000);
				
					logger.info("providing dash2sell details....");
					
					add.selectPriority("High");
					logger.info("priority selected...");
					
					add.description("Automation test 200");
					logger.info("description provided...");
					
					add.selectChain("Walmart");
					logger.info("chain selected...");
					
					add.clickDashStartDate("2019-08-20");
					logger.info("Start date Selected...");
					
					add.clickDashSEndDate("2019-08-22");
					logger.info("End date Selected...");
								
					add.selectDept("8");
					logger.info("deperment selected...");
						
					add.selectClient("Acme");
					logger.info("client selected...");
					
					add.clickStoreStartDate("2019-08-25");
					logger.info("Store Start date selected...");
					
					add.clickStoreEndDate("2019-08-27");
					logger.info("Store End date selected...");
					
					add.maxstore("1");
					logger.info("Max store provided...");
					
					//add.participantList("1,2,3");
					logger.info("Participant list not provided...");
					
					add.selectCategory1("D22 - Bedding");
					logger.info("category 1 selected...");
					
					add.selectCategory2("Kraft");
					logger.info("category 2 selected...");
					
					add.selectScog("No");
					logger.info("Scog no Selected...");
					
					add.selectPhoto("Yes");
					logger.info("photo No selected...");
					
					add.clickAttachment(System.getProperty("user.dir")+"/Attachments/sidekick"+".pdf");
					logger.info("Attachment selected...");
					
					add.clickSubmit();
					logger.info("Submitted for Approval...");
					
					Thread.sleep(3000);
					driver.switchTo().alert().accept();
					
					logger.info("validation started....");
					Thread.sleep(3000);
					boolean res=driver.getPageSource().contains("At least one participant must be specified.");
					
					
					if(res==true)
					{
						Assert.assertTrue(true);
						logger.info("test case passed....");
						
					}
					else
					{
						logger.info("test case failed....");
						captureScreen(driver,"validateParticipantlist");
						Assert.assertTrue(false);
					}
						
				}
			
				
				
				//Fill all the field in New Dash2Sell page with max store more than Participant list
				
				@Test
				public void validatePartilistMaxstore() throws InterruptedException, IOException {
					LoginPage lp=new LoginPage(driver);
					lp.setUserName(username);
					logger.info("User name is provided");
					lp.setPassword(password);
					logger.info("Passsword is provided");
					lp.clickSubmit();
					
					driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
					
					AddNewDash2SellPage add=new AddNewDash2SellPage(driver);
					add.clickDash2Sell();
					add.clickNewDash2Sell();
					Thread.sleep(3000);
				
					logger.info("providing dash2sell details....");
					
					add.selectPriority("High");
					logger.info("priority selected...");
					
					add.description("Automation test 200");
					logger.info("description provided...");
					
					add.selectChain("Walmart");
					logger.info("chain selected...");
					
					add.clickDashStartDate("2019-08-20");
					logger.info("Start date Selected...");
					
					add.clickDashSEndDate("2019-08-22");
					logger.info("End date Selected...");
								
					add.selectDept("8");
					logger.info("deperment selected...");
						
					add.selectClient("Acme");
					logger.info("client selected...");
					
					add.clickStoreStartDate("2019-08-25");
					logger.info("Store Start date selected...");
					
					add.clickStoreEndDate("2019-08-27");
					logger.info("Store End date selected...");
					
					add.maxstore("4");
					logger.info("Max store '4' provided...");
					
					add.participantList("1,2,3");
					logger.info("Participant list '1,2,3' provided...");
					
					add.selectCategory1("D22 - Bedding");
					logger.info("category 1 selected...");
					
					add.selectCategory2("Kraft");
					logger.info("category 2 selected...");
					
					add.selectScog("No");
					logger.info("Scog no Selected...");
					
					add.selectPhoto("Yes");
					logger.info("photo No selected...");
					
					add.clickAttachment(System.getProperty("user.dir")+"/Attachments/sidekick"+".pdf");
					logger.info("Attachment selected...");
					
					add.clickSubmit();
					logger.info("Submitted for Approval...");
					
					Thread.sleep(3000);
					driver.switchTo().alert().accept();
					
					logger.info("validation started....");
					Thread.sleep(3000);
					boolean res=driver.getPageSource().contains(" Max Store Approvals cannot be greater than Participant Count");
					
					
					if(res==true)
					{
						Assert.assertTrue(true);
						logger.info("test case passed....");
						
					}
					else
					{
						logger.info("test case failed....");
						captureScreen(driver,"validatePartilistMaxstore");
						Assert.assertTrue(false);
					}
						
				}
				
				
		
	
	//Fill all the field in New Dash2Sell page without category1
	
	@Test
	public void validateCategory1() throws InterruptedException, IOException {
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("User name is provided");
		lp.setPassword(password);
		logger.info("Passsword is provided");
		lp.clickSubmit();
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		AddNewDash2SellPage add=new AddNewDash2SellPage(driver);
		add.clickDash2Sell();
		add.clickNewDash2Sell();
		Thread.sleep(3000);
	
		logger.info("providing dash2sell details....");
		
		add.selectPriority("High");
		logger.info("priority selected...");
		
		add.description("Automation test 200");
		logger.info("description provided...");
		
		add.selectChain("Walmart");
		logger.info("chain selected...");
		
		add.clickDashStartDate("2019-08-20");
		logger.info("Start date Selected...");
		
		add.clickDashSEndDate("2019-08-22");
		logger.info("End date Selected...");
					
		add.selectDept("8");
		logger.info("deperment selected...");
			
		add.selectClient("Acme");
		logger.info("client selected...");
		
		add.clickStoreStartDate("2019-08-25");
		logger.info("Store Start date selected...");
		
		add.clickStoreEndDate("2019-08-27");
		logger.info("Store End date selected...");
		
		add.maxstore("1");
		logger.info("Max store provided...");
		
		add.participantList("1,2,3");
		logger.info("Participant list provided...");
		
		//add.selectCategory1("D22 - Bedding");
		logger.info("category 1 not selected...");
		
		add.selectCategory2("Kraft");
		logger.info("category 2 selected...");
		
		add.selectScog("No");
		logger.info("Scog no Selected...");
		
		add.selectPhoto("Yes");
		logger.info("photo No selected...");
		
		add.clickAttachment(System.getProperty("user.dir")+"/Attachments/sidekick"+".pdf");
		logger.info("Attachment selected...");
		
		add.clickSubmit();
		logger.info("Submitted for Approval...");
		
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		
		logger.info("validation started....");
		Thread.sleep(3000);
		boolean res=driver.getPageSource().contains("This is a required field.");
		
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
			
		}
		else
		{
			logger.info("test case failed....");
			captureScreen(driver,"validateCategory1");
			Assert.assertTrue(false);
		}
			
	}
	
	//Fill all the field in New Dash2Sell page without category2
	@Test
	public void validateCategory2() throws InterruptedException, IOException {
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("User name is provided");
		lp.setPassword(password);
		logger.info("Passsword is provided");
		lp.clickSubmit();
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		AddNewDash2SellPage add=new AddNewDash2SellPage(driver);
		add.clickDash2Sell();
		add.clickNewDash2Sell();
		Thread.sleep(3000);
	
		logger.info("providing dash2sell details....");
		
		add.selectPriority("High");
		logger.info("priority selected...");
		
		add.description("Automation test 200");
		logger.info("description provided...");
		
		add.selectChain("Walmart");
		logger.info("chain selected...");
		
		add.clickDashStartDate("2019-08-20");
		logger.info("Start date Selected...");
		
		add.clickDashSEndDate("2019-08-22");
		logger.info("End date Selected...");
					
		add.selectDept("8");
		logger.info("deperment selected...");
			
		add.selectClient("Acme");
		logger.info("client selected...");
		
		add.clickStoreStartDate("2019-08-25");
		logger.info("Store Start date selected...");
		
		add.clickStoreEndDate("2019-08-27");
		logger.info("Store End date selected...");
		
		add.maxstore("1");
		logger.info("Max store provided...");
		
		add.participantList("1,2,3");
		logger.info("Participant list provided...");
		
		add.selectCategory1("D22 - Bedding");
		logger.info("category 1 selected...");
		
		//add.selectCategory2("Kraft");
		logger.info("category 2 not selected...");
		
		add.selectScog("No");
		logger.info("Scog no Selected...");
		
		add.selectPhoto("Yes");
		logger.info("photo No selected...");
		
		add.clickAttachment(System.getProperty("user.dir")+"/Attachments/sidekick"+".pdf");
		logger.info("Attachment selected...");
		
		add.clickSubmit();
		logger.info("Submitted for Approval...");
		
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		
		logger.info("validation started....");
		Thread.sleep(3000);
		boolean res=driver.getPageSource().contains("This is a required field.");
		
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
			
		}
		else
		{
			logger.info("test case failed....");
			captureScreen(driver,"validateCategory2");
			Assert.assertTrue(false);
		}
			
	}
	
	//Fill all the field in New Dash2Sell page without category1 and category2
	
	@Test
	public void validateCategory1and2() throws InterruptedException, IOException {
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("User name is provided");
		lp.setPassword(password);
		logger.info("Passsword is provided");
		lp.clickSubmit();
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		AddNewDash2SellPage add=new AddNewDash2SellPage(driver);
		add.clickDash2Sell();
		add.clickNewDash2Sell();
		Thread.sleep(3000);
	
		logger.info("providing dash2sell details....");
		
		add.selectPriority("High");
		logger.info("priority selected...");
		
		add.description("Automation test 200");
		logger.info("description provided...");
		
		add.selectChain("Walmart");
		logger.info("chain selected...");
		
		add.clickDashStartDate("2019-08-20");
		logger.info("Start date Selected...");
		
		add.clickDashSEndDate("2019-08-22");
		logger.info("End date Selected...");
					
		add.selectDept("8");
		logger.info("deperment selected...");
			
		add.selectClient("Acme");
		logger.info("client selected...");
		
		add.clickStoreStartDate("2019-08-25");
		logger.info("Store Start date selected...");
		
		add.clickStoreEndDate("2019-08-27");
		logger.info("Store End date selected...");
		
		add.maxstore("1");
		logger.info("Max store provided...");
		
		add.participantList("1,2,3");
		logger.info("Participant list provided...");
		
		//add.selectCategory1("D22 - Bedding");
		logger.info("category 1 not selected...");
		
		//add.selectCategory2("Kraft");
		logger.info("category 2 not selected...");
		
		add.selectScog("No");
		logger.info("Scog no Selected...");
		
		add.selectPhoto("Yes");
		logger.info("photo No selected...");
		
		add.clickAttachment(System.getProperty("user.dir")+"/Attachments/sidekick"+".pdf");
		logger.info("Attachment selected...");
		
		add.clickSubmit();
		logger.info("Submitted for Approval...");
		
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		
		logger.info("validation started....");
		Thread.sleep(3000);
		boolean res=driver.getPageSource().contains("This is a required field.");
		
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
			
		}
		else
		{
			logger.info("test case failed....");
			captureScreen(driver,"validateCategory1and2");
			Assert.assertTrue(false);
		}
			
	}
	

	
		//Fill all the field in New Dash2Sell page without attachment field
		@Test
		public void validateAttachment() throws InterruptedException, IOException {
			LoginPage lp=new LoginPage(driver);
			lp.setUserName(username);
			logger.info("User name is provided");
			lp.setPassword(password);
			logger.info("Passsword is provided");
			lp.clickSubmit();
			
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			
			AddNewDash2SellPage add=new AddNewDash2SellPage(driver);
			add.clickDash2Sell();
			add.clickNewDash2Sell();
			Thread.sleep(3000);
		
			logger.info("providing dash2sell details....");
			
			add.selectPriority("High");
			logger.info("priority selected...");
			
			add.description("Automation test 200");
			logger.info("description provided...");
			
			add.selectChain("Walmart");
			logger.info("chain selected...");
			
			add.clickDashStartDate("2019-08-20");
			logger.info("Start date Selected...");
			
			add.clickDashSEndDate("2019-08-22");
			logger.info("End date Selected...");
						
			add.selectDept("8");
			logger.info("deperment selected...");
				
			add.selectClient("Acme");
			logger.info("client selected...");
			
			add.clickStoreStartDate("2019-08-25");
			logger.info("Store Start date selected...");
			
			add.clickStoreEndDate("2019-08-27");
			logger.info("Store End date selected...");
			
			add.maxstore("1");
			logger.info("Max store provided...");
			
			add.participantList("1,2,3");
			logger.info("Participant list provided...");
			
			add.selectCategory1("D22 - Bedding");
			logger.info("category 1 selected...");
			
			add.selectCategory2("Kraft");
			logger.info("category 2 selected...");
			
			add.selectScog("No");
			logger.info("Scog no Selected...");
			
			add.selectPhoto("Yes");
			logger.info("photo No selected...");
			
			//add.clickAttachment(System.getProperty("user.dir")+"123");
			logger.info("Attachment not selected...");
			
			add.clickSubmit();
			logger.info("Submitted for Approval...");
			
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			
			logger.info("validation started....");
			Thread.sleep(3000);
			boolean res=driver.getPageSource().contains("Image attachment is required.");
			
			
			if(res==true)
			{
				Assert.assertTrue(true);
				logger.info("test case passed....");
				
			}
			else
			{
				logger.info("test case failed....");
				captureScreen(driver,"validateAttachment");
				Assert.assertTrue(false);
			}
				
		}
	
		
		
		//Fill all the field in New Dash2Sell page without select store start date after end
				@Test
				public void validateStoreDate() throws InterruptedException, IOException {
					LoginPage lp=new LoginPage(driver);
					lp.setUserName(username);
					logger.info("User name is provided");
					lp.setPassword(password);
					logger.info("Passsword is provided");
					lp.clickSubmit();
					
					driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
					
					AddNewDash2SellPage add=new AddNewDash2SellPage(driver);
					add.clickDash2Sell();
					add.clickNewDash2Sell();
					Thread.sleep(3000);
				
					logger.info("providing dash2sell details....");
					
					add.selectPriority("High");
					logger.info("priority not selected...");
					
					add.description("Automation test 200");
					logger.info("description provided...");
					
					add.selectChain("Walmart");
					logger.info("chain selected...");
					
					add.clickDashStartDate("2019-08-20");
					logger.info("Start date Selected...");
					
					add.clickDashSEndDate("2019-08-21");
					logger.info("End date Selected...");
								
					add.selectDept("8");
					logger.info("deperment selected...");
						
					add.selectClient("Acme");
					logger.info("client selected...");
					
					add.clickStoreStartDate("2019-08-22");
					logger.info("Store Start date selected...");
					
					add.clickStoreEndDate("2019-08-19");
					logger.info("Store End date selected...");
					
					add.maxstore("1");
					logger.info("Max store provided...");
					
					add.participantList("1,2,3");
					logger.info("Participant list not provided...");
					
					add.selectCategory1("D22 - Bedding");
					logger.info("category 1 selected...");
					
					add.selectCategory2("Kraft");
					logger.info("category 2 selected...");
					
					add.selectScog("No");
					logger.info("Scog no Selected...");
					
					add.selectPhoto("Yes");
					logger.info("photo No selected...");
					
					add.clickAttachment(System.getProperty("user.dir")+"/Attachments/sidekick"+".pdf");
					logger.info("Attachment selected...");
					
					add.clickSubmit();
					logger.info("Submitted for Approval...");
					
					Thread.sleep(3000);
					driver.switchTo().alert().accept();
					
					logger.info("validation started....");
					Thread.sleep(3000);
					
				
					if(driver.getPageSource().contains("End date/time should fall")) {
						Assert.assertTrue(true);
						logger.info("End date/time should fall on or after start date");
						logger.info("test case passed....");
					}
					
					else if(driver.getPageSource().contains("In-Store Date date should fall")) {
						Assert.assertTrue(true);
						logger.info(" In-Store Date date should fall after Dash2Sell End date ");
						logger.info("test case passed....");
					}
					
					else if(driver.getPageSource().contains("Take Down date should")) {
						Assert.assertTrue(true);
						logger.info(" Take Down date should  fall on or after  In-Store Date ");
						logger.info("test case passed....");
					}
					
					else
					{
						logger.info("test case failed....");
						captureScreen(driver,"validateStoreDate");
						Assert.assertTrue(false);
					}
					
						
				}
		
	}



