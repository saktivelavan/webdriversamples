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


public class UploadFileTest {
  @Test
  public void uploadFile() {
	  
	  WebDriver driver = new ChromeDriver();
	  driver.get("https://blueimp.github.io/jQuery-File-Upload/");
	  WebElement addFile = driver.findElement(By.xpath("//input[@type='file']"));
	  String strPath = System.getProperty("user.dir") + "//screenshots//" + "1743068359563.png";
	  addFile.sendKeys(strPath);
	  
	  driver.findElement(By.xpath("(//span[text()='Start upload']")).click();
	  
  }
}
