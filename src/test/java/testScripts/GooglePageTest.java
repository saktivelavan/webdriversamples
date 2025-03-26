package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

/**
 * 
 */
public class GooglePageTest {
  @Test
  public void seleniumSearch() {
	  
      //ChromeOptions options = new ChromeOptions();
      	//options.setBrowserVersion("120");
	  //WebDriver driver = new ChromeDriver(options);
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
	  driver.get("https://the-internet.herokuapp.com/login");
	  driver.navigate().to("https://the-internet.herokuapp.com/login");
	  
	  WebElement name = driver.findElement(By.id ("username"));
	  name.sendKeys("tomsmith");
	  WebElement pwd = driver.findElement(By.name ("password"));
	  pwd.sendKeys("SuperSecretPassword!");
	  //WebElement btnLogin = driver.findElement(By.tagName("button"));
	  
	  WebElement btnLogin = driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
//      btnLogin.click();
  }
}
