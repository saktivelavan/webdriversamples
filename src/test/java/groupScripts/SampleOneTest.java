package groupScripts;

import org.testng.annotations.Test;

public class SampleOneTest {
  @Test(groups = "featureOne")
  public void testOne() {
	  System.out.println("test11 in SampleOne..");
  }
  
  @Test(groups = "featureTwo")
  public void testTwo() {
	  System.out.println("test12 in SampleOne..");
  }
  
  
  @Test(groups = "featureThree")
  public void testThree() {
	  System.out.println("test13 in SampleOne..");
  }
  
  @Test(groups = "featureFour")
  public void testFour() {
	  System.out.println("test14 in SampleOne..");
  }
}
