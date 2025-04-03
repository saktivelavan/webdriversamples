package groupScripts;

import org.testng.annotations.Test;

public class SampleThreeTest {
	@Test(groups = "featureOne")
	  public void testOne() {
		  System.out.println("test31 in SampleThree..");
	  }
	  
	  @Test(groups = "featureTwo")
	  public void testTwo() {
		  System.out.println("test32 in SampleThree..");
	  }
	  
	  
	  @Test(groups = "featureThree")
	  public void testThree() {
		  System.out.println("test33 in SampleThree..");
	  }
	  
	  @Test(groups = "featureFour")
	  public void testFour() {
		  System.out.println("test34 in SampleThree..");
	  }
}
