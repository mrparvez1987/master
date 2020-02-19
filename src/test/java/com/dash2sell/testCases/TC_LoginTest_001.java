package com.dash2sell.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dash2sell.pageObjects.LoginPage;
import com.dashManagement.utilities.BaseClass;

public class TC_LoginTest_001 extends BaseClass {
	
	@Test
	public void loginTest() throws IOException {
		//driver.get(baseURL);
		logger.info("URL is opened");
		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Entered username");
		
		lp.setPassword(password);
		logger.info("Entered password");
		
		lp.clickSubmit();
		
		
		
		if(driver.getTitle().equals("Anderson Merchandisers"))
		{
			Assert.assertTrue(true);
			logger.info("Login test passed");

		}
		else
		{
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("Login test failed");

			
		}


		
	}

}
