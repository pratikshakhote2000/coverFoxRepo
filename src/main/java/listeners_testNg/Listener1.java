package listeners_testNg;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Listener1 implements ITestListener {
	
	
	@Override
	public void onTestSuccess(ITestResult result) {
		String TC_Name = result.getName();

		Reporter.log("Tc " + TC_Name + " is running SuccessFully", true);
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		String TC_Name = result.getName();
		Reporter.log("Tc " +TC_Name+ "  is skipped,plz check dependant method", true);

	}
	
	
	@Override
	public void onTestStart(ITestResult result) {
		Reporter.log("Tc "+ result.getName() + " execucation is started", true);

	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		Reporter.log("Tc " +result.getName() + " is failed,plz check again ", true);

	}

}
