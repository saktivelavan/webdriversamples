package testScripts;

import org.testng.annotations.Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebtabletestTest {
  @Test
  public void dynamicWebTable() {
	  WebDriver driver = new ChromeDriver();
      driver.get("https://testautomationpractice.blogspot.com");
      List<WebElement> items = driver.findElements(
    	By.xpath("//td[contains(text(), 'Master In Selenium')]//following-sibling::td"));
      System.out.println("Details of book...:");
      for(WebElement item:items) {
    	  System.out.println(item.getText());
    	       }
      List<WebElement> itemm = driver.findElements(
      By.xpath("//td[contains(text(),'3000')]//preceding-sibling::td[3]"));
      System.out.println("Details of book...:");
      for(WebElement itemm1:items) {
    	  System.out.println(itemm1.getText());
    	       }    
    	
  }
}
