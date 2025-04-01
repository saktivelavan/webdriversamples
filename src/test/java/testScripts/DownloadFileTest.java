package testScripts;


import org.testng.annotations.Test;

//import com.sun.tools.javac.util.List;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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



public class DownloadFileTest {
  @Test
  public void fileDownload() throws InterruptedException {
	  ChromeOptions options  = new ChromeOptions();
	  
	  Map<String, Object> prefs = new HashMap<String, Object>();
	  prefs.put("download.prompt_for_download", false);
	  options.setExperimentalOption("prefs", prefs);
	  
	  WebDriver driver = new ChromeDriver(options);
	  driver.get("https://www.selenium.dev/downloads/");
	  
	  Actions actions = new Actions(driver);
	  Thread.sleep(5000);
	  
	  actions.scrollByAmount(100, 900).perform();
	  
	  driver.findElement(By.xpath("//a[text() = '4.30.0']")).click();
	  
  }
}
