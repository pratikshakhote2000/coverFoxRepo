package coverFoxPom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressDEtails_page4 {
	
	
	@FindBy(xpath = "(//input[@type='number'])[1]") private WebElement pincode;
	@FindBy(xpath = "(//input[@type='number'])[2]") private WebElement mobNumber;
@FindBy(className = "next-btn") private WebElement continueButton;
@FindBy(xpath = "//div[contains(text(),'valid pincode')]") private WebElement checkErrorMessage;

public AddressDEtails_page4(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}



public void enterPinCode(String pincode1)
{
	pincode.sendKeys(pincode1);

}

public void enterMobNo(String mobileNo)
{
	mobNumber.sendKeys(mobileNo);
}

public void  clickOnContinueButton()
{
	continueButton.click();
	
}

public boolean validateErrorMessageField()
{
	boolean result1 = checkErrorMessage.isDisplayed();
	return result1;
}



}
