package com.escalations.testCases;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.dash2sell.pageObjects.LoginPage;
import com.escalations.pageObjects.EscalataionListPage;
import com.escalations.pageObjects.EscalationPage;
import com.projects.activities.testCases.BaseClass;

public class TC_EscalationListTest_003 extends BaseClass{
	
	@Test
	public void validateStatusNew() throws InterruptedException, IOException {
		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName("shoresj");
		logger.info("User name is provided");
		lp.setPassword("Anderson2!");
		logger.info("Passsword is provided");
		lp.clickSubmit();
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		EscalationPage escPage=new EscalationPage(driver);
		escPage.clickEscalationIcon();
		
		EscalataionListPage escList=new EscalataionListPage(driver);
		escList.selectStatus("New");
		escList.clickFirstElement();
		escPage.clearDueDate();
		escPage.sendDueDate("2019-12-26");
		Thread.sleep(3000);
		escPage.clickSaveCloseButton();
		logger.info("save button clicked");
		
		String editDate=escList.getText();
	
		if(editDate.equalsIgnoreCase("2019-12-26")) {
			System.out.println("Test Case Passed");
			Assert.assertTrue(true);
		}else {
			System.out.println("Test Case failed");
			captureScreen(driver,"validateStatusNew");
			Assert.assertTrue(false);
			
	}
		
	}
	
	
	@Test
	public void validateStatusCancelled() throws InterruptedException, IOException {
		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName("shoresj");
		logger.info("User name is provided");
		lp.setPassword("Anderson2!");
		logger.info("Passsword is provided");
		lp.clickSubmit();
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		EscalationPage escPage=new EscalationPage(driver);
		escPage.clickEscalationIcon();
		
		EscalataionListPage escList=new EscalataionListPage(driver);
		escList.selectStatus("Cancelled");
		escList.clickFirstElement();
		
		try {
			escPage.sendSummery("abcde");
			}
			catch(Exception e) {
				System.out.println("Something went wrong.");
			}
		
	    String summery =escList.getSummery();
	   	
	    if(summery.contentEquals("abcde")){
	    	Assert.assertFalse(true);
	    	System.out.println("Field is editable");
	    }
	    else{
	    	Assert.assertFalse(false);
	    	captureScreen(driver,"validateStatusCancelled");
	    	System.out.println("Field is non editable" + " " +summery);
	    }
	}
	
	@Test
	public void validateProgramIdList() throws InterruptedException, IOException
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
		
		
		EscalataionListPage escList=new EscalataionListPage(driver);
		escList.clickClear();
		
		
		Integer id = 50;
		String operator = ">";
		
		escList.sendEscId(operator+id);
		logger.info("Escalation Id send");
		
		escList.clickApply();
		logger.info("Click apply");
		
		List<Integer> idList =  escList.getIdList();
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
	public void validateStatusFilter() throws InterruptedException, IOException {
		
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
		
		EscalataionListPage escList=new EscalataionListPage(driver);
		escList.selectStatus("New");
		logger.info("Drowpdown selected");
		
		
		List<WebElement> allOption=escList.getStatus();
		for(int i=0;i<allOption.size();i++) {
			
			if(allOption.get(i).getText().equals("New")) {
				System.out.println("Test Passed");
				Assert.assertTrue(true);
				
			}else {
				
		    	 System.out.println("Test Failed");
		    	 captureScreen(driver,"validateStatusFilter");
		    	 Assert.assertTrue(false);
		     }		
		}
	}
	
	@Test
	public void validateClientFilter() throws InterruptedException, IOException {
		
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
		
		EscalataionListPage escList=new EscalataionListPage(driver);
		escList.selectClient("Chobani");
		logger.info("Drowpdown selected");
		
		
		List<WebElement> allOption=escList.getClient();
		for(int i=0;i<allOption.size();i++) {
			
			if(allOption.get(i).getText().equals("Chobani")) {
				Assert.assertTrue(true);
				
			}else {
				
		    	 System.out.println("Test Failed");
		    	 captureScreen(driver,"validateClientFilter");
		    	 Assert.assertTrue(false);
		      }
		}
		System.out.println("Test Passed");
	}
		
	
	@Test
	public void validateSummeryFilter() throws InterruptedException, IOException {
		
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
		
		EscalataionListPage escList=new EscalataionListPage(driver);
		escList.sendSummary("escalation");
		escList.clickApply();

		
		
		List<WebElement> allOption=escList.getSummary();
		for(int i=0;i<allOption.size();i++) {
			
			if(allOption.get(i).getText().toLowerCase().contains("escalation".toLowerCase())) {
				System.out.println("Test Passed");
				
				Assert.assertTrue(true);
			}else {
				
				System.out.println("Test Failed");
				captureScreen(driver,"validateSummeryFilter");
		    	Assert.assertTrue(false);
		    }
		}
	}
	
	
	@Test
	public void validateDueDateFilter() throws InterruptedException, IOException {
		
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
		
		EscalataionListPage escList=new EscalataionListPage(driver);
		
		escList.clickCalenderDueDate();
		logger.info("Calender opened");
		String startMonthYear="December 2019";
		String startDate="10";
		
		String currentStartMonthYear=escList.getCurrentStartMonthYear();
		System.out.println(currentStartMonthYear);
		if(!currentStartMonthYear.equals(startMonthYear))
		{
		do {
			
			escList.clickStartRightAero();
			
		}while(currentStartMonthYear.trim().equalsIgnoreCase(startMonthYear));
	}
		
		List<WebElement> allDateOfStartMonth= escList.getStartAllDate();
		for(WebElement d:allDateOfStartMonth )
		{
			if(d.getText().trim().equals(startDate))
			{
				d.click();
				System.out.println(d.getText());
				break;
				
			}
		}
		
		String endMonthYear="December 2019";
		String endDate="30";
		String currentEndMonthYear=escList.getCurrentEndMonthYear();
		
		if(!currentEndMonthYear.equals(endMonthYear))
		{
		do {
			
			escList.clickEndRightAero();
			
		}while(currentEndMonthYear.trim().equalsIgnoreCase(endMonthYear));
	}
		
		List<WebElement> allDateOfEndMonth= escList.getEndAllDate();
		for(WebElement d:allDateOfEndMonth )
		{
			if(d.getText().trim().equals(endDate))
			{
				d.click();
				System.out.println(d.getText());
				break;
				
			}
		}

		
		
		escList.clickCalApply();
	
		Thread.sleep(3000);
		List<WebElement> dueDateList = escList.getDueDateList();
	

	    for (int i = 0; i < dueDateList.size(); i++) {
	        String date = dueDateList.get(i).getText();
	        System.out.println("List date: "+date);
	        boolean result = dueDate_comp_Dates(date);

	        if (result) {
	        	Assert.assertTrue(true);
	        	   logger.info("Test Case Passed");
	        	   logger.info("Due Dates are within the range");
	            
	        } else {
	        	captureScreen(driver,"validateDueDateFilter");
	        	Assert.assertTrue(false);
	        	
	        	logger.info("Due Dates are not within the range....Test Case Failed");  	
	        	
	        }
	    }	
		
	}
	
	private static boolean dueDate_comp_Dates(String date) {
	    try {
	    	
	    	
	    	String stringStart = "December 2019, 10";
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM yyyy, dd", Locale.ENGLISH);
			LocalDate sdate = LocalDate.parse(stringStart, formatter);
			System.out.println("Start Date: "+sdate); //2019-12-10
			
			String stringEnd = "December 2019, 30";
			DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("MMMM yyyy, dd", Locale.ENGLISH);
			LocalDate edate = LocalDate.parse(stringEnd, formatter1);
			System.out.println("End Date: "+edate); //2019-12-30
			
	        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");

	        String FromDate =sdate.toString();
	        String ToDate = edate.toString();
	      
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
	public void validatePendingCancellation() throws InterruptedException, IOException {
		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName("shoresj");
		logger.info("User name is provided");
		lp.setPassword("Anderson2!");
		logger.info("Passsword is provided");
		lp.clickSubmit();
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		EscalationPage escPage=new EscalationPage(driver);
		escPage.clickEscalationIcon();
		
		EscalataionListPage escList=new EscalataionListPage(driver);
		
		escList.selectStatus("Pending");
		String ele=escList.getFirstID().getText();
		System.out.println(ele);
		escList.getFirstID().click();
		
		((JavascriptExecutor) driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		logger.info("New tab open");
		
		driver.get("https://qa-4.dash.amerch.com/auth/index/login-ldap");
		driver.manage().deleteAllCookies();
		LoginPage lp1=new LoginPage(driver);
		lp1.setUserName("brownp");
		logger.info("User name is provided");
		lp1.setPassword("Anderson1!");
		logger.info("Passsword is provided");
		lp1.clickSubmit();
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		EscalationPage escPage1=new EscalationPage(driver);
		escPage1.clickEscalationIcon();
		
		EscalataionListPage escList1=new EscalataionListPage(driver);
		
		escList1.selectStatus("Pending");
		String ele1=escList1.getFirstID().getText();
		System.out.println(ele1);
		escList1.getFirstID().click();
		
		driver.switchTo().window(tabs.get(0));
		logger.info("Back to first tab");
		Thread.sleep(3000);
		escList1.clickNoActionButton();
		
		logger.info("no action button clicked");
		escPage1.acceptAlert();
		logger.info("alert clicked");
		driver.switchTo().window(tabs.get(1));
		logger.info("second tab");
		Thread.sleep(3000);
		escList1.clickApproveEscalationButton();
		escPage1.acceptAlert();
		Thread.sleep(3000);
		boolean res=driver.getPageSource().contains("Escalation is not in pending status.");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
			
		}
		else
		{
			logger.info("test case failed....");
			captureScreen(driver,"validatePendingCancellation");
			Assert.assertTrue(false);
		}	
}
	
	
	
}
