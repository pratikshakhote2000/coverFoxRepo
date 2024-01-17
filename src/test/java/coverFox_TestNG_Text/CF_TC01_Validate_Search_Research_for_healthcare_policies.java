package coverFox_TestNG_Text;

import java.io.IOException;
import org.openqa.selenium.WebDriver;

import org.apache.poi.EncryptedDocumentException;
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
public class CF_TC01_Validate_Search_Research_for_healthcare_policies extends BaseClass {
	//public static Logger logger;
	CoverFox_homePage home;
	CoverFoxHealthPlan_page2 healthPlan;
	CoverFox_MemberDetailspage3 memberDetails;
	AddressDEtails_page4 addressDetails;
	Result_page5  result;

	@BeforeClass
	public void launchBrowser() throws InterruptedException {
		//logger=logger.getLogger("CoverFoxInsurance");
		//PropertyConfigurator.configure("log4j.properties");
		//logger.fatal(addressDetails);
		
		
		launchCoverFoxBrowser();
		home = new CoverFox_homePage(driver);
		healthPlan = new CoverFoxHealthPlan_page2(driver);
		memberDetails = new CoverFox_MemberDetailspage3(driver);
		addressDetails = new AddressDEtails_page4(driver);
		result = new Result_page5(driver);

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

		Reporter.log("Entering Pincode", true);
		addressDetails.enterPinCode(Utility.readDataFRomExcelSheet(1, 1));
		Reporter.log("Entering Mob no", true);
		addressDetails.enterMobNo(Utility.readDataFRomExcelSheet(1, 2));
		Reporter.log("Clicking on continue button", true);
		addressDetails.clickOnContinueButton();
		Thread.sleep(1000);

	}

	@Test
	public void validateTestPlansFromTextAndBanners() throws InterruptedException, IOException {

		ChromeOptions opt = new ChromeOptions();
		
		opt.addArguments("--disable notifications");
		
		Thread.sleep(5000);

		Reporter.log("Fetching number of results from text", true);
		int textResult = result.availablePlanNumberFromText();
		Thread.sleep(8000);

		Reporter.log("Fetching number of results from Banners", true);
		int bannerResult = result.availablePlanNumberFromBanner();
		Thread.sleep(5000);

		Assert.assertEquals(textResult, bannerResult, "Text Result are not equal to Banner Result,TC will failed");
		Reporter.log("TC is Passed", true);
		Utility.takesScreenshot(driver, "CF_TC01");

	}

	@AfterMethod
	public void closeCoverFoxBrowser() throws InterruptedException {

		Reporter.log("closing browser", true);
		Thread.sleep(9000);
		closeBrowser();
	}
}
