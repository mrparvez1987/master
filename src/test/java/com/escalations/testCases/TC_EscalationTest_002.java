package com.escalations.testCases;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.dash2sell.database.DataTest;
import com.dash2sell.pageObjects.LoginPage;
import com.dashManagement.utilities.XLUtils;
import com.escalations.pageObjects.EscalataionListPage;
import com.escalations.pageObjects.EscalationPage;



public class TC_EscalationTest_002 extends BaseClassOld {
	

	@Test(dataProvider="EscalationPageData")
	public void createNewEscalationReview (String username,String password,String elementId,String sum,String store,String duration) throws InterruptedException, IOException
	{	//BasicConfigurator.configure();
		
		
		
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
		Reporter.log("Search is Successful");
		escPage.clickNewButton();
		logger.info("New button clicked");
		
		escPage.sendElementID(elementId);
		logger.info("Element ID Sent");
		Thread.sleep(5000);
		escPage.clickElementId();
		logger.info("Element Description clicked");
		Thread.sleep(3000);
		escPage.clickClient();
		escPage.selectClient(1);
		logger.info("Client ID selected");
		escPage.sendSummery(sum);
		logger.info("Summary Provided");
		escPage.sendDueDate(escPage.setFutureDate());
		logger.info("Due Date Provided");
		escPage.pressEscape();
		escPage.sendStoreList(store);
		logger.info("Store List selected");
		escPage.sendDescIssue("Description");
		logger.info("Description of Issue Provided");
		escPage.selectResult("Yes");
		logger.info("Result of Anderson Selected");	
		escPage.sendResulation("resulation");
		logger.info("Resulation Steps Provided");
		escPage.selectPlanDuration(duration);
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
			//captureScreenrobot();
			captureScreen(driver,"createNewEscalationReview");
			Assert.assertTrue(false);
		}
		
		
		
		DataTest dt= new DataTest();
		try {
			dt.validateNewEsalationData(elementId, sum, store, duration);
			
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	@DataProvider(name="EscalationPageData")
	String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/dash2sell/testData/EscalationPageNewData.xlsx";
	
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);
		
		String escalationData[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				escalationData[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);//1 0
			}
				
		}
	return escalationData;
	}
	
	
	

	@Test
	public void validateApproveStatus() throws InterruptedException, IOException {
		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName("brownp");
		logger.info("User name is provided");
		lp.setPassword("Anderson1!");
		logger.info("Passsword is provided");
		lp.clickSubmit();
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		EscalationPage escPage=new EscalationPage(driver);
		escPage.clickEscalationIcon();
		
		EscalataionListPage escList=new EscalataionListPage(driver);
		escList.selectStatus("Pending");
		escList.sortEscalationId();
		String eleid=escList.getFirstID().getText();
		System.out.println(eleid);
		escList.clickFirstElement();
		Thread.sleep(3000);
		escList.clickApproveEscalation();
		driver.switchTo().alert().accept();
		String neweleid=escList.getNewId().getText();
		System.out.println(neweleid);
		
		escList.clickHome();
		escPage.clickEscalationIcon();
		escList.selectStatus("Approved");
		escList.sendEscId(eleid);
		escList.clickApply();
		escList.clickFirstElement();
		
		
		String url=driver.getCurrentUrl();
		System.out.println("Current URL: "+url);
		URL nurl = new URL(url);
		String path = nurl.getPath();
		String urlId = path.substring(path.lastIndexOf('/') + 1);
		System.out.println("ID from current url: "+urlId);
		
		/*boolean res=driver.getPageSource().contains("Escalation approved successfully.");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
			
		}
		else
		{
			logger.info("test case failed....");
			captureScreen(driver,"validateStatus");
			Assert.assertTrue(false);
		}
		*/
		
		DataTest dt= new DataTest();
		try {
			dt.validateApproveStatusData(urlId);
			
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
	@Test
	public void validateCancelledtatus() throws InterruptedException, IOException {
		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName("brownp");
		logger.info("User name is provided");
		lp.setPassword("Anderson1!");
		logger.info("Passsword is provided");
		lp.clickSubmit();
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		EscalationPage escPage=new EscalationPage(driver);
		escPage.clickEscalationIcon();
		
		EscalataionListPage escList=new EscalataionListPage(driver);
		escList.selectStatus("New");
		escList.sortEscalationId();
		String eleid=escList.getFirstID().getText();
		System.out.println(eleid);
		escList.clickFirstElement();
		Thread.sleep(3000);
		escList.clickNoActionButton();
		driver.switchTo().alert().accept();
		Thread.sleep(5000);
		
		/*escList.selectStatus("Cancelled");
		escList.sendEscId(eleid);
		escList.clickApply();
		escList.clickFirstElement();
		Thread.sleep(3000);
		
		
		String url=driver.getCurrentUrl();
		System.out.println("Current URL: "+url);
		URL nurl = new URL(url);
		String path = nurl.getPath();
		String urlId = path.substring(path.lastIndexOf('/') + 1);
		System.out.println("ID from current url: "+urlId);
		*/
	
		
		DataTest dt= new DataTest();
		try {
			dt.validateCancelledStatusData(eleid);
			
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
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
		logger.info("N0 Action Button Clicked");
		
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
	
	
	@Test
	public void validateElementDetails() throws InterruptedException, IOException
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
		escPage.sendElementID("117902");
		logger.info("Element ID Sent");
		Thread.sleep(3000);
		escPage.clickElementId();
		logger.info("Element Description clicked");
		Thread.sleep(3000);
		escPage.clickDetailsButton();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		Set <String> ids=driver.getWindowHandles();
		Iterator <String> it = ids.iterator();
		it.next();
		String detailsWindow = it.next();
		driver.switchTo().window(detailsWindow);
		
		System.out.println("After Switching");
		System.out.println(driver.getTitle());
		
		
		String url=driver.getCurrentUrl();
		System.out.println("Current URL: "+url);
		
		URL nurl = new URL(url);
		String path = nurl.getPath();
		String urlId = path.substring(path.lastIndexOf('/') + 1);
		System.out.println("ID from current url: "+urlId);
		

		if(urlId.contentEquals("117902")) {
			Assert.assertTrue(true);
			System.out.println("Details Window open with same Element ID......Test Case Passed");
		}else {
			System.out.println("Details Window open with different Element ID....Test Case Failed");
			captureScreen(driver,"validateElementDetails");
			Assert.assertTrue(false);
			
		}
		
	}
	
	
	@Test
	public void validateElementResponses() throws InterruptedException, IOException
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
		escPage.sendElementID("117902");
		logger.info("Element ID Sent");
		Thread.sleep(3000);
		escPage.clickElementId();
		logger.info("Element Description clicked");
		Thread.sleep(3000);
		escPage.clickResponsesButton();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		Set <String> ids=driver.getWindowHandles();
		Iterator <String> it = ids.iterator();
		it.next();
		String responseWindow = it.next();
		driver.switchTo().window(responseWindow);
		
		System.out.println("After Switching");
		System.out.println(driver.getTitle());
		
		escPage.clickSubmitResponses();
		Thread.sleep(7000);
		
		
		if(isFileDownloaded_Ext("C:\\Users\\mohammad.parvez\\Downloads\\", ".csv")) {
			Assert.assertTrue(true);
			logger.info("File downloaded successfully.....Test Pass");
		}else {
			Assert.assertTrue(false);
			captureScreen(driver,"validateElementResponses");
			logger.info("Test Failed");
		}
		
		File folder = new File("C:\\Users\\mohammad.parvez\\Downloads\\");
        File fList[] = folder.listFiles();

        for (File f : fList) {
            if (f.getName().endsWith(".csv")) {
                f.delete(); 
                System.out.println("Downloaded file deleted from folder successfully");
            }
            
        }
	}
	
	
	private boolean isFileDownloaded_Ext(String dirPath, String ext){
		boolean flag=false;
	    File dir = new File(dirPath);
	    File[] files = dir.listFiles();
	    if (files == null || files.length == 0) {
	    	  flag = false;
	       
	    }
	    
	    for (int i = 1; i < files.length; i++) {
	    	if(files[i].getName().endsWith(ext)) {
	    		flag=true;
	    		
	    	}    	
	    }
	   
	    return flag;       
	}
	
	@Test
	public void validatePictureTab() throws InterruptedException, IOException
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
		escPage.sendElementID("117902");
		logger.info("Element ID Sent");
		Thread.sleep(3000);
		escPage.clickElementId();
		String inputId=escPage.getElementIdName().getText();
		logger.info("Element Description clicked");
		Thread.sleep(3000);
		escPage.clickPicturesButton();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		Set <String> ids=driver.getWindowHandles();
		Iterator <String> it = ids.iterator();
		it.next();
		String pictureWindow = it.next();
		driver.switchTo().window(pictureWindow);
		
		System.out.println("After Switching");
		System.out.println(driver.getTitle());
		
		
		String outputId=escPage.getElementName().getText();
		
		if(inputId.equalsIgnoreCase(outputId)) {
			Assert.assertTrue(true);
			System.out.println("Element name in escalation details match with element name in picture tab.....Test Passed");
		}else{
			System.out.println("Test Failed");
			captureScreen(driver,"validatePictureTab");
			Assert.assertTrue(false);
	
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
			logger.info("Get the error messege....test case passed!!!");
			
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
	public void validateDueDateField() throws Exception
	
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
		Reporter.log("svdfgverwfefef");
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
		
		boolean res=driver.getPageSource().contains("hjkhkjhjkhj");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
			
		}
		else
		{	
		
			logger.info("test case failed....");
			captureScreenrobot("validateDueDateField");
			//captureScreen(driver,"validateDueDateField");
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
