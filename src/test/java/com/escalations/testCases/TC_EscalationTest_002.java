package com.escalations.testCases;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.dash2sell.pageObjects.LoginPage;
import com.dash2sell.testCases.BaseClass;
import com.escalations.pageObjects.EscalataionListPage;
import com.escalations.pageObjects.EscalationPage;



public class TC_EscalationTest_002 extends BaseClass {
	
	
	@Test
	public void createNewEscalationReview() throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName("shoresj");
		logger.info("User name is provided");
		lp.setPassword("Anderson2!");
		logger.info("Passsword is provided");
		lp.clickSubmit();
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		EscalationPage escPage=new EscalationPage(driver);
		escPage.clickEscalationIcon();
		logger.info("Escalation Icon Clicked");
		escPage.clickNewButton();
		logger.info("New button clicked");
		escPage.sendElementID("112035");
		logger.info("Element ID Sent");
		Thread.sleep(3000);
		escPage.clickElementId();
		logger.info("Element Description clicked");
		Thread.sleep(3000);
		escPage.clickClient();
		escPage.selectClient(1);
		logger.info("Client ID selected");
		escPage.sendSummery("Summary");
		logger.info("Summary Provided");
		escPage.sendDueDate(escPage.setFutureDate());
		logger.info("Due Date Provided");
		escPage.pressEscape();
		escPage.sendStoreList("2297");
		logger.info("Store List selected");
		escPage.sendDescIssue("Description");
		logger.info("Description of Issue Provided");
		escPage.selectResult("Yes");
		logger.info("Result of Anderson Selected");	
		escPage.sendResulation("Resulation ");
		logger.info("Resulation Steps Provided");
		escPage.selectPlanDuration("60");
		logger.info("Plan Duration Selected");
		escPage.clickReviewButton();
		logger.info("Review Button Clicked");
		escPage.acceptAlert();
		logger.info("Alert accepted");
		
		logger.info("validation started....");
		Thread.sleep(2000);
		
		boolean res=driver.getPageSource().contains("Escalation submitted for review.");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
			
		}
		else
		{
			logger.info("test case failed....");
			captureScreen(driver,"createNewEscalationReview");
			Assert.assertTrue(false);
		}
	}
	
	
	
	@Test
	public void createNewEscalationNoAction() throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName("shoresj");
		logger.info("User name is provided");
		lp.setPassword("Anderson2!");
		logger.info("Passsword is provided");
		lp.clickSubmit();
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		EscalationPage escPage=new EscalationPage(driver);
		escPage.clickEscalationIcon();
		logger.info("Escalation Icon Clicked");
		escPage.clickNewButton();
		logger.info("New button clicked");
		escPage.sendElementID("112035");
		logger.info("Element ID Sent");
		Thread.sleep(3000);
		escPage.clickElementId();
		logger.info("Element Description clicked");
		Thread.sleep(3000);
		escPage.clickClient();
		escPage.selectClient(1);
		logger.info("Client ID selected");
		escPage.sendSummery("Summery");
		logger.info("Summery Provided");
		escPage.sendDueDate(escPage.setFutureDate());
		logger.info("Due Date Provided");
		escPage.pressEscape();
		escPage.sendStoreList("2297");
		logger.info("Store List selected");
		escPage.sendDescIssue("Description of Issue");
		logger.info("Description of Issue Provided");
		escPage.selectResult("Yes");
		logger.info("Result of Anderson Selected");
		escPage.sendResulation("Resulation ");
		logger.info("Resulation Steps Provided");		
		escPage.selectPlanDuration("60");
		logger.info("Plan Duration Selected");
		escPage.clickNoActionButton();
		logger.info("Np Action Button Clicked");
		
		escPage.acceptAlert();
		logger.info("Alert accepted");
		
		logger.info("validation started....");
		Thread.sleep(2000);
		
		boolean res=driver.getPageSource().contains("Escalation cancelled.");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
			
		}
		else
		{
			logger.info("test case failed....");
			captureScreen(driver,"createNewEscalationNoAction");
			Assert.assertTrue(false);
		}
	}
	
	
	@Test
	public void createNewEscalationSaveClose() throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName("shoresj");
		logger.info("User name is provided");
		lp.setPassword("Anderson2!");
		logger.info("Passsword is provided");
		lp.clickSubmit();
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		EscalationPage escPage=new EscalationPage(driver);
		EscalataionListPage escList=new EscalataionListPage(driver);
		escPage.clickEscalationIcon();
		logger.info("Escalation Icon Clicked");
		escPage.clickNewButton();
		logger.info("New button clicked");
		escPage.sendElementID("112035");
		logger.info("Element ID Sent");
		Thread.sleep(3000);
		escPage.clickElementId();
		logger.info("Element Description clicked");
		Thread.sleep(3000);
		escPage.clickClient();
		escPage.selectClient(1);
		logger.info("Client ID selected");
		escPage.sendSummery("Summery");
		logger.info("Summery Provided");
		escPage.sendDueDate(escPage.setFutureDate());
		logger.info("Due Date Provided");
		escPage.pressEscape();
		escPage.sendStoreList("2297");
		logger.info("Store List selected");
		escPage.sendDescIssue("Description of Issue");
		logger.info("Description of Issue Provided");
		escPage.selectResult("Yes");
		logger.info("Result of Anderson Selected");
		escPage.sendResulation("Resulation ");
		logger.info("Resulation Steps Provided");	
		escPage.selectPlanDuration("60");
		logger.info("Plan Duration Selected");
		escPage.clickSaveCloseButton();
		logger.info("Save Button Clicked");
		escList.selectStatus("New");
		logger.info("Status New selected");
		escList.sortEscalationId();
		logger.info("Escalation ID ordered");
		escList.clickFirstElement();
		String url=driver.getCurrentUrl();
		System.out.println("Current URL: "+url);
		
		URL nurl = new URL(url);
		String path = nurl.getPath();
		String urlId = path.substring(path.lastIndexOf('/') + 1);
		System.out.println("ID from current url: "+urlId);
		//int id = Integer.parseInt(urlId); //If need to convert String to int
		
		
		//Another way to get last string
		//String urlId =url.substring(url.lastIndexOf(".")+36,url.length());
		//System.out.println("ID from current url: "+urlId);
		
		escPage.clickBackButton();
		logger.info("Back button clicked");
		escList.clickClear();
		Thread.sleep(3000);
		escList.sortEscalationId();
		String id=escList.getId();
		
		System.out.println("ID from list Page: "+id);
		
		
		logger.info("validation started....");
		
		if(urlId.contentEquals(id)) {
			Assert.assertTrue(true);
			System.out.println("URL ID match with saved ID......Test Case Passed");
		}else {
			System.out.println("URL ID not match with saved ID....Test Case Failed");
			Assert.assertTrue(false);
			captureScreen(driver,"createNewEscalationSaveClose");
		}
		
	}
	
	//Negetive Test are starts from here
	

	@Test
	public void validateElementIdField() throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName("shoresj");
		logger.info("User name is provided");
		lp.setPassword("Anderson2!");
		logger.info("Passsword is provided");
		lp.clickSubmit();
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		EscalationPage escPage=new EscalationPage(driver);
		escPage.clickEscalationIcon();
		logger.info("Escalation Icon Clicked");
		escPage.clickNewButton();
		logger.info("New button clicked");	
		escPage.clickClient();
		escPage.selectClient(1);
		logger.info("Client ID selected");
		escPage.sendSummery("Summery");
		logger.info("Summery Provided");
		escPage.sendDueDate(escPage.setFutureDate());
		logger.info("Due Date Provided");
		escPage.pressEscape();
		escPage.sendStoreList("2297");
		logger.info("Store List selected");
		escPage.sendDescIssue("Description of Issue");
		logger.info("Description of Issue Provided");
		escPage.selectResult("Yes");
		logger.info("Result of Anderson Selected");	
		escPage.sendResulation("Resulation ");
		logger.info("Resulation Steps Provided");
		escPage.selectPlanDuration("60");
		logger.info("Plan Duration Selected");
		escPage.clickReviewButton();
		logger.info("Review Button Clicked");
		escPage.acceptAlert();
		logger.info("Alert accepted");
		
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
			captureScreen(driver,"validateElementIdField");
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void validateClientDropDown() throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName("shoresj");
		logger.info("User name is provided");
		lp.setPassword("Anderson2!");
		logger.info("Passsword is provided");
		lp.clickSubmit();
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		EscalationPage escPage=new EscalationPage(driver);
		escPage.clickEscalationIcon();
		logger.info("Escalation Icon Clicked");
		escPage.clickNewButton();
		logger.info("New button clicked");
		escPage.sendElementID("112035");
		logger.info("Element ID Sent");
		Thread.sleep(3000);
		escPage.clickElementId();
		logger.info("Element Description clicked");
		Thread.sleep(3000);
		logger.info("Client ID selected");
		escPage.sendSummery("Summery");
		logger.info("Summery Provided");
		escPage.sendDueDate(escPage.setFutureDate());
		logger.info("Due Date Provided");
		escPage.pressEscape();
		escPage.sendStoreList("2297");
		logger.info("Store List selected");
		escPage.sendDescIssue("Description of Issue");
		logger.info("Description of Issue Provided");
		escPage.selectResult("Yes");
		logger.info("Result of Anderson Selected");
		escPage.sendResulation("Resulation ");
		logger.info("Resulation Steps Provided");
		escPage.selectPlanDuration("60");
		logger.info("Plan Duration Selected");
		escPage.clickReviewButton();
		logger.info("Review Button Clicked");
		escPage.acceptAlert();
		logger.info("Alert accepted");
		
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
			captureScreen(driver,"validateClientDropDown");
			Assert.assertTrue(false);
		}
	}
	
	
	@Test
	public void validateSummeryField() throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName("shoresj");
		logger.info("User name is provided");
		lp.setPassword("Anderson2!");
		logger.info("Passsword is provided");
		lp.clickSubmit();
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		EscalationPage escPage=new EscalationPage(driver);
		escPage.clickEscalationIcon();
		logger.info("Escalation Icon Clicked");
		escPage.clickNewButton();
		logger.info("New button clicked");
		escPage.sendElementID("112035");
		logger.info("Element ID Sent");
		Thread.sleep(3000);
		escPage.clickElementId();
		logger.info("Element Description clicked");
		Thread.sleep(3000);
		escPage.clickClient();
		escPage.selectClient(1);
		logger.info("Client ID selected");
		escPage.sendDueDate("2019-12-31");
		logger.info("Due Date Provided");
		escPage.pressEscape();
		escPage.sendStoreList("2297");
		logger.info("Store List selected");
		escPage.sendDescIssue("Description of Issue");
		logger.info("Description of Issue Provided");
		escPage.selectResult("Yes");
		logger.info("Result of Anderson Selected");
		escPage.sendResulation("Resulation ");
		logger.info("Resulation Steps Provided");
		escPage.selectPlanDuration("60");
		logger.info("Plan Duration Selected");
		escPage.clickReviewButton();
		logger.info("Review Button Clicked");
		escPage.acceptAlert();
		logger.info("Alert accepted");
		
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
			captureScreen(driver,"validateSummeryField");
			Assert.assertTrue(false);
		}
	}
	
	
	
	@Test
	public void validateDueDateField() throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName("shoresj");
		logger.info("User name is provided");
		lp.setPassword("Anderson2!");
		logger.info("Passsword is provided");
		lp.clickSubmit();
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		EscalationPage escPage=new EscalationPage(driver);
		escPage.clickEscalationIcon();
		logger.info("Escalation Icon Clicked");
		escPage.clickNewButton();
		logger.info("New button clicked");
		escPage.sendElementID("112035");
		logger.info("Element ID Sent");
		Thread.sleep(3000);
		escPage.clickElementId();
		logger.info("Element Description clicked");
		Thread.sleep(3000);
		escPage.clickClient();
		escPage.selectClient(1);
		logger.info("Client ID selected");
		escPage.sendSummery("Summery");
		logger.info("Summery Provided");
		escPage.sendStoreList("2297");
		logger.info("Store List selected");
		escPage.sendDescIssue("Description of Issue");
		logger.info("Description of Issue Provided");
		escPage.selectResult("Yes");
		logger.info("Result of Anderson Selected");
		escPage.sendResulation("Resulation ");
		logger.info("Resulation Steps Provided");
		escPage.selectPlanDuration("60");
		logger.info("Plan Duration Selected");
		escPage.clickReviewButton();
		logger.info("Review Button Clicked");
		escPage.acceptAlert();
		logger.info("Alert accepted");
		
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
			captureScreen(driver,"validateDueDateField");
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void validateDuePastDate() throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName("shoresj");
		logger.info("User name is provided");
		lp.setPassword("Anderson2!");
		logger.info("Passsword is provided");
		lp.clickSubmit();
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		EscalationPage escPage=new EscalationPage(driver);
		escPage.clickEscalationIcon();
		logger.info("Escalation Icon Clicked");
		escPage.clickNewButton();
		logger.info("New button clicked");
		escPage.sendElementID("112035");
		logger.info("Element ID Sent");
		Thread.sleep(3000);
		escPage.clickElementId();
		logger.info("Element Description clicked");
		Thread.sleep(3000);
		escPage.clickClient();
		escPage.selectClient(1);
		logger.info("Client ID selected");
		escPage.sendSummery("Summery");
		logger.info("Summery Provided");
		escPage.sendDueDate(escPage.setPastDate());
		escPage.pressEscape();
		escPage.sendStoreList("2297");
		logger.info("Store List selected");
		escPage.sendDescIssue("Description of Issue");
		logger.info("Description of Issue Provided");
		escPage.selectResult("Yes");
		logger.info("Result of Anderson Selected");
		escPage.sendResulation("Resulation ");
		logger.info("Resulation Steps Provided");
		escPage.selectPlanDuration("60");
		logger.info("Plan Duration Selected");
		escPage.clickReviewButton();
		logger.info("Review Button Clicked");
		escPage.acceptAlert();
		logger.info("Alert accepted");
		
		logger.info("validation started....");
		Thread.sleep(2000);
		
		boolean res=driver.getPageSource().contains("Due date cannot be in the past");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
			
		}
		else
		{
			logger.info("test case failed....");
			captureScreen(driver,"validateDuePastDate");
			Assert.assertTrue(false);
		}
	}
	
	
	@Test
	public void validateStoresAffected() throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName("shoresj");
		logger.info("User name is provided");
		lp.setPassword("Anderson2!");
		logger.info("Passsword is provided");
		lp.clickSubmit();
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		EscalationPage escPage=new EscalationPage(driver);
		escPage.clickEscalationIcon();
		logger.info("Escalation Icon Clicked");
		escPage.clickNewButton();
		logger.info("New button clicked");
		escPage.sendElementID("112035");
		logger.info("Element ID Sent");
		Thread.sleep(3000);
		escPage.clickElementId();
		logger.info("Element Description clicked");
		Thread.sleep(3000);
		escPage.clickClient();
		escPage.selectClient(1);
		logger.info("Client ID selected");
		escPage.sendSummery("Summery");
		logger.info("Summery Provided");
		escPage.sendDueDate(escPage.setFutureDate());
		logger.info("Due Date Provided");
		escPage.pressEscape();
		escPage.sendDescIssue("Description of Issue");
		logger.info("Description of Issue Provided");
		escPage.selectResult("Yes");
		logger.info("Result of Anderson Selected");	
		escPage.sendResulation("Resulation ");
		logger.info("Resulation Steps Provided");
		escPage.selectPlanDuration("60");
		logger.info("Plan Duration Selected");
		escPage.clickReviewButton();
		logger.info("Review Button Clicked");
		escPage.acceptAlert();
		logger.info("Alert accepted");
		
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
			captureScreen(driver,"validateStoresAffected");
			Assert.assertTrue(false);
		}
	}
	
	
	@Test
	public void validateStoresAffectedRandom() throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName("shoresj");
		logger.info("User name is provided");
		lp.setPassword("Anderson2!");
		logger.info("Passsword is provided");
		lp.clickSubmit();
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		EscalationPage escPage=new EscalationPage(driver);
		escPage.clickEscalationIcon();
		logger.info("Escalation Icon Clicked");
		escPage.clickNewButton();
		logger.info("New button clicked");
		escPage.sendElementID("112035");
		logger.info("Element ID Sent");
		Thread.sleep(3000);
		escPage.clickElementId();
		logger.info("Element Description clicked");
		Thread.sleep(3000);
		escPage.clickClient();
		escPage.selectClient(1);
		logger.info("Client ID selected");
		escPage.sendSummery("Summery");
		logger.info("Summery Provided");
		escPage.sendDueDate(escPage.setFutureDate());
		logger.info("Due Date Provided");
		escPage.pressEscape();
		escPage.sendStoreList("2200");
		logger.info("Store List selected");
		escPage.sendDescIssue("Description of Issue");
		logger.info("Description of Issue Provided");
		escPage.selectResult("Yes");
		logger.info("Result of Anderson Selected");	
		escPage.sendResulation("Resulation ");
		logger.info("Resulation Steps Provided");
		escPage.selectPlanDuration("60");
		logger.info("Plan Duration Selected");
		escPage.clickReviewButton();
		logger.info("Review Button Clicked");
		escPage.acceptAlert();
		logger.info("Alert accepted");
		
		logger.info("validation started....");
		Thread.sleep(2000);
		
		boolean res=driver.getPageSource().contains("The following store(s) were not present on the original element and have been removed:");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
			
		}
		else
		{
			logger.info("test case failed....");
			captureScreen(driver,"validateStoresAffected");
			Assert.assertTrue(false);
		}
	}
	
	
	@Test
	public void validateDescriptionField() throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName("shoresj");
		logger.info("User name is provided");
		lp.setPassword("Anderson2!");
		logger.info("Passsword is provided");
		lp.clickSubmit();
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		EscalationPage escPage=new EscalationPage(driver);
		escPage.clickEscalationIcon();
		logger.info("Escalation Icon Clicked");
		escPage.clickNewButton();
		logger.info("New button clicked");
		escPage.sendElementID("112035");
		logger.info("Element ID Sent");
		Thread.sleep(3000);
		escPage.clickElementId();
		logger.info("Element Description clicked");
		Thread.sleep(3000);
		escPage.clickClient();
		escPage.selectClient(1);
		logger.info("Client ID selected");
		escPage.sendSummery("Summery");
		logger.info("Summery Provided");
		escPage.sendDueDate(escPage.setFutureDate());
		logger.info("Due Date Provided");
		escPage.pressEscape();
		escPage.sendStoreList("2297");
		logger.info("Store List selected");
		//escPage.sendDescIssue("Description of Issue");
		//logger.info("Description of Issue Provided");
		escPage.selectResult("Yes");
		logger.info("Result of Anderson Selected");
		escPage.sendResulation("Resulation ");
		logger.info("Resulation Steps Provided");
		escPage.selectPlanDuration("60");
		logger.info("Plan Duration Selected");
		escPage.clickReviewButton();
		logger.info("Review Button Clicked");
		escPage.acceptAlert();
		logger.info("Alert accepted");
		
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
			captureScreen(driver,"validateDescriptionField");
			Assert.assertTrue(false);
		}
	}
	
	//this need to to fixed
	@Test
	public void validateIssueResultDropDown() throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName("shoresj");
		logger.info("User name is provided");
		lp.setPassword("Anderson2!");
		logger.info("Passsword is provided");
		lp.clickSubmit();
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		EscalationPage escPage=new EscalationPage(driver);
		escPage.clickEscalationIcon();
		logger.info("Escalation Icon Clicked");
		escPage.clickNewButton();
		logger.info("New button clicked");
		escPage.sendElementID("112035");
		logger.info("Element ID Sent");
		Thread.sleep(3000);
		escPage.clickElementId();
		logger.info("Element Description clicked");
		Thread.sleep(3000);
		escPage.clickClient();
		escPage.selectClient(1);
		logger.info("Client ID selected");
		escPage.sendSummery("Summery");
		logger.info("Summery Provided");
		escPage.sendDueDate(escPage.setFutureDate());
		logger.info("Due Date Provided");
		escPage.pressEscape();
		escPage.sendStoreList("2297");
		logger.info("Store List selected");
		escPage.sendDescIssue("Description of Issue");
		logger.info("Description of Issue Provided");
		escPage.sendResulation("Resulation ");
		logger.info("Resulation Steps Provided");
		escPage.selectPlanDuration("60");
		logger.info("Plan Duration Selected");
		escPage.clickReviewButton();
		logger.info("Review Button Clicked");
		escPage.acceptAlert();
		logger.info("Alert accepted");
		
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
			captureScreen(driver,"validateIssueResultDropDown");
			Assert.assertTrue(false);
		}
	}
	
	
	
	@Test
	public void validateResulationStepsField() throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName("shoresj");
		logger.info("User name is provided");
		lp.setPassword("Anderson2!");
		logger.info("Passsword is provided");
		lp.clickSubmit();
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		EscalationPage escPage=new EscalationPage(driver);
		escPage.clickEscalationIcon();
		logger.info("Escalation Icon Clicked");
		escPage.clickNewButton();
		logger.info("New button clicked");
		escPage.sendElementID("112035");
		logger.info("Element ID Sent");
		Thread.sleep(3000);
		escPage.clickElementId();
		logger.info("Element Description clicked");
		Thread.sleep(3000);
		escPage.clickClient();
		escPage.selectClient(1);
		logger.info("Client ID selected");
		escPage.sendSummery("Summery");
		logger.info("Summery Provided");
		escPage.sendDueDate(escPage.setFutureDate());
		logger.info("Due Date Provided");
		escPage.pressEscape();
		escPage.sendStoreList("2297");
		logger.info("Store List selected");
		escPage.sendDescIssue("Description of Issue");
		logger.info("Description of Issue Provided");
		escPage.selectResult("Select One...");
		escPage.selectResult("Yes");
		logger.info("Result of Anderson Selected");
		escPage.selectPlanDuration("60");
		logger.info("Plan Duration Selected");
		escPage.clickReviewButton();
		logger.info("Review Button Clicked");
		escPage.acceptAlert();
		logger.info("Alert accepted");
		
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
			captureScreen(driver,"validateResulationStepsField");
			Assert.assertTrue(false);
		}
	}
	
	
	@Test
	public void validatePlanDurationDropDown() throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName("shoresj");
		logger.info("User name is provided");
		lp.setPassword("Anderson2!");
		logger.info("Passsword is provided");
		lp.clickSubmit();
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		EscalationPage escPage=new EscalationPage(driver);
		escPage.clickEscalationIcon();
		logger.info("Escalation Icon Clicked");
		escPage.clickNewButton();
		logger.info("New button clicked");
		escPage.sendElementID("112035");
		logger.info("Element ID Sent");
		Thread.sleep(3000);
		escPage.clickElementId();
		logger.info("Element Description clicked");
		Thread.sleep(3000);
		escPage.clickClient();
		escPage.selectClient(1);
		logger.info("Client ID selected");
		escPage.sendSummery("Summery");
		logger.info("Summery Provided");
		escPage.sendDueDate(escPage.setFutureDate());
		logger.info("Due Date Provided");
		escPage.pressEscape();
		escPage.sendStoreList("2297");
		logger.info("Store List selected");
		escPage.sendDescIssue("Description of Issue");
		logger.info("Description of Issue Provided");
		escPage.selectResult("Select One...");
		escPage.sendResulation("Resulation ");
		logger.info("Resulation Steps Provided");
		escPage.selectResult("Yes");
		logger.info("Result of Anderson Selected");
		escPage.clickReviewButton();
		logger.info("Review Button Clicked");
		escPage.acceptAlert();
		logger.info("Alert accepted");
		
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
			captureScreen(driver,"validatePlanDurationDropDown");
			Assert.assertTrue(false);
		}
	}
	
	

}
