package testScripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

//import com.sun.tools.javac.util.List;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
public class JavaScriptExecTest {
  @Test
  public void voidTest() {
	  
	  WebDriver driver = new ChromeDriver();
	  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
	  driver.manage().window().maximize();
	  driver.get("https://testautomationpractice.blogspot.com/");
	  JavascriptExecutor js = (JavascriptExecutor)driver;
	  String strTitle = (String) js.executeScript("return document.title");
	  System.out.println(strTitle);
	  WebElement inpName = (WebElement) js.executeScript("return document.getElementById('name')");
	  inpName.sendKeys("Testuser");
	  js.executeScript("window.scrollBy(100,document.body.scrollHeight)");
	  
  }
}
