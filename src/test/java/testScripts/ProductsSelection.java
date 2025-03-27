package testScripts;

import org.testng.annotations.Test;
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
import org.testng.annotations.Test;
public class ProductsSelection {
	String expectedElemement = "HTC One M9";
  @Test
  public void dynamicElementSelection() throws InterruptedException {
	   WebDriver driver = new ChromeDriver();
	   driver.manage().window().maximize();
	   driver.get("https://demoblaze.com");
	   Thread.sleep(5000);
	   //List<WebElement> items = driver.findElements(By.cssSelector("h4.card-title"));
	   List<WebElement> items = driver.findElements(By.xpath("(//h4[@class='card-title'])"));
	   Thread.sleep(5000);
	   for(WebElement item: items) {
		   System.out.println(item.getText());
		   if(item.getText().equalsIgnoreCase(expectedElemement)) {
			  System.out.println(item.getText());
			   item.click();
			   break;
		   }
	   }
	   
	   
	   
  }
}
