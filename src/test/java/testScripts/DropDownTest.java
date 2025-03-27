package testScripts;

import org.testng.annotations.Test;

//import com.sun.tools.javac.util.List;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
public class DropDownTest {
  /**
 * @throws InterruptedException
 */
/**
 * @throws InterruptedException
 */
@Test
  public void selectDrpDownTest() throws InterruptedException {
	   WebDriver driver = new ChromeDriver();
	   driver.manage().window().maximize();
	   driver.get("https://testautomationpractice.blogspot.com");
	   
	   Select sel = new Select(driver.findElement(By.id("country")));
	  // sel.selectByIndex(9);
	   sel.selectByValue("uk");
	  // sel.selectByVisibleText("India");
	  
	   Select mulSel = new Select(driver.findElement(By.id("colors")));
	   if(mulSel.isMultiple()) {
		   mulSel.selectByIndex(0);
		   mulSel.selectByValue("green");
		   mulSel.selectByVisibleText("Red");
		   
		   
		   List<WebElement> items = mulSel.getAllSelectedOptions();
		   System.out.println(items.size());
		   mulSel.deselectByValue("green");
	   }
		  
	   
  }
}
