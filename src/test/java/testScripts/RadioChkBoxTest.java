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
public class RadioChkBoxTest {
  @Test
  public void selectRadioTest() throws InterruptedException {
	   WebDriver driver = new ChromeDriver();
	   driver.manage().window().maximize();
	   driver.get("https://the-internet.herokuapp.com/checkboxes");
	   
	   driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
	   boolean isSel = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).isSelected();
	   if (isSel) {
		   driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
	   }
	   
	   
	   
	   
  }
}
