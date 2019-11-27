package com.dashManagement.utilities;

import org.testng.Reporter;


import com.relevantcodes.extentreports.LogStatus;

public class TestLogger  {
	
	public static void log(final String message) {
		Reporter.log(message,true);
		ExtentTestManager.getTest().log(LogStatus.PASS, message + "<br>");
		/*if (ExtentTestManager.getTest() != null) {
			ExtentTestManager.getTest().log(LogStatus.INFO, message + "<br>");
			ExtentTestManager.endTest();
			
			
		}*/
	}

}
