package parallelScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SampleThreeTest {
	
	WebDriver driver;
  //@Test(groups = "featureOne")
	@Test
  public void testOne() {
//	  driver = new ChromeDriver();
	  long id = Thread.currentThread().getId();
	  System.out.println("test31 in SampleThree.."+id);
  }
  
 // @Test(groups = "featureTwo")
	@Test
  public void testTwo() {
//		driver = new ChromeDriver();
		  long id = Thread.currentThread().getId();
	  System.out.println("test32 in SampleThree.."+id);
  }
  
  
 // @Test(groups = "featureThree")
	@Test
  public void testThree() {
//		driver = new ChromeDriver();
		  long id = Thread.currentThread().getId();
	  System.out.println("test33 in SampleThree.."+id);
  }
  
//  @Test(groups = "featureFour")
	@Test(invocationCount=6, threadPoolSize=3, timeOut=10000)
  public void testFour() {
//		driver = new ChromeDriver();
		  long id = Thread.currentThread().getId();
	  System.out.println("test34 in SampleThree.."+id);
  }
}

