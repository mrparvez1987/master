package com.projects.activities.testCases;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.projects.activities.pageObjects.ProjectListPage;
import com.projects.activities.pageObjects.ProjectPriorityPage;

public class TC_ProjectListTest_006 extends BaseClass {
	
	@Test
	public void validateProjectIdList() throws InterruptedException, IOException
	{
		AccessLogin login=new AccessLogin();
		login.loginAccess();
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		ProjectPriorityPage project=new ProjectPriorityPage(driver);
		project.clickProjectsIcon();
		project.moveToActivities();
		project.clickProjPriority();
		
	
		ProjectListPage projectList=new ProjectListPage(driver);
		
	
		projectList.clickClear();
		
		Integer id = 1340;
		String operator = ">";
		
		projectList.sendProjectID(operator+id);
		logger.info("id send");
		
		projectList.clickEnter();
		logger.info("Click apply");
		
		
		List<Integer> idList =  projectList.getIdList();
		boolean isValid = true;
		Iterator<Integer> iterator = idList.iterator();
		while(iterator.hasNext()) {
			Integer currentId = iterator.next();
			if(operator.equalsIgnoreCase(">")) {
				if(currentId <= id) {
					isValid = false;
					break;
				}
				
			}else if(operator.equalsIgnoreCase("<")) {
				if(currentId >= id) {
					isValid = false;
					break;
				}
			}else {
				if(currentId == id) {
					isValid = false;
					break;
				}
			}
		}
		Assert.assertTrue(isValid);
	
		if(isValid) {
			logger.info("all id's are  "+ operator +" "+id);
		}else {
			logger.info("some id's re not " +operator + " " +id);
		}
		
		logger.info("ID List :"+" "+ idList);
		logger.info("Test Case Passed");
			
	}
	
	
	@Test
	public void validateProjectRankList() throws InterruptedException, IOException
	{
		AccessLogin login=new AccessLogin();
		login.loginAccess();
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		ProjectPriorityPage project=new ProjectPriorityPage(driver);
		project.clickProjectsIcon();
		project.moveToActivities();
		project.clickProjPriority();
		
	
		ProjectListPage projectList=new ProjectListPage(driver);
		
	
		projectList.clickClear();
		
		Integer rank = 3;
		String operator = "<";
		
		projectList.sendProjectRank(operator+rank);
		logger.info("rank send");
		
		projectList.clickEnter();
		logger.info("Click apply");
		
		
		
		List<Integer> rankList =  projectList.getRankList();
		boolean isValid = true;
		Iterator<Integer> iterator = rankList.iterator();
		while(iterator.hasNext()) {
			Integer currentRank = iterator.next();
			if(operator.equalsIgnoreCase(">")) {
				if(currentRank <= rank) {
					isValid = false;
					break;
				}
				
				
			}else if(operator.equalsIgnoreCase("<")) {
				if(currentRank >= rank) {
					isValid = false;
					break;
				}
			}else {
				if(currentRank == rank) {
					isValid = false;
					break;
				}
			}
		}
		Assert.assertTrue(isValid);
	
		if(isValid) {
			logger.info("all rank's are  "+ operator +" "+rank);
		}else {
			logger.info("some rank's re not " +operator + " " +rank);
		}
		
		logger.info("Rank List :"+" "+ rankList);
		logger.info("Test Case Passed");
	}

	
	
	@Test
	public void validateProjectCreationDate() throws InterruptedException, IOException
	{
		AccessLogin login=new AccessLogin();
		login.loginAccess();
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		ProjectPriorityPage project=new ProjectPriorityPage(driver);
		project.clickProjectsIcon();
		project.moveToActivities();
		project.clickProjPriority();
		logger.info("project priority clicked");
		
	
		ProjectListPage projectList=new ProjectListPage(driver);
	
		projectList.clickClear();
		logger.info("clear clicked");

		projectList.clickcreationButton();
		logger.info("Creation calender button clicked");
		
		projectList.selectCreationDate("September 2019","September 2019");
		logger.info("Creation date selected");

		projectList.clickApplyButton();
		logger.info("apply clicked");
		Thread.sleep(3000);
		
		List<WebElement> creationDateList = driver.findElements(By.xpath("//*[@id=\"activitytablesprojectpriorityListing_c4\"]/div"));

	    for (int i = 2; i < creationDateList.size(); i++) {
	        String date = creationDateList.get(i).getText();
	        System.out.println(date);
	        boolean result = creation_comp_Dates(date);

	        if (result) {
	        	Assert.assertTrue(true);
	        	logger.info("Creation Dates are within the range");
	            
	        } else {
	        	
	        	Assert.assertTrue(false);
	        	captureScreen(driver,"validateProjectCreationDate");
	        	logger.info("Creation Dates are not within the range....Test Case Failed");  	
	        	
	        }
	    }	
	    logger.info("Test Case Passed");
	}
		
	private static boolean creation_comp_Dates(String date) {
	    try {
	        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");

	        String FromDate = "2019-09-01";
	        String ToDate = "2019-09-20";

	        java.util.Date Fdate = fmt.parse(FromDate);
	        java.util.Date Tdate = fmt.parse(ToDate);
	        java.util.Date ActualDate = fmt.parse(date);

	        if (ActualDate.compareTo(Fdate) >= 0 && ActualDate.compareTo(Tdate) <= 0) {
	            return true;
	        }
	    } catch (Exception ex) {
	        System.out.println(ex);
	    }
	    return false;
	}
	
	@Test
	public void validateProjectEffectiveDate() throws InterruptedException, IOException
	{
		AccessLogin login=new AccessLogin();
		login.loginAccess();
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		ProjectPriorityPage project=new ProjectPriorityPage(driver);
		project.clickProjectsIcon();
		project.moveToActivities();
		project.clickProjPriority();
		logger.info("project priority clicked");
		
	
		ProjectListPage projectlist=new ProjectListPage(driver);
	
		projectlist.clickClear();
		logger.info("clear clicked");

		projectlist.clickEffectiveButton();
		logger.info("calender button clicked");
		
		projectlist.selectEffectiveDate("September 2019","September 2019");
		logger.info("Effective date selected");

		projectlist.clickApplyButton();
		logger.info("apply clicked");
		Thread.sleep(3000);
		
		List<WebElement> EffectiveDateList = driver.findElements(By.xpath("//*[@id=\"activitytablesprojectpriorityListing_c6\"]/div"));


	    for (int i = 2; i < EffectiveDateList.size(); i++) {
	        String date = EffectiveDateList.get(i).getText();
	        System.out.println(date);
	        boolean result = effective_comp_Dates(date);

	        if (result) {
	        	Assert.assertTrue(true);
	        	logger.info("Effective Dates are within the range");
	            
	        }   else {
	        	
	        	Assert.assertTrue(false);
	        	captureScreen(driver,"validateProjectEffectiveDate");
	        	logger.info("Effective Dates are not within the range....Test Case Failed");  	
	        	
	        }
	    }	
	    logger.info("Test Case Passed");
	    
	}
		
	private static boolean effective_comp_Dates(String date) {
	    try {
	        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");

	        String FromDate = "2019-09-10";
	        String ToDate = "2019-09-30";

	        java.util.Date Fdate = fmt.parse(FromDate);
	        java.util.Date Tdate = fmt.parse(ToDate);
	        java.util.Date ActualDate = fmt.parse(date);

	        if (ActualDate.compareTo(Fdate) >= 0 && ActualDate.compareTo(Tdate) <= 0) {
	            return true;
	        }
	    } catch (Exception ex) {
	        System.out.println(ex);
	    }
	    return false;
	}
	
	

	@Test
	public void validateProjectExpireeDate() throws InterruptedException, IOException
	{
		AccessLogin login=new AccessLogin();
		login.loginAccess();
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		ProjectPriorityPage project=new ProjectPriorityPage(driver);
		project.clickProjectsIcon();
		project.moveToActivities();
		project.clickProjPriority();
		logger.info("project priority clicked");
		
	
		ProjectListPage projectlist=new ProjectListPage(driver);
	
		projectlist.clickClear();
		logger.info("clear clicked");

		projectlist.clickProjectExpireButton();
		logger.info("calender button clicked");
		
		projectlist.selectExpireDate("September 2019","October 2019");
		logger.info("Expire date selected");

		projectlist.clickApplyButton();
		logger.info("apply clicked");
		Thread.sleep(2000);
		
		List<WebElement> expireDateList = driver.findElements(By.xpath("//*[@id=\"activitytablesprojectpriorityListing_c7\"]/div"));


	    for (int i = 2; i < expireDateList.size(); i++) {
	        String date = expireDateList.get(i).getText();
	        System.out.println(date);
	        boolean result = expire_comp_Dates(date);

	        if (result) {
	        	Assert.assertTrue(true);
	        	logger.info("Expire Dates are within the range");
	            
	        } else {
	        	
	        	Assert.assertTrue(false);
	        	captureScreen(driver,"validateProjectExpireDate");
	        	logger.info("Expire Dates are not within the range....Test Case Failed");  	
	        	
	        }
	    }	
	    logger.info("Test Case Passed");
	}
		
	private static boolean expire_comp_Dates(String date) {
	    try {
	        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");

	        String FromDate = "2019-09-10";
	        String ToDate = "2019-10-20";

	        java.util.Date Fdate = fmt.parse(FromDate);
	        java.util.Date Tdate = fmt.parse(ToDate);
	        java.util.Date ActualDate = fmt.parse(date);

	        if (ActualDate.compareTo(Fdate) >= 0 && ActualDate.compareTo(Tdate) <= 0) {
	            return true;
	        }
	    } catch (Exception ex) {
	        System.out.println(ex);
	    }
	    return false;
	}
	
	@Test
	public void validateProjectFollowupsList() throws InterruptedException, IOException
	{
		AccessLogin login=new AccessLogin();
		login.loginAccess();
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		ProjectPriorityPage project=new ProjectPriorityPage(driver);
		project.clickProjectsIcon();
		project.moveToActivities();
		project.clickProjPriority();
		
		ProjectListPage projectList=new ProjectListPage(driver);
		projectList.clickClear();
		projectList.selectFollowups("Yes");
		logger.info("Folowups Selected");
		Thread.sleep(2000);
		
		List <WebElement> dropList=driver.findElements(By.xpath("//*[@id=\"activitytablesprojectpriorityListing_c8\"]/div"));
		
		for(int i=2;i<=dropList.size();i++) {
		
			if(dropList.get(i).getText().equals("Yes")) {
				logger.info("Test Case Passed");
				break;
			      }  else  {
			    	  logger.info("Test Case Failed");
			    	  Assert.assertTrue(false);
			    	  }
				}
		}
		
	@Test
	public void validateProjectDescriptionList() throws InterruptedException, IOException
	{
		AccessLogin login=new AccessLogin();
		login.loginAccess();
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		ProjectPriorityPage project=new ProjectPriorityPage(driver);
		
		project.clickProjectsIcon();
		project.moveToActivities();
		project.clickProjPriority();
		project.clickNewProjPriority();
		project.sendProjectId("1500");
		project.clickProjectDesc();
		project.sendProjRank("2");
		project.sendProjEffectiveDate("2019-11-12");
		project.sendProjExpireDate("2019-11-25");
		//program.selectdrProgFollowups("Yes");
		project.clickProjSave();
		logger.info("Project saved");
		
	
		ProjectListPage projectList=new ProjectListPage(driver);
		projectList.sendProjectID("1500");
		projectList.clickApply();
		logger.info("apply clicked");
		
			boolean res=driver.getPageSource().contains("Postpaid Test");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
			
		}
		else
		{
			logger.info("test case failed....");
			captureScreen(driver,"validateProjectDescriptionList");
			Assert.assertTrue(false);
		}
		
	
	}
	
	@Test
	public void validateProjectCreatorList() throws InterruptedException, IOException
	{
		AccessLogin login=new AccessLogin();
		login.loginAccess();
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		ProjectPriorityPage project=new ProjectPriorityPage(driver);
		
		project.clickProjectsIcon();
		project.moveToActivities();
		project.clickProjPriority();
		
		ProjectListPage projectList=new ProjectListPage(driver);
		projectList.sendCreatorName("mckeej");
		projectList.clickApply();
		logger.info("apply clicked");
		
			boolean res=driver.getPageSource().contains("mckeej");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
			
		}
		else
		{
			logger.info("test case failed....");
			captureScreen(driver,"validateProjectCreatorList");
			Assert.assertTrue(false);
		}
		
	
	}
	
	
	@Test
	public void validateProjectCreatorListUser() throws InterruptedException, IOException
	{
		
		
		driver.findElement(By.id("username")).sendKeys("brownp");
		driver.findElement(By.id("password")).sendKeys("Anderson2!");
		driver.findElement(By.id("submit")).click();
		//AccessLogin login=new AccessLogin();
		//login.loginAccess();
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		ProjectPriorityPage project=new ProjectPriorityPage(driver);
		
		project.clickProjectsIcon();
		project.moveToActivities();
		project.clickProjPriority();
		project.clickNewProjPriority();
		project.sendProjectId("1204");
		project.clickProjectDesc();
		project.sendProjRank("1");
		project.sendProjEffectiveDate("2019-11-15");
		project.sendProjExpireDate("2019-11-25");
		project.clickProjSave();
		
		ProjectListPage projectList=new ProjectListPage(driver);
		projectList.sendProjectID("1204");
		projectList.clickApply();
		
		
			boolean res=driver.getPageSource().contains("brownp");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
			
		}
		else
		{
			logger.info("test case failed....");
			captureScreen(driver,"validateProjectCreatorListUser");
			Assert.assertTrue(false);
		}
	}
	
	
	
	@Test
	public void validateExportToDownload() throws InterruptedException, IOException
	{
		AccessLogin login=new AccessLogin();
		login.loginAccess();
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		ProjectPriorityPage project=new ProjectPriorityPage(driver);
		project.clickProjectsIcon();
		project.moveToActivities();
		project.clickProjPriority();
		
		ProjectListPage projectList=new ProjectListPage(driver);
		projectList.clickExportTableLink();
		projectList.selectFileType("Excel 5");
		logger.info("File Type Selected");
		projectList.clickExportTableButton();
		projectList.clickDownloadTableLink();
		logger.info("File Downloded");
		Thread.sleep(3000);
		
		Assert.assertTrue(isFileDownloaded_Ext("C:\\Users\\mohammad.parvez\\Downloads\\", ".xls"));
		
			
			
		
		
		}
	
	
	private boolean isFileDownloaded_Ext(String dirPath, String ext){
		boolean flag=false;
	    File dir = new File(dirPath);
	    File[] files = dir.listFiles();
	    if (files == null || files.length == 0) {
	    	  flag = false;
	       
	    }
	    
	    for (int i = 1; i < files.length; i++) {
	    	if(files[i].getName().contains(ext)) {
	    		flag=true;
	    		 logger.info("Test Pass");
	    	}
	    	
	    	
	    }
	   
	    return flag;
	    
	    
	}

	
	
	@Test
	public void validateExportToFile() throws InterruptedException, IOException
	{
		AccessLogin login=new AccessLogin();
		login.loginAccess();
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		ProjectPriorityPage project=new ProjectPriorityPage(driver);
		project.clickProjectsIcon();
		project.moveToActivities();
		project.clickProjPriority();
		
		ProjectListPage projectList=new ProjectListPage(driver);
		projectList.clickExportTableLink();
		projectList.selectFileType("Excel 5");
		logger.info("File Type Selected");
		projectList.clickExportTableButton();
		
		boolean res=driver.getPageSource().contains("The table has been exported to file.");
		
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
			
		}
		else
		{
			logger.info("test case failed....");
			captureScreen(driver,"validateExportToFile");
			Assert.assertTrue(false);
		}
			
				
	}
	

}
