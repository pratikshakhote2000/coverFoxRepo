package listeners_testNg;

import org.testng.Assert;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class MyClass2 {
	@Test
	public void tc_9() {
		Reporter.log("tc 9 is running", false);
	}

	@Test(dependsOnMethods = { "tc_11" })

	public void tc_10() {
		Reporter.log("tc 10 is running", false);
	}

	@Test
	public void tc_11() {
		Assert.fail();
		Reporter.log("tc 11 is running", false);
	}

	@Test
	public void tc_12() {
		Reporter.log("tc 12 is running", false);
	}

}
