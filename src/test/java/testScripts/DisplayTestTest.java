package testScripts;

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


public class DisplayTestTest {
  /**
 * @throws IOException
 * @throws InterruptedException
 */
@Test
  public void displayElementTest() throws IOException, InterruptedException {
   WebDriver driver = new ChromeDriver();
   driver.manage().window().maximize();
   driver.get("https://automationbookstore.dev");
   
   TakesScreenshot screen = (TakesScreenshot)driver;
   File src = screen.getScreenshotAs(OutputType.FILE);
   String path = System.getProperty("user.dir") +
		   "/screenshots/" + System.currentTimeMillis()+ ".png";
   FileUtils.copyFile(src, new File(path));
   
   driver.findElement(By.id("searchBar")).sendKeys("Test");
   Thread.sleep(5000);
   WebElement closeIcon = driver.findElement(
          By.cssSelector("a[title = 'Clear text']"));
   
   File srcImg = closeIcon.getScreenshotAs(OutputType.FILE);
   String path1 = System.getProperty("user.dir") +
		   "/screenshots/" + System.currentTimeMillis()+ ".png";
   FileUtils.copyFile(srcImg, new File(path1));
   
   System.out.println(closeIcon.isDisplayed());
  
   if (closeIcon.isDisplayed()) {
	   closeIcon.click();
   }
  }
  
}
