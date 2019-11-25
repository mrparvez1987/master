package com.dash2sell.testData;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Parameters;

import com.dashManagement.utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readconfig=new ReadConfig();

	public String baseURL=readconfig.getApplicationURL();
	public String username=readconfig.getUsername();
	public String password=readconfig.getPassword();
	public static WebDriver driver;
	
	public static Logger logger;

	@Parameters("browser")
	@BeforeMethod
	public void setup(String br) {
		
		logger = Logger.getLogger("Retail");
		PropertyConfigurator.configure("Log4j.properties");
		
		
		if(br.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+readconfig.getChromePath());
		driver = new ChromeDriver();
		}
		
		else if(br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+readconfig.getFirefoxPath());
			driver = new FirefoxDriver();
			}
		else if(br.equals("ie")) {
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+readconfig.getIEPath());
			driver = new InternetExplorerDriver();		
		}
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.get(baseURL);
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}
	
	
	
	//BeforeClass-BeforeMethod-Test-AfterMethod-BeforeMethod-Test-AfterMethod-AfterClass
	
	@AfterMethod
	public void teardown() {
		driver.quit();
		
		
	}
	
	

	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	

}
