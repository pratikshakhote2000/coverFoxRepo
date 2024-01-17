package listeners_testNg;

import org.testng.Assert;

import org.testng.Reporter;
import org.testng.annotations.Test;



public class MyClass1 {
	 
	@Test(dependsOnMethods = {"tc_7"})
 public void tc_5() {
	  Reporter.log("tc 5 is running", false);
  }
  @Test
  public void tc_6() {
	  Reporter.log("tc 6 is running", false);
  }
  @Test
  public void tc_7() {
	  Assert.fail();
	  Reporter.log("tc 7 is running", false);
  }
  @Test
  public void tc_8() {
	  Reporter.log("tc 8 is running", false);
  }

}
