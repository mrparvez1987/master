package com.dashManagement.utilities;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.relevantcodes.extentreports.ExtentReports;



public class ExtentManager {
	
	private static ExtentReports extent;
	
	
	
	public synchronized static ExtentReports getInstance() {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
		String repName="Test-Report-"+timeStamp+".html";
		
		if (extent==null) {
			try{
				File reportLocation = new File (System.getProperty("user.dir")+ "/test-output/"+repName);
				extent = new ExtentReports(reportLocation.getAbsolutePath(),true);
				System.out.println("Report is started");
				extent.addSystemInfo("Testing Team","QA Team").addSystemInfo("Environment","QA").addSystemInfo("Test Name","Automation");
			}
			catch (Exception e) {
				System.out.println(e.getMessage()+ "\n" +"Exception while generating report");
			}
		}
		return extent;
		}
		
		
	}
	
	


