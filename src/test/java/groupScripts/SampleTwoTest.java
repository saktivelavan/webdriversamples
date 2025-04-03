package groupScripts;

import org.testng.annotations.Test;

public class SampleTwoTest {
	@Test(groups = "featureOne")
	  public void testOne() {
		  System.out.println("test21 in SampleTwo..");
	  }
	  
	  @Test(groups = "featureTwo")
	  public void testTwo() {
		  System.out.println("test22 in SampleTwo..");
	  }
	  
	  
	  @Test(groups = "featureThree")
	  public void testThree() {
		  System.out.println("test23 in SampleTwo..");
	  }
	  
	  @Test(groups = "featureFour")
	  public void testFour() {
		  System.out.println("test24 in SampleTwo..");
	  }
}
