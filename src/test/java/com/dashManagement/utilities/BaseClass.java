package com.dashManagement.utilities;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.ExtentTest;
import com.dashManagement.utilities.ExtentManager;
import com.dashManagement.utilities.ExtentTestManager;
import com.dashManagement.utilities.ReadConfig;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

//BeforeClass-BeforeMethod-Test-AfterMethod-BeforeMethod-Test-AfterMethod-AfterClass

public class BaseClass  {
	
	ReadConfig readconfig=new ReadConfig();

	public String baseURL=readconfig.getApplicationURL();
	public String username=readconfig.getUsername();
	public String password=readconfig.getPassword();
	public static WebDriver driver;
	public static ExtentTest test;
	public static Logger logger;
	
	public static ExtentReports extent;
	 
	 @BeforeSuite
	 public void extentSetup(ITestContext context) {
	        extent = ExtentManager.getInstance();	//initiating extent in @BeforeSuite so it can cover the whole test suite
	    }
	
	@Parameters("browser")
	@BeforeMethod()
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
	
	
	 @BeforeMethod()


	 public void startExtent(Method method, Object[] testData) {	//this will initialize the test name and test class
	        String className = method.getDeclaringClass().getSimpleName();
	        String methodName = method.getName();
	        ExtentTestManager.startTest(methodName);
	        ExtentTestManager.getTest().assignCategory(className);
	    }
	
		 
	 protected String getStackTrace(Throwable t) {	//this is nothing just wanna get the stacktrace for error, you can call directly on your failed testcase
	        StringWriter sw = new StringWriter();
	        PrintWriter pw = new PrintWriter(sw);
	        t.printStackTrace(pw);
	        return sw.toString();
	    }
	 
	
	 private Date getTime(long millis) {	//getting current date and time so extent report will contain time of test
	        Calendar calender = Calendar.getInstance();
	        calender.setTimeInMillis(millis);
	        return calender.getTime();
	    }
	 
	 @AfterMethod
	    public void afterEachTestMethod(ITestResult result) throws IOException {	//this aftermethod will initialized pass and failed test case
	        ExtentTestManager.getTest().setStartedTime(getTime(result.getStartMillis()));
	       
	        for (String group : result.getMethod().getGroups()) {
	            ExtentTestManager.getTest().assignCategory(group);
	        }
	        if (result.getStatus() == ITestResult.SUCCESS) {
	            ExtentTestManager.getTest().log(LogStatus.PASS, "Test Case Passed : "+" - "+result.getName());
	        }
	        else if (result.getStatus() == ITestResult.FAILURE) {
	        	 String screenshotPath=System.getProperty("user.dir")+"/Screenshots/"+result.getName()+".png";
	        	ExtentTestManager.getTest().log(LogStatus.FAIL, "Test Case Failed : "+"Test Name - "+result.getName()+"/ "+"Reason-"+result.getThrowable()+ExtentTestManager.getTest().addScreenCapture(screenshotPath));
	           
	        	 //ExtentTestManager.getTest().log(LogStatus.FAIL,"Test Case Failed "+result.getThrowable());
	            //String screenshotPath=System.getProperty("user.dir")+"/Screenshots/"+result.getName()+".png";
	        	 // ExtentTestManager.getTest().log(LogStatus.FAIL, ExtentTestManager.getTest().addScreenCapture(screenshotPath));

	        	//String screenshotPath=BaseClass.getScreenshot(driver,result.getName());
	        	
	          }
	        else if (result.getStatus() == ITestResult.SKIP) {
	            ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Case Skipped : "+result.getName());
	        }

	        ExtentTestManager.endTest();
	        extent.flush();	    
	        driver.quit();
	    }

	 
	 @AfterSuite
	  public void generateReport() {
	        System.out.println("Report is Generated");
	        extent.close();	//close extent here
	    }
	 
	 
	//Capture ScreenShot with Return File
	public static File captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
		return target;
	}
	
	
	//Capture ScreenShot with Robot class with URl
	public void captureScreenrobot(String tname) throws Exception{
			BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			ImageIO.write(image, "png", new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png")); 
			System.out.println("Screenshot taken");
	}
	
	//Capture ScreenShot with Return String
	public static String getScreenshot(WebDriver driver,String screenshotName) throws IOException {
		String dateName = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination=System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName+".png";
		File finalDestination=new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
		
	}

}
