package com.escalations.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;

import com.dashManagement.utilities.ReadConfig;

public class LoginEsc {
	@Parameters({"uname","pword"})
	public void loginEsc (String uname, String pword) {
		
		ReadConfig readconfig=new ReadConfig();
		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		
		//driver.manage().window().maximize();
		
		//driver.get("https://qa-5.dash.amerch.com/auth/index/login-ldap");
		
		driver.findElement(By.id("username")).sendKeys(uname);
		driver.findElement(By.id("password")).sendKeys(pword);
		driver.findElement(By.id("submit")).click();
		
	}

}
