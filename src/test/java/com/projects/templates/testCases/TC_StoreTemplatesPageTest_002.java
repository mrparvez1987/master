package com.projects.templates.testCases;


import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.dash2sell.database.DataTest;
import com.dash2sell.pageObjects.LoginPage;
import com.dashManagement.utilities.BaseClass;
import com.dashManagement.utilities.TestLogger;
import com.dashManagement.utilities.XLUtils;
import com.projects.templates.pageObject.StoreTemplatesPage;

public class TC_StoreTemplatesPageTest_002 extends BaseClass{
	
	StoreTemplatesPage storeTemp=new StoreTemplatesPage(driver);
	
	public void loginFeature(String user,String pass) {
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(user);
		TestLogger.log("username: "+user);
		lp.setPassword(pass);
		TestLogger.log("password: "+pass);
		lp.clickSubmit();
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
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
			
	}
	
	
	@Test(dataProvider="TemplateNumericFieldPageData")
	public void validateStoreElementNumericField(String user,String pass,String desc,String fieldType,String cap,String optional,String minvalue,String maxvalue) throws Exception {
		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(user);
		TestLogger.log("username: "+user);
		lp.setPassword(pass);
		TestLogger.log("password: "+pass);
		lp.clickSubmit();
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
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
		storeTemp.sendDescription(desc);
		TestLogger.log("description sent");
		
		//TC_StoreTemplatesPageTest_002 testClass=new TC_StoreTemplatesPageTest_002(); 
		//testClass.commonNumberField(fieldType,cap,optional,minvalue,maxvalue);
		
	}
	
	
	
	public void commonNumberField(String desc,String fieldType,String cap,String optional,String minvalue,String maxvalue,String comp,String value) throws Exception {
		
		String text=storeTemp.tempText().getText();
		System.out.println(text);
		String tempNumber=(String) text.subSequence(10, 15);
		TestLogger.log("Current Template number :"+tempNumber);
			
		storeTemp.sendDescription(desc);
		storeTemp.clickMultiExecutionBox();
		storeTemp.clickNewFieldButton();
		TestLogger.log("New Field button clicked");
		storeTemp.selectFieldTypeByText(fieldType);
		TestLogger.log("Numeric field type selected");
		storeTemp.sendCaption(cap);
		TestLogger.log("Caption provided");
		storeTemp.selectOptional(optional);
		TestLogger.log("Optional field selected");
		storeTemp.selectIdentifierField("1");
		TestLogger.log("Identifier field selected");
		storeTemp.sendMinValue(minvalue);
		TestLogger.log("min value selected");
		storeTemp.sendMaxValue(maxvalue);
		TestLogger.log("max value selected");
		storeTemp.sendLooseAttachment("ATT");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		storeTemp.getLoosAttachmentName();
		TestLogger.log("Loose Attachment Name Provided");
		storeTemp.clickInstruction();
		TestLogger.log("Instruction fieild clicked");
		storeTemp.sendInstruction("instruction");
		TestLogger.log("Instruction sent");
		storeTemp.clickApplyChangesButton();
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		storeTemp.gotoBottomPage();
		List<WebElement> multiaddcriteria=storeTemp.getMultiCriteriaAdd();
		Iterator<WebElement> criteriaAdd=multiaddcriteria.iterator();
	
		WebElement criteriaAdd6=criteriaAdd.next();
		criteriaAdd6.click();
		TestLogger.log("Advance crieteria add button clicked");
		
		List<WebElement> multisource=storeTemp.getMultisource();
		Iterator<WebElement> source=multisource.iterator();
		WebElement source1=source.next();
		source1.click();
		driver.findElement(By.xpath("//b[contains(text(),'location')]")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		storeTemp.selectComp(comp);
		
		storeTemp.clickValue();
		storeTemp.sendValue(value);
		List<WebElement> applychangebuttonlist=storeTemp.getApplyChangesButton();
		Iterator<WebElement> applychange=applychangebuttonlist.iterator();
		applychange.next();	

		WebElement applychange2=applychange.next();
		applychange2.click();
			
		storeTemp.clickSave();
		TestLogger.log("Save Button Clicked");
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		boolean b=driver.getPageSource().contains("Save successful.");
		
		
		if(b==true)
		{
			Assert.assertTrue(true);
			TestLogger.log("test case passed....Save successful.");
			
		}else	{
			
			captureScreenrobot("validateStoreElementNumericField");
			Assert.assertTrue(false,"Template Did not Save successful....");
		}
			
		DataTest dt= new DataTest();
		try {
			dt.validateTemplateNumericData(desc,fieldType,cap,optional,minvalue,maxvalue,comp,value,tempNumber);
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		} 
	

	
	@DataProvider(name="TemplateNumericFieldPageData")
	String [][] getNumericTypeData() throws IOException
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
	
	
	
	
	@Test(dataProvider="TemplateLooseAttachmentPageData")
	public void validateStoreElementLooseAttachmentField(String user,String pass,String desc,String fieldType,String cap,String optional,String loose) throws Exception {
	
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(user);
		TestLogger.log("username :"+user);
		lp.setPassword(pass);
		TestLogger.log("password :"+pass);
		lp.clickSubmit();
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		storeTemp.clickProjectsIcon();
		TestLogger.log("project icon clicked");
		storeTemp.moveToActivities();
		storeTemp.clickTemplatesMenu();
		TestLogger.log("template menu clicked");
		storeTemp.clickNewTemplateButton();
		storeTemp.clickStoreTemplate();
		storeTemp.clickElementTemplate();
		TestLogger.log("Element template selected");		
		storeTemp.sendDescription(desc);
		TestLogger.log("description sent");
				
		
	}
	
	public void commonStoreElementLooseAttachmentField(String fieldType2,String cap2,String optional2,String loose2) throws Exception {	
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		String text=storeTemp.tempText().getText();
		System.out.println(text);
		String tempNumber=(String) text.subSequence(10, 15);
		TestLogger.log("Current Template number :"+tempNumber);
		
		storeTemp.gotoBottomPage();
		 
		 driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		storeTemp.clickNewFieldButton();
		
		TestLogger.log("new field button clicked");
		storeTemp.selectFieldTypeByText(fieldType2);
		
		List<WebElement> captionList=(List<WebElement>) storeTemp.getMultiCaption();
		Iterator<WebElement> cap=captionList.iterator();
		cap.next();
		WebElement caption2=cap.next();
		caption2.sendKeys(cap2);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		TestLogger.log("caption sent");
		storeTemp.selectOptional(optional2);
		
		List<WebElement>looseList=(List<WebElement>) storeTemp.getMultiLooseAttachment();
		Iterator<WebElement> looseName=looseList.iterator();
		looseName.next();
		WebElement looseName2=looseName.next();
		
		looseName2.sendKeys(loose2);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		storeTemp.getLoosAttachmentName();
		TestLogger.log("Loose Attachment Name Provided");	
		storeTemp.clickSave();
		TestLogger.log("Save Button Clicked");
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		boolean b=driver.getPageSource().contains("Save successful.");
		

		if(b==true)
		{
			Assert.assertTrue(true);
			TestLogger.log("test case passed....Template Save successful.");
			
		}else	{
			
			captureScreenrobot("commonStoreElementLooseAttachmentField");
			Assert.assertTrue(false,"Template Did not Save successful....");
		}
		
		DataTest dt= new DataTest();
		try {
			dt.validateLooseAttachmentTypeData(fieldType2,cap2,optional2,loose2,tempNumber);
			
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	
	@DataProvider(name="TemplateLooseAttachmentPageData")
	public String [][] getLooseAttachmentData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/dash2sell/testData/TemplateLooseAttachmentPageData.xlsx";
	
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);
		
		String templateLooseAttachmentData[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				templateLooseAttachmentData[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);//1 0
			}
				
		}
	return templateLooseAttachmentData;
	}
	
	
	
	@Test(dataProvider="TemplateDateFieldPageData")
	public void validateStoreElementDateField(String user,String pass,String desc,String fieldType,String caption,String optional,String edate,String ldate) throws Exception {
	
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(user);
		TestLogger.log("username :"+user);
		lp.setPassword(pass);
		TestLogger.log("password :"+pass);
		lp.clickSubmit();
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		storeTemp.clickProjectsIcon();
		TestLogger.log("Project Icon Clicked");
		storeTemp.moveToActivities();
		storeTemp.clickTemplatesMenu();
		TestLogger.log("Templates Menu Clicked");
		storeTemp.clickNewTemplateButton();
		TestLogger.log("New Template Button Clicked");
		storeTemp.clickStoreTemplate();
		storeTemp.clickElementTemplate();	
		storeTemp.sendDescription(desc);
		TestLogger.log("description sent");
	}
	
	
	public void coomonDateField(String fieldType3,String cap3,String optional3,String edate,String ldate) throws Exception {
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		String text=storeTemp.tempText().getText();
		System.out.println(text);
		String tempNumber=(String) text.subSequence(10, 15);
		TestLogger.log("Current Template number :"+tempNumber);
		
		storeTemp.gotoBottomPage();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		storeTemp.gotoBottomPage();
	
		storeTemp.clickNewFieldButton();
		storeTemp.selectFieldTypeByText(fieldType3);
		TestLogger.log("field type 'DateType' selected");
		
		storeTemp.gotoBottomPage();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);	
		
		List<WebElement> captionList=(List<WebElement>) storeTemp.getMultiCaption();
		Iterator<WebElement> cap=captionList.iterator();
		cap.next();
		cap.next();
		WebElement caption2=cap.next();
		caption2.sendKeys(cap3);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		TestLogger.log("caption sent for date field");
		
		storeTemp.selectOptional(optional3);
		TestLogger.log("optional selected");	
		
		List<WebElement> edateList=(List<WebElement>) storeTemp.getMultiEarliestDate();
		Iterator<WebElement> earlyDate=edateList.iterator();
		earlyDate.next();
		earlyDate.next();
		WebElement earlyDate2=earlyDate.next();
		earlyDate2.sendKeys(edate);
		earlyDate2.sendKeys(Keys.ESCAPE);
		TestLogger.log("earliest date provided");	
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	
		List<WebElement> ldateList=(List<WebElement>) storeTemp.getMultiLatestDate();
		Iterator<WebElement> latestDate=ldateList.iterator();
		latestDate.next();
		latestDate.next();
		WebElement latestDate2=latestDate.next();
		latestDate2.sendKeys(ldate);
		latestDate2.sendKeys(Keys.ESCAPE);
			
		TestLogger.log("latest date provided");
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		storeTemp.clickAttachment();
		
		storeTemp.uploadFile(System.getProperty("user.dir")+"\\Attachments\\sidekick"+".pdf");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		List<WebElement> instructionList=(List<WebElement>) storeTemp.getMultiInstructionBox();
		Iterator<WebElement> instrBox=instructionList.iterator();
		instrBox.next();
		instrBox.next();
		WebElement instrBox2=instrBox.next();
		instrBox2.click();
				
		storeTemp.sendInstruction("instruction");
		storeTemp.clickApplyChangesButton();	 
		storeTemp.clickSave();
		TestLogger.log("Save Button Clicked");
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		boolean b=driver.getPageSource().contains("Save successful.");
		

		if(b==true)
		{
			Assert.assertTrue(true);
			TestLogger.log("test case passed....Save successful.");
			
		}else	{
			
			captureScreenrobot("coomonDateField");
			Assert.assertTrue(false,"Template Did not Save successful....");		
			
		}
		
		DataTest dt= new DataTest();
		try {
			dt.validateTemplateDateData(fieldType3,cap3,optional3,edate,ldate,tempNumber);
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	@DataProvider(name="TemplateDateFieldPageData")
	public String [][] getDateData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/dash2sell/testData/TemplateDateFieldPageData.xlsx";
	
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);
		
		String templateDateData[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				templateDateData[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);//1 0
			}
				
		}
	return templateDateData;
	}
	
	
	
	@Test(dataProvider="TemplateInstructionFieldPageData")
	public void validateStoreElementInstructionField(String user,String pass,String desc,String fieldType,String cap,String optional,String instr ) throws Exception {
	
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(user);
		TestLogger.log("username :"+user);
		lp.setPassword(pass);
		TestLogger.log("password :"+pass);
		lp.clickSubmit();
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		storeTemp.clickProjectsIcon();
		TestLogger.log("poject icon clicked");
		storeTemp.moveToActivities();
		storeTemp.clickTemplatesMenu();
		TestLogger.log("template menu clicked");
		storeTemp.clickNewTemplateButton();
		storeTemp.clickStoreTemplate();
		TestLogger.log("store template clicked");
		storeTemp.clickElementTemplate();
		TestLogger.log("Element template selected");	
		storeTemp.sendDescription(desc);
		TestLogger.log("description sent");
	}
	
		
	public void commonInstructionField(String fieldType4,String cap4,String optional4) throws Exception {
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		String text=storeTemp.tempText().getText();
		System.out.println(text);
		String tempNumber=(String) text.subSequence(10, 15);
		TestLogger.log("Current Template number :"+tempNumber);
		
		storeTemp.gotoBottomPage();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		storeTemp.clickNewFieldButton();
		TestLogger.log("new field button clicked");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		storeTemp.selectFieldTypeByText(fieldType4);
		TestLogger.log("Instruction field selected");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		List<WebElement> captionList=(List<WebElement>) storeTemp.getMultiCaption();
		Iterator<WebElement> cap=captionList.iterator();
		cap.next();
		cap.next();
		cap.next();
		WebElement caption2=cap.next();
		caption2.sendKeys(cap4);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		TestLogger.log("caption sent for instruction field");
		storeTemp.selectOptional(optional4);
		
		List<WebElement> instboxList=(List<WebElement>) storeTemp.getMultiInstructionBox();
		Iterator<WebElement> instbox=instboxList.iterator();
		instbox.next();
		instbox.next();
		instbox.next();
		WebElement instbox4=instbox.next();
		instbox4.click();
		storeTemp.sendInstruction("Instruction for instruction field type");
		TestLogger.log("instruction provided");
		storeTemp.clickApplyChangesButton();
		TestLogger.log("instruction sent");
		
		storeTemp.clickSave();
		TestLogger.log("Save Button Clicked");
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		boolean b=driver.getPageSource().contains("Save successful.");
		

		if(b==true)
		{
			Assert.assertTrue(true);
			TestLogger.log("test case passed....Template Save successful.");
			
		}else	{
			
			captureScreenrobot("commonInstructionField");
			Assert.assertTrue(false,"Template Did not Save successful....");
		}
		
		DataTest dt= new DataTest();
		try {
			dt.validateInstructionTypeData(fieldType4,cap4,optional4,tempNumber);
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	
	
	@DataProvider(name="TemplateInstructionFieldPageData")
	public String [][] getInstructionData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/dash2sell/testData/TemplateInstructionFieldPageData.xlsx";
	
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);
		
		String templateInstructionData[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				templateInstructionData[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);//1 0
			}
				
		}
	return templateInstructionData;
	}
	
	
	
	@Test(dataProvider="TemplateSignatureFieldPageData")
	public void validateStoreElementSignatureField(String user,String pass,String desc,String fieldType,String cap,String optional,String aApprove,String internal,String loose) throws Exception {
	
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(user);
		TestLogger.log("username :"+user);
		lp.setPassword(pass);
		TestLogger.log("password :"+pass);
		lp.clickSubmit();
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		storeTemp.clickProjectsIcon();
		TestLogger.log("Project Icon Clicked");
		storeTemp.moveToActivities();
		storeTemp.clickTemplatesMenu();
		TestLogger.log("Templates Menu Clicked");
		storeTemp.clickNewTemplateButton();
		storeTemp.clickStoreTemplate();
		storeTemp.clickElementTemplate();
		TestLogger.log("template menu clicked");
		storeTemp.sendDescription(desc);
		TestLogger.log("description sent");
	}
	
	public void commonSignatureField(String fieldType5,String cap5,String optional5,String aApprove,String internal,String loose5 ) throws Exception {
			
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			
		String text=storeTemp.tempText().getText();
		System.out.println(text);
		String tempNumber=(String) text.subSequence(10, 15);
		TestLogger.log("Current Template number :"+tempNumber);
		
		storeTemp.gotoBottomPage();
			
		storeTemp.clickNewFieldButton();
		storeTemp.selectFieldTypeByText(fieldType5);
		TestLogger.log("field type 'SignatureType' selected");
		
		List<WebElement> captionList=(List<WebElement>) storeTemp.getMultiCaption();
		Iterator<WebElement> cap=captionList.iterator();
		cap.next();
		cap.next();
		cap.next();
		cap.next();
		WebElement caption2=cap.next();
		caption2.sendKeys(cap5);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		TestLogger.log("caption sent for instruction field");
		
		storeTemp.selectOptional(optional5);
		TestLogger.log("optional field selected");
		
		storeTemp.gotoBottomPage();
			
		List<WebElement> autoApproveList=(List<WebElement>) storeTemp.getMultiAutoApproveDrop();
		Iterator<WebElement> autoApprove=autoApproveList.iterator();
		autoApprove.next();
		autoApprove.next();
		autoApprove.next();
		autoApprove.next();
		WebElement autoApprove3=autoApprove.next();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		Select select=new Select(autoApprove3);
		select.selectByValue(aApprove);		
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		List<WebElement> internalUseList=(List<WebElement>) storeTemp.getMultiInterUSeDrop();
		Iterator<WebElement> internaluse=internalUseList.iterator();
		internaluse.next();
		internaluse.next();
		internaluse.next();
		internaluse.next();
		WebElement internaluse5=internaluse.next();
			
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		Select selectInternal=new Select(internaluse5);
		selectInternal.selectByValue(internal);
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);	

		List<WebElement>looseList=(List<WebElement>) storeTemp.getMultiLooseAttachment();
		Iterator<WebElement> looseName=looseList.iterator();
		looseName.next();
		looseName.next();
		looseName.next();
		looseName.next();
		WebElement looseName5=looseName.next();
		looseName5.sendKeys(loose5);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		storeTemp.getLoosAttachmentName();
		TestLogger.log("Loose Attachment Name Provided");	
		
		List<WebElement> instboxList=(List<WebElement>) storeTemp.getMultiInstructionBox();
		Iterator<WebElement> instbox=instboxList.iterator();
		instbox.next();
		instbox.next();
		instbox.next();
		instbox.next();
		WebElement instbox5=instbox.next();
		instbox5.click();
		storeTemp.sendInstruction("Instruction for signature field type");
		TestLogger.log("instruction provided");
		storeTemp.clickApplyChangesButton();
		TestLogger.log("instruction sent");
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		storeTemp.clickSave();
		TestLogger.log("Save Button Clicked");
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		boolean b=driver.getPageSource().contains("Save successful.");
		

		if(b==true)
		{
			Assert.assertTrue(true);
			TestLogger.log("test case passed....Save successful.");
			
		}else	{
			
			
			Assert.assertTrue(false);
			captureScreenrobot("validateStoreElementSignatureField");
		}
	
		DataTest dt= new DataTest();
		try {
			dt.validateSignatureTypeData(fieldType5,cap5,optional5,aApprove,internal,loose5,tempNumber);
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	
	@DataProvider(name="TemplateSignatureFieldPageData")
	public String [][] getSignatureData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/dash2sell/testData/TemplateSignatureFieldPageData.xlsx";
	
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);
		
		String templateSignatureData[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				templateSignatureData[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);//1 0
			}
				
		}
	return templateSignatureData;
	}
	
		
	
	
	@Test(dataProvider="TemplateTextFieldPageData")
	public void validateStoreElementTextField(String user,String pass,String desc,String fieldType,String cap,String optional,String maxValue,String loose) throws Exception {
	
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(user);
		TestLogger.log("username :"+user);
		lp.setPassword(pass);
		TestLogger.log("password :"+pass);
		lp.clickSubmit();
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		storeTemp.clickProjectsIcon();
		storeTemp.moveToActivities();
		storeTemp.clickTemplatesMenu();
		TestLogger.log("template menue clicked");
		storeTemp.clickNewTemplateButton();
		storeTemp.clickStoreTemplate();
		TestLogger.log("store template selected");
		storeTemp.clickElementTemplate();
		TestLogger.log("Element template selected");
		storeTemp.sendDescription(desc);
		TestLogger.log("description sent");
	}
	
	public void commonTextField(String fieldType6,String cap6,String optional6,String maxValue6,String loose6) throws Exception {
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		String text=storeTemp.tempText().getText();
		System.out.println(text);
		String tempNumber=(String) text.subSequence(10, 15);
		TestLogger.log("Current Template number :"+tempNumber);
		
		storeTemp.gotoBottomPage();
		
		storeTemp.clickNewFieldButton();
		TestLogger.log("new field button clicked");
		storeTemp.selectFieldTypeByText(fieldType6);
		TestLogger.log("Text field type selected");
		
		List<WebElement> captionList=(List<WebElement>) storeTemp.getMultiCaption();
		Iterator<WebElement> cap=captionList.iterator();
		cap.next();
		cap.next();
		cap.next();
		cap.next();
		cap.next();
		WebElement caption2=cap.next();
		caption2.sendKeys(cap6);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		TestLogger.log("caption sent for Text field");
		
		storeTemp.selectOptional(optional6);
		
		storeTemp.gotoBottomPage();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		List<WebElement> maxvalueList=(List<WebElement>) storeTemp.getMultiMaxValue();
		Iterator<WebElement> maxvalue=maxvalueList.iterator();
		maxvalue.next();
		maxvalue.next();
		maxvalue.next();
		maxvalue.next();
		maxvalue.next();
		WebElement maxvalue6=maxvalue.next();
		maxvalue6.sendKeys(maxValue6);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		TestLogger.log("Max value provided");
		
		List<WebElement>looseList=(List<WebElement>) storeTemp.getMultiLooseAttachment();
		Iterator<WebElement> looseName=looseList.iterator();
		looseName.next();
		looseName.next();
		looseName.next();
		looseName.next();
		looseName.next();
		WebElement looseName5=looseName.next();
		looseName5.sendKeys(loose6);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		storeTemp.getLoosAttachmentName();
		TestLogger.log("Loose Attachment Name Provided");
		
		List<WebElement> instboxList=(List<WebElement>) storeTemp.getMultiInstructionBox();
		Iterator<WebElement> instbox=instboxList.iterator();
		instbox.next();
		instbox.next();
		instbox.next();
		instbox.next();
		instbox.next();
		WebElement instbox6=instbox.next();
		instbox6.click();
		storeTemp.sendInstruction("Instruction for Text field type");
		TestLogger.log("instruction provided");
		storeTemp.clickApplyChangesButton();
		TestLogger.log("instruction sent"); 
				
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		storeTemp.clickSave();
		TestLogger.log("Save Button Clicked");
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		boolean b=driver.getPageSource().contains("Save successful.");
		

		if(b==true)
		{
			Assert.assertTrue(true);
			TestLogger.log("test case passed....Save successful.");
			
		}else	{
			
			captureScreenrobot("commonTextField");
			Assert.assertTrue(false,"Template Did not Save successful....");
		}
		
		DataTest dt= new DataTest();
		try {
			dt.validateTextTypeData(fieldType6,cap6,optional6,maxValue6,loose6,tempNumber);
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	
	
	@DataProvider(name="TemplateTextFieldPageData")
	public String [][] getTextData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/dash2sell/testData/TemplateTextFieldPageData.xlsx";
	
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);
		
		String templateTextData[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				templateTextData[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);//1 0
			}
				
		}
	return templateTextData;
	}
	
	
	@Test(dataProvider="TemplatePictureFieldPageData")
	public void validateStoreElementPictureField(String user,String pass,String desc,String fieldType,String cap,String optional,String loose) throws Exception {
	
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(user);
		TestLogger.log("username :"+user);
		lp.setPassword(pass);
		TestLogger.log("password :"+pass);
		lp.clickSubmit();
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		storeTemp.clickProjectsIcon();
		storeTemp.moveToActivities();
		storeTemp.clickTemplatesMenu();
		storeTemp.clickNewTemplateButton();
		storeTemp.clickStoreTemplate();
		storeTemp.clickElementTemplate();
		TestLogger.log("Element template clicked");	
		storeTemp.sendDescription(desc);
		TestLogger.log("description sent");
	}
	
	
	
	
	public void commonPictureField(String fieldType7,String cap7,String optional7,String loose7) throws Exception {
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		String text=storeTemp.tempText().getText();
		System.out.println(text);
		String tempNumber=(String) text.subSequence(10, 15);
		TestLogger.log("Current Template number :"+tempNumber);
		
		storeTemp.gotoBottomPage();
		
		storeTemp.clickNewFieldButton();
		storeTemp.selectFieldTypeByText(fieldType7);
		TestLogger.log("picture field type selected");
		
		List<WebElement> captionList=(List<WebElement>) storeTemp.getMultiCaption();
		Iterator<WebElement> cap=captionList.iterator();
		cap.next();
		cap.next();
		cap.next();
		cap.next();
		cap.next();
		cap.next();
		WebElement caption2=cap.next();
		caption2.sendKeys(cap7);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		TestLogger.log("caption sent for Text field");
		
		storeTemp.selectOptional(optional7);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		storeTemp.gotoBottomPage();
		
		List<WebElement>looseList=(List<WebElement>) storeTemp.getMultiLooseAttachment();
		Iterator<WebElement> looseName=looseList.iterator();
		looseName.next();
		looseName.next();
		looseName.next();
		looseName.next();
		looseName.next();
		looseName.next();
		WebElement looseName5=looseName.next();
		looseName5.sendKeys(loose7);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		storeTemp.getLoosAttachmentName();
		TestLogger.log("Loose Attachment Name Provided");	
			
		List<WebElement> autoApproveList=(List<WebElement>) storeTemp.getMultiAutoApproveDrop();
		Iterator<WebElement> autoApprove=autoApproveList.iterator();
		autoApprove.next();
		autoApprove.next();
		autoApprove.next();
		autoApprove.next();
		autoApprove.next();
		autoApprove.next();
		WebElement autoApprove3=autoApprove.next();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		Select select=new Select(autoApprove3);
		select.selectByValue("0");		
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		List<WebElement> instboxList=(List<WebElement>) storeTemp.getMultiInstructionBox();
		Iterator<WebElement> instbox=instboxList.iterator();
		instbox.next();
		instbox.next();
		instbox.next();
		instbox.next();
		instbox.next();
		instbox.next();
		WebElement instbox7=instbox.next();
		instbox7.click();
		storeTemp.sendInstruction("Instruction for picture field type");
		TestLogger.log("instruction provided");
		storeTemp.clickApplyChangesButton();
		TestLogger.log("instruction sent"); 
		
		storeTemp.clickSave();
		TestLogger.log("Save Button Clicked");
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		boolean b=driver.getPageSource().contains("Save successful.");
		

		if(b==true)
		{
			Assert.assertTrue(true);
			TestLogger.log("test case passed....Save successful.");
			
		}else	{
			
			captureScreenrobot("commonPictureField");
			Assert.assertTrue(false,"Template Did not Save successful....");
		}
		
		DataTest dt= new DataTest();
		try {
			dt.validatePictureTypeData(fieldType7,cap7,optional7,loose7,tempNumber);
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	
	@DataProvider(name="TemplatePictureFieldPageData")
	public String [][] getPictureData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/dash2sell/testData/TemplatePictureFieldPageData.xlsx";
	
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);
		
		String templatePictureData[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				templatePictureData[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);//1 0
			}
				
		}
	return templatePictureData;
	}
	
	
	
	@Test(dataProvider="TemplateExceptionPageData")
	public void validateStoreElementExceptionField(String user,String pass,String desc,String fieldType,String cap,String optional,String exceptionType) throws Exception {
	
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(user);
		TestLogger.log("username :"+user);
		lp.setPassword(pass);
		TestLogger.log("password :"+pass);
		lp.clickSubmit();
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		storeTemp.clickProjectsIcon();
		TestLogger.log("poject icon clicked");
		storeTemp.moveToActivities();
		storeTemp.clickTemplatesMenu();
		storeTemp.clickNewTemplateButton();
		TestLogger.log("new template button clicked");
		storeTemp.clickStoreTemplate();
		TestLogger.log("Store template clicked");
		storeTemp.clickElementTemplate();
		storeTemp.sendDescription(desc);
		TestLogger.log("description sent");
	}
		
		
	public void commonExceptionField(String fieldType8,String cap8,String optional8,String exceptionType) throws Exception {
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		String text=storeTemp.tempText().getText();
		System.out.println(text);
		String tempNumber=(String) text.subSequence(10, 15);
		TestLogger.log("Current Template number :"+tempNumber);
		
		storeTemp.gotoBottomPage();
		
		storeTemp.clickNewFieldButton();
		storeTemp.selectFieldTypeByText(fieldType8);
		TestLogger.log("Exception field type selected");

		List<WebElement> captionList=(List<WebElement>) storeTemp.getMultiCaption();
		Iterator<WebElement> cap=captionList.iterator();
		cap.next();
		cap.next();
		cap.next();
		cap.next();
		cap.next();
		cap.next();
		cap.next();
		WebElement caption2=cap.next();
		caption2.sendKeys(cap8);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		TestLogger.log("caption sent for Text field");
		
		storeTemp.selectOptional(optional8);
		storeTemp.gotoBottomPage();

		List<WebElement> uploadList=(List<WebElement>) storeTemp.getMultiUploadAttachment();
		Iterator<WebElement> upload=uploadList.iterator();
		upload.next();
		upload.next();
		upload.next();
		upload.next();
		upload.next();
		upload.next();
		upload.next();
		WebElement upload8=upload.next();
		upload8.click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		
		storeTemp.uploadFile(System.getProperty("user.dir")+"\\Attachments\\sidekick"+".pdf");
		String text1="(System.getProperty(\"user.dir\")+\'\\Attachments\\sidekick.pdf')";
		String filename=(String) text1.subSequence(46, 58);
		System.out.println(filename);
		
	/*	
		storeTemp.uploadFile("C:\\Users\\mohammad.parvez\\git\\test-automation\\Attachments\\sidekick.pdf");
		TestLogger.log("file uploaded");
		String text1="C:\\Users\\mohammad.parvez\\git\\test-automation\\Attachments\\sidekick.pdf";
		String filename=(String) text1.subSequence(57, 69);
		System.out.println(filename);
		*/
		
		
		List<WebElement> instboxList=(List<WebElement>) storeTemp.getMultiInstructionBox();
		Iterator<WebElement> instbox=instboxList.iterator();
		instbox.next();
		instbox.next();
		instbox.next();
		instbox.next();
		instbox.next();
		instbox.next();
		instbox.next();
		WebElement instbox8=instbox.next();
		instbox8.click();
		storeTemp.sendInstruction("Instruction for Exception field type");
		TestLogger.log("instruction provided");
		storeTemp.clickApplyChangesButton();
		TestLogger.log("instruction sent"); 
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		List<WebElement> exceptionTypeList=(List<WebElement>) storeTemp.getMultiExceptionType();
		Iterator<WebElement> exception=exceptionTypeList.iterator();
		exception.next();
		exception.next();
		exception.next();
		exception.next();
		exception.next();
		exception.next();
		exception.next();
		WebElement exception8=exception.next();
		
		Select select=new Select(exception8);
		select.selectByValue(exceptionType);
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	
		storeTemp.clickSave();
		TestLogger.log("Save Button Clicked");
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		boolean b=driver.getPageSource().contains("Save successful.");
		

		if(b==true)
		{
			Assert.assertTrue(true);
			TestLogger.log("test case passed....Template Save successful..");
			
		}else	{
			
			captureScreenrobot("commonExceptionField");
			Assert.assertTrue(false,"Template Did not Save successful....");
		}
		
		DataTest dt= new DataTest();
		try {
			dt.validateExceptionTypeData(fieldType8,cap8,optional8,exceptionType,filename,tempNumber);
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	@DataProvider(name="TemplateExceptionPageData")
	public String [][] getExceptionData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/dash2sell/testData/TemplateExceptionPageData.xlsx";
	
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);
		
		String templateExceptionData[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				templateExceptionData[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);//1 0
			}
				
		}
	return templateExceptionData;
	}
	
	
	@Test(dataProvider="TemplateShopcomPageData")
	public void validateStoreElementShopcomField(String user,String pass,String desc,String fieldType,String cap,String optional,String comp,String value) throws Exception {
		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(user);
		TestLogger.log("username :"+user);
		lp.setPassword(pass);
		TestLogger.log("password :"+pass);
		lp.clickSubmit();
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		storeTemp.clickProjectsIcon();
		TestLogger.log("poject icon clicked");
		storeTemp.moveToActivities();
		storeTemp.clickTemplatesMenu();
		TestLogger.log("template menu clicked");
		storeTemp.clickNewTemplateButton();
		storeTemp.clickStoreTemplate();
		storeTemp.clickElementTemplate();
		TestLogger.log("Element template selected");
		storeTemp.sendDescription(desc);
		TestLogger.log("description sent");
	}
		
	public void commonShopcomField(String desc,String fieldType,String cap,String optional,String comp,String value) throws Exception {
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		String text=storeTemp.tempText().getText();
		System.out.println(text);
		String tempNumber=(String) text.subSequence(10, 15);
		TestLogger.log("Current Template number :"+tempNumber);
		
		storeTemp.sendDescription(desc);
		TestLogger.log("Description sent");
		storeTemp.clickNewFieldButton();
		TestLogger.log("New field button clicked");
		storeTemp.selectFieldTypeByText(fieldType);
			
		if (!driver.findElement(By.xpath("//*[text()[contains(.,'Field Availability Criteria (advanced)')]]")).isDisplayed()) {
			 driver.findElement(By.xpath("//*[text()[contains(.,'Toggle Advanced Mode')]]")).click();
			 driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			}
			
		storeTemp.sendCaption(cap);
		TestLogger.log("caption sent");
		storeTemp.selectOptional(optional);
		
		storeTemp.clickAttachment();
		storeTemp.uploadFile(System.getProperty("user.dir")+"\\Attachments\\sidekick"+".pdf");
		TestLogger.log("attachment uploaded");
		storeTemp.clickInstruction();
		storeTemp.sendInstruction("First Instruction for shopcom field type");
		storeTemp.clickApplyChangesButton();	 
		TestLogger.log("instruction provided");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		storeTemp.gotoBottomPage();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		List<WebElement> addButtonList=driver.findElements(By.xpath("//div[text()[contains(.,'Add')]]"));
		Iterator<WebElement> addButton=addButtonList.iterator();
		addButton.next();
		addButton.next();
		addButton.next();
		addButton.next();
		addButton.next();
		WebElement addButton6=addButton.next();
		addButton6.click();
		TestLogger.log("Advance crieteria add button clicked");
		
		List<WebElement> multisource=storeTemp.getMultisource();
		Iterator<WebElement> source=multisource.iterator();
		WebElement source1=source.next();
		source1.click();
		driver.findElement(By.xpath("//*[@class=\"ui-menu ui-widget ui-widget-content ui-autocomplete ui-front\" and starts-with(@id,\"ui-id\")]/li[2]")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		Select select=new Select(driver.findElement(By.xpath("//*[@id=\"criteria_grid_grid_criteria_aawgui_Fields_grid_temporary_0_temporary_0\"]/div[11]/div/select")));
		select.selectByValue(comp);
		TestLogger.log("comparison selected");
		
		storeTemp.clickValue();
		storeTemp.sendValue(value);
		List<WebElement> applychangebuttonlist=storeTemp.getApplyChangesButton();
		Iterator<WebElement> applychange=applychangebuttonlist.iterator();
		applychange.next();	
		TestLogger.log("value provided");

		WebElement applychange2=applychange.next();
		applychange2.click();
		
		storeTemp.clickSave();
		TestLogger.log("Save Button Clicked");
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		boolean b=driver.getPageSource().contains("Save successful.");
		

		if(b==true)
		{
			Assert.assertTrue(true);
			TestLogger.log("test case passed....Save successful.");
			
		}else	{
			
			captureScreenrobot("commonShopcomField");
			Assert.assertTrue(false,"Template Did not Save successful....");
		}
		
		DataTest dt= new DataTest();
		try {
			dt.validateShomcomTypeData(desc,fieldType,cap,optional,comp,value,tempNumber);
			
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	@DataProvider(name="TemplateShopcomPageData")
	public String [][] getShopcomData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/dash2sell/testData/TemplateShopcomPageData.xlsx";
	
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);
		
		String templateShopcomData[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				templateShopcomData[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);//1 0
			}
				
		}
	return templateShopcomData;
	}
		
	
	
	
	@Test(dataProvider="TemplateListFieldPageData")
	public void validateStoreElementListField(String user,String pass,String desc,String fieldType,String cap,String optional,String loose,String resText) throws Exception {
	
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(user);
		TestLogger.log("username :"+user);
		lp.setPassword(pass);
		TestLogger.log("password :"+pass);
		lp.clickSubmit();
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		storeTemp.clickProjectsIcon();
		TestLogger.log("project icon clicked");
		storeTemp.moveToActivities();
		storeTemp.clickTemplatesMenu();
		storeTemp.clickNewTemplateButton();
		storeTemp.clickStoreTemplate();
		TestLogger.log("Store template selected");
		storeTemp.clickElementTemplate();
		TestLogger.log("Element template selected");	
		storeTemp.sendDescription(desc);
		TestLogger.log("description sent");
	}
	
	
public void commonListField(String fieldType2,String cap2,String optional2,String loose2,String resText) throws Exception {
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		String text=storeTemp.tempText().getText();
		System.out.println(text);
		String tempNumber=(String) text.subSequence(10, 15);
		TestLogger.log("Current Template number :"+tempNumber);
		
		storeTemp.gotoBottomPage();
		
		storeTemp.clickNewFieldButton();
		storeTemp.selectFieldTypeByText(fieldType2);
		TestLogger.log("List field selected");
		
		List<WebElement> captionList=(List<WebElement>) storeTemp.getMultiCaption();
		Iterator<WebElement> cap=captionList.iterator();
		cap.next();
		WebElement caption2=cap.next();
		caption2.sendKeys(cap2);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		TestLogger.log("caption sent for list field");
		
		storeTemp.selectOptional(optional2);
		
		storeTemp.gotoBottomPage();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		List<WebElement>looseList=(List<WebElement>) storeTemp.getMultiLooseAttachment();
		Iterator<WebElement> looseName=looseList.iterator();
		looseName.next();
		WebElement looseName2=looseName.next();
		looseName2.sendKeys(loose2);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		storeTemp.getLoosAttachmentName();
		TestLogger.log("Loose Attachment Name Provided");
		
	
		List<WebElement> multipleSelectList=(List<WebElement>) storeTemp.getMultiMultipleSelection();
		Iterator<WebElement> mselection=multipleSelectList.iterator();
		mselection.next();
		WebElement mselection2=mselection.next();
		Select select=new Select(mselection2);
		select.selectByValue("1");
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	
		
		storeTemp.clickAddResponse();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		List<WebElement> responseTextList=(List<WebElement>) storeTemp.getMultiResponseText();
		Iterator<WebElement> restext=responseTextList.iterator();
		restext.next();
		WebElement restext2=restext.next();
		restext2.sendKeys(resText);
	
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		restext2.sendKeys(Keys.DOWN);
		restext2.sendKeys(Keys.RETURN);
		storeTemp.clickDeleteResponse();
		driver.switchTo().alert().accept();
		storeTemp.selectReportResponse("1");		
		
		List<WebElement> instboxList=(List<WebElement>) storeTemp.getMultiInstructionBox();
		Iterator<WebElement> instbox=instboxList.iterator();
		instbox.next();
		WebElement instbox2=instbox.next();
		instbox2.click();
		storeTemp.sendInstruction("First Instruction for List field type");
		TestLogger.log("instruction provided");
		
		storeTemp.clickApplyChangesButton();	 
		storeTemp.clickSave();
		TestLogger.log("Save Button Clicked");
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		boolean b=driver.getPageSource().contains("Save successful.");
		

		if(b==true)
		{
			Assert.assertTrue(true);
			TestLogger.log("test case passed....Save successful.");
			
		}else	{
			
			captureScreenrobot("commonListField");
			Assert.assertTrue(false,"Template Did not Save successful....");
		}
		
		DataTest dt= new DataTest();
		try {
			dt.validateListTypeData(fieldType2,cap2,optional2,loose2,resText,tempNumber);
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	

	@DataProvider(name="TemplateListFieldPageData")
	public String [][] getListData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/dash2sell/testData/TemplateListFieldPageData.xlsx";
	
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);
		
		String templateListData[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				templateListData[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);//1 0
			}
				
		}
	return templateListData;
	}

	@Test(dataProvider="TemplateCurrencyPageData")
	public void validateStoreElementCurrencyField(String user,String pass,String desc,String fieldType,String cap,String optional,String minamount,String maxamount) throws Exception {

		LoginPage lp=new LoginPage(driver);
		lp.setUserName(user);
		TestLogger.log("username :"+user);
		lp.setPassword(pass);
		TestLogger.log("password :"+pass);
		lp.clickSubmit();
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		storeTemp.clickProjectsIcon();
		TestLogger.log("Project icon clicked");
		storeTemp.moveToActivities();
		storeTemp.clickTemplatesMenu();
		storeTemp.clickNewTemplateButton();
		storeTemp.clickStoreTemplate();
		TestLogger.log("Store template clicked");
		storeTemp.clickElementTemplate();
		TestLogger.log("Element template selected");
		storeTemp.sendDescription(desc);
		TestLogger.log("description sent");
	}
	
	public void commonCurrencyField(String fieldType3,String cap3,String optional3,String minamount,String maxamount) throws Exception {
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		String text=storeTemp.tempText().getText();
		System.out.println(text);
		String tempNumber=(String) text.subSequence(10, 15);
		TestLogger.log("Current Template number :"+tempNumber);
		
		storeTemp.gotoBottomPage();
		
		storeTemp.clickNewFieldButton();
		TestLogger.log("new field button clicked");
		storeTemp.selectFieldTypeByText(fieldType3);
		TestLogger.log("currency field type selected");
		
		
		List<WebElement> captionList=(List<WebElement>) storeTemp.getMultiCaption();
		Iterator<WebElement> cap=captionList.iterator();
		cap.next();
		cap.next();
		WebElement caption3=cap.next();
		caption3.sendKeys(cap3);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		TestLogger.log("caption sent for list field");
		
		storeTemp.selectOptional(optional3);
		storeTemp.gotoBottomPage();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		List<WebElement> minamountList=(List<WebElement>) storeTemp.getMultiMinAmount();
		Iterator<WebElement> minAmount=minamountList.iterator();
		minAmount.next();
		minAmount.next();
		WebElement minAmount3=minAmount.next();
		minAmount3.clear();	
		minAmount3.sendKeys(minamount);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		TestLogger.log("minimum amount provided");
		
		
		List<WebElement> maxamountList=(List<WebElement>) storeTemp.getMultiMaxAmount();
		Iterator<WebElement> maxAmount=maxamountList.iterator();
		maxAmount.next();
		maxAmount.next();
		WebElement maxAmount3=maxAmount.next();
		maxAmount3.clear();
		maxAmount3.sendKeys(maxamount);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		TestLogger.log("minimum amount provided");
		
	
		List<WebElement>looseList=(List<WebElement>) storeTemp.getMultiLooseAttachment();
		Iterator<WebElement> looseName=looseList.iterator();
		looseName.next();
		looseName.next();
		WebElement looseName3=looseName.next();
		looseName3.sendKeys("ATT");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		storeTemp.getLoosAttachmentName();
		TestLogger.log("Loose Attachment Name Provided");	
		
		List<WebElement> instboxList=(List<WebElement>) storeTemp.getMultiInstructionBox();
		Iterator<WebElement> instbox=instboxList.iterator();
		instbox.next();
		instbox.next();
		WebElement instbox3=instbox.next();
		instbox3.click();
		storeTemp.sendInstruction("First Instruction for currency field type");
		TestLogger.log("instruction provided");
		storeTemp.clickApplyChangesButton();	 
		storeTemp.clickSave();
		TestLogger.log("Save Button Clicked");
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		boolean b=driver.getPageSource().contains("Save successful.");
		
	
		if(b==true)
		{
			Assert.assertTrue(true);
			TestLogger.log("test case passed....Template Save successful.");
			
		}else	{
			
			captureScreenrobot("commonCurrencyField");
			Assert.assertTrue(false,"Template Did not Save successful....");
		}
		
		DataTest dt= new DataTest();
		try {
			dt.validateCurrencyTypeData(fieldType3,cap3,optional3,minamount,maxamount,tempNumber);
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	@DataProvider(name="TemplateCurrencyPageData")
	public String [][] getCurrencyData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/dash2sell/testData/TemplateCurrencyPageData.xlsx";
	
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);
		
		String templateCurrencyData[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				templateCurrencyData[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);//1 0
			}
				
		}
	return templateCurrencyData;
	}
	
	


	@Test(dataProvider="TemplateHyperlinkPageData")
	public void validateStoreElementHyperlinkField(String user,String pass,String desc,String fieldType,String caption,String optional,String hyperadd) throws Exception {

		LoginPage lp=new LoginPage(driver);
		lp.setUserName(user);
		TestLogger.log("username :"+user);
		lp.setPassword(pass);
		TestLogger.log("password :"+pass);
		lp.clickSubmit();
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		storeTemp.clickProjectsIcon();
		TestLogger.log("project i8con clicked");
		storeTemp.moveToActivities();
		storeTemp.clickTemplatesMenu();
		TestLogger.log("template menu clicked");
		storeTemp.clickNewTemplateButton();
		storeTemp.clickStoreTemplate();
		TestLogger.log("Store template selected");
		storeTemp.clickElementTemplate();
		TestLogger.log("Element template selected");
		storeTemp.sendDescription(desc);
		TestLogger.log("Description provided");
	}

	public void commonHyperLinkField(String fieldType4,String cap4,String optional4,String hyperadd) throws Exception {
	
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		String text=storeTemp.tempText().getText();
		System.out.println(text);
		String tempNumber=(String) text.subSequence(10, 15);
		TestLogger.log("Current Template number :"+tempNumber);
		
		storeTemp.gotoBottomPage();
		storeTemp.clickNewFieldButton();
		TestLogger.log("Newfield button clicked");
		storeTemp.selectFieldTypeByText(fieldType4);
		
	
		List<WebElement> captionList=(List<WebElement>) storeTemp.getMultiCaption();
		Iterator<WebElement> cap=captionList.iterator();
		cap.next();
		cap.next();
		cap.next();
		WebElement caption4=cap.next();
		caption4.sendKeys(cap4);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		TestLogger.log("caption sent for hyperlink field");
		
		storeTemp.selectOptional(optional4);
		storeTemp.gotoBottomPage();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		
		List<WebElement> hyperlinkList=storeTemp.getMultiHyperAddBox();
		Iterator<WebElement> hyper=hyperlinkList.iterator();
		hyper.next();
		hyper.next();
		hyper.next();
		WebElement hyper4=hyper.next();
		hyper4.sendKeys(hyperadd);
		
		List<WebElement> instboxList=(List<WebElement>) storeTemp.getMultiInstructionBox();
		Iterator<WebElement> instbox=instboxList.iterator();
		instbox.next();
		instbox.next();
		instbox.next();
		WebElement instbox4=instbox.next();
		instbox4.click();
		storeTemp.sendInstruction("Instruction for hyperlink field type");
		TestLogger.log("instruction provided");
		storeTemp.clickApplyChangesButton();
		TestLogger.log("instruction sent");
		
		
		storeTemp.clickSave();
		TestLogger.log("Save Button Clicked");
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		boolean b=driver.getPageSource().contains("Save successful.");
		
	
		if(b==true)
		{
			Assert.assertTrue(true);
			TestLogger.log("test case passed....Template Save successful.");
			
		}else	{
			
			captureScreenrobot("commonHyperLinkField");
			Assert.assertTrue(false,"Template Did not Save successful....");
		}
		
		DataTest dt= new DataTest();
		try {
			dt.validateHyperlinkTypeData(fieldType4,cap4,optional4,hyperadd,tempNumber);
			
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	@DataProvider(name="TemplateHyperlinkPageData")
	public String [][] getHyperlinkData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/dash2sell/testData/TemplateHyperlinkPageData.xlsx";
	
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);
		
		String templatehyperlinkData[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				templatehyperlinkData[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);//1 0
			}
				
		}
	return templatehyperlinkData;
	}

	


	@Test(dataProvider="TemplateScanTypeFieldPageData")
	public void validateStoreElementScanTypeField(String user,String pass,String desc,String fieldType,String caption,String optional,String scanType) throws Exception {

		LoginPage lp=new LoginPage(driver);
		lp.setUserName(user);
		TestLogger.log("Usename :"+user);
		lp.setPassword(pass);
		TestLogger.log("Password :"+pass);
		lp.clickSubmit();
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		storeTemp.clickProjectsIcon();
		TestLogger.log("project icon clicked");
		storeTemp.moveToActivities();
		storeTemp.clickTemplatesMenu();
		TestLogger.log("template menu clicked");
		storeTemp.clickNewTemplateButton();
		storeTemp.clickStoreTemplate();
		storeTemp.clickElementTemplate();
		TestLogger.log("Element template selected");	
		storeTemp.sendDescription(desc);
		TestLogger.log("Description sent");
	}
		
		public void commonScanTypeField(String fieldType5,String cap5 ,String optional5,String scanType) throws Exception {
		
	
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		String text=storeTemp.tempText().getText();
		System.out.println(text);
		String tempNumber=(String) text.subSequence(10, 15);
		TestLogger.log("Current Template number :"+tempNumber);
		
		storeTemp.gotoBottomPage();
		storeTemp.clickNewFieldButton();
		TestLogger.log("new filed button clicked");
		storeTemp.selectFieldTypeByText(fieldType5);
		TestLogger.log("Field type selected");
		
		List<WebElement> captionList=(List<WebElement>) storeTemp.getMultiCaption();
		Iterator<WebElement> cap=captionList.iterator();
		cap.next();
		cap.next();
		cap.next();
		cap.next();
		WebElement caption5=cap.next();
		caption5.sendKeys(cap5);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		TestLogger.log("caption sent for scantype field");
		storeTemp.gotoBottomPage();
		
		List<WebElement> scantypeList=(List<WebElement>) storeTemp.getMultiScanType();
		Iterator<WebElement> scantype=scantypeList.iterator();
		scantype.next();
		scantype.next();
		scantype.next();
		scantype.next();
		WebElement scantype5=scantype.next();
		Select select=new Select(scantype5);
		select.selectByValue(scanType);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		TestLogger.log("scan type selecteed");
		storeTemp.gotoBottomPage();
		storeTemp.selectOptional(optional5);
		
		List<WebElement>looseList=(List<WebElement>) storeTemp.getMultiLooseAttachment();
		Iterator<WebElement> looseName=looseList.iterator();
		looseName.next();
		looseName.next();
		looseName.next();
		looseName.next();
		WebElement looseName5=looseName.next();
		looseName5.sendKeys("ATT");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		storeTemp.getLoosAttachmentName();
		TestLogger.log("Loose Attachment Name Provided");	
		
		List<WebElement> instboxList=(List<WebElement>) storeTemp.getMultiInstructionBox();
		Iterator<WebElement> instbox=instboxList.iterator();
		instbox.next();
		instbox.next();
		instbox.next();
		instbox.next();
		WebElement instbox5=instbox.next();
		instbox5.click();
		storeTemp.sendInstruction("Instruction for scantype field type");
		TestLogger.log("instruction provided");
		storeTemp.clickApplyChangesButton();
		TestLogger.log("instruction sent"); 
		
		storeTemp.clickSave();
		TestLogger.log("Save Button Clicked");
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		boolean b=driver.getPageSource().contains("Save successful.");	
	
		if(b==true)
		{
			Assert.assertTrue(true);
			TestLogger.log("test case passed....Template Save successfully");
			
		}else	{
			
			captureScreenrobot("commonScanTypeField");
			Assert.assertTrue(false,"Template Did not Save successful....");
		}
		
		
		DataTest dt= new DataTest();
		try {
			dt.validateTemplateScanTypeData(fieldType5,cap5,optional5,scanType,tempNumber);
			
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@DataProvider(name="TemplateScanTypeFieldPageData")
	String [][] getScanTypeData() throws IOException {
		String path=System.getProperty("user.dir")+"/src/test/java/com/dash2sell/testData/TemplateScanTypeFieldPageData.xlsx";
		
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


	
	@Test(dataProvider="TemplateFeatureLinkPageData")
	public void validateStoreElementFeatureLinkField(String user,String pass,String desc,String fieldType,String cap,String optional,String featurelink) throws Exception {
	
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(user);
		TestLogger.log("username :"+user);
		lp.setPassword(pass);
		TestLogger.log("password :"+pass);
		lp.clickSubmit();
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		storeTemp.clickProjectsIcon();
		TestLogger.log("poject icon clicked");
		storeTemp.moveToActivities();
		storeTemp.clickTemplatesMenu();
		storeTemp.clickNewTemplateButton();
		TestLogger.log("new template button clicked");
		storeTemp.clickStoreTemplate();
		TestLogger.log("store template selected");
		storeTemp.clickElementTemplate();
		storeTemp.sendDescription(desc);
		TestLogger.log("description sent");
	}
	
	public void commonFeatureLinkType(String fieldType6,String cap6,String optional6,String featurelink) throws Exception {
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		String text=storeTemp.tempText().getText();
		System.out.println(text);
		String tempNumber=(String) text.subSequence(10, 15);
		TestLogger.log("Current Template number :"+tempNumber);
		
		storeTemp.gotoBottomPage();
		storeTemp.clickNewFieldButton();
		TestLogger.log("new field button clicked");
		storeTemp.selectFieldTypeByText(fieldType6);
		TestLogger.log("feature link field selected");
		
		List<WebElement> captionList=(List<WebElement>) storeTemp.getMultiCaption();
		Iterator<WebElement> cap=captionList.iterator();
		cap.next();
		cap.next();
		cap.next();
		cap.next();
		cap.next();
		WebElement caption6=cap.next();
		caption6.sendKeys(cap6);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		TestLogger.log("caption sent for featurelink field");
		storeTemp.gotoBottomPage();
		
		storeTemp.selectOptional(optional6);
		
		List<WebElement> featurelinkList=(List<WebElement>) storeTemp.getMultiFeatureLink();
		Iterator<WebElement> feature=featurelinkList.iterator();
		feature.next();
		feature.next();
		feature.next();
		feature.next();
		feature.next();
		WebElement feature6=feature.next();
		Select select=new Select(feature6);
		select.selectByValue(featurelink);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		TestLogger.log("featurelink type selected");
		storeTemp.gotoBottomPage();
		
		storeTemp.clickAttachment();
		storeTemp.uploadFile(System.getProperty("user.dir")+"\\Attachments\\sidekick"+".pdf");;
		TestLogger.log("attacmetn uploaded");
		
		List<WebElement> instboxList=(List<WebElement>) storeTemp.getMultiInstructionBox();
		Iterator<WebElement> instbox=instboxList.iterator();
		instbox.next();
		instbox.next();
		instbox.next();
		instbox.next();
		instbox.next();
		WebElement instbox6=instbox.next();
		instbox6.click();
		storeTemp.sendInstruction("Instruction for featurelink field type");
		TestLogger.log("instruction provided");
		storeTemp.clickApplyChangesButton();
		TestLogger.log("instruction sent"); 
	
		storeTemp.clickSave();
		TestLogger.log("Save Button Clicked");
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		boolean b=driver.getPageSource().contains("Save successful.");
		

		if(b==true)
		{
			Assert.assertTrue(true);
			TestLogger.log("test case passed....Template Save successful.");
			
		}else	{
			
			captureScreenrobot("commonFeatureLinkType");
			Assert.assertTrue(false,"Template Did not Save successful....");
		}
		
		DataTest dt= new DataTest();
		try {
			dt.validateFeatureLinkTypeData(fieldType6,cap6,optional6,featurelink,tempNumber);
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	
	@DataProvider(name="TemplateFeatureLinkPageData")
	public String [][] getFeatureLinkData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/dash2sell/testData/TemplateFeatureLinkPageData.xlsx";
	
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);
		
		String templateFeatureLinkData[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				templateFeatureLinkData[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);//1 0
			}
				
		}
	return templateFeatureLinkData;
	}
	
	
	
	@Test(dataProvider="TemplateSingleScreenWarapperPageData")
	public void validateStoreElementSingleScreenWrapperField(String user,String pass,String desc,String fieldType,String cap,String optional) throws Exception {
	
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(user);
		TestLogger.log("username :"+user);
		lp.setPassword(pass);
		TestLogger.log("password :"+pass);
		lp.clickSubmit();
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		storeTemp.clickProjectsIcon();
		TestLogger.log("poject icon clicked");
		storeTemp.moveToActivities();
		storeTemp.clickTemplatesMenu();
		TestLogger.log("template menu clicked");
		storeTemp.clickNewTemplateButton();
		storeTemp.clickStoreTemplate();
		storeTemp.clickElementTemplate();
		TestLogger.log("element template selected");
		storeTemp.sendDescription(desc);
		TestLogger.log("description sent");
	}
	
	public void commonScreenWrapperField(String fieldType7,String cap7,String optional7) throws Exception {
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		String text=storeTemp.tempText().getText();
		System.out.println(text);
		String tempNumber=(String) text.subSequence(10, 15);
		TestLogger.log("Current Template number :"+tempNumber);
		
		storeTemp.gotoBottomPage();
		storeTemp.clickNewFieldButton();
		TestLogger.log("new field button clicked");
		storeTemp.selectFieldTypeByText(fieldType7);
		TestLogger.log("single screen wrapper field selected");
		storeTemp.selectOptional(optional7);
		
		List<WebElement> captionList=(List<WebElement>) storeTemp.getMultiCaption();
		Iterator<WebElement> cap=captionList.iterator();
		cap.next();
		cap.next();
		cap.next();
		cap.next();
		cap.next();
		cap.next();
		WebElement caption7=cap.next();
		caption7.sendKeys(cap7);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		TestLogger.log("caption sent for ScreenWrapper field");
		storeTemp.gotoBottomPage();
		
		
		
		/*driver.findElement(By.xpath("//div[@colname[contains(.,'addchild')]]")).click();
		
		List<WebElement> captionList=(List<WebElement>) storeTemp.getMultiCaption();
		Iterator<WebElement> cap=captionList.iterator();
		cap.next();
		WebElement caption2=cap.next();
		caption2.sendKeys("This is Second caption");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		
		
		
		List<WebElement> attachList=driver.findElements(By.xpath("//input[@class[contains(.,'aawgui_attachment_filepicker')]]"));
		Iterator<WebElement> attach=attachList.iterator();
		attach.next();
		Thread.sleep(2000);
		WebElement attachList2=attach.next();
		attachList2.click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		storeTemp.uploadFile(System.getProperty("user.dir")+"\\Attachments\\sidekick"+".pdf");
		
		List<WebElement> addButtonResponseList=driver.findElements(By.xpath("//*[starts-with(@id,'grid_responses_aawgui_Fields_grid_temporary_') and text()='Add']"));
		Iterator<WebElement> addButtonResponse=addButtonResponseList.iterator();
		addButtonResponse.next();
		WebElement addButtonResponse2=addButtonResponse.next();
		addButtonResponse2.click();
		storeTemp.sendResponseText("abc");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class=\"ui-menu ui-widget ui-widget-content ui-autocomplete ui-front\" and starts-with(@id,\"ui-id\")]/li[1]/a/b")).click();*/
	
		storeTemp.clickSave();
		TestLogger.log("Save Button Clicked");
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		boolean b=driver.getPageSource().contains("Save successful.");
		
		
		if(b==true)
		{
			Assert.assertTrue(true);
			TestLogger.log("test case passed....Template Save successful.");
			
		}else	{
			
			captureScreenrobot("commonScreenWrapperField");
			Assert.assertTrue(false,"Template Did not Save successful....");
		}
		
		
		DataTest dt= new DataTest();
		try {
			dt.validateSingleWrapperTypeData(fieldType7,cap7,optional7,tempNumber);
			
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	@DataProvider(name="TemplateSingleScreenWarapperPageData")
	public String [][] getSingleWrapperData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/dash2sell/testData/TemplateSingleScreenWarapperPageData.xlsx";
	
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);
		
		String templateSingleWrapperData[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				templateSingleWrapperData[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);//1 0
			}
				
		}
	return templateSingleWrapperData;
	}
	
	

	@Test(dataProvider="TemplateInLineFieldPageData")
	public void validateStoreElementInLineAttachmentField(String user,String pass,String desc,String fieldType,String cap,String optional) throws Exception {
	
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(user);
		TestLogger.log("username :"+user);
		lp.setPassword(pass);
		TestLogger.log("password :"+pass);
		lp.clickSubmit();
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		storeTemp.clickProjectsIcon();
		TestLogger.log("poject icon clicked");
		storeTemp.moveToActivities();
		storeTemp.clickTemplatesMenu();
		TestLogger.log("template menu clicked");
		storeTemp.clickNewTemplateButton();
		storeTemp.clickStoreTemplate();
		TestLogger.log("store template clicked");
		storeTemp.clickElementTemplate();
		TestLogger.log("Element template selected");
		storeTemp.sendDescription(desc);
		TestLogger.log("Description provided");
		
	}
	
	public void commonInLineField(String fieldType8,String cap8,String optional8) throws Exception {
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		String text=storeTemp.tempText().getText();
		System.out.println(text);
		String tempNumber=(String) text.subSequence(10, 15);
		TestLogger.log("Current Template number :"+tempNumber);
		
		storeTemp.gotoBottomPage();
		storeTemp.clickNewFieldButton();
		TestLogger.log("New field button clicked");
		storeTemp.selectFieldTypeByText(fieldType8);
		
		List<WebElement> captionList=(List<WebElement>) storeTemp.getMultiCaption();
		Iterator<WebElement> cap=captionList.iterator();
		cap.next();
		cap.next();
		cap.next();
		cap.next();
		cap.next();
		cap.next();
		cap.next();
		WebElement caption8=cap.next();
		caption8.sendKeys(cap8);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		TestLogger.log("caption sent for inlineattachment field");
		storeTemp.gotoBottomPage();
		storeTemp.selectOptional(optional8);	 
		storeTemp.clickAttachment();
		
		storeTemp.gotoBottomPage();
		
		storeTemp.uploadFile(System.getProperty("user.dir")+"\\Attachments\\sidekick"+".pdf");
		TestLogger.log("Attachment uploaded");
	
		storeTemp.clickSave();
		TestLogger.log("Save Button Clicked");
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		boolean b=driver.getPageSource().contains("Save successful.");
		

		if(b==true)
		{
			Assert.assertTrue(true);
			TestLogger.log("test case passed....Template Save successful.");
			
		}else	{
			
			captureScreenrobot("commonInLineField");
			Assert.assertTrue(false,"Template Did not Save successful....");
		}
		
		DataTest dt= new DataTest();
		try {
			dt.validateInLineAttachmentTypeData(fieldType8,cap8,optional8,tempNumber);
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	
	@DataProvider(name="TemplateInLineFieldPageData")
	public String [][] getInLineAttachmentData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/dash2sell/testData/TemplateInLineFieldPageData.xlsx";
	
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);
		
		String templateInLineData[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				templateInLineData[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);//1 0
			}
				
		}
	return templateInLineData;
	}
	
			
	
}




