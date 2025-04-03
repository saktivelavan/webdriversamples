package testScripts;

import org.testng.annotations.Test;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

@Test
public class BookSearchText {
  WebDriver driver;
  
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
  
	//@Test
  public void crimeNovelSearch() {
		driver.findElement(By.xpath("(//a[contains(text(),'Crime & Thrillers')])")).click();
		String strUrl = driver.getCurrentUrl();
		Assert.assertTrue(strUrl.contains("crime"));
		
  }
	public void novelSearch() {
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
	
	public void fantasySearch() {
		driver.findElement(By.xpath("(//a[contains(text(),'Fantasy')])")).click();
		String strUrl1 = driver.getCurrentUrl();
		Assert.assertTrue(strUrl1.contains("fantasy"));
		
  }
	
  

  @AfterMethod
  public void afterMethod() {
	driver.close();  
  }

}
