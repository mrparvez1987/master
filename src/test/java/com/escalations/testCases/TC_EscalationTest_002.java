package com.escalations.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;
import com.dash2sell.pageObjects.LoginPage;
import com.dash2sell.testCases.BaseClass;
import com.escalations.pageObjects.EscalationPage;


public class TC_EscalationTest_002 extends BaseClass {
	
	
	@Test
	public void createProgramPriority() throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("User name is provided");
		lp.setPassword(password);
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
		escPage.clickElementId();
		logger.info("Element Description clicked");
		escPage.selectClient(2);
		escPage.sendSummery("Test");
		escPage.sendDueDate("2019-12-31");
		escPage.sendStoreList("4705");
		logger.info("Store List selected");
		escPage.sendDescIssue("Description od Issue");
		logger.info("Description of Issue Provided");
		escPage.sendResulation("1.Resulation ");
		logger.info("Resulation Steps Provided");
		escPage.selectPlanDuration("60");
		logger.info("Plan Duration Selected");
		escPage.clickReviewButton();
		logger.info("Review Button Clicked");
		
		
	}

}
