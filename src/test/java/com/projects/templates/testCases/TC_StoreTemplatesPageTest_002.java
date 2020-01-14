package com.projects.templates.testCases;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.dash2sell.pageObjects.LoginPage;
import com.dashManagement.utilities.BaseClass;
import com.dashManagement.utilities.TestLogger;
import com.dashManagement.utilities.XLUtils;
import com.projects.templates.pageObject.StoreTemplatesPage;

public class TC_StoreTemplatesPageTest_002 extends BaseClass{
	
	@Test(dataProvider="TemplateNumericFieldPageData")
	public void validateStoreElementNumericField(String user,String pass,String fieldType,String optional,String identifier,String minvalue,String maxvalue,String loosattch,String instruction) throws Exception {
	
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(user);
		TestLogger.log("username: "+user);
		lp.setPassword(pass);
		TestLogger.log("password: "+pass);
		lp.clickSubmit();
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		StoreTemplatesPage storeTemp=new StoreTemplatesPage(driver);
		
		storeTemp.clickProjectsIcon();
		TestLogger.log("Project Icon Clicked");
		storeTemp.moveToActivities();
		storeTemp.clickTemplatesMenu();
		TestLogger.log("Templates Menu Clicked");
		storeTemp.clickNewTemplateButton();
		TestLogger.log("New Template Button Clicked");
		storeTemp.clickStoreTemplate();
		TestLogger.log("Select Store template");
		storeTemp.clickElementTemplate();
		TestLogger.log("Select Element Template");
		storeTemp.sendDescription("This is Description of element template");
		storeTemp.clickMultiExecutionBox();
		storeTemp.clickNewFieldButton();
		storeTemp.selectFieldType(fieldType);
		storeTemp.sendCaption("This is Caption for Numeric field");
		storeTemp.selectOptional(optional);
		storeTemp.selectIdentifierField(identifier);
		storeTemp.sendMinValue(minvalue);
		storeTemp.sendMaxValue(maxvalue);	
		storeTemp.sendLooseAttachment(loosattch);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		storeTemp.getLoosAttachmentName();
		TestLogger.log("Loose Attachment Name Provided");
		storeTemp.clickInstruction();
		storeTemp.sendInstruction(instruction);
		storeTemp.clickApplyChangesButton();	 
		storeTemp.clickSubmitForReveiw();
		TestLogger.log("Submit for Reveiw Button Clicked");
		driver.switchTo().alert().accept();	
		TestLogger.log("Alert accepted");
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		boolean b=driver.getPageSource().contains("Template submitted for review.");
		//boolean b1=driver.getPageSource().contentEquals("Template submitted for review.");
		
		
		if(b==true)
		{
			Assert.assertTrue(true);
			TestLogger.log("test case passed....Template submitted for review.");
			
		}else	{
			
			captureScreenrobot("validateStoreElementNumericField");
			Assert.assertTrue(false,"Template Did not submitted for review...");
		}
			
		 
	}
	
	@DataProvider(name="TemplateNumericFieldPageData")
	String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/dash2sell/testData/TemplateNumericFieldPageData.xlsx";
	
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);
		
		String templateNumericData[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				templateNumericData[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);//1 0
			}
				
		}
	return templateNumericData;
	}
	
	
	@Test
	public void validateStoreElementDateField() throws Exception {
	
		LoginPage lp=new LoginPage(driver);
		lp.setUserName("brownp");
		TestLogger.log("username ");
		lp.setPassword("Anderson1!");
		TestLogger.log("password");
		lp.clickSubmit();
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		StoreTemplatesPage storeTemp=new StoreTemplatesPage(driver);
		
		storeTemp.clickProjectsIcon();
		storeTemp.moveToActivities();
		storeTemp.clickTemplatesMenu();
		storeTemp.clickNewTemplateButton();
		storeTemp.clickStoreTemplate();
		storeTemp.clickElementTemplate();
		storeTemp.sendDescription("This is Description of element template");
		storeTemp.clickNewFieldButton();
		storeTemp.selectFieldType("945");
		storeTemp.sendCaption("This is Caption for List field");
		storeTemp.selectOptional("1");
		storeTemp.sendEarliestDate("2019-12-15");
		storeTemp.getEarliestDate().sendKeys(Keys.ESCAPE);
		storeTemp.sendLatesttDate("2019-12-25");
		storeTemp.getEarliestDate().sendKeys(Keys.ESCAPE);
		storeTemp.clickAttachment();
		
		Robot robot=new Robot();
		robot.setAutoDelay(2000);
		
		StringSelection stringSelection=new StringSelection("C:\\Users\\mohammad.parvez\\git\\test-automation\\Attachments\\sidekick.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection,null);
		robot.setAutoDelay(1000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.setAutoDelay(2000);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		storeTemp.clickInstruction();
		storeTemp.sendInstruction("First Instruction for Date field type"+"\n"+"This is second instruction");
		storeTemp.clickApplyChangesButton();	 
		storeTemp.clickSubmitForReveiw();
		TestLogger.log("Submit for Reveiw Button Clicked");
		driver.switchTo().alert().accept();	
		TestLogger.log("Alert accepted");
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		boolean b=driver.getPageSource().contains("Template submitted for review.");
		

		if(b==true)
		{
			Assert.assertTrue(true);
			TestLogger.log("test case passed....Template submitted for review.");
			
		}else	{
			
			captureScreenrobot("validateStoreElementDateField");
			Assert.assertTrue(false,"Template Did not submitted for review...");
			
			
			
			
		}
	}
	
	
	@Test
	public void validateStoreElementSignatureField() throws Exception {
	
		LoginPage lp=new LoginPage(driver);
		lp.setUserName("brownp");
		TestLogger.log("username ");
		lp.setPassword("Anderson1!");
		TestLogger.log("password");
		lp.clickSubmit();
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		StoreTemplatesPage storeTemp=new StoreTemplatesPage(driver);
		
		storeTemp.clickProjectsIcon();
		storeTemp.moveToActivities();
		storeTemp.clickTemplatesMenu();
		storeTemp.clickNewTemplateButton();
		storeTemp.clickStoreTemplate();
		storeTemp.clickElementTemplate();
		storeTemp.sendDescription("This is Description of element template");
		storeTemp.clickNewFieldButton();
		storeTemp.selectFieldType("2427");
		storeTemp.sendCaption("This is Caption for List field");
		storeTemp.selectOptional("1");
		storeTemp.selectAutoApprovePic("1");
		storeTemp.selectInternalUse("1");	
		storeTemp.sendLooseAttachment("ATT");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		storeTemp.getLoosAttachmentName();
		TestLogger.log("Loose Attachment Name Provided");	
		storeTemp.clickInstruction();
		storeTemp.sendInstruction("First Instruction for Scan Type field type"+"\n"+"This is second instruction");
		storeTemp.clickApplyChangesButton();	 
		storeTemp.clickSubmitForReveiw();
		TestLogger.log("Submit for Reveiw Button Clicked");
		driver.switchTo().alert().accept();	
		TestLogger.log("Alert accepted");
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		boolean b=driver.getPageSource().contains("Template submitted for review.");
		

		if(b==true)
		{
			Assert.assertTrue(true);
			TestLogger.log("test case passed....Template submitted for review.");
			
		}else	{
			
			captureScreenrobot("validateStoreElementScanTypeField");
			Assert.assertTrue(false,"Template Did not submitted for review...");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	@Test
	public void validateStoreElementTextField() throws Exception {
	
		LoginPage lp=new LoginPage(driver);
		lp.setUserName("brownp");
		TestLogger.log("username ");
		lp.setPassword("Anderson1!");
		TestLogger.log("password");
		lp.clickSubmit();
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		StoreTemplatesPage storeTemp=new StoreTemplatesPage(driver);
		
		storeTemp.clickProjectsIcon();
		storeTemp.moveToActivities();
		storeTemp.clickTemplatesMenu();
		storeTemp.clickNewTemplateButton();
		storeTemp.clickStoreTemplate();
		storeTemp.clickElementTemplate();
		storeTemp.sendDescription("This is Description of element template");
		storeTemp.clickNewFieldButton();
		storeTemp.selectFieldType("867");
		storeTemp.sendCaption("This is Caption for Text field");
		storeTemp.selectOptional("1");
		storeTemp.sendMaxValue("10");
		storeTemp.sendLooseAttachment("ATT");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		storeTemp.getLoosAttachmentName();
		TestLogger.log("Loose Attachment Name Provided");
		storeTemp.clickInstruction();
		storeTemp.sendInstruction("First Instruction for Text field type"+"\n"+"This is second instruction");
		storeTemp.clickApplyChangesButton();	 
		storeTemp.clickSubmitForReveiw();
		TestLogger.log("Submit for Reveiw Button Clicked");
		driver.switchTo().alert().accept();	
		TestLogger.log("Alert accepted");
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		boolean b=driver.getPageSource().contains("Template submitted for review.");
		

		if(b==true)
		{
			Assert.assertTrue(true);
			TestLogger.log("test case passed....Template submitted for review.");
			
		}else	{
			
			captureScreenrobot("validateStoreElementTextField");
			Assert.assertTrue(false,"Template Did not submitted for review...");
		}
	}
	
	
	@Test
	public void validateStoreElementListField() throws Exception {
	
		LoginPage lp=new LoginPage(driver);
		lp.setUserName("brownp");
		TestLogger.log("username ");
		lp.setPassword("Anderson1!");
		TestLogger.log("password");
		lp.clickSubmit();
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		StoreTemplatesPage storeTemp=new StoreTemplatesPage(driver);
		
		storeTemp.clickProjectsIcon();
		storeTemp.moveToActivities();
		storeTemp.clickTemplatesMenu();
		storeTemp.clickNewTemplateButton();
		storeTemp.clickStoreTemplate();
		storeTemp.clickElementTemplate();
		storeTemp.sendDescription("This is Description of element template");
		storeTemp.clickNewFieldButton();
		storeTemp.selectFieldType("868");
		storeTemp.sendCaption("This is Caption for List field");
		storeTemp.selectOptional("1");
		storeTemp.sendLooseAttachment("ATT");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		storeTemp.getLoosAttachmentName();
		TestLogger.log("Loose Attachment Name Provided");
		storeTemp.selectMultipleSelection("1");	
		storeTemp.clickAddResponse();
		storeTemp.sendResponseText("anderson");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		storeTemp.getResponse().sendKeys(Keys.DOWN);
		storeTemp.getResponse().sendKeys(Keys.RETURN);
		storeTemp.clickDeleteResponse();
		driver.switchTo().alert().accept();
		storeTemp.selectReportResponse("1");		
		storeTemp.clickInstruction();
		storeTemp.sendInstruction("First Instruction for Text field type"+"\n"+"This is second instruction");
		storeTemp.clickApplyChangesButton();	 
		storeTemp.clickSubmitForReveiw();
		TestLogger.log("Submit for Reveiw Button Clicked");
		driver.switchTo().alert().accept();	
		TestLogger.log("Alert accepted");
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		boolean b=driver.getPageSource().contains("Template submitted for review.");
		

		if(b==true)
		{
			Assert.assertTrue(true);
			TestLogger.log("test case passed....Template submitted for review.");
			
		}else	{
			
			captureScreenrobot("validateStoreElementListField");
			Assert.assertTrue(false,"Template Did not submitted for review...");
		}
	}
	
	@Test
	public void validateStoreElementPictureField() throws Exception {
	
		LoginPage lp=new LoginPage(driver);
		lp.setUserName("brownp");
		TestLogger.log("username ");
		lp.setPassword("Anderson1!");
		TestLogger.log("password");
		lp.clickSubmit();
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		StoreTemplatesPage storeTemp=new StoreTemplatesPage(driver);
		
		storeTemp.clickProjectsIcon();
		storeTemp.moveToActivities();
		storeTemp.clickTemplatesMenu();
		storeTemp.clickNewTemplateButton();
		storeTemp.clickStoreTemplate();
		storeTemp.clickElementTemplate();
		storeTemp.sendDescription("This is Description of element template");
		storeTemp.clickNewFieldButton();
		storeTemp.selectFieldType("869");
		storeTemp.sendCaption("This is Caption for List field");
		storeTemp.selectOptional("1");
		storeTemp.sendLooseAttachment("ATT");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		storeTemp.getLoosAttachmentName();
		TestLogger.log("Loose Attachment Name Provided");	
		storeTemp.selectAutoApprovePictures("0");
		storeTemp.clickInstruction();
		storeTemp.sendInstruction("First Instruction for Picture field type"+"\n"+"This is second instruction");
		storeTemp.clickApplyChangesButton();	 
		storeTemp.clickSubmitForReveiw();
		TestLogger.log("Submit for Reveiw Button Clicked");
		driver.switchTo().alert().accept();	
		TestLogger.log("Alert accepted");
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		boolean b=driver.getPageSource().contains("Template submitted for review.");
		

		if(b==true)
		{
			Assert.assertTrue(true);
			TestLogger.log("test case passed....Template submitted for review.");
			
		}else	{
			
			captureScreenrobot("validateStoreElementPictureField");
			Assert.assertTrue(false,"Template Did not submitted for review...");
		}
	}
	
	@Test
	public void validateStoreElementInstructionField() throws Exception {
	
		LoginPage lp=new LoginPage(driver);
		lp.setUserName("brownp");
		TestLogger.log("username ");
		lp.setPassword("Anderson1!");
		TestLogger.log("password");
		lp.clickSubmit();
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		StoreTemplatesPage storeTemp=new StoreTemplatesPage(driver);
		
		storeTemp.clickProjectsIcon();
		storeTemp.moveToActivities();
		storeTemp.clickTemplatesMenu();
		storeTemp.clickNewTemplateButton();
		storeTemp.clickStoreTemplate();
		storeTemp.clickElementTemplate();
		storeTemp.sendDescription("This is Description of element template");
		storeTemp.clickNewFieldButton();
		storeTemp.selectFieldType("870");
		storeTemp.sendCaption("This is Caption for List field");
		storeTemp.selectOptional("1");
		storeTemp.clickInstruction();
		storeTemp.sendInstruction("First Instruction for Instructions field type"+"\n"+"This is second instruction");
		storeTemp.clickApplyChangesButton();	 
		storeTemp.clickSubmitForReveiw();
		TestLogger.log("Submit for Reveiw Button Clicked");
		driver.switchTo().alert().accept();	
		TestLogger.log("Alert accepted");
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		boolean b=driver.getPageSource().contains("Template submitted for review.");
		

		if(b==true)
		{
			Assert.assertTrue(true);
			TestLogger.log("test case passed....Template submitted for review.");
			
		}else	{
			
			captureScreenrobot("validateStoreElementInstructionField");
			Assert.assertTrue(false,"Template Did not submitted for review...");
		}
	}
	
	@Test
	public void validateStoreElementInLineAttachmentField() throws Exception {
	
		LoginPage lp=new LoginPage(driver);
		lp.setUserName("brownp");
		TestLogger.log("username ");
		lp.setPassword("Anderson1!");
		TestLogger.log("password");
		lp.clickSubmit();
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		StoreTemplatesPage storeTemp=new StoreTemplatesPage(driver);
		
		storeTemp.clickProjectsIcon();
		storeTemp.moveToActivities();
		storeTemp.clickTemplatesMenu();
		storeTemp.clickNewTemplateButton();
		storeTemp.clickStoreTemplate();
		storeTemp.clickElementTemplate();
		storeTemp.sendDescription("This is Description of element template");
		storeTemp.clickNewFieldButton();
		storeTemp.selectFieldType("871");
		storeTemp.sendCaption("This is Caption for In-Line Attachment field");
		storeTemp.selectOptional("1");	 
		storeTemp.clickAttachment();
		
		Robot robot=new Robot();
		robot.setAutoDelay(2000);
		
		StringSelection stringSelection=new StringSelection("C:\\Users\\mohammad.parvez\\git\\test-automation\\Attachments\\sidekick.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection,null);
		robot.setAutoDelay(1000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.setAutoDelay(2000);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	
		storeTemp.clickSubmitForReveiw();
		TestLogger.log("Submit for Reveiw Button Clicked");
		driver.switchTo().alert().accept();	
		TestLogger.log("Alert accepted");
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		boolean b=driver.getPageSource().contains("Template submitted for review.");
		

		if(b==true)
		{
			Assert.assertTrue(true);
			TestLogger.log("test case passed....Template submitted for review.");
			
		}else	{
			
			captureScreenrobot("validateStoreElementInLineAttachmentField");
			Assert.assertTrue(false,"Template Did not submitted for review...");
		}
	}
	
	@Test
	public void validateStoreElementFeatureLinkField() throws Exception {
	
		LoginPage lp=new LoginPage(driver);
		lp.setUserName("brownp");
		TestLogger.log("username ");
		lp.setPassword("Anderson1!");
		TestLogger.log("password");
		lp.clickSubmit();
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		StoreTemplatesPage storeTemp=new StoreTemplatesPage(driver);
		
		storeTemp.clickProjectsIcon();
		storeTemp.moveToActivities();
		storeTemp.clickTemplatesMenu();
		storeTemp.clickNewTemplateButton();
		storeTemp.clickStoreTemplate();
		storeTemp.clickElementTemplate();
		storeTemp.sendDescription("This is Description of element template");
		storeTemp.clickNewFieldButton();
		storeTemp.selectFieldType("935");
		storeTemp.sendCaption("This is Caption for In-Line Attachment field");
		storeTemp.selectOptional("1");
		storeTemp.selectFeatureLinkType("32");
		storeTemp.clickAttachment();
		
		Robot robot=new Robot();
		robot.setAutoDelay(2000);
		
		StringSelection stringSelection=new StringSelection("C:\\Users\\mohammad.parvez\\git\\test-automation\\Attachments\\sidekick.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection,null);
		robot.setAutoDelay(1000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.setAutoDelay(2000);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		storeTemp.clickInstruction();
		storeTemp.sendInstruction("First Instruction for Feature Link field type"+"\n"+"This is second instruction");
		storeTemp.clickApplyChangesButton();	 
	
		storeTemp.clickSubmitForReveiw();
		TestLogger.log("Submit for Reveiw Button Clicked");
		driver.switchTo().alert().accept();	
		TestLogger.log("Alert accepted");
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		boolean b=driver.getPageSource().contains("Template submitted for review.");
		

		if(b==true)
		{
			Assert.assertTrue(true);
			TestLogger.log("test case passed....Template submitted for review.");
			
		}else	{
			
			captureScreenrobot("validateStoreElementFeatureLinkField");
			Assert.assertTrue(false,"Template Did not submitted for review...");
		}
	}
	
	
	//that need to fixed
	@Test
	public void validateStoreElementExceptionField() throws Exception {
	
		LoginPage lp=new LoginPage(driver);
		lp.setUserName("brownp");
		TestLogger.log("username ");
		lp.setPassword("Anderson1!");
		TestLogger.log("password");
		lp.clickSubmit();
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		StoreTemplatesPage storeTemp=new StoreTemplatesPage(driver);
		
		storeTemp.clickProjectsIcon();
		storeTemp.moveToActivities();
		storeTemp.clickTemplatesMenu();
		storeTemp.clickNewTemplateButton();
		storeTemp.clickStoreTemplate();
		storeTemp.clickElementTemplate();
		storeTemp.sendDescription("This is Description of element template");
		storeTemp.clickNewFieldButton();
		storeTemp.selectFieldType("936");
		storeTemp.sendCaption("This is Caption for Exception field");
		storeTemp.selectOptional("1");
		storeTemp.selectExcetptionType("939");
		storeTemp.clickAttachment();
		
		Robot robot=new Robot();
		robot.setAutoDelay(2000);
		
		StringSelection stringSelection=new StringSelection("C:\\Users\\mohammad.parvez\\git\\test-automation\\Attachments\\sidekick.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection,null);
		robot.setAutoDelay(1000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.setAutoDelay(2000);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		storeTemp.clickInstruction();
		storeTemp.sendInstruction("First Instruction for Exception field type"+"\n"+"This is second instruction");
		storeTemp.clickApplyChangesButton();	 
	
		storeTemp.clickSubmitForReveiw();
		TestLogger.log("Submit for Reveiw Button Clicked");
		driver.switchTo().alert().accept();	
		TestLogger.log("Alert accepted");
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		boolean b=driver.getPageSource().contains("Template submitted for review.");
		

		if(b==true)
		{
			Assert.assertTrue(true);
			TestLogger.log("test case passed....Template submitted for review.");
			
		}else	{
			
			captureScreenrobot("validateStoreElementExceptionField");
			Assert.assertTrue(false,"Template Did not submitted for review...");
		}
	}
	
	
	
	@Test
	public void validateStoreElementCurrencyField() throws Exception {
	
		LoginPage lp=new LoginPage(driver);
		lp.setUserName("brownp");
		TestLogger.log("username ");
		lp.setPassword("Anderson1!");
		TestLogger.log("password");
		lp.clickSubmit();
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		StoreTemplatesPage storeTemp=new StoreTemplatesPage(driver);
		
		storeTemp.clickProjectsIcon();
		storeTemp.moveToActivities();
		storeTemp.clickTemplatesMenu();
		storeTemp.clickNewTemplateButton();
		storeTemp.clickStoreTemplate();
		storeTemp.clickElementTemplate();
		storeTemp.sendDescription("This is Description of element template");
		storeTemp.clickNewFieldButton();
		storeTemp.selectFieldType("946");
		storeTemp.sendCaption("This is Caption for List field");
		storeTemp.selectOptional("1");
		storeTemp.getMinAmount().clear();
		storeTemp.sendMinAmount("15");
		storeTemp.getMaxAmount().clear();
		storeTemp.sendMaxAmount("25");
		storeTemp.sendLooseAttachment("ATT");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		storeTemp.getLoosAttachmentName();
		TestLogger.log("Loose Attachment Name Provided");	
		storeTemp.clickInstruction();
		storeTemp.sendInstruction("First Instruction for Currency field type"+"\n"+"This is second instruction");
		storeTemp.clickApplyChangesButton();	 
		storeTemp.clickSubmitForReveiw();
		TestLogger.log("Submit for Reveiw Button Clicked");
		driver.switchTo().alert().accept();	
		TestLogger.log("Alert accepted");
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		boolean b=driver.getPageSource().contains("Template submitted for review.");
		

		if(b==true)
		{
			Assert.assertTrue(true);
			TestLogger.log("test case passed....Template submitted for review.");
			
		}else	{
			
			captureScreenrobot("validateStoreElementCurrencyField");
			Assert.assertTrue(false,"Template Did not submitted for review...");
		}
	}



	@Test
	public void validateStoreElementLooseAttachmentField() throws Exception {
	
		LoginPage lp=new LoginPage(driver);
		lp.setUserName("brownp");
		TestLogger.log("username ");
		lp.setPassword("Anderson1!");
		TestLogger.log("password");
		lp.clickSubmit();
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		StoreTemplatesPage storeTemp=new StoreTemplatesPage(driver);
		
		storeTemp.clickProjectsIcon();
		storeTemp.moveToActivities();
		storeTemp.clickTemplatesMenu();
		storeTemp.clickNewTemplateButton();
		storeTemp.clickStoreTemplate();
		storeTemp.clickElementTemplate();
		storeTemp.sendDescription("This is Description of element template");
		storeTemp.clickNewFieldButton();
		storeTemp.selectFieldType("1069");
		storeTemp.sendCaption("This is Caption for List field");
		storeTemp.selectOptional("1");
		storeTemp.sendLooseAttachment("ATT");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		storeTemp.getLoosAttachmentName();
		TestLogger.log("Loose Attachment Name Provided");	
		storeTemp.clickSubmitForReveiw();
		TestLogger.log("Submit for Reveiw Button Clicked");
		driver.switchTo().alert().accept();	
		TestLogger.log("Alert accepted");
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		boolean b=driver.getPageSource().contains("Template submitted for review.");
		

		if(b==true)
		{
			Assert.assertTrue(true);
			TestLogger.log("test case passed....Template submitted for review.");
			
		}else	{
			
			captureScreenrobot("validateStoreElementLooseAttachmentField");
			Assert.assertTrue(false,"Template Did not submitted for review...");
		}
	}
	
	@Test
	public void validateStoreElementScanTypeField() throws Exception {
	
		LoginPage lp=new LoginPage(driver);
		lp.setUserName("brownp");
		TestLogger.log("username ");
		lp.setPassword("Anderson1!");
		TestLogger.log("password");
		lp.clickSubmit();
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		StoreTemplatesPage storeTemp=new StoreTemplatesPage(driver);
		
		storeTemp.clickProjectsIcon();
		storeTemp.moveToActivities();
		storeTemp.clickTemplatesMenu();
		storeTemp.clickNewTemplateButton();
		storeTemp.clickStoreTemplate();
		storeTemp.clickElementTemplate();
		storeTemp.sendDescription("This is Description of element template");
		storeTemp.clickNewFieldButton();
		storeTemp.selectFieldType("1091");
		storeTemp.sendCaption("This is Caption for List field");
		storeTemp.selectScanType("2");
		storeTemp.selectOptional("1");
		storeTemp.sendLooseAttachment("ATT");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		storeTemp.getLoosAttachmentName();
		TestLogger.log("Loose Attachment Name Provided");	
		storeTemp.clickInstruction();
		storeTemp.sendInstruction("First Instruction for Scan Type field type"+"\n"+"This is second instruction");
		storeTemp.clickApplyChangesButton();	 
		storeTemp.clickSubmitForReveiw();
		TestLogger.log("Submit for Reveiw Button Clicked");
		driver.switchTo().alert().accept();	
		TestLogger.log("Alert accepted");
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		boolean b=driver.getPageSource().contains("Template submitted for review.");
		

		if(b==true)
		{
			Assert.assertTrue(true);
			TestLogger.log("test case passed....Template submitted for review.");
			
		}else	{
			
			captureScreenrobot("validateStoreElementScanTypeField");
			Assert.assertTrue(false,"Template Did not submitted for review...");
		}
	}
	

	@Test
	public void validateStoreElementSingleScreenWrapperField() throws Exception {
	
		LoginPage lp=new LoginPage(driver);
		lp.setUserName("brownp");
		TestLogger.log("username ");
		lp.setPassword("Anderson1!");
		TestLogger.log("password");
		lp.clickSubmit();
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		StoreTemplatesPage storeTemp=new StoreTemplatesPage(driver);
		
		storeTemp.clickProjectsIcon();
		storeTemp.moveToActivities();
		storeTemp.clickTemplatesMenu();
		storeTemp.clickNewTemplateButton();
		storeTemp.clickStoreTemplate();
		storeTemp.clickElementTemplate();
		storeTemp.sendDescription("This is Description of element template");
		storeTemp.clickNewFieldButton();
		storeTemp.selectFieldType("2004");
		storeTemp.selectOptional("1");
		storeTemp.sendCaption("This is Caption for List field");
		driver.findElement(By.xpath("//div[@colname[contains(.,'addchild')]]")).click();
		
		
		List<WebElement> captionList=(List<WebElement>) storeTemp.getMultiCaption();
		Iterator<WebElement> cap=captionList.iterator();
		cap.next();
		WebElement caption2=cap.next();
		caption2.sendKeys("This is Second caption");
		
		
		List<WebElement> attachList=driver.findElements(By.xpath("//input[@class[contains(.,'aawgui_attachment_filepicker')]]"));
		Iterator<WebElement> attach=attachList.iterator();
		attach.next();
		WebElement attachList2=attach.next();
		attachList2.click();
		
		
		Robot robot=new Robot();
		robot.setAutoDelay(2000);
		
		StringSelection stringSelection2=new StringSelection("C:\\Users\\mohammad.parvez\\git\\test-automation\\Attachments\\sidekick.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection2,null);
		robot.setAutoDelay(1000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.setAutoDelay(2000);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		List<WebElement> addButtonList=driver.findElements(By.xpath("//*[starts-with(@id,'grid_responses_aawgui_Fields_grid_temporary_') and text()='Add']"));
		Iterator<WebElement> addButton=addButtonList.iterator();
		addButton.next();
		WebElement addButton2=addButton.next();
		addButton2.click();
		storeTemp.sendResponseText("This is Rsponse Text");

		storeTemp.clickSubmitForReveiw();
		TestLogger.log("Submit for Reveiw Button Clicked");
		driver.switchTo().alert().accept();	
		TestLogger.log("Alert accepted");
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		boolean b=driver.getPageSource().contains("Template submitted for review.");
		
		
		if(b==true)
		{
			Assert.assertTrue(true);
			TestLogger.log("test case passed....Template submitted for review.");
			
		}else	{
			
			captureScreenrobot("validateStoreElementSingleScreenWrapperField");
			Assert.assertTrue(false,"Template Did not submitted for review...");
		}
		
		
	}

	
	
	@Test
	public void validateStoreElementHyperlinkField() throws Exception {
	
		LoginPage lp=new LoginPage(driver);
		lp.setUserName("brownp");
		TestLogger.log("username ");
		lp.setPassword("Anderson1!");
		TestLogger.log("password");
		lp.clickSubmit();
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		StoreTemplatesPage storeTemp=new StoreTemplatesPage(driver);
		
		storeTemp.clickProjectsIcon();
		storeTemp.moveToActivities();
		storeTemp.clickTemplatesMenu();
		storeTemp.clickNewTemplateButton();
		storeTemp.clickStoreTemplate();
		storeTemp.clickElementTemplate();
		storeTemp.sendDescription("This is Description of element template");
		storeTemp.clickNewFieldButton();
		storeTemp.selectFieldType("2911");
		storeTemp.sendCaption("This is Caption for Hyperlink field");
		storeTemp.selectOptional("1");
		storeTemp.sendHyperlinkAddress("https://google.com");
		storeTemp.clickInstruction();
		storeTemp.sendInstruction("First Instruction for Hyperlink Type field type"+"\n"+"This is second instruction");
		storeTemp.clickApplyChangesButton();
		
		storeTemp.clickNewFieldButton();
		
		List<WebElement> hyperlinkdropList=storeTemp.getMultihyperdroplist();
		Iterator<WebElement> add=hyperlinkdropList.iterator();
		add.next();
		WebElement hyperlinkdropList2=add.next();
		hyperlinkdropList2.click();
			
		List<WebElement> captionList=(List<WebElement>) storeTemp.getMultiCaption();
		Iterator<WebElement> cap=captionList.iterator();
		cap.next();
		WebElement caption2=cap.next();
		caption2.sendKeys("This is Second caption");
		
		List<WebElement> hyperlinkList=(List<WebElement>) storeTemp.getMultihyperlink();
		Iterator<WebElement> hyper=hyperlinkList.iterator();
		hyper.next();
		WebElement hyperlink2=hyper.next();
		hyperlink2.sendKeys("https://yahoo.com");	
		
		storeTemp.clickSubmitForReveiw();
		TestLogger.log("Submit for Reveiw Button Clicked");
		driver.switchTo().alert().accept();	
		TestLogger.log("Alert accepted");
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		boolean b=driver.getPageSource().contains("Template submitted for review.");
		

		if(b==true)
		{
			Assert.assertTrue(true);
			TestLogger.log("test case passed....Template submitted for review.");
			
		}else	{
			
			captureScreenrobot("validateStoreElementHyperlinkField");
			Assert.assertTrue(false,"Template Did not submitted for review...");
		}
	}
	
	
	
	@Test
	public void validateStoreElementShopcomField() throws Exception {
		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName("brownp");
		TestLogger.log("username ");
		lp.setPassword("Anderson1!");
		TestLogger.log("password");
		lp.clickSubmit();
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		StoreTemplatesPage storeTemp=new StoreTemplatesPage(driver);
		
		storeTemp.clickProjectsIcon();
		storeTemp.moveToActivities();
		storeTemp.clickTemplatesMenu();
		storeTemp.clickNewTemplateButton();
		storeTemp.clickStoreTemplate();
		storeTemp.clickElementTemplate();
		storeTemp.sendDescription("This is Description of element template");
		storeTemp.clickNewFieldButton();
		storeTemp.selectFieldType("3056");
		storeTemp.sendCaption("This is Caption for Shopcom field");
		storeTemp.selectOptional("1");
		
		storeTemp.clickAttachment();
		
		Robot robot=new Robot();
		robot.setAutoDelay(2000);
		
		StringSelection stringSelection=new StringSelection("C:\\Users\\mohammad.parvez\\git\\test-automation\\Attachments\\sidekick.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection,null);
		robot.setAutoDelay(1000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.setAutoDelay(2000);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	Thread.sleep(3000);
	/*	
		storeTemp.clickInstruction();
		storeTemp.sendInstruction("First Instruction for Shopcom Type field type"+"\n"+"This is second instruction");
		storeTemp.clickApplyChangesButton();*/
		
		
		//boolean addbutton=driver.findElement(By.xpath("//div[starts-with(@id,'grid_criteria_Fields_grid_row_') and text()='Add']")).isDisplayed();
		/*
		if(driver.findElement(By.xpath("//div[starts-with(@id,'grid_criteria_Fields_grid_row_') and text()='Add']")).isDisplayed()) {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//div[starts-with(@id,'grid_criteria_Fields_grid_row_') and text()='Add']")));
			
			//driver.findElement(By.xpath("//div[starts-with(@id,'grid_criteria_Fields_grid_row_') and text()='Add']")).click();
		}
		else {
			
			driver.findElement(By.xpath("//*[text()[contains(.,'Toggle Advanced Mode')]]")).click();
			//driver.findElement(By.xpath("//div[starts-with(@id,'grid_criteria_Fields_grid_row_') and text()='Add']")).click();
			
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//div[starts-with(@id,'grid_criteria_Fields_grid_row_') and text()='Add']")));
			
		}*/
		
		
	
	
		
		driver.findElement(By.xpath("//*[text()[contains(.,'Toggle Advanced Mode')]]")).click();
		
		Thread.sleep(3000);
	driver.findElement(By.xpath("//div[starts-with(@id,'grid_criteria_Fields_grid_row_') and text()='Add']")).click();
		
		
	
	
	/*	storeTemp.clickNewFieldButton();
		
		
		List<WebElement> shopcomdropList=driver.findElements(By.xpath("//option[text()='Shopcom Order']"));
		Iterator<WebElement> add=shopcomdropList.iterator();
		add.next();
		WebElement shopcomdropList2=add.next();
		shopcomdropList2.click();
		
		
		List<WebElement> captionList=(List<WebElement>) storeTemp.getMultiCaption();
		Iterator<WebElement> cap=captionList.iterator();
		cap.next();
		WebElement caption2=cap.next();
		caption2.sendKeys("This is Second caption");
		
		List<WebElement> attachList=driver.findElements(By.xpath("//input[@class[contains(.,'aawgui_attachment_filepicker')]]"));
		Iterator<WebElement> attach=attachList.iterator();
		attach.next();
		WebElement attachList2=attach.next();
		attachList2.click();
		
		
		Robot robot2=new Robot();
		robot2.setAutoDelay(2000);
		
		StringSelection stringSelection2=new StringSelection("C:\\Users\\mohammad.parvez\\git\\test-automation\\Attachments\\sidekick.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection2,null);
		robot2.setAutoDelay(1000);
		robot2.keyPress(KeyEvent.VK_CONTROL);
		robot2.keyPress(KeyEvent.VK_V);
		
		robot2.keyRelease(KeyEvent.VK_CONTROL);
		robot2.keyRelease(KeyEvent.VK_V);
		robot2.setAutoDelay(2000);
		
		robot2.keyPress(KeyEvent.VK_ENTER);
		robot2.keyRelease(KeyEvent.VK_ENTER);
		
		robot2.keyPress(KeyEvent.VK_ENTER);
		robot2.keyRelease(KeyEvent.VK_ENTER);
			
	
	*/
		
	/*	storeTemp.clickSubmitForReveiw();
		TestLogger.log("Submit for Reveiw Button Clicked");
		driver.switchTo().alert().accept();	
		TestLogger.log("Alert accepted");
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		boolean b=driver.getPageSource().contains("Template submitted for review.");
		

		if(b==true)
		{
			Assert.assertTrue(true);
			TestLogger.log("test case passed....Template submitted for review.");
			
		}else	{
			
			captureScreenrobot("validateStoreElementShopcomField");
			Assert.assertTrue(false,"Template Did not submitted for review...");
		}*/
	}
	



}
