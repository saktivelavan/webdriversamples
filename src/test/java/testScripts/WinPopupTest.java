package testScripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

//import com.sun.tools.javac.util.List;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
public class WinPopupTest {
  @Test
  public void winPop() throws InterruptedException {
	  
	  WebDriver driver = new EdgeDriver();
	  Actions actions = new Actions(driver);
	  driver.manage().window().maximize();
	  driver.get("https://demoqa.com/browser-windows");
	  String parentwin = driver.getWindowHandle();
	  Thread.sleep(5000);
	  actions.scrollByAmount(100, 1200).perform();
	  System.out.println("Parent Win....." + parentwin);
	  
	  driver.findElement(By.id("tabButton")).click();
	  System.out.println("page title....." + driver.getTitle());
	  
	  
	  Set<String> wins = driver.getWindowHandles();
	  System.out.println("No. of windows....  " + wins.size());
	  for(String child : wins) {
		  System.out.println("Window Handles..... " + child);
		  if(!child.equalsIgnoreCase(parentwin)) {
			  driver.switchTo().window(child);
			  Thread.sleep(2000);
			  String hlTagText = driver.findElement(By.cssSelector("h1#sampleHeading")).getText();
			  System.out.println("Text in Tab window... " + hlTagText);
		  }
	  }
	  
	  driver.close();
	  
	  driver.switchTo().window(parentwin);
	  driver.findElement(By.id("windowButton")).click();
	  
	  Set<String> popwins = driver.getWindowHandles();
	  System.out.println("No. of windows....  " + popwins.size());
	  for(String child : popwins) {
		  System.out.println("Window Handles..... " + child);
		  if(!child.equalsIgnoreCase(parentwin)) {
			  driver.switchTo().window(child);
			  Thread.sleep(2000);
			  String hlTagText = driver.findElement(By.cssSelector("h1#sampleHeading")).getText();
			  System.out.println("Text in Tab window... " + hlTagText);
		  }
	  }
	  
	  driver.close();
	  
	  driver.switchTo().window(parentwin);
	  
	  driver.switchTo().newWindow(WindowType.WINDOW);
	  driver.get("https://testautomationpractice.blogspot.com/");
	  driver.quit();
  }
}
