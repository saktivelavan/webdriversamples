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
public class AutoCompleteTest {
	
	public String expText = "JavaScript"; 
  @Test
  public void autoComplteTest() throws InterruptedException {
	  
	  WebDriver driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	  driver.manage().window().maximize();
	  Actions actions = new Actions(driver);
	  driver.get("https://jqueryui.com/tooltip/autocomplete/");
	  driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));
	  WebElement txtBox = driver.findElement(By.xpath("(//input[@id='tags'])"));
	  txtBox.sendKeys("as");
	
	  List<WebElement> items = driver.findElements(By.cssSelector("ul#ui-id-1 > li"));
	  System.out.println("Number of matching elements are...: " + items.size());
	  
	  for(WebElement item : items) {
		  
		  System.out.println(item.getText());
		  
		  if(item.getText().equalsIgnoreCase(expText)) {
			  item.click();
			  break;
			  		  }
		  
	  }
  }
}
