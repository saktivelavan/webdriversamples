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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class AlertsTest {
  @Test
  public void variousAlerts() throws InterruptedException {
	  
	  EdgeDriver driver = new EdgeDriver();
	   driver.manage().window().maximize();
	   Actions actions = new Actions(driver);
	   driver.get("https://testautomationpractice.blogspot.com");
	   Thread.sleep(5000);
	   
	   driver.findElement(By.id("alertBtn")).click();
	   Alert alert = driver.switchTo().alert();
	   System.out.println(alert.getText());
	   SoftAssert softAssert = new SoftAssert();
	   softAssert.assertEquals(alert.getText(), "I am an alert box");
	   alert.accept();
	   
	   driver.findElement(By.id("confirmBtn")).click();
	   Alert confirm = driver.switchTo().alert();
	   System.out.println(confirm.getText());
	//   Assert.assertEquals(alert.getText(), "I am an alert box");
//	   SoftAssert softAssert1 = new SoftAssert();
	   softAssert.assertEquals(confirm.getText(), "Press a buttonk");
	   confirm.dismiss();
	   
	   driver.findElement(By.id("promptBtn")).click();
	   Alert prompt = driver.switchTo().alert();
	   System.out.println(prompt.getText());
	//   Assert.assertEquals(alert.getText(), "I am an alert box");
	   prompt.sendKeys("Sam");
	   prompt.accept();
	   
	   
	   softAssert.assertAll();
	   
	   
  }
}
