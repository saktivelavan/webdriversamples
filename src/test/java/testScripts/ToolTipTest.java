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
public class ToolTipTest {
  @Test
  public void tooltip() {
	  
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  Actions actions = new Actions(driver);
	  driver.get("https://jqueryui.com/tooltip/");
	  driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));
//	  driver.switchTo().frame(0);
	  driver.findElement(By.id("age")).sendKeys(Keys.ARROW_DOWN);
	  actions.moveToElement(driver.findElement(By.id("age"))).perform();
	  
	  String strTxt = driver.findElement(By.className("ui-tooltip-content")).getText();
	  Assert.assertEquals(strTxt, "We ask for your age only for statistical purposes.");
	  driver.findElement(By.id("age")).sendKeys("20");
	  
	  driver.switchTo().defaultContent();
	  String strHeader = driver.findElement(By.tagName("h1")).getText();
	  System.out.println(strHeader);
	  
  }
}
