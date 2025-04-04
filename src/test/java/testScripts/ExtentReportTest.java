package testScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;

import commonUtils.Utility;

public class ExtentReportTest {
	 WebDriver driver;
	  ExtentReports extentReports;
	  ExtentSparkReporter spark;
	  ExtentTest extentTest;
	  
	  @BeforeTest
	  public void setupExtent() {
		  extentReports = new ExtentReports();
		  spark = new ExtentSparkReporter("test-output/SparkReport.html")
				  .viewConfigurer()
				  .viewOrder()
				  .as(new ViewName[] {
						  ViewName.DASHBOARD,
						  ViewName.TEST,
						  ViewName.AUTHOR,
						  ViewName.DEVICE,
						  ViewName.LOG
				  }).apply();
		  extentReports.attachReporter(spark);
	  }
	  
	  @Parameters("browser") 
	  @BeforeMethod
	  public void setup(String strBrowser) {
		  if(strBrowser.equalsIgnoreCase("chrome")) {
			  driver = new ChromeDriver();
		  } 
		  else if(strBrowser.equalsIgnoreCase("edge")) {
			  driver = new EdgeDriver(); 
		  }
		  
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  driver.get("https://danube-webshop.herokuapp.com/");
	  }
	  
		@Test
	  public void crimeNovelSearch() {
			extentTest = extentReports.createTest("Crime & Thrillers Search Test");
			driver.findElement(By.xpath("(//a[contains(text(),'Crime & Thrillers')])")).click();
			String strUrl = driver.getCurrentUrl();
			Assert.assertTrue(strUrl.contains("crime"));
			
	  }
		@Test(retryAnalyzer = RetryAnalyserImpl.class)
		public void novelSearch() {
			extentTest = extentReports.createTest("Novels & Stories Search Test");
			driver.findElement(By.xpath("(//a[contains(text(),'Novels & Stories')])")).click();
			String strUrl1 = driver.getCurrentUrl();
			Assert.assertTrue(strUrl1.contains("novell"));
			
	  }
		
		//@Test(priority=2)
		public void horrorSearch() {
			driver.findElement(By.xpath("(//a[contains(text(),'Horror')])")).click();
			String strUrl1 = driver.getCurrentUrl();
			Assert.assertTrue(strUrl1.contains("horror"));
			
	  }
		//@Test
		public void fantasySearch() {
			driver.findElement(By.xpath("(//a[contains(text(),'Fantasy')])")).click();
			String strUrl1 = driver.getCurrentUrl();
			Assert.assertTrue(strUrl1.contains("fantasy"));
			
	  }
		
	  

	  @AfterMethod
	  public void afterMethod(ITestResult result) {
		  extentTest.assignAuthor("Tester1")
		  .assignCategory("Regression")
		  .assignDevice(System.getProperty("os.name"))
		  .assignDevice(System.getProperty("os.version"));
		  
		  if(ITestResult.FAILURE == result.getStatus()) {
			  extentTest.log(Status.FAIL, result.getThrowable().getMessage());
			  String path = Utility.getScreenshotPath(driver);
			  extentTest.addScreenCaptureFromPath(path);
		  }
		//driver.close();  
	  }
	  
	  @AfterTest
	  public void finishExtent() {
		  extentReports.flush();
	  }
	  
	  

	}
