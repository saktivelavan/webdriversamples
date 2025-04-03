package parallelScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SampleOneTest {
	
	WebDriver driver;
  //@Test(groups = "featureOne")
	@Test
  public void testOne() {
	  driver = new ChromeDriver();
	  long id = Thread.currentThread().getId();
	  System.out.println("test11 in SampleOne.."+id);
  }
  
 // @Test(groups = "featureTwo")
	@Test
  public void testTwo() {
		driver = new ChromeDriver();
		  long id = Thread.currentThread().getId();
	  System.out.println("test12 in SampleOne.." +id);
  }
  
  
 // @Test(groups = "featureThree")
	@Test
  public void testThree() {
		driver = new ChromeDriver();
		  long id = Thread.currentThread().getId();
	  System.out.println("test13 in SampleOne.."+id);
  }
  
//  @Test(groups = "featureFour")
	@Test
  public void testFour() {
		driver = new ChromeDriver();
		  long id = Thread.currentThread().getId();
	  System.out.println("test14 in SampleOne.."+id);
  }
}
