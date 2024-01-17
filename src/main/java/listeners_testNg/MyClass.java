package listeners_testNg;

import org.testng.Assert;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(listeners_testNg.Listener1.class)

public class MyClass {
  @Test
  public void tc_1() {
	  Reporter.log("tc 1 is running", false);
  }
  @Test
  public void tc_2() {
	  Reporter.log("tc 2 is running", false);
  }
  @Test(dependsOnMethods = {"tc_2"})
  public void tc_3() {
	  Assert.fail();
	  Reporter.log("tc 3 is running", false);
  }
  @Test
  public void tc_4() {
	  Reporter.log("tc 4 is running", false);
  }

}
