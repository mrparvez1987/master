package com.dashManagement.utilities;

import java.util.HashMap;
import java.util.Map;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ExtentTestManager {
	public static ExtentHtmlReporter htmlReporter;
	static Map<Integer,ExtentTest> extentTestMap = new HashMap<Integer,ExtentTest>();
	private static ExtentReports extent = ExtentManager.getInstance();
	
	
	public static synchronized ExtentTest getTest() {
		
		return extentTestMap.get((int)(long)(Thread.currentThread().getId()));
	} 
	
	public static synchronized void endTest() {
			extent.endTest(extentTestMap.get((int)(long)(Thread.currentThread().getId())));
    }
	
	public static synchronized ExtentTest startTest (String testName) {
		return startTest(testName,"");
	}
	
	public static synchronized ExtentTest startTestClass (String className,String testName) {
		return startTest(className,testName,"");
	}
	
	public static synchronized ExtentTest startTest (String testName,String desc) {
		ExtentTest test = extent.startTest(testName,desc);
		extentTestMap.put((int)(long)(Thread.currentThread().getId()),test);
		return test;
	}
	
	public static synchronized ExtentTest startTest (String className,String testName,String desc) {
		ExtentTest test = extent.startTest(testName,desc);
		extentTestMap.put((int)(long)(Thread.currentThread().getId()),test);
		return test;
	}
	
}
