package com.dash2sell.testCases;

import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.dash2sell.pageObjects.LoginPage;

public class TC_NegetiveLoginTest_006 extends BaseClass {
	
	@Test
	public void negetiveLoginTest() throws IOException, InterruptedException {
		//driver.get(baseURL);
		logger.info("URL is opened");
		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Entered username");
		
		lp.setPassword(password);
		logger.info("Entered password");
		
		lp.clickSubmit();
		logger.info("Submit button clicked");
		
		Thread.sleep(3000);
		
		
		String actualMsg = driver.findElement(By.xpath("//*[@id='loginContainer']/form/div")).getText();
		System.out.println(actualMsg);
		String errorMsg = "Username and/or password is not valid.";
		
		if(actualMsg.contains(errorMsg)) 
		{
			Assert.assertTrue(true);
			logger.info("Login test passed");
		}else
		{
			captureScreen(driver,"negetiveLoginTest");
			Assert.assertTrue(false);
			logger.info("Login test failed");
		};


	}


}
