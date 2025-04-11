package testScripts;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RemoteWebSampleTest {
  WebDriver driver;
	
	@Test
	public void novelSearch() throws MalformedURLException {
		ChromeOptions options = new ChromeOptions();
		options.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
		
		String strHub = " http://10.0.12.22:4444/";
		
		driver = new RemoteWebDriver(new URL(strHub), options);
//		driver = new RemoteWebDriver(new URL(strHub), options);
		driver.get("https://danube-webshop.herokuapp.com/");
	  	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("(//a[contains(text(),'Novels & Stories')])")).click();
		String strUrl1 = driver.getCurrentUrl();
		AssertJUnit.assertTrue(strUrl1.contains("novell"));
}

}