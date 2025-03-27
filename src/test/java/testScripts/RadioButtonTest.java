package testScripts;

import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;

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
import org.testng.annotations.Test;
public class RadioButtonTest {
  @Test
  public void selectRadioTest() throws InterruptedException {
	   WebDriver driver = new ChromeDriver();
	   driver.manage().window().maximize();
	   driver.get("https://testautomationpractice.blogspot.com");
	   
	   driver.findElement(By.xpath("(//input[@id='male' and @type='radio'])")).click();
	   boolean isSel = driver.findElement(By.xpath("(//input[@id='male' and @type='radio'])")).isSelected();
	   if (isSel) {
		   driver.findElement(By.xpath("(//input[@id='female' and @type='radio'])")).click();
	   }
	   
	   
	   
	   
  }
}
