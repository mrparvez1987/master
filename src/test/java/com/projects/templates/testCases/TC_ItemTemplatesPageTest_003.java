package com.projects.templates.testCases;

import java.util.concurrent.TimeUnit;

import com.dash2sell.pageObjects.LoginPage;
import com.dashManagement.utilities.BaseClass;
import com.dashManagement.utilities.TestLogger;
import com.projects.templates.pageObject.StoreTemplatesPage;

public class TC_ItemTemplatesPageTest_003 extends BaseClass {
	
	StoreTemplatesPage storeTemp=new StoreTemplatesPage(driver);
	
	public void loginFeature(String user,String pass) {
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
		storeTemp.clickItemTemplate();
		TestLogger.log("Select item template");
		storeTemp.clickElementTemplate();
		TestLogger.log("Select Element Template");
		
		
	}

}
