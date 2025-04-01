package testScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class FluentWaitTest {
  @Test
  public void fluentWaitTest() {
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
	  driver.get("http://uitestingplayground.com/ajax/");
	  
	  //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	  
	  driver.findElement(By.id("ajaxButton")).click();
	  
	  
	  Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			  .withTimeout(Duration.ofSeconds(30))
			  .pollingEvery(Duration.ofSeconds(5))
			  .ignoring(NoSuchElementException.class);
	  
	  wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.cssSelector("div#content")),"Data loaded with AJAX get request."));


	  String strText = driver.findElement(By.cssSelector("div#content")).getText();
	  System.out.println(strText);
  }
}
