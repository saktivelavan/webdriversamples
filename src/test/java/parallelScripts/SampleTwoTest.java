package parallelScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SampleTwoTest {
	
	WebDriver driver;
  //@Test(groups = "featureOne")
	@Test
  public void testOne() {
	  driver = new ChromeDriver();
	  long id = Thread.currentThread().getId();
	  System.out.println("test21 in SampleTwo.."+id);
  }
  
 // @Test(groups = "featureTwo")
	@Test
  public void testTwo() {
		driver = new ChromeDriver();
		  long id = Thread.currentThread().getId();
	  System.out.println("test22 in SampleTwo.."+id);
  }
  
  
 // @Test(groups = "featureThree")
	@Test
  public void testThree() {
		driver = new ChromeDriver();
		  long id = Thread.currentThread().getId();
	  System.out.println("test23 in SampleTwo.."+id);
  }
  
//  @Test(groups = "featureFour")
	@Test
  public void testFour() {
		driver = new ChromeDriver();
		  long id = Thread.currentThread().getId();
	  System.out.println("test24 in SampleTwo.."+id);
  }
}

