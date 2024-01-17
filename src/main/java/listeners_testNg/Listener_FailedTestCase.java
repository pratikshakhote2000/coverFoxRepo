package listeners_testNg;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import coverFoxUtility.Utility;
import coverFox_Base.BaseClass;

public class Listener_FailedTestCase extends BaseClass  implements ITestListener{
	
	
	@Override
	public void onTestFailure(ITestResult result) {
		
		Reporter.log("taking Screenshot of fail test case",true);
		try {
			Utility.takesScreenshot(driver,result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		Reporter.log("Tc "+ result.getName() + " execucation is started", true);

	}

}
