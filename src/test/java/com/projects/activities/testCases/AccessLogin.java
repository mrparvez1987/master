package com.projects.activities.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import com.dash2sell.pageObjects.LoginPage;



public class AccessLogin extends BaseClass {
	
	
	public void loginAccess() throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("User name is provided");
		lp.setPassword(password);
		logger.info("Passsword is provided");
		lp.clickSubmit();

		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}

}
