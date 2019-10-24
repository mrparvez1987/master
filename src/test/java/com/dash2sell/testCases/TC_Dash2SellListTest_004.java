package com.dash2sell.testCases;

import java.util.Iterator;
import java.util.List;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


import org.testng.Assert;
import org.testng.annotations.Test;


import com.dash2sell.pageObjects.LoginPage;
import com.dash2sell.pageObjects.Dash2SellListPage;

public class TC_Dash2SellListTest_004 extends BaseClass{
	
	@Test
	public void validateIdList() throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("User name is provided");
		lp.setPassword(password);
		logger.info("Passsword is provided");
		lp.clickSubmit();
		
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	
		Dash2SellListPage add=new Dash2SellListPage(driver);
		add.clickDash2Sell();
		add.clickClear();
		Integer id = 1340;
		String operator = "<";
		add.sendID(operator+id);
		logger.info("id send");
		add.clickEnter();
		//add.clickApply();
		logger.info("Click apply");
		
		
		
		List<Integer> idList =  add.getIdList();
		boolean isValid = true;
		Iterator<Integer> iterator = idList.iterator();
		while(iterator.hasNext()) {
			Integer currentId = iterator.next();
			if(operator.equalsIgnoreCase(">")) {
				if(currentId <= id) {
					isValid = false;
					break;
				}
				
				// for date string
				//String currentDate = "";
				//if(currentDate.compareTo("19-08-08") <= 0) {
					
				//}
				
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
		
		logger.info(idList);
		logger.info("ID List show");
		
		
		//"askdjhf".compareToIgnoreCase(currentDate) > 0
		
		
		/*boolean res=driver.getPageSource().contains("<"+id);
		
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
			
		}
		else
		{
			logger.info("test case failed....");
			captureScreen(driver,"validateIdList");
			Assert.assertTrue(false);
		}
		*/
		//add.clickClear();
		//logger.info("clear clicked");
		//add.sendDescription("testing");
		//logger.info("Description send and click enter");
		//add.clickApply();
		//add.getDescriptionList();
		//logger.info("Description list show");
	}
	
	

}
