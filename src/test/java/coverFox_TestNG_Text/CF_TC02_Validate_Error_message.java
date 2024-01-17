package coverFox_TestNG_Text;

import java.io.IOException;

import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import coverFoxPom.AddressDEtails_page4;
import coverFoxPom.CoverFoxHealthPlan_page2;
import coverFoxPom.CoverFox_MemberDetailspage3;
import coverFoxPom.CoverFox_homePage;
import coverFoxPom.Result_page5;
import coverFoxUtility.Utility;
import coverFox_Base.BaseClass;

@Listeners(listeners_testNg.Listener1.class)


public class CF_TC02_Validate_Error_message extends BaseClass {
	CoverFox_homePage home;
	CoverFoxHealthPlan_page2 healthPlan;
	CoverFox_MemberDetailspage3 memberDetails;
	AddressDEtails_page4 addressDetails;
	Result_page5  result;

	@BeforeClass
	public void launchBrowser() throws InterruptedException {
		launchCoverFoxBrowser();
		home = new CoverFox_homePage(driver);
		healthPlan = new CoverFoxHealthPlan_page2(driver);
		memberDetails = new CoverFox_MemberDetailspage3(driver);
		addressDetails = new AddressDEtails_page4(driver);
		result = new Result_page5(driver);

		Reporter.log("opening Browser", true);
		//driver.get("https://www.coverfox.com/");
		driver.manage().window().maximize();
		Utility.ImplicitWait(driver, 5);
	}

	@BeforeMethod
	public void enterMembersDetails() throws InterruptedException, EncryptedDocumentException, IOException {
		Reporter.log("Clicking on gender button", true);
		home.clickOngenderButton();
		Thread.sleep(1000);

		Reporter.log("Clicking on next button", true);
		healthPlan.clickOnNextButton();
		Thread.sleep(1000);

		Reporter.log("Handling age drop down", true);
		memberDetails.dropDownHandle(Utility.readDataFRomExcelSheet(1, 0));
		Reporter.log("Clicking on next button", true);
		memberDetails.clickOnnextButtonPage3();
		Thread.sleep(1000);
//
//		Reporter.log("Entering Pincode", true);
//		addressDetails.enterPinCode(Utility.readDataFRomExcelSheet(1, 1));
		Reporter.log("Entering Mob no", true);
		addressDetails.enterMobNo(Utility.readDataFRomExcelSheet(1, 2));
		Reporter.log("Clicking on continue button", true);
		addressDetails.clickOnContinueButton();
		Thread.sleep(1000);

	}
	@Test
	public void validate_error_message() throws InterruptedException
	{
		Thread.sleep(2000);

		Reporter.log("validating Pincode error message", true);
		boolean status = addressDetails.validateErrorMessageField();
		Assert.assertTrue(status,"pincode is not displayed,TC is failed");
		Reporter.log("Tc will passed", true);



	}

	@AfterMethod
	public void closeCoverFoxBrowser() throws InterruptedException {

		Reporter.log("closing browser", true);
		Thread.sleep(10000);
		closeBrowser();
	}
}
