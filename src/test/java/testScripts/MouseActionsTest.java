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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class MouseActionsTest {
  @Test
  public void mouseActions()  throws InterruptedException {
	  WebDriver driver = new ChromeDriver();
	   driver.manage().window().maximize();
	   Actions actions = new Actions(driver);
	   driver.get("https://testautomationpractice.blogspot.com");
	   Thread.sleep(5000);
	   
	   WebElement txtField = driver.findElement(By.id("field2"));
	   actions.scrollToElement(txtField).perform();
	   
	   WebElement btn = driver.findElement(By.xpath("(//button[contains(text(), 'Point Me')])"));
	   actions.moveToElement(btn).perform();
	   
	   WebElement item2 = driver.findElement(By.linkText("Laptops"));
	   actions.moveToElement(item2).perform();
	   
	   WebElement btnDblClk = driver.findElement(By.xpath("(//button[contains(text(), 'Copy Text')])"));
	   actions.doubleClick(btnDblClk).perform();
	   actions.contextClick(txtField).perform();
	   
	   WebElement draggablItem = driver.findElement(By.xpath("(//div[@id= 'draggable']/p)"));
	   WebElement dropToItem = driver.findElement(By.xpath("(//div[@id= 'droppable'])"));
	   
	   actions.dragAndDrop(draggablItem, dropToItem).perform();
	  
	  
  }
}
